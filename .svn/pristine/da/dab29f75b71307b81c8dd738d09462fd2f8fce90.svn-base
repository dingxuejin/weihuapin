<template>
  <div class="online">
    <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="text1">上线率统计</div>
      <div class="text2">上线率详情信息</div>
    </div>
    <div class="onlineRateStatistics">
      <!-- <div class="onlineRateStatistics_title"></div> -->
      <div class="onlineRateStatistics_content">
        <!-- 数据传输量统计 -->
        <div class="barchart">
          <div class="itemCon fr clearfix">
            <div class="fl">统计周期</div>
            <div class="fl">
              <key-value-select width="117px"
                                :data="yearOption"
                                @select='selectYear'></key-value-select>
            </div>
            <div class="fl">
              <key-value-select width="108px"
                                :data="monthOption"
                                @select="selectMonth"></key-value-select>
            </div>
          </div>
          <div class="OnlinechartCon"
               v-if="barhorData">
            <!-- <barhor chartTheme="dark" :data="barhorData"></barhor> -->
          </div>
        </div>
      </div>
    </div>
    <div class="onlineRateDetails">
      <!-- <div class="onlineRateDetails_title">
        上线率详情信息
      </div> -->
      <div class="onlineRateDetails_content">
        <div class="listTitle">
          <key-value-select width="252px"
                            height='30px'
                            :data="SeverThemeData"
                            @select='selectSever'></key-value-select>
          <div>车机上线率</div>
          <div>ADAS上线率</div>
          <div>分值</div>
        </div>
        <ul>
          <li v-for='(item,index) in listdata'
              :key='index'>
            <div>{{item.name}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value2}}</div>
            <div>{{item.value3}}</div>
          </li>
        </ul>
      </div>
    </div>
    <div class="online_bottom"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import barhor from "../../components/charts/barhor";
import KeyValueSelect from "../../components/KeyValueSelect";
import Dictionary from "../../util/dictionary";
const { date: { year, month }, SeverType } = Dictionary;
export default {
  components: {
    TitleView,
    KeyValueSelect,
    Dictionary,
    barhor
  },
  data: () => ({
    listTitle: ["服务商", "车机上线率", "ADAS上线率", "分值"],
    listdata: [
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 },
      { name: "CCCCCCCC", value1: 99, value2: 55, value3: 22 }
    ],
    SeverThemeData: SeverType,
    sever: null,
    yearOption: year,
    monthOption: [{ label: "全年", value: null }, ...month],
    year: 2017,
    month: "01",
    barhorData: [
      {
        data: [
          {
            name: "ADA总上线率",
            value: 80
            //   value: '80%',
          },
          {
            name: "手机总上线率",
            value: 74
            //   value: '74%',
          }
        ]
      }
    ]
  }),
  methods: {
    selectSever(item) {
      this.sever = item.value;
    },
    selectYear(item) {
      this.year = item.value;
    },
    selectMonth(item) {
      this.month = item.value;
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.online {
  // padding: 5px;
  position: relative;
  width: 1140px;
  height: 240px;
  box-sizing: border-box;
  .title {
    width: 1128px;
    // margin-left: 20px;
    // margin-top: 3px;
    margin-left: 10px;
    height: 30px;
    background: rgba(3, 139, 252, 0.4);
    line-height: 30px;
    box-sizing: border-box;
    font-size: 18px;
    color: #89dddf;
    position: relative;
    overflow: hidden;
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
    .col3 {
      width: 2px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 388px;
      background: #89dddf;
    }
    .text1 {
      float: left;
      width: 388px;
      height: 30px;
      padding-left: 50px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .text2 {
      float: left;
      width: 740px;
      height: 30px;
      padding-left: 50px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
  }
  .onlineRateStatistics {
    @include size(390px, 190px);
    float: left;
   margin-left: 10px;
    &_content {
      @include size(100%, 180px);
      box-sizing: border-box;
      margin-top: 10px;
      border-right: 2px solid rgba(129, 217, 229, 0.5);
      .barchart {
        @include size(390px, 180px);
        float: left;
        // 下拉框包裹
        .itemCon {
          @include size(390px, 37px);
          color: #b5b5b5;
          font-size: 14px;
          line-height: 25px;
          box-sizing: border-box;
          padding-left: 50px;
          div {
            &:nth-child(1) {
              margin-left: 16px;
            }
          }
        }
        .OnlinechartCon {
          @include size(97%, 140px);
          float: left;
        }
      }
    }
  }
  .onlineRateDetails {
    @include size(732px, 190px);
    margin-left: 406px;
    // margin-top: -30px;
    // color: #89dddf;
    // &_title {
    //   @include size(100%, 26px);
    //   line-height: 30px;
    //   box-sizing: border-box;
    //   padding-left: 50px;
    //   font-size: 18px;
    //   color: #89dddf;
    // }
    &_content {
      @include size(100%, 186px);
      box-sizing: border-box;
      //   margin-left: 23px;
    //   margin: 0 auto;
      margin-top: 10px;
    //   margin-left: 5px;
      .listTitle {
        @include size(100%, 30px);
        // clear: both;
        margin-bottom: 10px;
        float: left;
        div {
          @include size(100%, 30px);
          float: left;
          margin-left: 8px;
          box-sizing: border-box;
          text-align: center;
          line-height: 28px;
          border: 1px solid #81d9e5;
          color: #b5b5b5;
          font-size: 16px;
        }
        div:nth-child(1) {
          @include size(252px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(175px, 100%);
        }
        div:nth-child(3) {
          @include size(177px, 100%);
        }
        div:nth-child(4) {
          @include size(87px, 100%);
        }
      }
      ul {
        @include size(96.8%, 145px);
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
            margin-left: 8px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
          }
          div:nth-child(1) {
            @include size(252px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(175px, 100%);
          }
          div:nth-child(3) {
            @include size(177px, 100%);
          }
          div:nth-child(4) {
            @include size(74px, 100%);
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
  &_bottom {
    width: calc(100% - 26px);
    height: 2px;
    position: absolute;
    bottom: 2px;
    left: 21px;
    background: rgba(129, 217, 229, 0.5);
  }
}
</style>