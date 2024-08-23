class Solution {
    public String fractionAddition(String exp) {
        // List<String> exp = new ArrayList<>();
        int[] cur = new int[]{0, 1};
        String[] one = exp.split("\\+");
        for(String o: one){
            String[] two = o.split("-");
            // int[] cur = new int[]{0, 1};
            if(two[0]!="") two[0] = "-"+two[0];
            for(String t : two){
                // System.out.println(t);
                if(t=="") continue;
                String[] curNum = t.split("/");
                int nume = Integer.parseInt(curNum[0]);
                int deno = Integer.parseInt(curNum[1]);
                System.out.println("numedeno "+nume+" "+deno);
                cur = add(cur, new int[]{nume*-1, deno});
            }   
            System.out.println(cur[0]+" "+cur[1]);
        }
        if(cur[0]==0) return "0/1";
        cur = reduce(cur);
        return String.valueOf(cur[0])+"/"+String.valueOf(cur[1]);
    }
    
    int[] add(int[] i, int[] j){
        System.out.println("start "+Arrays.toString(i)+" "+Arrays.toString(j));
        // if(i[1]==j[1]) return new int[]{i[0]+j[0], i[0]};
        if(i[1] != j[1]){
            int[] temp = new int[]{j[0], j[1]};
            // int[] temp = Arrays.copyOf(j);
            j[0] *= i[1];
            j[1] = Math.abs(j[1] * i[1]);
            // System.out.println("spe "+i[0]+" "+temp[0]+" "+i[0]*temp[0]);
            i[0] *= temp[1];
            i[1] = j[1];
        }
        // i[0] *= j[1];
        // i[1] = Math.abs(i[1]*j[1]);
        // j[0] *= i[1];
        // j[1] = i[1];
        System.out.println("mid "+Arrays.toString(i)+" "+Arrays.toString(j));
        int[] ans =  new int[]{i[0]+j[0], i[1]};
        System.out.println("end "+Arrays.toString(ans));
        return ans;
    }
    
    int[] reduce(int[] cur){
        for(int i=2; i<=Math.min(Math.abs(cur[0]), cur[1]); ++i){
            while(cur[0]%i==0 && cur[1]%i==0){
                cur[0] /= i;
                cur[1] /= i;
            }
        }
        return cur;
    }
    
    
}