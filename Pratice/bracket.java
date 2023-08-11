import java.util.HashSet;
import java.util.Set;

public class MyClass {
    
    public static long bracket(String s){
        long r = 0;
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            while (i < j && s.charAt(i) != '(') {
                i++;
            }
            while (i < j && s.charAt(j) != ')') {
                j--;
            }
            if (i < j) {
                r += j - i;
            }
            i++;
            j--;
        }
        
        return r;

    }
    
    public static void main(String args[]) {
        String s = "()()";
        System.out.println(bracket(s));
    }
}