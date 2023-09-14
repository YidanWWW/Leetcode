package Pratice.dropbox.database;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//scan
public class scan2 {
    HashMap<String, HashMap<String, Integer>> database;

    public scan2() {
        database = new HashMap<>();
    }

    public String setOrInc(String key, String field, String value) {
        int number = Integer.parseInt(value);
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
            return true;
        }
        return false;
    }

    public String scan(String key, String prefix) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(!database.containsKey(key)) return "";
        
        HashMap<String, Integer> map = database.get(key);
        for(String f:map.keySet()) {
            if(f.startsWith(prefix)) list.add(f);
        }
        
        Collections.sort(list);
        for(String s: list) {
            if(!sb.isEmpty()) sb.append(", ");
            sb.append(s);
            sb.append("(" + database.get(key).get(s)+")");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        scan2 db = new scan2();

        System.out.println(db.setOrInc("A", "BC", "5")); // Returns "5"
        System.out.println(db.setOrInc("A", "BD","6")); 
        System.out.println(db.setOrInc("A", "C","7"));// Returns "11"
        System.out.println(db.scan("A", "B")); // Returns "11"
        System.out.println(db.scan("A", "")); // Returns ""
        System.out.println(db.scan("B", "B")); // Returns true
        //System.out.println(db.delete("A", "C")); // Returns false
    }

}
