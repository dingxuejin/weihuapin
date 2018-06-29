package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgnslTDJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 13:54 2018/6/15/015
 * @Modify By:
 **/
public interface TbSubjectQyCdwgnslTDJMapper {


    //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwgnslTDJ> findAllByEntityIdAndYear(@Param("entity_id") String entity_id, @Param("year")String year);
}
