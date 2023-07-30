//   1 2 3 4 5 6 7 8 9 10 11 11 11 11 11 11 11 --- 1000
// memory is used while taking input or while declaring input 
// array is like container weher same datatype  of data is stored 
//  1001, 1002, 1003, ........ 1010;
// 1001 , 1005
//   5th place -> 5
 

// 10, 20 , 30, 40, 50

// sum => arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
//scope of k =>global scope;
// scope of i =>local scope
public class arrraClass {
        public static void main(String args[]){
        //  [ | | | | ]
        //  [0|1|2|3|4]
        int arr[]= new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        System.out.println(arr[0] +" " + " "+ arr[1] +" " +" "+ arr[2] +" "+ arr[3]+" " + "" +arr[4]);
        int k;
       
        // for(int i =0 ; i<=4; i++){
        //     System.out.println(arr[i]);

        // }

        // sum => arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        // int sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        // prin(sum)
        // int sum = 0;
        // sum = 0 +arr[0]; =>10
        // sum = 0 + 10 + arr[1] => 30;
        // sum = sum    + arr [1] => 30; 
        // sum = sum  + arr[2] => 60;
        // sum = sum + arr[2] + arr[3] => 100
        // sum = sum +arr[3] + arr[4] => 150;
        // int sum =0;
 
        // for(int i = 0; i<=4; i++){
        //     sum = sum + arr[i];
        //     System.out.println(arr[i]) ;
        // }
        //   System.out.println(sum);

        // ques ->1 , 2, 3, 4 , 5
        // sum = sum + arr[i]*10
        // 10 + 20 +30 +40+50 
        // nameofrra.length => length of array

        // average of array elements  = 20, 40, 50, 60 =>  allsum/ 4

        int sumaverage = 0;
        // 4 = 5
        for(int i = 0; i< arr.length; i++){
            // sum = sum + arr[i];
            sumaverage = sumaverage  + arr[i];
        }
            // 4+ 3+ 5+ 2+ 2 =>  16 / 5 => 3.2
        double avg =  sumaverage/arr.length;


        //  max of five number
        // 10, 20 , 30, 40, 50
        // 50, 30, 40, 10, 20;

        // 0 > 10 => max=10 => 10> 20 => max=20 ; 20> 30 => max=30; 30> 40 => max= 40 => 40> 50 => max=50;
        // max= 50;

    
        // arrtwo[i]> 0 = max = arr[i]

        //arrtwo.length = 6
        // 5 
        //  5< 6
        //  max= 40 => max= 600 =>  max= 6000;
        //  min of array => 
        int arrtwo[]= new int[6];
        arrtwo[0] = 40;
        arrtwo[1] = 20;
        arrtwo[2] = 600;
        arrtwo[3] = 40;
        arrtwo[4] = 50;
        arrtwo[5] = 5000;

        int max= 0;
        
        int min =arrtwo[0]; 
        for(int i = 0; i<arrtwo.length; i++){
            if(arrtwo[i]>max){
                max = arrtwo[i];
            }
            if(arrtwo[i]<min){
                min = arrtwo[i];
            }
        }
        System.out.println(max + " max value") ;
        System.out.println(min + " min value") ;


        //   int k;
    


    }
    
}
