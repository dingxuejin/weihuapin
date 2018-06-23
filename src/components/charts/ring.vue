<template>
  <div class="content">
    <Echarts :options="newOption"
             :theme="chartTheme"></Echarts>
  </div>

</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'ring',
  props: ['chartTheme', 'data', 'color'],
  components: {
    Echarts,
  },
  computed: {
    newOption() {
      const option = this.chartOption
      option.color = this.color
      option.legend.data = this.data.map(item => item.name)
      option.series.data = this.data
      return option
    },
  },
  data() {
    return {
      chartOption: {
        tooltip: {
          show: false,
        },
        legend: {
          show: false,
          type: 'scroll',
          pageTextStyle: {
            color: '#fff',
          },
          left: 'right',
          top: 'bottom',
          data: [],
        },
        series: {
          type: 'pie',
          radius: ['65%', '85%'],
          avoidLabelOverlap: false,
          label: {
            normal: {
              show: false,
              position: 'center',
            },
            emphasis: {
              show: true,
              formatter(params) {
                return `{gray|${params.name}}\n\n{white|${params.percent}%}`
              },
              rich: {
                gray: {
                  color: '#ccc',
                  fontSize: 20,
                },
                white: {
                  color: '#fff',
                  fontSize: 30,
                  fontWeight: 'bold',
                },
              },
            },
          },
          labelLine: {
            normal: {
              show: false,
            },
          },
          data: '',
        },
      },
    }
  },

  mounted() {
    const chart = this.$children['0'].chart
    chart.dispatchAction({
      type: 'highlight',
      seriesIndex: 0,
      dataIndex: 0,
    })

    chart.on('mouseover', (params) => {
      if (params.dataIndex !== 0) {
        chart.dispatchAction({
          type: 'downplay',
          seriesIndex: 0,
          dataIndex: 0,
        })
      }
    })

    const chartCon = this.$el
    chartCon.onmouseout = function () {
      chart.dispatchAction({
        type: 'highlight',
        seriesIndex: 0,
        dataIndex: 0,
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.content {
  width: 100%;
  height: 100%;
  position: relative;
  // overflow: hidden;
}
.echarts {
  width: 100%;
  height: 100%;
}
</style>
