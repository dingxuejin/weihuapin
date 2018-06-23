<template>
  <div class="dline">
    <div class="tittle">驾驶员承运线路</div>
    <div class="dline_mapCon">
      <!-- 实时线路 -->
      <driverCurrentLine v-if="activeMapIndex === 0 && runtime_route_info"
                         :data="runtime_route_info"
                         :driverData="driverCurrentData"></driverCurrentLine>
      <!-- 历史数据 -->
      <driverHistoryLine v-if="activeMapIndex === 1&&jy"
                         :data="jy"
                         :color="driverHistoryLineColor"></driverHistoryLine>
      <!-- 实时线路报警信息 -->
      <div v-if="activeMapIndex === 0"
           class="current_alarm_count">
        <div class="title">当日实时报警统计</div>
        <div class="alarm_classify clearfix">
          <div :class="{active_alarm:activeAlarmIndex === 0}"
               @click="selectAlarm(0)">驾驶行为</div>
          <!-- <div :class="{active_alarm:activeAlarmIndex === 1}"
               @click="selectAlarm(1)">违规行为</div>
          <div :class="{active_alarm:activeAlarmIndex === 2}"
               @click="selectAlarm(2)">违法行为</div> -->
          <!-- <div :class="{active_alarm:activeAlarmIndex === 3}"
               @click="selectAlarm(3)">有责事故</div> -->
        </div>
        <!-- 报警信息 items -->

        <template>
          <div v-for="(item,index) in alarmData"
               :key="index"
               class="items clearfix"
               @click="openDialog"
               v-if="detailsShow">
            <div>{{item.name}}</div>
            <div>{{item.value}}次</div>
          </div>
        </template>
        <loading :data='todayAlarm'></loading>
      </div>

      <!-- 历史线路信息 -->
      <div v-if="activeMapIndex === 1"
           class="history_infoCon">
        <div class="content">
          <div class="title clearfix">
            <div>排名</div>
            <div>周转量</div>
            <div>区域</div>
          </div>
          <div class="itemsCon eleScrollBar"
               v-if="jy">
            <div v-for="(item,index) in jy"
                 :key="index"
                 class="item clearfix">
              <div>{{index+1}}</div>
              <div class="clearfix indexCon">
                <!-- <div :style="{width:item.value*40/maxData+'%'}"></div> -->
                <p>{{item.value}}</p>
              </div>
              <div>{{item.name}}</div>
            </div>
          </div>
          <loading :data='jy'></loading>
        </div>
      </div>

      <div class="switchMap">
        <div @click="selectMap(0)">
          <div :class="{active_map:activeMapIndex === 0}">实时线路</div>
        </div>
        <div @click="selectMap(1)">
          <div :class="{active_map:activeMapIndex === 1}">历史线路</div>
        </div>
      </div>
      <!-- <div v-show="false">{{gettodayAlarm}}</div> -->
    </div>

  </div>
</template>
<script>
import { mapState, mapActions, mapMutations } from 'vuex'
import driverCurrentLine from '../../../containers/driver/driverCurrentLine/driverCurrentLine'
import driverHistoryLine from '../../../containers/driver/driverHistoryLine/driverHistoryLine'

