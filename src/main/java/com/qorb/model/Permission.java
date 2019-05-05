package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "tb_Permission")
@Transactional
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_SEQ")
    @SequenceGenerator(sequenceName = "permission_seq", allocationSize = 1, name = "PERMISSION_SEQ")
    @Column(name = "idPermission")
    private int idPermission;
    @ManyToOne
    @JoinColumn(name = "objectProject",referencedColumnName = "idObjectProject",nullable = false)
    @JsonIgnore
    private ObjectProject objectProject;
    @ManyToOne
    @JoinColumn(name = "enum", referencedColumnName = "idEnum", nullable = false)
    @JsonIgnore
    private EnumInfo anEnum;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "idRole", nullable = false)
    @JsonIgnore
    private Role role;


    private Date insertDate;
    private Date updateDate;
    @Transient
    private int idEnum;
    @Transient
    private int idRole;
    @Transient
    private int idObjectProject;

    /***************************getter&&setter*************************/

    public int getIdEnum() {
        return anEnum.getIdEnum();
    }

    public void setIdEnum(int idEnum) {
        this.idEnum = idEnum;
    }

    public int getIdRole() {
        return role.getIdRole();
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdObjectProject() {
        return objectProject.getIdObjectProject();
    }

    public void setIdObjectProject(int idObjectProject) {
        this.idObjectProject = idObjectProject;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public ObjectProject getObjectProject() {
        return objectProject;
    }

    public void setObjectProject(ObjectProject objectProject) {
        this.objectProject = objectProject;
    }

    public EnumInfo getAnEnum() {
        return anEnum;
    }

    public void setAnEnum(EnumInfo anEnum) {
        this.anEnum = anEnum;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
