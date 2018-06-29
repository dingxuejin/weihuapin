package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectJy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员区域驾驶经验（入职之前经验）
 * @Date:Created in 11:06 2018/6/27/027
 * @Modify By:
 **/
public interface TbSubjectJyMapper {
    //TB_SUBJECT_JY档案人员记录中，通过driver_id查询历史经验
    public List<TbSubjectJy> findAllJyByDid(@Param("driver_id") String driver_id);
}
