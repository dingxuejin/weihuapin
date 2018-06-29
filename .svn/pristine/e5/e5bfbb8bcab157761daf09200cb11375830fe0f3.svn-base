package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfYslTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdwfNandYslTDJService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:不同企业违法驾驶行为
 * @Date:Created in 13:29 2018/6/19/019
 * @Modify By:
 **/
@Api(description ="不同企业违法驾驶行为相关接口")
@Controller
public class TbSubjectQyCdwfNandYslTDJController {
    //不同机构违规行为年统计表
    //通过entity_id和year查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @ApiOperation(value = "查询不同企业违法驾驶行为某一年的数据",
            notes = "年和月不填则查询当年当月",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "entity_id", value = "企业编号", required = true, dataType = "String",defaultValue = "1310000010000000"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
    })
    @RequestMapping("/TbSubjectQyCdwfNslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdwfNslTDJ> findAllByEntityIdAndYear(String entity_id, String year) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyCdwfNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdwfNandYslTDJService();
        List<TbSubjectQyCdwfNslTDJ> list = tbSubjectQyCdgwNandYslTDJService.findListWfNslByEntityIdAndYear(entity_id, year);
        return list;
    }

    //不同机构违规行为月统计表
    //通过entity_id和year和month查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @ApiOperation(value = "查询不同企业违法驾驶行为某一月的数据",
            notes = "年和月不填则查询当年当月",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "entity_id", value = "企业编号", required = true, dataType = "String",defaultValue = "1310000010000000"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = true, dataType = "String",defaultValue = "11"),
    })
    @RequestMapping("/TbSubjectQyCdwfYslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdwfYslTDJ> findAllByEntityIdAndMonth(String entity_id, String year, String month) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyCdwfNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdwfNandYslTDJService();
        List<TbSubjectQyCdwfYslTDJ> list = tbSubjectQyCdgwNandYslTDJService.findAllListWfYslByEntityIdAndYearAndMonth(entity_id,year, month);
        return list;
    }

    //不同机构违规行为年统计表
    //通过entity_id、year和month查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    @ApiOperation(value = "查询不同企业违法驾驶行为某一年和月的总数据（企业必选，年份和月份不必须）",
            notes = "年和月不填则查询当年当月",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "entity_id", value = "企业编号", required = true, dataType = "String",defaultValue = "1310000010000000"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = true, dataType = "String",defaultValue = "11"),
    })
    @RequestMapping("/TbSubjectQyCdwfNandYslTDJ")
    public @ResponseBody
    Map<String,Object> findAllMapByEntityIdAndYearAndMonth(String entity_id, String year, String month) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            //组合map
            Map<String,Object> map=new LinkedHashMap<>();
            map.put("thisYear",null);
            map.put("thisMonth",null);
            return map;
        }

        TbSubjectQyCdwfNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdwfNandYslTDJService();
        //查询map
        Map<String,Object>  map= tbSubjectQyCdgwNandYslTDJService.findAllMapByEntityIdAndYearAndMonth(entity_id,year,month);
        return map;
    }
}
