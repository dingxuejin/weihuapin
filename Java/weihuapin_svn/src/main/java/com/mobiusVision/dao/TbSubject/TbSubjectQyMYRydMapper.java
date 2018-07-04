package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyMryd;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMyyd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:09 2018/7/3/003
 * @Modify By:
 **/
public interface TbSubjectQyMYRydMapper {

    //TB_SUBJECT_QY_MYYD运营企业数据表记录中，通过entity_id查询所有年和某年所有月或部分月的信息
    public List<TbSubjectQyMyyd> findMYYDAllYearMonthByEId(
            @Param("entity_id")String entity_id,
            @Param("year")String year,
            @Param("monthlist") List<String> monthlist);

    //TB_SUBJECT_QY_MYYD运营企业数据表记录中，通过entity_id查询某年某月所有天的信息
    public List<TbSubjectQyMryd> findMYYDAllDayByEId(
            @Param("entity_id")String entity_id,
            @Param("year")String year,
            @Param("month") String month);
}
