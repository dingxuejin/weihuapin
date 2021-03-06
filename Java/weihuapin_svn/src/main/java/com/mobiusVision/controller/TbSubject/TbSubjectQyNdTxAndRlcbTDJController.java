package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdtxcbTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyNdTxAndRlcbTDJService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @Author:
 * @Description:
 * @Date:Created
 * @Modify By:LEO
 **/
@Api(description = "企业年度同行成本及燃料成本相关")
@Controller
public class TbSubjectQyNdTxAndRlcbTDJController {
    @ApiOperation(value = "查询企业年度同行成本及燃料成本)",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
    }) //entity_id查询tb_subject_qy_ndtxcb表和TbSubjectQyNdrlcb表中所有数据
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
