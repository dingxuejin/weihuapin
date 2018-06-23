<template>
  <div class="CompanySecureBox">
    <div class="container">
      <div class="pandect">
        <mainTitleMsg></mainTitleMsg>
        <securityOverview></securityOverview>
        <insitutionChange></insitutionChange>
        <securityRanking></securityRanking>
      </div>
      <div class="behavior">
        <!-- 标题 -->
        <behaviorTitle :detailesBoxShow="detailesBoxShow"></behaviorTitle>
        <div class="behavior_left" v-if="detailesBoxShow===1">
          <!-- 右边第一 -->
          <div class="danger">
            <div class="danger1">
              <driverTrend></driverTrend>
            </div>
            <div class="danger1">
              <areaDistributionDriver></areaDistributionDriver>
            </div>
            <div class="danger1">
              <alarm-event-rank-bad-steering></alarm-event-rank-bad-steering>
            </div>
          </div>
          <!-- 右边第二 -->
          <div class="danger">
            <div class="danger2">
              <irregularityTrend></irregularityTrend>
            </div>
            <div class="danger2">
              <areaDistributionIrregularity></areaDistributionIrregularity>
            </div>
            <div class="danger2">
              <alarm-event-rank-irregularities></alarm-event-rank-irregularities>
            </div>
          </div>
        </div>
        <div class="behavior_right" v-if="detailesBoxShow===2">
          <!-- 右边第三 -->
          <div class="danger">
            <div class="danger3">
              <illegalTrend></illegalTrend>
            </div>
            <div class="danger3">
              <!-- <quantityIllegal></quantityIllegal> -->
              <areaDistributionIllegal></areaDistributionIllegal>
            </div>
            <div class="danger3">
              <alarm-event-rank-illegality></alarm-event-rank-illegality>
            </div>
          </div>
          <!-- 右边第四 -->
          <div class="danger">
            <div class="danger4">
              <accidentTime></accidentTime>
            </div>
            <div class="danger4">
              <accidentArea></accidentArea>
            </div>
            <div class="danger4">
              <accidentView></accidentView>
            </div>
          </div>
        </div>
        <div class="behavior_prev"
              @click="scrollContent(-1)" v-if="detailesBoxShow===2">
          <i></i>
        </div>
        <div class="behavior_next"
              @click="scrollContent(1)" v-if="detailesBoxShow===1">
          <i></i>
        </div>
      </div>
    </div>

    <!-- 详情弹出框 -->
    <popup-sec-container></popup-sec-container>
  </div>

</template>
<script>
/* eslint-disable */
import mainTitleMsg from '../containers/companysecure/mainTitleMsg/mainTitleMsg'
import securityOverview from '../containers/companysecure/securityOverview/securityOverview'
import insitutionChange from '../containers/companysecure/insitutionChange/insitutionChange'
import securityRanking from '../containers/companysecure/securityRanking/securityRanking'
import behaviorTitle from '../containers/companysecure/behaviorTitle/behaviorTitle'
import driverTrend from '../containers/companysecure/driverTrend/driverTrend'
import irregularityTrend from '../containers/companysecure/irregularityTrend/irregularityTrend'
import illegalTrend from '../containers/companysecure/illegalTrend/illegalTrend'
// import quantityDriver from '../containers/companysecure/quantityDriver/quantityDriver'
// import quantityIrregularity from '../containers/companysecure/quantityIrregularity/quantityIrregularity'
// import quantityIllegal from '../containers/companysecure/quantityIllegal/quantityIllegal'
import areaDistributionDriver from '../containers/companysecure/areaDistributionDriver/areaDistributionDriver'
import areaDistributionIrregularity from '../containers/companysecure/areaDistributionIrregularity/areaDistributionIrregularity'
import areaDistributionIllegal from '../containers/companysecure/areaDistributionIllegal/areaDistributionIllegal'
import accidentArea from '../containers/companysecure/accidentArea/accidentArea'
import accidentTime from '../containers/companysecure/accidentTime/accidentTime'
import accidentView from '../containers/companysecure/accidentView/accidentView'
import popupSecContainer from '../containers/companysecure/popupSecContainer/PopupSecContainer'
import alarmEventRankBadSteering from '../containers/companysecure/alarmEventRankBadSteering/alarmEventRankBadSteering'
import alarmEventRankIrregularities from '../containers/companysecure/alarmEventRankIrregularities/alarmEventRankIrregularities'
import alarmEventRankIllegality from '../containers/companysecure/alarmEventRankIllegality/alarmEventRankIllegality'

