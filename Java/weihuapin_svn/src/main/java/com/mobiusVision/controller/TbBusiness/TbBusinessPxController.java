package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.service.TbBusiness.TbBusinessPxService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员培训信息查询
 * @Date:Created in 10:30 2018/6/22/022
 * @Modify By:
 **/
@Api(description = "人员培训信息相关接口")
@Controller
public class TbBusinessPxController {

    private TbBusinessPxService tbBusinessPxService=new TbBusinessPxService();

    //通过String driver_id,String training_type_code,String training_theme_code,String year查询所有同环比
    @ApiOperation(value = "查询人员培训信息所有同环比",
            notes = "type:0=培训次数；1=培训时长；2=培训通过率",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "training_type_code", value = "培训类型代码", required = true, dataType = "String",defaultValue = "12"),
            @ApiImplicitParam(paramType="query", name = "training_theme_code", value = "培训主题代码", required = true, dataType = "String",defaultValue = "10"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = true, dataType = "String",defaultValue = "2017"),
            @ApiImplicitParam(paramType="query", name = "type", value = "查询类型", required = false, dataType = "String",defaultValue = "0")
    })
    @RequestMapping("/TbBusinessPxByDidCY")
    public @ResponseBody List<Map<String,Object>> findPxByDidCodeDateAType(
            String driver_id,
            String training_type_code,
            String training_theme_code,
            String year,
            String type
    ) {
        //检测输入合法性
        if(driver_id==null && training_theme_code==null && training_theme_code==null && year==null) return null;


        List<Map<String,Object>> AllMap=tbBusinessPxService.findPxByDidCodeDateAType(driver_id,training_type_code,training_theme_code,year);



        List<Map<String,Object>> AllMapNow=AllMap;
        if(type!=null) {
            //培训次数
            if (type.equals("0"))
                AllMapNow=AllMap.subList(0, 2);
            //培训时长
            if (type.equals("1"))
                AllMapNow=AllMap.subList(2, 4);
            //培训通过率
            if (type.equals("2"))
                AllMapNow=AllMap.subList(4, 6);
        }
        return AllMapNow;
    }
}
