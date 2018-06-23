<template>
  <div class="carx">
    <amessage class="amessage_wrap">
      <aheader slot='header'
               name='车辆信息'
               @click='$router.push("/car")'></aheader>
      <aCarPeople slot='content'
                  :data='acar'
                  :data1='carMsg'
                  @up='selectTitle'>
        <!-- 图表 -->
        <div class="carMsgSunburst">
          <sunburst chartTheme="dark"
                    :data="carMsg"
                    :color="sunburstColor"
                    class="carMsgSunburstChart"></sunburst>
        </div>
      </aCarPeople>
    </amessage>
    <div class="carz"
         @click='popshow'>车载终端安装比例</div>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import amessage from '../../../components/company/amessage'
import aheader from '../../../components/company/aheader'
import aCarPeople from '../../../components/company/aCarPeople'
import sunburst from '../../../components/charts/sunburst'

export default {
  components: {
    amessage,
    aheader,
    aCarPeople,
    sunburst,
  },
  computed: {
    ...mapState('carMsgStore', ['carMsg']),
    ...mapState('headerMsgStore', ['selectedEntity']),
  },
  methods: {
    ...mapActions('carMsgStore', ['getCarMsg']),
    fetchData() {
      this.getCarMsg({
        entity_id: this.selectedEntity,
        // entity_id: 1310000010010000,
        type: this.type,
      })
    },
    selectTitle(i) {
      this.type = this.acar[i]
      this.fetchData()
    },
    popshow() {
      this.show = !this.show
      this.$emit('up')
    },
  },
  data() {
    return {
      show: false,
      acar: [
        '车辆类型',
        '车辆品牌',
        '使用年限',
        '燃油类型',
        '运力单位',
        '车辆归属',
      ],
      cardata1: ['小于3年', '3-8年', '大于8年'],
      cardata2: [104, 467, 114],
      sunburstColor: [
        'rgb(5, 208, 235)',
        'rgb(129, 180, 223)',
        'rgb(255, 203, 246)',
        'rgb(231, 80, 41)',
        'rgb(0, 252, 155)',
        'rgb(88, 0, 106)',
        'rgb(78, 106, 0)',
      ],
      type: '车辆类型',
    }
  },
}
</script>

<style lang="scss" scoped>
.carx {
  position: relative;
  height: 250px;
  .carz {
    position: absolute;
    width: 160px;
    height: 25px;
    color: #b5b5b5;
    text-align: center;
    line-height: 25px;
    background: rgba(0, 91, 127, 0.5);
    right: 0;
    top: 78px;
    cursor: pointer;
  }
  .carz:hover {
    color: #ffffff;
    background: rgba(0, 91, 127, 1);
  }
  .amessage_wrap {
    .carMsgSunburst {
      width: 170px;
      height: 170px;
      position: relative;
      .carMsgSunburstChart {
        width: 170px;
        height: 170px;
      }
    }
  }
}
</style>
