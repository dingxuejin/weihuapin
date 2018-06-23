<template>
  <div class="dhome">
    <!-- top layout -->
    <div class="dhome_top clearfix">
      <div class="left fl">
        <DriverBase></DriverBase>
        <div class="dhome_top_splitLine"></div>
      </div>

      <div class="center fl">
        <DriverLine></DriverLine>
      </div>

      <div class="right fl">
        <accumulated-workload-statistics/>
      </div>
    </div>
    <!-- splitline -->
    <!-- <div class="dhome_splitline"></div> -->

    <!-- bottom layout -->
    <div class="dhome_bottom clearfix">
      <div class="left fl">
        <award-punishment/>
      </div>
      <!-- <div class="split_line fl">
      </div> -->
      <div class="right fl">
        <score-and-ranking-of-safety-evaluation/>
      </div>
    </div>
    <!-- 驾驶员标签 -->
    <div class="driverdetailTagCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         :class="[driverDetailsTag?'show':'hide']">
      <pop-up-frame @close="close('driverDetailsTag')">
        <pop-up-driver-tag></pop-up-driver-tag>
      </pop-up-frame>
    </div>
    <!-- 驾驶员基本信息 -->
    <div class="driverdetailCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         :class="[driverDetailsInfo?'show':'hide']">
      <pop-up-frame @close="close('driverDetailsInfo')">
        <pop-up-driver-info></pop-up-driver-info>
      </pop-up-frame>
    </div>
    <!-- 健康信息 -->
    <div class="driverHeathyCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         :class="[driverHealthy?'show':'hide']">
      <pop-up-frame @close="close('driverHealthy')">
        <pop-up-driver-healthy-pop></pop-up-driver-healthy-pop>
      </pop-up-frame>
    </div>
    <!-- 点击资格证书之后，出现两个小铃铛-->

    <!-- 资质弹窗 -->
    <div class="certificateCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         :class="[qualifyDetailInfo?'show':'hide']">
      <pop-up-frame @close="close('qualifyDetailInfo')">
        <pop-up-driver-qualification></pop-up-driver-qualification>
      </pop-up-frame>
    </div>

    <!-- 培训信息弹窗 -->
    <div class="trainInfoCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         :class="[trainDetailInfo?'show':'hide']">
      <pop-up-frame @close="close('trainDetailInfo')">
        <pop-up-train-info></pop-up-train-info>
      </pop-up-frame>
    </div>

    <!-- 奖励信息弹窗 -->
    <div class="rewardInfoCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         v-if="rewardInfo">
      <pop-up-frame @close="close('rewardInfo')">
        <reward-info></reward-info>
      </pop-up-frame>
    </div>

    <!-- 惩罚信息弹窗 -->
    <div class="punishInfoCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         v-if="punishInfo">
      <pop-up-frame @close="close('punishInfo')">
        <punish-info></punish-info>
      </pop-up-frame>
    </div>
    <!-- 安全积分弹窗 -->
    <div class="safetyIntegralCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         v-if="safetyIntegral">
      <pop-up-frame @close="close('safetyIntegral')">
        <pop-up-driver-safety-integral></pop-up-driver-safety-integral>
      </pop-up-frame>
    </div>
    <!-- 工作统计信息 -->
    <div class="workCountInfoCon"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''"
         v-if="workCountInfo">
      <pop-up-frame @close="close('workCountInfo')">
        <work-info></work-info>
      </pop-up-frame>
    </div>

    <!-- 驾驶行为弹窗 -->
    <div class="driverBehaviorCon"
         v-if="driverBehavior"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close="close('driverBehavior')">
        <drive-behavior-count-info></drive-behavior-count-info>
      </pop-up-frame>
    </div>

    <!-- 违规行为弹窗 -->
    <div class="irregalarityBehaviorCon"
         v-if="irregalarityBehavior"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close="close('irregalarityBehavior')">
        <irregalarity-behavior-count-info></irregalarity-behavior-count-info>
      </pop-up-frame>
    </div>

    <!-- 违法行为弹窗 -->
    <div class="illegalBehaviorCon"
         v-if="illegalBehavior"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close="close('illegalBehavior')">
        <illegal-behavior-count-info></illegal-behavior-count-info>
      </pop-up-frame>
    </div>

    <!-- 有责事故弹窗 -->
    <div class="blameAccidentCon"
         v-if="blameAccident"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close="close('blameAccident')">
        <blame-accident-count-info></blame-accident-count-info>
      </pop-up-frame>
    </div>

    <!-- 驾驶员承运线路 实时报警弹窗 -->
    <div class="driverLineRealtimeAlarmCon"
         v-if="driverLineRealtimeAlarm"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close="close('driverLineRealtimeAlarm')">
        <driver-line-realtime-alarm-info></driver-line-realtime-alarm-info>
      </pop-up-frame>
    </div>

  </div>
