package org.se.lab;

public interface Stack<E>
{
	void push(E value);
	E pop();
	E top();
	boolean isEmpty();
	int size();
}
