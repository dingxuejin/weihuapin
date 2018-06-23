package com.mobiusVision.pojo.TbBasic;

public class TbBasicQyCdxx {
    private Integer tb_basic_qy_cdxx_id;

    private String entity_id;

    private String entity_name;

    private String campany_code;

    private String parent_code;

    private String region_scope_code;

    private String manager;

    private String phone_number;

    private String create_time;

    public Integer getTb_basic_qy_cdxx_id() {
        return tb_basic_qy_cdxx_id;
    }

    public void setTb_basic_qy_cdxx_id(Integer tb_basic_qy_cdxx_id) {
        this.tb_basic_qy_cdxx_id = tb_basic_qy_cdxx_id;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id == null ? null : entity_id.trim();
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name == null ? null : entity_name.trim();
    }

    public String getCampany_code() {
        return campany_code;
    }

    public void setCampany_code(String campany_code) {
        this.campany_code = campany_code == null ? null : campany_code.trim();
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code == null ? null : parent_code.trim();
    }

    public String getRegion_scope_code() {
        return region_scope_code;
    }

    public void setRegion_scope_code(String region_scope_code) {
        this.region_scope_code = region_scope_code == null ? null : region_scope_code.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number == null ? null : phone_number.trim();
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time == null ? null : create_time.trim();
    }
}