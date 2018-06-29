package com.mobiusVision.pojo.TbSubject;

/**
 * @Author: zhangzhirong
 * @Description:行驶里程、重车里程、空车里程、空重里程比
 * @Date:Created in 13:44 2018/6/28/028
 * @Modify By:
 **/
public class TbSubjectYRxslc {
    private String year;
    private String month;
    private String day;

    //总
    private Double total_km;
    private Double loaded_km;
    private Double empty_km;
    private Double empty_loaded_rate;

    //平均
    private Double avg_total_km;
    private Double avg_loaded_km;
    private Double avg_empty_km;
    private Double avg_empty_loaded_rate;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getTotal_km() {
        return total_km;
    }

    public void setTotal_km(Double total_km) {
        this.total_km = total_km;
    }

    public Double getLoaded_km() {
        return loaded_km;
    }

    public void setLoaded_km(Double loaded_km) {
        this.loaded_km = loaded_km;
    }

    public Double getEmpty_km() {
        return empty_km;
    }

    public void setEmpty_km(Double empty_km) {
        this.empty_km = empty_km;
    }

    public Double getEmpty_loaded_rate() {
        return empty_loaded_rate;
    }

    public void setEmpty_loaded_rate(Double empty_loaded_rate) {
        this.empty_loaded_rate = empty_loaded_rate;
    }

    public Double getAvg_total_km() {
        return avg_total_km;
    }

    public void setAvg_total_km(Double avg_total_km) {
        this.avg_total_km = avg_total_km;
    }

    public Double getAvg_loaded_km() {
        return avg_loaded_km;
    }

    public void setAvg_loaded_km(Double avg_loaded_km) {
        this.avg_loaded_km = avg_loaded_km;
    }

    public Double getAvg_empty_km() {
        return avg_empty_km;
    }

    public void setAvg_empty_km(Double avg_empty_km) {
        this.avg_empty_km = avg_empty_km;
    }

    public Double getAvg_empty_loaded_rate() {
        return avg_empty_loaded_rate;
    }

    public void setAvg_empty_loaded_rate(Double avg_empty_loaded_rate) {
        this.avg_empty_loaded_rate = avg_empty_loaded_rate;
    }
}
