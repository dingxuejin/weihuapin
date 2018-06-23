<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'pieRose',
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
          trigger: 'item',
          textStyle: {
            fontSize: 14,
          },
          formatter: '{b}<br/>{d}%',
        },
        legend: {
          show: false,
          type: 'scroll',
          pageTextStyle: {
            color: '#fff',
          },
          orient: 'vertical',
          left: 'right',
          top: 'bottom',
          data: [],
        },
        grid: {
          left: '3%',
          top: '5%',
        },
        series: {
          type: 'pie',
          roseType: 'radius',
          radius: '80%',
          center: ['50%', '50%'],
          label: {
            normal: {
              show: true,
              color: '#fff',
            },
          },
          labelLine: {
            normal: {
              show: true,
              length: 5,
              lenght2: 5,
              lineStyle: {
                color: '#f6ffcb',
              },
            },
          },
          data: [],
        },
      },
    }
  },

  // // 钩子函数,默认触发
  // mounted () {
  //   const len = this.$options.propsData.data.length
  //   const pie = this.$children['0'].chart
  //   pie.dispatchAction({
  //     type: 'highlight',
  //     seriesIndex: 0,
  //     dataIndex: len - 1
  //   })
  //   pie.dispatchAction({
  //     type: 'showTip',
  //     seriesIndex: 0,
  //     dataIndex: len - 1
  //     // position:['30%','40%']
  //   })

  //   pie.on('mouseover', params => {
  //     // console.log('移入');
  //     if (params.dataIndex !== len - 1) {
  //       pie.dispatchAction({
  //         type: 'downplay',
  //         seriesIndex: 0,
  //         dataIndex: len - 1
  //       })
  //     }
  //   })

  //   const chartCon = this.$el
  //   chartCon.onmouseout = function () {
  //     pie.dispatchAction({
  //       type: 'highlight',
  //       seriesIndex: 0,
  //       dataIndex: len - 1
  //     })

  //     pie.dispatchAction({
  //       type: 'showTip',
  //       seriesIndex: 0,
  //       dataIndex: len - 1
  //       // position:['30%','40%']
  //     })
  //   }
  // }
}
</script>

<style lang="scss" scoped>
.echarts {
  width: 100%;
  height: 100%;
}
</style>
