package Heap;

public class HeapImpl {
    int size;
    int arr[]=new int[20];

    public void insert(int val){
        arr[size]=val;
        int index=size;
        int parent=(index-1)/2;
        while (parent>0&& arr[parent]<arr[index]){
            int t=arr[parent];
            arr[parent]=arr[index];
            arr[index]=t;
            t=parent;
            index=parent;
            parent=(t-1)/2;
        }
        size++;
    }

    public int getmax(){
      return   arr[0];
    }
    public int removeMax(){
        int max=arr[0];
        arr[0]=arr[size-1];
        size=size-1;
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int i) {
        int l,r;
        l=2*i+1;
        r=2*i+2;
        int largest=i;
        if(l<this.size&&arr[l]>arr[largest]){
            largest=l;
        }
        if(r<this.size&&arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int t=arr[largest];
            arr[largest]=arr[i];
            arr[i]=t;
        }
        maxHeapify(largest);
    }
}
