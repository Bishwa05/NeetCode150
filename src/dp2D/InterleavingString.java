package dp2D;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;

        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3, int k) {

        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }

        if (k > s3.length()) return false;

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(s1, i + 1, s2, j, s3, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || dfs(s1, i, s2, j + 1, s3, k + 1);
        }
        return res;
    }


    // Memo approach

    private Boolean[][] dp;

    public boolean isInterleave2(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs2(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs2(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }

        if (dp[i][j] != null) return dp[i][j];

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs2(s1, i + 1, s2, j, s3, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || dfs2(s1, i, s2, j + 1, s3, k + 1);
        }
        dp[i][j] = res;
        return res;
    }
}
