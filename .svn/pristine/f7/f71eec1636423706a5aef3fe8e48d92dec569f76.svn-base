package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessAqxwjfjjAndSw;
import com.mobiusVision.service.TbBusiness.TbBusinessAqxwjfjjService;
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
 * @Description:安全行为积分和奖金相关接口Controller
 * @Date:Created in 13:40 2018/6/21/021
 * @Modify By:
 **/
@Api(description ="人员安全行为积分和奖金相关接口")
@Controller
public class TbBusinessAqxwjfjjController {

    private TbBusinessAqxwjfjjService tbBusinessAqxwjfjjService=new TbBusinessAqxwjfjjService();
    //通过driver_id查询TB_BUSINESS_AQXWJFJJ aqxwjfjj,TB_DICTIONARY_SW sw表中所有违章数据
    @ApiOperation(value = "查询人员所有违章数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbBusinessAqxwjfjjASwByDid")
    public @ResponseBody List<TbBusinessAqxwjfjjAndSw> findAllJfJjSwByDriverId(String driver_id){

        if(driver_id==null)return null;

        List<TbBusinessAqxwjfjjAndSw> tbBusinessAqxwjfjjAndSwList=tbBusinessAqxwjfjjService.findAllJfJjSwByDriverId(driver_id);

        return tbBusinessAqxwjfjjAndSwList;
    }
}
