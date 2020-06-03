
/*
Example 1:
        Input: num1 = "2", num2 = "3"
        Output: "6"

        Example 2:
        Input: num1 = "123", num2 = "456"
        Output: "56088"

 */






class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m+n];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int pos1 = i+j,pos2 = i+j+1;
                int sum = arr[pos2] + mul;
                arr[pos1] += sum / 10;
                arr[pos2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/*
T:O(n^2) S:O(1)

For more explanition please visit www.leeemask.com and search for your problem ~

We simulate the multiply process. Using pos1 and pos2 to store the carry.
For example:
```
        1 2 5
        * 3 2
        ------
          1 0 ( 5*2 ) step 1
        0 4   ( 2*2 ) step 2
      0 2     ( 1*2 ) .... 3
        1 5   ( 3*5 ) .... 4
      0 6   ...
    0 3   ...
    --------------
      4 0 0 0
```
Like above, cause every time we caculate the two number to get mul,
then we have to use the last time's pos1 value, which is the same as current pos2's vlaue.
Then after caculate that we add them together to get the final value string.

 */