export default {
  name: 'DriverLine',
  components: {
    driverCurrentLine,
    driverHistoryLine,
  },
  computed: {
    ...mapState('driverLine', ['jy', 'todayAlarm', 'runtime_route_info']),
    ...mapState('driverbase', ['ryjb']),
    alarmData() {
      if (this.todayAlarm) {
        const key = {
          0: () =>
            this.todayAlarm
              .map(i => ({
                name: i.jssjlx.drive_event_type,
                value: i['sum(alarm_quantity)'],
              }))
              .filter(i => i.value > 0),
          1: () =>
            this.todayAlarm
              .map(i => ({
                name: i.jssjlx.drive_event_type,
                value: i['sum(irregularity_quantity)'],
              }))
              .filter(i => i.value > 0),
          2: () =>
            this.todayAlarm
              .map(i => ({
                name: i.jssjlx.drive_event_type,
                value: i['sum(illegal_quantity)'],
              }))
              .filter(i => i.value > 0),
          3: () =>
            this.todayAlarm
              .map(i => ({
                name: `${i.sgdj.accident_level}${
                  i.sgzr.accident_responsibility
                }${i.sfxl.if_hm_release}泄露`,
                value: i['sum(accident_quantity)'],
              }))
              .filter(i => i.value > 0),
        }
        return key[this.activeAlarmIndex]()
      }
      return null
    },
    maxData() {
      const dataArr = this.jy.map(item => item.value)
      const max = Math.max(...dataArr)
      return max
    },
    gettodayAlarm() {
      this.getTodayDriver({
        driver_id: '201408000001',
        year: 2017,
        month: 11,
        day: 18,
      })
      return null
    },
  },
  data() {
    return {
      activeAlarmIndex: 0,
      activeMapIndex: 0,

      // 人员地图类组件
      /*eslint-disable*/
      driverCurrentData: {
        name: "线路1",
        source: "揭阳渔湖站",
        target: "永州新奥",
        orderNum: 20171017445243110057,
        position: "揭阳",
        speed: 72,
        status: "待卸车",
        value: [125.306534, 43.889156],
        symbolSize: [45, 48],
        symbol: `image://${require("../../../assets/chartsImg/people.png")}`
      },

      driverCurrentLineData: {
        source: "揭阳渔湖站",
        target: "永州新奥",
        sourceCode: 5,
        targetCode: 4,
        stationCode: "永州分卸",
        mileage: 805.5,
        time: 12.5,
        riskSiteNum: 7,
        coords: [
          [125.285963, 43.947375],
          [125.285442, 43.946817],
          [125.283852, 43.945152]
        ]
      },

      // driverHistoryLineData
      driverHistoryLineData: [
        { name: "湖北", value: 1000000 }
      ],

      driverHistoryLineColor: ["#e28b4a", "#eac736", "#50a3ba"],

      detailsShow: false
    };
  },
  methods: {
    ...mapActions("driverLine", [
      "getTodayDriver",
      "getToadyIrregularity",
      "getTodayIllegal",
      "getTodayAccident",
      "getDriver_runtime_route_info"
    ]),
    ...mapMutations("driver", ["open"]),
    ...mapActions("driverlinerealtimealarminfo", ["setType"]),
    openDialog() {
      //设置type
      this.setType({
        driver_id: this.ryjb && this.ryjb.driver_id,
        type: ["驾驶行为", "有责事故"][this.activeAlarmIndex]
      });
      //打开弹窗
      this.open("driverLineRealtimeAlarm");
    },
    selectAlarm(index) {
      let switchApi = {
        0: () =>
          this.getTodayDriver({
            driver_id: this.ryjb && this.ryjb.driver_id,
            year: 2017,
            month: 11,
            day: 18
          }),
        1: () =>
          this.getToadyIrregularity({
            driver_id: this.ryjb && this.ryjb.driver_id,
            year: 2017,
            month: 11,
            day: 18
          }),
        2: () =>
          this.getTodayIllegal({
            driver_id: this.ryjb && this.ryjb.driver_id,
            year: 2017,
            month: 11,
            day: 18
          }),
        3: () =>
          this.getTodayAccident({
            driver_id: this.ryjb && this.ryjb.driver_id,
            year: 2017,
            month: 11,
            day: 18
          })
      };
      switchApi[index]();
      this.activeAlarmIndex = index;
      this.detailsShow = true;
    },
    selectMap(index) {
      this.activeMapIndex = index;
    }
  },
  mounted() {
    this.gettodayAlarm;
  },
  created(){
    // this.getDriver_runtime_route_info({
    //   driver_id: '201408000001',
    // })
  }
};
</script>

<style lang="scss" scoped>
// -----------公用样式变量
@mixin font_level_4_1() {
  color: #b5b5b5;
  font-size: 14px;
}

.eleScrollBar::-webkit-scrollbar {
  width: 5px;
  height: 100%;
  background: url("../../../assets/driver/scroll.png") no-repeat;
  background-size: 100% 100%;
}

