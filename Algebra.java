// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(-8,-5));   // 2 + 3
		//System.out.println(minus(7,2));  // 7 - 2
		//System.out.println(minus(2,7));  // 2 - 7
		//System.out.println(times(-3,-4));  // 3 * 4
		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		//System.out.println(pow(5,-3));      // 5^3
		//System.out.println(pow(-3,5));      // 3^5
		System.out.println(div(1,3));   // 12 / 3    
   		System.out.println(div(5,-5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123)); 
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0 && x1 < 0){
			while (x2 != 0) {
				x1--;
				x2 ++;
			}
		}
		else if (x2 < 0 && x1 > 0) {
			while (x2 != 0) {
				x1--;
				x2++;
			}
		}
		for (int i=0; i<x2; i++){
			x1++;
		}
		return x1;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0 && x1 < 0){
			while (x2 != 0) {
				x1++;
				x2 --;
			}
		}
		else if (x2 < 0 && x1 > 0) {
			while (x2 != 0) {
				x1++;
				x2--;
			}
		}
		for (int i=0; i<x2; i++){
			x1--;
		}		
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0)
			return 0;
		else{
		int x = x1;
		if (x2 < 0 && x1 < 0){
			while (x2 != -1) {
				x1 = plus(x1, x);
				x2++;
			}
		}
		else if (x2 < 0 && x1 > 0) {
			while (x2 != -1) {
				x1 = plus(x1, x);
				x2++;
			}
		}
		for (int i=1; i<x2; i++){
			x1 = plus(x1, x);
		}		
		return x1;
	}
	}

	// Returns x^n (for n >= 0) // 5 -3 = 1/125
	public static double pow(int x, int n) {
		if (n == 0)
			return 1;
		if (x == 0)
			return 0;
		int y = times(x, x); //25
		if (n > 0)
		{
		for (int i=2; i<n; i++){
			y  = times(y, x);
		}
	}
		else if (n < 0) {
			int trick = n - n - n;
			for (int i=2; i<trick; i++){
				y  = times(y, x);
			}
			double z = (double)y;
			return 1/z;	
		}
	return y;

}
	

	// Returns the integer part of x1 / x2 6/-2 -2/6
	public static double div(int x1, int x2) {
		double z = 0;
		if (x1 >= x2 ) {
			while (x1 >= x2) {
			x1 = minus(x1, x2);
			z++; 
		}
		}
		else{
		while (x1 <= x2) {
			x2 = minus(x2, x1);
			z--;
		}	
	}
		if (x1 < 0 || x2 < 0)
			return -z;	
		return z;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int y = 0; 
		while (times(y, y) < x ) {
			y++;
		}
		return y;
	}	  	  
}