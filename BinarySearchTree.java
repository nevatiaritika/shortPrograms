
public class BinarySearchTree<Key extends Comparable<Key>,Value> 
{
	private Node root;
	private class Node
	{
		Key key;
		Value value;
		Node left, right;
		public Node(Key key, Value value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	public void put(Key key, Value value)
	{
		root = put(root, key, value);
	}
	public Node put(Node x, Key key, Value value)
	{
		if(x==null)
		{
			return new Node(key, value);
		}
		int cmp = key.compareTo(x.key);
		if(cmp>0)
		{
			
		}
		else if(cmp<0)
		{
			x.left = put(x.left, key, value);
		}
		else
		{
			x.value = value;
		}
		return x;
	}
	public Value get(Key key)
	{
		Node x = root;
		while(x!=null)
		{
			int cmp = key.compareTo(x.key);
			if(cmp>0)
			{
				x=x.right;
			}
			else if(cmp<0)
			{
				x=x.left;
			}
			else
			{
				return x.value;
			}
		}
		return null;
	}
	public void delete(Key key)
	{
		
	}
	
}
