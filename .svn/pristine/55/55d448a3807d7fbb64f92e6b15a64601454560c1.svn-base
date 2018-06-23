<template>
  <div class="carOverdueRemindingPopupWrap"
       v-if="carOverdueRemindingShow">
    <div class="close"
         @click="close"></div>
    <div class="content clearfix">
      <div class="contentTit clearfix">过期提醒</div>
      <div class="tabToggle clearfix">
        <div class="tab1 "
             @click="toggleTab(1)"
             :class="{activeTab:nowIndex===1}">证件</div>
        <div class="tab2"
             @click="toggleTab(2)"
             :class="{activeTab:nowIndex===2}">辅件</div>
        <!-- <div class="tab3"
             @click="toggleTab(3)"
             :class="{activeTab:nowIndex===3}">车辆</div> -->
      </div>
      <div class="contentSmallTit  clearfix">
        <div class="contentSmallTitLeft ">证书名称</div>
        <div class="contentSmallTitRight">状态</div>
      </div>
      <ul v-if="nowIndex===1 &&alertList1">
        <li v-for="(item,index) in  alertList1"
            :key="index"
            class="  clearfix">
          <div class="liLift">{{item.name}}</div>
          <div class="liRight">{{item.value}}</div>
        </li>
      </ul>
      <ul v-else-if="nowIndex===2 &&alertList2">
        <li v-for="(item,index) in  alertList2"
            :key="index">
          <div class="liLift">{{item.name}}</div>
          <div class="liRight">{{item.value}}</div>
        </li>
      </ul>
      <!-- <ul v-else-if="nowIndex===3 &&alertList3">
        <li v-for="(item,index) in  alertList3"
            :key="index">
          <div class="liLift">{{item.name}}</div>
          <div class="liRight">{{item.value}}</div>
        </li>
      </ul> -->

    </div>
  </div>
</template>
<script>
/* eslint-disable */
import { mapMutations, mapState } from "vuex";
export default {
  name: "car-overdue-reminding-info",
  //   props: ['carAlertLists'],
  data() {
    return {
      nowIndex: 1,
      move: false
      // alertList1: [
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "起源地准入证", value: "已过期" },
      //   { name: "安全证书", value: "已过期" },
      //   { name: "驾驶证", value: "已过期" },
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "起源地准入证", value: "已过期" },
      //   { name: "安全证书", value: "已过期" }
      // ],
      // alertList2: [
      //   { name: "安全证书", value: "已过期" },
      //   { name: "驾驶证", value: "已过期" },
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "起源地准入证", value: "已过期" },
      //   { name: "安全证书", value: "已过期" },
      //   { name: "起源地准入证", value: "已过期" }
      // ],
      // alertList3: [
      //   { name: "起源地准入证", value: "已过期" },
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "起源地准入证", value: "已过期" },
      //   { name: "安全证书", value: "已过期" },
      //   { name: "行驶证书", value: "已过期" },
      //   { name: "道路运输证", value: "已过期" },
      //   { name: "安全证书", value: "已过期" },
      //   { name: "驾驶证", value: "已过期" }
      // ]
    };
  },
  computed: {
    ...mapState("CarOverdueRemindingStore", ["carOverdueRemindingShow"]),
    ...mapState("CarOverdueRemindingStore", ["carOverdueRemindingData"]),
    alertList1() {
      const data =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.certificate &&
        this.carOverdueRemindingData.certificate.lessOneDay &&
        this.carOverdueRemindingData.certificate.lessOneDay.map(o => {
          return {
            name: o.certificate_type,
            value: "已过期"
          };
        });
      return data;
    },
    alertList2() {
      const data =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.accessory &&
        this.carOverdueRemindingData.accessory.lessOneDay &&
        this.carOverdueRemindingData.accessory.lessOneDay.map(o => {
          return {
            name: o.certificate_type,
            value: "已过期"
          };
        });
      return data;
    },
    alertList3() {
      const data =
        this.carOverdueRemindingData &&
        this.carOverdueRemindingData !== null &&
        this.carOverdueRemindingData !== undefined &&
        this.carOverdueRemindingData.car &&
        this.carOverdueRemindingData.car.lessOneDay &&
        this.carOverdueRemindingData.car.lessOneDay.map(o => {
          return {
            name: o.certificate_type,
            value: "已过期"
          };
        });
      return data;
    }
    // ...mapMutations('warningCarouselpopupContainer', [
    //   'getTermialSelectedInfo',
    // ]),
    // getLessOneMonthLists() {
    //   // console.log('--------------2-------')
    //   // console.log('carAlertLists', this.carAlertLists)
    //   const lessOneMonthLists = this.carAlertLists && this.carAlertLists.filter((item) => {
    //     const difDate = new Date(item.endDate) - new Date()
    //     // console.log('difDate', difDate)
    //     return difDate > 0 && difDate < 31 * 24 * 3600 * 1000
    //   })
    //   // console.log('lessOneMonthLists', lessOneMonthLists)
    //   return lessOneMonthLists
    // },
  },
  methods: {
    ...mapMutations("CarOverdueRemindingStore", ["setcarOverdueRemindingShow"]),
    close() {
      this.setcarOverdueRemindingShow(false);
    },
    toggleTab(i) {
      this.nowIndex = i;
    }

    // ...mapMutations('warningCarouselpopupContainer', ['warningDetails']),
    // getCarouselDetails(params) {
    //   // console.log('title:', params)
    //   this.warningDetails(params)
    // },
  }
};
</script>
<style lang="scss">
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

