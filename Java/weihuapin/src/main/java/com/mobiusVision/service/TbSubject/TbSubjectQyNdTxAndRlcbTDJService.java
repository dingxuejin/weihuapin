package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyNdtxcbTDJMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdtxcbTDJ;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class TbSubjectQyNdTxAndRlcbTDJService {


    public List<TbSubjectQyNdtxcbTDJ> findListNdTxAndRlByEntityId(String entity_id) {

        //获取SpringBean
        ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
        TbSubjectQyNdtxcbTDJMapper tbSubjectQyNdtxcbTDJMapper = (TbSubjectQyNdtxcbTDJMapper) aplc.getBean("tbSubjectQyNdtxcbTDJMapper");

        //
        List<TbSubjectQyNdtxcbTDJ> list = null;
       list = tbSubjectQyNdtxcbTDJMapper.findAllByEntityId(entity_id);


        return list;
    }
}

