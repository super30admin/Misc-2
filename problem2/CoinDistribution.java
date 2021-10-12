// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class CoinDistribution {
	int ans;

	public int distributeCoins(TreeNode root) {
		if (root == null) {
			return 0;
		}

		ans = 0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode node) {
		// Base
		if (node == null) {
			return 0;
		}

		// Logic
		int left = dfs(node.left);
		int right = dfs(node.right);
		ans += Math.abs(node.val + left + right - 1);
        return node.val + left + right - 1;
	}

	public static void main(String[] args) {
		CoinDistribution obj = new CoinDistribution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);

		System.out.println("Number of moves required to equally distribute coins: " + obj.distributeCoins(root));
	}

}
