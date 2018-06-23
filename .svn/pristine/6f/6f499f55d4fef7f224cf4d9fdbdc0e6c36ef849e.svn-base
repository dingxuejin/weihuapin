<template>
  <div class="ringAndLegend_con">
    <Echarts :options="newOption"
             :theme="chartTheme"></Echarts>
    <div class="ringAndLegend_itemTitle"></div>
  </div>

</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'ringAndLegend',
  components: {
    Echarts,
  },
  props: ['chartTheme', 'data', 'color', 'marginLeft'],
  computed: {
    newOption() {
      const option = this.chartOption
      option.color = this.color
      option.legend.data = this.data && this.data.map(item => item.name)
      option.series[1].data = this.data
      return option
    },
  },
  data() {
    return {
      chartData: this.data,
      chartOption: {
        tooltip: {
          show: false,
        },
        legend: {
          type: 'scroll',
          // width: 200,
          height: 400,
          pageTextStyle: {
            color: '#fff',
          },
          show: true,
          left: 'center',
          top: 'bottom',
          // orient: 'vertical',
          align: 'left',
          data: [],
        },
        series: [
          {
            name: 'bg',
            type: 'pie',
            silent: true,
            center: ['45%', '48%'],
            radius: ['38.5%', '39%'],
            avoidLabelOverlap: false,
            hoverAnimation: false,
            label: {
              show: false,
            },
            labelLine: {
              show: false,
            },
            emphasis: {
              label: {
                show: false,
              },
            },
            data: [
              {
                name: 'bg1',
                value: 4,
                itemStyle: {
                  color: '#909090',
                },
              },
              {
                name: 'bg2',
                value: 1,
                itemStyle: {
                  color: 'rgba(0,0,0,0)',
                },
              },
              {
                name: 'bg3',
                value: 4,
                itemStyle: {
                  color: '#909090',
                },
              },
              {
                name: 'bg4',
                value: 4,
                itemStyle: {
                  color: '#909090',
                },
              },
              {
                name: 'bg5',
                value: 1,
                itemStyle: {
                  color: 'rgba(0,0,0,0)',
                },
              },
              {
                name: 'bg6',
                value: 4,
                itemStyle: {
                  color: '#909090',
                },
              },
            ],
          },
          {
            name: '',
            type: 'pie',
            center: ['45%', '48%'],
            radius: ['40.5%', '60%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: 'center',
                textStyle: {
                  color: '#fff',
                  fontSize: 16,
                  fontWeight: 'bold',
                },
              },
              emphasis: {
                show: true,
                // formatter (params) {
                //   return (
                //     `{gray|${params.name}}\n\n{white|${params.percent}%}`
                //   )
                // },
                formatter: '{d}%',
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
            itemStyle: {
              borderColor: 'rgba(51,51,51,1)',
              borderWidth: 1,
            },
            data: [],
          },
        ],
      },
    }
  },

  mounted() {
    const chart = this.$children['0'].chart
    const chartData = this.data
    // itemTitle
    // const msgTitle = document.getElementsByClassName('ringAndLegend_itemTitle')[0]  j
    const msgTitle = this.$el.children[1]
    msgTitle.innerText = this.data && this.data[0].name
    msgTitle.style.left = this.marginLeft

    chart.dispatchAction({
      type: 'highlight',
      seriesIndex: 1,
      dataIndex: 0,
    })

    chart.on('mouseover', (params) => {
      if (params.dataIndex !== 0) {
        chart.dispatchAction({
          type: 'downplay',
          seriesIndex: 1,
          dataIndex: 0,
        })
      }
      // 赋值标题
      msgTitle.innerText = params.name
    })

    const chartCon = this.$el
    chartCon.onmouseout = function () {
      chart.dispatchAction({
        type: 'highlight',
        seriesIndex: 1,
        dataIndex: 0,
      })
      msgTitle.innerText = chartData && chartData[0].name
    }
  },
}
</script>

<style lang="scss" scoped>
//包裹
.ringAndLegend_con {
  width: 100%;
  height: 100%;
  overflow: hidden;
  position: relative;
  // background: #ccc;

  // 图表
  .echarts {
    width: 100%;
    height: 100%;
  }

  // title
  .ringAndLegend_itemTitle {
    width: 150px;
    position: absolute;
    left: 0px;
    top: 0px;
    z-index: 100;
    color: #89dddf;
    font-size: 16px;
    word-wrap: break-word;
    word-break: break-all;
  }
}
</style>
