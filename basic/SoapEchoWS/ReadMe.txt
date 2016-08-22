This example is a simple SOAP based web service. It echo's the request ( payload + soap header).

To populate elements in the reply class CustomHeaderMapper is defined and it overrrides populateUserDefinedHeader. 
Also note definition of the bean, we need to pass requestHeaderNames and replyHeaderNames

<bean id="customMapper" class="com.samples.CustomHeaderMapper">
      <property name="requestHeaderNames" value="*"/>
      <property name="replyHeaderNames"   value="*"/>
</bean>   


Note::: To reply (echo) complex header elements (elements containing Child) advance logic needs to be implemented.    
Check the SoapHeader available in javax.xml.soap.SOAPHeader
     
WSDL is accessible by ::  http://localhost:8080/SoapEchoWS/empservice.wsdl
endpoint ::   http://localhost:8080/SoapEchoWS/{anycontext}

SOAP Request:
================
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:emp="http://www.example.org/xsd/Employee">
   <soapenv:Header region="ord">
     <sessionkey xmlns="auth.key">RWE2334JH5JH55555KF8U9GN</sessionkey>
     <userkey xmlns="auth.user">rb123</userkey>
   </soapenv:Header>
   <soapenv:Body>
      <emp:Employee>
         <emp:EmpId>1</emp:EmpId>
         <emp:EmpFName>2</emp:EmpFName>
         <emp:EmpLName>3</emp:EmpLName>
         <emp:EmpEligibility>40</emp:EmpEligibility>
      </emp:Employee>
   </soapenv:Body>
</soapenv:Envelope>