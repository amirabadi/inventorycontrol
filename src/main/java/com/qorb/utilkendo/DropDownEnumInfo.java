package com.qorb.utilkendo;

public class DropDownEnumInfo {
    public DropDownEnumInfo(){}
    public DropDownEnumInfo(int id,String title){
        this.id=id;
        this.title=title;
    }
    private int id;
    private  String title;
    /********************getter&setter*********************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
