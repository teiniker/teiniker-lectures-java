package org.se.lab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClassAlaysis
{
    private Class<?> clazz;
    public TestClassAlaysis(Class<?> clazz)
    {
        this.clazz = clazz;
    }

    public List<String> getTestMethods()
    {
        Method[] testMethods = clazz.getDeclaredMethods();
        List<String> tests = new ArrayList<>();
        for(Method m: testMethods)
        {
            if (m.isAnnotationPresent(Test.class))
                tests.add(m.getName());
        }
        return tests;
    }

    public boolean hasBefore()
    {
        return hasAnnotation(Before.class);
    }

    public boolean hasAfter()
    {
        return hasAnnotation(After.class);
    }

    public boolean hasTest()
    {
        return hasAnnotation(Test.class);
    }

    private boolean hasAnnotation(Class<? extends Annotation> annotation)
    {
        Method[] testMethods = clazz.getDeclaredMethods();
        for(Method m: testMethods)
        {
            if(m.isAnnotationPresent(annotation))
                return true;
        }
        return false;
    }
}
