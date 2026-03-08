package Algo;

public class RemoveAdjecentDuplicates {

    public static void main(String[] args) {

        int a[]={1,5,6,8,8,8,0,1,1,0,6,7,8};
        int index=removeDuplicates(a);
        for(int i=0;i<=index;i++){
            System.out.println(a[i]);
        }
    }


    public  static int removeDuplicates(int a[]){
        int stkptr=-1;
        int i=0;

        while(i<a.length){
            if(stkptr==-1 || a[stkptr]!=a[i]){
                stkptr++;
                a[stkptr]=a[i];
                i++;
            }else{
                while (i<a.length&& a[stkptr]==a[i]){
                    i++;
                }
                stkptr--;
            }


        }
        return stkptr;
    }
}
