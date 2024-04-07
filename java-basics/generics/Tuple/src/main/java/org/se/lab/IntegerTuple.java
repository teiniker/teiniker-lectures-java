package org.se.lab;

public final class IntegerTuple
{
    // Constructor
    public IntegerTuple(Integer a, Integer b)
    {
        if(a == null || b == null)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    // First element of the 2-tuple
    private final Integer a;
    public Integer getFirstElement()
    {
        return a;
    }
    
    // Second element of the 2-tuple
    private final Integer b;
    public Integer getSecondElement()
    {
        return b;
    }
    
    @Override
    public String toString()
    {
        return "(" + a + "," + b + ")";
    }
}
