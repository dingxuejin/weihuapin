<template>
  <div>
    <pop-up-widget title="惩罚信息"></pop-up-widget>

    <!-- 内容 -->
    <div class="rewardInfoCon">
      <div class="itemContent">
        <div class="titleCon clearfix">
          <div>累计惩罚次数</div>
          <div>累计惩罚金额</div>
          <div>最近一次惩罚时间</div>
          <div>最近一次惩罚金额</div>
        </div>

        <div class="indexCon clearfix"
             v-if="punishInfo">
          <div>{{qf(punishInfo['punishment_count'])}}</div>
          <div>{{qf(punishInfo['punishment_sum'])}}</div>
          <div>{{formatDate(punishInfo['lately_date'])}}</div>
          <div>{{qf(punishInfo['lately_punishment_amount'])}}</div>
        </div>
      </div>

      <!-- 弹窗按钮 -->
      <div class="popupBtn"
           @click="popPunishCountInfo = true">惩罚统计信息</div>

      <!-- 奖励信息统计 -->
      <div class="rewardCountInfoContainer"
           v-if="popPunishCountInfo">
        <pop-up-frame @close="popPunishCountInfo = false">
          <punish-count-info></punish-count-info>
        </pop-up-frame>
      </div>

    </div>

  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpFrame from '../../../components/PopUpFrame'
import PopUpWidget from '../../../components/PopUpWidget'
import PunishCountInfo from '../../driverPopup/punishcountinfo/PunishCountInfo'

export default {
  name: 'punishInfo',
  components: {
    PopUpFrame,
    PopUpWidget,
    PunishCountInfo,
  },
  computed: {
    ...mapState('punishinfo', ['punishInfo']),
    ...mapState('driverbase', ['ryjb']),
  },
  methods: {
    ...mapActions('punishinfo', ['getPunishInfo']),
  },
  data() {
    return {
      popPunishCountInfo: false,
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