package com.mobiusVision.pojo.TbBusiness;

public class TbBusinessYzsg {
    private Integer tb_business_yzsg_id;

    private String driver_ID;

    private String waybill_Code;

    private String vehicle_ID;

    private String accidentType_Time;

    private String accident_Location;

    private String longitude;

    private String latitude;

    private String accident_Level_Code;

    private String accident_Responsibility_Code;

    private String if_Hm_Release_Code;

    private String accident_Cause;

    private String accident_Loss;

    private String accident_Status;

    public Integer getTb_business_yzsg_id() {
        return tb_business_yzsg_id;
    }

    public void setTb_business_yzsg_id(Integer tb_business_yzsg_id) {
        this.tb_business_yzsg_id = tb_business_yzsg_id;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID == null ? null : driver_ID.trim();
    }

    public String getWaybill_Code() {
        return waybill_Code;
    }

    public void setWaybill_Code(String waybill_Code) {
        this.waybill_Code = waybill_Code == null ? null : waybill_Code.trim();
    }

    public String getVehicle_ID() {
        return vehicle_ID;
    }

    public void setVehicle_ID(String vehicle_ID) {
        this.vehicle_ID = vehicle_ID == null ? null : vehicle_ID.trim();
    }

    public String getAccidentType_Time() {
        return accidentType_Time;
    }

    public void setAccidentType_Time(String accidentType_Time) {
        this.accidentType_Time = accidentType_Time == null ? null : accidentType_Time.trim();
    }

    public String getAccident_Location() {
        return accident_Location;
    }

    public void setAccident_Location(String accident_Location) {
        this.accident_Location = accident_Location == null ? null : accident_Location.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getAccident_Level_Code() {
        return accident_Level_Code;
    }

    public void setAccident_Level_Code(String accident_Level_Code) {
        this.accident_Level_Code = accident_Level_Code == null ? null : accident_Level_Code.trim();
    }

    public String getAccident_Responsibility_Code() {
        return accident_Responsibility_Code;
    }

    public void setAccident_Responsibility_Code(String accident_Responsibility_Code) {
        this.accident_Responsibility_Code = accident_Responsibility_Code == null ? null : accident_Responsibility_Code.trim();
    }

    public String getIf_Hm_Release_Code() {
        return if_Hm_Release_Code;
    }

    public void setIf_Hm_Release_Code(String if_Hm_Release_Code) {
        this.if_Hm_Release_Code = if_Hm_Release_Code == null ? null : if_Hm_Release_Code.trim();
    }

    public String getAccident_Cause() {
        return accident_Cause;
    }

    public void setAccident_Cause(String accident_Cause) {
        this.accident_Cause = accident_Cause == null ? null : accident_Cause.trim();
    }

    public String getAccident_Loss() {
        return accident_Loss;
    }

    public void setAccident_Loss(String accident_Loss) {
        this.accident_Loss = accident_Loss == null ? null : accident_Loss.trim();
    }

    public String getAccident_Status() {
        return accident_Status;
    }

    public void setAccident_Status(String accident_Status) {
        this.accident_Status = accident_Status == null ? null : accident_Status.trim();
    }
}