.eleScrollBar::-webkit-scrollbar-thumb {
  background: #05d0eb;
}
.dline {
  width: 100%;
  height: 100%;
  overflow: hidden;
  position: relative;
  // title
  .tittle {
    width: 300px;
    height: 50px;
    overflow: hidden;
    position: absolute;
    top: 0px;
    left: 20px;
    z-index: 2;
    color: #89dddf;
    font-size: 24px;
    font-weight: bold;
    text-align: center;
    line-height: 50px;
    background: url("../../../assets/driver/center_frame_route.png") no-repeat;
    background-size: 100% 100%;
  }
  // 地图包裹
  .dline_mapCon {
    width: 100%;
    height: 455px;
    overflow: hidden;
    margin-top: 25px;
    position: relative;
    border: 1px solid rgba(5, 208, 235, 0.8);
    box-sizing: border-box;
    // background:cyan;
    // 右上侧信息
    .current_alarm_count {
      width: 323px;
      // height: 236px;
      overflow: hidden;
      //   border: 1px solid #fff;
      position: absolute;
      top: 0px;
      right: 0px;
      // title
      .title {
        width: 100%;
        height: 30px;
        overflow: hidden;
        background: rgba(231, 80, 41, 0.6);
        text-indent: 20px;
        line-height: 30px;
        color: #fff;
        font-size: 16px;
      }
      .alarm_classify {
        width: 100%;
        height: 25px;
        overflow: hidden;
        // background: green;
        border-top: 1px solid #000;
        div {
          width: 80px;
          height: 100%;
          overflow: hidden;
          float: left;
          background: rgba(231, 80, 41, 0.3);
          @include font_level_4_1();
          text-align: center;
          line-height: 25px;
          cursor: pointer;
        }
        div:nth-child(n + 2) {
          margin-left: 1px;
        }
        .active_alarm {
          color: #fff;
          background: rgba(231, 80, 41, 0.6);
        }
      }
      // alarm items
      .items {
        width: 100%;
        height: 35px;
        overflow: hidden;
        background: rgba(231, 80, 41, 0.2);
        border-top: 1px solid #000;
        color: #fff;
        font-size: 14px;
        line-height: 35px;
        cursor: pointer;
        div:nth-child(1) {
          float: left;
          margin-left: 40px;
        }
        div:nth-child(2) {
          float: right;
          margin-right: 40px;
        }
      }
    }
    //切换地图
    .switchMap {
      width: 220px;
      height: 130px;
      overflow: hidden;
      //   margin-top: 45px;
      position: absolute;
      top: 45px;
      left: 0px;
      //   background: #000;
      div {
        width: 100%;
        height: 60px;
        overflow: hidden;
        border: 2px solid rgba(5, 208, 235, 0.8);
        background: rgba(9, 10, 11, 0.9);
        box-sizing: border-box;
        cursor: pointer;
        div {
          width: 190px;
          height: 30px;
          overflow: hidden;
          background: rgba(5, 208, 235, 0.3);
          border: none;
          margin: 14px 13px;
          text-align: center;
          line-height: 30px;
          color: #b5b5b5;
          font-size: 18px;
          font-weight: bold;
        }
      }
      // 历史线路
      div:nth-child(2) {
        margin-top: 10px;
      }
      // hover样式
      .active_map {
        color: #fff;
        background: rgba(5, 208, 235, 0.8);
      }
    }

    // 历史信息窗口
    .history_infoCon {
      width: 280px;
      height: 144px;
      overflow: hidden;
      position: absolute;
      top: 304px;
      right: 5px;
      border: 2px solid rgba(5, 208, 235, 0.8);
      background: rgba(9, 10, 11, 0.9);
      box-sizing: border-box;
      .content {
        width: 265px;
        height: 140px;
        overflow: hidden;
        margin: 8px;
        color: #b5b5b5;
        font-size: 12px;
        // background: pink;
        // 标题
        .title {
          width: 100%;
          height: 25px;
          line-height: 25px;
          font-size: 12px;
          overflow: hidden;
          box-sizing: border-box;
          //   background: green;
          div {
            float: left;
            height: 100%;
            box-sizing: border-box;
            border: 1px solid rgba(5, 208, 235, 0.8);
            background: rgba(9, 10, 11, 0.9);
            color: #b5b5b5;
            text-align: center;
            line-height: 20px;
          }
          div:nth-child(1) {
            width: 40px;
          }
          div:nth-child(2) {
            width: 120px;
            margin-left: 10px;
          }
          div:nth-child(3) {
            width: 80px;
            margin-left: 10px;
          }
        }
        // itemsCon 包裹
        .itemsCon {
          width: 100%;
          height: 88px;
          overflow-y: scroll;
          margin-top: 10px;
          //   background: green;
          .item {
            width: 255px;
            height: 25px;
            overflow: hidden;
            // background: #fff;
            div {
              float: left;
              height: 100%;
              text-align: center;
              line-height: 23px;
              box-sizing: border-box;
              border: 1px solid rgba(5, 208, 235, 0.8);
              background: rgba(9, 10, 11, 0.9);
            }
            div:nth-child(1) {
              width: 40px;
            }
            div:nth-child(2) {
              width: 120px;
              margin-left: 10px;
            }
            div:nth-child(3) {
              width: 70px;
              margin-left: 10px;
            }
            // 中间部分
            .indexCon div:nth-child(1) {
              width: 90px;
              height: 10px;
              float: left;
              margin-left: 10px;
              margin-top: 6px;
              border: none;
              background: #89dddf;
            }
            .indexCon p:nth-child(2) {
              float: left;
              border: none;
              line-height: 23px;
              margin-left: 5px;
              //   background: green;
            }
          }
          .item:nth-child(n + 2) {
            margin-top: 5px;
          }
          .item:nth-child(1) div {
            border: 1px solid rgba(5, 208, 235, 0.8);
            background: rgba(5, 208, 235, 0.3);
          }
          // hover 高亮
          .item:hover {
            color: #fff;
          }
        }
      }
    }
  }
}
</style>