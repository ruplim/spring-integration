GET
=====

URI:  http://localhost:8080/RestSample/emps/1

a. JSON Output:
---------------
{
  "empId": "1",
  "empFirstName": "Stephen",
  "empLastName": "Brian",
  "spouse": {
    "name": "Heidi",
    "age": "43"
  }
}


Content-Type    application/xml
Accept          application/xml

b. XML Output:
-------------------
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Employee xmlns="http://www.example.org/xsd/Employee">
    <EmpId>1</EmpId>
    <EmpFirstName>Stephen</EmpFirstName>
    <EmpLastName>Brian</EmpLastName>
    <Spouse>
        <Name>Heidi</Name>
        <Age>43</Age>
    </Spouse>
</Employee>

