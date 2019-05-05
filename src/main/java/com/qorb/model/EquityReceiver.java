package com.qorb.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amirabadi-h on 09/12/2018.
 */
@Entity
@Table(name = "tb_equityreceiver")
public class EquityReceiver implements Serializable{
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUITYRECEIVER_SEQ")
    @SequenceGenerator(sequenceName = "equityreceiver_seq", allocationSize = 1, name = "EQUITYRECEIVER_SEQ")
    private Integer id;
    private String aminName;
    private String entesabDate;
    private Boolean enabled;

    private String updateDate;
    private String createDate;
    private String userCreate;
    @ManyToOne
    @JoinColumn(name = "orgEquityReceiver", referencedColumnName = "idUnit", nullable = true)
    private Unit orgEquityReceiver;
    private String userUpdate;
    /**********************************************getter&&setter*************************************/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAminName() {
        return aminName;
    }

    public void setAminName(String aminName) {
        this.aminName = aminName;
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

    public Unit getOrgEquityReceiver() {
        return orgEquityReceiver;
    }

    public void setOrgEquityReceiver(Unit orgEquityReceiver) {
        this.orgEquityReceiver = orgEquityReceiver;
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
