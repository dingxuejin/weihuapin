package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryCpys {
    private Integer tb_dictionary_cpys_id;

    private String plate_color_code;

    private String plate_color;

    private String remark;

    public Integer getTb_dictionary_cpys_id() {
        return tb_dictionary_cpys_id;
    }

    public void setTb_dictionary_cpys_id(Integer tb_dictionary_cpys_id) {
        this.tb_dictionary_cpys_id = tb_dictionary_cpys_id;
    }

    public String getPlate_color_code() {
        return plate_color_code;
    }

    public void setPlate_color_code(String plate_color_code) {
        this.plate_color_code = plate_color_code == null ? null : plate_color_code.trim();
    }

    public String getPlate_color() {
        return plate_color;
    }

    public void setPlate_color(String plate_color) {
        this.plate_color = plate_color == null ? null : plate_color.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}