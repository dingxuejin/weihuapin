package com.mobiusVision.controller.TbBasic;

import com.mobiusVision.pojo.TbBasic.TbBasicQyXlxx;
import com.mobiusVision.service.TbBasic.TbBasicQyXlxxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhangzhirong
 * @Description:线路信息相关
 * @Date:Created in 19:52 2018/6/29/029
 * @Modify By:
 **/
@Api(description ="线路信息相关")
@Controller
public class TbBasicQyXlxxController {

    TbBasicQyXlxxService tbBasicQyXlxxService=new TbBasicQyXlxxService();

    //通过route_id查询线路名称
    @ApiOperation(value = "查询线路名称",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "route_id", value = "线路编号", required = true, dataType = "String",defaultValue = "445200431100201501"),
    })
    @RequestMapping("/TbBasicQyXlxxAllByRId")
    public @ResponseBody TbBasicQyXlxx findAllByRId(String route_id){
        if(route_id==null)return null;
        TbBasicQyXlxx tbBasicQyXlxx=tbBasicQyXlxxService.findAllByRId(route_id);
        return tbBasicQyXlxx;
    }
}
