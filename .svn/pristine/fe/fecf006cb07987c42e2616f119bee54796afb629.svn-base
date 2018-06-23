<template>
  <div class="container">
    <div class="top-border">
    </div>

    <!-- content -->
    <div class="content clearfix">
      <!-- 左侧部分 -->
      <div class="leftCon fl">
        <headerMsg></headerMsg>
        <div class="left_center">
          <peopleMsg></peopleMsg>
        </div>
        <div class="left_center"
             style="margin-top:10px">
          <carMsg @up='carShow'></carMsg>
        </div>
        <div class="left_center left_center3"
             style="margin-top:10px">
          <lineMsg @upx='lineShow'></lineMsg>
        </div>
      </div>
      <!-- 中间部分 -->
      <div class="centerCon fl">
        <centerMsg @up='centerShow'></centerMsg>
      </div>

      <!-- 右侧部分 -->
      <div class="rightCon">
        <div class="rightTop">
          <manageMsg></manageMsg>
        </div>
        <div class="rightBottom">
          <safeMsg></safeMsg>
        </div>
      </div>

    </div>

    <!-- 弹窗 -->
    <div class="pop_car"
         v-if='car_show'>
      <carPopup @upx='carup'></carPopup>
    </div>

    <div class="pop_line"
         v-show='line_show'>
      <linePopup @upx='lineup'></linePopup>
    </div>

    <div class="pop_center"
         v-show='center_show'>
      <centerPopup @upx='centerup'></centerPopup>
    </div>

    <!-- 车辆状态二级弹窗 -->
    <div class="carBaseMsgCon"
         v-if="popCarBaseMsg"
         v-drag>
      <center-car-popup @upx="companyClose('popCarBaseMsg')"></center-car-popup>
    </div>

  </div>
</template>
<script>
import { mapState, mapMutations } from 'vuex'
import PopUpFrame from '../components/PopUpFrame'
import peopleMsg from '../containers/company/peopleMsg/peopleMsg'
import carMsg from '../containers/company/carMsg/carMsg'
import lineMsg from '../containers/company/lineMsg/lineMsg'
import manageMsg from '../containers/company/manageMsg/manageMsg'
import safeMsg from '../containers/company/safeMsg/safeMsg'
import centerMsg from '../containers/company/centerMsg/centerMsg'
import headerMsg from '../containers/company/headerMsg/headerMsg'

import carPopup from '../containers/company/carPopup/carPopup'
import linePopup from '../containers/company/linePopup/linePopup'
import centerPopup from '../containers/company/centerPopup/centerPopup'
import centerCarPopup from '../containers/company/centerPopup/centerCarPopup'

// import amessage from './amessage'
// import aheader from './aheader'
// import aCarPeople from './aCarPeople'
// import aline from './aline'
// import amanage from './amanage'
// import asafe from './asafe'
// 组件
import carsMsg from '../components/company/carsMsg'
import driveBehavior from '../components/company/driveBehavior'
import CarCenterTopMarquee from '../components/car/CarCenterTopMarquee'
// 企业首页布局组件
import companyMsg from '../containers/company/companyMsg/companyMsg'
import companyIndex from '../containers/company/companyIndex/companyIndex'
import lineRank from '../containers/company/lineRank/lineRank'
import driveRankTable from '../containers/company/driveRankTable/driveRankTable'
// 0201 修改动态组件
import bar from '../components/charts/bar'
import barhor from '../components/charts/barhor'
import barInfobox from '../components/charts/barInfobox'
import barMore from '../components/charts/barMore'
import lineArea from '../components/charts/lineArea'
import lineChart from '../components/charts/lineChart'
import pieRose from '../components/charts/pieRose'
import ring from '../components/charts/ring'
import ringAndIndex from '../components/charts/ringAndIndex'
import ringMore from '../components/charts/ringMore'
import ringSingle from '../components/charts/ringSingle'
import lineDoubleAxis from '../components/charts/lineDoubleAxis'
// 企业获取流向地图
import companyGoodsMap from '../containers/company/companyGoodsMap/companyGoodsMap'

