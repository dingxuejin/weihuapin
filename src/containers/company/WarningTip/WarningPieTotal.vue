<template>
    <div class="box">
        <Echarts :options="Options" />
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
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)',
        },
        calculable: true,
        grid: {
          right: 30,
        },
        legend: {
          orient: 'vertical',
          type: 'scroll',
          x: 'right',
          top: 10,
          bottom: 20,
          textStyle: {
            color: '#fff',
          },
          pageTextStyle: {
            color: '#fff',
          },
          data: ['超速报警', '疲劳驾驶', '紧急报警', '进入指定区域', '离开指定区域', '其他', 'rose2', 'rose1'],
        },
        series: [
          {
            name: '车机报警',
            type: 'pie',
            radius: ['10%', '90%'],
            center: ['55%', '50%'],
            label: {
              show: false,
            },
            labelLine: {
              show: false,
            },
            roseType: 'area',
            max: 40,
            data: [
                { value: 5, name: 'rose1' },
                { value: 10, name: 'rose2' },
                { value: 15, name: '其他' },
                { value: 20, name: '离开指定区域' },
                { value: 25, name: '进入指定区域' },
                { value: 30, name: '紧急报警' },
                { value: 35, name: '疲劳驾驶' },
                { value: 40, name: '超速报警' },
            ],
          },
        ],
      },
    }
  },
}
</script>
<style lang="scss" scoped>
.box{
    width: 100%;
    height: 180px;
    position: absolute;
    bottom: 0px;
    .echarts{
        width: 100%;
        height: 100%;
    }
}
</style>

