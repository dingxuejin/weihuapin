<template>
  <div class="company_secure_driver_danger_trend_wrap clearfix"
       v-if="distributeTrendArea_show">
    <!-- <popup-out-frame title="高危驾驶行为区域分布变化趋势"> -->
    <!-- 选择类型 -->
    <div class="company_secure_driver_danger_outframe_wrap"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetails'>
        <pop-up-widget title="高危驾驶行为区域分布变化趋势"></pop-up-widget>
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
            <div class="title">区域选择</div>
            <div class="typeWrap">
              <key-value-select width="100px"
                                :data="areaTypeCode"
                                @up="selectType"></key-value-select>
            </div>
          </div>
        </div>
        <!-- 内容：chart -->
        <div class="distributeTrendArea_chart">
          <loading :data="getChartData">
            <lineChart chartTheme="dark"
                       :data="getChartData"
                       :color="chartColor"
                       yaxisName="数量(次)"
                       v-if="getChartData"></lineChart>
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
    PopUpWidget,
    PopUpFrame
  },
  data() {
    return {
      // 公共数据
      move: false,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      areaTypeCode: [{ label: "全部", value: null }, ...xxx.regionCode],
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

      // 获取数据
      lineChartData: [
        {
          name: "车距过近",
          data: [
            {
              name: "01",
              value: 505
            },
            {
              name: "02",
              value: 928
            },
            {
              name: "03",
              value: 898
            },
            {
              name: "04",
              value: 491
            },
            {
              name: "05",
              value: 708
            },
            {
              name: "06",
              value: 522
            },
            {
              name: "07",
              value: 505
            },
            {
              name: "08",
              value: 287
            },
            {
              name: "09",
              value: 661
            },
            {
              name: "10",
              value: 418
            },
            {
              name: "11",
              value: 529
            },
            {
              name: "12",
              value: 612
            },
            {
              name: "13",
              value: 824
            },
            {
              name: "14",
              value: 206
            },
            {
              name: "15",
              value: 382
            },
            {
              name: "16",
              value: 980
            },
            {
              name: "17",
              value: 767
            },
            {
              name: "18",
              value: 730
            },
            {
              name: "19",
              value: 783
            },
            {
              name: "20",
              value: 627
            },
            {
              name: "21",
              value: 703
            },
            {
              name: "22",
              value: 802
            },
            {
              name: "23",
              value: 300
            },
            {
              name: "24",
              value: 956
            },
            {
              name: "25",
              value: 237
            },
            {
              name: "26",
              value: 245
            },
            {
              name: "27",
              value: 689
            },
            {
              name: "28",
              value: 650
            },
            {
              name: "29",
              value: 491
            },
            {
              name: "30",
              value: 340
            }
          ]
        },
        {
          name: "转弯过速",
          data: [
            {
              name: "01",
              value: 409
            },
            {
              name: "02",
              value: 345
            },
            {
              name: "03",
              value: 567
            },
            {
              name: "04",
              value: 338
            },
            {
              name: "05",
              value: 531
            },
            {
              name: "06",
              value: 549
            },
            {
              name: "07",
              value: 495
            },
            {
              name: "08",
              value: 224
            },
            {
              name: "09",
              value: 509
            },
            {
              name: "10",
              value: 415
            },
            {
              name: "11",
              value: 430
            },
            {
              name: "12",
              value: 521
            },
            {
              name: "13",
              value: 450
            },
            {
              name: "14",
              value: 579
            },
            {
              name: "15",
              value: 541
            },
            {
              name: "16",
              value: 224
            },
            {
              name: "17",
              value: 445
            },
            {
              name: "18",
              value: 514
            },
            {
              name: "19",
              value: 359
            },
            {
              name: "20",
              value: 444
            },
            {
              name: "21",
              value: 607
            },
            {
              name: "22",
              value: 492
            },
            {
              name: "23",
              value: 363
            },
            {
              name: "24",
              value: 470
            },
            {
              name: "25",
              value: 221
            },
            {
              name: "26",
              value: 275
            },
            {
              name: "27",
              value: 267
            },
            {
              name: "28",
              value: 607
            },
            {
              name: "29",
              value: 370
            },
            {
              name: "30",
              value: 483
            }
          ]
        },
        {
          name: "车道偏离",
          data: [
            {
              name: "01",
              value: 1106
            },
            {
              name: "02",
              value: 800
            },
            {
              name: "03",
              value: 1258
            },
            {
              name: "04",
              value: 943
            },
            {
              name: "05",
              value: 1394
            },
            {
              name: "06",
              value: 1761
            },
            {
              name: "07",
              value: 1571
            },
            {
              name: "08",
              value: 1021
            },
            {
              name: "09",
              value: 1856
            },
            {
              name: "10",
              value: 958
            },
            {
              name: "11",
              value: 1792
            },
            {
              name: "12",
              value: 908
            },
            {
              name: "13",
              value: 1159
            },
            {
              name: "14",
              value: 825
            },
            {
              name: "15",
              value: 2018
            },
            {
              name: "16",
              value: 914
            },
            {
              name: "17",
              value: 1076
            },
            {
              name: "18",
              value: 1993
            },
            {
              name: "19",
              value: 1861
            },
            {
              name: "20",
              value: 1705
            },
            {
              name: "21",
              value: 661
            },
            {
              name: "22",
              value: 926
            },
            {
              name: "23",
              value: 742
            },
            {
              name: "24",
              value: 1229
            },
            {
              name: "25",
              value: 1201
            },
            {
              name: "26",
              value: 1253
            },
            {
              name: "27",
              value: 1180
            },
            {
              name: "28",
              value: 1525
            },
            {
              name: "29",
              value: 1623
            },
            {
              name: "30",
              value: 1735
            }
          ]
        }
      ],
      entity_id: "1310000010000000"
      // entity_id: '1310000010040100',
    };
  },
  computed: {
    ...mapState("popupSecContainer", [
      // 弹框显示/隐藏：
      "detailsShow",
      "distributeTrendArea_show",
      // 数据
      "tb_subject_qy_gwqy",
      "driver_danger_distribute_trend_area"
    ]),
    ...mapState("secureMain", ["selectedEntity"]),
    getChartData() {
      if (this.driver_danger_distribute_trend_area) {
        return this.driver_danger_distribute_trend_area;
      }
      return null;
    },
    // 设置参数
    getQueryParams() {
      return {
        entity_id: this.entity_id,
        year: this.yearValue,
        month: this.monthValue,
        region_code: this.typeValue
      };
    }
  },
  methods: {
    ...mapActions("popupSecContainer", [
      "getdriver_danger_distribute_trend_area",
      "gettb_subject_qy_gwqy"
    ]),
    ...mapMutations("popupSecContainer", ["setdistributeTrendArea_show"]),
    closeDetails() {
      this.setdistributeTrendArea_show(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getdriver_danger_distribute_trend_area(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getdriver_danger_distribute_trend_area(this.getQueryParams);
    },
    selectType(item) {
      this.typeValue = item;
      this.getdriver_danger_distribute_trend_area(this.getQueryParams);
    }
  },
  mounted() {
    this.getdriver_danger_distribute_trend_area(this.getQueryParams);
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
.company_secure_driver_danger_trend_wrap {
  width: 750px;
  position: absolute;
  top: 320px;
  left: 120px;
  z-index: 3;
  .dateSelectedWrap {
    width: 100%;
    position: relative;
    margin-top: 10px;
    .dateSelecteContent {
      @include size(552px, 25px);
      float: right;
      .title {
        width: 100px;
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
        width: 100px;
        height: 25px;
        float: left;
      }
    }
  }
  .distributeTrendArea_chart {
    width: 100%;
    height: 200px;
    margin-top: 10px;
  }
}
</style>