<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
/*eslint-disable */
import Echarts from "vue-echarts";

export default {
  name: "BarStack",
  components: { Echarts },
  props: ["chartTheme", "data", "color", "yName"],
  computed: {
    newOption() {
      const option = this.chartOption;
      option.color = this.color;
      option.yAxis.name = this.yName;
      option.xAxis.data = this.data[0].data.map(item => item.name);
      option.series = this.data.map(item => ({
        type: "bar",
        name: item.name,
        stack: true,
        data: item.data.map(item => item.value)
      }));
      if (this.data.length > 1) {
        option.legend.data = this.data.map(item => item.name);
      }
      return option;
    }
  },
  data() {
    return {
      chartOption: {
        tooltip: {
          trigger: "axis",
          backgroundColor: "rgba(0,0,0,0)",
          axisPointer: {
            type: "shadow"
          },
          formatter(params) {
            return (
              `${'<div class="BarStackTooltip">' + '<p class="title">'}${
                params[0].name
              }</p >` +
              `<div class="itemsBorder clearfix"><div></div><div></div><div></div></div>${params
                .map(
                  item =>
                    `<div class="itemCon clearfix">
                      <p class="itembg fl"></p>
                      <p class="indexName fl">${item.seriesName}</p>
                      <p class="index fr">${Number(item.value).toFixed(2)}</p >
                    </div>`
                )
                .join(" ")}</div>`
            );
          }
        },
        grid: {
          left: "3%",
          right: "3%",
          top: 60,
          bottom: 0,
          containLabel: true
        },
        legend: {
          type: "scroll",
          pageTextStyle: {
            color: "#fff"
          },
          textStyle: {
            fontSize: 14
          },
          data: []
        },
        xAxis: {
          type: "category",
          axisTick: { show: false },
          axisLine: { show: false },
          splitLine: { show: false },
          axisLabel: {
            fontSize: 14
          },
          data: []
        },
        yAxis: {
          type: "value",
          axisTick: { show: false },
          axisLine: { show: false },
          axisLabel: {
            fontSize: 14
          },
          nameTextStyle: {
            fontSize: 16
          }
        },
        series: []
      }
    };
  }
};
</script>

<style lang="scss">
.echarts {
  width: 100%;
  height: 100%;
  // overflow: hidden;
}

// tooltip 样式
.BarStackTooltip {
  min-width: 100px;
  min-height: 10px;
  padding: 10px;
  overflow: hidden;
  border: 2px solid rgba(5, 208, 235, 0.78);
  background: rgba(9, 10, 11, 0.9);
  color: #fff;
  font-size: 14px;
  line-height: 20px;

  // 间隔线
  .itemsBorder {
    width: 100%;
    height: 2px;
    margin-top: 10px;
    // background: orange;
    div:nth-child(odd) {
      width: 10px;
      height: 100%;
      overflow: hidden;
      float: left;
      background: #81d9e5;
    }
    div:nth-child(even) {
      width: calc(100% - 20px);
      height: 100%;
      overflow: hidden;
      float: left;
      background: rgba(129, 217, 229, 0.5);
    }
  }
  // 图表数据
  .itemCon {
    width: 100%;
    height: 20px;
    overflow: hidden;
    margin-top: 10px;
    // background: pink;
    .itembg {
      width: 6px;
      height: 6px;
      overflow: hidden;
      border-radius: 50%;
      margin-top: 7px;
      background: rgba(5, 208, 235, 1);
    }
    .indexName {
      margin-left: 5px;
    }
  }
  .itemCon:nth-child(n + 4) {
    margin-top: 5px;
  }
}
</style>
