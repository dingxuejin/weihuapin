<template>
  <div>
    <!-- 标题 -->
    <pop-up-widget title="培训信息"></pop-up-widget>

    <!-- 数据内容 -->
    <div class="trainContent clearfix">
      <div class="itemTypeCon clearfix">
        <div :class="{itemTypeActive:activeIndex === item.value}"
             v-for="(item,index) in trainingThemeCode"
             :key='index'
             @click="currentTypeActive(item.value)">{{item.label}}</div>
      </div>

      <div class="itemContent">
        <div class="titleCon clearfix">
          <div>累计培训次数</div>
          <div>累计培训时长</div>
          <div>培训通过率</div>
          <div>最近一次培训时间</div>
        </div>
        <div class="indexCon clearfix" v-if="popUpTrainInfo">
          <div>{{popUpTrainInfo['count(driver_id)']}}</div>
          <div>{{popUpTrainInfo['sum(training_hours)']}}h</div>
          <div>{{popUpTrainInfo['pass_rate']}}</div>
          <div>{{formatDate(popUpTrainInfo['last_px_date'])}}</div>
        </div>
      </div>
      <div class="popupTime" v-if="SubjectInfo&&SubjectInfo.length>0">
        <div>本周期继续教育剩余时间：{{SubjectData.remaining_days}}天</div>
        <div>未完成学时：{{SubjectData.remaining_time}}h</div>
      </div>
      <!-- 弹窗按钮 -->
      <div class="popupBtn"
           @click="popTrain = true">培训信息统计</div>

      <!-- 培训信息统计 -->
      <div class="trainCountInfoCon"
           v-if="popTrain">
        <pop-up-frame @close="popTrain = false">
          <train-count-info></train-count-info>
        </pop-up-frame>
      </div>
  <div v-show="false">{{SubjectTimeColor1()}}</div> 
    </div>

  </div>
</template>

<script type="text/javascript">
/* eslint-disable */
import { mapState, mapActions,mapMutations } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'
import PopUpFrame from '../../../components/PopUpFrame'
// 二级弹窗
import TrainCountInfo from '../../driverPopup/traincountinfo/TrainCountInfo'

import Dictionary from '../../../util/dictionary'

const { trainingThemeCode } = Dictionary

export default {
  name: '',
  components: {
    PopUpFrame,
    PopUpWidget,
    TrainCountInfo,
  },
  data() {
    return {
      activeIndex: 10,
      popTrain: false,
      trainingThemeCode,
    }
  },
  methods: {
    ...mapActions('popuptraininfo', ['getPopUpTrainInfo']),
    ...mapMutations('popuptraininfo',['setSubjectTimeColor']),
    currentTypeActive(index) {
      this.activeIndex = index
      this.getPopUpTrainInfo({
        driver_id: this.ryjb.driver_id,
        training_theme_code: index,
      })
    },
    SubjectTimeColor1(){
      this.setSubjectTimeColor(this.SubjectDataColor)
      // console.log(this.SubjectDataColor)
    }
  },
  computed: {
    ...mapState('popuptraininfo', ['popUpTrainInfo', 'SubjectInfo']),
    ...mapState('driverbase', ['ryjb']),
    SubjectData() {
      if (this.SubjectInfo) {
        return {
          remaining_days: Number(this.SubjectInfo[0].remaining_days),
          remaining_time: Number(this.SubjectInfo[0].remaining_time),
        }
      }
      return ''
    },
    SubjectDataColor(){
      if(this.SubjectInfo){
        const color=Number(this.SubjectInfo[0].remaining_time)
        // console.log(color)
        if(color<24&&color>0){
          return 1
        } else if (color>24){
          return 0
        }
      }
    }
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
@mixin font_level_4_1 {
  color: #b5b5b5;
  font-size: 14px;
}
@mixin pop_off {
  background: rgba(0, 91, 127, 0.5);
}
@mixin pop_on {
  background: rgba(0, 91, 127, 1);
}
@mixin box_off {
  background: rgba(0, 191, 229, 0.2);
  border: 1px solid rgba(0, 191, 229, 1);
}
.trainContent {
  width: 100%;
  height: 100%;
  position: relative;
  // background: pink;

  // 切换数据种类
  .itemTypeCon {
    @include size(100%,25px);
    overflow: hidden;
    // background:green;
    div {
      @include size(170px,25px);
      float: left;
      box-sizing: border-box;
      @include box_off;
      @include font_level_4_1;
      text-align: center;
      line-height: 23px;
      cursor: pointer;
    }
    div:nth-child(n + 2) {
      margin-left: 10px;
    }
    .itemTypeActive {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
  }

  // 数据内容包裹
  .itemContent {
    @include size(100%,68px);
    overflow: hidden;
    margin-top: 10px;
    // background:red;

    // 标题
    .titleCon > div {
      @include size(170px,18px);
      box-sizing: border-box;
      @include font_level_4_1;
      float: left;
      text-align: center;
      line-height: 16px;
      background: rgba(0, 191, 229, 0.2);
      border: 1px solid rgba(0, 191, 229, 1);
    }
    .titleCon > div:nth-child(n + 2) {
      margin-left: 10px;
    }

    // 参数
    .indexCon {
      margin-top: 10px;
    }
    .indexCon > div {
      @include size(170px,40px);
      float: left;
      overflow: hidden;
      color: #fff;
      font-size: 22px;
      text-align: center;
      line-height: 40px;
      background: rgba(3, 139, 252, 0.4);
    }
    .indexCon > div:nth-child(n + 2) {
      margin-left: 10px;
    }
  }
  .popupTime{
    @include size(434px,30px);
    float: left;
    margin-top: 10px;
    div{
      background: rgba(0, 191, 229, 0.5);
      float: left;
      font-size: 16px;
      color: #fff;
      line-height: 30px;
      text-align:center;
      &:nth-child(1){
        @include size(254px,30px);
        margin-right:10px;
      }
      &:nth-child(2){
        @include size(170px,30px);
      }
    }
  }
  // popupbtn
  .popupBtn {
    @include size(200px,30px);
    overflow: hidden;
    float: right;
    margin-top: 10px;
    @include pop_off;
    color: #b5b5b5;
    font-size: 16px;
    text-align: center;
    line-height: 30px;
    cursor: pointer;
  }
  .popupBtn:hover {
    color: #fff;
  }
  .popupBtn:visited {
    color: #fff;
    @include pop_on;
  }

  // 二级弹窗包裹
  .trainCountInfoCon {
    width: 750px;
    min-height: 200px;
    position: absolute;
    top: -20px;
    left: 500px;
    background: green;
  }
}
</style>