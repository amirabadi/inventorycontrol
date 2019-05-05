package com.qorb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by amirabadi-h on 09/22/2018.
 */
@Entity
@Table(name = "tb_Store")
/*@NamedQueries({
        @NamedQuery(name="Store.getAllBasedOrganizationUser",query = "select s from Store s where s.organizationStore.uniquePath like :uniquePath and s.event<>'DELETE'"),
@NamedQuery(name="Store.findById",query="select s from Store s where s.storeId=:id")})*/
public class Store implements Serializable {
    @Id
    @Column(name = "storeId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ")
    @SequenceGenerator(sequenceName = "store_seq", allocationSize = 1, name = "STORE_SEQ")
    private int storeId;
    @ManyToOne
    @JoinColumn( name="organizationStore", referencedColumnName = "idUnit")
    @JsonIgnore
    private Unit organizationStore;
    private String storeName;
    private String storeCode;
    private String provinceId;
    private String cityId;
    private String part;
    private String region;
    private String exporter;
    private String imoprter;
    @Column(length = 512)
    private String address;
    private String attachmentType;
    private Boolean enabled;
    private String updateDate;
    private String createDate;
    private String userCreate;
    private String userUpdate;
    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Storekeeper> storekeeperSet;
    /**************************************************getter&&setter******************************************************/
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getExporter() {
        return exporter;
    }

    public void setExporter(String exporter) {
        this.exporter = exporter;
    }

    public String getImoprter() {
        return imoprter;
    }

    public void setImoprter(String imoprter) {
        this.imoprter = imoprter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
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

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
}
