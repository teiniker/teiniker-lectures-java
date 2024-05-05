# Extensible Markup Language (XML)

XML is a flexible, structured markup language used in the encoding of documents and data. 
It was designed to be both human-readable and machine-readable, making it a popular choice 
for **data representation and exchange**, particularly in **web services**, 
**configuration files**, and data interchange between various applications.

Key Features of XML
* **Structured Data**: XML allows you to define your own tags (markup symbols) that are used 
to organize and label pieces of data in a hierarchical format, which is both structured 
and customizable.
* **Text-Based**: XML data is stored in plain text format. This makes it easy to create 
and edit with any text editor and ensures that it can be read by both humans and machines.
* **Self-Descriptive**: XML documents can be designed to be self-descriptive; the tags 
themselves often describe the data they contain.
* **Support for Namespaces**: XML supports namespaces, allowing the same document to contain 
XML elements and attributes drawn from multiple vocabularies without naming conflicts.

An **XML document** consists of elements, nested within each other, 
forming a **tree-like structure**. 

Here is what you typically find in an XML document:
* **Prolog**: This is optional, but when used, it typically contains 
  the XML declaration which specifies the XML version and the 
  character encoding used in the document. 
  
  _Example_: `<?xml version="1.0" encoding="UTF-8"?>`

* **Root Element**: Every XML document must contain a single root 
  element that encloses all other elements.
* **Child Elements**: Nested inside parent elements, child elements 
  can contain text, other elements, or a mix of both.
* **Attributes**: Elements can have attributes in name-value pairs, 
  providing additional information about elements.
* **Text**: The actual data content of elements.

_Example:_ XML document
```XML
<?xml version="1.0" encoding="UTF-8"?>
<library>
    <book id="1">
        <title>Introduction to XML</title>
        <author>John Doe</author>
        <year>2021</year>
        <price>39.95</price>
    </book>
    <book id="2">
        <title>Advanced XML Features</title>
        <author>Jane Smith</author>
        <year>2023</year>
        <price>49.95</price>
    </book>
</library>
```

In this example:

* `<?xml version="1.0" encoding="UTF-8"?>` is the XML declaration.
* `<library>` is the root element.
* `<book>`, `<title>`, `<author>`, `<year>`, and `<price>` are 
  child elements.
* The `id` in the `<book>` element is an attribute.


## JAXB (Java Architecture for XML Binding)

JAXB is a framework that allows Java developers to map Java objects to XML representations. 
JAXB makes it easier to **convert XML into Java objects** and **Java objects back into XML**, 
which is particularly useful when working with web services or storing and retrieving data 
in XML format.

Key Features of JAXB:

* **Marshalling**: Converts Java objects into XML. This process is used when you need to send 
  data as XML, such as in web service communication or when writing to XML files.
* **Unmarshalling**: Converts XML into Java objects. This is useful for reading XML data received 
  from external sources or files and converting them into usable Java objects.
* **Annotations**: JAXB uses annotations to define how Java classes relate to XML structures. 
For instance, `@XmlElement` and `@XmlAttribute` are used to denote XML elements and attributes, 
respectively.
* **Schema Generation**: JAXB can generate an XML schema from Java classes which can be used to 
validate XML files.

JAXB is particularly useful in applications involving web services, where you need to exchange 
data in XML format. For example, in a SOAP-based web service, JAXB can be used to handle the 
conversion of service data into XML requests and responses automatically.

_Example:_ Marshalling Java objects into XML
```Java
  @Test
  public void testWriteOrder() throws JAXBException, IOException
  {
      Order order = new Order(100, "001-20151020-007");
      order.getLines().add(new OrderLine(101, 2, new Product(102, "Effective Java", 3336)));
      order.getLines().add(new OrderLine(101, 2, new Product(103, "Design Patterns", 5280)));

      JAXBContext context = JAXBContext.newInstance(Order.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      Writer out = new StringWriter();
      marshaller.marshal(order, out);
      out.close();            
      String xml = out.toString();
      System.out.println(xml);
  }
```

_Example:_ Unmarshalling XML back into Java objects
```Java
  @Test
  public void testReadOrder() 
    throws SAXException, JAXBException, FileNotFoundException
  {
      Source src = new StreamSource(new FileReader(new File("src/test/resources/xml", "order.xml")));
      Unmarshaller unmarshaller = context.createUnmarshaller();
      JAXBElement<Order> element = unmarshaller.unmarshal(src, Order.class);
      Order order = element.getValue();

      Assert.assertEquals("001-20151020-007", order.getName());
  }
```

## References


*Egon Teiniker, 2024, GPL v3.0*