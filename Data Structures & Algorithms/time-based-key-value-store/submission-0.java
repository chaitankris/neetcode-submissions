class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> valueMap = map.get(key);

        Map.Entry<Integer, String> entry = valueMap.floorEntry(timestamp);

        // Return empty string if no timestamp <= requested timestamp exists
        return (entry == null) ? "" : entry.getValue();
    }
}
