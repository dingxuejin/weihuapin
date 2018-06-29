package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectNYRxslc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员行驶里程统计相关数据查询操作
 * @Date:Created in 11:46 2018/6/23/023
 * @Modify By:
 **/
public interface TbSubjectNYRxslcMapper {

    //年份的行驶里程数据
    public List<TbSubjectNYRxslc> findNYxslcByDId(@Param("driver_id")String driver_id);

    //月份的行驶里程数据
    public List<TbSubjectNYRxslc> findYYxslcByDId(@Param("driver_id")String driver_id,@Param("year")String year);

    //月份的行驶里程数据TB_SUBJECT_RXSLC
    public List<TbSubjectNYRxslc> findRRxslcByDId(@Param("driver_id")String driver_id,@Param("year")String year,@Param("month")String month);

}
