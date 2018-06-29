package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyCdwgnslTDJMapper;
import com.mobiusVision.dao.TbSubject.TbSubjectQyCdwgyslTDJMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgnslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgyslTDJ;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:05 2018/6/15/015
 * @Modify By:
 **/
public class TbSubjectQyCdwgNandYslTDJService {

    //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年的数据（企业必选，年份不必须））
    public List<TbSubjectQyCdwgnslTDJ> findAllCdwgNslByEntityIdAndYear(String entity_id, String year){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdwgnslTDJMapper tbSubjectQyCdwgnslTDJMapper=(TbSubjectQyCdwgnslTDJMapper)aplc.getBean("tbSubjectQyCdwgnslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdwgnslTDJ> list = null;
        //如果无year参数，则返回当年的参数
        if (year == null){
            list = tbSubjectQyCdwgnslTDJMapper.findAllByEntityIdAndYear(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdwgnslTDJMapper.findAllByEntityIdAndYear(entity_id, year);

        return list;
    }

    //通过entity_id、year和month查询TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一月的数据（企业必选，月份和年份不必须））
    public List<TbSubjectQyCdwgyslTDJ> findAllCdwgYslByEntityIdAndMonth(String entity_id,String year, String month){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectQyCdwgyslTDJMapper tbSubjectQyCdwgyslTDJMapper=(TbSubjectQyCdwgyslTDJMapper)aplc.getBean("tbSubjectQyCdwgyslTDJMapper");

        //通过entity_id和year查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表中所有数据
        List<TbSubjectQyCdwgyslTDJ>  list = null;
        //如果无year参数，则返回当年的参数
        if (month == null){
            list = tbSubjectQyCdwgyslTDJMapper.findAllByEntityIdAndYearAndMonth(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
        }
        else
            //如果有year参数
            list = tbSubjectQyCdwgyslTDJMapper.findAllByEntityIdAndYearAndMonth(entity_id,year,month);

        return list;
    }

    //通过entity_id、year和month查询TB_SUBJECT_QY_CDWGNSL表和TB_DICTIONARY_JSSJLX表、TB_SUBJECT_QY_CDWGYSL表和TB_DICTIONARY_JSSJLX表中所有数据（查询企业中哪一年和月的总数据（企业必选，年份和月份不必须））
    public Map<String,Object> findAllMapByEntityIdAndYearAndMonth(String entity_id, String year, String month){

//        List<TbSubjectQyCdwgnslTDJ> listNian=findAllByEntityIdAndYear();
        //年份高危驾驶行为列表
        List<TbSubjectQyCdwgnslTDJ> listTbN=findAllCdwgNslByEntityIdAndYear(entity_id,year);

        //排序


        //月份高危驾驶行为列表
        List<TbSubjectQyCdwgyslTDJ> listTbY=findAllCdwgYslByEntityIdAndMonth(entity_id,year,month);

        //组合map
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("thisYear",listTbN);
        map.put("thisMonth",listTbY);
        return map;
    }
}
