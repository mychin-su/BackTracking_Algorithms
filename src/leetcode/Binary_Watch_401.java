package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Watch_401 {
	private static List<String> results = new ArrayList<>();
	private static int[] values = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
	private static int EXPECT_COUNT = 0;

	public static void backtracking(int index, int curCount, int h, int m) {
		for (int i = 0; i <= 1; i++) {
			if (i == 1) {
				curCount++;
				if (index <= 3) {
					h += values[index];
				} else {
					m += values[index];
				}
			}
			if (index == values.length - 1) {
				if (EXPECT_COUNT == curCount && h < 12 && m < 60) {
					StringBuilder sb = new StringBuilder();
					sb.append(h);
					sb.append(":");
					if (m < 10) {
						sb.append(0);
					}
					sb.append(m);
					results.add(sb.toString());
				}
			} else {
				backtracking(index + 1, curCount, h, m);
			}
		}
	}

	public static List<String> readBinaryWatch(int turnedOn) {
		EXPECT_COUNT = turnedOn;
		backtracking(0, 0, 0, 0);
		return results;
	}

	public static void main(String[] args) {
		int turnedOn = 1;
		System.out.println(readBinaryWatch(turnedOn));
	}
}
