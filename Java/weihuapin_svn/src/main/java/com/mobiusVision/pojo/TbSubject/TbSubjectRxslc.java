package com.mobiusVision.pojo.TbSubject;

public class TbSubjectRxslc {
    private Integer tb_subject_rxslc_id;

    private String driver_ID;

    private String year;

    private String month;

    private String day;

    private String empty_KM;

    private String loaded_KM;

    public Integer getTb_subject_rxslc_id() {
        return tb_subject_rxslc_id;
    }

    public void setTb_subject_rxslc_id(Integer tb_subject_rxslc_id) {
        this.tb_subject_rxslc_id = tb_subject_rxslc_id;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getEmpty_KM() {
        return empty_KM;
    }

    public void setEmpty_KM(String empty_KM) {
        this.empty_KM = empty_KM == null ? null : empty_KM.trim();
    }

    public String getLoaded_KM() {
        return loaded_KM;
    }

    public void setLoaded_KM(String loaded_KM) {
        this.loaded_KM = loaded_KM == null ? null : loaded_KM.trim();
    }
}