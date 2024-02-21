package leetcode;

public class Sum_of_All_Subnet_XOR_Totals_1863_P2 {
	private int resultSum = 0;

	private void backtrack(int index, int[] nums, int curXOR) {
		for (int i = 0; i <= 1; i++) {
			curXOR = i == 0 ? curXOR : curXOR ^ nums[index];
			if (index == nums.length - 1) {
				this.resultSum += curXOR;
			} else {
				backtrack(index + 1, nums, curXOR);
			}
		}
	}

	public int subsetXORSum(int[] nums) {
		backtrack(0, nums, 0);
		return this.resultSum;
	}
}
