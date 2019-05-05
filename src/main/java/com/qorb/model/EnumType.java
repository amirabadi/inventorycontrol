package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_EnumType")
public class EnumType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENUMTYPE_SEQ")
    @SequenceGenerator(sequenceName = "enumtype_seq", allocationSize = 1, name = "ENUMTYPE_SEQ")
    private int idEnumType;
    private  String title;
    private String code;
    private Date insertDate;
    private Date updateDate;
    @OneToMany( mappedBy = "enumType",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EnumInfo> enums;



    /***************************getter&&setter*************************/

    public int getIdEnumType() {
        return idEnumType;
    }

    public void setIdEnumType(int idEnumType) {
        this.idEnumType = idEnumType;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
