package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectKhExtends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员运输的客户相关接口
 * @Date:Created in 10:15 2018/6/28/028
 * @Modify By:
 **/
public interface TbSubjectKhMapper {

    //TB_SUBJECT_KH档案人员记录中，TB_BASIC_QY_HZSXX运营企业6-13，通过driver_id查询人员当年运单数的客户统计
    public List<TbSubjectKhExtends> findKuHzsYearByDId(@Param("driver_id")String driver_id);

    //TB_SUBJECT_KH档案人员记录中，TB_BASIC_QY_HZSXX运营企业6-13，通过driver_id查询人员当月运单数的客户统计
    public List<TbSubjectKhExtends> findKuHzsMonthByDId(@Param("driver_id")String driver_id);
}
