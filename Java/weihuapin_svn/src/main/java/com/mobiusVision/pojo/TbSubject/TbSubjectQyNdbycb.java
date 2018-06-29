package com.mobiusVision.pojo.TbSubject;
//年度保养成本
public class TbSubjectQyNdbycb {
    private Integer tb_subject_qy_ndbycb_id;
    private String year ;
    private String entity_id;
    private String maintain_times;
    private String maintain_cost;
    private String maintaintimes_tenthousand_km;
    private String maintaincost_tenthousand_km	;
    private String maintaincost_per_waybill;
    private String million_turnover_cost;

    public Integer getTb_subject_qy_ndbycb_id() {
        return tb_subject_qy_ndbycb_id;
    }

    public void setTb_subject_qy_ndbycb_id(Integer tb_subject_qy_ndbycb_id) {
        this.tb_subject_qy_ndbycb_id = tb_subject_qy_ndbycb_id;
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

    public String getMaintain_times() {
        return maintain_times;
    }

    public void setMaintain_times(String maintain_times) {
        this.maintain_times = maintain_times;
    }

    public String getMaintain_cost() {
        return maintain_cost;
    }

    public void setMaintain_cost(String maintain_cost) {
        this.maintain_cost = maintain_cost;
    }

    public String getMaintaintimes_tenthousand_km() {
        return maintaintimes_tenthousand_km;
    }

    public void setMaintaintimes_tenthousand_km(String maintaintimes_tenthousand_km) {
        this.maintaintimes_tenthousand_km = maintaintimes_tenthousand_km;
    }

    public String getMaintaincost_tenthousand_km() {
        return maintaincost_tenthousand_km;
    }

    public void setMaintaincost_tenthousand_km(String maintaincost_tenthousand_km) {
        this.maintaincost_tenthousand_km = maintaincost_tenthousand_km;
    }

    public String getMaintaincost_per_waybill() {
        return maintaincost_per_waybill;
    }

    public void setMaintaincost_per_waybill(String maintaincost_per_waybill) {
        this.maintaincost_per_waybill = maintaincost_per_waybill;
    }

    public String getMillion_turnover_cost() {
        return million_turnover_cost;
    }

    public void setMillion_turnover_cost(String million_turnover_cost) {
        this.million_turnover_cost = million_turnover_cost;
    }
}
