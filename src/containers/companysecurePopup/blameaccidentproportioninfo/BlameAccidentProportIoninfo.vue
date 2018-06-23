<template>
  <div class="blameAccidentProportIoninfoCon">
    <pop-up-widget title="有责事故占比统计"></pop-up-widget>

    <!-- 内容部分 -->
    <div class="mileageCon">
      <!-- 数据类型 -->
      <div class="dataTypeCon">
        <div :class="{dataTypeActive:currentDataTypeIndex === 0}"
             @click="dataTypeActive(0)">有责事故类型占比</div>
        <div :class="{dataTypeActive:currentDataTypeIndex === 1}"
             @click="dataTypeActive(1)">责任类型占比</div>
        <div :class="{dataTypeActive:currentDataTypeIndex === 2}"
             @click="dataTypeActive(2)">事故程度占比</div>
        <div :class="{dataTypeActive:currentDataTypeIndex === 3}"
             @click="dataTypeActive(3)">有无危险品泄露占比</div>
      </div>

      <!-- 标题 -->
      <div class="selectCon clearfix">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select width="90px"
                              :data="selectYearData"
                              @select='select("year",$event)'></key-value-select>
          </div>

          <!-- <div class="fl">
            <key-value-select width="90px"
                              :data="selectMonthData"
                              @select='select("month",$event)'></key-value-select>
          </div>

          <div class="fl">
            <key-value-select width="90px"
                              :data="selectDayData"
                              @select='select("day",$event)'></key-value-select>
          </div> -->
        </div>
      </div>

      <!-- 图表 -->
      <div class="chartsCon">
        <ringAndLegend chartTheme="dark"
                       :data="blameAccidentProportionInfo"
                       v-if="blameAccidentProportionInfo"
                       :color="chartColor"
                       marginLeft="0px"></ringAndLegend>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
/*eslint-disable */
import { mapState, mapActions } from "vuex";

import PopUpFrame from "../../../components/PopUpFrame";
import PopUpWidget from "../../../components/PopUpWidget";
import KeyValueSelect from "../../../components/KeyValueSelect";
import Dictionary from "../../../util/dictionary";
import ringAndLegend from "../../../components/charts/ringAndLegend";

const {
  driveEventType: { danger },
  date: { year, month, day },
  countType,
  timeSlot
} = Dictionary;

export default {
  name: "illegalBehaviorAlarmCount",
  components: {
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect,
    Dictionary,
    ringAndLegend
  },
  computed: {
    ...mapState("blameaccidentproportioninfo", ["blameAccidentProportionInfo"]),
    ...mapState("driverbase", ["ryjb"])
  },
  data() {
    return {
      selectYearData: year,
      selectMonthData: month,
      selectDayData: day,
      selectAlarmType: danger,
      selectCountType: countType,
      selectTimeSlot: timeSlot,
      currentDataTypeIndex: 0,
      // chartData: [
      //   { name: '特大事故-全部责任-有危险品泄露', value: 33 },
      //   { name: '特大事故-全部责任-无危险品泄露', value: 44 },
      //   { name: '特大事故-主要责任-有危险品泄露', value: 66 },
      //   { name: '特大事故-主要责任-无危险品泄露', value: 16 },
      //   { name: '特大事故-同等责任-有危险品泄露', value: 33 },
      //   { name: '特大事故-同等责任-无危险品泄露', value: 20 },
      //   { name: '特大事故-次要责任-有危险品泄露', value: 33 },
      //   { name: '特大事故-次要责任-无危险品泄露', value: 30 },
      // ],
      chartColor: [
        "#05d0eb",
        "#81d9e5",
        "#f6ffcb",
        "#e75029",
        "#038bfc",
        "#006a55"
      ]
    };
  },
  methods: {
    ...mapActions("blameaccidentproportioninfo", [
      "getBlameAccidentProportionInfo"
    ]),
    fetchData() {
      this.getBlameAccidentProportionInfo({
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        day: this.day,
        type: [
          "有责事故类型占比",
          "责任类型占比",
          "事故程度占比",
          "有无危险品泄露占比"
        ][this.currentDataTypeIndex]
      });
    },
    select(name, item) {
      this[name] = item.value;
      // console.log('item', item)
      this.fetchData();
    },
    dataTypeActive(index) {
      this.currentDataTypeIndex = index;
      this.fetchData();
    }
  }
};
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w, $h) {
  width: $w;
  height: $h;
}

// 组件包裹
.blameAccidentProportIoninfoCon {
  position: relative;
  // 内容包裹
  .mileageCon {
    position: relative;
    // 下拉框包裹
    .selectCon {
      @include size(100%, 25px);
      color: #b5b5b5;
      font-size: 14px;
      line-height: 25px;
      .itemCon {
        div:nth-child(n + 2) {
          margin-left: 5px;
        }
      }
      //   .itemCon:nth-child(1) {
      //     margin-left: 132px;
      //   }
      .itemCon:nth-child(n + 2) {
        margin-right: 10px;
      }
    }
    .selectCon:nth-child(2) {
      margin-top: 10px;
    }

    // 切换数据
    .dataTypeCon {
      @include size(100%, 25px);
      margin-top: 10px;
      //   background: green;
      div {
        @include size(170px, 25px);
        box-sizing: border-box;
        text-align: center;
        line-height: 23px;
        color: #b5b5b5;
        float: left;
        background: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .dataTypeActive {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      div:nth-child(n + 2) {
        margin-left: 10px;
      }
    }

    // 图表包裹
    .chartsCon {
      @include size(100%, 200px);
      overflow: hidden;
      margin-top: 10px;
      //   background:red;
    }
  }
}
</style>