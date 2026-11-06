class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i =0; 
        StringBuilder sb = new StringBuilder();

        while(i<str.length()){

            while(i < str.length() && str.charAt(i) != '#' ) {
                sb.append(str.charAt(i));
                i++;
            }
            int strLeng = Integer.parseInt(sb.toString());
            sb.setLength(0);
            i++;

            res.add(str.substring(i, i+strLeng));
            i+=strLeng;
        }

        return res;
    }
}
