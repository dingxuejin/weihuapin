package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdtxcbTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyNdTxAndRlcbTDJService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TbSubjectQyNdTxAndRlcbTDJController {
    //entity_id查询tb_subject_qy_ndtxcb表和TbSubjectQyNdrlcb表中所有数据
    @RequestMapping("/TbSubjectQyNdtxcbTDJ")
    @ResponseBody
    public  List<TbSubjectQyNdtxcbTDJ> findAllByEntityId(String entity_id) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyNdTxAndRlcbTDJService tbSubjectQyNdTxAndRlcbTDJService = new TbSubjectQyNdTxAndRlcbTDJService();
        List<TbSubjectQyNdtxcbTDJ> list = tbSubjectQyNdTxAndRlcbTDJService.findListNdTxAndRlByEntityId(entity_id);
        return list;
    }
}
