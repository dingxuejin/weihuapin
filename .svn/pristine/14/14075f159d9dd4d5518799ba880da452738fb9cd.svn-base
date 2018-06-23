<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
/*eslint-disable */
import Echarts from "vue-echarts";

export default {
  name: "ringSingle",
  props: [
    "chartTheme",
    "data",
    "color",
    "borderColor",
    "showLabel",
    "fontSize"
  ],
  components: {
    Echarts
  },
  computed: {
    newOption() {
      /* eslint-disable */
      const color = this.color;
      const borderColor = this.borderColor;
      const option = this.chartOption;
      const chartData = this.data;
      const len = chartData.length;
      const showLabel = this.showLabel;

      option.legend.data = this.data.map(item => item.name);
      option.legend.textStyle.fontSize = this.fontSize;
      option.series = (function(data) {
        const arr = [];
        data.forEach((item, index) => {
          // bg
          arr.push({
            name: "bg",
            type: "pie",
            radius: (function(index) {
              if (len === 1) {
                return ["84%", "85%"];
              }
              const res = 100 / len + 10 * index + 10;
              return [`${res}%`, `${res + 1}%`];
            })(index),
            silent: true,
            cursor: "arrow",
            hoverAnimation: false,
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: false
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            itemStyle: {
              normal: {
                color: "#808080"
              }
            },
            data: [
              {
                value: 0,
                name: "直接访问"
              }
            ]
          });

          // 图表
          arr.push({
            name: item.name,
            type: "pie",
            radius: (function(index) {
              if (len === 1) {
                return ["75%", "94%"];
              }
              const res = 100 / len + 10 * index + 10;
              return [`${res - 2}%`, `${res + 3}%`];
            })(index),
            hoverAnimation: false,
            avoidLabelOverlap: false,
            clockwise: false,
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: false
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: [
              {
                value: 100 - item.value.split("%")[0],
                itemStyle: {
                  normal: {
                    color: "rgba(0,0,0,0)"
                  }
                }
              },
              {
                value: item.value.split("%"),
                itemStyle: {
                  normal: {
                    color: color[index % len],
                    borderColor: borderColor[index % len],
                    borderWidth: 2,
                    opacity: 1
                  },
                  emphasis: {
                    color: color[index % len],
                    borderColor: borderColor[index % len],
                    borderWidth: 2
                  }
                },
                label: {
                  normal: {
                    show: false,
                    position: "center",
                    formatter(params) {
                      return `${params.percent.toFixed(0)}%`;
                    },
                    color: "#fff"
                  },
                  emphasis: {
                    show: showLabel
                  }
                }
              }
            ]
          });
        });
        return arr;
      })(chartData);

      option.tooltip.formatter = params => {
        if (params.dataIndex === 1 && params.seriesIndex % 2 === 1) {
          return (
            `${'<div class="ringSingleTooltip">' + '<p class="title">'}${
              params.seriesName
            }</p >` +
            '<div class="itemsBorder clearfix"><div></div><div></div><div></div></div>' +
            `<div class="itemCon clearfix"><p class="itembg fl"></p><p class="indexName fl">${
              // chartData[(params.seriesIndex - 1) / 2].itemName
              params.seriesName
            }</p><p class="index fr">${Number(params.value[0]).toFixed(
              2
            )}%</p ></div>` +
            "</div>"
          );
        }
        return null;
      };
      return option;
    }
  },
  data() {
    return {
      chartData: this.data,
      chartOption: {
        legend: {
          type: "scroll",
          pageTextStyle: {
            color: "#fff"
          },
          textStyle: {},
          right: 10,
          bottom: 20,
          orient: "vertical",
          data: []
        },
        tooltip: {
          trigger: "item",
          backgroundColor: "rgba(0,0,0,0)",
          axisPointer: {
            type: "shadow"
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
  background: none;
}

// tooltip 样式
.ringSingleTooltip {
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
