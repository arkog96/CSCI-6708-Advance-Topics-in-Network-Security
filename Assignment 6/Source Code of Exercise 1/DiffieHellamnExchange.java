import java.util.*;
public class DiffieHellamnExchange
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner (System.in);
    Random rand = new Random();
    
    //prompt user to input the value of p and g
    System.out.println("Please enter p and g");
    int p = scan.nextInt();
    int g = scan.nextInt();
    
    //set a upperbound and lowerbound to generate random values of SA and SB between 1 to 10. 
    int upperbound = 10;
    int lowerbound = 1;
    int SA = lowerbound + rand.nextInt(upperbound);
    int SB = lowerbound + rand.nextInt(upperbound);
    System.out.println("The value of SA is " + SA);
    System.out.println("The value of SB is " + SB);
    System.out.println("");
    
    //Compute TA and TB using SA, SB, p and g
    int TA = (int)((Math.pow(g,SA))%p);
    int TB = (int)((Math.pow(g,SB))%p);
    
    //compute the secret key after exchanging the T's
    int SK1 = (int)((Math.pow(TB,SA))%p);
    int SK2 = (int)((Math.pow(TA,SB))%p);
    
    if(SK1==SK2)
    {
      System.out.println("The secret key is " + SK1);
    }
    else{
      System.out.println("Invalid");
    }
  }
}