
public class Searching
{
	public static void main(String args[])
	{
		int[] array = {1,2,3,5,6,9,10,15,18,21,22};
		System.out.println("Key present at index: "+binarySearch(array,5));
	}
	
	public static int binarySearch(int[] x, int search)
	{
		//uses at most 1+logn compares to find an element
		int low = 0;
		int high = x.length - 1;
		
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(search>x[mid])
			{
				low = mid+1;
			}
			else if(search<x[mid])
			{
				high = mid-1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}
	
}
