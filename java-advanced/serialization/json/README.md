# JavaScript Object Notation (JSON)

## JSON Format
JSON is a lightweight data-interchange format that is easy for
humans to read and write, and easy for machines to parse and generate.
It's widely used for **data exchange** in **web applications**, 
**APIs**, and **configuration files**. 

Syntax and Structure:

* **Data Types**: JSON supports several basic data types:
    * **Numbers**: Any numeric value, integer or floating-point. 
        
        _Examples:_ `123`, `10.5`

    * **Strings**: A sequence of zero or more Unicode characters,
        wrapped in double quotes. 
        
        _Example:_ `"Hello, world"`

    * **Booleans**: Either `true` or `false`.
    
    * **Null**: Represents a null value (null).

* **Arrays**: An ordered list of zero or more values, each 
    of which can be of any type. Arrays are enclosed in square
    brackets, and values are separated by commas.
        
    _Example:_ `["apple", "banana", "cherry"]`

* **Objects**: A collection of key-value pairs where the keys 
    are strings and the values can be any JSON data type. 
    Objects are denoted by curly braces with key-value pairs 
    separated by commas, and keys and values separated by a 
    colon.

    _Example:_ `{"name": "John", "age": 30}`

_Example:_ JSON document
```JSON
{
  "name": "Alice",
  "age": 25,
  "isStudent": false,
  "courses": ["Math", "Science", "Literature"],
  "address": {
    "street": "123 Maple St.",
    "city": "Anytown",
    "zip": "12345"
  },
  "phoneNumbers": null
}
```

This JSON object represents a person with several properties: 
a name, age, student status, a list of courses, a nested address 
object, and a null value for phone numbers.

## Jackson Library

Jackson is a suite of data-processing tools for Java (and the JVM platform), 
including the flagship streaming **JSON parser / generator** library, matching 
data-binding library (POJOs to and from JSON) and additional data format 
modules to process data encoded in Avro, BSON, CBOR, CSV, Smile, Java Properties, Protobuf, TOML, XML or YAML.

_Example_: Serialize an object into a String
```Java
	@Test
	public void testOrderToJsonString() throws IOException
	{
	    Order order = new Order(100, "001-20151020-007");
	    order.getLines().add(new OrderLine(101, 2, new Product(102, "Effective Java", 3336)));
	    order.getLines().add(new OrderLine(101, 2, new Product(103, "Design Patterns", 5280)));

        ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(order);
		System.out.println(jsonString);
	}
```

* An `Order` object is created with an order `ID` of `100` and an order 
    `number` of `"001-20151020-007"`. 
    Two `OrderLine` objects are added to the `Order` object using the 
    `getLines()` method.
    Each `OrderLine` represents a line item in the order, with a product 
    `ID`, `quantity`, and associated `Product` object.

* An `ObjectMapper` instance named mapper is created. This is from the 
    **Jackson library** and is used for serialization and deserialization 
    of Java objects to/from JSON.

* The `writeValueAsString()` method of the `ObjectMapper` is called to 
    serialize the Order object into a JSON string. This JSON string 
    represents the Order object in a serialized form.

_Example_: Deserialize an object from a String
```Java
	@Test
	public void testOrderFromJsonString() throws IOException
	{
		String jsonString = 
		"""
		{
		"id" : 100,
		"name" : "001-20151020-007",
		"lines" : 
		[ 
			{
				"id" : 101,
				"quantity" : 2,
				"product" : 
				{
					"id" : 102,
					"description" : "Effective Java",
					"price" : 3336
				}
			}, 
			{
				"id" : 101,
				"quantity" : 2,
				"product" : 
				{
					"id" : 103,
					"description" : "Design Patterns",
					"price" : 5280
				}
			} 
		]
		}	
		""";

        ObjectMapper mapper = new ObjectMapper();
    	Order order = mapper.readValue(jsonString, Order.class);

		Assert.assertEquals(100, order.getId());
		Assert.assertEquals("001-20151020-007", order.getName());
		Assert.assertEquals(2, order.getLines().size());
		Assert.assertEquals(101, order.getLines().get(0).getId());
		Assert.assertEquals(102, order.getLines().get(0).getProduct().getId());
	}
```

* A JSON string representing an `Order` object is declared and assigned 
    to the variable jsonString.
    The JSON string uses **multi-line text** `""" ... """` to represent 
    the JSON structure in a more readable format.

* An `ObjectMapper` instance named mapper is created. This is from the 
    Jackson library and is used for deserialization of JSON into Java 
    objects.

* The `readValue()` method of the `ObjectMapper` is called to deserialize 
    the JSON string into an `Order` object. The second argument `Order.class` 
    specifies the target class for deserialization.

With Jackson, developers can easily serialize Java objects into JSON format 
and deserialize JSON strings or files into Java objects, offering seamless 
integration between Java applications and **JSON-based web services**. 


## References

* [Jackson JSON Java Parser API Example Tutorial](https://www.digitalocean.com/community/tutorials/jackson-json-java-parser-api-example-tutorial)

* [Baeldung: Jackson JSON Tutorial](https://www.baeldung.com/jackson)
    * [Jackson Annotation Examples](https://www.baeldung.com/jackson-annotations)

* [Jackson Project Home](https://github.com/FasterXML/jackson)

*Egon Teiniker, 2024, GPL v3.0*