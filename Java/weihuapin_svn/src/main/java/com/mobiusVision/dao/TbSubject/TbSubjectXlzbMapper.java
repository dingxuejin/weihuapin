package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbBusiness.TbSubjectXlzbTjXxExtends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:线路指标统计相关
 * @Date:Created in 18:40 2018/6/29/029
 * @Modify By:
 **/
public interface TbSubjectXlzbMapper {

    //通过driver_id查询人员线路所有年和某年所有月的相关统计信息信息
    public List<TbSubjectXlzbTjXxExtends> findAllTjXxYearMonthByDId(
            @Param("driver_id")String driver_id,
            @Param("route_id") String route_id,
            @Param("year") String year);
}
