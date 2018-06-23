<template>
  <div>
    <amessage>
      <aheader slot='header'
               name='企业经营情况'
               @click='$router.push("/manage")'></aheader>
      <amanage slot='content'
               @select='selectAll'>
        <!-- <line-double-axis slot='turnover'
                          :data='manageStateTurnover'
                          :color='lineDoubleAxisColor'
                          :dataZoom=false
                          :property='property'
                          yaxisNameL='量'
                          yaxisNameR='%'
                          chartTheme='dark'
                          v-if="manageStateTurnover"></line-double-axis> -->
        <loading :data="getChartWaybillData"
                 slot='waybill'>
          <line-double-axis :data='getChartWaybillData'
                            :color='lineDoubleAxisColor'
                            :dataZoom=false
                            :property='propertyWaybill'
                            yaxisNameL='量'
                            yaxisNameR='%'
                            chartTheme='dark'></line-double-axis>
        </loading>
        <loading :data="getChartTurnoverData"
                 slot='turnover'>
          <line-double-axis :data='getChartTurnoverData'
                            :color='lineDoubleAxisColor'
                            :dataZoom=false
                            :property='propertyTurnOver'
                            yaxisNameL='量'
                            yaxisNameR='%'
                            chartTheme='dark'></line-double-axis>
        </loading>
        <!-- <loading :data='manageStateTurnover'></loading> -->
        <!-- <loading :data='manageStateWaybill'></loading> -->
        <!-- <div  v-show='false'>{{selectedEntity}}</div> -->
      </amanage>
    </amessage>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import amessage from '../../../components/company/amessage'
import aheader from '../../../components/company/aheader'
import amanage from '../../../components/company/amanage'
import lineDoubleAxis from '../../../components/charts/lineDoubleAxis'

export default {
  components: {
    amessage,
    aheader,
    amanage,
    lineDoubleAxis,
  },
  computed: {
    ...mapState('manageMsgStore', [
      'manageStateWaybill',
      'manageStateTurnover',
    ]),
    ...mapState('headerMsgStore', ['selectedEntity']),
    propertyWaybill() {
      return [
        {
          name: '运单量',
          type: 'bar',
          axis: 0,
        },
        {
          name: '运单量环比',
          type: 'line',
          axis: 1,
        },
        {
          name: '运单量同比',
          type: 'line',
          axis: 1,
        },
      ]
    },
    propertyTurnOver() {
      return [
        {
          name: '周转量',
          type: 'bar',
          axis: 0,
        },
        {
          name: '周转量环比',
          type: 'line',
          axis: 1,
        },
        {
          name: '周转量同比',
          type: 'line',
          axis: 1,
        },
      ]
    },
    // 获取chart数据
    getChartWaybillData() {
      if (this.manageStateWaybill) {
        // console.log('this.getChartWaybillData', this.manageStateWaybill)
        return this.manageStateWaybill
      }
      return null
    },
    getChartTurnoverData() {
      if (this.manageStateTurnover) {
        // console.log('this.manageStateTurnover', this.manageStateTurnover)
        return this.manageStateTurnover
      }
      return null
    },
    // 设置参数
    getQueryParams() {
      // console.log('selectedEntity', this.selectedEntity)
      return {
        // entity_id: this.selectedEntity,
        // entity_id: 1310000010000000,
        entity_id: this.selectedEntity,
        year: this.yearValue,
        // month: this.monthValue,
      }
    },
  },
  methods: {
    ...mapActions('manageMsgStore', [
      'getManageStateWaybill',
      'getMangeStateTurnover',
    ]),
    selectAll({ year, type }) {
      // console.log('getQueryParams', this.getQueryParams)
      if (type === 'Y') {
        this.yearValue = year
      }
      // if (type === 'M') {
      //   this.monthValue = month
      // }

      this.getManageStateWaybill(this.getQueryParams)
      this.getMangeStateTurnover(this.getQueryParams)
    },
  },
  data() {
    return {
      yearValue: '',
      monthValue: '',
      lineDoubleAxisColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
    }
  },
  // mounted() {
  //   this.getManageStateWaybill(this.getQueryParams)
  //   this.getMangeStateTurnover(this.getQueryParams)
  // },
}
</script>