.carOverdueRemindingPopupWrap {
  @include size(400px, 276px);
  background: rgba(9, 10, 11, 0.9);
  border: 4px solid rgba(5, 208, 235, 0.8);
  padding: 10px;
  box-sizing: border-box;
  //   position: absolute;
  //   top: 100px;
  //   left: -500px;
  .close {
    @include size(36px, 36px);
    line-height: 28px;
    text-align: center;
    color: rgba(5, 208, 235, 0.5);
    font-size: 36px;
    //   border: 2px solid rgba(5, 208, 235, 0.8);
    background: rgba(9, 10, 11, 0.9) url("../../assets/car/guanbi.png")
      no-repeat 0 0;
    background-size: 36px 36px;
    box-sizing: border-box;
    position: absolute;
    top: -22px;
    right: -22px;
    cursor: pointer;
  }
  .content {
    @include size(372px, 248px);
    background: rgba(9, 122, 206, 0.2);
    .contentTit {
      @include size(310px, 24px);
      background: rgba(129, 217, 229, 0.3);
      padding-left: 22px;
      box-sizing: border-box;
      color: #89dddf;
      font-size: 16px;
      line-height: 24px;
      margin-top: 10px;
      margin-left: 6px;
    }
    .tabToggle {
      @include size(360px, 30px);
      margin-top: 10px;
      margin-left: 6px;
      .tab1 {
        @include size(180px, 30px);
        float: left;
        background: rgba(5, 208, 235, 0.2);
        color: #ffffff;
        font-size: 16px;
        text-align: center;
        line-height: 30px;
        border: 1px solid rgba(5, 208, 235, 0.5);
        box-sizing: border-box;
        cursor: pointer;
      }
      .tab2 {
        @include size(180px, 30px);
        float: left;
        background: rgba(5, 208, 235, 0.2);
        color: #ffffff;
        font-size: 16px;
        text-align: center;
        line-height: 30px;
        border: 1px solid rgba(5, 208, 235, 0.5);
        box-sizing: border-box;
        cursor: pointer;
      }
      .tab3 {
        @include size(120px, 30px);
        float: left;
        background: rgba(5, 208, 235, 0.2);
        color: #ffffff;
        font-size: 16px;
        text-align: center;
        line-height: 30px;
        border: 1px solid rgba(5, 208, 235, 0.5);
        box-sizing: border-box;
        cursor: pointer;
      }
      .activeTab {
        background: rgba(5, 208, 235, 0.5);
      }
    }
    .contentSmallTit {
      @include size(360px, 30px);
      margin-top: 10px;
      margin-left: 6px;
      .contentSmallTitLeft {
        @include size(174px, 30px);
        float: left;
        color: #89dddf;
        text-align: center;
        font-size: 14px;
        line-height: 30px;
        border: 1px solid rgba(5, 208, 235, 0.5);
        box-sizing: border-box;
      }
      .contentSmallTitRight {
        @include size(174px, 30px);
        float: left;
        color: #89dddf;
        text-align: center;
        font-size: 14px;
        line-height: 30px;
        margin-left: 9px;
        border: 1px solid rgba(5, 208, 235, 0.5);
        box-sizing: border-box;
      }
    }
    ul {
      @include size(100%, 130px);
      list-style: none;
      margin: 0;
      padding: 0;
      position: relative;
      top: 0px;
      left: 0;
      overflow: hidden;
      overflow-y: scroll;
      box-sizing: border-box;
      margin-top: 10px;
      li {
        list-style: none;
        margin: 0;
        padding: 0;
        @include size(100%, 27px);
        line-height: 20px;
        font-size: 14px;
        margin-left: 6px;
        margin-top: 5px;
        background: url("../../assets/car/hengxian.png") no-repeat 0px 25px;
        cursor: pointer;
        .liLift {
          @include size(48%, 20px);
          float: left;
          background: rgba(5, 208, 235, 0.2);
          color: #89dddf;
          text-align: center;
          font-size: 14px;
          line-height: 20px;
        }
        .liRight {
          @include size(48%, 20px);
          float: left;
          background: rgba(81, 81, 81, 0.5);
          color: #89dddf;
          text-align: center;
          font-size: 14px;
          line-height: 20px;
          margin-left: 6px;
        }
      }
    }
    ul::-webkit-scrollbar {
      width: 3px;
      background: #69a3b1;
    }
    ul::-webkit-scrollbar-thumb {
      background: #05f0eb;
    }
  }
}
</style>
