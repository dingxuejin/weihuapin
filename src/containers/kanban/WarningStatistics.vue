<template>
  <div class="warning">
    <!-- <TitleView title="预警统计"></TitleView> -->
    <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="col4"></div>
      <div class="text1">预警统计</div>
      <div class="anniu"
           @click="warn">报警事件统计</div>
      <div class="text2">各月报警数量变化</div>
      <div class="text3">预警项排名</div>
    </div>
    <div class="warningStatistics">
      <!-- <div class="warningStatistics_title" >
        <div class="warningNumTotle">
          <div >报警事件统计</div>
        </div> 
      </div> -->
      <div class="warningStatistics_content">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select width="100px"
                              :data="yearOption"
                              @select='selectYear'></key-value-select>
          </div>
          <div class="fl">
            <key-value-select width="82px"
                              :data="monthOption"
                              @select="selectMonth"></key-value-select>
          </div>
          <div class="fl">
            <key-value-select width="82px"
                              :data="dayOption"
                              @select="selectDay"></key-value-select>
          </div>
        </div>
        <div class="itemCon fr clearfix">
          <div class="fl">统计维度</div>
          <div class="fl">
            <key-value-select width="100px"
                              :data="yearOption"
                              @select='selectYear'></key-value-select>
          </div>
          <div class="fl">
            <key-value-select width="82px"
                              :data="monthOption"
                              @select="selectMonth"></key-value-select>
          </div>
          <div class="fl">
            <key-value-select width="82px"
                              :data="dayOption"
                              @select="selectDay"></key-value-select>
          </div>
        </div>

        <div class="warningCarNum">
          <div>报警车辆数</div>
          <div>900</div>
          <div>
            <div></div>
            <span>报警车辆数</span>
          </div>
          <div>
            <div></div>已处理报警测含量数</div>
        </div>
        <div class="warningchartCon">
          <barhor-two chartTheme="dark"
                      :data="barhorData"></barhor-two>
        </div>
        <div class=""></div>
        <!-- <div class="warningchartCon" v-if="barhorData">
            <barhor-two  chartTheme="dark" :data="barhorData"></barhor-two>
        </div> -->
      </div>
    </div>
    <div class="warningNumChange">
      <!-- <div class="warningNumChange_title">
        各月报警数量变化
      </div> -->
      <div class="warningNumChange_content">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select width="100px"
                              :data="yearOption"
                              @select='selectYear'></key-value-select>
          </div>
        </div>
        <div class="chartCon">
          <changesinthenumberofalarmineachmonth chartTheme="dark"
                                                :data="warningNumChangeData"
                                                :color="workStrengthChartColor"
                                                :areaOpacity=0
                                                v-if="warningNumChangeData"
                                                :dataZoom=false
                                                yaxisName="报警数量"></changesinthenumberofalarmineachmonth>
          <div class="month">月</div>
        </div>
      </div>
    </div>
    <div class="warningNumRank">
      <!-- <div class="warningNumRank_title">
        预警项排名
      </div> -->
      <div class="warningNumRank_content">
        <div class="listTitle">
          <div v-for='(item,index) in listTitle'
               :key='index'>{{item}}</div>
        </div>
        <ul>
          <li v-for='(item,index) in listdata'
              :key='index'>
            <div>{{item.name}}</div>
            <div>{{item.value}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value2}}</div>
          </li>
        </ul>
      </div>
    </div>
    <div class="warning_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */

