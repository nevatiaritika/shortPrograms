package jp.co.wap.exam;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
 * @param <E>
 */
public class ImmutableQueue<E> {
	/**
	 * ImmutableStack for implementing ImmutableQueue
	 * @param <E>
	 */

	private ImmutableStack<E> original;
	private ImmutableStack<E> reverse;

	private static class ImmutableStack<E>
	{
		private E first;
		private ImmutableStack<E> last;
		private int size;

		//default constructor
		private ImmutableStack()
		{
			this.first = null;
			this.last = null;
			this.size = 0;
		}

		//default constructor with parameters
		private ImmutableStack(E e, ImmutableStack<E> last)
		{
			this.first = e;
			this.last = last;
			this.size = last.size + 1;
		}

		/**
		*create empty stack
		*/
		@SuppressWarnings("rawtypes")
		public static ImmutableStack createStack()
		{
			return new ImmutableStack();
		}

		/**
		 * Reverse the Stack
		 * @return reversed stack
		 */
		public ImmutableStack<E> reverseStack() 
		{
			ImmutableStack<E> stack = new ImmutableStack<E>();
			ImmutableStack<E> last = this;
			while (!last.isEmpty()) 
			{
				stack = stack.push(last.first);
				last = last.last;
			}
			return stack;
		}

		/**
		*@return true if stack empty
		*/
		public boolean isEmpty() 
		{
			return this.size == 0;
		}

		/**
		*Push new element to stack
		*/
		public ImmutableStack<E> push(E e) 
		{
			return new ImmutableStack<E>(e, this);
		}
	}

	private ImmutableQueue(ImmutableStack<E> original, ImmutableStack<E> reverse) 
	{
		this.original = original;
		this.reverse = reverse;
	}
	
	/**
	 * requires default constructor.
	 */
	@SuppressWarnings("unchecked")
	public ImmutableQueue() 
	{
		this.original = ImmutableStack.createStack();
		this.reverse = ImmutableStack.createStack();
	}

	/** 
    * Returns the queue that adds an item into the tail of this queue without modifying this queue.         
    * <pre>         
    * e.g.         
    * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
    * this method returns a new queue (2, 1, 2, 2, 6, 4)         
    * and this object still represents the queue (2, 1, 2, 2, 6) .         
    * </pre>         
    * If the element e is null, throws IllegalArgumentException.         
    * @param e         
    * @return         
    * @throws IllegalArgumentException         
    */
	public ImmutableQueue<E> enqueue(E e) 
	{
		if (e == null)
		{
			throw new IllegalArgumentException();
		}
		ImmutableQueue<E> a = new ImmutableQueue<E>(this.original.push(e), this.reverse);
		return a;
	}

	/**         
	* Returns the queue that removes the object at the head of this queue without modifying this queue.         
	* <pre>         
	* e.g.         
	* When this queue represents the queue (7, 1, 3, 3, 5, 1) ,         
	* this method returns a new queue (1, 3, 3, 5, 1)         
	* and this object still represents the queue (7, 1, 3, 3, 5, 1) .         
	* </pre>         
	* If this queue is empty, throws java.util.NoSuchElementException.         
	* @return         
	* @throws java.util.NoSuchElementException         
	*/
	public ImmutableQueue<E> dequeue()
	{
		if (this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if (!this.reverse.isEmpty()) 
		{
			ImmutableQueue<E> a = new ImmutableQueue<E>(this.original, this.reverse.last);
			return a;
		} 
		else
		{
			@SuppressWarnings("unchecked")
			ImmutableQueue<E> a = new ImmutableQueue<E>(ImmutableStack.createStack(),this.original.reverseStack().last);
			return a;
		}
	}

	//reverse original stack without modifying internal queue
	@SuppressWarnings("unchecked")
	private void revrevQueue() 
	{
		this.reverse = this.original.reverseStack();
		this.original = ImmutableStack.createStack();
	}

	/**         
	* Looks at the object which is the head of this queue without removing it from the queue.         
	* <pre>         
	* e.g.         
	* When this queue represents the queue (7, 1, 3, 3, 5, 1),         
	* this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)         
	* </pre>         
	* If the queue is empty, throws java.util.NoSuchElementException.         
	* @return         
	* @throws java.util.NoSuchElementException         
	*/
	public E peek() 
	{
		if (this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		if (this.reverse.isEmpty())
		{
			revrevQueue();
		}
		return this.reverse.first;
	}

	/**
	*@return true if queue empty
	*/
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**         
	* Returns the number of objects in this queue.         
	* @return         
	*/   
	public int size() 
	{
		return this.original.size + this.reverse.size;
	}
}