package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryCjhwfl {
    private Integer tb_dictionary_cjhwfl_id;

    private String cargo_id;

    private String cargo_type_code;

    private String cargo_name;

    private String cargo_alias;

    private String cargo_common_name;

    private String cargo_english_abbreviation;

    private String capacity_unit_code;

    public Integer getTb_dictionary_cjhwfl_id() {
        return tb_dictionary_cjhwfl_id;
    }

    public void setTb_dictionary_cjhwfl_id(Integer tb_dictionary_cjhwfl_id) {
        this.tb_dictionary_cjhwfl_id = tb_dictionary_cjhwfl_id;
    }

    public String getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(String cargo_id) {
        this.cargo_id = cargo_id == null ? null : cargo_id.trim();
    }

    public String getCargo_type_code() {
        return cargo_type_code;
    }

    public void setCargo_type_code(String cargo_type_code) {
        this.cargo_type_code = cargo_type_code == null ? null : cargo_type_code.trim();
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name == null ? null : cargo_name.trim();
    }

    public String getCargo_alias() {
        return cargo_alias;
    }

    public void setCargo_alias(String cargo_alias) {
        this.cargo_alias = cargo_alias == null ? null : cargo_alias.trim();
    }

    public String getCargo_common_name() {
        return cargo_common_name;
    }

    public void setCargo_common_name(String cargo_common_name) {
        this.cargo_common_name = cargo_common_name == null ? null : cargo_common_name.trim();
    }

    public String getCargo_english_abbreviation() {
        return cargo_english_abbreviation;
    }

    public void setCargo_english_abbreviation(String cargo_english_abbreviation) {
        this.cargo_english_abbreviation = cargo_english_abbreviation == null ? null : cargo_english_abbreviation.trim();
    }

    public String getCapacity_unit_code() {
        return capacity_unit_code;
    }

    public void setCapacity_unit_code(String capacity_unit_code) {
        this.capacity_unit_code = capacity_unit_code == null ? null : capacity_unit_code.trim();
    }
}