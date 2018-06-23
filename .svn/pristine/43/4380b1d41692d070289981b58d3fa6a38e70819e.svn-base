package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyNdbycbTDJMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdbycbTDJ;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class TbSubjectQyNdByAndJcAndWxcbTDJSevice {
    public List<TbSubjectQyNdbycbTDJ> findListNdByAndJcAndWxByEntityId(String entity_id) {

        //获取SpringBean
        ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
        TbSubjectQyNdbycbTDJMapper tbSubjectQyNdbycbTDJMapper = (TbSubjectQyNdbycbTDJMapper) aplc.getBean("tbSubjectQyNdbycbTDJMapper");

        //
        List<TbSubjectQyNdbycbTDJ> list = null;
        list = tbSubjectQyNdbycbTDJMapper.findAllByEntityId(entity_id);


        return list;
    }
}
