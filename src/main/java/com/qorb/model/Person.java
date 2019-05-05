package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_seq", allocationSize = 1, name = "PERSON_SEQ")
    private int idPerson;
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String name;
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String lastName;
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String nationalCode;
    private Date insertDate;
    private Date updateDate;
    @OneToMany( mappedBy = "person",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> userSet;


    /***************************getter&&setter*************************/
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
