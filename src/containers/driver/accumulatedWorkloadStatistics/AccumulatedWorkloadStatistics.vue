<template>
  <div class="accumulatedWorkloadStatistics">
    <div class="titileWrap">
      <div class="title">当年累计工作量统计</div>
      <div class="subTilte" @click="open('workCountInfo')">工作量统计信息</div>
    </div>
    <div class="mileageWrap">
      <div class="leftWrap">
        <div class="leftWrapSubTitle">行驶里程</div>
        <template v-if="pm">
          <div class="leftWrapItem_01">事故发生数</div>
          <div class="leftWrapItem_02">行驶里程(公里)</div>
          <div class="leftWrapItem_03"></div>
          <div class="leftWrapItem_04">{{qf(1)}}</div>
          <div class="leftWrapItem_05">{{qf(pm.total_km)}}</div>
        </template>
        <loading :data='pm'></loading>
      </div>
      <div class="rightWrap">
        <div class="rightWrapSubTitle">行驶里程排名</div>
        <template v-if="pm">
          <div class="rightWrapItem_01">
            <div class="rightWrapItem_01_01">车队排名</div>
            <div class="rightWrapItem_01_02">{{pm.fleet_km_ranking}}</div>
          </div>
          <div class="rightWrapItem_02">
            <div class="rightWrapItem_01_01">总公司排名</div>
            <div class="rightWrapItem_01_02">{{pm.company_km_ranking}}</div>
          </div>
        </template>
        <loading :data='pm'></loading>
      </div>
    </div>
    <div class="goodsQuantity">
      <div class="leftWrap">
        <div class="leftWrapSubTitle">货物量</div>
        <template v-if="pm">
          <div class="leftWrapItem_01 goodsQuantityUnit">货物量(吨)</div>
          <!-- <div class="leftWrapItem_02">货物量(立方米)</div> -->
          <div class="leftWrapItem_03"></div>
          <div class="leftWrapItem_04 goodsQuantityNo">{{qf(pm.volume_ton)}}</div>
          <!-- <div class="leftWrapItem_05">{{qf(pm.volume_m3)}}</div> -->
        </template>
        <loading :data='pm'></loading>
      </div>
      <div class="rightWrap">
        <div class="rightWrapSubTitle">货物量排名</div>
        <template v-if="pm">
          <div class="rightWrapItem_01">
            <div class="rightWrapItem_01_01">车队排名</div>
            <div class="rightWrapItem_01_02">{{pm.fleet_volume_ranking}}</div>
          </div>
          <div class="rightWrapItem_02">
            <div class="rightWrapItem_01_01">总公司排名</div>
            <div class="rightWrapItem_01_02">{{pm.company_volume_ranking}}</div>
          </div>
        </template>
        <loading :data='pm'></loading>
      </div>
    </div>
    <div class="waybillNumbner">
      <div class="leftWrap">
        <div class="leftWrapSubTitle">运单数</div>
        <template v-if="pm">
          <div class="leftWrapItem_01 waybillUnit">运单数(单)</div>
          <div class="leftWrapItem_03"></div>
          <div class="leftWrapItem_04 waybillNo">{{qf(pm.waybill_quantity)}}</div>
        </template>
        <loading :data='pm'></loading>
      </div>
      <div class="rightWrap">
        <div class="rightWrapSubTitle">运单数排名</div>
        <template v-if="pm">
          <div class="rightWrapItem_01">
            <div class="rightWrapItem_01_01">车队排名</div>
            <div class="rightWrapItem_01_02">{{pm.fleet_waybill_ranking}}</div>
          </div>
          <div class="rightWrapItem_02">
            <div class="rightWrapItem_01_01">总公司排名</div>
            <div class="rightWrapItem_01_02">{{pm.company_waybill_ranking}}</div>
          </div>
        </template>
        <loading :data='pm'></loading>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  components: {},
  computed: {
    ...mapState('accumulatedWorkloadStatistics', ['pm']),
    ...mapState('driver', ['workCountInfo']),
  },
  methods: {
    ...mapMutations('driver', ['open']),
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.accumulatedWorkloadStatistics {
  @include size(485px,450px);
  .titileWrap {
    @include size(100%,30px);
    .title {
      @include size(200px,30px);
      line-height: 30px;
      background: #005b7f;
      padding-left: 20px;
      color: #89dddf;
      font-size: 18px;
      font-weight: bold;
      box-sizing: border-box;
      float: left;
    }
    .subTilte {
      @include size(160px,25px);
      line-height: 25px;
      margin-top: 5px;
      float: right;
      padding-left: 20px;
      color: #b5b5b5;
      font-size: 14px;
      background: rgba(0, 191, 229, 0.2);
      box-sizing: border-box;
      cursor:pointer;
    }
  }
  .mileageWrap {
    @include size(100%,130px);
    margin-top: 10px;
    .leftWrap {
      @include size(231px,130px);
      float: left;
      .leftWrapSubTitle {
        @include size(150px,25px);
        line-height: 24px;
        color: #89dddf;
        font-size: 16px;
        padding-left: 20px;
        background: rgba(129, 217, 229, 0.3);
        box-sizing: border-box;
        float: left;
      }
      .leftWrapItem_01 {
        @include size(110px,25px);
        line-height: 25px;
        text-align: center;
        color: #89dddf;
        font-size: 16px;
        float: left;
        margin-top: 10px;
        background: rgba(231, 80, 41, 0.5);
      }
      .leftWrapItem_02 {
        @include size(119px,25px);
        line-height: 25px;
        text-align: center;
        color: #89dddf;
        font-size: 16px;
        float: left;
        margin-top: 10px;
        margin-left: 2px;
        background: #004669;
      }
      .leftWrapItem_03 {
        @include size(100%,2px);
        margin: 9px 0;
        background: #81d9e5;
        float: left;
      }
      .leftWrapItem_04 {
        @include size(113px,50px);
        line-height: 50px;
        text-align: center;
        font-family: "digi";
        color: #e75029;
        font-size: 36px;
        font-weight: bold;
        border: 2px solid #81d9e5;
        box-sizing: border-box;
        float: left;
      }
      .leftWrapItem_05 {
        @extend .leftWrapItem_04;
        margin-left: 2px;
        color: #89dddf;
      }
    }
    .rightWrap {
      @include size(231px,130px);
      float: left;
      margin-left: 20px;
      .rightWrapSubTitle {
        @include size(150px,25px);
        line-height: 24px;
        color: #89dddf;
        font-size: 16px;
        padding-left: 20px;
        background: rgba(129, 217, 229, 0.3);
        box-sizing: border-box;
        float: left;
      }
      .rightWrapItem_01 {
        @include size(113px,95px);
        margin-top: 10px;
        float: left;
        .rightWrapItem_01_01 {
          @include size(113px,55px);
          text-align: center;
          color: #89dddf;
          font-size: 16px;
          background: url(../../../assets/driver/rank_1.png) no-repeat center
            24px;
        }
        .rightWrapItem_01_02 {
          @include size(113px,40px);
          text-align: center;
          font-family: "digi";
          font-size: 36px;
          color: #efca0f;
          border: 1px solid #81d9e5;
          box-sizing: border-box;
        }
      }
      .rightWrapItem_02 {
        @extend .rightWrapItem_01;
        float: left;
        margin-left: 2px;
        margin-top: 10px;
      }
    }
  }
  .goodsQuantity {
    @extend .mileageWrap;
    margin-top: 10px;
    .leftWrap {
      .goodsQuantityUnit {
        width:100%;
        background: #004668;
      }
      .goodsQuantityNo {
        width:100%;
        color: #89dddf;
      }
    }
  }
  .waybillNumbner {
    @extend .mileageWrap;
    margin-top: 10px;
    .leftWrap {
      .waybillUnit {
        width: 100%;
        background: #004668;
      }
      .waybillNo {
        width: 100%;
        color: #89dddf;
      }
    }
  }
}
</style>