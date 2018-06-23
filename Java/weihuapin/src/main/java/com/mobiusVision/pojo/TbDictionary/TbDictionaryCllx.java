package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryCllx {
    private Integer tb_dictionary_cllx_id;

    private String vehicle_category_code;

    private String vehicle_category;

    private String vehicle_type_code;

    private String vehicle_type;

    private String remark;

    public Integer getTb_dictionary_cllx_id() {
        return tb_dictionary_cllx_id;
    }

    public void setTb_dictionary_cllx_id(Integer tb_dictionary_cllx_id) {
        this.tb_dictionary_cllx_id = tb_dictionary_cllx_id;
    }

    public String getVehicle_category_code() {
        return vehicle_category_code;
    }

    public void setVehicle_category_code(String vehicle_category_code) {
        this.vehicle_category_code = vehicle_category_code == null ? null : vehicle_category_code.trim();
    }

    public String getVehicle_category() {
        return vehicle_category;
    }

    public void setVehicle_category(String vehicle_category) {
        this.vehicle_category = vehicle_category == null ? null : vehicle_category.trim();
    }

    public String getVehicle_type_code() {
        return vehicle_type_code;
    }

    public void setVehicle_type_code(String vehicle_type_code) {
        this.vehicle_type_code = vehicle_type_code == null ? null : vehicle_type_code.trim();
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type == null ? null : vehicle_type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}