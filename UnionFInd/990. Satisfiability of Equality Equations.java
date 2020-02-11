class Solution {
    int[] UF = new int[26];
    public boolean equationsPossible(String[] equations) {
        if(equations.length == 0 || equations == null)return false; // corner case
        for(int i=0 ;i<26 ;i++){
            UF[i] = i; // initialiaze uf array
        }
        for(String str : equations){
            if(str.charAt(1) == '='){ // == case, the same as link between the two 字母
                UF[find(str.charAt(0)-'a')] = find(str.charAt(3)-'a');
            }
        }
        for(String str : equations){
            if( str.charAt(1) == '!'){ // != case, means cut off the link between two 字母
                if ( find(str.charAt(0)-'a') == find( str.charAt(3) -'a')) {
                    // only if the two char has been linked before but it is in != case then we can return false
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int a){ // classic find function
        if( a!= UF[a]) UF[a] = find(UF[a]);
        return UF[a];
    }
}

//uf把==的两个字母连起来。然后去判断！=的情况里，如果两个字母已经是union的了，但是处在！=情况里，则返回false，表明这个方程组无解。