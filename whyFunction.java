
//writ good code is less lines and not mashup

//call function  name();
public class whyFunction{
    public static void main(String[] args){
        double perimeter= perimeterOFCuboid();
        System.out.println(perimeter);
        double radius = 12.5;
        double focallength = focalLengthOfMirror(radius);
        System.out.println(focallength);
    }
    // break the code into pieces
    public static void areaOfSquare(){
        int side=50;
        int areaofsquare=side*side;
        System.out.println("areaofsquare="+areaofsquare);
    }

    public static double perimeterOFCuboid(){
        double length=50.5;
        double  breadth=50.5;
        double height=50.5;
        double  perimeter=4*(length+breadth+height);
        return perimeter;
        // System.out.println("perimeter="+perimeter);
    }

    public static double focalLengthOfMirror( double num){
        double radius=num;
        double focallength=num/2;
        System.out.println("focal="+focallength);
        areaOfSquare();
        return focallength;
        // System.out.println("focal="+focallength);
    }
}