package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListUtils
{    
    public static <T> List<T> asList(T... in)
    {
        List<T> out = new ArrayList<T>();        
        for(T t : in)
        {
            out.add(t);
        }        
        return out;
    }
        

    public static double sum(List<? extends Number> numbers)
    {
        double sum = 0.0;
        for(Number n : numbers)
        {
            sum += n.doubleValue();
        }
        return sum;
    }


    public static void fill(List<? super Integer> list, int n)
    {
        for(int i = 0; i<n; i++)
        {
            list.add(i);
        }
    }


    public static <T> void copy(List<? extends T> src, List<? super T> dest)
    {
        for(int i = 0; i<src.size(); i++)
        {
            dest.add(src.get(i));
        }
    }
}
