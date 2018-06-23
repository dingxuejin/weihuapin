<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'Radar',
  components: {
    Echarts,
  },
  props: ['chartTheme', 'data', 'color'],
  computed: {
    newOption() {
      const option = this.chartOption
      const chartData = this.data
      option.color = this.color
      option.radar.indicator = chartData[0].data.map(item => ({
        text: item.name,
        // max: Math.max.apply(null, chartData.map(item => item.data[index].max)),
        // max: Math.max.apply(null, chartData.map(item => item.data[index].value)) * 1.1,
        max: Math.max(
          ...chartData.reduce((total, curr) => {
            const values = curr.data.map(i => i.value)
            return [...total, ...values]
          }, []),
        ),
        // color: 'rgba(0,0,0,0)',
      }))
      option.tooltip.formatter = params =>
        `<div class="radarTooltip"><p class="title">${
          params.name
        }</p >` +
        `<div class="itemsBorder clearfix"><div></div><div></div><div></div></div>${chartData[
          params.dataIndex
        ].data
          .map(
            item =>
              `<div class="itemCon clearfix"><p class="itembg fl"></p><p class="indexName fl">${
                item.name
              }</p><p class="index fr">${Number(item.value).toFixed(2)}</p ></div>`,
          )
          .join(' ')}</div>`
      if (this.data[0].data.length !== 0) {
        option.series.data = this.data.map(item => ({
          name: item.name,
          symbol: 'circle',
          symbolSize: 2,
          areaStyle: {
            opacity: 0.4,
          },
          label: {
            normal: {
              show: true,
              fontSize: 10,
              formatter(params) {
                return params.value
              },
            },
          },
          value: item.data.map(item => item.value),
        }))
      }
      return option
    },
  },
  data() {
    return {
      chartOption: {
        tooltip: {
          trigger: 'item',
          backgroundColor: 'rgba(0,0,0,0)',
          axisPointer: {
            type: 'shadow',
          },
        },
        grid: {
          top: 100,
        },
        radar: {
          radius: '70%',
          nameGap: 10,
          name: {
            fontSize: 8,

          },
          splitArea: {
            areaStyle: {
              color: 'rgba(129,217,229,0.1)',
            },
          },
          splitLine: {
            lineStyle: {
              color: '#365458',
            },
          },
          axisLine: {
            lineStyle: {
              color: '#365458',
            },
          },
          axisLabel: {
            show: false,
          },
          indicator: [],
        },
        series: {
          name: 'radar',
          type: 'radar',
          symbolSize: 2,
          lineStyle: {
            width: 1,
          },
          label: {
            show: false,
          },
          data: [],
        },
      },
    }
  },
}
</script>

<style lang="scss">
.echarts {
  width: 100%;
  height: 100%;
  // overflow: hidden;
}

// tooltip 样式
.radarTooltip {
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