export default {
  components: {
    mainTitleMsg,
    securityOverview,
    insitutionChange,
    securityRanking,
    behaviorTitle,
    driverTrend,
    irregularityTrend,
    illegalTrend,
    // quantityDriver,
    // quantityIrregularity,
    // quantityIllegal,
    areaDistributionDriver,
    areaDistributionIrregularity,
    areaDistributionIllegal,
    accidentArea,
    accidentTime,
    accidentView,
    popupSecContainer,
    alarmEventRankBadSteering,
    alarmEventRankIrregularities,
    alarmEventRankIllegality,
  },
  data() {
    return {
      detailesBoxShow:1,
    }
  },
  methods: {
    scrollContent(i) {
      this.detailesBoxShow += 1 * i
      if (this.detailesBoxShow > 2) {
        this.detailesBoxShow = 2
      }
      if (this.detailesBoxShow < 1) {
        this.detailesBoxShow = 1
      }
    },
  },
}
</script>
<style lang="scss" scoped>
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

@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.CompanySecureBox {
  position: relative;
  height:960px;
  // width: 1890px;
  width:1816px;
  // margin: 15.5px 15px 15px 15px;
  margin: 14.7px 52.4px 47.9px 51px;
  background: url("../assets/company/content_header_bg.png") 0 0 no-repeat;
  padding-top: 5px;
}
.container {
  width:1816px;
  // height: 960px;
  height: 936px;
  overflow: hidden;
  box-sizing: border-box;
  border-left: 3px solid #004668;
  border-right: 3px solid #004668;
  border-bottom: 5px solid #004668;
  .pandect {
    width: 430px;
    height:954px;
    float: left;
    margin: 0 30.3px 0 17.6px;
  }
  .behavior {
    width: 1332px;
    float: left;
    margin: 0px auto;
    &_left{
      width:100%;
      float: left;
      // margin-left:44px;
      .danger {
        &:nth-child(1) {
          width:615px;
          margin-right:54px;
          float: left;
          .danger1{
            margin-top: 10px;
            &:nth-child(1) {
              height: 265px;
            }
            &:nth-child(2) {
              height: 240px;
            }
            &:nth-child(3) {
              height: 235px;
            }
          }    
        }
        &:nth-child(2) {
          margin-left: 670px;
          width:620px;
          .danger2{
            margin-top: 10px;
            &:nth-child(1) {
              height: 265px;
            }
            &:nth-child(2) {
              height: 240px;
            }
            &:nth-child(3) {
              height: 235px;
            }
          }
        }
      }
    }
    &_right{
      width:100%;
      // margin-left:44px;
      .danger {
        &:nth-child(1) {
          width:615px;
          // margin-left:54px;
          // margin-right:54px;
          float: left;
          .danger3{
            margin-bottom: 10px;
            &:nth-child(1) {
              height: 265px;
            }
            &:nth-child(2) {
              height: 240px;
            }
            &:nth-child(3) {
              height: 235px;
            }
          }    
        }
        &:nth-child(2) {
          margin-left: 670px;
          width:620px;
          .danger4{
            margin-top: 10px;
            &:nth-child(1) {
              height: 265px;
            }
            &:nth-child(2) {
              height: 240px;
            }
            &:nth-child(3) {
              height: 235px;
            }
          }
        }
      }
    }
    &_prev {
      @include size(25px, 130px);
      line-height: 130px;
      text-align: left;
      position: absolute;
      top: 338px;
      left: 443px;
      color: #81d9e5;
      font-size: 24px;
      font-weight: bold;
      cursor: pointer;
      i {
        @include size(25px, 60px);
        position: absolute;
        top: 50%;
        left: 5px;
        background: url('../assets/companysecure/zuo.png') no-repeat center center;
        background-size: 100% 100%;
        // background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
      }
    }
    &_prev:hover i {
        background: url('../assets/companysecure/zuo.png') no-repeat center center;
        background-size: 100% 100%;
      // background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;
    }
    &_next {
      @include size(25px, 130px);
      line-height: 130px;
      text-align: right;
      position: absolute;
      top: 338px;
      right: 15px;
      color: #81d9e5;
      font-size: 30px;
      font-weight: bold;
      cursor: pointer;
      i {
        @include size(25px, 60px);
        position: absolute;
        top: 50%;
        right: -5px;
        background: url('../assets/companysecure/zuo.png') no-repeat center center;
        background-size: 100% 100%;
        // background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
        transform: rotate(180deg);
      }
    }
    &_next:hover i {
      // background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;
      background: url('../assets/companysecure/zuo.png') no-repeat center center;
      background-size: 100% 100%;
      transform: rotate(180deg);
    }
  }
}
.company_secure_Details_layout {
  width: 100%;
  height: 905px;
  position: absolute;
  top: 0;
  left: 0;
  background: #81d9e5;
}
</style>
