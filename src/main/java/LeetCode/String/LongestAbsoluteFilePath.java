package LeetCode.String;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    static int max=0;

    public static void main(String[] args) {
        String input="dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
      //  find(input.split("\n"),"",0,0);
        System.out.println(lenghtLarget(input));
      //  System.out.println(lengthLongestPaths(input));
    }
    public static int lengthLongestPaths(String input) {
        String[] paths = input.split("\n");
        int[] levels = new int[paths.length + 1];
        levels[0] = -1;
        int maxLength = 0;
        for (String path : paths) {
            String name = path;
            int level = 1;
            while (name.startsWith("\t")) {
                name = name.substring(1);
                level++;
            }
            int newLength = levels[level - 1] + name.length() + 1;
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, newLength);
            } else {
                levels[level] = newLength;
            }
        }
        return maxLength;
    }


    public static void find(String[] dirs,String part,int idx, int count) {
        String temp = "";

        for (int i = idx; i < dirs.length; i++) {
            int j = dirs[i].lastIndexOf("\t") + 1; //"\t" only one space

            if (j == count) {
                temp = part;
                temp += dirs[i].substring(j, dirs[i].length());
                if (temp.contains("."))
                    max = Math.max(max, temp.length());
            } else if (j == count + 1)
                find(dirs, temp + '/', i, count + 1);
            else if (j > count + 1)
                continue;
            else break;//j<count
        }
    }

    class Directory {
        String name;
        int depth;

        public Directory(String name, int depth) {
            this.name = name;
            this.depth = depth;
        }
    }


   /* Counting a depth (or level) of a directory/file
    If depth >= of the last element of stack then we need to find a 'parent'
    Check if we have a file or dir*/
    private int length = 0;

    public int lengthLongestPath(String input) {
        String[] in = input.split("\n");
        Stack<Directory> stack = new Stack<>();
        for (String elem : in) {

            // number of \t
            int depth = elem.lastIndexOf('\t') + 1;

            // finding parent
            while (!stack.isEmpty() && stack.peek().depth >= depth)
                length -= stack.pop().name.length() + 1;

            // checks if we have a file
            if (elem.indexOf('.') != -1) {
                max = Math.max(max, length + elem.length() - depth);
            } else {
                Directory dir = new Directory(elem.substring(depth, elem.length()), depth);
                length += dir.name.length() + 1;
                stack.add(dir);
            }
        }
        return max;
    }

    public static int larget(String input){
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int maxlen=0;
        for(String s:input.split("/n")){
            int level=s.lastIndexOf("\t")+1;
            while (level<st.size()){
                st.pop();
            }
            int len=st.peek()+(s.length()-level)+1;
            st.push(len);
            if(s.contains(".")){
                maxlen=Math.max(maxlen,len);
            }
        }
        return maxlen;
    }

    public  static int lenghtLarget(String input){
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        int maxLen=0;

        for(String s:input.split("\n")){
            int depth=s.lastIndexOf("\t")+1;

            while (depth<st.size()-1){
                st.pop();
            }
            int length=st.peek()+(s.length()-depth)+1;
            st.push(length);
            if(s.contains(".")){
                maxLen=Math.max(maxLen,length-1);
            }
        }
   return maxLen;
    }
}
