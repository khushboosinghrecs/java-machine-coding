import java.util.Scanner;

public class areaOfTriangle{
    public static void main(String args[]){
         Scanner s= new Scanner(System.in);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Enter a string: ");  
        String str= sc.nextLine();              //reads string             

         System.out.println("Enter the width of the Triangle:");
         double b= s.nextDouble();
 
         System.out.println("Enter the height of the Triangle:");
          double h= s.nextDouble();
 
                  //Area = (width*height)/2
      System.out.print("You have entered: "+str);  
      double area=(b*h)/2;
      System.out.println("Area of Triangle is: " + area);
    }
}