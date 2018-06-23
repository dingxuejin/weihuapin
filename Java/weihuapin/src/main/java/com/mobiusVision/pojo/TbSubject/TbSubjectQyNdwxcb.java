package com.mobiusVision.pojo.TbSubject;
//年度维修成本表
public class TbSubjectQyNdwxcb {
    private Integer tb_subject_qy_ndwxcb_id;
    private String year;
    private String entity_id;
    private String repair_times;
    private String repair_cost;
    private String repairtimes_tenthousand_km;
    private String repaircost_tenthousand_km;
    private String repaircost_per_waybill;
    private String million_turnover_cost;

    public Integer getTb_subject_qy_ndwxcb_id() {
        return tb_subject_qy_ndwxcb_id;
    }

    public void setTb_subject_qy_ndwxcb_id(Integer tb_subject_qy_ndwxcb_id) {
        this.tb_subject_qy_ndwxcb_id = tb_subject_qy_ndwxcb_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getRepair_times() {
        return repair_times;
    }

    public void setRepair_times(String repair_times) {
        this.repair_times = repair_times;
    }

    public String getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(String repair_cost) {
        this.repair_cost = repair_cost;
    }

    public String getRepairtimes_tenthousand_km() {
        return repairtimes_tenthousand_km;
    }

    public void setRepairtimes_tenthousand_km(String repairtimes_tenthousand_km) {
        this.repairtimes_tenthousand_km = repairtimes_tenthousand_km;
    }

    public String getRepaircost_tenthousand_km() {
        return repaircost_tenthousand_km;
    }

    public void setRepaircost_tenthousand_km(String repaircost_tenthousand_km) {
        this.repaircost_tenthousand_km = repaircost_tenthousand_km;
    }

    public String getRepaircost_per_waybill() {
        return repaircost_per_waybill;
    }

    public void setRepaircost_per_waybill(String repaircost_per_waybill) {
        this.repaircost_per_waybill = repaircost_per_waybill;
    }

    public String getMillion_turnover_cost() {
        return million_turnover_cost;
    }

    public void setMillion_turnover_cost(String million_turnover_cost) {
        this.million_turnover_cost = million_turnover_cost;
    }
}
