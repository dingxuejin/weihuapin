package com.mobiusVision.pojo.TbDictionary;

public class TbDictionarySw {
    private Integer tb_dictionary_sw_id;

    private String three_violations_content_code;

    private String three_violations_content;

    private String remark;

    public Integer getTb_dictionary_sw_id() {
        return tb_dictionary_sw_id;
    }

    public void setTb_dictionary_sw_id(Integer tb_dictionary_sw_id) {
        this.tb_dictionary_sw_id = tb_dictionary_sw_id;
    }

    public String getThree_violations_content_code() {
        return three_violations_content_code;
    }

    public void setThree_violations_content_code(String three_violations_content_code) {
        this.three_violations_content_code = three_violations_content_code == null ? null : three_violations_content_code.trim();
    }

    public String getThree_violations_content() {
        return three_violations_content;
    }

    public void setThree_violations_content(String three_violations_content) {
        this.three_violations_content = three_violations_content == null ? null : three_violations_content.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}