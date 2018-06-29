package com.mobiusVision.pojo.TbDictionary;

public class TbDictionarySgzr {
    private Integer tb_dictionary_sgzr_id;

    private String accident_responsibility_code;

    private String accident_responsibility;

    private String remark;

    public Integer getTb_dictionary_sgzr_id() {
        return tb_dictionary_sgzr_id;
    }

    public void setTb_dictionary_sgzr_id(Integer tb_dictionary_sgzr_id) {
        this.tb_dictionary_sgzr_id = tb_dictionary_sgzr_id;
    }

    public String getAccident_responsibility_code() {
        return accident_responsibility_code;
    }

    public void setAccident_responsibility_code(String accident_responsibility_code) {
        this.accident_responsibility_code = accident_responsibility_code == null ? null : accident_responsibility_code.trim();
    }

    public String getAccident_responsibility() {
        return accident_responsibility;
    }

    public void setAccident_responsibility(String accident_responsibility) {
        this.accident_responsibility = accident_responsibility == null ? null : accident_responsibility.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}