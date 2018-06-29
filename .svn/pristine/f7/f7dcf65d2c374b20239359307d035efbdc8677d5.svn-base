package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectJxjyARemainTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员教育周期相关接口
 * @Date:Created in 15:47 2018/6/21/021
 * @Modify By:
 **/
public interface TbSubjectJxjyMapper {

    //通过driver_id查询tb_subject_jxjy表及其到期天数和未学习时间数据
    public List<TbSubjectJxjyARemainTime> findJxjyRemainByDriverId(@Param("driver_id")String driver_id);
}
