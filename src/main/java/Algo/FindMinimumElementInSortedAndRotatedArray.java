package Algo;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FindMinimumElementInSortedAndRotatedArray {

  public static void main(String[] args) {
    //
      CopyOnWriteArrayList<Integer> data=new CopyOnWriteArrayList<>();
      data.add(1);
      data.add(2);
      data.add(3);
      data.add(4);
      data.add(5);
      data.add(6);
    System.out.println(search(data,0,data.size(),7));
    data.stream().forEach(s -> System.out.println(s));
  }

    public int search(int a[],int l,int h){

        while (l<h){
            int mid=(h+l)/2;
            if(a[mid]==a[h])
                h--;
            if(a[mid]>a[h])
                l=mid+1;
            else
                h=mid;
        }
        return a[l];
    }

    public static boolean search (List<Integer>data,int l,int h,int key){
    if (l < h) {

      int mid = l + (h - l) / 2;
      if (key == data.get(mid)) {
        return true;
      }  if (key < data.get(mid)) {
       return search(data, l, mid - 1, key);
      }  if (key > data.get(mid)) {
       return search(data, mid + 1, h, key);
      }
}
    data.add(key);
    return false;
    }
}
