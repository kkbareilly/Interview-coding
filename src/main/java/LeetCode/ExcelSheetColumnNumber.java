package LeetCode;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        int p=0;
        int ans=0;
        String column="ZY";
        for(int i=column.length()-1;i>=0;i--){
            System.out.println(column.charAt(i));
           int data= (int)column.charAt(i)-65+1;
           ans+=data*Math.pow(26,p);
           p++;

        }
        System.out.println(ans);
    }

}
