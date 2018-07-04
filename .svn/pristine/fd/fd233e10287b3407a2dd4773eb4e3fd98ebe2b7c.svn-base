package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyMryd;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMyyd;
import com.mobiusVision.util.ApplicationContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:44 2018/7/3/003
 * @Modify By:
 **/
public class TbSubjectQyMYRydMapperTest {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectQyMYRydMapper tbSubjectQyMYRydMapper =(TbSubjectQyMYRydMapper)aplc.getBean("tbSubjectQyMYRydMapper");

    @Test
    public void findMYYDAllYearMonthByEId() {
        List<String> month=new ArrayList<>();
        month.add("01");
        month.add("02");
        List<TbSubjectQyMyyd> tbSubjectQyMyydList=tbSubjectQyMYRydMapper.findMYYDAllYearMonthByEId("1310000010000000",null,null);
        List<TbSubjectQyMryd> tbSubjectQyMrydList=tbSubjectQyMYRydMapper.findMYYDAllDayByEId("1310000010000000","2017","11");
    }
}