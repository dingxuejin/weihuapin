package com.mobiusVision.pojo.TbBusiness;

public class TbBusinessPx {
    private Integer tb_business_px_id;

    private String driver_ID;

    private String training_Type_Code;

    private String training_Theme_Code;

    private String year;

    private String month;

    private String day;

    private String start_Time;

    private String end_Time;

    private String training_Location;

    private String training_Content;

    private String training_Hours;

    private String training_Result_Code;

    private String training_Institution;

    private String certificateNumber;

    public Integer getTb_business_px_id() {
        return tb_business_px_id;
    }

    public void setTb_business_px_id(Integer tb_business_px_id) {
        this.tb_business_px_id = tb_business_px_id;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID == null ? null : driver_ID.trim();
    }

    public String getTraining_Type_Code() {
        return training_Type_Code;
    }

    public void setTraining_Type_Code(String training_Type_Code) {
        this.training_Type_Code = training_Type_Code == null ? null : training_Type_Code.trim();
    }

    public String getTraining_Theme_Code() {
        return training_Theme_Code;
    }

    public void setTraining_Theme_Code(String training_Theme_Code) {
        this.training_Theme_Code = training_Theme_Code == null ? null : training_Theme_Code.trim();
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

    public String getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(String start_Time) {
        this.start_Time = start_Time == null ? null : start_Time.trim();
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time == null ? null : end_Time.trim();
    }

    public String getTraining_Location() {
        return training_Location;
    }

    public void setTraining_Location(String training_Location) {
        this.training_Location = training_Location == null ? null : training_Location.trim();
    }

    public String getTraining_Content() {
        return training_Content;
    }

    public void setTraining_Content(String training_Content) {
        this.training_Content = training_Content == null ? null : training_Content.trim();
    }

    public String getTraining_Hours() {
        return training_Hours;
    }

    public void setTraining_Hours(String training_Hours) {
        this.training_Hours = training_Hours == null ? null : training_Hours.trim();
    }

    public String getTraining_Result_Code() {
        return training_Result_Code;
    }

    public void setTraining_Result_Code(String training_Result_Code) {
        this.training_Result_Code = training_Result_Code == null ? null : training_Result_Code.trim();
    }

    public String getTraining_Institution() {
        return training_Institution;
    }

    public void setTraining_Institution(String training_Institution) {
        this.training_Institution = training_Institution == null ? null : training_Institution.trim();
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }
}