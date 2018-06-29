package com.mobiusVision.dao.TbSubject;


import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdtxcbTDJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSubjectQyNdtxcbTDJMapper {
    //通过entity_id查询tb_subject_qy_ndtxcb表和TbSubjectQyNdrlcb表中所有数据
    public List<TbSubjectQyNdtxcbTDJ> findAllByEntityId(@Param("entity_id") String entity_id);


}
