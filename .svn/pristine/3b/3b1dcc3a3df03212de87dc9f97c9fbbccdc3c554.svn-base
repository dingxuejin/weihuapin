package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyMYRydMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMryd;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyMyyd;
import com.mobiusVision.util.ApplicationContextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:企业年月日运单统计表
 * @Date:Created in 15:03 2018/7/3/003
 * @Modify By:
 **/
public class TbSubjectQyMYRydService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectQyMYRydMapper tbSubjectQyMYRydMapper =(TbSubjectQyMYRydMapper)aplc.getBean("tbSubjectQyMYRydMapper");

    //通过entity_id查询所有年和某年所有月或部分月的运单统计信息
    public List<TbSubjectQyMyyd> findMYYDAllYearMonthByEId(
            String entity_id,
            String year,
            List<String> monthlist){
        List<TbSubjectQyMyyd> tbSubjectQyMyydList=tbSubjectQyMYRydMapper.findMYYDAllYearMonthByEId(entity_id,year,monthlist);
        return tbSubjectQyMyydList;
    }

    //通过entity_id查询某年某月所有天的运单统计信息
    public List<TbSubjectQyMryd> findMYYDAllDayByEId(
            String entity_id,
            String year,
            String month){
        List<TbSubjectQyMryd> tbSubjectQyMrydList=tbSubjectQyMYRydMapper.findMYYDAllDayByEId(entity_id,year,month);
        return tbSubjectQyMrydList;
    }

}
