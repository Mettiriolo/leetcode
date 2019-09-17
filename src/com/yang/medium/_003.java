package com.yang.medium;

public class _003 {
	public int lengthOfLongestSubstring(String s) {
		int max = 0, left = 0;

		for (int i = 1; i < s.length(); i++) {
			for (int j = left; j < i; j++)
				if (s.charAt(i) == s.charAt(j)) {
					left = j + 1;
					break;
				}
			if (i - left + 1 > max)
				max = i - left + 1;
		}

		return max == 0 ? s.length() : max;
	}
}
