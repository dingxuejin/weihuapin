<template>

  <!-- 违法行为区域分布 **ok-->
  <!-- <illegal-distribute-trend-area></illegal-distribute-trend-area> -->
  <!-- 违法行为时段分布 **ok-->
  <!-- <illegal-distribute-trend-interval></illegal-distribute-trend-interval> -->
  <!-- 事故时段分布 **ok-->
  <!-- <accident-distribute-trend-interval></accident-distribute-trend-interval> -->
  <!-- 事故区域分布 **ok-->
  <!-- <accident-distribute-trend-area></accident-distribute-trend-area> -->
  <!-- 高驾行为区域分布 -->
  <!-- <driver-danger-trend></driver-danger-trend> -->
  <!-- 事故浏览**ok -->
  <!-- <accident-details></accident-details> -->
  <!-- 高驾行为时段分布 -->
  <!-- <distribute-trend-area></distribute-trend-area> -->
  <!-- 违规行为区域分布 -->
  <!-- <irregularity-distribute-trend-area></irregularity-distribute-trend-area> -->
  <!-- 违规行为时段分布 -->
  <!-- <irregularity-distribute-trend-interval></irregularity-distribute-trend-interval> -->
  <!-- *************************************************************** -->
  <!-- 车辆经营安全详情弹出框 -->
  <!-- <div class="company_secure_driver_danger_popup_layout_wrap clearfix" v-if="detailsShow"> -->

  <div>
    <!-- 违法行为区域分布  -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="illegalDistributeTrendArea_show">
      <illegal-distribute-trend-area></illegal-distribute-trend-area>
    </div>
    <!-- 违法行为时段分布 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="illegalDistributeTrendInterval_show">
      <illegal-distribute-trend-interval></illegal-distribute-trend-interval>
    </div>
    <!--  事故时段分布  -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="accidentDistributeTrendInterval_show">
      <accident-distribute-trend-interval></accident-distribute-trend-interval>
    </div>
    <!-- 事故区域分布-->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="accidentDistributeTrendArea_show">
      <accident-distribute-trend-area></accident-distribute-trend-area>
    </div>
    <!-- 事故浏览 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="accidentDetails_show">
      <accident-details></accident-details>
    </div>
    <!-- 不同周期高位驾驶行为数量 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="distributeTrendArea_show">
      <driver-danger-trend></driver-danger-trend>
    </div>
    <!-- 高驾行为时段分布 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="distributeTrendTime_show">
      <distribute-trend-area></distribute-trend-area>
    </div>
    <!-- 违规行为区域分布 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="irregularityDistributeTrendArea_Show">
      <irregularity-distribute-trend-area></irregularity-distribute-trend-area>
    </div>
    <!-- 违规行为时段分布 -->
    <div class="company_secure_driver_danger_popup_layout_wrap clearfix"
         v-if="irregularityDistributeTrendInterval_show">
      <irregularity-distribute-trend-interval></irregularity-distribute-trend-interval>
    </div>
  </div>

</template>
<script>
/*eslint-disable */
import DriverDangerTrend from "./DriverDangerTrend";
import DistributeTrendArea from "./DistributeTrendArea";
import IllegalDistributeTrendArea from "./IllegalDistributeTrendArea";
import IllegalDistributeTrendInterval from "./IllegalDistributeTrendInterval";
import IrregularityDistributeTrendArea from "./IrregularityDistributeTrendArea";
import IrregularityDistributeTrendInterval from "./IrregularityDistributeTrendInterval";
import AccidentDistributeTrendArea from "./AccidentDistributeTrendArea";
import AccidentDistributeTrendInterval from "./AccidentDistributeTrendInterval";
import AccidentDetails from "./AccidentDetails";
import quantityDriver from "./quantityDriver";
import { mapState } from "../../../../node_modules/_vuex@3.0.1@vuex";

export default {
  name: "",
  components: {
    DriverDangerTrend,
    DistributeTrendArea,
    IllegalDistributeTrendArea,
    IllegalDistributeTrendInterval,
    IrregularityDistributeTrendArea,
    IrregularityDistributeTrendInterval,
    AccidentDistributeTrendArea,
    AccidentDistributeTrendInterval,
    AccidentDetails
  },
  data() {
    return {
      move: false
    };
  },
  computed: {
    ...mapState("popupSecContainer", ["detailsShow"]),
    ...mapState("popupSecContainer", ["differentDateTrend_show"]),
    ...mapState("popupSecContainer", [
      "illegalDistributeTrendArea_show",
      "illegalDistributeTrendInterval_show",
      "accidentDistributeTrendInterval_show",
      "accidentDistributeTrendArea_show",
      "accidentDetails_show",
      "differentDateTrend_show",
      "distributeTrendArea_show",
      "distributeTrendTime_show",
      "irregularityDistributeTrendArea_Show",
      "irregularityDistributeTrendInterval_show"
    ])
  },
  methods: {}
};
</script>

<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
.company_secure_driver_danger_popup_layout_wrap {
  // @include size(100%,100%);
  position: absolute;
  top: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.25);
  z-index: 2;
}
</style>