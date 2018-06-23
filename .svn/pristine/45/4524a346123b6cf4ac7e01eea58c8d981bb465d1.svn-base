<template>
  <!-- 内容 -->
  <div class="carHomeLayoutFrame-content clearfix">
    <!-- 左侧：配置等信息 -->
    <div class="left-content-configuration">
      <!-- 终端配置信息 -->
      <div class="terminal-configuration">
        <slot name="terminalConfiuration"></slot>
      </div>
      <!-- 轮胎配置 -->
      <div class="tyre-configuration">
        <slot name="tyreConfiuration"></slot>
      </div>
      <!-- 货车,挂车等信息 -->
      <div class="car-vehicle-type">
        <slot name="carVehicleType"></slot>
      </div>
      <!-- 防护及警告装备配置信息 -->
      <div class="protection-warning-configuration">
        <slot name="protectionWarningConfiguration"></slot>
      </div>
    </div>
    <!-- 右侧：车辆走马灯信息提示, 搜索，地图，行驶里程等信息 -->
    <div class="right-misc-info">
      <!-- 跑马灯 -->
      <div class="marquee">
        <slot name="centerTopMarquee"></slot>
      </div>
      <!-- 车辆搜索等内容 -->
      <div class="search-misc-info">
        <!-- 车辆型号搜索 -->
        <div class="car-models-search">
          <slot name="carModelsSearch"></slot>
        </div>
        <!-- 本车辆基本信息 -->
        <div class="car-base-info">
          <slot name="carBaseInfo"></slot>
        </div>
        <!-- 本车辆过期提醒 -->
        <div class="overdue-reminding">
          <slot name="overdueRemindingInfo"></slot>
        </div>
        <!-- 本车辆警告统计信息 -->
        <div class="car-alert-info">
          <slot name="carAlertInfo"></slot>
        </div>
        <!-- 本车辆模型展示状况 -->
        <div class="car-health-status">
          <div class="carModelShow">
            <slot name="carModelShow"></slot>
          </div>
        </div>
        <!-- 车辆位置实时地图 -->
        <div class="car_realtime_map"
             v-if="showRealtimeMap">
          <slot name="carRealtimeMap"></slot>
        </div>
      </div>
      <!-- 保养, 维修等信息 -->
      <div class="car-maintenance-Repair">
        <slot name="carMaintenanceRepaire"></slot>
      </div>
      <!-- 累计各项费用占比, 年度费用趋势等 -->
      <div class="car-list-costs">
        <slot name="carListCosts"></slot>
      </div>
      <!-- 车辆里程, 运量，吨公里数,运单数 -->
      <div class="mileage-misc-info">
        <slot name="mileagemiscinfoWrap"></slot>
      </div>
    </div>
    <!--本车辆过期提醒弹出框  -->
    <div class="overdue-reminding-popup clearfix"
         v-if="carOverdueRemindingShow"
         v-drag>
      <slot name="overdueRemindingPopup"></slot>
    </div>
    <!--本车辆预警提醒弹出框  -->
    <div class="car-alert-info-popup clearfix"
         v-if="carAlertPopUpShow"
         v-drag>
      <slot name="carAlertInfoPopup"></slot>
    </div>

    <!-- 费用统计信息弹出框 -->
    <div class="cost-statistic-popup clearfix">
      <slot name="costStatisticPopup"></slot>
    </div>

    <!-- 警告信息弹出框 -->
    <div class="warning-carousel-popup clearfix">
      <slot name="warningCarouselPopup"></slot>
    </div>
  </div>
</template>

<script>
/*eslint-disable */
import { mapState } from "vuex";
import DropDownFrame from "@/components/DropDownFrame";

export default {
  name: "car-home-layout-frame",
  components: {
    DropDownFrame
  },
  // data() {
  //   return {
  //     carOverdueRemindingShow: false
  //   };
  // },
  computed: {
    ...mapState("caralertinfo", ["carAlertPopUpShow"]),
    ...mapState("CarOverdueRemindingStore", ["carOverdueRemindingShow"]),
    ...mapState("CarRealtimeMap", ["showRealtimeMap"])
  }
};
</script>

<style lang="scss" scoped>
/*清除浮动*/
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

