package com.mobiusVision.test;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwfNslTDJ;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgnslTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdwfNandYslTDJService;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdwgNandYslTDJService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:09 2018/6/15/015
 * @Modify By:
 **/
public class TbSubjectQyCdwgNandYslTDJServiceTest {


    @Test
    public void findAllCdwgNslByEntityIdAndYear() {
        TbSubjectQyCdwgNandYslTDJService tbSubjectQyCdwgNandYslTDJService =new TbSubjectQyCdwgNandYslTDJService();
        String entity_id="1310000010000000";
        List<TbSubjectQyCdwgnslTDJ> list= tbSubjectQyCdwgNandYslTDJService.findAllCdwgNslByEntityIdAndYear(entity_id,"2017");
        System.out.println(list.get(0).getTb_subject_qy_cdwgnsl_id());

    }


    @Test
    public void TbSubjectQyCdwfNandYslTDJServiceTest() {
        TbSubjectQyCdwfNandYslTDJService tbSubjectQyCdwfNandYslTDJService =new TbSubjectQyCdwfNandYslTDJService();
        String entity_id="1310000010000000";
        Map<String,Object> map= tbSubjectQyCdwfNandYslTDJService.findAllMapByEntityIdAndYearAndMonth(entity_id,"2017","11");
        List<TbSubjectQyCdwfNslTDJ> list=(List<TbSubjectQyCdwfNslTDJ>)map.get("thisYear");
        System.out.println(list.get(0).getTb_subject_qy_cdwfnsl_id());

    }
}