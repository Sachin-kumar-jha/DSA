package String;

public class BeautiOfString {
   static public  int  beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Re-initialize frequency for each new starting point
            int[] freq = new int[26];
            
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // Finding the  max and min frequencies more efficiently
                // This still iterates through 26 elements, but avoids     re-calculating everything 
                // as a map
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                
                // Adding the beauty to the total sum, only if there is more     than one character
                if (minFreq != Integer.MAX_VALUE) {
                    totalBeauty += (maxFreq - minFreq);
                }
            }
        }
        return totalBeauty;
    }
 public static void main(String[] args) {
    String str = "aabac";
    System.out.println(beautySum(str));

}
// class Solution {
//     public int beautySum(String s) {
//         int totalBeauty = 0;
//         int n = s.length();

//         for (int i = 0; i < n; i++) {
//             Map<Character, Integer> charFreq = new HashMap<>();
//             // Map to track the count of frequencies: freq -> count
//             Map<Integer, Integer> freqCount = new HashMap<>();
//             int maxFreq = 0;

//             for (int j = i; j < n; j++) {
//                 char ch = s.charAt(j);
                
//                 // Update character frequency
//                 int oldFreq = charFreq.getOrDefault(ch, 0);
//                 int newFreq = oldFreq + 1;
//                 charFreq.put(ch, newFreq);

//                 // Update freqCount map
//                 if (oldFreq > 0) {
//                     freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);
//                     if (freqCount.get(oldFreq) == 0) {
//                         freqCount.remove(oldFreq);
//                     }
//                 }
//                 freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

//                 // Update maxFreq
//                 maxFreq = Math.max(maxFreq, newFreq);
                
//                 // Find minFreq (smallest key in freqCount)
//                 int minFreq = 0;
//                 if (!freqCount.isEmpty()) {
//                     minFreq = Integer.MAX_VALUE;
//                     for (int freq : freqCount.keySet()) {
//                         minFreq = Math.min(minFreq, freq);
//                     }
//                 }

//                 totalBeauty += (maxFreq - minFreq);
//             }
//         }
//         return totalBeauty;
//     }
// }
}