export default {
  name: 'companyHome',
  components: {
    PopUpFrame,
    // 另加
    peopleMsg,
    carMsg,
    lineMsg,
    manageMsg,
    safeMsg,
    centerMsg,
    headerMsg,

    carPopup,
    linePopup,
    centerPopup,
    centerCarPopup,

    // amessage,
    // aheader,
    // aCarPeople,
    // aline,
    // amanage,
    // asafe,

    carsMsg,
    driveBehavior,
    // 中间顶部滚动
    CarCenterTopMarquee,
    // 企业首页布局组件
    companyMsg,
    companyIndex,
    lineRank,
    driveRankTable,
    // 图表组件
    bar,
    barhor,
    barInfobox,
    barMore,
    lineArea,
    lineChart,
    pieRose,
    ring,
    ringAndIndex,
    ringMore,
    ringSingle,
    lineDoubleAxis,
    // 企业地图类组件
    // 企业获取流向地图组件
    companyGoodsMap,
  },
  methods: {
    ...mapMutations('company', ['companyClose']),
    carShow() {
      this.car_show = !this.car_show
    },
    carup() {
      this.car_show = false
    },
    lineShow() {
      this.line_show = !this.line_show
    },
    lineup() {
      this.line_show = false
    },
    centerShow() {
      this.center_show = !this.center_show
    },
    centerup() {
      this.center_show = false
    },
  },
  data() {
    return {
      // 另加
      car_show: false,
      line_show: false,
      center_show: false,

      // 组件数据
      aqysData: {
        name: '安全运输',
        value: 4296,
        unit: '天',
      },
      wsgxcData: {
        name: '无事故行车',
        value: 24586,
        unit: '公里',
      },
      dangerdrive_num: {
        name: '当日高危驾驶行为数量',
        total: 5048,
        deal_num: 2356,
      },
      illegalBehavior_num: {
        name: '当日违规行为数量',
        total: 4048,
        deal_num: 1659,
      },
      driveRankData: [
        {
          name: '王明',
          value: 99,
        },
        {
          name: '王明',
          value: 98,
        },
        {
          name: '王明',
          value: 97,
        },
        {
          name: '王明',
          value: 96,
        },
        {
          name: '王明',
          value: 95,
        },
      ],
      lineRankData: [
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
        {
          carNum: 123,
          order_num: 456,
          sum: 789,
          lineName: '线路6',
        },
      ],
      // 图表数据
      // bar
      barData: [
        {
          name: '数据一',
          value: 1,
        },
        {
          name: '数据二',
          value: 2,
        },
      ],
      barColor: ['red', 'green'],
      // barhor
      barhorData: [
        {
          seriesName: '数据一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
          ],
        },
        {
          seriesName: '数据二',
          data: [
            {
              name: '数据一',
              value: 3,
            },
            {
              name: '数据二',
              value: 4,
            },
          ],
        },
      ],
      barhorColor: ['red', 'green'],
      // barinfobox
      barInfoboxData: [
        {
          name: '一',
          value: 1,
          total: 100,
        },
        {
          name: '二',
          value: 2,
          total: 200,
        },
        {
          name: '三',
          value: 3,
          total: 300,
        },
        {
          name: '四',
          value: 4,
          total: 400,
        },
        {
          name: '五',
          value: 5,
          total: 500,
        },
      ],
      barInfoboxColor: ['red', 'green'],
      // barmore
      barMoreData: [
        {
          seriesName: '数据一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
          ],
        },
        {
          seriesName: '数据二',
          data: [
            {
              name: '数据一',
              value: 3,
            },
            {
              name: '数据二',
              value: 4,
            },
          ],
        },
      ],
      barMoreColor: ['red', 'green'],
      // lineArea
      lineAreaData: [
        {
          seriesName: '数据一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
            {
              name: '数据三',
              value: 1,
            },
          ],
        },
        {
          seriesName: '数据二',
          data: [
            {
              name: '数据一',
              value: 3,
            },
            {
              name: '数据二',
              value: 4,
            },
            {
              name: '数据三',
              value: 3,
            },
          ],
        },
      ],
      lineAreaColor: ['red', 'green'],
      // lineChart
      lineChartData: [
        {
          seriesName: '数据一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
            {
              name: '数据三',
              value: 1,
            },
          ],
        },
        {
          seriesName: '数据二',
          data: [
            {
              name: '数据一',
              value: 3,
            },
            {
              name: '数据二',
              value: 4,
            },
            {
              name: '数据三',
              value: 3,
            },
          ],
        },
      ],
      lineChartColor: ['red', 'green'],
      // pieRose
      pieRoseData: [
        {
          name: '数据一',
          value: 1,
        },
        {
          name: '数据二',
          value: 2,
        },
        {
          name: '数据三',
          value: 3,
        },
        {
          name: '数据四',
          value: 4,
        },
      ],
      pieRoseColor: ['red', 'orange', 'green', 'cyan'],
      // ring
      ringData: [
        {
          name: '数据一',
          value: 1,
        },
        {
          name: '数据二',
          value: 1,
        },
        {
          name: '数据三',
          value: 1,
        },
        {
          name: '数据四',
          value: 1,
        },
      ],
      ringColor: ['red', 'orange', 'green', 'cyan'],
      // ringAndIndex
      ringAndIndexData: [
        {
          name: '挂车',
          value: 33,
        },
        {
          name: '货车',
          value: 31,
        },
        {
          name: '牵引车',
          value: 23,
        },
      ],
      ringAndIndexColor: ['red', 'orange', 'green', 'cyan'],
      // ringMore
      ringMoreData: [
        {
          name: '数据一',
          total: 100,
          ry_num: 20,
        },
        {
          name: '数据二',
          total: 100,
          ry_num: 30,
        },
      ],
      ringMoreRadius: [
        // 第一个数组为bg radius
        ['66.5%', '67%'],
        ['70%', '75%'],
        ['78%', '83%'],
      ],
      ringMoreColor: ['red', 'orange', 'green', 'cyan'],
      // ringSingle
      ringSingleData: {
        total: 100,
        value: 50,
      },
      ringSingleColor: ['red', 'green'],
      // ringSingleMore
      ringSingleMoreData: [
        {
          name: '数据一',
          total: 100,
          value: 10,
        },
        {
          name: '数据二',
          total: 100,
          value: 20,
        },
        {
          name: '数据三',
          total: 100,
          value: 30,
        },
      ],
      ringSingleMoreColor: ['red', 'orange', 'green', 'cyan', 'purple'],
      ringSingleMoreRadius: [
        ['49%', '50%'],
        ['55%', '60%'],
        ['65%', '70%'],
        ['75%', '80%'],
        ['85%', '90%'],
      ],
      // lineDoubleAxis
      lineDoubleAxisData: [
        {
          seriesName: '系列一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
            {
              name: '数据三',
              value: 3,
            },
            {
              name: '数据四',
              value: 4,
            },
          ],
        },
        {
          seriesName: '系列二',
          data: [
            {
              name: '数据一',
              value: 2,
            },
            {
              name: '数据二',
              value: 3,
            },
            {
              name: '数据三',
              value: 4,
            },
            {
              name: '数据四',
              value: 5,
            },
          ],
        },
        {
          seriesName: '系列三',
          data: [
            {
              name: '数据一',
              value: 30,
            },
            {
              name: '数据二',
              value: 40,
            },
            {
              name: '数据三',
              value: 50,
            },
            {
              name: '数据四',
              value: 60,
            },
          ],
        },
      ],
      lineDoubleAxisColor: ['red', 'orange', 'green', 'cyan', 'blue'],
    }
  },
  computed: {
    ...mapState('company', ['popCarBaseMsg']),
  },
  mounted() {
    // setInterval(() => {
    //   console.log('lineDouble')
    //   this.lineDoubleAxisData[0].data[0].value += 1
    // }, 1000)
  },
}
</script>


