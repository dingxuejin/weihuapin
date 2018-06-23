<template>
  <div class="veidoo">
    <!-- <TitleView title="维度统计"></TitleView> -->
     <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="text1">维度统计</div>
      <div class="text2">各月变化趋势</div>
    </div>
    <div class="veidooStatistics">
      <!-- <div class="veidooStatistics_title"></div> -->
      <div class="veidooStatistics_content">
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
    <div class="veidooNumChange">
      <!-- <div class="veidooNumChange_title">
        各月变化趋势
      </div> -->
      <div class="veidooNumChange_content">
        <changetrendofdatatransmission chartTheme="dark"
                                       :data="veidooNumChangeData"
                                       :color="workStrengthChartColor"
                                       :areaOpacity=0 
                                       v-if="veidooNumChangeData"
                                       :dataZoom=false
                                       yaxisName="传输量"></changetrendofdatatransmission>
        <div class="month">月</div>
      </div>
    </div>

    <div class="veidoo_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import changetrendofdatatransmission from "../../components/charts/changetrendofdatatransmission.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
export default {
  components: {
    TitleView,
    KeyValueSelect,
    changetrendofdatatransmission
  },
  data: () => ({
    listTitle1: ["服务商", "轨迹完整", "分值", "排名"],
    listdata1: [
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
      { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 }
    ],
    workStrengthChartColor: ["#05D0EB ", "#C88637", "#BC570C"],
    veidooNumChangeData: [
      {
        name: "轨迹",
        data: [
          { name: "1", value: Math.floor(Math.random() * 100) },
          { name: "2", value: Math.floor(Math.random() * 100) },
          { name: "3", value: Math.floor(Math.random() * 100) },
          { name: "4", value: Math.floor(Math.random() * 100) },
          { name: "5", value: Math.floor(Math.random() * 100) },
          { name: "6", value: Math.floor(Math.random() * 100) },
          { name: "7", value: Math.floor(Math.random() * 100) },
          { name: "8", value: Math.floor(Math.random() * 100) },
          { name: "9", value: Math.floor(Math.random() * 100) },
          { name: "10", value: Math.floor(Math.random() * 100) },
          { name: "11", value: Math.floor(Math.random() * 100) },
          { name: "12", value: Math.floor(Math.random() * 100) }
        ]
      },
      {
        name: "数据",
        data: [
          { name: "1", value: Math.floor(Math.random() * 100) },
          { name: "2", value: Math.floor(Math.random() * 100) },
          { name: "3", value: Math.floor(Math.random() * 100) },
          { name: "4", value: Math.floor(Math.random() * 100) },
          { name: "5", value: Math.floor(Math.random() * 100) },
          { name: "6", value: Math.floor(Math.random() * 100) },
          { name: "7", value: Math.floor(Math.random() * 100) },
          { name: "8", value: Math.floor(Math.random() * 100) },
          { name: "9", value: Math.floor(Math.random() * 100) },
          { name: "10", value: Math.floor(Math.random() * 100) },
          { name: "11", value: Math.floor(Math.random() * 100) },
          { name: "12", value: Math.floor(Math.random() * 100) }
        ]
      },
      {
        name: "卫星车辆",
        data: [
          { name: "1", value: Math.floor(Math.random() * 100) },
          { name: "2", value: Math.floor(Math.random() * 100) },
          { name: "3", value: Math.floor(Math.random() * 100) },
          { name: "4", value: Math.floor(Math.random() * 100) },
          { name: "5", value: Math.floor(Math.random() * 100) },
          { name: "6", value: Math.floor(Math.random() * 100) },
          { name: "7", value: Math.floor(Math.random() * 100) },
          { name: "8", value: Math.floor(Math.random() * 100) },
          { name: "9", value: Math.floor(Math.random() * 100) },
          { name: "10", value: Math.floor(Math.random() * 100) },
          { name: "11", value: Math.floor(Math.random() * 100) },
          { name: "12", value: Math.floor(Math.random() * 100) }
        ]
      }
    ]
  })
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.veidoo {
  @include size(713px, 100%);
  // padding: 5px 0px;
  position: relative;
  // margin-left: 10px;
   .title {
    width: 722px;
    // margin-left: 20px;
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
  .veidooStatistics {
    @include size(375px, 239px);
    float: left;
    // margin-top: -30px;
    // background:pink;
    &_title {
      @include size(100%, 26px);
      box-sizing: border-box;
      margin-top: 2px;
      border-right: 2px solid rgba(129, 217, 229, 0.5);
    }
    &_content {
      @include size(100%, 186px);
      box-sizing: border-box;
      margin-top: 10px;
      border-right: 2px solid rgba(129, 217, 229, 0.5);
      .listTitle {
        @include size(100%, 30px);
        // clear: both;
        margin-bottom: 10px;
        margin-left: 18px;
        // margin-top: 10px;
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
          @include size(97px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(100px, 100%);
        }
        div:nth-child(3) {
          @include size(53px, 100%);
        }
        div:nth-child(4) {
          @include size(58px, 100%);
        }
      }
      ul {
        @include size(90%, 146px);
        list-style: none;
        overflow-y: scroll;
        color: #b5b5b5;
        float: left;
        margin-left: 18px;
        li {
          margin-bottom: 5px;
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
            @include size(97px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(100px, 100%);
          }
          div:nth-child(3) {
            @include size(53px, 100%);
          }
          div:nth-child(4) {
            @include size(48px, 100%);
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
  .veidooNumChange {
    @include size(338px, 239px);
    // margin-top: -30px;
    float: left;
    // background: #05D0EB;
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
    //   box-sizing: border-box;
    //   margin-top: 10px;
      padding-left: 10px;
      padding-right: 10px;
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
  .veidooNumRank {
    @include size(349px, 239px);
    margin-left: 780px;
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
      margin-left: 11px;
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
    bottom: 2px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
}
</style>