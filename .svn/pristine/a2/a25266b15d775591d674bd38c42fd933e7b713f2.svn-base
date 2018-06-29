package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectKhMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectKhExtends;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:人员运输的客户相关接口
 * @Date:Created in 10:24 2018/6/28/028
 * @Modify By:
 **/
public class TbSubjectKhService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectKhMapper tbSubjectKhMapper =(TbSubjectKhMapper)aplc.getBean("tbSubjectKhMapper");

    //TB_SUBJECT_KH档案人员记录中，TB_BASIC_QY_HZSXX运营企业6-13，通过driver_id查询人员当年运单数的客户统计
    public List<TbSubjectKhExtends> findKuHzsYearByDId(String driver_id){
        List<TbSubjectKhExtends> tbSubjectKhExtendsList=tbSubjectKhMapper.findKuHzsYearByDId(driver_id);
        return tbSubjectKhExtendsList;
    }

    //TB_SUBJECT_KH档案人员记录中，TB_BASIC_QY_HZSXX运营企业6-13，通过driver_id查询人员当月运单数的客户统计
    public List<TbSubjectKhExtends> findKuHzsMonthByDId(String driver_id){
        List<TbSubjectKhExtends> tbSubjectKhExtendsList=tbSubjectKhMapper.findKuHzsMonthByDId(driver_id);
        return tbSubjectKhExtendsList;
    }

    //查询人员当年和当月客户统计
    public Map<String,Object> findKuHzsYearAMonthByDId(String driver_id){
        //当年当月
        List<TbSubjectKhExtends> tbSubjectKhExtendsListYear=findKuHzsYearByDId(driver_id);
        List<TbSubjectKhExtends> tbSubjectKhExtendsListMonth=findKuHzsMonthByDId(driver_id);

        //返回格式处理
        Map<String,Object> allMap=new LinkedHashMap<>();

        allMap.put("ThisYear",tbSubjectKhExtendsListYear);
        allMap.put("ThisMonth",tbSubjectKhExtendsListMonth);
        return allMap;
    }
}
