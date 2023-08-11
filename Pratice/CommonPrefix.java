public class MyClass {
    
    public static int CommonPrefix(String s){
        int n = s.length();
        if(n==0) return 0;
        int res = 0;
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(chars[i]==chars[0]){
                res += getPrefixLength(chars, i);
            }
        }
        return res;

    }
    
    public static int getPrefixLength(char[] chars, int start) {
        int res = 0, i=0, j=start;
        while(j<chars.length) {
            if(chars[i++] == chars[j++]){
                res++;
            }else {
                break;
            }
        }
        return res;
    }
    public static void main(String args[]) {
 
    String s = "abcabcd";
    System.out.print(CommonPrefix(s));
    }
}