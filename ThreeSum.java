/*
 * Find number of triplets whose sum is zero in given array
 */
public class ThreeSum
{
	public static void main(String args[])
	{
		int[] array = {30,-40,-20,-10,40,0,10,5};
		System.out.println("Number of three sums by Brute Force: "+bruteForce(array));
		System.out.println("Number of three sums by Sorting Based: "+sortingBased(array));
	}
	
	public static int bruteForce(int[] array)
	{
		//Complexity: n^3
		int count =0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				for(int k=0;k<j;k++)
				{
					if(array[i]+array[j]+array[k]==0)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int sortingBased(int[] array)
	{
		//complexity: n^2logn
		/*
		 * Sort the array
		 * For each pair a[i] and a[j], binary search -(a[i]+a[j])
		 */
		int count=0;
		int[]  a = Sorting.insertionSort(array);
		for(int i=0;i<a.length;i++)
		{
			for(int j=i;j<a.length;j++)
			{
				int first = a[i];
				int second = a[j];
				int third = -(first+second);
				int k = Searching.binarySearch(a, third);
				if(k!=-1)
				{
					
					if((first<second) && (second<third))
					{
						count++;
					}
				}
			}
		}
		return count;
	}
}
