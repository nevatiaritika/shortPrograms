
public class Sorting 
{
	public static void main(String ar[])
	{
		int[] array1 = {2,6,3,8,3,5,2,0};
		array1 = insertionSort(array1);
		printArray(array1);
		System.out.println();
		
		int[] array2 = {2,6,3,8,3,5,2,0};
		array2 = selectionSort(array2);
		printArray(array2);
		System.out.println();
		
		int[] array3 = {2,6,3,8,3,5,2,0};
		array3 = shellSort(array3);
		printArray(array3);
	}
	
	public static void merge(int[] a, int low, int mid,int high)
	{
		
	}
	
	public static int[] shellSort(int[] x)
	{
		int h=1;
		int n=x.length;
		while(h<n/3)
		{
			h = 3*h+1;
		}
		while(h>=1)
		{
			for(int i=0;i<n;i=i+h)
			{
				for(int j=0;j<i;j=j+h)
				{
					if(x[i]<x[j])
					{
						//swap(x[i],x[j]);
						int temp=x[i];
						x[i]=x[j];
						x[j]=temp;
					}
				}
			}
			h=h/3;
		}
		return x;
	}
	
	public static int[] insertionSort(int[] x)
	{
		for(int i=0; i<x.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(x[i]<x[j])
				{
					//swap(x[i],x[j]);
					int temp=x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
		}
		return x;
	}
	
	public static int[] selectionSort(int[] x)
	{
		for(int i=0;i<x.length-1;i++)
		{
			int min=i+1;
			for(int j=i+2;j<x.length;j++)
			{
				if(x[j]<x[min])
					min = j;
			}
			if(x[i]>x[min])
			{
				int temp = x[i];
				x[i]=x[min];
				x[min]=temp;
			}
		}
		return x;
	}
	
	public static void printArray(int[] x)
	{
		for(int i=0; i<x.length; i++)
		{
			System.out.print(x[i]+" ");
		}
	}
}

/*
 * 1. Selection sort is worst. (N^2 comparisions and N exchanges) 
 * 2. Insertion sort is a little better - partially sorted arrays takes linear time
 * 3. Shell sort - makes use of Insertion sort's partially sort property (worst case - N^3/2 comparisions)
 * 
 */
