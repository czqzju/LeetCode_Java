//https://leetcode.com/problems/insert-delete-getrandom-o1/
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class RandomizedSet {
	
	private Set<Integer> set;
	
	public RandomizedSet() {
        this.set = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return this.set.add(val);
    }
    
    public boolean remove(int val) {
        return this.set.remove(val);
    }
    
    public int getRandom() {
        List<Integer> arr = new ArrayList<Integer>(this.set);
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }
}
