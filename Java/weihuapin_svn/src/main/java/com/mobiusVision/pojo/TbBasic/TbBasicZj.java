package com.mobiusVision.pojo.TbBasic;

public class TbBasicZj {
    private Integer tb_basic_zj_id;

    private String driver_ID;

    private String certificate_type_code;

    private String certificate_Number;

    private String initialCollection_Date;

    private String effective_Date;

    private String expire_Date;

    private String valid_Period;

    private String issuing_Authority;

    private String allow_Driving_Type_Code;

    private String file_No;

    private String certificateAbbreviation;

    private String certificate_status_code;

    private String photo;

    public Integer getTb_basic_zj_id() {
        return tb_basic_zj_id;
    }

    public void setTb_basic_zj_id(Integer tb_basic_zj_id) {
        this.tb_basic_zj_id = tb_basic_zj_id;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID == null ? null : driver_ID.trim();
    }

    public String getCertificate_type_code() {
        return certificate_type_code;
    }

    public void setCertificate_type_code(String certificate_type_code) {
        this.certificate_type_code = certificate_type_code == null ? null : certificate_type_code.trim();
    }

    public String getCertificate_Number() {
        return certificate_Number;
    }

    public void setCertificate_Number(String certificate_Number) {
        this.certificate_Number = certificate_Number == null ? null : certificate_Number.trim();
    }

    public String getInitialCollection_Date() {
        return initialCollection_Date;
    }

    public void setInitialCollection_Date(String initialCollection_Date) {
        this.initialCollection_Date = initialCollection_Date == null ? null : initialCollection_Date.trim();
    }

    public String getEffective_Date() {
        return effective_Date;
    }

    public void setEffective_Date(String effective_Date) {
        this.effective_Date = effective_Date == null ? null : effective_Date.trim();
    }

    public String getExpire_Date() {
        return expire_Date;
    }

    public void setExpire_Date(String expire_Date) {
        this.expire_Date = expire_Date == null ? null : expire_Date.trim();
    }

    public String getValid_Period() {
        return valid_Period;
    }

    public void setValid_Period(String valid_Period) {
        this.valid_Period = valid_Period == null ? null : valid_Period.trim();
    }

    public String getIssuing_Authority() {
        return issuing_Authority;
    }

    public void setIssuing_Authority(String issuing_Authority) {
        this.issuing_Authority = issuing_Authority == null ? null : issuing_Authority.trim();
    }

    public String getAllow_Driving_Type_Code() {
        return allow_Driving_Type_Code;
    }

    public void setAllow_Driving_Type_Code(String allow_Driving_Type_Code) {
        this.allow_Driving_Type_Code = allow_Driving_Type_Code == null ? null : allow_Driving_Type_Code.trim();
    }

    public String getFile_No() {
        return file_No;
    }

    public void setFile_No(String file_No) {
        this.file_No = file_No == null ? null : file_No.trim();
    }

    public String getCertificateAbbreviation() {
        return certificateAbbreviation;
    }

    public void setCertificateAbbreviation(String certificateAbbreviation) {
        this.certificateAbbreviation = certificateAbbreviation == null ? null : certificateAbbreviation.trim();
    }

    public String getCertificate_status_code() {
        return certificate_status_code;
    }

    public void setCertificate_status_code(String certificate_status_code) {
        this.certificate_status_code = certificate_status_code == null ? null : certificate_status_code.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}