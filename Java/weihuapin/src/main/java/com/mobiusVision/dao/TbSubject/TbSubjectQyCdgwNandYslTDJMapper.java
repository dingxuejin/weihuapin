package com.mobiusVision.dao.TbSubject;


import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwYslTDJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 10:19 2018/6/19/019
 * @Modify By:
 **/
public interface TbSubjectQyCdgwNandYslTDJMapper {

    //通过entity_id和year查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdgwNslTDJ> findListGwNslByEntityIdAndYear(@Param("entity_id") String entity_id, @Param("year")String year);

    //通过entity_id和year和month查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdgwYslTDJ> findAllListGwYslByEntityIdAndYearAndMonth(@Param("entity_id") String entity_id, @Param("year")String year, @Param("month")String month);
}
