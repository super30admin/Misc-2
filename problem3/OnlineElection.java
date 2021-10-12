// Time Complexity : CONSTRUCTOR: O(m), m -> Number of time intervals, Q -> O(log m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
	Map<Integer, Integer> leaderBoard;
	Map<Integer, Integer> voteMap;
	int[] timesClone;

	public OnlineElection(int[] persons, int[] times) {
		leaderBoard = new HashMap<>();
		voteMap = new HashMap<>();
		timesClone = times;

		int leader = 0;
		voteMap.put(0, 0);

		for (int i = 0; i < times.length; i++) {
			voteMap.put(persons[i], voteMap.getOrDefault(persons[i], 0) + 1);

			if (voteMap.get(leader) <= voteMap.get(persons[i])) {
				leader = persons[i];
			}

			leaderBoard.put(times[i], leader);
		}
	}

	public int q(int t) {
		if (leaderBoard.containsKey(t)) {
			return leaderBoard.get(t);
		}

		int bsIndex = binarySearch(t);
		return leaderBoard.get(timesClone[bsIndex]);
	}

	private int binarySearch(int target) {
		int low = 0;
		int high = timesClone.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (timesClone[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	public static void main(String[] args) {
		int[] persons = { 0, 1, 1, 0, 0, 1, 0 };
		int[] times = { 0, 5, 10, 15, 20, 25, 30 };

		OnlineElection obj = new OnlineElection(persons, times);

		System.out.println("At time \'3\', leader = " + obj.q(3));
		System.out.println("At time \'12\', leader = " + obj.q(12));
		System.out.println("At time \'25\', leader = " + obj.q(25));
		System.out.println("At time \'15\', leader = " + obj.q(15));
		System.out.println("At time \'24\', leader = " + obj.q(24));
		System.out.println("At time \'8\', leader = " + obj.q(8));
	}
}
