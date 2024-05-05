# Date Time API

Java's Date Time API, introduced in Java 8, provides a comprehensive 
set of classes for handling date and time values. 
It addresses the shortcomings of the older `java.util.Date` and 
`java.util.Calendar` classes by offering better clarity, immutability, 
and thread safety.

The main components of the Java Date Time API:

* **LocalDate**: Represents a date without a time component. 
    It stores year, month, and day of the month values.

* **LocalTime**: Represents a time without a date component. 
    It stores hour, minute, second, and nanosecond values.

* **LocalDateTime**: Represents both date and time without a timezone. 
    It combines LocalDate and LocalTime. 

* **ZonedDateTime**: Represents a date and time with a timezone. 
    It extends `LocalDateTime` by adding a timezone offset.

* **Instant**: Represents a point in time in UTC timezone. 
    It's used for machine-readable timestamps. 

* **Duration**: Represents a time-based amount, such as 
    "2 hours" or "30 seconds". 
    It's used for measuring time spans.

* **Period**: Represents a date-based amount, such as 
    "2 months" or "3 days". 
    It's used for measuring date intervals.

These are the core classes provided by the Java Date Time API. 
They offer various methods for manipulation, formatting, and 
conversion of date and time values, making it easier to work 
with date and time in Java applications.


## References

* Java API: 
    * [Class LocalDate](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDate.html)
    * [Class LocalTime](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalTime.html)
    * [Class LocalDateTime](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html)
    * [Class ZonedDateTime](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/ZonedDateTime.html)
    * [Class Instant](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Instant.html)
    * [Class Duration](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Duration.html)
    * [Class Period](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Period.html)

* [Baeldung: Introduction to the Java 8 Date/Time API](https://www.baeldung.com/java-8-date-time-intro)

*Egon Teiniker, 2024, GPL v3.0*