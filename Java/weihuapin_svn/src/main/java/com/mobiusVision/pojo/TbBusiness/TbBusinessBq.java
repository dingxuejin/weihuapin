package com.mobiusVision.pojo.TbBusiness;

public class TbBusinessBq {
    private Integer tb_business_bq_id;

    private String driver_ID;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    private String year;

    private String month;

    private String day;

    private String label_content;

    private String label_source;

    public Integer getTb_business_bq_id() {
        return tb_business_bq_id;
    }

    public void setTb_business_bq_id(Integer tb_business_bq_id) {
        this.tb_business_bq_id = tb_business_bq_id;
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

    public String getLabel_content() {
        return label_content;
    }

    public void setLabel_content(String label_content) {
        this.label_content = label_content == null ? null : label_content.trim();
    }

    public String getLabel_source() {
        return label_source;
    }

    public void setLabel_source(String label_source) {
        this.label_source = label_source == null ? null : label_source.trim();
    }
}