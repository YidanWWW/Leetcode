package Pratice.dropbox.database;

import java.util.HashMap;

public class level1 {
    HashMap<String, HashMap<String, Integer>> database;
    public level1() {
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

    public static void main(String[] args) {
        level1 db = new level1();

        System.out.println(db.setOrInc("A", "B", "5")); // Returns "5"
        System.out.println(db.setOrInc("A", "B", "6")); // Returns "11"
        System.out.println(db.get("A", "B")); // Returns "11"
        System.out.println(db.get("A", "C")); // Returns ""
        System.out.println(db.delete("A", "B")); // Returns true
        System.out.println(db.delete("A", "C")); // Returns false
    }

}
