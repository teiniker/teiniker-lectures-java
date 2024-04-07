package org.se.lab;

public class StackImpl
	implements Stack
{
	private StackImpl.Node stack = null;

	// Nested class
	private static class Node
	{
		public Node(Integer value, Node next)
		{
			setValue(value);
			setNext(next);
		}

		public Node(Integer value)
		{
			this(value, null);
		}

		private Integer value;
		public Integer getValue()
		{
			return value;
		}
		public void setValue(Integer value)
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
	public void push(Integer value)
	{
		Node newNode = new Node(value);
	
		if(!isEmpty())
		{
			newNode.setNext(stack);
		}
		stack = newNode;
	}

	
	@Override
	public Integer pop()
	{
		if(isEmpty())
			return null;
		
		Node tmp = stack;
		stack = tmp.getNext();
	
		return tmp.getValue();
	}

	@Override
	public Integer top()
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
		Node tmp = stack;
		while(tmp.getNext() != null)
		{
			size++;
			tmp = tmp.getNext();
		}
		
		return size;
	}
}
