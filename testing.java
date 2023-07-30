import java.util.Scanner;
import java.util.TreeSet;

public class testing {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // int a;
        // float b;
        // String s;
        // a= sc.nextInt();
        // b= sc.nextFloat();
        // s= sc.nextLine();
        // System.out.println(s+ " "+  a + " " +b);
        swap(10, 12);
        // int t;
        // t = sc.nextInt();
        // while(t>0){
        //     System.out.print(t);
        //     int n;
        //     n = sc.nextInt();
        //     int arr[] = new int[n];
        //     for(int i=0; i<n; i++){
        //         arr[i] = i;
        //         System.out.println(arr[i]);
        //     }
        //     t--;

        // }

        int a=9, b=-2;
        int c= (int) Math.pow(a, b);
        int d= Math.max(a, b);
        int e= Math.abs(b);
        System.out.println(c);
         System.out.println(d);
         System.out.println(e);
         double cc = 8.6;
         System.out.println((int)Math.ceil(cc));
        System.out.println((int)Math.floor(cc));

      //  allSubstr("abc cde bde hde");

    }

    // transpose of matrix = row=> column, columne= row;
    public static void swap(int a, int b){
        a= a+b;
        b= a-b;

        System.out.println(a + " " +b);
    }
    public static void compareToString(String s1, String s2){
        if(s1.compareTo(s2)>0){
            System.out.print("s1 is greater");
        }
        else if(s1.compareTo(s2)< 0){
            System.out.print('s2 is greater');
        }
        else{
            System.out.print("both are equal");
        }
    }

    public static void reversenum(int num){
        // 123
        // 321
        int reversenum = 0;
        while(num!=0){
            reversenum = reversenum*10;
            reversenum = reversenum +num%10;
            num = num/10;
        }
        System.out.println(reversenum);
    }
    
    public static void allSubstr(String s1){
        String ss= s1.trim();
        System.out.println("----------------");

        System.out.println(ss);
        String sub = "";
        String rev = "";
        for(int i =0; i<s1.length()-1; i++){
            // sub = "" +s1.charAt(i);
            for(int j=i+1; j<=s1.length(); j++){
                sub = s1.substring(i, j);
                // sub = sub+ s1.charAt(j);
                System.out.println(sub);
            }
        }
        for(int i= s1.length()-1; i>=0; i--){
            rev= rev+s1.charAt(i);

        }
        System.out.println(rev);
        for(int i =0; i<=s1.length()-1; i++){
            for(int j=1; j<= s1.length()-1-i; j++){
                sub = s1.substring(i, i+j);
                System.out.println(sub);
            }
        }
        String words[] = s1.split("\\s");
        for(String s: words){
            System.out.println(s);
        }
    }
    // TreeSet<String> al=new TreeSet<String>(); 
    // String s="200";
    // int i=Integer.parseInt(s);
    // int i=200;
    // String s=String.valueOf(i); 
    // String s="9990449935";
    // long l=Long.parseLong(s);

    
}
