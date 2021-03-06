package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyJyzkdcpmMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkdcpm;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.List;

public class TbSubjectQyJyzkdcpmService {
    ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
    TbSubjectQyJyzkdcpmMapper tbSubjectQyJyzkdcpmMapper = (TbSubjectQyJyzkdcpmMapper) aplc.getBean("tbSubjectQyJyzkdcpmMapper");

    //根据year,entity_id查询年单车排名，年单车收入变化趋势
    public TbSubjectQyJyzkdcpm queryRankingByYearAndEntityId(String year, String entity_id) {

        //获取当前企业所有年排名
        List<TbSubjectQyJyzkdcpm> list = queryAllByEntityId(entity_id);

        //数据存放处

        TbSubjectQyJyzkdcpm tbSubjectQyJyzkdcpm = new TbSubjectQyJyzkdcpm();
        //获取某年的数据
        for (TbSubjectQyJyzkdcpm tmp : list) {
            if (year.equals(tmp.getYear())) {
                tbSubjectQyJyzkdcpm.setYear_ranking_change_code(tmp.getYear_ranking_change_code());
                tbSubjectQyJyzkdcpm.setYear_ranking(tmp.getYear_ranking());
            }
        }
        list = tbSubjectQyJyzkdcpmMapper.queryEntityCount();
        for (TbSubjectQyJyzkdcpm tmp : list) {
            tbSubjectQyJyzkdcpm.setEntity_count(tmp.getEntity_count());
        }
        return tbSubjectQyJyzkdcpm;
    }
    //根据当前年月返回月排名和公司总数
    public List<TbSubjectQyJyzkdcpm> queryRankingEntityCountByEntityIdAndYearAndMonth(String entity_id, String year, String month) {
        List<TbSubjectQyJyzkdcpm> list = null;
        if(year==null||month==null){
            list = tbSubjectQyJyzkdcpmMapper.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id,Integer.toString(Calendar.getInstance().get(Calendar.YEAR)),Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));
            return list ;
        }else{
            list = tbSubjectQyJyzkdcpmMapper.queryRankingEntityCountByEntityIdAndYearAndMonth(entity_id,year,month);
            return list;
        }
    }
    //根据entity_id查询企业年单车收入排名，年份，年单车总收入，年排名变化趋势
    public List<TbSubjectQyJyzkdcpm> queryAllByEntityId(String entity_id) {
        List<TbSubjectQyJyzkdcpm> list = null;
        list = tbSubjectQyJyzkdcpmMapper.queryAllByEntityId(entity_id);
        for (TbSubjectQyJyzkdcpm tmp : list) {
            for (TbSubjectQyJyzkdcpm tmp1 : list) {
                if ((Integer.parseInt(tmp.getYear()) - 1) == Integer.parseInt(tmp1.getYear())) {
                    if ((Double.parseDouble(tmp.getYear_average_income()) - Double.parseDouble(tmp1.getYear_average_income())) > 0)
                        tmp.setYear_ranking_change_code("1");
                    else
                        tmp.setYear_ranking_change_code("0");
                }

            }
        }
        return list;
    }

    //根据entity_id、year查询月排名和月排名变化趋势
    public List<TbSubjectQyJyzkdcpm> queryAllByEntityIdAndYear(String entity_id, String year) {
        List<TbSubjectQyJyzkdcpm> list = null;
        list = tbSubjectQyJyzkdcpmMapper.queryAllByEntityIdAndYear(entity_id,year);
        try {
            for (TbSubjectQyJyzkdcpm tmp : list) {
                for (TbSubjectQyJyzkdcpm tmp1 : list) {
                    if ((Integer.parseInt(tmp.getMonth()) - 1) == Integer.parseInt(tmp1.getMonth())) {
                        if ((Double.parseDouble(tmp.getAverage_income()) - Double.parseDouble(tmp1.getAverage_income())) > 0) {
                            tmp.setRanking_change_code1("1");
                        } else {
                            tmp.setRanking_change_code1("0");
                        }
                    }
                }
            }
        }catch (NumberFormatException e){
            return null;
        }
        return list;
    }

}


