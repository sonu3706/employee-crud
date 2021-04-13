package com.employee.app.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    @Column(name = "id")
    private BigInteger id;
    @Column(name = "airst_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
}
