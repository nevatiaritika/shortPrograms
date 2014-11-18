import java.util.Random;


public class Shuffling 
{
	public static void main(String args[])
	{
		int[] x = {1,2,3,5,6,7,8,8,10};
		x = knuthShuffle(x);
		Sorting.printArray(x);
	}
	
	public static int[] knuthShuffle(int[] x)
	{
		Random rand = new Random();
		for(int i=0;i<x.length;i++)
		{
			int r = rand.nextInt(i+1);
			//swap the random and ith value
			int temp = x[r];
			x[r]=x[i];
			x[i]=temp;
		}
		return x;
	}
}
