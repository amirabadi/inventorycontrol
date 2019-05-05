package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_User")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
    private int idUser;
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String userName;
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String password;
    private Date insertDate;
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "unit", referencedColumnName = "idUnit", nullable = true)
    @JsonIgnore
    private Unit unit;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="person",referencedColumnName = "idPerson",nullable = true)
    private Person person;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_User_Role",
            joinColumns = { @JoinColumn(name = "idRole") },
            inverseJoinColumns = { @JoinColumn(name = "idUser") }
    )
    @JsonManagedReference
    private Set<Role> roles=new HashSet<>();

    /***************************getter&&setter*************************/

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(roles.size());

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            role.getPermissionSet().stream()
                    .map(p -> new SimpleGrantedAuthority(p.getAnEnum().getTitle()+"/"+p.getObjectProject().getObjectName()))
                    .forEach(authorities::add);
        }
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
