<template>
  <div class="cross">
    <!-- <TitleView title="跨域统计"></TitleView> -->
    <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="col4"></div>
      <div class="text1">跨域统计</div>
      <div class="anniu"
           @click="popup"></div>
      <div class="text2">跨域数量变化趋势</div>
      <div class="text3">跨域比例统计</div>
    </div>
    <div class="crossStatistics">
      <!-- <div class="crossStatistics_title"></div> -->
      <div class="crossStatistics_content">
        <div class="itemCon fr clearfix">
          <div class="fl">统计日期</div>
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
        <div class="listTitle">
          <div v-for='(item,index) in listTitle1'
               :key='index'>{{item}}</div>
        </div>
        <ul>
          <li v-for='(item,index) in listdata1'
              :key='index'>
            <div>{{item.name}}</div>
            <div>{{item.value}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value1}}</div>
          </li>
        </ul>
      </div>
    </div>
    <!-- 分割线 -->
    <div class="lineleft"></div>
    <div class="crossNumChange">
      <!-- <div class="crossNumChange_title">
        跨域数量变化趋势
      </div> -->
      <div class="crossNumChange_content">
        <div class="tab">
          <div class="tablefe"
               :class="{active:showTab}"
               @click="toggle">当年各月</div>
          <div class="tabright"
               :class="{active:!showTab}"
               @click="toggle">连续各年</div>
        </div>
        <div class="chart">
          <changetrendofdatatransmission chartTheme="dark"
                                         :data="crossNumChangeData"
                                         :color="workStrengthChartColor"
                                         :areaOpacity=0
                                         v-if="crossNumChangeData"
                                         :dataZoom=false
                                         yaxisName="占比 (%)"></changetrendofdatatransmission>
          <div class="month">月</div>
        </div>

      </div>
    </div>
     <!-- 分割线 -->
    <div class="lineright"></div>
    <div class="crossNumRank">
      <!-- <div class="crossNumRank_title">
        跨域比例统计
      </div> -->
      <div class="crossNumRank_content">
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
          </li>
        </ul>
      </div>
    </div>
    <div class="cross_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import changetrendofdatatransmission from "../../components/charts/changetrendofdatatransmission.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