<style lang="scss" scoped>
// 车辆状态 tooltip 二级弹窗
.carBaseMsgCon {
  position: absolute;
  width: 710px;
  height: 240px;
  top: 200px;
  left: 500px;
  background: green;
}

.pop_center {
  position: absolute;
  width: 900px;
  top: 200px;
  left: 500px;
}
.pop_line {
  position: absolute;
  width: 750px;
  top: 430px;
  left: 600px;
}
.pop_car {
  position: absolute;
  width: 750px;
  top: 360px;
  left: 600px;
}
.top_name {
  height: 100px;
  margin: 15px 20px 10px;
  background: url("../assets/company/company_bg.png") no-repeat;
  line-height: 104px;
  text-indent: 50px;
  font-size: 24px;
  font-weight: bold;
  color: #89dddf;
  position: relative;
  .top_btn {
    width: 29px;
    height: 20px;
    position: absolute;
    top: 44px;
    right: 10px;
    background: url("../assets/company/selecet.png") no-repeat;
    cursor: pointer;
  }
}
.left_center {
  margin: 0 20px;
  height: 250px;
}
.left_center3 {
  height: 305px;
}
.rightTop {
  margin: 15px 20px 0;
  height: 290px;
}
.rightBottom {
  margin: 10px 20px 0;
  height: 580px;
}
.map {
  width: 100%;
  height: 700px !important;
}
.center_header {
  width: 825px;
  height: 95px;
  border-bottom: 2px solid #038bfc;
  position: absolute;
  top: 15px;
  left: 102px;
  .num {
    height: 55px;
    div {
      width: 410px;
      height: 55px;
      background: rgba(3, 139, 252, 0.4);
      text-align: center;
      font-size: 14px;
      color: #ffffff;
      float: left;
      span:nth-child(1) {
        font-size: 48px;
        font-weight: bold;
        color: #efca0f;
        font-family: "digi";
        margin-right: 20px;
      }
    }
    div:nth-child(1) {
      margin-right: 5px;
    }
  }
  .name {
    margin-top: 5px;
    div {
      float: left;
      height: 35px;
      width: 410px !important;
      background: rgba(3, 139, 252, 0.2);
      font-size: 18px;
      color: #ffffff;
      line-height: 35px;
      text-align: center;
    }
    div:nth-child(1) {
      margin-right: 5px;
    }
  }
}
.center_left_icon {
  width: 70px;
  height: 60px;
  background: url("../assets/company/company_infor_off.png") no-repeat;
  position: absolute;
  left: 0;
  top: 120px;
  cursor: pointer;
}
.center_left_icon:hover {
  background: url("../assets/company/company_infor_on.png") no-repeat;
}
.center_right_icon {
  width: 70px;
  height: 60px;
  background: url("../assets/company/company_alarm_off.png") no-repeat;
  position: absolute;
  right: 440px;
  top: 120px;
  cursor: pointer;
}
.center_right_icon:hover {
  background: url("../assets/company/company_alarm_on.png") no-repeat;
}
.center_left_center {
  position: absolute;
  left: 0;
  bottom: 270px;
  width: 220px;
  div {
    width: 220px;
    height: 60px;
    box-sizing: border-box;
    border: 2px solid rgba(5, 208, 235, 0.8);
    margin-top: 10px;
    cursor: pointer;
    div {
      width: 190px;
      height: 30px;
      margin: 13px auto;
      border: 0px;
      line-height: 30px;
      text-align: center;
      background: rgba(5, 208, 235, 0.3);
      color: #b5b5b5;
    }
    .hover {
      color: #ffffff;
      background: rgba(5, 208, 235, 0.6);
    }
  }
}
.center_bottom {
  width: 1420px;
  height: 250px;
  position: absolute;
  left: 0;
  bottom: 0;
  background: #082333;
  .title {
    margin-top: 10px;
    margin-left: 20px;
    font-size: 18px;
    font-weight: bold;
    color: #89dddf;
    width: 200px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    background: #005b71;
  }
  .header {
    margin-top: 10px;
    margin-left: 20px;
    padding-bottom: 10px;
    height: 20px;
    div {
      float: left;
      font-size: 16px;
      color: #89dddf;
      text-align: center;
      margin-right: 5px;
    }
  }
  ul {
    list-style: none;
    height: 135px;
    overflow-y: scroll;
    clear: both;
    margin-left: 20px;
    li {
      height: 30px;
      margin-bottom: 5px;
      div {
        float: left;
        background: rgba(3, 139, 252, 0.4);
        font-size: 14px;
        color: #ffffff;
        text-align: center;
        line-height: 30px;
        margin-right: 5px;
      }
    }
  }
  ul::-webkit-scrollbar {
    width: 0px;
  }
}
.center_bottom .header div:nth-child(1),
.center_bottom li div:nth-child(1) {
  width: 218px;
}
.center_bottom .header div:nth-child(2),
.center_bottom li div:nth-child(2) {
  width: 100px;
}
.center_bottom .header div:nth-child(3),
.center_bottom li div:nth-child(3) {
  width: 120px;
}
.center_bottom .header div:nth-child(4),
.center_bottom li div:nth-child(4) {
  width: 150px;
}
.center_bottom .header div:nth-child(5),
.center_bottom li div:nth-child(5) {
  width: 120px;
}
.center_bottom .header div:nth-child(6),
.center_bottom li div:nth-child(6) {
  width: 180px;
}
.center_bottom .header div:nth-child(7),
.center_bottom li div:nth-child(7) {
  width: 150px;
}
.center_bottom .header div:nth-child(8),
.center_bottom li div:nth-child(8) {
  width: 150px;
}
.center_bottom .header div:nth-child(9),
.center_bottom li div:nth-child(9) {
  width: 150px;
}
.arrow_up {
  width: 20px;
  height: 16px;
  background: url("../assets/company/arrow_off.png") no-repeat;
  position: absolute;
  top: 10px;
  left: 710px;
  cursor: pointer;
}
.arrow_up:hover {
  background: url("../assets/company/arrow_on.png") no-repeat;
}
.arrow_down {
  width: 20px;
  height: 16px;
  background: url("../assets/company/arrow_off.png") no-repeat;
  position: absolute;
  bottom: 10px;
  left: 710px;
  cursor: pointer;
  transform: rotate(180deg);
}
.arrow_down:hover {
  background: url("../assets/company/arrow_on.png") no-repeat;
}
.center_right_icon div {
  width: 30px;
  height: 30px;
  background: #aa0019;
  border-radius: 50%;
  float: right;
  line-height: 30px;
  text-align: center;
  font-size: 14px;
  font-weight: bold;
  color: #ffffff;
}
.test {
  width: 60%;
  height: 90%;
  overflow: hidden;
  background: red;
  margin-top: 60px;
}

