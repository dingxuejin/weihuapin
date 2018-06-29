package com.mobiusVision.pojo.TbSubject;
//通过entity_id查询TB_SUBJECT_QY_NDTXCB和TB_SUBJECT_QY_NDRLCB表中最新数据
public class TbSubjectQyNdtxcbTDJ extends TbSubjectQyNdtxcb {
    private TbSubjectQyNdrlcb tbSubjectQyNdrlcb;

    public TbSubjectQyNdrlcb getTbSubjectQyNdrlb() {
        return tbSubjectQyNdrlcb;
    }

    public void setTbSubjectQyNdrlb(TbSubjectQyNdrlcb tbSubjectQyNdrlb) {
        this.tbSubjectQyNdrlcb = tbSubjectQyNdrlb;
    }
}
