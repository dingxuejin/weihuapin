<template>

  <div class="qysl">
    <!-- 分割线 -->
    <div class="linetop"></div>
    <div class="title">
      企业数量统计
      <div class="col1"></div>
      <div class="col2"></div>
    </div>
    <div class="contop">
      <div class="contopLeft">
        <p>服务商总数量</p>
        <div>10</div>
      </div>
      <div class="contopRight">
        <div class="contopRightTop">
          <div class="fuwu"
               :class="{hover:show}"
               @click='change'>服务商</div>
          <div class="sheng"
               :class="{hover:!show}"
               @click='change'>省份</div>
        </div>
        <div class="select">
          <key-value-select width="210px"
                            height='25px'
                            style="lineHeight:25px"
                            :data="SeverThemeData"
                            @select='selectSever'></key-value-select>
        </div>
      </div>
    </div>
    <div class="conbot">
      <div class="conbotTop">
        <p>企业总数量</p>
        <div>11</div>
      </div>
      <div class="chart">
        <enterprisequantity></enterprisequantity>
      </div>

    </div>
    <!-- 分割线 -->
    <div class="linebot"></div>
  </div>

</template>
<script>
/* eslint-disable */
import enterprisequantity from "../../components/charts/enterprisequantitystatistics.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
import Dictionary from "../../util/dictionary";
const { date: { year, month }, SeverType } = Dictionary;

export default {
  components: {
    enterprisequantity,
    Dictionary,
    KeyValueSelect
  },
  data() {
    return {
      show: true,
      SeverThemeData:SeverType,
      sever:'服务商',
    };
  },
  methods: {
    selectSever(item) {
      this.sever = item.value;
    },
    change() {
      this.show = !this.show;
    }
  }
};
</script>
<style lang="scss" scoped>
.qysl {
  width: 400px;
  height: 240px;
  position: relative;
  .title {
    width: 370px;
    margin-left: 10px;
    margin-top: 7px;
    height: 30px;
    background: rgba(3, 139, 252, 0.4);
    line-height: 30px;
    padding-left: 50px;
    box-sizing: border-box;
    font-size: 18px;
    color: #89dddf;
    position: relative;
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
  }
  .contop {
    width: 400px;
    height: 50px;
    overflow: hidden;
    .contopLeft {
      width: 178px;
      height: 50px;
      float: left;
      p {
        margin: 0;
        margin-left: 30px;
        font-size: 14px;
        color: #89dddf;
        line-height: 28px;
      }
      div {
        width: 109px;
        height: 20px;
        background: rgba(3, 139, 252, 0.4);
        margin-left: 30px;
        text-align: center;
        line-height: 20px;
        font-size: 16px;
        color: #05d0eb;
      }
    }
    .contopRight {
      width: 217px;
      height: 50px;
      float: left;
      box-sizing: border-box;
      .contopRightTop {
        overflow: hidden;
        .fuwu {
          float: left;
          width: 140px;
          margin-top: 5px;
          text-align: center;
          line-height: 15px;
          font-size: 12px;
          color: #b5b5b5;
          height: 15px;
          background: rgba(0, 91, 127, 0.5);
          cursor: pointer;
          // font-size: 14px;
          // color: #89dddf;
          // background: #005b7f;
          // height: 20px;
        }
        .sheng {
          float: left;
          width: 70px;
          height: 15px;
          margin-top: 5px;
          margin-left: 3px;
          background: rgba(0, 91, 127, 0.5);
          text-align: center;
          line-height: 15px;
          font-size: 12px;
          color: #b5b5b5;
          cursor: pointer;
        }
        .hover {
          height: 20px;
          line-height: 20px;
          background: #005b7f;
          color: #89dddf;
          font-size: 14px;
          margin-top: 2px;
        }
      }
      .select {
        margin-top: 2px;
        width: 217px;
        height: 25px;
        div {
          // @include size(100%, 30px);
          width: 100%;
          height: 25px;
          float: left;
          margin-left: 12px;
          box-sizing: border-box;
          text-align: center;
          line-height: 28px;
          border: 1px solid #81d9e5;
          color: #b5b5b5;
          font-size: 16px;
        }
        div:nth-child(1) {
          // @include size(170px, 100%);
          width: 170px;
          height: 100%;
          margin-left: 0px;
        }
        div:nth-child(2) {
          // @include size(158px, 100%);
          width: 158px;
          height: 100%;
        }
        // .selectCon {
        //   padding-left: 30px;
        //   box-sizing: border-box;
        // }
        // select {
        //   height: 25px;
        //   width: 217px;
        //   box-sizing: border-box;
        //   outline: none;
        //   border: 1px solid #81d9e5;
        //   background: #000000;
        //   color: #b5b5b5;
        //   appearance: none;
        //   -moz-appearance: none;
        //   -webkit-appearance: none;
        //   background: url("../../assets/driver/select_arrow.png") no-repeat
        //     scroll calc(100% - 26px) center #000000;
        //   padding-left: 30px;
        // }
      }
    }
  }
  .conbot {
    width: 400px;
    height: 149px;
    position: relative;
    .conbotTop {
      // height: 43px;
      width: 110px;
      position: absolute;
      left: 30px;
      top: 6px;
      p {
        margin: 0;
        font-size: 14px;
        color: #89dddf;
        line-height: 28px;
      }
      div {
        width: 109px;
        height: 20px;
        background: rgba(3, 139, 252, 0.4);
        text-align: center;
        line-height: 20px;
        font-size: 16px;
        color: #05d0eb;
      }
    }
    .chart {
      width: 400px;
      height: 149px;
    }
  }
  .linetop {
    width: 350px;
    height: 2px;
    background: rgba(129, 217, 229, 0.5);
    margin-top: 2px;
    margin-left: 32px;
  }
  .linebot {
    width: 350px;
    height: 2px;
    background: rgba(129, 217, 229, 0.5);
    // margin-left: 32px;
    position: absolute;
    left: 32px;
    bottom: 4px;
    // margin-top: 1px;
  }
}
</style>
