<template>
  <div class="car">
    <div class="car_title_top"></div>
    <div class="carNumState_Title">
      <TitleView title="车辆数量统计"></TitleView>
      <div class="carNumTotle">
        <div>总车辆数：
          <span>10</span>
        </div>
      </div>
    </div>
    <div class="carNumState_Content">
      <div class="listTitle">
        <key-value-select width="170px"
                          height='30px'
                          style="lineheight:30px"
                          :data="SeverThemeData"
                          @select='selectSever'></key-value-select>
        <div>车辆数</div>
      </div>
      <ul>
        <li v-for='(item,index) in listdata'
            :key='index'>
          <div>{{item.name}}</div>
          <div>{{item.value}}</div>
        </li>
      </ul>
    </div>
    <div class="car_title_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import KeyValueSelect from "../../components/KeyValueSelect";
import Dictionary from "../../util/dictionary";
const { date: { year, month }, SeverType } = Dictionary;
export default {
  components: {
    TitleView,
    KeyValueSelect,
    Dictionary
  },
  data: () => ({
    listTitle: ["服务商", "车辆数"],
    listdata: [
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 },
      { name: "CCCCCCCC", value: 99 }
    ],
    SeverThemeData: SeverType,
    sever: null
  }),
  methods: {
    selectSever(item) {
      this.sever = item.value;
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.car {
  @include size(100%, 100%);
  padding: 11px 5px 0 5px;
  box-sizing:border-box;
  position: relative;
  .car_title_top {
    width: calc(100% - 46px);
    height: 2px;
    position: absolute;
    top: 2px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
  .car_title_bottom {
    width: calc(100% - 48px);
    height: 2px;
    position: absolute;
    bottom: 2px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
  .carNumState_Title {
    @include size(360px, 30px);
    position: absolute;
    .carNumTotle {
      @include size(142px, 20px);
      position: absolute;
      right: 8px;
      top: 5px;
      background: rgba(3, 139, 252, 0.4);
      font-size: 14px;
      color: #89dddf;
      text-align: center;
      line-height: 20px;
      span {
        color: #05d0eb;
        font-size: 16px;
      }
    }
  }
  .carNumState_Content {
    @include size(342px, 200px);
    position: absolute;
    // left: 22px;
    // top: 48px;
    left: 20px;
    bottom: 0px;
    .listTitle {
      @include size(100%, 30px);
      clear: both;
      margin-top: 10px;
      margin-bottom: 8px;
      float: left;
      div {
        @include size(100%, 30px);
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
        @include size(170px, 100%);
        margin-left: 0px;
      }
      div:nth-child(2) {
        @include size(158px, 100%);
      }
    }
    ul {
      @include size(98%, 145px);
      list-style: none;
      overflow-y: scroll;
      color: #b5b5b5;
      float: left;
      li {
        margin-bottom: 5px;
        height: 25px;
        cursor: pointer;
        div {
          float: left;
          height: 25px;
          box-sizing: border-box;
          line-height: 23px;
          text-align: center;
          border: 1px solid rgba(0, 191, 229, 1);
          background: rgba(0, 191, 229, 0.2);
          width: 89px;
          margin-left: 12px;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
        }
        div:nth-child(1) {
          @include size(170px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(143px, 100%);
        }
        &:hover div {
          background: rgba(0, 191, 229, 0.5);
          color: #ffffff;
        }
      }
    }
    ul::-webkit-scrollbar {
      background: #69a3b1;
      width: 6px;
    }
    ul::-webkit-scrollbar-thumb {
      background: #05d0eb;
    }
  }
}
</style>