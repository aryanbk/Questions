class Solution {
    public boolean isPathCrossing(String path) {
        Set<List<Integer>> set = new HashSet<>();
        int x = 0;
        int y = 0;
        List<Integer> l = List.of(x, y);
        set.add(l);
        
        
        for(int i=0; i<path.length(); ++i){
            char ch = path.charAt(i);
            if(ch == 'N')
                --y;
            else if(ch == 'W')
                --x;
            else if(ch == 'S')
                ++y;
            else if(ch == 'E')
                ++x;
            List<Integer> list = List.of(x, y);
            System.out.println(list+" "+set);
            if(set.contains(list))
                return true;
            set.add(list);
            
        }
        return false;
    }
}