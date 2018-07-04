package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusineseeQngrxsscTjXx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员行驶时长相关统计信息
 * @Date:Created in 10:52 2018/6/29/029
 * @Modify By:
 **/
public interface TbBusineseeQngrxsscMapper {

    //通过driver_id查询TB_BUSINESEE_QNGRXSSC查询全年各日行驶时长表（档案Excel）中年月日所有行驶里程相关统计信息
    public List<TbBusineseeQngrxsscTjXx> findAllYearMonthDayTjXxByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month);
}
