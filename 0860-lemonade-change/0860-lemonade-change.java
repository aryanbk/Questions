class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i=0; i<bills.length; ++i){
            if(bills[i] == 5) ++five;
            else if(bills[i] == 10){
                if(five==0) return false;
                --five;
                ++ten;
            }
            else{
                if(five>0 && ten>0){
                    --five;
                    --ten;
                }
                else if(five>=3) five-=3;
                else return false;
            }
        }
        return true;
    }
}


// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         int[] myBills = new int[3]; // five, ten, twenty
//         for(int i=0; i<bills.length; ++i){
//             if(bills[i] == 5) ++myBills[0];
            
//             else if(bills[i] == 10){
//                 if(myBills[0] == 0) return false;
//                 ++myBills[1];
//                 --myBills[0];
//             }
            
//             else{
//                 ++myBills[2];
//                 if(myBills[0]>0 && myBills[1]>0){
//                     --myBills[0];
//                     --myBills[1];
//                 }
//                 else if(myBills[0]>=3){
//                     myBills[0] -= 3;
//                 }
//                 else return false;
//             }
//         }
        
//         return true;
//     }
// }