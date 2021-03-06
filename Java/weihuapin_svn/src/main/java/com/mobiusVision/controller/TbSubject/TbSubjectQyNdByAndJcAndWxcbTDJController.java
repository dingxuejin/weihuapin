package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyNdbycbTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyNdByAndJcAndWxcbTDJSevice;
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
@Api(description = "企业年度保养检测维修成本相关")
@Controller
public class TbSubjectQyNdByAndJcAndWxcbTDJController {
    @ApiOperation(value = "查询企业年度保养检测维修成本)",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
    })
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
