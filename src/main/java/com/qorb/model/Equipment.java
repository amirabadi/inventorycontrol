package com.qorb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by amirabadi-h on 12/11/2018.
 */
@Entity
@Table(name = "tb_equipment")
public class Equipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPMENT_SEQ")
    @SequenceGenerator(sequenceName = "equipmentt_seq", allocationSize = 1, name = "EQUIPMENT_SEQ")
    private int idEquipment;
    //private item
    private String pelakNo;
    private String malekiatId;
    private BigDecimal price;
    private String productYear;
    private String countryId;
    private String stateId;
    private String amvalNo;
    private String usefullLife;
    /*******************************getter&&setter*******************************/
    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getPelakNo() {
        return pelakNo;
    }

    public void setPelakNo(String pelakNo) {
        this.pelakNo = pelakNo;
    }

    public String getMalekiatId() {
        return malekiatId;
    }

    public void setMalekiatId(String malekiatId) {
        this.malekiatId = malekiatId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getAmvalNo() {
        return amvalNo;
    }

    public void setAmvalNo(String amvalNo) {
        this.amvalNo = amvalNo;
    }

    public String getUsefullLife() {
        return usefullLife;
    }

    public void setUsefullLife(String usefullLife) {
        this.usefullLife = usefullLife;
    }
}
