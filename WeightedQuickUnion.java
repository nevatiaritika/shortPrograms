/*
 * Implementation of Weighted Quick Union
 * 
 * Same as Quick Union, only that we merge the smaller tree into the bigger
 * 
 * Running time:
 * find: time proportional to depth of elements
 * union: constant time given the roots
 * 
 * Running time:
 * initialize - n
 * find: log n
 * union; log n
 */


public class WeightedQuickUnion
{
static int[] nodes;
static int[] size;
	
	WeightedQuickUnion(int n)
	{
		nodes = new int[n];
		size = new int[n];
		for(int i=0;i<n;i++)
		{
			nodes[i]=i;
			size[i]=1;
		}
	}
	
	public static void union(int a, int b)
	{
		if(size[a]>size[b])
		{
			nodes[root(a)]=root(b);
			size[b]+=size[a];
		}
		else
		{
			nodes[root(b)]=root(a);
			size[a]+=size[b];
		}
	}
	
	public static boolean connected(int a, int b)
	{
		if(root(a)==root(b))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int root(int a)
	{
		//returns main root of a node
		int temp = nodes[a];
		while(temp!=nodes[temp])
		{
			temp = nodes[temp];
		}
		
		return temp;
	}
	
	public static void main(String args[])
	{
		WeightedQuickUnion qu = new WeightedQuickUnion(10);
		for(int i=0;i<nodes.length;i++)
		{
			System.out.print(qu.nodes[i]);
		}
		System.out.println();
		union(4,3);
		union(3,8);
		union(6,5);
		union(9,4);
		union(2,1);
		System.out.println(connected(8,9));
		System.out.println(connected(5,4));
		union(5,0);
		union(7,2);
		union(6,1);
		union(7,3);
		System.out.println(connected(5,4));
		System.out.println(connected(1,4));
		System.out.println(connected(7,3));
		System.out.println(connected(2,7));
		//626466244
		for(int i=0;i<nodes.length;i++)
		{
			System.out.print(qu.nodes[i]);
		}
	}
}
