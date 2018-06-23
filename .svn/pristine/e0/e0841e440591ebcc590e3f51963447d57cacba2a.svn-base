<template>
	<div class="dline">
		<div class="tittle">驾驶员承运线路</div>
		<div class="dline_mapCon">
			<!-- 实时线路 -->
			<driverCurrentLine v-if="activeMapIndex === 0" :data="driverCurrentLineData"
                         :driverData="driverCurrentData"></driverCurrentLine>
			<!-- 历史数据 -->
			<driverHistoryLine v-if="activeMapIndex === 1" :data="driverHistoryLineData" :color="driverHistoryLineColor"></driverHistoryLine>
			<!-- 实时线路报警信息 -->
			<div v-if="activeMapIndex === 0"
			     class="current_alarm_count">
				<div class="title">当日实时报警统计</div>
				<div class="alarm_classify clearfix">
					<div :class="{active_alarm:activeAlarmIndex === 0}"
					     @click="selectAlarm(0)">驾驶行为</div>
					<div :class="{active_alarm:activeAlarmIndex === 1}"
					     @click="selectAlarm(1)">违规行为</div>
					<div :class="{active_alarm:activeAlarmIndex === 2}"
					     @click="selectAlarm(2)">违法行为</div>
					<div :class="{active_alarm:activeAlarmIndex === 3}"
					     @click="selectAlarm(3)">有责事故</div>
				</div>
				<!-- 报警信息 items -->
				<div v-for="(item,index) in alarmData"
				     :key="index"
				     class="items clearfix">
					<div>{{item.name}}</div>
					<div>{{item.value}}次</div>
				</div>
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
					<div class="itemsCon eleScrollBar">
						<div v-for="(item,index) in historyInfoData"
						     :key="index"
						     class="item clearfix">
							<div>{{index+1}}</div>
							<div class="clearfix indexCon">
								<!-- 90/220 -->
								<div :style="{width:item.value*40/maxData+'%'}"></div>
								<p>{{item.value}}</p>
							</div>
							<div>{{item.name}}</div>
						</div>
					</div>
				</div>
			</div>

			<!-- <div class="switchMap">
				<div @click="selectMap(0)">
					<div :class="{active_map:activeMapIndex === 0}">实时线路</div>
				</div>
				<div @click="selectMap(1)">
					<div :class="{active_map:activeMapIndex === 1}">历史线路</div>
				</div>
			</div> -->
		</div>

	</div>
</template>
<script type="text/javascript">
import driverCurrentLine from '../../../containers/driver/driverCurrentLine/driverCurrentLine'
import driverHistoryLine from '../../../containers/driver/driverHistoryLine/driverHistoryLine'

