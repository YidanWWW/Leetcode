/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;

class TimeMap {
    HashMap<String, List<Pair<String,Integer>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        int res = search(map.get(key), timestamp);
        if(res==-1) return "";
        return map.get(key).get(res).getKey();
    }
    public int search(List<Pair<String,Integer>> list, int target) {
        
        int left = -1, right = list.size(); //<=target
        while(left+1!=right) {
            int mid = left+(right-left)/2;
            if(list.get(mid).getValue()<=target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

