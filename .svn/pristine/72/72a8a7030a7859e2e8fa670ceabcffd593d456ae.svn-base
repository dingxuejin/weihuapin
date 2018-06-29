package com.mobiusVision.controller.TbBasic;

import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBasicZj;
import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBusinessZj;
import com.mobiusVision.service.TbBasic.TbBasicRyjbZjService;
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
 * @Description:人员和证件相关接口
 * @Date:Created in 15:43 2018/6/20/020
 * @Modify By:
 **/
@Api(description ="人员和证件相关接口")
@Controller
public class TbBasicRyjbZjController {

    private TbBasicRyjbZjService tbBasicRyjbZjService=new TbBasicRyjbZjService();
    //通过driver_id查询TB_BASIC_RYJB users,TB_BASIC_ZJ zj,TB_DICTIONARY_ZJZT zt,TB_DICTIONARY_ZJLX lx表中基础证件和业务证件数据
    @ApiOperation(value = "查询人员基础证件和业务证件数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbBasicRyjbZjAllByDId")
    public @ResponseBody Map<String,Object> findAllZjByDriverId(String driver_id){
        if(driver_id==null)return null;
        //查询基础证件数据
        List<TbBasicRyjbBasicZj> tbBasicRyjbBasicZjList=tbBasicRyjbZjService.findAllBaiscZjByDriverId(driver_id);
        //查询业务证件数据
        List<TbBasicRyjbBusinessZj> tbBasicRyjbBusinessZjList=tbBasicRyjbZjService.findAllBusinessZjByDriverId(driver_id);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("AllbasicZj",tbBasicRyjbBasicZjList);
        map.put("AllbusinessZj",tbBasicRyjbBusinessZjList);
        return map;
    }
}
