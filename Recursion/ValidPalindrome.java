package Recursion;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("radar;..,,"));
    }

    public boolean isPalindrome(String s) {
        String converted = "";
        for(char ch: s.toCharArray()) {
            // Check if the character is alphanum, only then consider else skip
            if(Character.isLetter(ch)) 
                converted += Character.toLowerCase(ch);
            // If its digit, no need to convert to lowercase
            else if(Character.isDigit(ch)) 
                converted += ch;
        }
        return helper(converted);
    }
    
    public boolean helper(String s) {
        if(s.length() <= 1) return true;
        if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        return isPalindrome(s.substring(1, s.length()-1));
    }
}
