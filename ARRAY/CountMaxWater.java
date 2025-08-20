package ARRAY;

public class CountMaxWater {

    public static int maxArea(int[] height) {
        int maxwater = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int ht = Math.min(height[start], height[end]);
            int width = end - start;
            int water = ht * width;
            maxwater = Math.max(water, maxwater);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        // //bruteForce approach
        // for(int i=0;i<height.length;i++){
        // for(int j=i+1;j<height.length;j++){
        // int ht= Math.min(height[i],height[j]);
        // int width=j-i;

        // int water= ht*width;
        // maxwater=Math.max(water,maxwater);
        // }
        // }

        return maxwater;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
    }
}

