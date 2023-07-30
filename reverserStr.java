import java.util.Scanner;

public class reverserStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; 
        n = sc.nextInt();
         String arr[] = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
      int   min = arr[0];
       int  max = arr[0]; 
       for(int i=1; i<n; i++){
        if(arr[i]<min){
            min = arr[i];
        }
        if(arr[i]>max){
            max =arr[i];
        }
       }
    
       System.out.println(min);
        System.out.println(max);
    }
    
}
