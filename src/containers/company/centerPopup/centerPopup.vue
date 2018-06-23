<template>
  <div class="pop" v-drag  @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
    <PopUpFrame @close='up'>
      <PopUpWidget title='最近一次事故信息'>
        <div class="echart">
          <div v-for='(item,index) in title' :key='index'>{{item}}</div>
        </div>
        <div class="echart value"
             v-if="recentlyAccdient"
             v-for="(item,index) in recentlyAccdient"
             :key='index'>
          <div>{{item.ryjb.name}}</div>
          <el-tooltip class="item" effect="dark" :content="item.accidenttype_time" placement="top">
            <div>{{item.accidenttype_time}}</div>
          </el-tooltip>
          <el-tooltip class="item" effect="dark" :content="item.accident_location" placement="top">
            <div>{{item.accident_location}}</div>
          </el-tooltip>
          <div>{{item.sgdj.accident_level}}</div>
          <div>{{item.sgzr.accident_responsibility}}</div>
          <div>{{item.sfxl.if_hm_release}}</div>
          <el-tooltip class="item" effect="dark" :content="item.accident_cause" placement="top">
            <div>{{item.accident_cause}}</div>
          </el-tooltip>
          <el-tooltip class="item" effect="dark" :content="item.accident_loss" placement="top">
            <div>{{item.accident_loss}}</div>
          </el-tooltip>
          <el-tooltip class="item" effect="dark" :content="item.accident_status" placement="top">
            <div>{{item.accident_status}}</div>
          </el-tooltip>
        </div>
      </PopUpWidget>
    </PopUpFrame>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'

export default {
  components: {
    PopUpFrame,
    PopUpWidget,
  },
  computed: {
    ...mapState('centerPopup', ['recentlyAccdient']),
  },
  methods: {
    up() {
      this.$emit('upx')
    },
  },
  data() {
    return {
      move: false,
      title: [
        '驾驶员',
        '事故时间',
        '事故地点',
        '事故等级',
        '事故责任',
        '危化品是否泄漏',
        '事故原因',
        '事故损失',
        '事故处理进度描述',
      ],
      value: [
        '王蒙',
        '2017-12-26',
        '广东省汕头市潮南',
        '特大事故',
        '完全责任',
        '否',
        '变道时没给后车留空间',
        '支付对方车辆维护费用',
        '交警部分已出具事罚单',
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.pop {
  width: 900px;
}
.echart {
  overflow: hidden;
  div {
    width: 70px;
    font-size: 16px;
    color: #89dddf;
    margin: 0px 0px 10px 10px;
    float: left;
    text-align: center;
  }
  div:nth-child(1) {
    margin-left: 0px;
    width: 70px;
  }
  div:nth-child(6) {
    width: 120px;
  }
  div:last-child{
    width: 150px;
  }
}
.value {
  div {
    background: rgba(3, 139, 252, 0.4);
    height: 30px;
    font-size: 14px;
    color: #ffffff;
    line-height: 30px;
    margin-bottom: 0px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}
</style>