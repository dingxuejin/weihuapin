<template>
    <div class="box">
        <Echarts :options="Options" />
        <div class="total">总报警数:<span>{{total}}</span></div>
    </div>
</template>
<script>
import Echarts from 'vue-echarts'

export default {
  components: {
    Echarts,
  },
  props: ['data'],
  data() {
    return {
      total: 0,
      Options: {
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)',
        },
        series: [
          {
            name: '',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '55%'],
            label: {
              normal: {
                position: 'inner',
              },
            },
            labelLine: {
              normal: {
                show: false,
              },
            },
            data: [],
          }, {
            name: '已处理',
            type: 'pie',
            radius: ['65%', '85%'],
            data: [],
          },
        ],
      },
    }
  },
  created() {
    /* eslint-disable*/
    const {handle_type,handled_details}=this.data
    this.Options.series[0].data=handle_type.filter(o=>o.alarm_handle_name!='总条数' && o.alarm_handle_name!='已处理').map(item=>({
      name:item.alarm_handle_name,
      value:item.alarm_quantity_handled
    }))
    this.Options.series[1].data=handled_details.map(item=>({
      name:item.alarm_measure_name,
      value:item.alarm_quantity_handled
    }))
    this.total=handle_type.filter(o=>o.alarm_handle_name=='总条数')[0].alarm_quantity_handled
  }
}
</script>
<style lang="scss" scoped>
.box{
    width: 100%;
    height: 300px;
    position: relative;
    .echarts{
        width: 100%;
        height: 100%;
    }
    .total{
      position: absolute;
      text-align: right;
      top: -24px;
      right: 30px;
      color: #67b8c1;
      span{
        padding: 0 5px;
      }
    }
}
</style>
