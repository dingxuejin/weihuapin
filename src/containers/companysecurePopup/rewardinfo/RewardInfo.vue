<template>
  <div>
    <pop-up-widget title="奖励信息"></pop-up-widget>

    <!-- 内容 -->
    <div class="rewardInfoCon">
      <div class="itemContent">
        <div class="titleCon clearfix">
          <div>累计奖励次数</div>
          <div>累计奖励金额</div>
          <div>最近一次奖励时间</div>
          <div>最近一次奖励金额</div>
        </div>

        <div class="indexCon clearfix" v-if="rewardInfo">
          <div>{{qf(rewardInfo['reward_count'])}}</div>
          <div>{{qf(rewardInfo['reward_sum'])}}</div>
          <div>{{formatDate(rewardInfo['lately_date'])}}</div>
          <div>{{qf(rewardInfo['lately_amount'])}}</div>
        </div>
      </div>

      <!-- 弹窗按钮 -->
      <div class="popupBtn"
           @click="popRewardCountInfo = true">奖励统计信息</div>

      <!-- 奖励信息统计 -->
      <div class="rewardCountInfoContainer" v-if="popRewardCountInfo">
          <pop-up-frame @close="popRewardCountInfo = false">
              <reward-count-info></reward-count-info>
          </pop-up-frame>
      </div>

    </div>

  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpFrame from '../../../components/PopUpFrame'
import PopUpWidget from '../../../components/PopUpWidget'
import RewardCountInfo from '../../driverPopup/rewardcountinfo/RewardCountInfo'

export default {
  name: 'rewardInfo',
  components: {
    PopUpFrame,
    PopUpWidget,
    RewardCountInfo,
  },
  computed: {
    ...mapState('rewardinfo', ['rewardInfo']),
    ...mapState('driverbase', ['ryjb']),
  },
  methods: {
    ...mapActions('rewardinfo', ['getRewardInfo']),
  },
  data() {
    return {
      popRewardCountInfo: false,
    }
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
// @mixin font_level_4_1 {
//   color: #b5b5b5;
//   font-size: 14px;
// }
@mixin pop_off {
  background: rgba(0, 91, 127, 0.5);
}
@mixin pop_on {
  background: rgba(0, 91, 127, 1);
}

.rewardInfoCon {
  width: 100%;
  height: 110px;
  font-size: 14px;
  position: relative;
  //   background: green;

  // 数据内容包裹
  .itemContent {
    @include size(100%,68px);
    overflow: hidden;
    margin-top: 10px;
    // background:red;

    // 标题
    .titleCon > div {
      @include size(170px,18px);
      //   box-sizing: border-box;
      color: #89dddf;
      float: left;
      text-align: center;
      line-height: 18px;
      background: rgba(0, 191, 229, 0.2);
      //   border: 1px solid rgba(0, 191, 229, 1);
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

  // 二级奖励统计信息弹窗
  .rewardCountInfoContainer {
    width: 750px;
    // min-height: 200px;
    background: green;
    position: absolute;
    top: -430px;
    left: 0px;
  }
}
</style>