</template>
<script>
/*eslint-disable */
import { mapState, mapMutations } from "vuex";
// 驾驶员基本信息
import DriverBase from "../containers/driver/driverbase/DriverBase";
import DriverLine from "../containers/driver/driverLine/DriverLine";
import AwardPunishment from "../containers/driver/awardPunishment/AwardPunishment";
import AccumulatedWorkloadStatistics from "../containers/driver/accumulatedWorkloadStatistics/AccumulatedWorkloadStatistics";
import ScoreAndRankingOfSafetyEvaluation from "../containers/driver/scoreAndRankingOfSafetyEvaluation/ScoreAndRankingOfSafetyEvaluation";

// 0303 lfl
// 弹窗组件
import PopUpFrame from "../components/PopUpFrame";
// 驾驶员标签
import PopUpDriverTag from '../containers/driverPopup/popupdrivertag/PopUpDriverTag'
// 人员基本信息
import PopUpDriverInfo from "../containers/driverPopup/popupdriverinfo/PopUpDriverInfo";
// 资格证书
import PopUpDriverQualification from "../containers/driverPopup/popupdriverqualification/PopUpDriverQualification";
// 健康信息
import PopUpDriverHealthyPop from '../containers/driverPopup/popupdriverhealthy/PopUpDriverHealthy'
// 培训信息
import PopUpTrainInfo from "../containers/driverPopup/popuptraininfo/PopUpTrainInfo";
// 奖励信息弹窗
import RewardInfo from "../containers/driverPopup/rewardinfo/RewardInfo";
// 惩罚信息弹窗
import PunishInfo from "../containers/driverPopup/punishinfo/PunishInfo";
// 安全积分弹窗
import PopUpDriverSafetyIntegral from "../containers/driverPopup/popupdriversafetyIntegral/PopUpDriverSafetyIntegral";
// 工作量统计弹窗
import WorkInfo from "../containers/driverPopup/workinfo/WorkInfo";
// 驾驶行为弹窗
import DriveBehaviorCountInfo from "../containers/driverPopup/drivebehaviorcountinfo/DriveBehaviorCountInfo";
// 违规行为弹窗
import IrregalarityBehaviorCountInfo from "../containers/driverPopup/irregalaritybehaviorcountinfo/IrregalarityBehaviorCountInfo";
// 违法行为弹窗
import IllegalBehaviorCountInfo from "../containers/driverPopup/illegalbehaviorcountinfo/IllegalBehaviorCountInfo";
// 有责事故弹窗
import BlameAccidentCountInfo from "../containers/driverPopup/blameaccidentcountinfo/BlameAccidentCountInfo";
//
import DriverLineRealtimeAlarmInfo from "../containers/driverPopup/driverlinerealtimealarminfo/DriverLineRealtimeAlarmInfo";