.carHomeLayoutFrame-content {
  @include size(1920px, 950px);
  /*左侧：配置信息*/
  .left-content-configuration {
    @include size(400px, 950px);
    // border-top: 2px solid #05d0eb;
    border-left: 2px solid #004668;
    box-sizing: border-box;
    padding: 20px 15px 0;
    margin-left: 15px;
    float: left;
    // margin-left: 15px;
    background: rgba(3, 139, 252, 0.2);
    box-sizing: border-box;
    // 终端配置信息
    .terminal-configuration {
      @include size(100%, 188px);
    }
    .tyre-configuration {
      @include size(100%, 258px);
      // margin-top: 10px;
    }
    .car-vehicle-type {
      @include size(100%, 210px);
      margin-top: 10px;
    }
    .protection-warning-configuration {
      @include size(100%, 249px);
      margin-top: 15px;
    }
  }
  /*右侧：车辆走马灯信息提示, 搜索，地图，行驶里程等信息*/
  .right-misc-info {
    @include size(1490px, 950px);
    position: relative;
    float: left;
    // background:red;
    // 跑马灯
    .marquee {
      @include size(1090px, 40px);
      margin-top: 2px;
      float: left;
      overflow: hidden;
      z-index: 9;
    }
    // 车型搜索等信息
    .search-misc-info {
      @include size(1072px, 600px);
      position: relative;
      // float: left;
      //  搜索车型及车辆图片展示等
      // background: pink;
      .car-models-search {
        @include size(500px, 40px);
        position: absolute;
        top: 70px;
        right: 150px;
        z-index: 9;
      }
      //  车辆基本信息
      .car-base-info {
        // @include size(440px);
        width: 440px;
        position: absolute;
        top: 70px;
        left: 0;
        z-index: 10;
      }
      //本车辆过期提醒
      .overdue-reminding {
        @include size(70px, 60px);
        position: absolute;
        top: 70px;
        right: 0;
        z-index: 10;
      }
      // 本车辆警告统计信息
      .car-alert-info {
        @include size(70px, 60px);
        position: absolute;
        top: 140px;
        right: 0;
        z-index: 10;
      }
      // 本车辆证件信息: 点击滚动
      .car-certificate-info {
        @include size(320px, 140px);
        position: absolute;
        top: 90px;
        right: 42px;
        z-index: 10;
      }
      // 本车辆技术健康状况
      .car-health-status {
        @include size(955px, 525px);
        position: absolute;
        top: 130px;
        right: 0;
        z-index: 8;
        .carModelShow {
          @include size(100%, 100%);
          position: absolute;
          top: 60;
          left: -48px;
          z-index: 8;
        }
      }
      //车辆实时地图
      .car_realtime_map {
        @include size(300px, 350px);
        position: absolute;
        right: -10px;
        bottom: -90px;
        z-index: 30;
      }
    }
    // 保养, 维修等信息
    .car-maintenance-Repair {
      @include size(530px, 250px);
      position: absolute;
      bottom: 0px;
      left: 10px;
      // border-right: 5px solid #0c0c0c;
      z-index: 9;
      background: #082333;
      // background: pink;
    }
    .car-list-costs {
      @include size(530px, 250px);
      position: absolute;
      bottom: 0px;
      left: 550px;
      background: #082333;
      z-index: 8;
    }
    // 车型行驶里程等信息
    .mileage-misc-info {
      @include size(400px, 950px);
      box-sizing: border-box;
      float: left;
      background: rgba(3, 139, 252, 0.2);
      position: absolute;
      right: 0px;
      top: 0px;
      // 行驶总里程
      .rightMileageTopLine {
        width: 356px;
        height: 2px;
        background: #81d9e5;
        position: absolute;
        top: 15px;
        left: 22px;
      }
      .totalMileage {
        margin-top: 25px;
        @include size(100%, 140px);
      }
      // 重车与空车行驶里程
      .heavy-empty-mileage {
        @include size(100%, 200px);
        margin-top: 10px;
        // background:red;
      }
      // 车辆运量, 吨公里数, 运单数
      .weight-perMileage-totalCount {
        @include size(100%, 482px);
        margin-top: 30px;
        //  运量
        .weight {
          @include size(100%, 140px);
          // margin-top: 20px;
        }
        // 吨公里数
        .perMileage {
          @include size(100%, 140px);
          margin-top: 30px;
        }
        //运单数
        .totalCount {
          @include size(100%, 140px);
          margin-top: 30px;
          // margin-bottom: 20px;
        }
        //装饰条
        .decorationLine {
          @include size(400px, 2px);
          background: rgba(129, 217, 229, 0.5);
          position: relative;
          div {
            @include size(10px, 2px);
            background: #81d9e5;
          }
          div:first-child {
            position: absolute;
            top: 0px;
            left: 0;
          }
          div:last-child {
            position: absolute;
            top: 0px;
            right: 0;
          }
        }

        .rightMileageBottomLine {
          width: 356px;
          height: 2px;
          background: #81d9e5;
          position: absolute;
          bottom: 15px;
          left: 22px;
        }
      }
    }
  }
  // 费用统计信息弹出框
  .cost-statistic-popup {
    width: 750px;
    position: absolute;
    top: 135px;
    left: 930px;
    z-index: 33;
  }
  // 警告信息弹出框
  .warning-carousel-popup {
    position: absolute;
    top: 290px;
    left: 870px;
    z-index: 33;
  }
  //资质信息弹出框
  .carCertificate-Infor-popup {
    position: absolute;
    top: 100px;
    left: 870px;
    z-index: 33;
  }
  //本车辆过期提醒弹出框
  .overdue-reminding-popup {
    width: 400px;
    height: 276px;
    position: absolute;
    top: 290px;
    left: 870px;
    z-index: 33;
  }
  //本车辆预警提醒弹出框
  .car-alert-info-popup {
    width: 400px;
    height: 276px;
    position: absolute;
    top: 290px;
    left: 870px;
    z-index: 33;
  }
}
</style>
