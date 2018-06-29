package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessYzsgNDjZrXl;
import com.mobiusVision.service.TbBusiness.TbBusinessYzsgService;
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
 * @Description:事故相关接口Controller
 * @Date:Created in 10:13 2018/6/21/021
 * @Modify By:
 **/
@Api(description ="人员事故相关接口")
@Controller
public class TbBusinessYzsgController {

    TbBusinessYzsgService tbBusinessYzsgService=new TbBusinessYzsgService();
    //通过driver_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询某个人的事故按最新时间排列)
    @ApiOperation(value = "查询某个人的事故按最新时间排列",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbBusinessYzsgByDId")
    public @ResponseBody List<TbBusinessYzsgNDjZrXl> findSgxqByDriverId(String driver_id){
        if(driver_id==null) return null;

        List<TbBusinessYzsgNDjZrXl> tbBusinessYzsgNDjZrXlList=tbBusinessYzsgService.findSgxqByDriverId(driver_id);
        return tbBusinessYzsgNDjZrXlList;
    }

    //通过entity_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询某一企业的所有事故按最新时间排列)
    @ApiOperation(value = "查询某一企业的所有事故按最新时间排列",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "entity_id", value = "企业编号", required = true, dataType = "String",defaultValue = "1310000010000000"),
    })
    @RequestMapping("/TbBusinessYzsgByEId")
    public @ResponseBody List<TbBusinessYzsgNDjZrXl> findSgxqByEntityId(String entity_id){
        if(entity_id==null) return null;

        List<TbBusinessYzsgNDjZrXl> tbBusinessYzsgNDjZrXlList=tbBusinessYzsgService.findSgxqByEntityId(entity_id);
        return tbBusinessYzsgNDjZrXlList;
    }
}
