package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectLsxlydMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectLsxlyd;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员历史线路运单统计（人员本企业数据）
 * @Date:Created in 11:50 2018/6/27/027
 * @Modify By:
 **/
public class TbSubjectLsxlydService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectLsxlydMapper tbSubjectLsxlydMapper =(TbSubjectLsxlydMapper)aplc.getBean("tbSubjectLsxlydMapper");

    //TB_SUBJECT_LSXLYD档案人员记录中，通过driver_id查询本企业历史线路统计
    public List<TbSubjectLsxlyd> findAllLsxlydByDid(String driver_id){
        List<TbSubjectLsxlyd> tbSubjectLsxlydList=tbSubjectLsxlydMapper.findAllLsxlydByDid(driver_id);
        return tbSubjectLsxlydList;
    }
}
