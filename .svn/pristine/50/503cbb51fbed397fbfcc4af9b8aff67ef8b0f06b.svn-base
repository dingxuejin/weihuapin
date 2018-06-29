package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectDydslDay;
import com.mobiusVision.pojo.TbSubject.TbSubjectDydslMonth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:33 2018/6/23/023
 * @Modify By:
 **/
public interface TbSubjectDydslMapper {

    //通过driver_id查询tb_subject_dydsl_day表全月某天数据
    public List<TbSubjectDydslDay> findYdslAllOneDayByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month,
            @Param("day")String day);

    //通过driver_id查询tb_subject_dydsl_day表全月每天数据
    public List<TbSubjectDydslDay> findYdslAllDayByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("month")String month);

    //通过driver_id查询tb_subject_dydsl_day表全年每月数据
    public List<TbSubjectDydslMonth> findYdslAllMonthByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year);

    //通过driver_id查询tb_subject_dydsl_day表计算每天运单数量的同比环比
    public List<TbSubjectDydslDay> findYdslAllDayTongHuanbiByDId(
            @Param("driver_id")String driver_id,
             @Param("year")String year,
             @Param("month")String month,
             @Param("capacity_unit_code")String capacity_unit_code);

    //通过driver_id查询tb_subject_dydsl_month表计算每月运单数量的同比环比
    public List<TbSubjectDydslMonth> findYdslAllMonthTongHuanbiByDId(
            @Param("driver_id")String driver_id,
            @Param("year")String year,
            @Param("capacity_unit_code")String capacity_unit_code);

    //通过driver_id查询tb_subject_dydsl_month表计算每年运单数量的同比环比
    public List<TbSubjectDydslMonth> findYdslAllYearTongHuanbiByDId(
            @Param("driver_id")String driver_id,
            @Param("capacity_unit_code")String capacity_unit_code);
}
