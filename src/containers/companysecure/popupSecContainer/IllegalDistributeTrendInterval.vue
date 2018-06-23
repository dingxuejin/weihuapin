<template>
  <div class="company_secure_driver_illegal_distribute_trend_interval_wrap"
       v-if="illegalDistributeTrendInterval_show">
    <!-- <popup-out-frame title="违法行为时段分布变化趋势"> -->
    <!-- 选择类型 -->
    <div class="company_secure_driver_danger_outframe_wrap"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetails'>
        <pop-up-widget title="违法行为时段分布变化趋势"></pop-up-widget>
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
              <key-value-select width="140px"
                                :data="typeCode"
                                @up="selectType"></key-value-select>
            </div>
          </div>
        </div>
        <!-- 内容：chart -->
        <div class="illegal_distribute_trend_interval_chart">
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
  mapActions,
  mapMutations
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
      // 公共数据
      move: false,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      typeCode: [{ label: "全部", value: null }, ...xxx.driveEventType.danger],
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
      typeValue: null,
      entity_id: 1310000010000000,

      // 获取数据
      radarData: [
        {
          name: "30",
          data: [
            {
              name: "0-1点",
              value: 0
            },
            {
              name: "1-2点",
              value: 0
            },
            {
              name: "2-3点",
              value: 0
            },
            {
              name: "3-4点",
              value: 0
            },
            {
              name: "4-5点",
              value: 0
            },
            {
              name: "5-6点",
              value: 0
            },
            {
              name: "6-7点",
              value: 0
            },
            {
              name: "7-8点",
              value: 0
            },
            {
              name: "8-9点",
              value: 0
            },
            {
              name: "9-10点",
              value: 0
            },
            {
              name: "10-11点",
              value: 0
            },
            {
              name: "11-12点",
              value: 0
            },
            {
              name: "12-13点",
              value: 0
            },
            {
              name: "13-14点",
              value: 2
            },
            {
              name: "14-15点",
              value: 1
            },
            {
              name: "15-16点",
              value: 0
            },
            {
              name: "16-17点",
              value: 0
            },
            {
              name: "17-18点",
              value: 0
            },
            {
              name: "18-19点",
              value: 0
            },
            {
              name: "19-20点",
              value: 0
            },
            {
              name: "20-21点",
              value: 0
            },
            {
              name: "21-22点",
              value: 1
            },
            {
              name: "22-23点",
              value: 0
            },
            {
              name: "23-24点",
              value: 0
            }
          ]
        }
      ]
    };
  },
  computed: {
    ...mapState("popupSecContainer", [
      // 弹框显示/隐藏：
      "detailsShow",
      "illegalDistributeTrendInterval_show",
      "driver_illegal_distribute_trend_interval"
    ]),
    // 获取chart数据
    getChartData() {
      if (this.driver_illegal_distribute_trend_interval) {
        return this.driver_illegal_distribute_trend_interval;
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
    ...mapActions("popupSecContainer", [
      "getdriver_illegal_distribute_trend_interval"
    ]),
    ...mapMutations("popupSecContainer", [
      "setillegalDistributeTrendArea_show",
      "setillegalDistributeTrendInterval_show"
    ]),
    closeDetails() {
      this.setillegalDistributeTrendInterval_show(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getdriver_illegal_distribute_trend_interval(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getdriver_illegal_distribute_trend_interval(this.getQueryParams);
    },
    selectType(item) {
      this.typeValue = item;
      this.getdriver_illegal_distribute_trend_interval(this.getQueryParams);
    }
  },
  mounted() {
    this.getdriver_illegal_distribute_trend_interval(this.getQueryParams);
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
.company_secure_driver_illegal_distribute_trend_interval_wrap {
  width: 750px;
  position: absolute;
  top: 320px;
  left: 1240px;
  z-index: 3;
  .dateSelectedWrap {
    width: 100%;
    position: relative;
    margin-top: 10px;
    .dateSelecteContent {
      @include size(552px, 25px);
      float: right;
      .title {
        width: 88px;
        text-align: center;
        line-height: 25px;
        float: left;
        color: #b5b5b5;
        font-size: 14px;
        // margin-right: 10px;
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
        width: 100px;
        height: 25px;
        float: left;
      }
    }
  }
  .illegal_distribute_trend_interval_chart {
    width: 100%;
    height: 200px;
    margin-top: 10px;
  }
}
</style>