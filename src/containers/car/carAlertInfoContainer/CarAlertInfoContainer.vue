<template>
  <div class="carAlertInfoPopUpWrap"
       @click="openLIst">
    <div class="number">{{length}}</div>
  </div>
</template>
<script>
/*eslint-disable */
import { mapActions, mapState, mapMutations } from "vuex";
// import CarAlertInfo from "@/components/car/CarAlertInfo";

export default {
  // components: {
  //   CarAlertInfo
  // },
  data() {
    return {};
  },
  computed: {
    ...mapState("caralertinfo", ["carAlertPopUpShow"]),
    ...mapState("caralertinfo", ["carAlertInftData"]),
    length() {
      const length1 =
        this.carAlertInftData &&
        this.carAlertInftData !== null &&
        this.carAlertInftData !== undefined &&
        this.carAlertInftData.certificate &&
        this.carAlertInftData.certificate.all &&
        this.carAlertInftData.certificate.all.length &&
        Number(this.carAlertInftData.certificate.all.length);
      const length2 =
        this.carAlertInftData &&
        this.carAlertInftData !== null &&
        this.carAlertInftData !== undefined &&
        this.carAlertInftData.accessory &&
        this.carAlertInftData.accessory.all &&
        this.carAlertInftData.accessory.all.length &&
        Number(this.carAlertInftData.accessory.all.length);
      const length3 =
        this.carAlertInftData &&
        this.carAlertInftData !== null &&
        this.carAlertInftData !== undefined &&
        this.carAlertInftData.car &&
        this.carAlertInftData.car.all &&
        this.carAlertInftData.car.all.length &&
        Number(this.carAlertInftData.car.all.length);
      const allLength = length1 + length2 + length3;
      return allLength;
    }
    //   ...mapState("caralertinfo", ["DataJgxxsl"]),
    //   //   原始数据：
    //   // 原始数据：终端信息
    //   ...mapState("terminalConfigurationContainer", ["czzdxxData"]),
    //   // 原始数据：防护及警告装备
    //   ...mapState("protectionWarningConfigurationContainer", ["czzbxxData"]),
    //   // 原始数据：车辆基础信息
    //   ...mapState("carBaseInfoContainer", ["clzzzjxxData"]),
    //   // 原始数据：保养维修检测保险信息
    //   ...mapState("carMaintenanceRepaireContainer", [
    //     "clbyxxData",
    //     "clwxxxData",
    //     "clbxjcData",
    //     "ylrqgtjcData"
    //   ]),
    //   getAlertList() {
    //     // 终端信息汇总：start
    //     const active_safety_devices =
    //       this.czzdxxData &&
    //       this.czzdxxData.active_safety_devices &&
    //       this.czzdxxData.active_safety_devices;
    //     const GPS_GNSS =
    //       this.czzdxxData && this.czzdxxData.GPS_GNSS && this.czzdxxData.GPS_GNSS;
    //     const video_terminal =
    //       this.czzdxxData &&
    //       this.czzdxxData.video_terminal &&
    //       this.czzdxxData.video_terminal;
    //     const goods_detects =
    //       this.czzdxxData &&
    //       this.czzdxxData.goods_detects &&
    //       this.czzdxxData.goods_detects.device_info &&
    //       this.czzdxxData.goods_detects.device_info;
    //     const car_status_detects =
    //       this.czzdxxData &&
    //       this.czzdxxData.car_status_detects &&
    //       this.czzdxxData.car_status_detects;

    //     const tire_detects =
    //       this.czzdxxData &&
    //       this.czzdxxData.tire_detects &&
    //       this.czzdxxData.tire_detects.device_info &&
    //       this.czzdxxData.tire_detects.device_info;

    //     const terminalAlertListsArr = [
    //       active_safety_devices,
    //       GPS_GNSS,
    //       video_terminal,
    //       goods_detects,
    //       car_status_detects,
    //       tire_detects
    //     ];

    //     const terminalAlertLists =
    //       terminalAlertListsArr &&
    //       terminalAlertListsArr !== undefined &&
    //       terminalAlertListsArr !== null &&
    //       terminalAlertListsArr.map(item => {
    //         const endDate = item && item.warranty_period && item.warranty_period;
    //         const title = item && item.terminal_type && item.terminal_type;
    //         return {
    //           title,
    //           endDate,
    //           type: "terminal"
    //         };
    //       });

    //     // 终端信息汇总：end

    //     // 防护及警告装备: start
    //     const pwcAlertLists = !this.czzbxxData
    //       ? {}
    //       : this.czzbxxData.map(item => {
    //           const date = this.formatDate(item.purchase_date);
    //           const year = String(
    //             Number(date.slice(0, 4)) + Number(item.valid_period)
    //           );
    //           const month = date.slice(5, 7);
    //           const day = date.slice(8, 10);
    //           const endDate = `${year}-${month}-${day}`;
    //           const title = item.fhzzlx.protective_equipment_type;
    //           return {
    //             title,
    //             endDate,
    //             type: "pwc"
    //           };
    //         });
    //     // 防护及警告装备: end

    //     // 车辆基础信息:start
    //     const certificateAlertLists = !this.clzzzjxxData
    //       ? {}
    //       : this.clzzzjxxData.map(item => {
    //           const endDate = this.formatDate(item.expire_date);
    //           const title = item.clzj.vehicle_certificate_type;
    //           return {
    //             title,
    //             endDate,
    //             type: "baseInfo"
    //           };
    //         });
    //     // 车辆基础信息:end

    //     // 保养维修检测保险信息: 保养
    //     const maintenanceAlertLists = {
    //       title: "下次保养时间",
    //       endDate: !this.clbyxxData ? "" : this.clbyxxData.next_maintain_date,
    //       type: "maintenance"
    //     };
    //     // 保养维修检测保险信息: 维修-----
    //     const repaireAlertLists = {
    //       title: "下次维修时间",
    //       endDate: !this.clwxxxData ? "" : this.clwxxxData.next_maintain_date,
    //       type: "repaire"
    //     };

    //     // 保养维修检测保险信息: 检测-----
    //     const detectionAlertLists = {
    //       title: "下次检测时间",
    //       endDate: !this.ylrqgtjcData ? "" : this.ylrqgtjcData.next_test_date,
    //       type: "detection"
    //     };

    //     // 保养维修检测保险信息: 保险
    //     const insuranceAlertLists = {
    //       title: "保单到期时间",
    //       endDate: !this.clbxjcData ? "" : this.clbxjcData.insurance_end_date,
    //       type: "insurance"
    //     };

    //     // 汇总list
    //     const alertLists = [
    //       ...terminalAlertLists,
    //       ...pwcAlertLists,
    //       ...certificateAlertLists,
    //       maintenanceAlertLists,
    //       repaireAlertLists,
    //       detectionAlertLists,
    //       insuranceAlertLists
    //     ];
    //     return alertLists;
    //   }
  },
  methods: {
    // ...mapActions("caralertinfo", ["getJgxxsl"]),
    ...mapMutations("caralertinfo", ["setcarAlertPopUpShow"]),
    openLIst() {
      this.setcarAlertPopUpShow(true);
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
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
.carAlertInfoPopUpWrap {
  @include size(70px, 60px);
  background: url(/static/img/css_sprite_car-01.8788e60.png) no-repeat -760px -128px;
  position: relative;
  color: #fff;
  z-index: 14;
  cursor: pointer;
  .number {
    @include size(30px, 30px);
    line-height: 30px;
    text-align: center;
    color: #fff;
    font-size: 14px;
    font-weight: bold;
    border-radius: 50%;
    background: red;
    position: absolute;
    top: 12%;
    right: 8%;
    cursor: pointer;
  }
}
.carAlertInfoPopUpWrap:hover {
  background: url(~assets/car/css_sprite_car-01.png) no-repeat -880px -128px;
}
</style>