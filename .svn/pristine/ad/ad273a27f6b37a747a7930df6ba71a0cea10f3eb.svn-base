package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectJy;
import com.mobiusVision.pojo.TbSubject.TbSubjectLsxlyd;
import com.mobiusVision.service.TbSubject.TbSubjectJyService;
import com.mobiusVision.service.TbSubject.TbSubjectLsxlydService;
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
 * @Description:人员区域驾驶经验（入职之前经验）
 * @Date:Created in 12:14 2018/6/27/027
 * @Modify By:
 **/
@Api(description ="人员区域驾驶经验（入职之前经验）")
@Controller
public class TbSubjectJyController {

    private TbSubjectJyService tbSubjectJyService=new TbSubjectJyService();
    //TB_SUBJECT_LSXLYD档案人员记录中，通过driver_id查询本企业历史线路统计
    @ApiOperation(value = "查询人员入职之前驾驶经验和入职后的工作运单数",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbSubjectJyALsxlByDId")
    public @ResponseBody Map<String,Object> findAllJyLsxlydByDid(String driver_id){
        if(driver_id==null)return null;
        TbSubjectLsxlydService tbSubjectLsxlydService=new TbSubjectLsxlydService();
        //数据获取
        List<TbSubjectLsxlyd> tbSubjectLsxlydList=tbSubjectLsxlydService.findAllLsxlydByDid(driver_id);
        List<TbSubjectJy> tbSubjectJyList=tbSubjectJyService.findAllJyByDid(driver_id);

        //数据汇总
        Map<String,Object> allmap=new LinkedHashMap<>();

        allmap.put("history",tbSubjectJyList);
        allmap.put("now",tbSubjectLsxlydList);

        return allmap;
    }
}
