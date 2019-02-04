package learn.avinash.rabbitmq.rabbitmqtestconsumer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Employee {
    @JsonProperty("employee_idd")
    private String employeeId;
    private String name;
    @JsonProperty("birth_date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Jakarta")
    private Date birthDate;
    public Employee(){
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Employee(String employeeId, String name, Date birthDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
