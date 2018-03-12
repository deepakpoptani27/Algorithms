package com.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationOfNumbers {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		solve(nums, 0, groups);
		return groups;
	}

	public void solve(int nums[], int index, List<List<Integer>> groups) {

		if (index == nums.length) {
			{
				groups.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
				return;
			}

		} else {
			for (int i = index; i < nums.length; i++) {
				int t = nums[index];
				nums[index] = nums[i];
				nums[i] = t;
				solve(nums, index + 1, groups);
				t = nums[index];
				nums[index] = nums[i];
				nums[i] = t;
			}
		}

	}
}
