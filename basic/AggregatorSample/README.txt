This example shows the usage of Aggregator and Splitter

Below is the Use case.

1) Read message (<order>) from queue.

Input data
============
<?xml version="1.0" encoding="UTF-8"?>
<order xmlns="http://www.example.org/orders">
  <orderItem>
    <isbn>12333454443</isbn>
    <quantity>4</quantity>
  </orderItem>
  <orderItem>
    <isbn>545656777</isbn>
    <quantity>50</quantity>
  </orderItem>
..
..
</order>

One order message will contain 'n' orderItem. The value of 'n' is not fixed. 

After processing we should implement the below:
a) Each orderitem (nested under Order) should be written to a file.
b) 5 such files should be written to a unique folder.

FileContent
===========


<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<order xmlns="http://www.example.org/orders">
  <orderItem>
    <isbn>4</isbn>
    <quantity>40</quantity>
  </orderItem>
</order>


Note:
====
1. Execute the tables.sql to store the aggregator data. The script is for Oracle DB.
   link::  https://github.com/spring-projects/spring-integration/tree/master/spring-integration-jdbc/src/main/resources/org/springframework/integration/jdbc  

2. OrderItemType has to implement Serializable as it is stored in DB.
