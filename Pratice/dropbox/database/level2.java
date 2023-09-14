package Pratice.dropbox.database;

import java.util.*;


public class level2 {
    HashMap<String,HashMap<String, Integer> > database;
    HashMap<String, Integer> modification;
    public level2() {
        database = new HashMap<>();
        modification = new HashMap<>();
    }

    public String setOrInc(String key, String field, String value) {
        int number = Integer.parseInt(value);
        modification.put(key, modification.getOrDefault(key, 0)+1);
        database.putIfAbsent(key, new HashMap<>());
        HashMap<String, Integer> map = database.get(key);
        map.put(field, map.getOrDefault(field, 0)+number);
       
        return String.valueOf(map.get(field));
    }

    public String get(String key, String field) {
        if(database.containsKey(key) && database.get(key).containsKey(field)) {
            return String.valueOf(database.get(key).get(field));
        }
        return "";
    }

    public boolean delete(String key, String field) {
        if(database.containsKey(key) && database.get(key).containsKey(field)) {
            database.get(key).remove(field);
            if(database.get(key).isEmpty()) database.remove(key);
            if(database.get(key).isEmpty()) modification.remove(key);
            return true;
        }
        return false;
    }

    public String topNKey(int n) {
        //List<String> list = new ArrayList<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->Integer.compare(modification.get(b), modification.get(a)));
        StringBuilder sb = new StringBuilder();
        for(String s:modification.keySet()) {
            pq.offer(s);
        }
        
        for(int i=0; i<n && i<=pq.size(); i++) {
            if(!sb.isEmpty()) sb.append(", ");
            String s = pq.poll();
            sb.append(s);
            sb.append("(" + modification.get(s) + ")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        level2 db = new level2();
         System.out.println(db.setOrInc("A", "B", "5")); // Returns "5"
        System.out.println(db.setOrInc("A", "B", "6")); 
        System.out.println(db.setOrInc("C", "B", "9"));
        System.out.println(db.topNKey(1)); // Returns "A (2)"
        System.out.println(db.topNKey(2)); // Returns "A (2), B (0)"


        // System.out.println(db.setOrInc("A", "B", "5")); // Returns "5"
        // System.out.println(db.setOrInc("A", "B", "6")); // Returns "11"
        // System.out.println(db.get("A", "B")); // Returns "11"
        // System.out.println(db.get("A", "C")); // Returns ""
        // System.out.println(db.delete("A", "B")); // Returns true
        // System.out.println(db.delete("A", "C")); // Returns false
    }

}
