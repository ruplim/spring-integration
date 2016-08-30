In this example the Content Enricher pattern is demostrated.  
This web service - SOAP based  can be invoked using http://localhost:8080/ContentEnricher

The payload is enriched from 2 endpoints - JMS and REST service .

1. JMS endpoint accepts empId as string and returns Emp Name as String
   Please see MultipleClient project for JMS implementation.

2. The Rest endpoint is available at  http://localhost:8080/RestSample/emps/{empId}
   Please check RestSample project for details.
   


 