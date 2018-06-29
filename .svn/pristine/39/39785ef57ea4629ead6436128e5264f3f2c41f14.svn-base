package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectLsxlyd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员历史线路运单统计（人员本企业数据）
 * @Date:Created in 11:18 2018/6/27/027
 * @Modify By:
 **/
public interface TbSubjectLsxlydMapper {

    //TB_SUBJECT_LSXLYD档案人员记录中，通过driver_id查询本企业历史线路统计
    public List<TbSubjectLsxlyd> findAllLsxlydByDid(@Param("driver_id") String driver_id);
}
