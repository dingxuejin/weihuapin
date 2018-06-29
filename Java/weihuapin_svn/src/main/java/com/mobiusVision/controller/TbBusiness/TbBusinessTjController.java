package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessTj;
import com.mobiusVision.service.TbBusiness.TbBusinessTjService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员体检相关接口
 * @Date:Created in 15:16 2018/6/19/019
 * @Modify By:
 **/
@Api(description ="人员体检相关接口")
@Controller
public class TbBusinessTjController {

    //通过driver_id查询tb_business_tj表中一条最新数据（最新健康信息）
    @ApiOperation(value = "查询人员体检最新健康信息数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbBusinessTjByDriverId")
    public @ResponseBody TbBusinessTj findOneByDriverId(String driver_id){
        if(driver_id==null){
            return null;
        }
        TbBusinessTjService tbBusinessTjService=new TbBusinessTjService();

        List<TbBusinessTj> tbBusinessTjList=tbBusinessTjService.findOneByDriverId(driver_id);
        return tbBusinessTjList.get(0);
    }
}
