<template>
    <div class="pop" v-drag  @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
        <PopUpFrame @close='up'>
            <PopUpWidget :title='data.certificate_name+"信息"'>
                <div class="box">
                    <div class="img" @click="onClickImg(data.picture_address)" >
                        <img :src="data.picture_address" alt="暂无图片" width="100%" height="100%">
                    </div>
                    <div class="echart list_title">
                    <div v-for='(item,index) in title' :key='index'>{{item}}</div> 
                    </div>
                    <div class="echart value">
                        <div :title="data.certificate_name"><span></span>{{data.certificate_name}}</div>
                        <div :title="data.issuing_authority"><span></span>{{data.issuing_authority}}</div>
                        <div :title="data.effective_date"><span></span>{{data.effective_date}}</div>
                        <div :title="data.expire_date"><span></span>{{data.expire_date}}</div>
                    </div>
                </div>
            </PopUpWidget>
        </PopUpFrame>
    </div>
</template>

<script>
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'

export default{
  props: ['data'],
  components: {
    PopUpFrame,
    PopUpWidget,
  },
  methods: {
    up() {
      this.$emit('upx')
    },
    onClickImg(v) {
      this.$emit('onClickImg', v)
    },
  },
  data() {
    return {
      title: ['证书名称', '发证机构', '有效期始', '有效期止'],
    //   data: ['健康、安全与环境管理体系认证证书', '北京新世纪检验有限公司', '2017-12-26', '2018-12-26'],
      move: false,
    }
  },
}
</script>

<style lang="scss" scoped>
.pop{
    width:550px;
    left: -160px;
    top: -110px;
}
.img{
    width: 140px;
    cursor: pointer;
}
.box{
    display: flex;
    justify-content: center;
}
.list_title{
    padding: 0 30px;
}
.echart{
    width: 100px;
    overflow: hidden;
    div{
        width:100px;
        font-size:16px;
        color:#89dddf;
        height: 30px;
        line-height:30px;
        margin:0px 0px 10px 10px;
        float: left;
    }
}
.value{
    width: 200px;
    div{
        width: 190px;
        background:rgba(3,139,252,.4);
        height: 30px;
        color:#ffffff;
        line-height:30px;
        margin-bottom:0px;
        overflow: hidden;
        text-overflow:ellipsis;
        white-space: nowrap;
        margin:0px 0px 10px 10px;
        span{
            display: inline-block;
            width: 10px;
            height:10px;
            margin: 0 15px;
            background-color: #05D0EB ;
            transform: rotate(45deg);
        }
    }
}
</style>