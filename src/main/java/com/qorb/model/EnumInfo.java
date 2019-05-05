package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_EnumInfo")
@Transactional
public class EnumInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDENUM_SEQ")
    @SequenceGenerator(sequenceName = "idenum_seq", allocationSize = 1, name = "IDENUM_SEQ")
    private int idEnum;
    private  String title;
    @ManyToOne
    @JoinColumn(name = "enumType", referencedColumnName = "idEnumType", nullable = false)
    @JsonIgnore
    private EnumType enumType;
    private String code;
    private Date insertDate;
    private Date updateDate;
    @OneToMany( mappedBy = "anEnum",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Permission> permissions;


    /***************************getter&&setter*************************/
    public int getIdEnum() {
        return idEnum;
    }

    public void setIdEnum(int idEnum) {
        this.idEnum = idEnum;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EnumType getEnumType() {
        return enumType;
    }

    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
