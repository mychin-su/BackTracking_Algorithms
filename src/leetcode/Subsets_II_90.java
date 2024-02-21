package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		Arrays.sort(nums); // săp xếp mảng đã cho theo thứ tự tăng dần mục địch tạo điều kiện để cho 2 phần
							// tử bằng nhau đứng cạnh nhau
		// Start backtracking from the beginning
		backtrack(resultList, new ArrayList<>(), nums, 0);
		return resultList;

	}

	private void backtrack(List<List<Integer>> resultSets, ArrayList<Integer> tempSet, int[] nums, int start) {
		if (resultSets.contains(tempSet)) {
			return;
		}
		resultSets.add(new ArrayList<>(tempSet));
		for (int i = start; i < nums.length; i++) {
			// Case of including the number
			tempSet.add(nums[i]);

			// Backtracking then new subset
			backtrack(resultSets, tempSet, nums, i + 1);

			// Case of not-including the numbers
			tempSet.remove(tempSet.size() - 1);
		}
	}
}
