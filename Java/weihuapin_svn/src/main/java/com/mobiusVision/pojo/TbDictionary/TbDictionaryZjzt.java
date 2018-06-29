package com.mobiusVision.pojo.TbDictionary;

public class TbDictionaryZjzt {
    private Integer tb_dictionary_zjzt_id;

    private String certificate_status_code;

    private String certificate_status;

    private String remark;

    public Integer getTb_dictionary_zjzt_id() {
        return tb_dictionary_zjzt_id;
    }

    public void setTb_dictionary_zjzt_id(Integer tb_dictionary_zjzt_id) {
        this.tb_dictionary_zjzt_id = tb_dictionary_zjzt_id;
    }

    public String getCertificate_status_code() {
        return certificate_status_code;
    }

    public void setCertificate_status_code(String certificate_status_code) {
        this.certificate_status_code = certificate_status_code == null ? null : certificate_status_code.trim();
    }

    public String getCertificate_status() {
        return certificate_status;
    }

    public void setCertificate_status(String certificate_status) {
        this.certificate_status = certificate_status == null ? null : certificate_status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}