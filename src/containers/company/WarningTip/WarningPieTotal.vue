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
  props: ['data', 'name'],
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
          data: [],
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
            data: [],
          },
        ],
      },
    }
  },
  watch: {
    data() {
      this.Options.legend.data = this.data.map(o => o.name)
      this.Options.series[0].data = this.data
      this.Options.series[0].name = this.name || '车机报警'
      this.Options.series[0].max = this.data[this.data.length - 1]
    },
  },
  created() {
    this.Options.legend.data = this.data.map(o => o.name)
    this.Options.series[0].data = this.data
    this.Options.series[0].name = this.name || '车机报警'
    this.Options.series[0].max = this.data[this.data.length - 1]
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

