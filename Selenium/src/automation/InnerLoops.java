package automation;

public class InnerLoops {
	
	public static void main(String[] args) {
	
	int k = 1;
	
	for (int i=0; i<5; i++) {
		
		for (int j=1; j<5; j++) {
			
			System.out.print(k);			
			System.out.print("\s");
			k++;
			
		}
		
		System.out.println("");
	}

}
}

/*   
 
 1
2 3
4 5 6
7 8 9 10
 
*/

