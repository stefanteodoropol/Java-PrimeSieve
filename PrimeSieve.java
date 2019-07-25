//Creator: Stefan Nicolae Teodoropol
//Date: 12.08.2019

import java.util.*;
import java.lang.*;

public class PrimeSieve {
	
	public static void main (String[] args) throws java.lang.Exception {
	
		Scanner scn = new Scanner(System.in);
		// Enter n the nr of test cases, followed by the range a through b in which primes should be found.
		int n = scn.nextInt();
		int a;
		int b;
		for (int i = 0; i < n; i++) {
			a = scn.nextInt();
			b = scn.nextInt();
			if (a < 0 || b < 1) { System.out.println("Ensure a is >= 0 and b is >= 1."); }
			else { solve(a,b); }
		}
		scn.close();
	}
	
	public static void solve (int a, int b) {
		// Initially all entries in sieve[] are false		
		boolean[] sieve = new boolean[b+1];
		
		// All numbers are assumed to be prime, we start by setting the flag in sieve[] to true when a number is a multiple of a prime.
		// 0 isnt prime, neither is 1, b >= 1 so our array will always have at least size 2. 
		sieve[0]=true;
		sieve[1]=true;
		
		// Recursive sieve loop from 2 to b to identify prime numbers by marking off (sieve[x] is set to TRUE) multiples of found primes.
		// The numbers left untouched (sieve[x] is FALSE as when initialized) have no known multiples other than themself and 1, and are thus prime.    
		for (int i = 2; i <= b; i++) {
			if (sieve[i] == false) {
				if (i >= a) {
					// Print it ONLY if it's larger than a.
					System.out.print(i + " ");
				}
				for (int j = 2; i*j <= b; j++) {
					// Mark off multiples of the prime up to b. 
					sieve[i*j] = true;
				}
			}
		}
		System.out.println();
	}
}
