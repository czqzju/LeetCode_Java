package leetcode;

import java.util.HashMap;

public class CropRatio {
    private int totalWeight = 0;
    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

    public void add(String name, int cropWeight) {
    	Integer currentCropWeight = 0;
    	
    	if (crops.containsKey(name)) {
			currentCropWeight = crops.get(name);
		}
        

    	if (cropWeight > 0) {
    		crops.put(name, currentCropWeight + cropWeight);
		}
        
        totalWeight += cropWeight;
    }

    public double proportion(String name) {
    	if (totalWeight > 0) {
    		return crops.get(name) * 1.0 / totalWeight;
		}
    	else {
			return 0;
		}
        
    }

    public static void main(String[] args) {
        CropRatio cropRatio = new CropRatio();

        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
    }
}