import Dictionary from "../../util/dictionary";
const { date: { year, month, day } } = Dictionary;
export default {
  components: {
    TitleView,
    KeyValueSelect,
    Dictionary,
    changetrendofdatatransmission
  },
  data: () => ({
    showTab: true,
    listTitle1: ["省份", "运营商", "企业", "跨出率", "跨入率"],
    listdata1: [
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 }
    ],
    listTitle: ["排名", "企业", "跨域率"],
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
    crossNumChangeData: [
      {
        name: "跨出量",
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
      },
      {
        name: "跨入量",
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
    ]
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
    toggle() {
      this.showTab = !this.showTab;
    },
    popup(){
      alert('1111')
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.cross {
  width: 1140px;
  height: 230px;
  // padding: 5px;
  position: relative;
  box-sizing: border-box;
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
      background:  url('../../assets/kanban/qiehuan.png') no-repeat  right  center;
      background-size:18px 18ox;
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
  .crossStatistics {
    @include size(390px, 190px);
    float: left;
    margin-left: 10px;
    // margin-top: -30px;
    // background:pink;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      // border-right: 2px solid #81d9e5;
      .crossNumTotle {
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
      @include size(100%, 180px);
      box-sizing: border-box;
      margin-top: 10px;
      // border-right: 2px solid rgba(129, 217, 229, 0.4);
      padding-left: 19px;
      .itemCon {
        @include size(392px, 32px);
        color: #b5b5b5;
        font-size: 14px;
        line-height: 25px;
        box-sizing: border-box;
        padding-left: 15px;
        padding-top: 7px;
        div {
          &:nth-child(1) {
            margin-left: 10px;
          }
        }
      }
      .listTitle {
        @include size(100%, 30px);
        // clear: both;
        margin-bottom: 8px;
        margin-top: 8px;
        float: left;
        div {
          @include size(100%, 100%);
          float: left;
          margin-left: 9px;
          box-sizing: border-box;
          text-align: center;
          line-height: 30px;
          border: 1px solid #81d9e5;
          color: #b5b5b5;
          font-size: 16px;
        }
        div:nth-child(1) {
          @include size(56px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(73px, 100%);
        }
        div:nth-child(3) {
          @include size(73px, 100%);
        }
        div:nth-child(4) {
          @include size(56px, 100%);
        }
        div:nth-child(5) {
          @include size(58px, 100%);
        }
      }
      ul {
        @include size(95%, 95px);
        list-style: none;
        overflow-y: scroll;
        color: #b5b5b5;
        float: left;
        li {
          margin-bottom: 10px;
          height: 25px;
          cursor: pointer;
          div {
            float: left;
            height: 25px;
            box-sizing: border-box;
            line-height: 25px;
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
            @include size(56px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(73px, 100%);
          }
          div:nth-child(3) {
            @include size(73px, 100%);
          }
          div:nth-child(4) {
            @include size(56px, 100%);
          }
          div:nth-child(5) {
            @include size(47px, 100%);
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
  .crossNumChange {
    @include size(390px, 190px);
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
      // margin-top: 10px;
      // border-right: 2px solid rgba(129, 217, 229, 0.4);
      position: relative;
      overflow: hidden;
      .tab {
        width: 120px;
        height: 20px;
        margin-top: 10px;
        overflow: hidden;
        float: right;
        margin-right: 6px;
        .tablefe {
          width: 60px;
          height: 20px;
          line-height: 20px;
          text-align: center;
          float: left;
          font-size: 12px;
          color: #b5b5b5;
          background: rgba(5, 208, 235, 0.2);
          border: 1px solid rgba(5, 208, 235, 0.4);
          box-sizing: border-box;
          cursor: pointer;
        }
        .tabright {
          width: 60px;
          height: 20px;
          line-height: 20px;
          text-align: center;
          float: left;
          font-size: 12px;
          color: #b5b5b5;
          background: rgba(5, 208, 235, 0.2);
          border: 1px solid rgba(5, 208, 235, 0.4);
          box-sizing: border-box;
          cursor: pointer;
        }
        .active {
          color: #ffffff;
          background: rgba(5, 208, 235, 0.6);
          border: 1px solid rgba(5, 208, 235, 0.5);
        }
      }
      .chart {
        @include size(100%, 158px);
        position: absolute;
        // top: 0;
        bottom: 0;
        left: 0;
        padding-left: 10px;
        padding-right: 10px;
        // padding-top: 5px;
        margin-top: 30px;
        box-sizing: border-box;
        position: relative;
        .month {
          position: absolute;
          bottom: 4px;
          right: 3px;
          font-size: 14px;
          color: #b5b5b5;
        }
      }
    }
  }
  .crossNumRank {
    @include size(349px, 190px);
    margin-left: 788px;
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
      padding-left: 8px;
      //  border-left: 2px solid rgba(129, 217, 229, 0.4);
      .listTitle {
        @include size(100%, 45px);
        // clear: both;
        margin-bottom: 10px;
        float: left;
        div {
          @include size(100%, 100%);
          float: left;
          margin-left: 9px;
          box-sizing: border-box;
          text-align: center;
          line-height: 45px;
          border: 1px solid #81d9e5;
          color: #b5b5b5;
          font-size: 16px;
        }
        div:nth-child(1) {
          @include size(83px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(155px, 100%);
        }
        div:nth-child(3) {
          @include size(83px, 100%);
        }
      }
      ul {
        @include size(99%, 135px);
        list-style: none;
        overflow-y: scroll;
        color: #b5b5b5;
        float: left;
        li {
          margin-bottom: 5px;
          height: 40px;
          cursor: pointer;
          div {
            float: left;
            height: 40px;
            box-sizing: border-box;
            line-height: 40px;
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
            @include size(83px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(155px, 100%);
          }
          div:nth-child(3) {
            @include size(70px, 100%);
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
    bottom: 0px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
   .lineleft {
    width: 2px;
    height: 180px;
    position: absolute;
    bottom: 8px;
    left: 402px;
    background: rgba(129, 217, 229, 0.4);
  }
  .lineright {
    width: 2px;
    height: 180px;
    position: absolute;
    bottom: 8px;
    left: 793px;
    background: rgba(129, 217, 229, 0.4);
  }
}
</style>