package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_Object")
public class ObjectProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBJECTPROJECT_SEQ")
    @SequenceGenerator(sequenceName = "objectproject_seq", allocationSize = 1, name = "OBJECTPROJECT_SEQ")
    private int idObjectProject;
    private String objectName;
    private Date insertDate;
    private Date updateDate;

    @OneToMany(mappedBy = "objectProject")
    @JsonIgnore
    private Set<Permission> permissions;
    /***************************getter&&setter*************************/

    public int getIdObjectProject() {
        return idObjectProject;
    }

    public void setIdObjectProject(int idObjectProject) {
        this.idObjectProject = idObjectProject;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
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
