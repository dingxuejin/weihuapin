package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.service.TbSubject.TbSubjectQyMYRydAndHwzzlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:企业年月日运单和周转量统计信息相关
 * @Date:Created in 15:58 2018/7/3/003
 * @Modify By:
 **/
@Api(description ="企业年月日运单和周转量统计信息相关(运单量、周转量)")
@Controller
public class TbSubjectQyMYRydAndHwzzlController {

    TbSubjectQyMYRydAndHwzzlService tbSubjectQyMYRydAndHwzzlService=new TbSubjectQyMYRydAndHwzzlService();

    //通过entity_id查询年月日及部分月的运单和周转量统计信息
    @ApiOperation(value = "查询某企业年月日运单和周转量统计信息",
            notes = "年月不填则返回所有年数据，月不填则返回所有月数据，都填则返回所有日数据",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "entity_id", value = "企业编号", required = true, dataType = "String",defaultValue = "1310000010000000"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = false, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "monthlist", value = "类型", required = false, dataType = "String",defaultValue = "11,12")
    })
    @RequestMapping("/TbSubjectQyMYRydAndHwzzlYearMonthDayByEId")
    public @ResponseBody List<Map<String,Object>> findMYYDAndHwzzlAllYearMonthDayByEIdToJson(
            String entity_id,
            String year,
            @RequestParam(value = "monthlist",required = false)List<String> monthlist){
        if(entity_id==null)return null;
        if(monthlist==null)monthlist=new ArrayList<>();
        List<Map<String ,Object>> allListMap=null;
        allListMap=tbSubjectQyMYRydAndHwzzlService.findMYYDAndHwzzlAllYearMonthDayByEIdToJson(entity_id,year,monthlist);
        return allListMap;
    }
}
