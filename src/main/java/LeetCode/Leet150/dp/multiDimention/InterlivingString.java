package LeetCode.Leet150.dp.multiDimention;

public class InterlivingString {
    Boolean cache[][];
    char[] s1Arr,s2Arr,s3Arr;
    char UNKNOWN='0';
    public boolean isInterleave(String s1, String s2, String s3) {
      s1Arr=s1.toCharArray();
      s2Arr=s2.toCharArray();
      s3Arr=s3.toCharArray();
      cache=new Boolean[s1Arr.length+1][s2Arr.length+1];
      if(s1Arr.length+s2Arr.length!=s3Arr.length)
          return false;
     return dfs(0,0);

    }

    public boolean dfs(int s1 ,int s2){
      if(s1==s1Arr.length && s2==s2Arr.length)
          return true;
      if(cache[s1][s2]!=null) return cache[s1][s2];
      int s3=s1+s2;
      char s1Char=s1==s1Arr.length?UNKNOWN:s1Arr[s1];
      char s2Char=s2==s2Arr.length?UNKNOWN:s2Arr[s2];
      char s3Char=s3Arr[s3];
      if(s1Char==s3Char&& s2Char==s3Char)
           cache[s1][s2]=dfs(s1+1,s2)||dfs(s1,s2+1);
      else if(s1Char==s3Char)
           cache[s1][s2]=dfs(s1+1,s2);
      else if(s2Char==s3Char)
          cache[s1][s2]=dfs(s1,s2+1);
      else
          cache[s1][s2]=false;

      return cache[s1][s2];
    }

}
