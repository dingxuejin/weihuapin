package com.mobiusVision.pojo.TbSubject;

import com.mobiusVision.pojo.TbDictionary.TbDictionaryJssjlx;

/**
 * @Author: zhangzhirong
 * @Description:不同机构违规行为当年数据表与驾驶行为表对应
 * @Date:Created in 13:51 2018/6/15/015
 * @Modify By:
 **/
public class TbSubjectQyCdwgnslTDJ extends TbSubjectQyCdwgnsl{

    private TbDictionaryJssjlx jssjlx;

    public TbDictionaryJssjlx getJssjlx() {
        return jssjlx;
    }

    public void setJssjlx(TbDictionaryJssjlx jssjlx) {
        this.jssjlx = jssjlx;
    }
}
