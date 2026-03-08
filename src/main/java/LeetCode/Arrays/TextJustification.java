package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/*Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
"This    is    an",
"example  of text",
"justification.  "
]*/
public class TextJustification {
  public static void main(String[] args) {
    String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
    System.out.println(fullJustify(words, 16));
  }

  public static List<String> fullJustify(String a[], int maxWidth) {
    List<String> list = new ArrayList<>();
    int i = 0;
    while (i < a.length) {
      int wc = a[i].length();
      int j = i + 1;

      int can = 0;
      while (j < a.length && wc + can + a[j].length() + 1 <= maxWidth) {
        wc += a[j].length();
        j++;
        can++;
      }
      int vac = maxWidth - wc;
      int atleast = can == 0 ? 0 : vac / can;
      int extra = can == 0 ? 0 : vac % can;
      if (j == a.length) {
        atleast = 1;
        extra = 0;
      }
      StringBuilder sb = new StringBuilder();
      for (int k = i; k < j; k++) {
        sb.append(a[k]);
        if (k == j - 1) break;
        ;
        for (int e = 0; e < atleast; e++) {
          sb.append(" ");
        }
        if (extra > 0) {
          sb.append(" ");
          extra--;
        }
      }
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      list.add(sb.toString());
      i=j;
    }
    return list;
  }
}
