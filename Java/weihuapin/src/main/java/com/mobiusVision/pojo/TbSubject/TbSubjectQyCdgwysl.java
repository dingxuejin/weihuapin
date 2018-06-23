package com.mobiusVision.pojo.TbSubject;

public class TbSubjectQyCdgwysl {
    private Integer tb_subject_qy_cdgwysl_id;

    private String year;

    private String month;

    private String entity_id;

    private String drive_event_type_code;

    private String total_danger_drive;

    public Integer getTb_subject_qy_cdgwysl_id() {
        return tb_subject_qy_cdgwysl_id;
    }

    public void setTb_subject_qy_cdgwysl_id(Integer tb_subject_qy_cdgwysl_id) {
        this.tb_subject_qy_cdgwysl_id = tb_subject_qy_cdgwysl_id;
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

    public String getTotal_danger_drive() {
        return total_danger_drive;
    }

    public void setTotal_danger_drive(String total_danger_drive) {
        this.total_danger_drive = total_danger_drive == null ? null : total_danger_drive.trim();
    }
}