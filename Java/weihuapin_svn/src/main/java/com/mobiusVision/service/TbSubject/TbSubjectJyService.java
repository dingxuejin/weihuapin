package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectJyMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectJy;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员区域驾驶经验（入职之前经验）
 * @Date:Created in 11:15 2018/6/27/027
 * @Modify By:
 **/
public class TbSubjectJyService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbSubjectJyMapper tbSubjectJyMapper =(TbSubjectJyMapper)aplc.getBean("tbSubjectJyMapper");

    //TB_SUBJECT_JY档案人员记录中，通过driver_id查询历史经验
    public List<TbSubjectJy> findAllJyByDid(String driver_id){

        List<TbSubjectJy> tbSubjectJyList=tbSubjectJyMapper.findAllJyByDid(driver_id);

        return tbSubjectJyList;
    }
}
