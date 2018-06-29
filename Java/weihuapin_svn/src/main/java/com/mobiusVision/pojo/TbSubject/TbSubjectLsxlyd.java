package com.mobiusVision.pojo.TbSubject;

public class TbSubjectLsxlyd {
    private Integer tb_subject_lsxlyd_id;

    private String driver_ID;

    private String route_id;

    //增加线路名称
    private String route_name;

    private String waybill_Quantity;

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public Integer getTb_subject_lsxlyd_id() {
        return tb_subject_lsxlyd_id;
    }

    public void setTb_subject_lsxlyd_id(Integer tb_subject_lsxlyd_id) {
        this.tb_subject_lsxlyd_id = tb_subject_lsxlyd_id;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID == null ? null : driver_ID.trim();
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id == null ? null : route_id.trim();
    }

    public String getWaybill_Quantity() {
        return waybill_Quantity;
    }

    public void setWaybill_Quantity(String waybill_Quantity) {
        this.waybill_Quantity = waybill_Quantity == null ? null : waybill_Quantity.trim();
    }
}