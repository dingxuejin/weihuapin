package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectJxjyARemainTime;
import com.mobiusVision.service.TbSubject.TbSubjectJxjyService;
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
 * @Description:人员教育周期相关接口
 * @Date:Created in 16:49 2018/6/21/021
 * @Modify By:
 **/
@Api(description ="人员教育周期相关接口")
@Controller
public class TbSubjectJxjyController {

    private TbSubjectJxjyService tbSubjectJxjyService=new TbSubjectJxjyService();
    //通过driver_id查询tb_subject_jxjy表及其到期天数和未学习时间数据
    @ApiOperation(value = "查询人员培训到期天数和未学习时间数据",
            notes = "",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
    })
    @RequestMapping("/TbSubjectJxjyARemainTime")
    public @ResponseBody List<TbSubjectJxjyARemainTime> findJxjyRemainByDriverId(String driver_id){
        if(driver_id==null)return null;

        List<TbSubjectJxjyARemainTime> tbSubjectJxjyARemainTimeList=tbSubjectJxjyService.findJxjyRemainByDriverId(driver_id);

        return tbSubjectJxjyARemainTimeList;
    }
}
