package com.mobiusVision.pojo.TbDictionary;

public class TbDictionarySfxl {
    private Integer tb_dictionary_sfxl_id;

    private String if_hm_release_code;

    private String if_hm_release;

    private String remark;

    public Integer getTb_dictionary_sfxl_id() {
        return tb_dictionary_sfxl_id;
    }

    public void setTb_dictionary_sfxl_id(Integer tb_dictionary_sfxl_id) {
        this.tb_dictionary_sfxl_id = tb_dictionary_sfxl_id;
    }

    public String getIf_hm_release_code() {
        return if_hm_release_code;
    }

    public void setIf_hm_release_code(String if_hm_release_code) {
        this.if_hm_release_code = if_hm_release_code == null ? null : if_hm_release_code.trim();
    }

    public String getIf_hm_release() {
        return if_hm_release;
    }

    public void setIf_hm_release(String if_hm_release) {
        this.if_hm_release = if_hm_release == null ? null : if_hm_release.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}