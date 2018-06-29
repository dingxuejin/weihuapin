package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessQyDzydMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydAndLcTj;
import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydExtends;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:电子运单信息数据接口
 * @Date:Created in 10:31 2018/6/26/026
 * @Modify By:
 **/
public class TbBusinessQyDzydService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbBusinessQyDzydMapper tbBusinessQyDzydMapper =(TbBusinessQyDzydMapper)aplc.getBean("tbBusinessQyDzydMapper");

    //通过driver_id等年月数据查询TB_BUSINESS_QY_DZYD表中运单详细信息数据
    public List<TbBusinessQyDzydExtends> findAllYearMonthDayDzydByDId(
            String driver_id,
            String route_id,
            String year,
            String month,
            String day){

        List<TbBusinessQyDzydExtends> tbBusinessQyDzydExtendsList=tbBusinessQyDzydMapper.findAllYearMonthDayDzydByDId(driver_id,route_id,year,month,day);
        return tbBusinessQyDzydExtendsList;
    }

    //通过driver_id查询TB_BUSINESS_QY_DZYD电子运单表中所有运单里程，以车辆品牌进行汇总
    public List<TbBusinessQyDzydAndLcTj> findDzydLcTjByDId(
            String driver_id,
            String year,
            String month){
        List<TbBusinessQyDzydAndLcTj> tbBusinessQyDzydAndLcTjList=tbBusinessQyDzydMapper.findDzydLcTjByDId(driver_id,year,month);
        return tbBusinessQyDzydAndLcTjList;
    }
}
