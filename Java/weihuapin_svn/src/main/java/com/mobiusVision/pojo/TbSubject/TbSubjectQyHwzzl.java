package com.mobiusVision.pojo.TbSubject;

public class TbSubjectQyHwzzl {
    private Integer tb_subject_qy_hwzzl_id;

    private String year;

    private String month;

    private String entity_id;

    private String turnover;

    public Integer getTb_subject_qy_hwzzl_id() {
        return tb_subject_qy_hwzzl_id;
    }

    public void setTb_subject_qy_hwzzl_id(Integer tb_subject_qy_hwzzl_id) {
        this.tb_subject_qy_hwzzl_id = tb_subject_qy_hwzzl_id;
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

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover == null ? null : turnover.trim();
    }
}