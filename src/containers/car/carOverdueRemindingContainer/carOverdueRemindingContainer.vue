<template>
  <div class="carOverdueRemindingInfo"
       @click="openLIst">
    <div class="number">{{length}}</div>
  </div>
</template>
<script>
/*eslint-disable */
import { mapMutations, mapState } from "vuex";
export default {
  computed: {
    ...mapState("CarOverdueRemindingStore", ["carOverdueRemindingShow"]),
    ...mapState("CarOverdueRemindingStore", ["carOverdueRemindingData"]),
    length() {
      const length1 =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.certificate &&
        this.carOverdueRemindingData.certificate.lessOneDay &&
        this.carOverdueRemindingData.certificate.lessOneDay.length &&
        Number(this.carOverdueRemindingData.certificate.lessOneDay.length);
      const length2 =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.accessory &&
        this.carOverdueRemindingData.accessory.lessOneDay &&
        this.carOverdueRemindingData.accessory.lessOneDay.length &&
        Number(this.carOverdueRemindingData.accessory.lessOneDay.length);
      const length3 =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.car &&
        this.carOverdueRemindingData.car.lessOneDay &&
        this.carOverdueRemindingData.car.lessOneDay.length &&
        Number(this.carOverdueRemindingData.car.lessOneDay.length);
      const allLength = length1 + length2 + length3;
      return allLength;
    }
    // ...mapMutations("warningCarouselpopupContainer", [
    //   "getTermialSelectedInfo"
    // ]),
    // getLessOneMonthLists() {
    //   const lessOneMonthLists =
    //     this.carAlertLists &&
    //     this.carAlertLists.filter(item => {
    //       const difDate = new Date(item.endDate) - new Date();
    //       return difDate > 0 && difDate < 31 * 24 * 3600 * 1000;
    //     });
    //   return lessOneMonthLists;
    // }
  },
  methods: {
    ...mapMutations("CarOverdueRemindingStore", ["setcarOverdueRemindingShow"]),
    openLIst() {
      this.setcarOverdueRemindingShow(true);
    }
    // ...mapMutations("warningCarouselpopupContainer", ["warningDetails"]),
    // getCarouselDetails(params) {
    //   // console.log('title:', params)
    //   this.warningDetails(params);
    // }
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
.carOverdueRemindingInfo {
  @include size(70px, 60px);
  background: url("../../../assets/car/guoqi.png") no-repeat 0 0;
  background-size: 70px 60px;
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
    background: #474747;
    position: absolute;
    top: 12%;
    right: 8%;
    cursor: pointer;
  }
}
.carOverdueRemindingInfo:hover {
  background: url("../../../assets/car/guoqi_2.png") no-repeat 0 0;
  background-size: 70px 60px;
}
</style>
