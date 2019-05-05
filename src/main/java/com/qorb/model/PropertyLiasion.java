package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amirabadi-h on 09/12/2018.
 */
@Entity
@Table(name="tb_propertyLiasion")
/*@NamedQueries({
        @NamedQuery(name = "PropertyLiasion.getAll",query = "select e from PropertyLiasion e"),
        @NamedQuery(name="PropertyLiasion.getAllBasedOrganization",query="select e from PropertyLiasion e where e.orgPropertyLiasion.uniquePath like :uniquePath")
})*/
public class PropertyLiasion implements Serializable{
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROPERTYLIASION_SEQ")
    @SequenceGenerator(sequenceName = "propertyliasion_seq", allocationSize = 1, name = "PROPERTYLIASION_SEQ")
    private int id;
    private String rabetName;
    private String entesabDate;
    private Boolean enabled;
    private String updateDate;
    private String createDate;
    private String userCreate;
    @ManyToOne
    @JoinColumn(name="propertyLiasions",referencedColumnName = "idUnit",nullable = true)
    @JsonIgnore
    private Unit orgPropertyLiasion;
    private String userUpdate;
    /**************************************getter&&setter**************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRabetName() {
        return rabetName;
    }

    public void setRabetName(String rabetName) {
        this.rabetName = rabetName;
    }

    public String getEntesabDate() {
        return entesabDate;
    }

    public void setEntesabDate(String entesabDate) {
        this.entesabDate = entesabDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Unit getOrgPropertyLiasion() {
        return orgPropertyLiasion;
    }

    public void setOrgPropertyLiasion(Unit orgPropertyLiasion) {
        this.orgPropertyLiasion = orgPropertyLiasion;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
}
