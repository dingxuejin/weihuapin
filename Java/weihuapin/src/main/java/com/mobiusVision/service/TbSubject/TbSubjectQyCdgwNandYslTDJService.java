package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyCdgwNandYslTDJMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdgwYslTDJ;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:违规驾驶类型代码年度和月度表查询业务逻辑
 * @Date:Created in 11:12 2018/6/19/019
 * @Modify By:
 **/
public class TbSubjectQyCdgwNandYslTDJService {


    //通过entity_id和year查询TB_SUBJECT_QY_WGNSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年的数据（企业必选，年份不必须））
    public List<TbSubjectQyCdgwNslTDJ> findListGwNslByEntityIdAndYear(String entity_id, String year){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdgwNandYslTDJMapper tbSubjectQyCdgwNandYslTDJMapper =(TbSubjectQyCdgwNandYslTDJMapper)aplc.getBean("tbSubjectQyCdgwNandYslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdgwNslTDJ> list = null;
        //如果无year参数，则返回当年的参数
        if (year == null){
            list = tbSubjectQyCdgwNandYslTDJMapper.findListGwNslByEntityIdAndYear(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdgwNandYslTDJMapper.findListGwNslByEntityIdAndYear(entity_id, year);

        return list;
    }

    //通过entity_id、year和month查询TB_SUBJECT_QY_WGNSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一月的数据（企业必选，月份和年份不必须））
    public List<TbSubjectQyCdgwYslTDJ> findAllListGwYslByEntityIdAndYearAndMonth(String entity_id, String year, String month){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdgwNandYslTDJMapper tbSubjectQyCdgwNandYslTDJMapper =(TbSubjectQyCdgwNandYslTDJMapper)aplc.getBean("tbSubjectQyCdgwNandYslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdgwYslTDJ>  list = null;
        //如果无year参数，则返回当年的参数
        if (month == null){
            list = tbSubjectQyCdgwNandYslTDJMapper.findAllListGwYslByEntityIdAndYearAndMonth(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdgwNandYslTDJMapper.findAllListGwYslByEntityIdAndYearAndMonth(entity_id,year,month);

        return list;
    }

    //通过entity_id、year和month查询TB_SUBJECT_QY_WGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_WGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    public Map<String,Object> findAllMapByEntityIdAndYearAndMonth(String entity_id, String year, String month){

//        List<TbSubjectQyCdwgnslTDJ> listNian=findAllByEntityIdAndYear();
        //年份高危驾驶行为列表
        List<TbSubjectQyCdgwNslTDJ> listTbN=findListGwNslByEntityIdAndYear(entity_id,year);

        //排序


        //月份高危驾驶行为列表
        List<TbSubjectQyCdgwYslTDJ> listTbY=findAllListGwYslByEntityIdAndYearAndMonth(entity_id,year,month);

        //组合map
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("thisYear",listTbN);
        map.put("thisMonth",listTbY);
        return map;
    }
}
