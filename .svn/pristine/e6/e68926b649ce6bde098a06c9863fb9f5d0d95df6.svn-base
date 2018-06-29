package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectYRxslc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:行驶里程、重车里程、空车里程、空重里程比统计信息
 * @Date:Created in 14:07 2018/6/28/028
 * @Modify By:
 **/
public interface TbSubjectYRxslcMapper {

    //通过driver_id查询所有年和某年所有月的信息及平均信息
    public List<TbSubjectYRxslc> findAllYearAMonthByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year);

    //通过driver_id查询某年某月所有天的信息及平均信息
    public List<TbSubjectYRxslc> findAllDayByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month);

    //通过driver_id查询所有年和某年所有月的平均信息
    public List<TbSubjectYRxslc> findAllAvgYearAMonthByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year);

    //通过driver_id查询某年某月所有天的平均信息
    public List<TbSubjectYRxslc> findAllAvgDayByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month);
}
