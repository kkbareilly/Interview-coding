package LeetCode.Leet150.arraystring;

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
    System.out.println(fullJustifys(words, 16));
  }

  static int MAX_WIDTH;

  public static List<String> fullJustifys(String[] words, int maxWidth) {

    List<String> result = new ArrayList<>();
    int n     = words.length;
     MAX_WIDTH = maxWidth;
    int i     = 0;

    while(i < n) {
      int lettersCount = words[i].length();
      int j            = i+1;
      int spaceSlots   = 0;

      while(j < n && spaceSlots + lettersCount + words[j].length() + 1 <= maxWidth) {
        lettersCount += words[j].length();
        spaceSlots   += 1;
        j++;
      }

      int remainingSlots = maxWidth - lettersCount;


      int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
      int extraSpace    = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

      if(j == n) { //Means we are on last line - Left justfied
        eachWordSpace = 1;
        extraSpace    = 0;
      }


      result.add(getFinalWord(i, j, eachWordSpace, extraSpace, words));
      i = j;
    }

    return result;
  }

  private static String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words) {
    StringBuilder s = new StringBuilder();

    for(int k = i; k < j; k++) {
      s.append(words[k]);

      if(k == j-1)
        continue;

      for(int space = 1; space <= eachWordSpace; space++)
        s.append(" ");

      if(extraSpace > 0) {
        s.append(" ");
        extraSpace--;
      }
    }

    while(s.length() < MAX_WIDTH) {
      s.append(" ");
    }

    return s.toString();
  }



  public List<String> fullJustify(String[] a, int maxWidth) {
      List<String> result=new ArrayList<>();
      int i=0;
      while (i<a.length){
        int lineLength=a[i].length();
        int j=i+1;
        while (j<a.length && lineLength+a[j].length()+(j-i)<=maxWidth){
          lineLength+=a[j].length();
          j++;
        }
        int numWords=j-i;
        int numSpace=maxWidth-lineLength;
        String line="";
        if(numSpace==1 || j==a.length){
          line=a[i];
          for(int k=i+1;k<j;k++){
            line+=" "+a[k];
          }
          int size=maxWidth-line.length()-1;
          for(int p=0;p<=size;p++){
            line+=" ";
          }
        }else{
          line=a[i];
          int spaceBetweenWords=numWords==1?numSpace:numWords-1==0?0: numSpace/(numWords-1);
          int extraSpace=numWords==1?numSpace:numWords-1==0?0:numSpace%(numWords-1);
          for(int k=i+1;k<j;k++){
            for(int p=0;p<spaceBetweenWords;p++){
              line+=" ";
            }
            if(extraSpace>0){
              line+=" ";
              extraSpace--;
            }
            line+=a[k];
          }
          if(numWords==1){
            for(int p=0;p<spaceBetweenWords;p++){
              line+=" ";
            }
          }

        }
        result.add(line);
        i=j;
      }
      return result;
  }
  }
