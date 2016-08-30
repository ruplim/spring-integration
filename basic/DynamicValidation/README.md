This example shows Dynamic Validation implementation.  The code supports 3 types of messages - <order> 

Valid payload
===============

1. 
<?xml version="1.0" encoding="UTF-8"?>
<order xmlns="urn:com:samples:order.001">
		<isbn>0321200683</isbn>
		<quantity>2</quantity>
</order>


2.
<?xml version="1.0" encoding="UTF-8"?>
<order xmlns="urn:com:samples:order.002">
		<isbn>0321200683</isbn>
		<quantity>2</quantity>
		<author>Mark</author>
</order>


3.
<?xml version="1.0" encoding="UTF-8"?>
<order xmlns="urn:com:samples:order.003">
		<isbn>0321200683</isbn>
		<quantity>2</quantity>
		<publisher>Oreilly</publisher>
</order>


Upon successful validation the message is processed by OrderProcessor. The failures are processed by OrderExceptionHandler.

Notes:
----
1. Need to use MessageConverter in the inbound JMS queue to convert to Document.
   else   class org.springframework.xml.transform.StringSource is passed to OrderXmlValidator.validate() and it fails to get namespace.
   
2. Use DefaultXmlPayloadConverter to convert the payload to Document


   

