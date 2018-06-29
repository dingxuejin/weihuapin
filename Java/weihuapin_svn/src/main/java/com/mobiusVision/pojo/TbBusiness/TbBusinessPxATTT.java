package com.mobiusVision.pojo.TbBusiness;

/**
 * @Author: zhangzhirong
 * @Description:TTT(人员每月的培训总次数和培训总时长和总通过人数)
 * @Date:Created in 18:15 2018/6/21/021
 * @Modify By:
 **/
public class TbBusinessPxATTT extends TbBusinessPx {

    //总培训次数
    private String total_training_times;
    //总培训时长
    private String total_training_time;
    //总通过人数
    private String total_result_pass;

    public String getTotal_training_times() {
        return total_training_times;
    }

    public void setTotal_training_times(String total_training_times) {
        this.total_training_times = total_training_times;
    }

    public String getTotal_training_time() {
        return total_training_time;
    }

    public void setTotal_training_time(String total_training_time) {
        this.total_training_time = total_training_time;
    }

    public String getTotal_result_pass() {
        return total_result_pass;
    }

    public void setTotal_result_pass(String total_result_pass) {
        this.total_result_pass = total_result_pass;
    }
}
