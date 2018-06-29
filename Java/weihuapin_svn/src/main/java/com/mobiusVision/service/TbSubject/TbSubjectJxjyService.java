package com.mobiusVision.service.TbSubject;

import com.mobiusVision.dao.TbSubject.TbSubjectJxjyMapper;
import com.mobiusVision.pojo.TbSubject.TbSubjectJxjyARemainTime;
import com.mobiusVision.util.ApplicationContextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员教育周期相关接口
 * @Date:Created in 16:46 2018/6/21/021
 * @Modify By:
 **/
public class TbSubjectJxjyService {

    //通过driver_id查询tb_subject_jxjy表及其到期天数和未学习时间数据
    public List<TbSubjectJxjyARemainTime> findJxjyRemainByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbSubjectJxjyMapper tbSubjectJxjyMapper =(TbSubjectJxjyMapper)aplc.getBean("tbSubjectJxjyMapper");

        List<TbSubjectJxjyARemainTime> tbSubjectJxjyARemainTimeList=tbSubjectJxjyMapper.findJxjyRemainByDriverId(driver_id);

        return tbSubjectJxjyARemainTimeList;
    }
}
