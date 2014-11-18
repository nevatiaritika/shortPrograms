
public class ResizingArrayStackOfStrings 
{
	private String[] s;
	private int N=0;
	public ResizingArrayStackOfStrings(int capacity)
	{
		s = new String[capacity];
	}
	public void push(String item)
	{
		if(N==s.length)
			resize(2*s.length);
		s[N++]=item;
	}
	public String pop()
	{
		String item = s[--N];
		s[N]=null;
		if(N>0 && N==s.length/4)
		{
			resize(s.length/2);
		}
		return item;
	}
	public void resize(int l)
	{
		String[] copy = new String[l];
		for(int i=0;i<s.length;i++)
		{
			copy[i]=s[i];
		}
		s=copy;
	}
}

/*
 * LINKED LIST v/s RESZING ARRAY:
 * Linked list: Every operation takes constant time but space used is more (for storing linked representation)
 * Array: Overall amortized time is taken but space used is less
 */
