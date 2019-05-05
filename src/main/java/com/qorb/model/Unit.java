package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "tb_Unit")
public class Unit  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIT_SEQ")
    @SequenceGenerator(sequenceName = "unit_seq", allocationSize = 1, name = "UNIT_SEQ")
    private int idUnit;
    //@Type(type = "org.hibernate.type.StringNVarcharType")
    private String unitName;
    private boolean active;
    private Date insertDate;
    private Date updateDate;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent",nullable=true)
    @JsonIgnore
    private Unit parent;
    @OneToMany( mappedBy = "unit",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> userSet;
    @OneToMany( mappedBy = "orgEquityReceiver",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EquityReceiver> equityReceivers;
    @OneToMany( mappedBy = "orgPropertyLiasion",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PropertyLiasion> propertyLiasions;
    @OneToMany( mappedBy = "organizationStore",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Store> stores;
    @OneToMany( mappedBy = "organizationStorekeeper",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Storekeeper> storekeepers;
    @JsonIgnore
    @OneToMany(mappedBy = "parent",fetch = FetchType.EAGER)
    private List<Unit> units;
    @Transient
    public Boolean getHasUnits() {
        return !getUnits().isEmpty();
    }



    /***************************getter&&setter*************************/
    public int getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Unit getParent() {
        return parent;
    }

    public void setParent(Unit parent) {
        this.parent = parent;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public List<Unit> getUnits() {
        return units;
    }

}
