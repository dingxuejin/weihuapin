package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydAndLcTj;
import com.mobiusVision.pojo.TbBusiness.TbBusinessQyDzydExtends;
import com.mobiusVision.service.TbBusiness.TbBusinessQyDzydService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: zhangzhirong
 * @Description:电子运单信息数据接口
 * @Date:Created in 10:35 2018/6/26/026
 * @Modify By:
 **/
@Api(description ="电子运单信息数据接口")
@Controller
public class TbBusinessQyDzydController {
    private TbBusinessQyDzydService tbBusinessQyDzydService=new TbBusinessQyDzydService();

    //通过driver_id等年月数据查询TB_BUSINESS_QY_DZYD表中运单详细信息数据
    @ApiOperation(value = "查询人员年月日运单详细信息数据数据",
            notes = "年月日不填则返回所有年数据，月日不填则返回所有月数据，日不填则返回所有日数据，数据表默认单位为天",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001"),
            @ApiImplicitParam(paramType="query", name = "route_id", value = "线路编号", required = true, dataType = "String",defaultValue = "445200445100201401"),
            @ApiImplicitParam(paramType="query", name = "year", value = "年份", required = false, dataType = "String",defaultValue = "2018"),
            @ApiImplicitParam(paramType="query", name = "month", value = "月份", required = false, dataType = "String",defaultValue = "06"),
            @ApiImplicitParam(paramType="query", name = "day", value = "天份", required = false, dataType = "String",defaultValue = "19")
    })
    @RequestMapping("/TbBusinessQyDzydAllYearMonthDayByDId")
    public @ResponseBody List<TbBusinessQyDzydExtends> findAllYearMonthDayDzydByDId(
            String driver_id,
            String route_id,
            String year,
            String month,
            String day){
        //判断输入合法性
        if(driver_id==null && route_id==null)return null;
        if(year!=null && month!=null && Integer.parseInt(month)<=0 && Integer.parseInt(month)>12)return null;
        if(year!=null && month!=null && day!=null && Integer.parseInt(day)<=0 && Integer.parseInt(day)>31)return null;

        List<TbBusinessQyDzydExtends> tbBusinessQyDzydExtendsList=tbBusinessQyDzydService.findAllYearMonthDayDzydByDId(driver_id,route_id,year,month,day);
        return tbBusinessQyDzydExtendsList;
    }

    //通过driver_id查询TB_BUSINESS_QY_DZYD电子运单表中所有运单里程，以车辆品牌进行汇总
    @ApiOperation(value = "查询人员所有运单里程，以车辆品牌进行汇总",
            notes = "年月都不填，返回当前年月的统计",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "driver_id", value = "人员编号", required = true, dataType = "String",defaultValue = "201408000001")
    })
    @RequestMapping("/TbBusinessQyDzydLcTjByDId")
    public @ResponseBody
    Map<String,List<TbBusinessQyDzydAndLcTj>> findDzydLcTjByDId(
            String driver_id){
        if(driver_id==null)return null;
        Map<String,List<TbBusinessQyDzydAndLcTj>> allMap=new LinkedHashMap<>();

        //当年数据
        List<TbBusinessQyDzydAndLcTj> tbBusinessQyDzydAndLcTjListYear=tbBusinessQyDzydService.findDzydLcTjByDId(driver_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),null);;
        if(tbBusinessQyDzydAndLcTjListYear.size()==0){
            TbBusinessQyDzydAndLcTj tbBusinessQyDzydAndLcTj=new TbBusinessQyDzydAndLcTj();
            List<TbBusinessQyDzydAndLcTj> tbBusinessQyDzydAndLcTjListYearNull=new ArrayList<>();
            tbBusinessQyDzydAndLcTjListYearNull.add(tbBusinessQyDzydAndLcTj);
            allMap.put("ThisYear",tbBusinessQyDzydAndLcTjListYearNull);
        }else {
            allMap.put("ThisYear",tbBusinessQyDzydAndLcTjListYear);
        }

        //当月数据
        List<TbBusinessQyDzydAndLcTj> tbBusinessQyDzydAndLcTjListMonth=tbBusinessQyDzydService.findDzydLcTjByDId(driver_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));;
        if(tbBusinessQyDzydAndLcTjListMonth.size()==0){
            TbBusinessQyDzydAndLcTj tbBusinessQyDzydAndLcTj=new TbBusinessQyDzydAndLcTj();
            List<TbBusinessQyDzydAndLcTj> tbBusinessQyDzydAndLcTjListMonthNull=new ArrayList<>();
            tbBusinessQyDzydAndLcTjListMonthNull.add(tbBusinessQyDzydAndLcTj);
            allMap.put("ThisMonth",tbBusinessQyDzydAndLcTjListMonthNull);
        }else {
            allMap.put("ThisMonth",tbBusinessQyDzydAndLcTjListMonth);
        }
        return allMap;
    }
}