export default {
  components: {
    DriverBase,
    DriverLine,
    AwardPunishment,
    AccumulatedWorkloadStatistics,
    ScoreAndRankingOfSafetyEvaluation,

    // 弹窗
    PopUpDriverSafetyIntegral,
    PopUpDriverHealthyPop,
    PopUpDriverTag,
    PopUpFrame,
    PopUpDriverInfo,
    PopUpDriverQualification,
    PopUpTrainInfo,
    RewardInfo,
    PunishInfo,
    WorkInfo,
    DriveBehaviorCountInfo,
    IrregalarityBehaviorCountInfo,
    IllegalBehaviorCountInfo,
    BlameAccidentCountInfo,
    DriverLineRealtimeAlarmInfo
  },
  data() {
    return {
      // popDetail: false,
      move: false
    };
  },
  computed: {
    ...mapState('driver', [
      'driverHealthy',
      'driverDetailsTag',
      'driverDetailsInfo',
      'qualifyDetailInfo',
      'trainDetailInfo',
      'rewardInfo',
      'punishInfo',
      'safetyIntegral',
      'workCountInfo',
      'driverBehavior',
      'irregalarityBehavior',
      'illegalBehavior',
      'blameAccident',
      'driverLineRealtimeAlarm',
    ]),
  },
  methods: {
    ...mapMutations("driver", ["close"])
  }
};
</script>
<style lang="scss" scoped>
.dhome {
  position: relative;
  width: 100%;
  height: 100%;
  // margin-left: 100px;
  // margin-top: 40px;

  // 上半部分
  .dhome_top {
    width: 100%;
    height: 480px;
    overflow: hidden;
    // background: yellow;
    // ----------left
    .left {
      width: 480px;
      height: 480px;
      // border-bottom: 2px solid rgba(129, 217, 229, 0.6);
      overflow: hidden;
      // background: pink;
      .dhome_top_splitLine {
        width: 100%;
        height: 2px;
        background: rgba(129, 217, 229, 0.6);
        margin-top: 10px;
        position: relative;
        left: 0;
        bottom: 38px;
      }
    }

    // ----------center
    .center {
      width: 852px;
      height: 100%;
      overflow: hidden;
      margin-left: 20px;
      // background: red;
    }

    // -----------right
    .right {
      width: 518px;
      height: 100%;
      overflow: hidden;
      margin-left: 20px;
      background: rgba(3, 139, 252, 0.2);
      padding: 15px 18px;
      box-sizing: border-box;
    }
  }

  //间隔线
  .dhome_splitline {
    width: 100%;
    height: 25px;
    overflow: hidden;
    // background: green;
  }

  // 底部
  .dhome_bottom {
    width: 100%;
    height: 485px;
    overflow: hidden;
    // background: red;
    // split line
    .split_line {
      width: 40px;
      height: 100%;
      overflow: hidden;
      background: url(../assets/driver/people_line_long.png) no-repeat center
        center;
      background-size: 40px 365px;
    }
    // --------------left
    .left {
      width: 480px;
      height: 100%;
      overflow: hidden;
      background: rgba(3, 139, 252, 0.2);
    }

    // --------------right
    .right {
      width: 1390px;
      height: 470px;
      overflow: hidden;
      margin-left: 20px;
      background: rgba(3, 139, 252, 0.2);
      margin-top: 15px;
    }
  }
// 驾驶员标签
  .driverdetailTagCon{
    width: 750px;
    height: 340px;
    position: absolute;
    left: 180px;
    top: 220px;
    z-index: 11;
    &.show {
      display: block;
    }
    &.hide {
      display: none;
    }
  }
  // 驾驶员基本信息
  .driverdetailCon {
    width: 750px;
    height: 240px;
    position: absolute;
    left: 620px;
    top: 120px;
    z-index: 10;
    &.show {
      display: block;
    }
    &.hide {
      display: none;
    }
    background: green;
  }
  // 健康信息
  .driverHeathyCon{
    width: 385px;
    height: 150px;
    position: absolute;
    left: 80px;
    top: 420px;
    z-index: 10;
    &.show {
      display: block;
    }
    &.hide {
      display: none;
    }
    // background: green;
  }
  // 资质证件弹窗
  .certificateCon {
    width: 770px;
    // height:305px;
    position: absolute;
    left: 620px;
    top: 400px;
    z-index: 10;
    &.show {
      display: block;
    }
    &.hide {
      display: none;
    }
    background: green;
  }

  // 培训信息弹窗
  .trainInfoCon {
    width: 750px;
    min-height: 200px;
    position: absolute;
    top: 500px;
    left: 420px;
    &.show {
      display: block;
    }
    &.hide {
      display: none;
    }
    &-test {
      color: #fff;
    }
    background: red;
  }

  // 奖励信息弹窗
  .rewardInfoCon {
    width: 750px;
    // height:300px;
    position: absolute;
    top: 500px;
    left: 220px;
    // background: green;
  }

  // 惩罚弹窗
  .punishInfoCon {
    width: 750px;
    // height:300px;
    position: absolute;
    top: 580px;
    left: 220px;
    background: pink;
  }
  // 安全积分
  .safetyIntegralCon{
    width: 750px;
    height:300px;
    position: absolute;
    top: 580px;
    left: 220px;
    // background: pink;
  }
  // 工作统计信息
  .workCountInfoCon {
    width: 750px;
    // min-height:500px;
    position: absolute;
    top: 20px;
    right: 620px;
    // background: green;
  }

  // 驾驶行为弹窗
  .driverBehaviorCon {
    width: 750px;
    // min-height: 400px;
    position: absolute;
    top: 100px;
    left: 310px;
    // background: green;
  }

  // 违规行为弹窗
  .irregalarityBehaviorCon {
    width: 750px;
    // min-height: 400px;
    position: absolute;
    top: 200px;
    left: 745px;
    // background: green;
  }

  // 违法行为弹窗
  .illegalBehaviorCon {
    width: 750px;
    // min-height: 400px;
    position: absolute;
    top: 200px;
    left: 1175px;
    // background: green;
  }

  // 有责事故弹窗
  .blameAccidentCon {
    width: 750px;
    // min-height: 400px;
    position: absolute;
    top: 200px;
    right: 0px;
    // background: green;
  }

  // 驾驶员承运线路 实时报警
  .driverLineRealtimeAlarmCon {
    width: 1730px;
    min-height: 100px;
    position: absolute;
    top: 300px;
    right: 0px;
    // background: green;
  }
}
</style>
