class Solution {

    // yt - https://www.youtube.com/watch?v=eGf-26OTI-A
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        // calaculate freq
        for(char c: tasks){
            freq[c-'A']++;
        }
        
        Arrays.sort(freq);
        
        int maxVal = freq[25] - 1;
        int idleSlots  = (maxVal) * n;

        for(int i=24; i>=0; i--){
            // The purpose is that we don't substract more idle spots than we are supposed to. the max_value will contain the number of times the most frequent task needs to be done (since you order the array and then you take the last position) minus 
            //1. We substract one  because for the last task executed, you don't need to wait n intervals of time.
// Now, every other element of the char array is supposed to be less than or equal to the max_value, but because we substracted 1 to it, now we don't know it for sure. So, let's say that after sorting the array, the last two positions hold the same value. The max_value will be then less than the element in freq[24]. So if we substract this value to the idle spots, we will be substracting one idle spot that we didn't take in count in the first place.
            idleSlots -= Math.min(freq[i], maxVal);
        }
        
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;  
    }
}
