package org.se.lab;

public abstract class DataEntity
{
    // Constructor
    public DataEntity(String id, String title)
    {
        this.id = id;
        this.title = title;
    }

    // Property: id:String
    private String id;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

     // Property: title:String
    private String title;
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }


    // Abstract methods
    public abstract String toCsv();

    // Object methods
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}
