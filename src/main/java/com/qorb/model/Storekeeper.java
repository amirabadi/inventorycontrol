package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amirabadi-h on 09/22/2018.
 */
@Entity
@Table(name = "tb_Storekeeper")
/*@NamedQueries({
        @NamedQuery(name="Storekeeper.getAllBasedOrganizationUser",query = "select s from Storekeeper s where s.organizationStorekeeper.uniquePath like :uniquePath and s.event<>'DELETE'"),
        @NamedQuery(name="Storekeeper.findById",query="select s from Storekeeper s where s.storekeeperId=:id")})*/
public class Storekeeper implements Serializable {
    @Id
    @Column(name = "storekeeperId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOREKEEPER_SEQ")
    @SequenceGenerator(sequenceName = "storekeeper_seq", allocationSize = 1, name = "STOREKEEPER_SEQ")
    private int storekeeperId;
    @ManyToOne
    @JoinColumn(name = "organizationStorekeeper", referencedColumnName = "idUnit")
    @JsonIgnore
    private Unit organizationStorekeeper;
    @ManyToOne
    @JoinColumn(name="store",referencedColumnName = "storeId")
    @JsonIgnore
    private Store store;
    private String storekeeperName;
    private Boolean enabled;
    private String updateDate;
    private String userUpdate;
    private String createDate;
    private String userCreate;
    /**************************************************getter&&setter******************************************************/
    public int getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(int storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public Unit getOrganizationStorekeeper() {
        return organizationStorekeeper;
    }

    public void setOrganizationStorekeeper(Unit organizationStorekeeper) {
        this.organizationStorekeeper = organizationStorekeeper;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
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

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
}
