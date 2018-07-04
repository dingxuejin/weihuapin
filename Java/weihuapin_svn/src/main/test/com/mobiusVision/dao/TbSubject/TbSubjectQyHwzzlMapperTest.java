package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyHwzzl;
import com.mobiusVision.util.ApplicationContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:51 2018/7/3/003
 * @Modify By:
 **/
public class TbSubjectQyHwzzlMapperTest {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectQyHwzzlMapper tbSubjectQyHwzzlMapper =(TbSubjectQyHwzzlMapper)aplc.getBean("tbSubjectQyHwzzlMapper");

    @Test
    public void findHwzzlAllYearMonthByEId() {
        List<String> month=new ArrayList<>();
        month.add("01");
        month.add("02");
        List<TbSubjectQyHwzzl> tbSubjectQyHwzzlList=tbSubjectQyHwzzlMapper.findHwzzlAllYearMonthByEId("1310000010000000","2014",null);
    }
}