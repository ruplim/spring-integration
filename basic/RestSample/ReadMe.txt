GET    : http://localhost:8080/RestSample/emps/1
DELETE : http://localhost:8080/RestSample/emps/1
POST   : http://localhost:8080/RestSample/emps
PUT    : http://localhost:8080/RestSample/emps/1

GET (Search) : http://localhost:8080/RestSample/emps?startOffSet=1&endOffSet=202

a. JSON Format:
---------------
{
  "empId": "22",
  "empFirstName": "Stephen",
  "empLastName": "Brian",
  "empSsn": "342-452-0987",
  "spouse": {
    "name": "Heidi",
    "age": "43"
  }
}}


Content-Type    application/xml
Accept          application/xml

b. XML Format:
-------------------
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Employee xmlns="http://www.example.org/xsd/Employee">
    <EmpId>22</EmpId>
    <EmpFirstName>Stephen</EmpFirstName>
    <EmpLastName>Brian</EmpLastName>
    <EmpSsn>342-452-0987</EmpSsn>
    <Spouse>
        <Name>Heidi</Name>
        <Age>43</Age>
    </Spouse>
</Employee>