$h30: 30px;
$l20: 20px;
.container {
  width: 1890px;
  height: 950px !important;
  // overflow: hidden;
  margin: 15.5px 15px 15px 15px;
  position: relative;
  // background:red;
  position: absolute;
  z-index: 99;
}

.top-border {
  width: 100%;
  height: 5px;
  overflow: hidden;
  background: url("../assets/company/content_header_bg.png");
  background-size: 100% 100%;
} // 内容部分
.content {
  width: 100%;
  height: 950px !important;
  overflow: hidden;
  position: relative;
  box-sizing: border-box;
  border-right: 2px solid #004668;
  border-bottom: 5px solid #004668; // background:green;
  // text-align: right;
  color: #fff;
} // leftCon
.leftCon {
  width: 440px;
  height: 945px;
  overflow: hidden;
  background: #0a2a42;
}

/* // left-top */

.left-top {
  width: 100%;
  height: 270px;
  overflow: hidden;
  margin-top: 8px;
}

.splitdiv {
  width: 530px;
  height: 2px;
  overflow: hidden;
  background: rgba(129, 217, 233, 0.5);
  margin-top: 10px;
  margin-left: 50px;
}

/* // left-bottom */

.left-bottom {
  width: 100%;
  height: 590px;
  overflow: hidden;
  margin-top: 8px;
}

