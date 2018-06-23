<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
/* eslint-disable */
import Echarts from "vue-echarts";

export default {
  name: "ringSingle",
  props: ["chartTheme", "data", "color", "borderColor"],
  components: {
    Echarts
  },
  computed: {
    newOption() {
      const option = this.chartOption;
      option.series[1].data[0].value =
        Number(this.data && this.data.total) -
        Number(this.data && this.data.value);

      option.series[1].data[1].value = this.data && this.data.value;

      return option;
    }
  },
  data() {
    return {
      chartOption: {
        // backgroundColor: 'rgba(0,0,0,0)',
        series: [
          // 背景底色圆
          {
            type: "pie",
            radius: ["84%", "85%"],
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
          },
          {
            type: "pie",
            radius: ["75%", "94%"],
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
                value: "",
                itemStyle: {
                  normal: {
                    color: "rgba(0,0,0,0)"
                  }
                }
              },
              {
                value: "",
                itemStyle: {
                  normal: {
                    color: this.color,
                    borderColor: this.borderColor,
                    borderWidth: 2,
                    opacity: 1
                  },
                  emphasis: {
                    color: this.color,
                    borderColor: this.borderColor,
                    borderWidth: 2
                  }
                },
                label: {
                  normal: {
                    show: true,
                    position: "center",
                    formatter(params) {
                      return `${params.percent.toFixed(0)}%`;
                    },
                    color: "#fff"
                  },
                  emphasis: {
                    show: true
                  }
                }
              }
            ]
          }
        ]
      }
    };
  }
};
</script>

<style lang="scss" scoped>
.echarts {
  width: 100%;
  height: 100%;
  background: none;
}
</style>
