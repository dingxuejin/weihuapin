<template>
  <div class="remote">
    <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="text1">异地经营统计</div>
      <div class="text2">异地经营车辆变化趋势</div>
    </div>
    <div class="remoteStatistics">
      <div class="remoteStatistics_content">
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
          </li>
        </ul>
      </div>
    </div>
    <div class="remoteRight">
      <div class="remoteNumChange">
        <div class="remoteNumChange_content">
          <changetrendofdatatransmission chartTheme="dark"
                                         :data="warningNumChangeData"
                                         :color="workStrengthChartColor"
                                         :areaOpacity=0
                                         v-if="warningNumChangeData"
                                         :dataZoom=false
                                         yaxisName="报警数量"></changetrendofdatatransmission>
          <div class="month">年</div>
        </div>
      </div>
      <div class="remoteNumRank">
        <div class="remoteNumRank_title">
          跨域比例统计
        </div>
        <div class="remoteNumRank_content">
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
    </div>

    <div class="remote_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
import changetrendofdatatransmission from "../../components/charts/changetrendofdatatransmission.vue";
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
    listTitle1: ["省份", "服务商", "企业", "异地车数量"],
    listdata1: [
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 }
    ],
    listTitle: ["排名", "企业", "异地经营率"],
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
    workStrengthChartColor: ["#05D0EB ", "#C88637", "#BC570C"],
    warningNumChangeData: [
      {
        name: "异地经营车辆",
        data: [
          { name: "2011", value: Math.floor(Math.random() * 120) },
          { name: "2012", value: Math.floor(Math.random() * 120) },
          { name: "2013", value: Math.floor(Math.random() * 120) },
          { name: "2014", value: Math.floor(Math.random() * 120) },
          { name: "2015", value: Math.floor(Math.random() * 120) },
          { name: "2016", value: Math.floor(Math.random() * 120) },
          { name: "2017", value: Math.floor(Math.random() * 120) },
          { name: "2018", value: Math.floor(Math.random() * 120) },
          { name: "2019", value: Math.floor(Math.random() * 120) },
          { name: "2020", value: Math.floor(Math.random() * 120) },
          { name: "2021", value: Math.floor(Math.random() * 120) },
          { name: "2022", value: Math.floor(Math.random() * 120) }
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
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.remote {
  @include size(722px, 463px);
  // padding: 5px 0px;
  position: relative;
  // margin-left: 15px;
  .title {
    width: 722px;
    height: 30px;
    background: rgba(3, 139, 252, 0.4);
    line-height: 30px;
    box-sizing: border-box;
    font-size: 18px;
    color: #89dddf;
    position: relative;
    &:after{
      conten:"";
      display: block;
      clear: both;
    }
    // overflow: hidden;
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
      left: 374px;
      background: #89dddf;
    }
    // .col4 {
    //   width: 2px;
    //   height: 30px;
    //   position: absolute;
    //   top: 0;
    //   left: 750px;
    //   background: #89dddf;
    // }
    .text1 {
      float: left;
      width: 374px;
      height: 30px;
      padding-left: 50px;
      position: absolute;
      top: 0;
      left: 0px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .text2 {
      float: left;
      width: 348px;
      height: 30px;
      padding-left: 38px;
       position: absolute;
      top: 0;
      left: 374px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    // .text3 {
    //   float: left;
    //   width: 338px;
    //   height: 30px;
    //   padding-left: 16px;
    //   box-sizing: border-box;
    //   line-height: 30px;
    //   color: #89dddf;
    //   font-size: 18px;
    // }
  }
  .remoteStatistics {
    @include size(370px, 472px);
    float: left;
    // margin-top: -30px;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      border-right: 2px solid rgba(129, 217, 229, 0.5);
    }
    &_content {
      @include size(100%, 432px);
      box-sizing: border-box;
      margin-top: 10px;
      border-right: 2px solid rgba(129, 217, 229, 0.5);
      padding-left: 5px;
      .itemCon {
        @include size(392px, 37px);
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
        margin-bottom: 10px;
        margin-top: 5px;
        margin-left: 3px;
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
          @include size(55px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(83px, 100%);
        }
        div:nth-child(3) {
          @include size(81px, 100%);
        }
        div:nth-child(4) {
          @include size(98px, 100%);
        }
      }
      ul {
        @include size(95%, 342px);
        margin-left: 3px;
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
            @include size(55px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(83px, 100%);
          }
          div:nth-child(3) {
            @include size(81px, 100%);
          }
          div:nth-child(4) {
            @include size(89px, 100%);
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
  .remoteRight {
    @include size(338px, 480px);
    margin-left: 370px;
    .remoteNumChange {
      @include size(100%, 235px);
      margin-top: -30px;
      &_title {
        @include size(100%, 26px);
        box-sizing: border-box;
        margin-top: 2px;
        font-size: 18px;
        color: #89dddf;
        line-height: 30px;
        box-sizing: border-box;
        padding-left: 18px;
      }
      &_content {
        @include size(100%, 186px);
        box-sizing: border-box;
        margin-top: 10px;
        padding-left: 10px;
        padding-right: 10px;
        box-sizing: border-box;
        position: relative;
        .month {
          position: absolute;
          bottom: 4px;
          right: 10px;
          font-size: 14px;
          color: #b5b5b5;
        }
      }
    }
    .remoteNumRank {
      @include size(100%, 240px);
      &_title {
        @include size(321px, 26px);
        background-color: rgba(3, 139, 252, 0.4);
        box-sizing: border-box;
        margin-top: 2px;
        font-size: 18px;
        color: #89dddf;
        line-height: 26px;
        margin-left: 11px;
        box-sizing: border-box;
        padding-left: 18px;
      }
      &_content {
        @include size(321px, 186px);
        box-sizing: border-box;
        margin-top: 10px;
        margin-left: 11px;
        .listTitle {
          @include size(100%, 45px);
          // clear: both;
          margin-bottom: 10px;
          float: left;
          div {
            @include size(100%, 100%);
            float: left;
            margin-left: 5px;
            box-sizing: border-box;
            text-align: center;
            line-height: 45px;
            border: 1px solid #81d9e5;
            color: #b5b5b5;
            font-size: 16px;
          }
          div:nth-child(1) {
            @include size(80px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(150px, 100%);
          }
          div:nth-child(3) {
            @include size(80px, 100%);
            line-height: 22px;
          }
        }
        ul {
          @include size(100%, 130px);
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
              margin-left: 5px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
            }
            div:nth-child(1) {
              @include size(80px, 100%);
              margin-left: 0px;
            }
            div:nth-child(2) {
              @include size(150px, 100%);
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
  }
  &_bottom {
    width: 700px;
    height: 2px;
    position: absolute;
    bottom: -8px;
    left: 8px;
    background: rgba(129, 217, 229, 0.5);
  }
}
</style>