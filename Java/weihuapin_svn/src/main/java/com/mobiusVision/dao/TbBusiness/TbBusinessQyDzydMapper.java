package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydAndLcTj;
import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydExtends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:电子运单信息数据接口
 * @Date:Created in 9:13 2018/6/26/026
 * @Modify By:
 **/
public interface TbBusinessQyDzydMapper {

    //通过driver_id等年月数据查询TB_BUSINESS_QY_DZYD表中运单详细信息数据
    public List<TbBusinessQyDzydExtends> findAllYearMonthDayDzydByDId(
            @Param("driver_id")String driver_id,
            @Param("route_id")String route_id,
            @Param("year")String year,
            @Param("month")String month,
            @Param("day")String day);

    //通过driver_id查询TB_BUSINESS_QY_DZYD电子运单表中所有运单里程，以车辆品牌进行汇总
    public List<TbBusinessQyDzydAndLcTj> findDzydLcTjByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month);

}
