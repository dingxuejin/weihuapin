<template>
    <div class="box">
        <Echarts :options="Options"></Echarts>
    </div>
</template>
<script>
/* eslint-disable */
import Echarts from 'vue-echarts'

export default {
  components: {
    Echarts,
  },
  data() {
    return {
      Options: {
        tooltip: {
          trigger: 'axis',
          formatter(params) {
            let res = params[0].name
            for (let i = 0, l = params.length; i < l; i++) {
              if (params[i].seriesType === 'line') {
                res += `<br/>${params[i].seriesName} : ${params[i].value ? params[i].value : '-'}%`
              } else {
                res += `<br/>${params[i].seriesName} : ${params[i].value ? params[i].value : '-'}次`
              }
            }
            return res
          },
        },
        grid: {
          bottom: 5,
          left: 10,
          right: 10,
          containLabel: true,
        },
        textStyle: {
          color: '#a9acae',
        },
        legend: {
          textStyle: {
            color: '#a9acae',
          },
          data: ['2016报警类型', '2017报警类型', '同比增长率'],
        },
        color: ['#5aa4d1', '#c43323', '#ffff00'],
        xAxis: [{
          type: 'category',
          data: ['离开指定区域', '进入指定区域', '紧急报警', '疲劳驾驶', '超速报警', '其他'],
          axisLabel: {
            rotate: 45,
          },
        }],
        yAxis: [{
          type: 'value',
          name: '次',
          min: 0,
          position: 'left',
          axisLabel: {
            formatter: '{value}',
          },
        }, {
          type: 'value',
          name: '',
          min: 0,
          max: 100,
          position: 'right',
          axisLabel: {
            formatter: '{value} %',
          },
        }],
        series: [{
          name: '2016报警类型',
          type: 'bar',
          yAxisIndex: 0,
          barMaxWidth: 10,
          label: {
            normal: {
              show: true,
              position: 'top',
            },
          },
          data: [22, 22, 23, 77, 24, 55],
        }, {
          name: '2017报警类型',
          type: 'bar',
          yAxisIndex: 0,
          barMaxWidth: 10,
          label: {
            normal: {
              show: true,
              position: 'top',
            },
          },
          data: [201, 222, 223, 777, 244, 255],
        }, {
          name: '同比增长率',
          type: 'line',
          yAxisIndex: 1,
          label: {
            normal: {
              show: true,
              position: 'top',
            },
          },
          lineStyle: {
            normal: {
              width: 2,
              shadowColor: 'rgba(0,0,0,0.4)',
              shadowBlur: 10,
              shadowOffsetY: 10,
            },
          },
          data: [1, 13, 37, 35, 15, 13],
        }],
      },
    }
  },
}
</script>
<style lang="scss" scoped>
.box{
    width: 450px;
    height: 200px;
    position: absolute;
    .echarts{
        width: 100%;
        height: 100%;
    }
}
</style>
