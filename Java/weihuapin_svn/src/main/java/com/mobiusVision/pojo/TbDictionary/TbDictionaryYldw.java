package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryYldw {
    private Integer tb_dictionary_yldw_id;

    private String capacity_unit_code;

    private String capacity_unit;

    private String remark;

    public Integer getTb_dictionary_yldw_id() {
        return tb_dictionary_yldw_id;
    }

    public void setTb_dictionary_yldw_id(Integer tb_dictionary_yldw_id) {
        this.tb_dictionary_yldw_id = tb_dictionary_yldw_id;
    }

    public String getCapacity_unit_code() {
        return capacity_unit_code;
    }

    public void setCapacity_unit_code(String capacity_unit_code) {
        this.capacity_unit_code = capacity_unit_code == null ? null : capacity_unit_code.trim();
    }

    public String getCapacity_unit() {
        return capacity_unit;
    }

    public void setCapacity_unit(String capacity_unit) {
        this.capacity_unit = capacity_unit == null ? null : capacity_unit.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}