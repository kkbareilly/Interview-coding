package LeetCode.Leet150.trie;

public class Trie {

   private Node root=new Node();
    public Trie() {

    }

    public void insert(String word) {
        Node current=root;
      for(int i=0;i<word.length();++i){
          int index=word.charAt(i)-'a';
          if(current.children[index]==null){
              current.children[index]=new Node();
          }
          current=current.children[index];
      }
      current.is_word=true;
    }

    public boolean search(String word) {
       Node node=getPreFix(word);
       return node!=null?node.is_word:false;
    }

    public boolean startsWith(String prefix) {
       Node node=getPreFix(prefix);
       return node!=null;
    }

    public Node getPreFix(String word){
       Node cur=root;
       for(int i=0;i<word.length()&&cur!=null;++i){
           int index=word.charAt(i)-'a';
           cur=cur.children[index];
       }
       return cur;
    }

    class Node{
        Node children[]=new Node[26];
        boolean is_word;

    }
}