.company-manage-title {
  width: 560px;
  height: $h30;
  overflow: hidden;
  margin-left: $l20;
  text-indent: 50px;
  line-height: 30px;
  background: url("../assets/company/left_header_strip.png");
}

/* // 企业运行状态 */

.company-status {
  width: 530px;
  height: 550px;
  overflow: hidden;
  margin: 10px 0px 0px 50px;
}

.company-status-title {
  width: 100%;
  height: 50px;
  overflow: hidden;
  background: url("../assets/company/item_bg.png");
  p {
    width: 200px;
    height: 30px;
    margin-top: 10px;
    text-indent: 20px;
    color: #89dddf;
    font: {
      size: 16px;
      weight: bold;
    }
    line-height: 30px;
    background: rgba(129, 217, 229, 0.3);
  }
}
/* // 企业运行状态参数 */

.company-indexCon {
  width: 100%;
  height: 280px;
  overflow: hidden;
  margin-top: 10px;
}
/* //线路排名 */
.company-line-rankTitle {
  @extend .company-status-title;
  margin-top: 10px;
  position: relative;
}
.company-line-rank {
  width: 100%;
  height: 125px;
  overflow: hidden;
  margin-top: 10px;
}
.company-line-rankBtn {
  width: 20px;
  height: 5px;
  overflow: hidden;
  position: absolute;
  top: 22px;
  right: 10px;
  background: url("../assets/company/icons_more.png");
  cursor: pointer;
}
/* // centerCon */
.centerCon {
  width: 1010px;
  height: 950px;
  overflow: hidden;
  position: relative;
}
/* //地图顶部滚动包裹 */
.centerCon-scrollCon {
  width: 100%;
  height: 40px;
  overflow: hidden;
  box-sizing: border-box;
  border-top: 1px solid #81d9e5;
  border-bottom: 1px solid #81d9e5;
  margin-top: 10px;
  position: absolute;
  top: 0px;
  left: 0px;
}
/* // 中间切换tabs */

