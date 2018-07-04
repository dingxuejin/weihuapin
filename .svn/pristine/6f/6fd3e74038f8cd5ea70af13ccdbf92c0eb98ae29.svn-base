package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.service.TbSubject.TbSubjectXlzbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:线路指标统计相关
 * @Date:Created in 19:31 2018/6/29/029
 * @Modify By:
 **/
@Api(description ="线路指标统计相关(运单数、周转量、油耗、时长)")
@Controller
public class TbSubjectXlzbController {

    TbSubjectXlzbService tbSubjectXlzbService=new TbSubjectXlzbService();

    //通过driver_id查询人员线路所有年和某年所有月的相关统计信息信息toJson
    @ApiOperation(value = "查询运单数、周转量、油耗、时长统计信息",
            notes = "年月不填则返回所有年数据，月不填则返回所有月数据，都填则返回所有日数据，数据表默认单位为天(type:0运单数及平均,1周转量及平均,2油耗及平均,3时长及平均)",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "route_id", value = "线路编号", required = true, dataType = "String",defaultValue = "445200431100201501"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = false, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "type", value = "类型", required = false, dataType = "String",defaultValue = "0")
    })
    @RequestMapping("/TbSubjectXlzbTjXxYearMonthByDId")
    public @ResponseBody List<Map<String ,Object>> findAllTjXxYearMonthToJsonByDId(
            String driver_id,
            String route_id,
            String year,
            String type){
        List<Map<String ,Object>> allListMap=null;
        List<Map<String ,Object>> allListMapPart=null;
        if(driver_id==null && route_id==null)return null;
        allListMap=tbSubjectXlzbService.findAllTjXxYearMonthToJsonByDId(driver_id,route_id,year);
        if(type.equals("0") || type==null)
            allListMapPart=allListMap.subList(0,2);
        else if(type.equals("1"))
            allListMapPart=allListMap.subList(2,4);
        else if(type.equals("2"))
            allListMapPart=allListMap.subList(4,8);
        else if(type.equals("3"))
            allListMapPart=allListMap.subList(8,12);

        return allListMapPart;
    }
}
