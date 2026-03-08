package LeetCode.Leet150.trie;

public class AddAndSearchWord {

    private Node root=new Node();
    public AddAndSearchWord() {

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
       char[]ch=word.toCharArray();
       return helper(root,0,ch);
    }
public boolean helper(Node node,int pos,char[]ch){
  for(int i=pos;i<ch.length;i++){
      if(ch[i]=='.'){
       for(int j=0;j<26;j++){
           if(node.children[j]!=null){
               if(helper(node.children[j],i+1,ch)){
                   return true;
               }
           }
       }
       return false;
      }else{
          if(node.children[ch[i]-'a']!=null)
              node=node.children[ch[i]-'a'];
          else
              return false;
      }
  }
  return node.is_word;
}


public boolean search1(int index,String word,Node node){
        if(index==word.length()-1){
            if(word.charAt(index)=='.'){
                for(int i=0;i<26;i++){
              if (node.children[i] != null & node.is_word) {
                return true;
                        }
                }
                return false;
                }
                if(node.children[word.charAt(index)]!=null && node.children[word.charAt(index)].is_word){
                    return  true;
                }
                return false;
        }

        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                if(node.children[i]!=null && search1(index+1,word,node.children[i])){
                    return true;
                }
            }
            return false;
        }

        if(node.children[word.charAt(index)-'a']!=null){
            return search1(index+1,word,node.children[word.charAt(index)-'a']);
        }
        return false;
}

    class Node{
      Node children[]=new Node[26];
        boolean is_word;

    }
}
