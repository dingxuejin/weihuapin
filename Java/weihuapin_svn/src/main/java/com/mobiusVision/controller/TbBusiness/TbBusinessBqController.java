package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessBq;
import com.mobiusVision.pojo.TbBusiness.TbBusinessBqTBR;
import com.mobiusVision.service.TbBusiness.TbBusinessBqService;
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
 * @Description:人员标签相关Controller
 * @Date:Created in 10:28 2018/6/20/020
 * @Modify By:
 **/
@Api(description ="人员标签相关接口")
@Controller
public class TbBusinessBqController {

    private TbBusinessBqService tbBusinessBqService=new TbBusinessBqService();
    //通过driver_id和label_source查询tb_business_bq表中所有数据
    //label_source=null则返回系统评价，否则返回单人评价
    @ApiOperation(value = "查询人员自身标签和同事评论标签数据",
            notes = "label_source为空则返回自身标签，否则返回某个同事对他所有的评论标签",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "label_source", value = "标签来源", required = false, dataType = "String",defaultValue = ""),
    })
    @RequestMapping("/TbBusinessBqByIAS")
    public @ResponseBody List<TbBusinessBq> findAllByDriverIdAndLabelSource(String driver_id, String label_source){
        if(driver_id==null)
            return null;

        List<TbBusinessBq> tbBusinessBqList=tbBusinessBqService.findAllByDriverIdAndLabelSource(driver_id,label_source);

        return tbBusinessBqList;
    }

    //通过driver_id和label_source=system和label_source与driver_id关联查询tb_business_bq表和tb_basic_ryjb表中最新数据（去重条件Label_source）
    @ApiOperation(value = "查询人员不同的同事最新评论标签数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbBusinessBqTBRByI")
    public @ResponseBody List<TbBusinessBqTBR> findAllByDriverIdAndNotSystemAndTBR(String driver_id){
        if(driver_id==null)
            return null;
        List<TbBusinessBqTBR> tbBusinessBqTBRList=tbBusinessBqService.findAllByDriverIdAndNotSystemAndTBR(driver_id);
        return  tbBusinessBqTBRList;
    }
}
