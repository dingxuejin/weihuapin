<template>
  <div class="company_secure_driver_danger_distribute_trend_interval_wrap"
       v-if="distributeTrendTime_show">
    <!-- 选择类型 -->
    <div class="company_secure_driver_danger_outframe_wrap"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetails'>
        <pop-up-widget title="高危驾驶行为时段分布变化趋势"></pop-up-widget>
        <div class="dateSelectedWrap clearfix">
          <div class="dateSelecteContent">
            <div class="title">统计周期</div>
            <div class="yearWrap">
              <key-value-select width="100px"
                                :data="years"
                                @up="selectYear"></key-value-select>
            </div>
            <div class="monthWrap">
              <key-value-select width="100px"
                                :data="months"
                                @up="selectMonth"></key-value-select>
            </div>
            <div class="title">行为类型</div>
            <div class="typeWrap">
              <key-value-select width="110px"
                                :data="areaTypeCode"
                                @up="selectType"></key-value-select>
            </div>
          </div>
        </div>
        <!-- 内容：chart -->
        <div class="distributeTrendTime_chart">
          <loading :data="getChartData">
            <radar chartTheme="dark"
                   :data="getChartData"
                   :color="chartColor"></radar>
          </loading>
        </div>
        <!-- </popup-out-frame> -->
      </pop-up-frame>
    </div>
  </div>
</template>
<script>
/*eslint-disable */
import KeyValueSelect from "@/components/KeyValueSelect";
import lineChart from "@/components/charts/lineChart";
import Radar from "@/components/charts/Radar";
import xxx from "../../../util/dictionary";
import PopupOutFrame from "./PopupOutFrame";
import PopUpFrame from "@/components/PopUpFrame";
import PopUpWidget from "@/components/PopUpWidget";
import {
  mapState,
  mapMutations,
  mapActions
} from "../../../../node_modules/_vuex@3.0.1@vuex";

export default {
  name: "",
  components: {
    KeyValueSelect,
    xxx,
    lineChart,
    PopupOutFrame,
    Radar,
    PopUpWidget,
    PopUpFrame
  },
  data() {
    return {
      // 公共数据
      move: false,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      areaTypeCode: xxx.driveEventType.danger,
      chartColor: [
        "#05d0eb",
        "#81d9e5",
        "#f6ffcb",
        "#e75029",
        "#038bfc",
        "#006a55"
      ],
      yearValue: null,
      monthValue: null,
      typeValue: 10110,
    };
  },
  computed: {
    ...mapState("popupSecContainer", [
      // 弹框显示/隐藏：
      "detailsShow",
      "distributeTrendTime_show",
      "driver_danger_distribute_trend_interval"
    ]),
    ...mapState("secureMain", ["selectedEntity"]),
    ...mapState("secureMain", ["entity_id"]),
    // 获取chart数据
    getChartData() {
      if (this.driver_danger_distribute_trend_interval) {
        return this.driver_danger_distribute_trend_interval;
      }
      return null;
    },
    // 设置参数
    getQueryParams() {
      return {
        entity_id: this.entity_id,
        year: this.yearValue,
        month: this.monthValue,
        drive_event_type_code: this.typeValue
      };
    }
  },
  methods: {
    ...mapMutations("popupSecContainer", ["closeComDetails"]),
    ...mapActions("popupSecContainer", [
      "getdriver_danger_distribute_trend_interval"
    ]),
    ...mapMutations("popupSecContainer", ["setdistributeTrendTime_show"]),
    closeDetails() {
      this.setdistributeTrendTime_show(false);
    },
    toggleDetails() {},
    selectYear(item) {
      this.yearValue = item;
      this.getdriver_danger_distribute_trend_interval(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getdriver_danger_distribute_trend_interval(this.getQueryParams);
    },
    selectType(item) {
      this.typeValue = item;
      this.getdriver_danger_distribute_trend_interval(this.getQueryParams);
    }
  },
  mounted() {
    // this.getdriver_danger_distribute_trend_interval(this.getQueryParams);
  }
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
.company_secure_driver_danger_distribute_trend_interval_wrap {
  width: 750px;
  position: absolute;
  top: 325px;
  left: 660px;
  z-index: 3;
  .dateSelectedWrap {
    width: 100%;
    position: relative;
    margin-top: 10px;
    .dateSelecteContent {
      @include size(552px, 25px);
      float: right;
      .title {
        width: 95px;
        text-align: center;
        line-height: 25px;
        float: left;
        color: #b5b5b5;
        font-size: 14px;
        margin-right: 10px;
        margin-left: 10px;
      }
      .yearWrap {
        width: 100px;
        height: 25px;
        float: left;
        margin-right: 5px;
      }
      .monthWrap {
        width: 100px;
        height: 25px;
        float: left;
        margin-right: 5px;
      }
      .typeWrap {
        width: 110px;
        height: 25px;
        float: left;
      }
    }
  }
  .distributeTrendTime_chart {
    width: 100%;
    height: 200px;
    margin-top: 10px;
  }
}
</style>