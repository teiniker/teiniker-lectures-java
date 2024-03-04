package org.se.lab;

/**
 * The <code>Stack</code> interface defines a subset of the operations related 
 * to a last-in-first-out (LIFO) data structure.
 * Based on this interface, different implementation strategies can be used to
 * realize this data structure.
 * <p>
 * Because this stack is only used for education purposes, it is restricted to 
 * a single element type - <code>Integer</code>.
 * 
 * @see java.util.Stack  
 *   
 * @author  Egon Teiniker
 * @version 1.0.0
 */
public interface Stack
{
	/**
	 * Pushes a value onto the top of this stack.
	 * 
	 * @param   value   the value to be pushed onto this stack.
     * @throws  IllegalArgumentException if the argument is a null pointer.
	 */
	void push(Integer value);
	
	
	/**
	 * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack or <code>null</code> 
     * if the stack is empty.
	 */
	Integer pop();

	
	/**
	 * Returns the actual number of elements stored in the stack.
	 * 
	 * @return number of elements.
	 */
	int size();
	
	
	/**
	 * Create a new <code>Stack</code> instance from a hidden implementation
	 * class. 
	 *
	 * @return a new instance of a <code>Stack</code> object.
	 */
	static Stack newInstance()
	{
		return new StackImpl();
	}
}
