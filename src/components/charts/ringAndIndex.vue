<template>
  <div class="content">
    <div class="ringChartCon">
      <Echarts :options="newOption"
               :theme="chartTheme"></Echarts>
    </div>

    <div class="msgCon">
      <div v-for="(item,index) in chartData"
           class="item clearfix"
           :key="index">
        <div class="itemTitle fl">{{item.name}}</div>
        <div class="itemIndex fr">{{item.value}}</div>
      </div>
    </div>
  </div>

</template>

<script type="text/javascript">
/*eslint-disable */
import Echarts from "vue-echarts";

export default {
  name: "ringAndIndex",
  components: {
    Echarts
  },
  props: ["chartTheme", "data", "color"],
  computed: {
    newOption() {
      const option = this.chartOption;
      option.color = this.color;
      option.legend.data = this.data && this.data.map(item => item.name);
      option.series.data = this.data && this.data;
      return option;
    }
  },
  data() {
    return {
      chartData: this.data && this.data,
      chartOption: {
        // color: this.color,
        tooltip: {
          show: false
        },
        legend: {
          show: false,
          type: "scroll",
          pageTextStyle: {
            color: "#fff"
          },
          left: "right",
          top: "bottom",
          data: []
        },
        series: {
          name: "访问来源",
          type: "pie",
          radius: ["65%", "85%"],
          avoidLabelOverlap: false,
          label: {
            normal: {
              show: false,
              position: "center"
            },
            emphasis: {
              show: true,
              formatter(params) {
                return `{gray|${params.name}}\n\n{white|${params.percent}%}`;
              },
              rich: {
                gray: {
                  color: "#ccc",
                  fontSize: 20
                },
                white: {
                  color: "#fff",
                  fontSize: 30,
                  fontWeight: "bold"
                }
              }
            }
          },
          labelLine: {
            normal: {
              show: false
            }
          },
          data: []
        }
      }
    };
  },

  mounted() {
    const chart = this.$children["0"].chart;
    chart.dispatchAction({
      type: "highlight",
      seriesIndex: 0,
      dataIndex: 0
    });

    chart.on("mouseover", params => {
      if (params.dataIndex !== 0) {
        chart.dispatchAction({
          type: "downplay",
          seriesIndex: 0,
          dataIndex: 0
        });
      }
    });

    const chartCon = this.$el;
    chartCon.onmouseout = function() {
      chart.dispatchAction({
        type: "highlight",
        seriesIndex: 0,
        dataIndex: 0
      });
    };
  }
};
</script>

<style lang="scss" scoped>
.content {
  width: 100%;
  height: 100%;
  position: relative;
  overflow: hidden;
}

.ringChartCon {
  width: 360px;
  height: 360px;
  overflow: hidden;
  position: absolute;
  top: 50%;
  /*left:50%;*/
  transform: translate(-50%, -50%);
  left: 30%;
  background: green;
  /*background:url(../../../static/chartsImgs/one.png) center center no-repeat;*/
  /*background-size: 10% 10%;*/
}

.echarts {
  width: 100%;
  height: 100%;
}

/* 参数包裹 */
.msgCon {
  width: 160px;
  height: 110px;
  overflow: hidden;
  /*background:pink;*/
  position: absolute;
  right: 10px;
  bottom: 20px;
}
.item {
  width: 100%;
  height: 30px;
  line-height: 30px;
  margin-top: 5px;
  /*background:#000;*/
}
.itemTitle {
  color: #b5b5b5;
  /*background:green;*/
}
.itemIndex {
  color: #0f417c;
  padding: 0px 30px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  /*background:green;*/
}
.item:nth-child(2) .itemIndex {
  color: #91faf0;
}
.item:nth-child(3) .itemIndex {
  color: #ff9a2c;
}
</style>