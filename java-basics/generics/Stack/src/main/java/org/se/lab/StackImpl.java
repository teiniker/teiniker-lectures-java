package org.se.lab;

public class StackImpl<E>
	implements Stack<E>
{
	private StackImpl.Node<E> stack = null;

	// Nested class
	private static class Node<E>
	{
		public Node(E value, Node next)
		{
			setValue(value);
			setNext(next);
		}

		public Node(E value)
		{
			this(value, null);
		}

		private E value;
		public E getValue()
		{
			return value;
		}
		public void setValue(E value)
		{
			this.value = value;
		}

		private Node next;
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node next)
		{
			this.next = next;
		}

	}

	public boolean isEmpty()
	{
		return stack == null;
	}

	@Override
	public void push(E value)
	{
		Node newNode = new Node(value);
	
		if(!isEmpty())
		{
			newNode.setNext(stack);
		}
		stack = newNode;
	}

	
	@Override
	public E pop()
	{
		if(isEmpty())
			return null;
		
		Node<E> tmp = stack;
		stack = tmp.getNext();
	
		return tmp.getValue();
	}

	@Override
	public E top()
	{
		if(isEmpty())
			return null;

		return stack.getValue();
	}

	@Override
	public int size()
	{
		if(isEmpty())
			return 0;
		
		int size = 1;
		Node<E> tmp = stack;
		while(tmp.getNext() != null)
		{
			size++;
			tmp = tmp.getNext();
		}
		
		return size;
	}
}
