package LeetCode.Leet150.binariSearch;

public class MedianOfTwoSortedArray {

    public double bruteForceApproach(int num1[],int num2[]){
        int m=num1.length;
        int n=num2.length;
        int merge[]=new int[m+n];
        int i=0,j=0 ,k=0;
        while (i<m&&j<m){
            if(num1[i]<num2[j]){
                merge[k]=num1[i];
                i++;
            }else{
                merge[k]=num2[j];
              j++;
            }
            k++;
        }
       while (i<m){
           merge[k]=num1[i];
           i++;
           k++;
       }

        while (j<n){
            merge[k]=num2[j];
            j++;
            k++;
        }

        if((m+n)%2!=0){
            return  merge[(m+n)/2];
        }else{
            int x=(m+n)/2;
            double p=merge[x];
            double q=merge[x-1];
            return (p+q)/2;
        }
    }


    public double medianBinary(int a[],int b[]){
        if(b.length<a.length) return medianBinary(b,a);
        int n1=a.length;
        int n2=b.length;
        int low=0;
        int high=n1;
        while (low<high){

            int cut1=(low+high)/2;
            int cut2=(low+high+1)/2-cut1;
            int leftCut1=cut1==0?Integer.MIN_VALUE:a[cut1-1];
            int leftCut2=cut2==0?Integer.MIN_VALUE:b[cut2-1];
            int rightCut1=cut1==n1?Integer.MAX_VALUE:a[cut1];
            int rightCut2=cut1==n2?Integer.MAX_VALUE:b[cut2];

            if(leftCut1<rightCut2&&leftCut2<rightCut1){
                if((n1+n2)%2==0){
                    return (Math.max(leftCut1,leftCut2)+Math.min(rightCut1,rightCut2))/2.0;
                }else
                    return Math.max(leftCut1,leftCut2);
            }else if(leftCut1>rightCut2){
                high=cut1-1;
            }else
                low=cut1+1;


        }
        return 0.0;
    }
}
