package com.mobiusVision.pojo.TbSubject;

public class TbSubjectQyMyyd {
    private Integer tb_subject_qy_myyd_id;

    private String year;

    private String month;

    private String entity_id;

    private String waybill_quantity;

    public Integer getTb_subject_qy_myyd_id() {
        return tb_subject_qy_myyd_id;
    }

    public void setTb_subject_qy_myyd_id(Integer tb_subject_qy_myyd_id) {
        this.tb_subject_qy_myyd_id = tb_subject_qy_myyd_id;
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

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id == null ? null : entity_id.trim();
    }

    public String getWaybill_quantity() {
        return waybill_quantity;
    }

    public void setWaybill_quantity(String waybill_quantity) {
        this.waybill_quantity = waybill_quantity == null ? null : waybill_quantity.trim();
    }
}