//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.29 at 03:31:37 PM CDT 
//


package com.samples.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmpId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmpFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmpLastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmpSsn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Spouse" type="{http://www.example.org/RestSample/Employee}SpouseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "empId",
    "empFirstName",
    "empLastName",
    "empSsn",
    "spouse"
})
@XmlRootElement(name = "Employee")
public class Employee {

    @XmlElement(name = "EmpId", required = true)
    protected String empId;
    @XmlElement(name = "EmpFirstName", required = true)
    protected String empFirstName;
    @XmlElement(name = "EmpLastName", required = true)
    protected String empLastName;
    @XmlElement(name = "EmpSsn", required = true)
    protected String empSsn;
    @XmlElement(name = "Spouse", required = true)
    protected SpouseType spouse;

    /**
     * Gets the value of the empId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Sets the value of the empId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpId(String value) {
        this.empId = value;
    }

    /**
     * Gets the value of the empFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpFirstName() {
        return empFirstName;
    }

    /**
     * Sets the value of the empFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpFirstName(String value) {
        this.empFirstName = value;
    }

    /**
     * Gets the value of the empLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpLastName() {
        return empLastName;
    }

    /**
     * Sets the value of the empLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpLastName(String value) {
        this.empLastName = value;
    }

    /**
     * Gets the value of the empSsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpSsn() {
        return empSsn;
    }

    /**
     * Sets the value of the empSsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpSsn(String value) {
        this.empSsn = value;
    }

    /**
     * Gets the value of the spouse property.
     * 
     * @return
     *     possible object is
     *     {@link SpouseType }
     *     
     */
    public SpouseType getSpouse() {
        return spouse;
    }

    /**
     * Sets the value of the spouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpouseType }
     *     
     */
    public void setSpouse(SpouseType value) {
        this.spouse = value;
    }

}
