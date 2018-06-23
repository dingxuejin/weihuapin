package com.mobiusVision.dao.TbSubject;


import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfYslTDJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:不同企业中违法行为统计查询
 * @Date:Created in 10:19 2018/6/19/019
 * @Modify By:
 **/
public interface TbSubjectQyCdwfNandYslTDJMapper {

    //通过entity_id和year查询TB_SUBJECT_QY_CDWFNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwfNslTDJ> findListWfNslByEntityIdAndYear(@Param("entity_id") String entity_id, @Param("year") String year);

    //通过entity_id和year和month查询TB_SUBJECT_QY_CDWFNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwfYslTDJ> findAllListWfYslByEntityIdAndYearAndMonth(@Param("entity_id") String entity_id, @Param("year") String year, @Param("month") String month);
}
