<template>
    <div class="box">
        <div class="box_item">
            <Echarts :options="TotalOptions" />
        </div>
        <div class="box_item">
            <Echarts :options="DealOptions" />
        </div>
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
      TotalOptions: {
        title: {
          text: '处理状态',
          left: '20px',
          top: 'center',
          textStyle: {
            fontSize: 14,
            color: '#67b8c1',
          },
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}: {c} ({d}%)',
        },
        legend: {
          orient: 'vertical',
          type: 'scroll',
          x: 'right',
          top: 'middle',
          textStyle: {
            color: '#fff',
          },
          pageTextStyle: {
            color: '#fff',
          },
          right: 10,
          data: [],
        },
        series: [
          {
            name: '',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '80%'],
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
          },
        ],
      },
      DealOptions: {
        title: {
          text: '已处理',
          left: '20px',
          top: 'center',
          textStyle: {
            fontSize: 14,
            color: '#67b8c1',
          },
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)',
        },
        legend: {
          orient: 'vertical',
          type: 'scroll',
          x: 'right',
          textStyle: {
            color: '#fff',
          },
          pageTextStyle: {
            color: '#fff',
          },
          right: 10,
          data: [],
        },
        series: [
          {
            name: '已处理',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '85%'],
            label: {
              normal: {
                show: false,
                position: 'inner',
              },
            },
            labelLine: {
              normal: {
                show: false,
              },
            },
            data: [],
          },
        ],
      },
    }
  },
  created() {
    /* eslint-disable*/
    const {handle_type,handled_details}=this.data
    this.TotalOptions.legend.data=handle_type.filter(o=>o.alarm_handle_name!='总条数' && o.alarm_handle_name!='已处理').map(item=>(item.alarm_handle_name))
    this.TotalOptions.series[0].data=handle_type.filter(o=>o.alarm_handle_name!='总条数' && o.alarm_handle_name!='已处理').map(item=>({
      name:item.alarm_handle_name,
      value:item.alarm_quantity_handled
    }))
    this.DealOptions.legend.data=handled_details.map(item=>item.alarm_measure_name)
    this.DealOptions.series[0].data=handled_details.map(item=>({
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
    position: relative;
    .box_item{
        height: 150px;
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