import TitleView from "./TitleView.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
import barhorTwo from "../../components/charts/barhorTwo.vue";
import changesinthenumberofalarmineachmonth from "../../components/charts/changesinthenumberofalarmineachmonth.vue";
import Dictionary from "../../util/dictionary";
const { date: { year, month, day } } = Dictionary;
export default {
  components: {
    TitleView,
    KeyValueSelect,
    Dictionary,
    barhorTwo,
    changesinthenumberofalarmineachmonth
  },
  data: () => ({
    listTitle: ["排名", "类别", "预警项", "数量"],
    listdata: [
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33 }
    ],
    yearOption: year,
    monthOption: [{ label: "全年", value: null }, ...month],
    dayOption: [{ label: "全月", value: null }, ...day],
    year: 2017,
    month: "01",
    day: "01",
    workStrengthChartColor: ["#05D0EB ", "#C88637", "#BC570C"],
    warningNumChangeData: [
      {
        data: [
          { name: "1", value: Math.floor(Math.random() * 120) },
          { name: "2", value: Math.floor(Math.random() * 120) },
          { name: "3", value: Math.floor(Math.random() * 120) },
          { name: "4", value: Math.floor(Math.random() * 120) },
          { name: "5", value: Math.floor(Math.random() * 120) },
          { name: "6", value: Math.floor(Math.random() * 120) },
          { name: "7", value: Math.floor(Math.random() * 120) },
          { name: "8", value: Math.floor(Math.random() * 120) },
          { name: "9", value: Math.floor(Math.random() * 120) },
          { name: "10", value: Math.floor(Math.random() * 120) },
          { name: "11", value: Math.floor(Math.random() * 120) },
          { name: "12", value: Math.floor(Math.random() * 120) }
        ]
      }
    ],
    barhorData: [
      {
        data: [
          {
            name: "报警车辆数",
            data: [
              {
                name: "ADAS",
                value: 52
              },
              {
                name: "DMS",
                value: 32
              },
              {
                name: "GPS+BD",
                value: 2
              }
            ]
          },
          {
            name: "已处理报警测含量数",
            // data:[42,22,20]
            data: [
              {
                name: "ADAS",
                value: 42
              },
              {
                name: "DMS",
                value: 22
              },
              {
                name: "GPS+BD",
                value: 20
              }
            ]
          }
        ]
      }
    ],
    barhorColor: ["#05d0eb", "#81d9e5", "#f6ffcb", "#e75029", "#038bfc"]
  }),
  methods: {
    selectYear(item) {
      this.year = item.value;
    },
    selectMonth(item) {
      this.month = item.value;
    },
    selectDay(item) {
      this.day = item.value;
    },
    warn() {
      alert("1111");
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.warning {
  width: 1140px;
  height: 240px;
  // padding: 5px;
  box-sizing: border-box;
  position: relative;
  .title {
    width: 1127px;
    margin-left: 10px;
    // margin-top: 7px;
    height: 30px;
    background: rgba(3, 139, 252, 0.4);
    line-height: 30px;
    box-sizing: border-box;
    font-size: 18px;
    color: #89dddf;
    position: relative;
    overflow: hidden;
    .col1 {
      width: 4px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 0;
      background: rgba(129, 217, 229, 0.3);
    }
    .col2 {
      width: 10px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 16px;
      background: rgba(129, 217, 229, 0.5);
    }
    .col3 {
      width: 2px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 388px;
      background: #89dddf;
    }
    .col4 {
      width: 2px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 778px;
      background: #89dddf;
    }
    .text1 {
      float: left;
      width: 258px;
      height: 30px;
      padding-left: 50px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .anniu {
      float: left;
      width: 112px;
      margin-right: 18px;
      // margin-right: 8px;
      // margin-top: 3px;
      height: 20px;
      margin-top: 5px;
      // padding-left: 50px;
      box-sizing: border-box;
      line-height: 20px;
      color: #89dddf;
      background: rgba(3, 139, 252, 0.4);
      font-size: 14px;
      text-align: center;
    }
    .text2 {
      float: left;
      width: 380px;
      height: 30px;
      padding-left: 50px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .text3 {
      float: left;
      width: 347px;
      height: 30px;
      padding-left: 40px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
  }
  .warningStatistics {
    @include size(390px, 200px);
    float: left;
    // margin-top: -30px;
    margin-left: 10px;
    // background:pink;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      // border-right: 2px solid #81d9e5;
      .warningNumTotle {
        @include size(112px, 20px);
        float: right;
        margin-right: 8px;
        margin-top: 3px;
        background: rgba(3, 139, 252, 0.4);
        font-size: 14px;
        color: #89dddf;
        text-align: center;
        line-height: 20px;
      }
    }
    &_content {
      @include size(100%, 186px);
      box-sizing: border-box;
      margin-top: 10px;
      border-right: 2px solid rgba(129, 217, 229, 0.4);
      .itemCon {
        @include size(392px, 37px);
        color: #b5b5b5;
        font-size: 14px;
        line-height: 25px;
        box-sizing: border-box;
        padding-left: 15px;
        div {
          &:nth-child(1) {
            margin-left: 10px;
          }
        }
      }
      .warningCarNum {
        @include size(109px, 50px);
        position: absolute;
        left: 25px;
        top: 123px;
        color: #89dddf;
        font-size: 14px;
        text-align: center;
        line-height: 30px;
        div {
          &:nth-child(1) {
            @include size(100%, 30px);
          }
          &:nth-child(2) {
            @include size(100%, 20px);
            line-height: 20px;
            background: rgba(3, 139, 252, 0.4);
          }
          &:nth-child(3) {
            @include size(100%, 20px);
            line-height: 20px;
            text-align: left;
            // background: rgba(3,139,252,0.7);
            margin-top: 20px;
            font-size: 12px;
            div {
              @include size(15px, 8px);
              background: #bc570c;
              float: left;
              margin-top: 4px;
              margin-right: 4px;
            }
          }
          &:nth-child(4) {
            @include size(150%, 20px);
            line-height: 20px;
            text-align: left;
            font-size: 12px;
            // background: rgba(3,139,252,0.7);
            div {
              @include size(15px, 8px);
              background: #05d0eb;
              float: left;
              margin-top: 4px;
              margin-right: 4px;
            }
          }
        }
      }
      .warningchartCon {
        @include size(242px, 122px);
        position: absolute;
        top: 113px;
        left: 150px;
        // background:#05d0eb;
      }
    }
  }
  .warningNumChange {
    @include size(390px, 200px);
    // margin-top: -30px;
    float: left;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      // border-right: 2px solid #81d9e5;
      font-size: 18px;
      color: #89dddf;
      line-height: 30px;
      box-sizing: border-box;
      padding-left: 50px;
    }
    &_content {
      @include size(100%, 186px);
      box-sizing: border-box;
      margin-top: 10px;
      border-right: 2px solid rgba(129, 217, 229, 0.4);
      position: relative;
      .itemCon {
        @include size(180px, 25px);
        color: #b5b5b5;
        font-size: 14px;
        line-height: 25px;
        box-sizing: border-box;
        // margin-left: 173px;
        margin-right: 10px;
        // position: absolute;
        // left: 173px;
        // top: 0;
        // margin-left: 173px;
        // padding-top: 7px;
        div:nth-child(1) {
          //   margin-left: 173px;
        }
        div:nth-child(2) {
          margin-left: 10px;
        }
      }
      .chartCon {
        @include size(100%, 155px);
        padding-left: 10px;
        padding-right: 10px;
        box-sizing: border-box;
        position: absolute;
        bottom: 0px;
        left: 0px;
        // position: relative;
        // padding-top: 37px;
        .month {
          position: absolute;
          bottom: 0px;
          right: 3px;
          font-size: 14px;
          color: #b5b5b5;
        }
      }
    }
  }
  .warningNumRank {
    @include size(349px, 200px);
    margin-left: 792px;
    // margin-top: -30px;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      font-size: 18px;
      color: #89dddf;
      line-height: 30px;
      box-sizing: border-box;
      padding-left: 50px;
    }
    &_content {
      @include size(100%, 186px);
      box-sizing: border-box;
      margin-top: 10px;
      // margin-left: 11px;
      .listTitle {
        @include size(100%, 30px);
        // clear: both;
        margin-bottom: 10px;
        float: left;
        div {
          @include size(100%, 30px);
          float: left;
          margin-left: 9px;
          box-sizing: border-box;
          text-align: center;
          line-height: 28px;
          border: 1px solid #81d9e5;
          color: #b5b5b5;
          font-size: 16px;
        }
        div:nth-child(1) {
          @include size(55px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(55px, 100%);
        }
        div:nth-child(3) {
          @include size(129px, 100%);
        }
        div:nth-child(4) {
          @include size(73px, 100%);
        }
      }
      ul {
        @include size(98%, 145px);
        list-style: none;
        overflow-y: scroll;
        color: #b5b5b5;
        float: left;
        li {
          margin-bottom: 5px;
          height: 25px;
          cursor: pointer;
          div {
            float: left;
            height: 25px;
            box-sizing: border-box;
            line-height: 23px;
            text-align: center;
            border: 1px solid rgba(0, 191, 229, 1);
            background: rgba(0, 191, 229, 0.2);
            width: 89px;
            margin-left: 9px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
          }
          div:nth-child(1) {
            @include size(55px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(55px, 100%);
          }
          div:nth-child(3) {
            @include size(129px, 100%);
          }
          div:nth-child(4) {
            @include size(63px, 100%);
          }
          &:hover div {
            background: rgba(0, 191, 229, 0.5);
            color: #ffffff;
          }
        }
      }
      ul::-webkit-scrollbar {
        background: #69a3b1;
        width: 6px;
      }
      ul::-webkit-scrollbar-thumb {
        background: #05d0eb;
      }
    }
  }
  &_bottom {
    width: calc(100% - 26px);
    height: 2px;
    position: absolute;
    bottom: -2px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
}
</style>