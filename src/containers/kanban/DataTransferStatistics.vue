<template>
  <div class="shujutongji">

    <!-- 分割线 -->
    <div class="linetop"></div>
    <!-- <TitleView title="数据传输统计" class="title"></TitleView> -->
    <div class="title">
      <div class="col1"></div>
      <div class="col2"></div>
      <div class="col3"></div>
      <div class="col4"></div>
      <div class="text1">数据传输量统计</div>
      <div class="text2">实时数据展示</div>
      <div class="text3">数据传输变化趋势</div>
    </div>
    <!-- 数据传输量统计 -->
    <div class="barchart">
      <div class="selectCon clearfix">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <dxj-select width="117px"
                        :data="yearOption"
                        @select='selectYear'></dxj-select>
          </div>
          <div class="fl">
            <key-value-select width="108px"
                              :data="monthOption"
                              @select="selectMonth"></key-value-select>
          </div>
        </div>

      </div>
      <div class="flex-between"
           style="marginTop:10px;">
        <div class="fl-title">统计维度</div>

        <div class="flex-between fl-inner">
          <dxj-select width="32%"
                      :data="provinceOption"
                      @select='selectProvince'></dxj-select>
          <dxj-select width="32%"
                      :data="serviceOption"
                      @select='selectService'></dxj-select>
          <dxj-select width="32%"
                      :data="companyOption"
                      @select='selectCompany'></dxj-select>
        </div>

      </div>
      <div class="chartCon">
        <barhor chartTheme="dark"
                :data="barhorData"
                :color="barhorColor"></barhor>
      </div>
    </div>
    <!-- 分割线 -->
    <div class="lineleft"></div>
    <!-- 实时数据展示 -->
    <div class="piechart">
      <!-- <realtimedatadisplay chartTheme="dark"
                           :data="shishishujuData"
                           :color="pieRoseColor"
                           v-if="shishishujuData"></realtimedatadisplay> -->

      <real-time-radar :data="shishishujuData"
                       v-if="shishishujuData"></real-time-radar>
    </div>

    <!-- 分割线 -->
    <div class="lineright">
    </div>
    <!-- 数据传输变化趋势 -->
    <div class="linechart">
      <changetrendofdatatransmission chartTheme="dark"
                                     :data="shujuchuanshubianhuaqushi"
                                     :color="workStrengthChartColor"
                                     :areaOpacity=0
                                     :dataZoom=false
                                     v-if="shujuchuanshubianhuaqushi"
                                     yaxisName="传输量"></changetrendofdatatransmission>
      <div class="month">月</div>
    </div>
    <!-- 分割线 -->
    <div class="linebot"></div>
  </div>
