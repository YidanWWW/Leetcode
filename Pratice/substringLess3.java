public class MyClass {
    public static void main(String args[]) {
      

      System.out.println(solution("baaaaa"));
      System.out.println(solution("baaabbaabbba"));
      
    }
    
    public static int solution(String s) {
        int res = 0, sSize = s.length();
        for (int i = 0; i < sSize;) {
            int next = i + 1;
            // if we meet sequence of the same letters 
            // scan the string to find length of this sequence 
            while ((next < sSize) && (s.charAt(i) == s.charAt(next))) {
                next++;
            }
            // Here "next - i" is length of the sequence
            // Each third letter should be changed to remove 
            // too long sequences
            res += (next - i) / 3; 
            i = next; // skip processed letters 
        }
        return res;
    }
        
}