package com.mobiusVision.pojo.TbSubject;

public class TbSubjectQyCdwfysl {
    private Integer tb_subject_qy_cdwfysl_id;

    private String year;

    private String month;

    private String entity_id;

    private String drive_event_type_code;

    private String total_illegal_drive;

    public Integer getTb_subject_qy_cdwfysl_id() {
        return tb_subject_qy_cdwfysl_id;
    }

    public void setTb_subject_qy_cdwfysl_id(Integer tb_subject_qy_cdwfysl_id) {
        this.tb_subject_qy_cdwfysl_id = tb_subject_qy_cdwfysl_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id == null ? null : entity_id.trim();
    }

    public String getDrive_event_type_code() {
        return drive_event_type_code;
    }

    public void setDrive_event_type_code(String drive_event_type_code) {
        this.drive_event_type_code = drive_event_type_code == null ? null : drive_event_type_code.trim();
    }

    public String getTotal_illegal_drive() {
        return total_illegal_drive;
    }

    public void setTotal_illegal_drive(String total_illegal_drive) {
        this.total_illegal_drive = total_illegal_drive == null ? null : total_illegal_drive.trim();
    }
}