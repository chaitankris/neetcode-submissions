class Solution {
    public boolean isPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<25; i++){
            set.add( (char) (i+'a'));
            set.add((char) (i+'A'));
            if(i<=9){
               set.add((char) (i+'0'));
            }
        }


        int l=0, r= s.length()-1;

        while(l<r){
            while(l<r && !set.contains(s.charAt(l))){
                l++;
            }
            while(l<r &&!set.contains(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)) ){
                return false;
            }
            l++;
            r--;
        }
      
      return true;
    }
}
