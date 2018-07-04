package com.mobiusVision.pojo.TbBusiness;

/**
 * @Author: zhangzhirong
 * @Description:人员运单相关统计
 * @Date:Created in 17:36 2018/6/29/029
 * @Modify By:
 **/
public class TbSubjectXlzbTjXxExtends{

    //时间
    private String year;
    private String month;

    //运单量
    private Double waybill_quantity;
    //平均运单量
    private Double avg_waybill_quantity;

    //周转量
    private Double turnover;
    //平均周转量
    private Double avg_turnover;

    //平均油耗
    private Double average_fuel_cost;
    //线路标准油耗
    private Double standard_oil_use;
    //车队平均油耗
    private Double fleet_average_fuel_cost;
    //公司平均油耗
    private Double company_average_fuel_cost;

    //平均驾驶时长
    private Double average_driving_time;
    //线路标准时长
    private Double standard_time;
    //车队平均驾驶时长
    private Double fleet_average_driving_time;
    //公司平均驾驶时长
    private Double company_average_driving_time;

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

    public Double getWaybill_quantity() {
        return waybill_quantity;
    }

    public void setWaybill_quantity(Double waybill_quantity) {
        this.waybill_quantity = waybill_quantity;
    }

    public Double getAvg_waybill_quantity() {
        return avg_waybill_quantity;
    }

    public void setAvg_waybill_quantity(Double avg_waybill_quantity) {
        this.avg_waybill_quantity = avg_waybill_quantity;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getAvg_turnover() {
        return avg_turnover;
    }

    public void setAvg_turnover(Double avg_turnover) {
        this.avg_turnover = avg_turnover;
    }

    public Double getAverage_fuel_cost() {
        return average_fuel_cost;
    }

    public void setAverage_fuel_cost(Double average_fuel_cost) {
        this.average_fuel_cost = average_fuel_cost;
    }

    public Double getStandard_oil_use() {
        return standard_oil_use;
    }

    public void setStandard_oil_use(Double standard_oil_use) {
        this.standard_oil_use = standard_oil_use;
    }

    public Double getFleet_average_fuel_cost() {
        return fleet_average_fuel_cost;
    }

    public void setFleet_average_fuel_cost(Double fleet_average_fuel_cost) {
        this.fleet_average_fuel_cost = fleet_average_fuel_cost;
    }

    public Double getCompany_average_fuel_cost() {
        return company_average_fuel_cost;
    }

    public void setCompany_average_fuel_cost(Double company_average_fuel_cost) {
        this.company_average_fuel_cost = company_average_fuel_cost;
    }

    public Double getAverage_driving_time() {
        return average_driving_time;
    }

    public void setAverage_driving_time(Double average_driving_time) {
        this.average_driving_time = average_driving_time;
    }

    public Double getStandard_time() {
        return standard_time;
    }

    public void setStandard_time(Double standard_time) {
        this.standard_time = standard_time;
    }

    public Double getFleet_average_driving_time() {
        return fleet_average_driving_time;
    }

    public void setFleet_average_driving_time(Double fleet_average_driving_time) {
        this.fleet_average_driving_time = fleet_average_driving_time;
    }

    public Double getCompany_average_driving_time() {
        return company_average_driving_time;
    }

    public void setCompany_average_driving_time(Double company_average_driving_time) {
        this.company_average_driving_time = company_average_driving_time;
    }
}
