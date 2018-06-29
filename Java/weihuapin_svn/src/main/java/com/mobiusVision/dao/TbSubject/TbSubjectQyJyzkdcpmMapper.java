package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkdcpm;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkpm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSubjectQyJyzkdcpmMapper {
    //根据year（默认当前年）查询排名，排名变化趋势
    public List<TbSubjectQyJyzkdcpm> queryRankingByYearAndEntityId(@Param("year") String year, @Param("entity_id") String entity_id);
    //根据entity_id查询年排名，年，年收入，年排名变化趋势
    public List<TbSubjectQyJyzkdcpm> queryAllByEntityId(@Param("entity_id")String entity_id);
    //获得企业总数
    public List<TbSubjectQyJyzkdcpm> queryEntityCount();
//根据年月获取月排名，公司总数
public List<TbSubjectQyJyzkdcpm> queryRankingEntityCountByEntityIdAndYearAndMonth(@Param("entity_id")String entity_id, @Param("year")String year, @Param("month")String month);    //根据企业id，年份查询月收入排名，月份，月收入，收入排名变化趋势

    public List<TbSubjectQyJyzkdcpm> queryAllByEntityIdAndYear(@Param("entity_id")String entity_id,@Param("year")String year);
}