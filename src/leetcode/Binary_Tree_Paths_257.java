package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<>();
		if (root != null) {
			backTracking(root, new StringBuilder(), answer);
		}
		return answer;
	}

	private static void backTracking(TreeNode root, StringBuilder sb, List<String> answer) {
		if (root == null) {
			return;
		}
		int curLen = sb.length();
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			answer.add(sb.toString());
		} else {
			sb.append("->");
			backTracking(root.left, sb, answer);
			backTracking(root.right, sb, answer);
		}
		sb.setLength(curLen); // sb.setLength(curLen) được sử dụng để cắt StringBuilder về độ dài ban đầu (curLen) sau khi bạn đã sử dụng nó để xây dựng một đường đi.
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		System.out.println(binaryTreePaths(root));
	}
}
