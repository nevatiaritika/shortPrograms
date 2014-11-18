/*
 * Implementation of Quick Find
 * 
 * each entry in array is the component it belongs to
 * 
 * union() unites two nodes into one connected component
 * find() finds if two nodes belong to same connected component
 * 
 * Time complexity:
 * Initialize - n
 * Union - n
 * Find - 1
 * 
 * Defect - union is too slow
 * 
 */


import java.util.Scanner;


public class QuickFind 
{
	public static int n;
	public static int[] nodes = new int[n];
	
	QuickFind(int n)
	{
		//constructor
		this.n = n;
		this.nodes = new int[n];
		for(int i=0 ; i<n;i++)
		{
			nodes[i]=i;
		}
	}
	
	public static void main(String args[])
	{
		//System.out.println("Enter the number of elements:");
		//Scanner sc = new Scanner(System.in);
		//int x = sc.nextInt();
		QuickFind qf = new QuickFind(10);
		qf.union(1, 2);
		qf.union(2, 7);
		qf.union(1, 6);
		qf.union(5, 6);
		qf.union(0, 5);
		
		qf.union(3, 8);
		qf.union(4, 9);
		qf.union(3, 4);
		for(int i=0;i<n;i++)
		{
			System.out.println(qf.nodes[i]);
		}
		
		System.out.println(qf.connected(1,5));
		System.out.println(qf.connected(4,6));
		System.out.println(qf.connected(4,8));
		
		
	}
	
	public static void union(int a, int b)
	{
		//everything becomes b type
		int temp = nodes[a];
		int sec = nodes[b];
		for(int i=0;i<n;i++)
		{
			if(nodes[i]==temp)
			{
				nodes[i]=sec;
			}
		}
	}

	public static boolean connected(int a, int b)
	{
		if(nodes[a]==nodes[b])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
