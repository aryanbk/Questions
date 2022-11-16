/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int st=1;
        while(st<n){
            int mid=st+(n-st)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid)==1) st=mid+1;
            else n=mid-1;
        }
        return st;
    }
}