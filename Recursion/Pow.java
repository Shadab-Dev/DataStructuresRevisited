package Recursion;

public class Pow{
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        // Base condition
        if(n==0) return 1;
        // handle negative values of n 
        if(n<0){
            // To handle negative values, we can just make x as 1/x and n as -n/2 in function
            // we use -n/2 in function to handle integer overflows
            x = 1/x;    
            double temp = myPow(x, -(n/2));
            // Then we need to handle the odd and even values of n
            return (n % 2 == 0) ? temp * temp : x * temp * temp;
        }
        double temp = myPow(x, n/2);
        return (n % 2 == 0) ? temp * temp : x * temp * temp;
    }
}