export default {
  name: 'DriverLine',
  components: {
    driverCurrentLine,
    driverHistoryLine,
  },
  data() {
    return {
      alarmData: [
        {
          name: '左顾右盼',
          value: 2,
        },
        {
          name: '分神提醒',
          value: 2,
        },
        {
          name: '变道频次',
          value: 1,
        },
        {
          name: '急减速',
          value: 3,
        },
        {
          name: '急加速',
          value: 1,
        },
      ],
      activeAlarmIndex: 0,
      activeMapIndex: 1,
      historyInfoData: [
        {
          name: '河北',
          value: 231564894215,
        },
        {
          name: '山东',
          value: 201564894215,
        },
        {
          name: '广东',
          value: 181564894215,
        },
        {
          name: '广西',
          value: 151564894215,
        },
        {
          name: '云南',
          value: 131564894215,
        },
        {
          name: '湖南',
          value: 101564894215,
        },
        {
          name: '湖北',
          value: 91564894215,
        },
        {
          name: '陕西',
          value: 81564894215,
        },
      ],
      // 人员地图类组件
      /*eslint-disable*/
      driverCurrentData: {
        name: "线路1",
        source: "天津大港",
        target: "东营自提",
        orderNum: 20171130156685498,
        position: "沧州",
        speed: 72,
        status: "待卸车",
        value: [125.306534, 43.889156],
        symbolSize: [45, 48],
        symbol: `image://${require("../../../assets/chartsImg/people.png")}`
      },
      driverCurrentLineData: {
        source: "天津大港",
        target: "东营自提",
        sourceCode: 5,
        targetCode: 4,
        stationCode: 731,
        mileage: 276.6,
        time: 4.8,
        riskSiteNum: 5,
        coords: [
          [125.285963, 43.947375],
          [125.285442, 43.946817],
          [125.283852, 43.945152],
          [125.282379, 43.94361],
          [125.284171, 43.943607],
          [125.290733, 43.943575],
          [125.29787, 43.943487],
          [125.300206, 43.943506],
          [125.300426, 43.943532],
          [125.300709, 43.943506],
          [125.300673, 43.943068],
          [125.300444, 43.94003],
          [125.300367, 43.938174],
          [125.300304, 43.937048],
          [125.30021, 43.93583],
          [125.300098, 43.934448],
          [125.300183, 43.934376],
          [125.300188, 43.93412],
          [125.300134, 43.93326],
          [125.300071, 43.931799],
          [125.299977, 43.931718],
          [125.299914, 43.931075],
          [125.299878, 43.930364],
          [125.299756, 43.929436],
          [125.299855, 43.929257],
          [125.299932, 43.92904],
          [125.299959, 43.928796],
          [125.299887, 43.928524],
          [125.299738, 43.928141],
          [125.299662, 43.926504],
          [125.29959, 43.926391],
          [125.299532, 43.925592],
          [125.299438, 43.924027],
          [125.299312, 43.922803],
          [125.29919, 43.921803],
          [125.299029, 43.920502],
          [125.299092, 43.920385],
          [125.299051, 43.920115],
          [125.298899, 43.918719],
          [125.298755, 43.917362],
          [125.298539, 43.915264],
          [125.298422, 43.915147],
          [125.29827, 43.913699],
          [125.297991, 43.911439],
          [125.297861, 43.909825],
          [125.297677, 43.908387],
          [125.297448, 43.906399],
          [125.297151, 43.905286],
          [125.296689, 43.904334],
          [125.296253, 43.903675],
          [125.294483, 43.901073],
          [125.293608, 43.899807],
          [125.293307, 43.899362],
          [125.293172, 43.899268],
          [125.292363, 43.898105],
          [125.291501, 43.896822],
          [125.290616, 43.895487],
          [125.290702, 43.895237],
          [125.290832, 43.895042],
          [125.292327, 43.894461],
          [125.29624, 43.893018],
          [125.298728, 43.89206],
          [125.302456, 43.890569],
          [125.303682, 43.890092],
          [125.303781, 43.889997],
          [125.305272, 43.889448],
          [125.306, 43.889208],
          [125.306534, 43.889156],
          [125.311039, 43.889065],
          [125.311098, 43.885813],
          [125.311124, 43.884004],
          [125.307882, 43.884043],
          [125.30798, 43.881327],
          [125.308052, 43.879634],
          [125.308075, 43.879481],
          [125.308205, 43.879326],
          [125.308856, 43.878874],
          [125.308816, 43.878789],
          [125.308416, 43.878487],
          [125.305847, 43.876713],
          [125.307756, 43.875284],
          [125.310774, 43.872977],
          [125.310702, 43.872934],
          [125.31359, 43.870709],
          [125.313797, 43.870605],
          [125.313972, 43.870585],
          [125.314327, 43.870683],
          [125.31465, 43.870722],
          [125.314978, 43.87066],
          [125.315252, 43.870523],
          [125.315504, 43.870338],
          [125.315629, 43.870147],
          [125.315715, 43.869984],
          [125.328134, 43.869922],
          [125.331938, 43.869919],
          [125.332113, 43.863501],
          [125.331988, 43.863498],
          [125.332024, 43.862533],
          [125.332136, 43.862529],
          [125.332298, 43.857979],
          [125.332351, 43.855031],
          [125.332414, 43.850221],
          [125.32764, 43.850286]
        ]
    },
    
	  // driverHistoryLineData
      driverHistoryLineData: [
        { name: "宜昌", value: [111.3, 30.7, 130] },
        { name: "义乌", value: [120.06, 29.32, 131] },
        { name: "丽水", value: [119.92, 28.45, 132] },
        { name: "洛阳", value: [112.44, 34.7, 133] },
        { name: "秦皇岛", value: [119.57, 39.95, 134] },
        { name: "株洲", value: [113.16, 27.83, 135] },
        { name: "石家庄", value: [114.48, 38.03, 136] },
        { name: "莱芜", value: [117.67, 36.19, 137] },
        { name: "常德", value: [111.69, 29.05, 138] },
        { name: "保定", value: [115.48, 38.85, 139] },
        { name: "湘潭", value: [115.48, 38.85, 140] },
        { name: "金华", value: [119.64, 29.12, 141] },
        { name: "岳阳", value: [113.09, 29.37, 142] },
        { name: "长沙", value: [113, 28.21, 143] },
        { name: "廊坊", value: [116.7, 39.53, 144] },
        { name: "武汉", value: [114.31, 30.52, 145] },
        { name: "大庆", value: [125.03, 46.58, 146] }
      ],
      driverHistoryLineColor:['#e28b4a', '#eac736', '#50a3ba']
    };
  },
  methods: {
    selectAlarm(index) {
      this.activeAlarmIndex = index;
    },
    selectMap(index) {
      this.activeMapIndex = index;
    }
  },
  computed: {
    maxData() {
      const dataArr = this.historyInfoData.map(item => item.value);
      const max = Math.max.apply(null, dataArr);
      return max;
    }
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
      height: 236px;
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
      width: 470px;
      height: 235px;
      overflow: hidden;
      position: absolute;
      top: 203px;
      right: 20px;
      border: 2px solid rgba(5, 208, 235, 0.8);
      background: rgba(9, 10, 11, 0.9);
      box-sizing: border-box;
      .content {
        width: 450px;
        height: 215px;
        overflow: hidden;
        margin: 8px;
        color: #b5b5b5;
        font-size: 14px;
        // background: pink;
        // 标题
        .title {
          width: 100%;
          height: 30px;
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
            line-height: 30px;
          }
          div:nth-child(1) {
            width: 80px;
          }
          div:nth-child(2) {
            width: 220px;
            margin-left: 10px;
          }
          div:nth-child(3) {
            width: 130px;
            margin-left: 10px;
          }
        }
        // itemsCon 包裹
        .itemsCon {
          width: 100%;
          height: 175px;
          overflow-y: scroll;
          margin-top: 10px;
          //   background: green;
          .item {
            width: 440px;
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
              width: 80px;
            }
            div:nth-child(2) {
              width: 220px;
              margin-left: 10px;
            }
            div:nth-child(3) {
              width: 120px;
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