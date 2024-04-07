package org.se.lab;

public final class ObjectTuple
{
    // Constructor
    public ObjectTuple(Object a, Object b)
    {
        if(a == null || b == null)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    // First element of the 2-tuple
    private final Object a;
    public Object getFirstElement()
    {
        return a;
    }
    
    // Second element of the 2-tuple
    private final Object b;
    public Object getSecondElement()
    {
        return b;
    }

    @Override
    public String toString()
    {
        return "(" + a + "," + b + ")";
    }
}
