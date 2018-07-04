package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectQyHwzzlMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectQyHwzzl;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:企业年月周转量统计表
 * @Date:Created in 15:55 2018/7/3/003
 * @Modify By:
 **/
public class TbSubjectQyHwzzlService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectQyHwzzlMapper tbSubjectQyHwzzlMapper =(TbSubjectQyHwzzlMapper)aplc.getBean("tbSubjectQyHwzzlMapper");

    //通过entity_id查询所有年和某年所有月或部分月的周转量统计信息
    public List<TbSubjectQyHwzzl> findHwzzlAllYearMonthByEId(
            String entity_id,
            String year,
            List<String> monthlist){
        List<TbSubjectQyHwzzl> tbSubjectQyHwzzlList=tbSubjectQyHwzzlMapper.findHwzzlAllYearMonthByEId(entity_id,year,monthlist);
        return tbSubjectQyHwzzlList;
    }
}
