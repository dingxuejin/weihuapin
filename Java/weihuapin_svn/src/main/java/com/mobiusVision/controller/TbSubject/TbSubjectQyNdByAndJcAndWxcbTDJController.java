package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdbycbTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyNdByAndJcAndWxcbTDJSevice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TbSubjectQyNdByAndJcAndWxcbTDJController {
    //entity_id查询tb_subject_qy_ndbycb；tb_subject_qy_ndjccb；tb_subject_qy_ndwxcb表中所有数据
    @RequestMapping("/TbSubjectQyNdbycbTDJ")
    @ResponseBody
    public List<TbSubjectQyNdbycbTDJ> findAllByEntityId(String entity_id) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyNdByAndJcAndWxcbTDJSevice tbSubjectQyNdByAndJcAndWxcbTDJSevice = new TbSubjectQyNdByAndJcAndWxcbTDJSevice();
        List<TbSubjectQyNdbycbTDJ> list = tbSubjectQyNdByAndJcAndWxcbTDJSevice.findListNdByAndJcAndWxByEntityId(entity_id);
        return list;
    }
}
