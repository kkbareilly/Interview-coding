package LRU.lfu;

import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
 Map<Integer,ListNode> keyMap=new HashMap<>();
 Map<Integer,DoublyList> feqMap=new HashMap<>();
 int currentCap=0;;
 int maxCapacity;

 public LFUCache(int maxCapacity){
     this.maxCapacity=maxCapacity;
 }

 public ListNode addNode(int key){
     if(!keyMap.containsKey(key))
         return null;
     ListNode currNode=keyMap.get(key);
     DoublyList list=feqMap.get(currNode.freq);
     list.deleteNode(key);
     currNode.freq++;
     if(!feqMap.containsKey(currNode.freq))
         feqMap.put(currNode.freq,new DoublyList());
     feqMap.get(currNode).addNode(currNode);
     return currNode;
 }

 public int get(int key){
     if(!keyMap.containsKey(key))
         return -1;
    ListNode node =keyMap.get(key);
    return node.value;
 }

 public void put(int key,int value){
     if(maxCapacity==0)
         return;
     if(keyMap.containsKey(key)){
       ListNode node=  keyMap.get(key);
       node.value=value;
     }else {
         if (currentCap==maxCapacity){
             int minFre=Integer.MIN_VALUE;

           for(int keys:feqMap.keySet()){
               if(!feqMap.containsKey(keys))
                   continue;
                   minFre=Math.min(minFre,keys);

           }
             DoublyList list= feqMap.get(minFre);
          ListNode curNode= list.deleteHead();
           keyMap.remove(curNode.key);
           currentCap--;

         }
         int curFreq=1;
         ListNode node=new ListNode(key,value);
         keyMap.put(key,node);
         if(!feqMap.containsKey(curFreq))
             feqMap.put(curFreq,new DoublyList());

         feqMap.get(curFreq).addNode(node);
         currentCap++;
     }


 }
}
class ListNode{
    ListNode prev,next;
    int key,value,freq;
    ListNode(){

    }
    ListNode(int key,int val){
     this.key=key;
     this.value=val;
     this.freq=1;
    }
}

class DoublyList{
    Map<Integer,ListNode> map=new HashMap<>();
    ListNode head,tail;

    DoublyList(){
        head=new ListNode();
        tail=new ListNode();
        head.next=tail;
        tail.prev=head;
    }

    public void addNode(ListNode curNode){
        ListNode preTail=tail.prev;
        preTail.next=curNode;
        curNode.prev=preTail;
        tail.prev=curNode;
        curNode.next=tail;
        map.put(curNode.key,curNode);

    }

    public ListNode deleteNode(int key){
        if(!map.containsKey(key))
            return null;
       ListNode curNode= map.get(key);
       ListNode preNode=curNode.prev;
       ListNode nextNode=curNode.next;
       preNode.next=nextNode;
       nextNode.prev=preNode;
       map.remove(key);
       return curNode;
    }

    public ListNode deleteHead(){
        if(head.next==tail)
            return null;
        ListNode firstNode=head.next;
        return deleteNode(firstNode.key);

    }
}