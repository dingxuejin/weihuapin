<template>
  <div id="companyCarStatusMap">
  </div>
</template>

<script>
import 'echarts/extension/bmap/bmap'
import bmapStyle from '../../../assets/mapStyle/mapStyle.json'

export default {
  name: 'companyCarStatusMap',
  props: ['data'],
  data() {
    return {}
  },
  watch: {
    data: {
      handler() {
        this.drawchart()
      },
      deep: true,
    },
  },
  methods: {
    drawchart() {
      // let chartData = this.data
      // console.log('shuju', chartData)
      // let legendArr = (function (chartData) {
      //   let arr = []
      //   chartData.forEach(function (item) {
      //     // console.log(item.currentStatus)
      //     if (arr.indexOf(item.currentStatus) === -1) {
      //       arr.push(item.currentStatus)
      //     }
      //   })
      //   return arr
      // })(this.data)
      // console.log('legend', legendArr)

      const unloadData = this.data.filter(item => item.currentStatus === '待卸车')
      const entruckingData = this.data.filter(item => item.currentStatus === '待装车')
      const offlineData = this.data.filter(item => item.currentStatus === '离线')

      const myChart = this.$echarts.init(
        document.getElementById('companyCarStatusMap'),
      )
/*eslint-disable*/
      const option = {
        tooltip: {
          show: true,
          formatter(params) {
            return (
              `${'<div class="tooltipContainer"><div class="tooltipContent">' +
              '<div class="items"><div class="itemsContent"><div class="itemTitle">当前状态</div><div class="itemIndex">'}${
              params.data.currentStatus
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">牵引车牌</div><div class="itemIndex">${
              params.data.qyCarId
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">挂车牌</div><div class="itemIndex">${
              params.data.gCarId
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">配送商</div><div class="itemIndex">${
              params.data.facilitator
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">驾驶员</div><div class="itemIndex">${
              params.data.driver
              }</div>` +
              '<div class="driverPhone">17733697669</div>' +
              '</div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>' +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">运单编号</div><div class="itemIndex">${
              params.data.orderNum
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">气源地</div><div class="itemIndex">${
              params.data.gasSource
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">货物名称</div><div class="itemIndex">${
              params.data.goodsType
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">时间</div><div class="itemIndex">${
              params.data.time
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">速度</div><div class="itemIndex">${
              params.data.speed
              }km/h</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">位置</div><div class="itemIndex">${
              params.data.position
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              '<div class="btn fr">车辆基本信息</div>' +
              '</div></div>'
            )
          },
        },
        legend: {
          orient: 'vertical',
          top: 'top',
          left: 'right',
          align: 'left',
          itemWidth: 48,
          itemHeight: 40,
          data: [
            {
              name: '待卸车',
              icon: `image://${require('../../../assets/chartsImg/loaded_show.png')}`,
            },
            {
              name: '待装车',
              icon: `image://${require('../../../assets/chartsImg/underloaded_show.png')}`,
            },
            {
              name: '离线',
              icon: `image://${require('../../../assets/chartsImg/offline_show.png')}`,
            },
          ],
          textStyle: {
            color: '#fff',
            fontSize: 18,
          },
        },
        bmap: {
          center: [110, 39],
          zoom: 5,
          roam: true,
          mapStyle: {
            styleJson: bmapStyle,
          },
        },
        series: [
          {
            type: 'scatter',
            name: '待卸车',
            coordinateSystem: 'bmap',
            label: {
              normal: {
                formatter: '{b}',
                position: 'right',
                show: false,
              },
              emphasis: {
                show: false,
              },
            },
            itemStyle: {
              normal: {
                color: '#ddb926',
              },
            },
            data: unloadData,
            // data: unloadData.map(function (item) {
            //   // item.symbol = 'image://' + require('../../../assets/chartsImg/loaded.png')
            //   item.symbol = 'image://' + require('../../../assets/chartsImg/underloaded_show.png')
            //   item.symbolSize = [32, 24]
            //   console.log(item)
            // })
          },
          {
            type: 'scatter',
            name: '待装车',
            coordinateSystem: 'bmap',
            label: {
              normal: {
                formatter: '{b}',
                position: 'right',
                show: false,
              },
              emphasis: {
                show: false,
              },
            },
            itemStyle: {
              normal: {
                color: '#ddb926',
              },
            },
            data: entruckingData,
          },
          {
            type: 'scatter',
            name: '离线',
            coordinateSystem: 'bmap',
            label: {
              normal: {
                formatter: '{b}',
                position: 'right',
                show: false,
              },
              emphasis: {
                show: false,
              },
            },
            itemStyle: {
              normal: {
                color: '#ddb926',
              },
            },
            data: offlineData,
          },
        ],

      }

      myChart.setOption(option)
    },
  },

  mounted() {
    this.drawchart()
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
#companyCarStatusMap {
  width: 100%;
  height: 100%;
  overflow: hidden;
  /* border: 1px solid red; */
  .tooltipContainer {
    width: 500px;
    height: 600px;
    overflow: hidden;
    border: 2px solid #05d0eb;
    background: rgba(9, 10, 11, 0.9);
    // 内容部分
    .tooltipContent {
      width: calc(100% - 20px);
      height: 100%;
      overflow: hidden;
      margin-left: 10px;
      // border:1px solid red;
      // background:pink;
      //items
      .items {
        width: 100%;
        height: 50px;
        overflow: hidden;
        // background:green;
        // itemsTitleContent
        .itemsTitleContent {
          // height:48px;
          height: calc(100% - 2px);
          overflow: hidden;
          font-size: 24px;
          color: #fff;
          line-height: 48px;
        }
        .itemsContent {
          // height:48px;
          height: calc(100% - 2px);
          overflow: hidden;
          font-size: 16px;
          color: #fff;
          line-height: 48px;
          position: relative;
          // title
          .itemTitle {
            float: left;
            // background: red;
          }
          // index
          .itemIndex {
            position: absolute;
            left: 130px;
            top: 0;
            color: #05d0eb;
            font-size: 24px;
            font-weight: bold;
            // background: green;
          }
          .itemOrderNum {
            font-size: 20px;
            font-weight: normal;
          }
          .driverPhone {
            position: absolute;
            left: 220px;
            top: 0px;
            color: #05d0eb;
            font-size: 24px;
            font-weight: bold;
            // background:red;
          }
          // unit
          .trafficMileageUnit {
            position: absolute;
            right: 0px;
            top: 15px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
            // background: red;
          }
          .orderNumUnit {
            position: absolute;
            left: 180px;
            top: 10px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
            // background: red;
          }
        }
        .itemsBorder {
          height: 2px;
          // background: orange;
          div:nth-child(odd) {
            width: 10px;
            height: 100%;
            overflow: hidden;
            float: left;
            background: #81d9e5;
          }
          div:nth-child(even) {
            width: calc(100% - 20px);
            height: 100%;
            overflow: hidden;
            float: left;
            background: rgba(129, 217, 229, 0.5);
          }
        }
      }
    }

    // 弹窗按钮
    .btn {
      width: 200px;
      height: 30px;
      overflow: hidden;
      margin-top: 10px;
      color: #b5b5b5;
      text-align: center;
      line-height: 30px;
      background: rgba(0, 91, 127, 0.5);
      cursor: pointer;
    }
    .btn:active {
      color: #fff;
      background: rgba(0, 91, 127, 1);
    }
  }
}
</style>
