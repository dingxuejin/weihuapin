<template>
  <div class="content">
    <Echarts :options="newOption"
             :theme="chartTheme"></Echarts>
    <div class="msgCon">
      <div class="ringMore-msgTitle">
      </div>
      <div class="ringMore-msgIndex">
      </div>
    </div>
  </div>

</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'ringMore',
  props: ['chartTheme', 'data', 'radius', 'color'],
  components: {
    Echarts,
  },
  computed: {
    newOption() {
      const option = this.chartOption
      option.color = this.color
      option.legend.data = this.data.map(item => item.name)
      option.series = [
        {
          type: 'pie',
          center: ['50%', '50%'],
          // radius: ["66.5%", "67%"],
          radius: this.radius[0],
          silent: true,
          hoverAnimation: false,
          label: {
            normal: {
              show: false,
            },
          },
          labelLine: {
            normal: {
              show: false,
            },
          },
          itemStyle: {
            normal: {
              color: '#b5b5b5',
            },
          },
          data: [0],
        },
      ]
      this.data.forEach((item, index) => {
        const seriesObj = {
          name: this.data[index].name,
          type: 'pie',
          center: ['50%', '50%'],
          radius: this.radius[index + 1],
          avoidLabelOverlap: false,
          label: {
            normal: {
              show: false,
              position: 'center',
            },
            emphasis: {
              show: false,
              formatter(params) {
                // return '{gray|'+params.name+'}\n\n'+'{white|'+params.percent+'%}'
                return `{white|${params.percent}%}`
              },
              rich: {
                gray: {
                  color: '#ccc',
                  fontSize: 20,
                },
                white: {
                  color: '#fff',
                  fontSize: 30,
                  fontWeight: 'bold',
                },
              },
            },
          },
          labelLine: {
            normal: {
              show: false,
            },
          },
          hoverAnimation: false,
          data: [
            {
              name: this.data[index].name,
              value: this.data[index].ry_num,
            },
            {
              name: 'invisible',
              value: this.data[index].total - this.data[index].ry_num,
              silent: true,
              itemStyle: {
                normal: {
                  color: 'rgba(0,0,0,0)',
                  label: {
                    show: false,
                  },
                  labelLine: {
                    show: false,
                  },
                },
                emphasis: {
                  show: false,
                },
              },
              tooltip: {
                show: false,
              },
              cursor: 'arrow',
            },
          ],
        }

        option.series.push(seriesObj)
        // end
      })
      return option
    },
  },
  data() {
    // const radius = this.radius
    return {
      /*eslint-disable*/
      chartOption: {
        legend: {
          show: false,
          type: 'scroll',
          pageTextStyle: {
            color: '#fff',
          },
          right: "2%",
          bottom: "5%",
          orient: "vertical",
          silent: true,
          textStyle: {},
          data: []
        },
        tooltip: {
          show: false
        },
        series:[],
      }
    }
  },

  mounted() {
    const chartData = this.$options.propsData.data;

    const msgTitle = document.getElementsByClassName("ringMore-msgTitle")[0];
    const msgIndex = document.getElementsByClassName("ringMore-msgIndex")[0];
    const percent1 = `${(
      chartData[0].ry_num /
      chartData[0].total *
      100
    ).toFixed(1)}%`;
    const percent2 = `${(
      chartData[1].ry_num /
      chartData[1].total *
      100
    ).toFixed(1)}%`;

    msgTitle.innerText = chartData[0].name;
    msgIndex.innerText = percent1;

    const chart = this.$children["0"].chart;
    chart.on("mouseover", params => {
      if (params.dataIndex != 1) {
        // console.log(params.name,params.value,params.percent);
        msgTitle.innerText = params.name;
        msgIndex.innerText = `${params.percent}%`;
      }
    });

    const chartCon = this.$el;
    chartCon.onmouseout = function() {
      msgTitle.innerText = chartData[0].name;
      msgIndex.innerText = percent1;
    };
  }
};
</script>

<style lang="scss" scoped>
.content {
  width: 100%;
  height: 100%;
  position: relative;

  /*background: green;*/
}

.echarts {
  width: 100%;
  height: 100%;
}

/* msgCon */
.msgCon {
  width: 30%;
  height: 20%;
  overflow: hidden;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /*background: red;*/
  /*border:1px solid red;*/
}

.ringMore-msgTitle {
  width: 100%;
  position: absolute;
  top: 0;
  color: #b5b5b5;
  font-size: 20px;
  /*background: green;*/
}

.ringMore-msgIndex {
  width: 100%;
  position: absolute;
  bottom: 0;
  color: #fff;
  font-size: 30px;
  font-weight: bold;
  /*background: pink;*/
}
</style>