.centerTabs-con {
  width: 220px;
  height: 240px;
  overflow: hidden;
  position: absolute;
  bottom: 40px;
  left: 0px;
}
.centerTabs {
  width: 100%;
  height: 60px;
  overflow: hidden;
  margin-top: 20px;
  box-sizing: border-box;
  border: 2px solid #05d0eb;
  background: rgba(0, 0, 0, 0.8);
  p {
    width: 176px;
    height: 32px;
    margin: 12px 20px 12px 20px;
    background: rgba(0, 191, 229, 0.3);
    color: #b5b5b5;
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    line-height: 30px;
  }
  p:hover {
    color: #fff;
    background: rgba(0, 191, 229, 0.6);
  }
}
/* // 小提示框 */

.center-rightMsgCon {
  width: 70px;

  height: 60px;
  position: absolute;
  top: 70px;
  right: 440px;
  background: url("../assets/company/map_notice.png") center center no-repeat;
  cursor: pointer;
  div {
    width: 30px;
    height: 30px;
    position: absolute;
    top: 8px;
    right: 8px;
    color: #fff;
    font-size: 14px;
    font-weight: bold;
    text-align: center;
    line-height: 30px;
    border-radius: 50%;
    background: #aa0019;
  }
}
/* // 右侧大框 */

.rightCon {
  width: 440px;
  height: 945px;
  overflow: hidden;
  position: absolute;
  top: 0px;
  right: 0px;
  background: rgba(10, 42, 66, 0.9);
}
/* // 车辆部分 */
.carsCon {
  width: 100%;

  height: 120px;
  overflow: hidden;
  margin-top: 20px;
}
.companyCar-content {
  width: 400px;
  height: 100%;
  overflow: hidden;
  margin-left: 20px;
  background: rgba(3, 139, 252, 0.2);
  position: relative;
}
.companyCar-imgcon {
  width: 100px;
  height: 100px;
  overflow: hidden;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  margin: 10px 0px 0px 10px;
  background: url("../assets/company/icon_car1.png") center center no-repeat;
}
.carsCon:nth-child(2) .companyCar-imgcon {
  background: url("../assets/company/icon_car2.png") center center no-repeat;
}
.companyCar-indexCon {
  width: 260px;
  height: 100%;
  overflow: hidden;
  margin-right: 10px;
  position: relative;
}
.companyCar-btn {
  width: 20px;
  height: 5px;
  overflow: hidden;
  position: absolute;
  top: 17px;
  right: 10px;
  background: url("../assets/company/icons_more.png");
  cursor: pointer;
}
/* // 右侧-驾驶行为 */
.drive-behavior {
  width: 400px;
  height: 112px;
  overflow: hidden;
  margin: 20px 0px 0px 20px;
}
.drive-rank {
  width: 100%;
  height: 205px;
  overflow: hidden;
  margin-top: 20px;
}
.drive-rank-name {
  width: 200px;
  height: 30px;
  overflow: hidden;
  background: #005b7f;
  text-indent: 20px;
  line-height: 30px;
}
.drive-rankCon {
  width: 400px;
  height: 155px;
  overflow: hidden;
  margin: 10px 0px 0px 20px;
}
.drive-split {
  width: 100%;
  height: 2px;
  overflow: hidden;
  margin-top: 14px;
  background: url("../assets/company/right_strip-01.png");
}
.change-item {
  width: 400px;
  height: 30px;
  overflow: hidden;
  margin: 14px 0px 0px 20px;
  background: #005b7f;
  text-align: center;
  line-height: 30px;
  color: #fff;
  font-size: 16px;
  font-weight: bold;
}
</style>
