package org.se.lab.instantiation;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GenericFactory
{
		
	//	public static <E> E createElement()
	//	{
	//		// Error: cannot instantiate the type E!
	//		E e = new E();
	//		return e;
	//	}

	public static <E> E createElement(Class<E> elementType)
	{
		try
		{
			E element = elementType.getDeclaredConstructor().newInstance();
			return element;
		}
		catch(NoSuchMethodException | InvocationTargetException
			  | InstantiationException | IllegalAccessException e)
		{
			throw new IllegalArgumentException("Can't create new Instance!", e);
		}
	}
	
	
	public static <E> List<E> createList(E element, int number)
	{
		List<E> list = new ArrayList<E>();
		for(int i = 0; i<number; i++)
			list.add(element);
		return list;
	}
	

	//	public static <E> E[] fillArray(E element, int number)
	//	{
	//		// Error: cannot create a generic array of E!
	//		E[] array = new E[number];
	//		for(int i = 0; i<number; i++)
	//			array[i] = element;
	//		return array;		
	//	}
	
	@SuppressWarnings("unchecked")
	public static <E> E[] createArray(Class<E> elementType, E element, int number)
	{
		E[] array = (E[])Array.newInstance(elementType, number);
		for(int i = 0; i<number; i++)
			array[i] = element;
		return array;		
	}	
}
