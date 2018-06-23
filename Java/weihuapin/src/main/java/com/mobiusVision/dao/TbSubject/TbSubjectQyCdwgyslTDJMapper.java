package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgyslTDJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 17:30 2018/6/15/015
 * @Modify By:
 **/
public interface TbSubjectQyCdwgyslTDJMapper {

    //通过entity_id和month查询TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwgyslTDJ> findAllByEntityIdAndYearAndMonth(@Param("entity_id") String entity_id,  @Param("year")String year,@Param("month")String month);
}
