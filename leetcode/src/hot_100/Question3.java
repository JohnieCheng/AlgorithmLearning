package hot_100;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author Johnie Cheng
 * @version 1.0
 */
public class Question3 {
    public static void main(String[] args) {
        System.out.println(new Question3().lengthOfLongestSubstring("123456 4"));
    }

    public int lengthOfLongestSubstring(String s) {
//        return officialAnswer(s);
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;

        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    private int officialAnswer(String s) {
        HashSet<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1; // 右指针位置
        int ans = 0; // 子串长度

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }

            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }
}
