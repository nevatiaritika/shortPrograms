
public class LinkedQueueOfStrings 
{
	private Node first,last;
	private class Node
	{
		String item;
		Node next;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public void enqueue(String s)
	{
		Node oldLast = last;
		last=new Node();
		last.item=s;
		last.next=null;
		if(isEmpty())
			first=last;
		else
			oldLast.next = last;
	}
	public String dequeue()
	{
		String item = first.item;
		first=first.next;
		if(isEmpty())
			last=null;
		return item;
	}
}
