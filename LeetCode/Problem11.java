
public class Problem11 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < height.length; j++){
            for(int k = j + 1; k < height.length; k++){
                int water;
                if(height[j] > height[k]){
                    water = Math.abs(k - j) * height[k];
                }else{
                    water = Math.abs(k - j) * height[j];
                }
                max = Math.max(water, max);
            }
        }
        return max;
    }
}
