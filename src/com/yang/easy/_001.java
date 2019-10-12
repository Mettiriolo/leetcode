package com.yang.easy;

import java.util.HashMap;

public class _001 {
	public int[] twoSum(int[] nums, int target) {
        int[] numIndex=new int[2];
		HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(hashmap.get(target-nums[i])==null) {
				hashmap.put(nums[i], i);
			}else {
				numIndex[0]=hashmap.get(target-nums[i]);
				numIndex[1]=i;
			}
                  		}
    return numIndex;
    }
}
