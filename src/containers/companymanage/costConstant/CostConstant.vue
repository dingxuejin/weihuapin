<template>
  <div class="costchang_content">
    <div class="title">固定成本</div>
    <!-- 切换数据 -->
    <div class="switchCon clearfix">
      <div class="fl"
           :class="{active:situation === 'maintain'}"
           @click="switchSituation('maintain')">保养情况</div>
      <div class="fl"
           :class="{active:situation === 'test'}"
           @click="switchSituation('test')">检测情况</div>
      <div class="fl"
           :class="{active:situation === 'repair'}"
           @click="switchSituation('repair')">维修情况</div>
    </div>
    <!-- 下拉 -->
    <div class="dropDown clearfix">
      <div class="selectCon fr">
        <key-value-select :data='options'
                          @select='select'></key-value-select>
      </div>
    </div>

    <!-- 图表 -->
    <div class="chartsCon"
         v-if="fixedCost">
      <lineDoubleAxis chartTheme="dark"
                      :data="fixedCost"
                      :color="[
                        '#05d0eb',
                        '#81d9e5',
                        '#f6ffcb',
                        '#e75029',
                        '#038bfc',
                        '#006a55',
                      ]"
                      dataZoom=f
                      alse
                      :property='property'
                      yaxisNameL="费用(万元)"
                      yaxisNameR="数量(次)"></lineDoubleAxis>
    </div>
    <!-- <div>{{JSON.stringify(fixedCost)}}</div> -->
  </div>
</template>

<script type="text/javascript">
/*eslint-disable */
import { mapState, mapActions } from "vuex";
import KeyValueSelect from "../../../components/KeyValueSelect";
import lineDoubleAxis from "../../../components/charts/costLineDoubleAxis";

const options = {
  maintain: [
    { label: "保养费用", value: "maintain_cost" },
    { label: "万公里保养费用", value: "maintaincost_tenthousand_km" },
    { label: "平均每单保养费用", value: "maintaincost_per_waybill" },
    { label: "周转量成本", value: "million_turnover_cost" }
  ],
  test: [
    { label: "检测费用", value: "test_cost" },
    { label: "检测次数", value: "test_times" },
    { label: "检测通过率", value: "pass_rate" }
  ],
  repair: [
    { label: "维修成本", value: "repair_cost" },
    { label: "万公里维修成本", value: "repaircost_tenthousand_km" },
    { label: "每运单维修成本", value: "repaircost_per_waybill" },
    { label: "周转量成本", value: "million_turnover_cost" }
  ]
};

export default {
  name: "CostConstant",
  components: {
    KeyValueSelect,
    lineDoubleAxis
  },
  computed: {
    ...mapState("manageCostConstant", ["fixedCost"]),
    ...mapState("maintitlemsg", ["selectedEntity"]),
    options() {
      return options[this.situation];
    },
    property() {
      const p = {
        maintain: {
          maintain_cost: [
            {
              name: "保养费用",
              type: "bar",
              axis: 0
            },
            {
              name: "保养次数",
              type: "line",
              axis: 1
            }
          ],
          maintaincost_tenthousand_km: [
            {
              name: "万公里保养费用",
              type: "bar",
              axis: 0
            },
            {
              name: "万公里保养次数",
              type: "line",
              axis: 1
            }
          ],
          maintaincost_per_waybill: [
            {
              name: "平均每单保养费用",
              type: "bar",
              axis: 0
            }
          ],
          million_turnover_cost: [
            {
              name: "周转量成本",
              type: "bar",
              axis: 0
            }
          ]
        },
        test: {
          test_cost: [
            {
              name: "检测费用",
              type: "bar",
              axis: 0
            }
          ],
          test_times: [
            {
              name: "检测次数",
              type: "bar",
              axis: 0
            }
          ],
          pass_rate: [
            {
              name: "检测通过率",
              type: "bar",
              axis: 0
            }
          ]
        },
        repair: {
          repair_cost: [
            {
              name: "维修成本",
              type: "bar",
              axis: 0
            },
            {
              name: "维修数量",
              type: "line",
              axis: 1
            }
          ],
          repaircost_tenthousand_km: [
            {
              name: "万公里维修成本",
              type: "bar",
              axis: 0
            },
            {
              name: "万公里维修数量",
              type: "line",
              axis: 1
            }
          ],
          repaircost_per_waybill: [
            {
              name: "每运单维修成本",
              type: "bar",
              axis: 0
            }
          ],
          million_turnover_cost: [
            {
              name: "周转量成本",
              type: "bar",
              axis: 0
            }
          ]
        }
      };
      return p[this.situation][this.type];
    }
  },
  methods: {
    ...mapActions("manageCostConstant", ["getFixedCost"]),
    switchSituation(situation) {
      this.situation = situation;
      this.type = options[situation][0].value;

      this.getFixedCost({
        entity_id: this.selectedEntity && this.selectedEntity,
        situation,
        type: options[situation][0].value
      });
    },

    select(item) {
      this.type = item.value;
      this.getFixedCost({
        entity_id: this.selectedEntity && this.selectedEntity,
        situation: this.situation,
        type: this.type
      });
    }
  },
  data: () => ({
    situation: "maintain",
    type: "maintain_cost"
  })
};
</script>

<style lang="scss" scoped>
// 公用样式
@mixin font_level_3 {
  color: #89dddf;
  font-size: 16px;
}
@mixin box_on {
  color: #fff;
  font-size: 14px;
  border: 1px solid rgba(0, 191, 229, 1);
  background: rgba(0, 191, 229, 0.5);
}
@mixin box_off {
  color: #b5b5b5;
  font-size: 14px;
  border: 1px solid rgba(0, 191, 229, 1);
  background: rgba(0, 191, 229, 0.2);
}
.costchang_content {
  width: 100%;
  height: 100%;
  // overflow: hidden;
  //   background: green;

  // 标题
  .title {
    width: 440px;
    height: 25px;
    overflow: hidden;
    background: rgba(129, 217, 229, 0.3);
    text-indent: 20px;
    line-height: 25px;
    @include font_level_3;
  }

  //   切换数据
  .switchCon {
    width: 210px;
    height: 25px;
    overflow: hidden;
    margin-top: 10px;
    // background: red;
    float: left;
    div {
      width: 66px;
      height: 25px;
      box-sizing: border-box;
      overflow: hidden;
      text-align: center;
      line-height: 23px;
      cursor: pointer;
      // background: pink;
      @include box_off;
    }
    div:nth-child(n + 2) {
      margin-left: 5px;
    }
    .active {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
  }

  // 下拉
  .dropDown {
    width: 190px;
    height: 25px;
    // overflow: hidden;
    margin-top: 10px;
    // background: green;
    float: left;
    .selectCon {
      width: 180px;
      height: 25px;
      // overflow: hidden;
      // background: red;
    }
  }

  //   图表
  .chartsCon {
    width: 100%;
    height: 210px;
    // overflow: hidden;
    margin-top: 50px;
    // background: lightblue;
  }
}
</style>