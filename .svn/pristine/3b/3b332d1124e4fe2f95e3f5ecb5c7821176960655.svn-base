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
          formatter: '{a} <br/>{b}: {c} ({d}%)',
        },
        series: [
          {
            type: 'sunburst',
            radius: [0, '90%'],
            label: {
              rotate: 'radial',
            },
            data: [{
              name: '已处理',
              value: 50,
              children: [{
                name: '及时处理',
                value: 30,
                children: [{
                  name: '电话',
                  value: 10,
                }, {
                  name: '短信',
                  value: 20,
                }],
              }, {
                name: '超时处理',
                value: 20,
              }],
            }, {
              name: '未处理',
              value: 60,
            }],
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
    height: 200px;
    position: absolute;
    .echarts{
        width: 100%;
        height: 100%;
    }
}
</style>
