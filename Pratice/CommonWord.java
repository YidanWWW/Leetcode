class Solution {
    public String mostCommonWord(String s, String[] banned) {
        //hashmap to store string and corresponding frequency
        //set to store banned
        Set<String> set = new HashSet<>();
        for(String str:banned) set.add(str);
        String res = null;int max = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); ) {
            if(!Character.isLetter(s.charAt(i)) && ++i>=0) continue;
            int j=i;
            while(j<s.length() && Character.isLetter(s.charAt(j)) ) j++;
            String sub = s.substring(i, j).toLowerCase();
            i=j+1;
            if(set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0)+1);
            if(map.get(sub)>max) {
                max = map.get(sub);
                res = sub;
            }
    
        }
        return res;
    }
}