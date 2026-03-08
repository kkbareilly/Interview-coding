package matrix;

public class FindElementInSortedAndRotedArray {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3, 4},

                {9, 10, 11, 12},{5, 6, 7, 8}};

        int s=10;
int i=0 ;int j=mat[0].length-1;

while(i<mat.length && j>0){
    if(s==mat[i][j]){
        System.out.println("match:   "+mat[i][j]);
        break;
    }
    if(s<mat[i][j])
        j--;
    else
        i++;
}

    }
}
