package com.mobiusVision.pojo.TbBusiness;

public class TbBusinessTj {
    private Integer tb_business_tj_id;

    private String driver_ID;

    private String date;

    private String year;

    private String month;

    private String day;

    private String physical_examination_results;

    public Integer getTb_business_tj_id() {
        return tb_business_tj_id;
    }

    public void setTb_business_tj_id(Integer tb_business_tj_id) {
        this.tb_business_tj_id = tb_business_tj_id;
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

    public String getPhysical_examination_results() {
        return physical_examination_results;
    }

    public void setPhysical_examination_results(String physical_examination_results) {
        this.physical_examination_results = physical_examination_results == null ? null : physical_examination_results.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}