package com.mobiusVision.pojo.TbSubject;

public class TbSubjectDydslMonth {
    private Integer tb_subject_dydsl_month_id;

    private String driver_ID;

    private String year;

    private String month;

    private String waybill_Quantity;

    private String capacity_Unit_Code;

    private String volume;

    private String loaded_Km;

    public Integer getTb_subject_dydsl_month_id() {
        return tb_subject_dydsl_month_id;
    }

    public void setTb_subject_dydsl_month_id(Integer tb_subject_dydsl_month_id) {
        this.tb_subject_dydsl_month_id = tb_subject_dydsl_month_id;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID == null ? null : driver_ID.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getWaybill_Quantity() {
        return waybill_Quantity;
    }

    public void setWaybill_Quantity(String waybill_Quantity) {
        this.waybill_Quantity = waybill_Quantity == null ? null : waybill_Quantity.trim();
    }

    public String getCapacity_Unit_Code() {
        return capacity_Unit_Code;
    }

    public void setCapacity_Unit_Code(String capacity_Unit_Code) {
        this.capacity_Unit_Code = capacity_Unit_Code == null ? null : capacity_Unit_Code.trim();
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getLoaded_Km() {
        return loaded_Km;
    }

    public void setLoaded_Km(String loaded_Km) {
        this.loaded_Km = loaded_Km == null ? null : loaded_Km.trim();
    }
}