/*
 * Implementation of Quick Union
 * 
 * Each entry in array represents its parent in the connected tree
 * 
 * union() unites two nodes into one connected component tree
 * find() finds if two nodes belong to same connected component
 * 
 * Running time:
 * Initialize - n
 * find - n
 * union - n
 *  
 */


public class QuickUnion 
{
	static int[] nodes;
	
	QuickUnion(int n)
	{
		nodes = new int[n];
		for(int i=0;i<n;i++)
		{
			nodes[i]=i;
		}
	}
	
	public static void union(int a, int b)
	{
		nodes[root(b)]=root(a);
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
		QuickUnion qu = new QuickUnion(10);
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
		for(int i=0;i<nodes.length;i++)
		{
			System.out.print(qu.nodes[i]);
		}
		System.out.println();
		
		
	}
}
