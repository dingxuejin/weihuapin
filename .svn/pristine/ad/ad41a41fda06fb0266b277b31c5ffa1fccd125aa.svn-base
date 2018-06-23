package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgnslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgyslTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdwgNandYslTDJService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description: 不同机构违规行为年和月统计接口
 * @Date:Created in 15:35 2018/6/15/015
 * @Modify By:
 **/
@Controller
public class TbSubjectQyCdwgNandYslTDJController {

    //不同机构违规行为年统计表
    //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @RequestMapping("/TbSubjectQyCdwgNslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdwgnslTDJ> findAllByEntityIdAndYear(String entity_id, String year) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            TbSubjectQyCdwgnslTDJ tbSubjectQyCdwgnslTDJ = new TbSubjectQyCdwgnslTDJ();
            List<TbSubjectQyCdwgnslTDJ> list = new ArrayList<>();
            list.add(tbSubjectQyCdwgnslTDJ);
            return list;
        }

        //通过entity_name查询TB_BASIC_QY_CDXX表中entity_id
        TbSubjectQyCdwgNandYslTDJService tbSubjectQyCdwgNandYslTDJService = new TbSubjectQyCdwgNandYslTDJService();

        List<TbSubjectQyCdwgnslTDJ> list = tbSubjectQyCdwgNandYslTDJService.findAllCdwgNslByEntityIdAndYear(entity_id, year);
        return list;
    }

    //不同机构违规行为月统计表
    //通过entity_id和year和month查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @RequestMapping("/TbSubjectQyCdwgYslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdwgyslTDJ> findAllByEntityIdAndMonth(String entity_id,String year, String month) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            TbSubjectQyCdwgyslTDJ tbSubjectQyCdwgyslTDJ = new TbSubjectQyCdwgyslTDJ();
            List<TbSubjectQyCdwgyslTDJ> list = new ArrayList<>();
            list.add(tbSubjectQyCdwgyslTDJ);
            return list;
        }

        TbSubjectQyCdwgNandYslTDJService tbSubjectQyCdwgNandYslTDJService = new TbSubjectQyCdwgNandYslTDJService();
        List<TbSubjectQyCdwgyslTDJ> list = tbSubjectQyCdwgNandYslTDJService.findAllCdwgYslByEntityIdAndMonth(entity_id,year, month);
        return list;
    }

    //不同机构违规行为年统计表
    //通过entity_id、year和month查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    @RequestMapping("/TbSubjectQyCdwgNandYslTDJ")
    public @ResponseBody
    Map<String,Object> findAllMapByEntityIdAndYearAndMonth(String entity_id, String year, String month) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            //组合map
            Map<String,Object> map=new LinkedHashMap<>();
            map.put("thisYear",null);
            map.put("thisMonth",null);
            return map;
        }

        TbSubjectQyCdwgNandYslTDJService tbSubjectQyCdwgNandYslTDJService = new TbSubjectQyCdwgNandYslTDJService();
        //查询map
        Map<String,Object>  map= tbSubjectQyCdwgNandYslTDJService.findAllMapByEntityIdAndYearAndMonth(entity_id,year,month);
        return map;
    }
}
