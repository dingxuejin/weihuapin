package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkpm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSubjectQyJyzkpmMapper {
    //根据year（默认当前年）查询排名，排名变化趋势
    public List<TbSubjectQyJyzkpm> queryRankingByYearAndEntityId(@Param("year") String year, @Param("entity_id") String entity_id);
 //根据entity_id查询年排名，年，年收入，年排名变化趋势
    public List<TbSubjectQyJyzkpm> queryAllByEntityId(@Param("entity_id")String entity_id);
    //计算企业总数
    public List<TbSubjectQyJyzkpm> queryEntityCount();
//根据当前年月返回当前月份排名  和企业总数
    public List<TbSubjectQyJyzkpm> queryRankingEntityCountByEntityIdAndYearAndMonth(@Param("entity_id")String entity_id,@Param("year")String year,@Param("month")String month);
    //根据企业id，年份查询月收入排名，月份，月收入，收入排名变化趋势
    public List<TbSubjectQyJyzkpm> queryAllByEntityIdAndYear(@Param("entity_id")String entity_id,@Param("year")String year);
}