import java.util.*;
 
public class RSA {
    public static void main(String args[])
    {
      Scanner scan = new Scanner(System.in);
      
      //prompt user to enter two prime numbers as input
      System.out.println("Enter the prime numbers, p and q: ");
      int p = scan.nextInt();
      int q = scan.nextInt();
      System.out.println();
      
      //calculating n=pq and (p-1)*(q-1)
      int n = p*q;
      int r = (p-1)*(q-1);
      
      int e, d=0, i;
 
      //calculating e for public key
      for (e = 2; e < r; e++) {
          if (gcd(e, r) == 1) {
              break;
           }
       }
       //calculating d for public key
       for (i = 0; i <= 9; i++) {
            int x = 1 + (i * r);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        
        System.out.println("Calculating RSA Values ....");
        System.out.println();
        System.out.println("Public RSA key is (" + e + "," + " " + n + ")");
        System.out.println("Private RSA key is (" + d + "," + " " + n + ")");
        System.out.println();
        
        //Prompt user to enter the message in integer
        System.out.println("Enter the plaintext message m (an integer)");
        int m = scan.nextInt();
        System.out.println();
        
        double c1;
        double c2 = (Math.pow(m, e));
        c1= c2%n;
        int c = (int)c1;
        
        System.out.println("Encrypting m...");
        System.out.println("The ciphertext c is " + c);
        System.out.println();
        
        System.out.println("Decrypting c...");
        System.out.println("The plaintext m is " + calmod(c,d,n));
    }
    
    static int gcd(int e, int r)
    {
        if (e == 0)
            return r;
        else
            return gcd(r % e, e);
    }
    
    static int calmod(int c , int d, int n)
    {
    int a = 1;
    for (int x = 0; x < d; x++) {
         a = ((a * c) % n);       
    }   
        return a;
    }
}