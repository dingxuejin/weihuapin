<template>
    <div class="box">
        <Echarts :options="Options">

        </Echarts>
    </div>
</template>
<script>
import Echarts from 'vue-echarts'

export default {
  components: {
    Echarts,
  },
  data() {
    return {
      Options: {
        tooltip: {
          show: 'true',
          trigger: 'item',
          axisPointer: {
            type: 'shadow',
          },
        },
        grid: {
          top: 5,
          bottom: 5,
          left: 5,
          right: 5,
          containLabel: true,
        },
        xAxis: {
          type: 'value',
          show: true,
          max: 100,
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: false,
          },
          splitLine: {
            show: false,
          },
        },
        yAxis: [{
          type: 'category',
          position: 'right',
          data: [],
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: true,
            color: '#fff',
          },
          splitLine: {
            show: false,
          },
        }, {
          type: 'category',
          position: 'left',
          data: ['离开指定区域', '进入指定区域', '紧急报警', '疲劳驾驶', '超速报警'],
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: true,
            color: '#fff',
          },
          splitLine: {
            show: false,
          },
        }],
        series: [{
          name: '',
          type: 'bar',
          barWidth: 2,
          silent: true,
          yAxisIndex: 0,
          label: {
            normal: {
              show: true,
              color: '#fff',
              formatter() {
                return ''
              },
              position: 'right',
            },
          },
          itemStyle: {
            normal: {
              color: '#0B2A54',
              barBorderRadius: 5,
            },
          },
          data: [100, 100, 100, 100, 100],
        }, {
          name: '',
          type: 'bar',
          barWidth: 8,
          silent: false,
          yAxisIndex: 1,
          itemStyle: {
            normal: {
              barBorderRadius: 2,
              color(params) {
                const colorList = ['#aaccdd', '#297f7d', '#7373d9', '#999977', '#ffbf00']
                return colorList[params.dataIndex]
              },
            },
          },
          data: [54, 64, 66, 70, 80],
        }],
      },
    }
  },
}
</script>
<style lang="scss" scoped>
.box{
    width: 100%;
    height: 150px;
    position: absolute;
    bottom: 5px;
    .echarts{
        width: 100%;
        height: 100%;
    }
}
</style>
