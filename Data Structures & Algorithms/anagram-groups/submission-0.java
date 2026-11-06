class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
           char[] s  = strs[i].toCharArray();
           Arrays.sort(s);
           String sortedStr = new String(s);
           map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(strs[i]);
        }

        for(var e: map.entrySet()){
            res.add(e.getValue());
        }

        return res;
    }
}
