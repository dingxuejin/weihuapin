package com.mobiusVision.test;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyCdwgnslTDJ;
import com.mobiusVision.service.TbSubject.TbSubjectQyCdwgNandYslTDJService;
import org.junit.Test;

import java.util.List;

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
        System.out.println(entity_id);

    }

}