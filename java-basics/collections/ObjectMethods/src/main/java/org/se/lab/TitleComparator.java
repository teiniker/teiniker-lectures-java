package org.se.lab;

import java.util.Comparator;

public class TitleComparator
    implements Comparator<Book>
{
    @Override
    public int compare(Book o1, Book o2)
    {
        System.out.println("TitleComparator.compare()");
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
