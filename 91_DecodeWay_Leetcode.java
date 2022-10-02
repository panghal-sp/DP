class Solution {
 public int numDecodings(String s) {
	if (s.length() == 0)
		return 0;

	Integer[] memo = new Integer[s.length()];
	return numDecodings(s, 0, memo);
}

private int numDecodings(String s, int i, Integer[] memo) {
	if (i == s.length())
		return 1;

	if (s.charAt(i) == '0')
		return 0;

	if (memo[i] != null)
		return memo[i];

	int res = numDecodings(s, i + 1, memo);

	if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
		res += numDecodings(s, i + 2, memo);

	return memo[i] = res;
}
}
