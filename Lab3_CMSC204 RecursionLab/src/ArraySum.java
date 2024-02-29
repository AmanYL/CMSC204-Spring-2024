public class ArraySum {
	public int sumOfArray(Integer[] a, int index) {
		if(index < 0) //This is executed when we reach the base case.
			return 0;
		
		return a[index] + sumOfArray(a, index -1); //This is the recursive call. 
	}
	

}
