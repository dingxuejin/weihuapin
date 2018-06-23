package com.mobiusVision.controller.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwYslTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdgwNandYslTDJService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:不同企业高危驾驶行为
 * @Date:Created in 11:23 2018/6/19/019
 * @Modify By:
 **/
@Controller
public class TbSubjectQyCdgwNandYslTDJController {

    //不同机构违规行为年统计表
    //通过entity_id和year查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @RequestMapping("/TbSubjectQyCdgwNslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdgwNslTDJ> findAllByEntityIdAndYear(String entity_id, String year) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyCdgwNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdgwNandYslTDJService();
        List<TbSubjectQyCdgwNslTDJ> list = tbSubjectQyCdgwNandYslTDJService.findListGwNslByEntityIdAndYear(entity_id, year);
        return list;
    }

    //不同机构违规行为月统计表
    //通过entity_id和year和month查询TB_SUBJECT_QY_CDGWNSL表和TB_DICTIONARY_JSSJLX表中所有数据(返回哪一年的数据)
    @RequestMapping("/TbSubjectQyCdgwYslTDJ")
    public @ResponseBody
    List<TbSubjectQyCdgwYslTDJ> findAllByEntityIdAndMonth(String entity_id, String year, String month) {
        //没有公司名称，返回基础NULL
        if (entity_id == null) {
            return null;
        }

        TbSubjectQyCdgwNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdgwNandYslTDJService();
        List<TbSubjectQyCdgwYslTDJ> list = tbSubjectQyCdgwNandYslTDJService.findAllListGwYslByEntityIdAndYearAndMonth(entity_id,year, month);
        return list;
    }

    //不同机构违规行为年统计表
    //通过entity_id、year和month查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    @RequestMapping("/TbSubjectQyCdgwNandYslTDJ")
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

        TbSubjectQyCdgwNandYslTDJService tbSubjectQyCdgwNandYslTDJService = new TbSubjectQyCdgwNandYslTDJService();
        //查询map
        Map<String,Object>  map= tbSubjectQyCdgwNandYslTDJService.findAllMapByEntityIdAndYearAndMonth(entity_id,year,month);
        return map;
    }
}
