<template>
  <Echarts :options="option" class="lineBarInOutCome_echarts"></Echarts>
</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: '',
  components: {
    Echarts,
  },
  computed: {},
  methods: {

  },
  data() {
    return {
      option: {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999',
            },
          },
        },
        grid: {
          top: '25%',
          left: '5%',
          width: '90%',
          height: '75%',
          containLabel: true,
        },
        legend: {
          textStyle: {
            color: '#B5B5B5',
            fontSize: 14,
          },
          data: ['人均收入', '人均支出', '总收入', '总支出'],
        },
        xAxis: [
          {
            type: 'category',
            data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
            axisPointer: {
              type: 'shadow',
            },
            axisLabel: {
              fontSize: 14,
              color: '#B5B5B5',
            },
            axisTick: {
              show: false,
            },
          },
        ],
        yAxis: [
          {
            type: 'value',
            name: '人均',
            min: 0,
            nameTextStyle: {
              fontSize: 14,
              color: '#B5B5B5',
            },
            max(value) {
              return value.max + 40
            },
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              fontSize: 14,
              color: '#B5B5B5',
            },
            interval: 20,
          },
          {
            type: 'value',
            name: '总的',
            min: 0,
            max(value) {
              return value.max + 100
            },
            interval: 200,
            nameTextStyle: {
              fontSize: 14,
              color: '#B5B5B5',
            },
            splitLine: {
              show: false,
            },
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              fontSize: 14,
              color: '#B5B5B5',
            },
          },
        ],
        series: [
          {
            name: '人均收入',
            type: 'bar',
            barGap: ' 0%',
            itemStyle: {
              color: '#05D0EB',
            },
            barWidth: 10,
            data: [55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55],
          },
          {
            name: '人均支出',
            type: 'bar',
            barWidth: 10,
            itemStyle: {
              color: '#2C77E5',
            },
            data: [60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60],
          },
          {
            name: '总收入',
            type: 'line',
            yAxisIndex: 1,
            itemStyle: {
              color: '#E75029',
            },
            lineStyle: {
              color: '#E75029',
            },
            data: [500, 550, 520, 600, 700, 520, 620, 720, 560, 660, 500, 560],
          },
          {
            name: '总支出',
            type: 'line',
            yAxisIndex: 1,
            itemStyle: {
              color: '#F6FFCB',
            },
            lineStyle: {
              color: '#F6FFCB',
            },
            data: [700, 520, 620, 500, 550, 520, 520, 600, 700, 550, 520, 600],
          },
        ],
      },
    }
  },
}
</script>

<style lang="scss" scoped>
.lineBarInOutCome_echarts{
    width: 100%;
    height: 100%;
}
</style>