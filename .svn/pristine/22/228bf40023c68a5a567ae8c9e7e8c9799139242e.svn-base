package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.service.TbSubject.TbSubjectKhService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员运输的客户相关接口
 * @Date:Created in 10:34 2018/6/28/028
 * @Modify By:
 **/
@Api(description ="人员运输的客户相关接口")
@Controller
public class TbSubjectKhController {
    TbSubjectKhService tbSubjectKhService=new TbSubjectKhService();

    //查询人员当年和当月客户统计
    @ApiOperation(value = "查询人员当年和当月客户统计",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbSubjectKhHzsYearAMonthByDId")
    public @ResponseBody Map<String,Object> findKuHzsYearAMonthByDId(String driver_id){
        Map<String,Object> allMap=tbSubjectKhService.findKuHzsYearAMonthByDId(driver_id);
        return allMap;
    }
}
