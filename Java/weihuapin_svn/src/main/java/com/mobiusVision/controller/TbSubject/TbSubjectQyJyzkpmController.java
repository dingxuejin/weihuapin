package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkpm;
import com.mobiusVision.service.TbSubject.TbSubjectQyJyzkpmService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date:Created
 * @Modify By:LEO
 **/
@Api(description = "企业经营状况排行相关接口")
@Controller
public class TbSubjectQyJyzkpmController {
    @ApiOperation(value = "查询当年排名，当年变化趋势(使用时不填写年，测试时因数据库表的原因需填写年)",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
            @ApiImplicitParam(paramType = "query", name = "year", value = "年", required = true, dataType = "String", defaultValue = "2017"),

    })
    @RequestMapping("/queryRankingByYearAndEntityId")
    @ResponseBody
    //根据year,entity_id查询当年排名和变化趋势
    public TbSubjectQyJyzkpm queryRankingByYearAndEntityId(String year, String entity_id) {
        if (entity_id == null) {
            return null;
        }
        if (year == null) {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            TbSubjectQyJyzkpm tbSubjectQyJyzkpm = tbSubjectQyJyzkpmService.queryRankingByYearAndEntityId(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)), entity_id);
            return tbSubjectQyJyzkpm;
        } else {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            TbSubjectQyJyzkpm tbSubjectQyJyzkpm = tbSubjectQyJyzkpmService.queryRankingByYearAndEntityId(year, entity_id);
            return tbSubjectQyJyzkpm;
        }
    }

    @ApiOperation(value = "查询当月排名，公司总数(使用时不填写年月，测试时因数据库表的原因需填写年月)",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
            @ApiImplicitParam(paramType = "query", name = "year", value = "年", required = true, dataType = "String", defaultValue = "2017"),
            @ApiImplicitParam(paramType = "query", name = "month", value = "月", required = true, dataType = "String", defaultValue = "10"),
    })
    @RequestMapping("/queryRankingEntityCountByEntityIdAndYearAndMonth")
    @ResponseBody
    //根据查询当年排名和变化趋势
    public List<TbSubjectQyJyzkpm> queryRankingEntityCountByEntityIdAndYearAndMonth(String year, String entity_id, String month) {
        if (entity_id == null) {
            return null;
        }
        if (year == null ) {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            List<TbSubjectQyJyzkpm> list = tbSubjectQyJyzkpmService.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)), Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
            return list;
        } else {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            List<TbSubjectQyJyzkpm> list = tbSubjectQyJyzkpmService.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id, year, month);

            return list;
        }
    }

    @ApiOperation(value = "查询当年收入排名,年份，年总收入，年排名变化趋势",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
    })
    @RequestMapping("/queryAllByEntityId")
    @ResponseBody
    //根据entity_id查询企业年收入排名，年份，年总收入，年排名变化趋势
    public List<TbSubjectQyJyzkpm> queryAllByEntityId(String entity_id) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }
        TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
        List<TbSubjectQyJyzkpm> list = tbSubjectQyJyzkpmService.queryAllByEntityId(entity_id);
        return list;
    }

    @ApiOperation(value = "查询指定年份每月的排名，收入，变化趋势",
            notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entity_id", value = "企业编号", required = true, dataType = "String", defaultValue = "1310000010010000"),
            @ApiImplicitParam(paramType = "query", name = "year", value = "年", required = true, dataType = "String", defaultValue = "2015"),

    })
    @RequestMapping("/queryAllByEntityIdAndYear")
    @ResponseBody
    //通过entity_id和year查询指定年份每月的排名，收入，变化趋势

    public List<TbSubjectQyJyzkpm> queryAllByEntityIdAndYear(String entity_id, String year) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }
        List<TbSubjectQyJyzkpm> list = null;

        if (year == null) {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            list = tbSubjectQyJyzkpmService.queryAllByEntityIdAndYear(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        } else {
            TbSubjectQyJyzkpmService tbSubjectQyJyzkpmService = new TbSubjectQyJyzkpmService();
            list = tbSubjectQyJyzkpmService.queryAllByEntityIdAndYear(entity_id, year);
        }
        return list;
    }
}
