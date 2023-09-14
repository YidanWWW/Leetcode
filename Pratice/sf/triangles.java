package sf;

import java.util.*;

public class triangles {
    public static List<String> triangleType(String[] triagnle) {
        List<String> list = new ArrayList<>();
        for(String s:triagnle) {
            String[] sides = s.split(" ");
            int a = Integer.parseInt(sides[0]);
            int b = Integer.parseInt(sides[1]);
            int c = Integer.parseInt(sides[2]);
            int[] arr = new int[]{a,b,c};
            Arrays.sort(arr);
            if(arr[0]+arr[1]<arr[2]) {
                list.add("None of these");
            }else {
                if(a==b && b==c) {
                    list.add("Equilateral");
                }else if(a==b || a==c || b==c) {
                    list.add("Isosceles");
                }else {
                    list.add("None of these");
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String[] triangleStrings = {"2 2 1", "33 33 33", "3 4 5", "1 1 3"};

        for (String result : triangleType(triangleStrings)) {
            System.out.println(result);
        }

    }
}