</template>
<script>
/* eslint-disable */
import TitleView from "./TitleView.vue";
import KeyValueSelect from "../../components/KeyValueSelect.vue";
import DxjSelect from "../../components/kanban/DxjSelect.vue";
import barhor from "../../components/charts/barhor";
import RealTimeRadar from "../../components/charts/RealTimeRadar";
import realtimedatadisplay from "../../components/charts/realtimedatadisplay.vue";
import changetrendofdatatransmission from "../../components/charts/changetrendofdatatransmission.vue";
import Dictionary from "../../util/dictionary";
const { date: { year, month }, SeverType } = Dictionary;
export default {
  components: {
    TitleView,
    KeyValueSelect,
    barhor,
    RealTimeRadar,
    DxjSelect,
    realtimedatadisplay,
    changetrendofdatatransmission,
    Dictionary
  },
  data() {
    return {
      year: null,
      month: null,
      company: null,
      service: null,
      province: null,
      barhorColor: ["#05d0eb", "#81d9e5", "#f6ffcb", "#e75029", "#038bfc"],
      barhorData: [
        {
          data: [
            { name: "服务商", value: 86 },
            { name: "企业", value: 74 },
            { name: "监管平台", value: 60 }
          ]
        }
      ],
      yearOption: year,
      provinceOption: [
        { value: null, label: "全部" },
        { value: 1, label: "江苏" }
      ],
      serviceOption: [
        { value: null, label: "全部" },
        { value: 1, label: "服务商" }
      ],
      companyOption: [
        { value: null, label: "全部" },
        { value: 1, label: "企业" }
      ],
      monthOption: [{ label: "全年", value: null }, ...month],
      pieRoseColor: [
        "rgba(5,208,235,0.80)",
        "rgba(234,147,42,0.60)",
        "#BC570C"
      ],
      shishishujuData: [
        { name: "服务商1", value: 21568 },
        { name: "服务商2", value: 20256 },
        { name: "服务商3", value: 10256 },
        { name: "服务商4", value: 30256 },
        { name: "服务商5", value: 10256 },
        { name: "服务商6", value: 30256 },
        { name: "服务商7", value: 14256 },
        { name: "服务商8", value: 18256 },
        { name: "服务商9", value: 16256 },
        { name: "服务商10", value: 10256 },
        { name: "服务商11", value: 15256 },
        { name: "服务商12", value: 20256 },
        { name: "服务商13", value: 10256 },
        { name: "服务商14", value: 10256 },
        { name: "服务商15", value: 30256 },
        { name: "服务商16", value: 10256 },
        { name: "服务商17", value: 19256 },
        { name: "服务商18", value: 30256 },
        { name: "服务商19", value: 25891 }
      ],
      workStrengthChartColor: ["#05D0EB ", "#C88637", "#BC570C"],
      shujuchuanshubianhuaqushi: [
        {
          name: "服务商",
          data: [
            { name: "1", value: Math.floor(Math.random() * 120) },
            { name: "2", value: Math.floor(Math.random() * 120) },
            { name: "3", value: Math.floor(Math.random() * 120) },
            { name: "4", value: Math.floor(Math.random() * 120) },
            { name: "5", value: Math.floor(Math.random() * 120) },
            { name: "6", value: Math.floor(Math.random() * 120) },
            { name: "7", value: Math.floor(Math.random() * 120) },
            { name: "8", value: Math.floor(Math.random() * 120) },
            { name: "9", value: Math.floor(Math.random() * 120) },
            { name: "10", value: Math.floor(Math.random() * 120) },
            { name: "11", value: Math.floor(Math.random() * 120) },
            { name: "12", value: Math.floor(Math.random() * 120) }
          ]
        },
        // {
        //   name: "监管平台",
        //   data: [
        //     { name: "1", value: Math.floor(Math.random() * 120) },
        //     { name: "2", value: Math.floor(Math.random() * 120) },
        //     { name: "3", value: Math.floor(Math.random() * 120) },
        //     { name: "4", value: Math.floor(Math.random() * 120) },
        //     { name: "5", value: Math.floor(Math.random() * 120) },
        //     { name: "6", value: Math.floor(Math.random() * 120) },
        //     { name: "7", value: Math.floor(Math.random() * 120) },
        //     { name: "8", value: Math.floor(Math.random() * 120) },
        //     { name: "9", value: Math.floor(Math.random() * 120) },
        //     { name: "10", value: Math.floor(Math.random() * 120) },
        //     { name: "11", value: Math.floor(Math.random() * 120) },
        //     { name: "12", value: Math.floor(Math.random() * 120) }
        //   ]
        // },
        {
          name: "企业",
          data: [
            { name: "1", value: Math.floor(Math.random() * 120) },
            { name: "2", value: Math.floor(Math.random() * 120) },
            { name: "3", value: Math.floor(Math.random() * 120) },
            { name: "4", value: Math.floor(Math.random() * 120) },
            { name: "5", value: Math.floor(Math.random() * 120) },
            { name: "6", value: Math.floor(Math.random() * 120) },
            { name: "7", value: Math.floor(Math.random() * 120) },
            { name: "8", value: Math.floor(Math.random() * 120) },
            { name: "9", value: Math.floor(Math.random() * 120) },
            { name: "10", value: Math.floor(Math.random() * 120) },
            { name: "11", value: Math.floor(Math.random() * 120) },
            { name: "12", value: Math.floor(Math.random() * 120) }
          ]
        }
      ]
    };
  },
  methods: {
    selectCompany(item) {
      this.company = item.value;
    },
    selectService(item) {
      this.service = item.value;
    },
    selectProvince(item) {
      this.province = item.value;
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
.shujutongji {
  width: 1110px;
  height: 240px;
  position: relative;
  .linetop {
    width: 1070px;
    height: 2px;
    background: rgba(129, 217, 229, 0.5);
    margin-top: 2px;
    margin-left: 20px;
  }
  .title {
    width: 1090px;
    // margin-left: 20px;
    margin-top: 7px;
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
      left: 372px;
      background: #89dddf;
    }
    .col4 {
      width: 2px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 750px;
      background: #89dddf;
    }
    .text1 {
      float: left;
      width: 374px;
      height: 30px;
      padding-left: 50px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .text2 {
      float: left;
      width: 378px;
      height: 30px;
      padding-left: 38px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
    .text3 {
      float: left;
      width: 338px;
      height: 30px;
      padding-left: 16px;
      box-sizing: border-box;
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
    }
  }
  .barchart {
    width: 372px;
    height: 198px;
    // background: red;
    float: left;
    // 下拉框包裹
    .itemCon {
      // @include size(392px,37px);
      width: 100%;
      height: 25px;
      margin-top: 12px;
      color: #b5b5b5;
      font-size: 14px;
      line-height: 25px;
      box-sizing: border-box;
      //   padding-left: 50px;
      div {
        &:nth-child(1) {
          margin-left: 16px;
        }
      }
    }
    .chartCon {
      width: 340px;
      height: 125px;
      // padding-left: 45px;
      padding-left: 25px;
      box-sizing: border-box;
    }
  }
  .piechart {
    width: 378px;
    height: 198px;
    // background: yellow;
    float: left;
  }
  .linechart {
    width: 340px;
    height: 198px;
    // background: green;
    float: left;
    padding-left: 10px;
    padding-right: 10px;
    padding-top: 5px;
    box-sizing: border-box;
    position: relative;
    .month {
      position: absolute;
      bottom: 4px;
      right: 3px;
      font-size: 14px;
      color: #b5b5b5;
    }
  }

  .lineleft {
    width: 2px;
    height: 189px;
    position: absolute;
    bottom: 7px;
    left: 372px;
    background: rgba(129, 217, 229, 0.4);
  }
  .lineright {
    width: 2px;
    height: 189px;
    position: absolute;
    bottom: 7px;
    left: 750px;
    background: rgba(129, 217, 229, 0.4);
  }
  .linebot {
    width: 1070px;
    height: 2px;
    background: rgba(129, 217, 229, 0.5);
    position: absolute;
    bottom: 4px;
    left: 20px;
  }
  .fl-inner {
    width: 300px;
    padding-right: 10px;
    box-sizing: border-box;
  }
  .fl-title {
    width: 75px;
    color: #b5b5b5;
    font-size: 14px;
    padding-left: 17px;
  }
}
</style>
