<template>
  <div class="company_secure_driver_accident_distribute_trend_area_wrap"
       v-if="accidentDistributeTrendArea_show">
    <!-- <popup-out-frame title="不同类型事故区域分布"> -->
    <!-- 选择类型 -->
    <div class="company_secure_driver_danger_outframe_wrap"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetails'>
        <pop-up-widget title="不同类型事故区域分布"></pop-up-widget>
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
            <div class="title">类型选择</div>
            <div class="typeWrap">
              <key-value-select width="110px"
                                :data="areaTypeCode"
                                @up="selectType"></key-value-select>
            </div>
          </div>
        </div>
        <!-- 内容：chart -->
        <div class="accident_distribute_trend_area_chart"
             v-if="AccidentDistributeTrendArea">
          <bar-stack chartTheme="dark"
                     :data="AccidentDistributeTrendArea"
                     :color="chartColor"
                     yName="数量(次)"></bar-stack>
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
import BarStack from "@/components/charts/BarStack";
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
    BarStack,
    PopUpWidget,
    PopUpFrame
  },
  data() {
    return {
      // 公共数据
      move: false,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      areaTypeCode: [{ label: "全部", value: null }, ...xxx.accidentLevelCode],
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
      TypeValue: null,

      // 获取数据
      barStackData: [
        {
          name: "特大",
          data: [
            {
              name: "area1",
              value: 2
            },
            {
              name: "area2",
              value: 0
            },
            {
              name: "area3",
              value: 10
            },
            {
              name: "area4",
              value: 0
            },
            {
              name: "area5",
              value: 10
            },
            {
              name: "area6",
              value: 22
            },
            {
              name: "area7",
              value: 10
            },
            {
              name: "area8",
              value: 11
            },
            {
              name: "area9",
              value: 20
            },
            {
              name: "area10",
              value: 1
            },
            {
              name: "arear11",
              value: 17
            },
            {
              name: "area12",
              value: 3
            }
          ]
        },
        {
          name: "重大",
          data: [
            {
              name: "area1",
              value: 2
            },
            {
              name: "area2",
              value: 0
            },
            {
              name: "area3",
              value: 15
            },
            {
              name: "area4",
              value: 0
            },
            {
              name: "area5",
              value: 5
            },
            {
              name: "area6",
              value: 22
            },
            {
              name: "area7",
              value: 10
            },
            {
              name: "area8",
              value: 11
            },
            {
              name: "area9",
              value: 20
            },
            {
              name: "area10",
              value: 1
            },
            {
              name: "arear11",
              value: 17
            },
            {
              name: "area12",
              value: 3
            }
          ]
        },
        {
          name: "一般",
          data: [
            {
              name: "area1",
              value: 2
            },
            {
              name: "area2",
              value: 0
            },
            {
              name: "area3",
              value: 13
            },
            {
              name: "area4",
              value: 0
            },
            {
              name: "area5",
              value: 12
            },
            {
              name: "area6",
              value: 22
            },
            {
              name: "area7",
              value: 10
            },
            {
              name: "area8",
              value: 11
            },
            {
              name: "area9",
              value: 20
            },
            {
              name: "area10",
              value: 1
            },
            {
              name: "arear11",
              value: 17
            },
            {
              name: "area12",
              value: 3
            }
          ]
        },
        {
          name: "轻微",
          data: [
            {
              name: "area1",
              value: 2
            },
            {
              name: "area2",
              value: 0
            },
            {
              name: "area3",
              value: 14
            },
            {
              name: "area4",
              value: 0
            },
            {
              name: "area5",
              value: 13
            },
            {
              name: "area6",
              value: 22
            },
            {
              name: "area7",
              value: 10
            },
            {
              name: "area8",
              value: 11
            },
            {
              name: "area9",
              value: 20
            },
            {
              name: "area10",
              value: 1
            },
            {
              name: "arear11",
              value: 17
            },
            {
              name: "area12",
              value: 3
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
      "accidentDistributeTrendArea_show",
      "AccidentDistributeTrendArea"
      // 状态

      // 数据：
    ]),
    ...mapState("secureMain", ["entity_id"]),
    fetchData() {
      return {
        entity_id: this.entity_id,
        year: this.yearValue,
        month: this.monthValue,
        region_code: this.TypeValue
      };
    }
  },
  methods: {
    ...mapActions("popupSecContainer", ["getAccidentDistributeTrendArea"]),
    ...mapMutations("popupSecContainer", [
      "setaccidentDistributeTrendArea_show"
      // "setillegalDistributeTrendArea_show",
      // "setillegalDistributeTrendInterval_show"
    ]),
    closeDetails() {
      // this.setillegalDistributeTrendInterval_show(false);
      this.setaccidentDistributeTrendArea_show(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getAccidentDistributeTrendArea(this.fetchData);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getAccidentDistributeTrendArea(this.fetchData);
    },
    selectType(item) {
      this.TypeValue = item;
      this.getAccidentDistributeTrendArea(this.fetchData);
    }
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
.company_secure_driver_accident_distribute_trend_area_wrap {
  width: 750px;
  position: absolute;
  top: 110px;
  left: 1239px;
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
        // margin-right: 5px;
      }
      .typeWrap {
        width: 110px;
        height: 25px;
        float: left;
      }
    }
  }
  .accident_distribute_trend_area_chart {
    width: 100%;
    height: 200px;
    margin-top: 10px;
  }
}
</style>