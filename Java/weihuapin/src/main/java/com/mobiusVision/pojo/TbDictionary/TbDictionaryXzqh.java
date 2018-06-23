package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryXzqh {
    private Integer tb_dictionary_xzqh_id;

    private String admin_code;

    private String admin_name;

    public Integer getTb_dictionary_xzqh_id() {
        return tb_dictionary_xzqh_id;
    }

    public void setTb_dictionary_xzqh_id(Integer tb_dictionary_xzqh_id) {
        this.tb_dictionary_xzqh_id = tb_dictionary_xzqh_id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code == null ? null : admin_code.trim();
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name == null ? null : admin_name.trim();
    }
}