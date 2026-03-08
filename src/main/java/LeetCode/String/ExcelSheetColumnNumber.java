package LeetCode.String;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int ans = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            ans *= 26;
            char c = columnTitle.charAt(i);
            int n = (int) (c - 'A' + 1);
            ans += n;
        }
        return ans;
    }
}
