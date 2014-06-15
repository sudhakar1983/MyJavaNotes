package hashes;

/**
 * Demonstration program:  Horner's method to implement the
 * Java definition of java.lang.String.hashCode() from the API:
 *
 * hashCode
 *
 * public int hashCode()
 *
 *    Returns a hash code for this string. The hash code for a
 *    String object is computed as
 *        s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
 *    using int arithmetic, where s[i] is the ith character of
 *    the string, n is the length of the string, and ^ indicates
 *    exponentiation. (The hash value of the empty string is
 *    zero.)
 *
 * In addition, this demonstrates how one can take advantage of
 * modular arithmetic and never actually have a number larger than
 * the size of the table.  If we represent an arbitrary arithmetic
 * operator as "@" (i.e., @ could be + - * / %)
 * ( a @ b ) % m <==> ( ( a % m ) @ ( b % m ) ) % m
 * The method moduloHashCode expressly forces modular arithmetic onto
 * the code of myHashCode.
 *
 * @author  Timothy Rolfe
 */
import java.util.Scanner;

public class HornerHash
{
   // Compute s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
   static int myHashCode(String s)
   {  char[] c = s.toCharArray();
      int k, n = s.length(), v = 0;

      for (k = 0; k < n; k++)
         v = v * 31 + c[k];
      return v;
   }

   // (s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]) % m
   static int moduloHashCode(String s, int m)
   {  char[] c = s.toCharArray();
      int k, n = s.length(), v = 0;

      for (k = 0; k < n; k++)
         v = (v * 31 + c[k]) % m;
      return v;
   }

   public static void main ( String[] args )
   {
      String line;
      int    modulus = 253;
      long   hash1,
             hash2,
             hash3;
      Scanner console = new Scanner(System.in);

      System.out.print ("Hash code for ");
      if ( args.length > 0 )
      {  line = args[0];
         System.out.println(line);
      }
      else
         line = console.nextLine();

      hash1 = line.hashCode();
      hash2 = myHashCode(line);
      System.out.printf (
         "String.hashCode gives %d\n     myHashCode gives %d\n",
          hash1, hash2);
      // Get the unsigned value into the long integer:
      if ( hash1 < 0 )
      {
         hash1 = 0x100000000L + hash1;
         System.out.printf("After forcing an unsigned value:  %d\n",
                           hash1);
      }
      System.out.printf("\nForcing results to stay less than %d\n",
                        modulus);
      hash2 = hash1 % modulus;
      System.out.printf("%d mod %d goes to %d\n", hash1, modulus,
                        hash2);
      hash3 = moduloHashCode(line, modulus);
      System.out.printf("moduloHashCode(\"%s\") gives %d\n", line, hash3);
      System.out.print("Press ENTER to exit: ");
      console.nextLine();
   }
}