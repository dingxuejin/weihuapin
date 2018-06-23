package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyCdwfNandYslTDJMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfYslTDJ;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:违法驾驶行为年度和月度表查询业务逻辑
 * @Date:Created in 13:24 2018/6/19/019
 * @Modify By:
 **/
public class TbSubjectQyCdwfNandYslTDJService {


    //通过entity_id和year查询TB_SUBJECT_QY_CDWFNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwfNslTDJ> findListWfNslByEntityIdAndYear(String entity_id, String year){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdwfNandYslTDJMapper tbSubjectQyCdwfNandYslTDJMapper =(TbSubjectQyCdwfNandYslTDJMapper)aplc.getBean("tbSubjectQyCdwfNandYslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdwfNslTDJ> list = null;
        //如果无year参数，则返回当年的参数
        if (year == null){
            list = tbSubjectQyCdwfNandYslTDJMapper.findListWfNslByEntityIdAndYear(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdwfNandYslTDJMapper.findListWfNslByEntityIdAndYear(entity_id, year);

        return list;
    }

    //通过entity_id和year和month查询TB_SUBJECT_QY_CDWFNSL表和TB_DICTIONARY_JSSJLX表中所有数据
    public List<TbSubjectQyCdwfYslTDJ> findAllListWfYslByEntityIdAndYearAndMonth(String entity_id, String year, String month){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdwfNandYslTDJMapper tbSubjectQyCdwfNandYslTDJMapper =(TbSubjectQyCdwfNandYslTDJMapper)aplc.getBean("tbSubjectQyCdwfNandYslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdwfYslTDJ>  list = null;
        //如果无year参数，则返回当年的参数
        if (month == null){
            list = tbSubjectQyCdwfNandYslTDJMapper.findAllListWfYslByEntityIdAndYearAndMonth(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdwfNandYslTDJMapper.findAllListWfYslByEntityIdAndYearAndMonth(entity_id,year,month);

        return list;
    }

    //通过entity_id、year和month查询TB_SUBJECT_QY_WGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_WGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    public Map<String,Object> findAllMapByEntityIdAndYearAndMonth(String entity_id, String year, String month){

//        List<TbSubjectQyCdwgnslTDJ> listNian=findAllByEntityIdAndYear();
        //年份高危驾驶行为列表
        List<TbSubjectQyCdwfNslTDJ> listTbN=findListWfNslByEntityIdAndYear(entity_id,year);

        //排序


        //月份高危驾驶行为列表
        List<TbSubjectQyCdwfYslTDJ> listTbY=findAllListWfYslByEntityIdAndYearAndMonth(entity_id,year,month);

        //组合map
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("thisYear",listTbN);
        map.put("thisMonth",listTbY);
        return map;
    }
}
