package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyJyzkpmMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyJyzkpm;
import com.mobiusVision.util.ApplicationContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.*;

import static org.junit.Assert.*;

public class TbSubjectQyJyzkpmServiceTest {

    @Test

    public void queryAllByEntityId() {
        ApplicationContext aplc = ApplicationContextUtil.getApplicationContext();
        TbSubjectQyJyzkpmMapper tbSubjectQyJyzkpmMapper = (TbSubjectQyJyzkpmMapper) aplc.getBean("tbSubjectQyJyzkpmMapper");
        List<TbSubjectQyJyzkpm> list = null;
        list = tbSubjectQyJyzkpmMapper.queryAllByEntityId("1310000010010000");
        Map<String, Integer> paiming = new HashMap<>();
        for (TbSubjectQyJyzkpm tmp : list) {
            for (TbSubjectQyJyzkpm tmp1 : list) {
                if ((Integer.parseInt(tmp.getYear()) - 1) == Integer.parseInt(tmp1.getYear())) {
                    if ((Double.parseDouble(tmp.getYear_income()) - Double.parseDouble(tmp1.getYear_income())) > 0)
                        paiming.put(tmp.getYear(), 1);
                    else
                        paiming.put(tmp.getYear(), 0);
                }
            }

        }
        int a = 1;
    }

    @Test
    public void queryRankingByYearAndEntityId() {
        TbSubjectQyJyzkpmService t =new TbSubjectQyJyzkpmService();
        t.queryRankingByYearAndEntityId("2017","1310000010010000");
        System.out.println(t);
    }

    }



