package com.mobiusVision.dao.TbSubject;

import com.mobiusVision.pojo.TbSubject.TbSubjectQyHwzzl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:企业年月周转量统计表
 * @Date:Created in 15:46 2018/7/3/003
 * @Modify By:
 **/
public interface TbSubjectQyHwzzlMapper {

    //通过entity_id查询所有年和某年所有月或部分月的信息
    public List<TbSubjectQyHwzzl> findHwzzlAllYearMonthByEId(
            @Param("entity_id")String entity_id,
            @Param("year")String year,
            @Param("monthlist") List<String> monthlist);
}
