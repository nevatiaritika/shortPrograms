
public class FixedArrayStackOfStrings 
{
	private int N=0;
	private String[] s;
	public FixedArrayStackOfStrings(int capacity)
	{
		s = new String[capacity];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public void push(String item)
	{
		s[N++]=item;
	}
	public String pop()
	{
		String item = s[--N];
		//Avoid loitering i.e. holding references even when not used.
		//now garbage collector will take care
		s[N]=null;
		return item;
	}
}

/*
 * 
 * For multiple object type implementations, what will you do? eg: StackofStrings, stackofints, stackofcars etc
 * 
 * Attempt 1: Create class for each type (tedious)
 * Attempt 2: Type cast (runtime errors if mismatch occurs)
 * Attempt 3: Java Generics using <> (compile time errors if mismatch occurs)
 * 
 * Here mismatch implies trying to store int in String or something similar :p
 */
