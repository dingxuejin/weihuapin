package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyJyzkpmMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkdcpm;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkpm;
import com.mobiusVision.util.ApplicationContextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class TbSubjectQyJyzkpmService {
    ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
    TbSubjectQyJyzkpmMapper tbSubjectQyJyzkpmMapper = (TbSubjectQyJyzkpmMapper) aplc.getBean("tbSubjectQyJyzkpmMapper");

    //根据year,entity_id查询排名
    public TbSubjectQyJyzkpm queryRankingByYearAndEntityId(String year, String entity_id) {

        //获取当前企业所有年排名
        List<TbSubjectQyJyzkpm> list = queryAllByEntityId(entity_id);

        //数据存放处

        TbSubjectQyJyzkpm tbSubjectQyJyzkpm = new TbSubjectQyJyzkpm();
        //获取某年的数据
        for (TbSubjectQyJyzkpm tmp : list) {
            if (year.equals(tmp.getYear())) {
                tbSubjectQyJyzkpm.setYear_ranking_change_code(tmp.getYear_ranking_change_code());
                tbSubjectQyJyzkpm.setYear_ranking(tmp.getYear_ranking());
            }
        }
        list = tbSubjectQyJyzkpmMapper.queryEntityCount();
        for (TbSubjectQyJyzkpm tmp : list) {
            tbSubjectQyJyzkpm.setEntity_count(tmp.getEntity_count());
        }

        return tbSubjectQyJyzkpm;
    }

    //根据entity_id查询企业年收入排名，年份，年总收入，年排名变化趋势
    public List<TbSubjectQyJyzkpm> queryAllByEntityId(String entity_id) {
        List<TbSubjectQyJyzkpm> list = null;
        list = tbSubjectQyJyzkpmMapper.queryAllByEntityId(entity_id);
        for (TbSubjectQyJyzkpm tmp : list) {
            for (TbSubjectQyJyzkpm tmp1 : list) {
                if ((Integer.parseInt(tmp.getYear()) - 1) == Integer.parseInt(tmp1.getYear())) {
                    if ((Double.parseDouble(tmp.getYear_income()) - Double.parseDouble(tmp1.getYear_income())) > 0)
                        tmp.setYear_ranking_change_code("1");
                    else
                        tmp.setYear_ranking_change_code("0");
                }
            }
        }
        return list;
    }
    //根据当前年月返回月排名和公司总数
    public List<TbSubjectQyJyzkpm> queryRankingEntityCountByEntityIdAndYearAndMonth(String entity_id,String year,String month) {
        List<TbSubjectQyJyzkpm> list = null;
        if(year==null||month==null){
            list = tbSubjectQyJyzkpmMapper.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id,Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
            return list ;
        }else{
            list = tbSubjectQyJyzkpmMapper.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id,year,month);
            return list;
        }
    }
    //根据entity_id、year查询排名和排名变化趋势
    public List<TbSubjectQyJyzkpm> queryAllByEntityIdAndYear(String entity_id, String year) {
        ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
        TbSubjectQyJyzkpmMapper tbSubjectQyJyzkpmMapper = (TbSubjectQyJyzkpmMapper) aplc.getBean("tbSubjectQyJyzkpmMapper");

        List<TbSubjectQyJyzkpm> list = null;
        if (year == null) {
            list = tbSubjectQyJyzkpmMapper.queryAllByEntityIdAndYear(entity_id, Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        } else {
            list = tbSubjectQyJyzkpmMapper.queryAllByEntityIdAndYear(entity_id, year);
        }
        return list;
    }

}


