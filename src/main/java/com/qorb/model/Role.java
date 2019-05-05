package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_Role")
@Transactional
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(sequenceName = "role_seq", allocationSize = 1, name = "ROLE_SEQ")
    private int idRole;
    private String roleName;
    private String roleNamePersian;
    private Date insertDate;
    private Date updateDate;
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(FetchMode.SELECT)
    private Set<Permission> permissionSet;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<User> user=new HashSet<>();

    /***************************getter&&setter*************************/
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNamePersian() {
        return roleNamePersian;
    }

    public void setRoleNamePersian(String roleNamePersian) {
        this.roleNamePersian = roleNamePersian;
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

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }
}
