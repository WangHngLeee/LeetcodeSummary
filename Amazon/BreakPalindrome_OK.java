
public class BreakPalindrome_OK {
    public String breakPalindrome(String p) {
        if(p.length() == 1)return "";
        int len = p.length();
        char[] chars = p.toCharArray();
        for(int i=0; i< len / 2; i++){
            if(chars[i] != 'a'){
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[len - 1] = 'b';
        return String.valueOf(chars);
    }
}

// Check half of the string,
// replace a non 'a' character to 'a'.

// If only one character, return empty string.
// Otherwise repalce the last character to 'b'


