<template>
  <car-maintenance-repaire :clbyxxData='clbyxxData'
                           :clwxxxData='clwxxxData'
                           :clbxjcData='clbxjcData'
                           :ylrqgtjcData='ylrqgtjcData'
                           @openDetails="openDetailsPopup">

    <!-- 详情弹出框:保养信息 -->
    <div class="maintenanceDetailsPopupWrap"
         slot="maintenancedetail"
         v-if='maintenanceDetailsPopupShow'
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetailsPopupShow'>
        <pop-up-widget title="保养信息"
                       :detailsBtnShow='false'></pop-up-widget>
        <!-- 详情内容 -->
        <div class="detailsContentWrap">
          <!-- 详情btn -->
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_on:!chartShow}"
                 @click="getDetails(1)">年度保养次数耗时统计</div>
            <div class="title"
                 :class="{box_on:chartShow}"
                 @click="getDetails(2)">年度保养次数费用统计</div>
          </div>
          <!-- 切换内容：年度保养次数费用统计 -->
          <div class="costStatisticsWrap"
               v-if="chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisCostData"
                            :color="lineDoubleAxisColor"
                            :dataZoom=false
                            :property="lineDoubleCostProperty"
                            yaxisNameL="费用(元)"
                            yaxisNameR="次数(次)"
                            v-if="lineDoubleAxisCostData"></lineDoubleAxis>
            <Loading :data='lineDoubleAxisCostData'></Loading>
            <!-- 调用数据 -->
            <div v-show="false">{{getMaintenanceCostData}}</div>
          </div>
          <!-- 切换内容：年度保养次数耗时统计 -->
          <div class="TimeConsumingStatisticsWrap"
               v-if="!chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisTimeData"
                            :color="lineDoubleAxisColor"
                            :dataZoom=false
                            :property="lineDoubleTimeProperty"
                            yaxisNameL="耗时(小时)"
                            yaxisNameR="次数(次)"
                            v-if="lineDoubleAxisTimeData"></lineDoubleAxis>
            <Loading :data='lineDoubleAxisTimeData'></Loading>
            <!-- 调用数据 -->
            <div v-show="false">{{getMaintenanceTimeData}}</div>
          </div>
          <!-- 累计保养信息 -->
          <div class="CumulativeMaintenanceInfoWrap">
            <pop-up-widget title="累计保养信息"
                           :detailsBtnShow='false'></pop-up-widget>
            <div class="CumulativeMaintenanceInfo clearfix">
              <div class="item">
                <div class="insuranceTitle">累计保养次数</div>
                <div class="insuranceData"
                     v-if="maintainInfomationData">{{qf(maintainInfomationData.accumulate['sum(maintain_times)']||'')}}</div>
              </div>
              <div class="item">
                <div class="insuranceTitle">累计保养费用</div>
                <div class="insuranceData"
                     v-if="maintainInfomationData">{{qf(maintainInfomationData.accumulate['sum(maintain_cost)']||'')}}</div>
              </div>
              <div class="item last">
                <div class="insuranceTitle">累计保养耗时(小时)</div>
                <div class="insuranceData"
                     v-if="maintainInfomationData">{{qf(maintainInfomationData.accumulate['sum(maintain_time_consumed)']||'')}}</div>
              </div>
            </div>
          </div>
        </div>
      </pop-up-frame>
    </div>

    <!-- 详情弹出框:维修信息 -->
    <div class="repaireDetailsPopupWrap"
         slot="repairedetails"
         v-if='repaireDetailsPopupShow'
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetailsPopupShow'>
        <!-- 车辆维修记录 -->
        <pop-up-widget title="车辆维修记录"
                       :detailsBtnShow='false'></pop-up-widget>
        <!-- 车辆维修记录:详细内容 -->
        <div class="repaireRecordDetailsContentWrap clearfix">
          <div class="detailsContent">
            <div class="titleWrap">
              <div class="repaireRecordtitle">维修时间</div>
              <div class="repaireRecordtitle">维修类型</div>
              <div class="repaireRecordtitle">维修费用</div>
              <div class="repaireRecordtitle">维修厂商</div>
              <div class="repaireRecordtitle">送修人</div>
              <div class="repaireRecordtitle">送修人联系电话</div>
              <div class="repaireRecordtitle">里程</div>
            </div>
            <div class="detailListWrap">
              <ul v-if="repairRecordData">
                <li v-for="(o,index) in repairRecordData"
                    :key=index>
                  <ul>
                    <li>{{o.repair_date}}</li>
                    <li>{{o.wxlx.repaire_type}}</li>
                    <li>{{o.repair_cost}}</li>
                    <li>{{o.partner_id}}</li>
                    <li>{{o.repair_director}}</li>
                    <li>{{Number(o.phone_number)}}</li>
                    <li>{{o.current_km}}</li>
                  </ul>
                </li>
              </ul>
              <loading :data="repairRecordData"></loading>
            </div>
          </div>
        </div>

        <pop-up-widget title="车辆维修统计信息"
                       :detailsBtnShow='false'></pop-up-widget>

        <!-- 车辆维修统计信息:详情内容 -->
        <div class="detailsStatisticsContentWrap">
          <!-- 详情btn -->
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_on:!chartShow}"
                 @click="getDetails(1)">年度维修次数耗时统计</div>
            <div class="title"
                 :class="{box_on:chartShow}"
                 @click="getDetails(2)">年度维修次数费用统计</div>
          </div>
          <!-- 切换内容：年度保养次数费用统计 -->
          <div class="costStatisticsWrap"
               v-if="chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisRepaireCostData"
                            :color="lineDoubleAxisColor"
                            :dataZoom=false
                            :property="lineDoubleRepaireCostProperty"
                            yaxisNameL="费用(元)"
                            yaxisNameR="次数(次)"
                            v-if="lineDoubleAxisRepaireCostData"></lineDoubleAxis>
            <Loading :data='lineDoubleAxisRepaireCostData'></Loading>
            <!-- 调用数据 -->
            <div v-show="false">{{getRepaireCostData}}</div>

          </div>
          <!-- 切换内容：年度保养次数耗时统计 -->
          <div class="TimeConsumingStatisticsWrap"
               v-if="!chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisRepaireTimeData"
                            :color="lineDoubleAxisColor"
                            :dataZoom=false
                            :property="lineDoubleRepaireTimeProperty"
                            yaxisNameL="耗时(次)"
                            yaxisNameR="次数(次)"
                            v-if="lineDoubleAxisRepaireTimeData"></lineDoubleAxis>
            <Loading :data='lineDoubleAxisRepaireTimeData'></Loading>
          </div>
          <!-- 累计维修信息 -->
          <div class="CumulativeMaintenanceInfoWrap">
            <pop-up-widget title="累计维修信息"
                           :detailsBtnShow='false'></pop-up-widget>
            <div class="CumulativeMaintenanceInfo clearfix">
              <div class="item">
                <div class="rerpaireTitle">累计维修次数</div>
                <div class="repaireData"
                     :class="{box_red:repaireCostChangeColor}"
                     v-if="repairStatisticsData">{{repairStatisticsData.accumalate[0]['sum(repair_times)']||''}}</div>
              </div>
              <div class="item">
                <div class="rerpaireTitle">累计维修费用</div>
                <div class="repaireData"
                     :class="{box_red:repaireCostChangeColor}"
                     v-if="repairStatisticsData">{{qf(repairStatisticsData.accumalate[0]['sum(repair_cost)']||'')}}</div>
              </div>
              <div class="item last">
                <div class="rerpaireTitle">累计维修耗时(小时)</div>
                <div class="repaireData"
                     :class="{box_red:repaireCostChangeColor}"
                     v-if="repairStatisticsData">{{qf(repairStatisticsData.accumalate[0]['sum(repair_time_consumed)']||'')}}</div>
              </div>
            </div>
          </div>
          <!-- 调用数据 -->
          <div v-show="false">{{getRepaireTimeData}}</div>
        </div>
      </pop-up-frame>
    </div>

    <!-- 详情弹出框:检测信息 -->
    <div class="detectionDetailsPopupWrap"
         slot="detectiondetails"
         v-if='detectionDetailsPopupShow'
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetailsPopupShow'>
        <pop-up-widget title="检测信息"
                       :detailsBtnShow='false'></pop-up-widget>
        <div class="slecteDateWrap clearfix">
          <div class="title">统计周期</div>
          <div class="date">
            <key-value-select width="100px"
                              :data="years"
                              @up="selectYear_detection"></key-value-select>
          </div>
        </div>
        <div class="detailsContentBorderFrame clearfix">
          <div class="detailsContent">
            <div class="titleWrap clearfix">
              <div class="title">检测时间</div>
              <div class="title">检测类别</div>
              <div class="title">检测机构</div>
              <div class="title">送检人</div>
              <div class="title">送检人联系电话</div>
              <div class="title">检测费用</div>
              <div class="title">检测结果</div>
              <div class="title">下次检测时间</div>
            </div>
            <div class="detailListWrap">
              <ul v-if="testInformationData"
                  class="totalItemWrap">
                <li v-for="(o,index) in testInformationData"
                    :key=index
                    class="rowWrap">
                  <ul class="colWrap">
                    <li class="itemData">{{o.test_date}}</li>
                    <li class="itemData decType"
                        :title="o.cljclx.detection_type">{{o.cljclx.detection_type}}</li>
                    <li class="itemData decAgency"
                        :title="o.test_agency">{{o.test_agency}}</li>
                    <li class="itemData">{{o.test_director}}</li>
                    <li class="itemData">{{Number(o.phone_number)}}</li>
                    <li class="itemData">{{o.test_cost}}</li>
                    <li class="itemData">{{o.gtjcjg.inspect_result}}</li>
                    <li class="itemData">{{o.next_test_date}}</li>
                  </ul>
                </li>
              </ul>
              <loading :data="testInformationData"></loading>
            </div>
          </div>
        </div>
      </pop-up-frame>
    </div>
    <div v-show="false">{{getTestInformationData}}</div>
    <!-- 详情弹出框:保险信息 -->
    <div class="insuranceDetailsPopupWrap"
         slot="detailsWrap"
         v-if='insuranceDetailsPopupShow'
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetailsPopupShow'>
        <pop-up-widget title="车辆投保记录"
                       :detailsBtnShow='false'></pop-up-widget>
        <div class="detailsContent">
          <div class="titleWrap">
            <div class="title">年度</div>
            <div class="title">投保机构</div>
            <div class="title">保单编号</div>
            <div class="title">保单到期日期</div>
            <div class="title">保险类型</div>
            <div class="title">保费金额</div>
            <div class="title">投保区域</div>
          </div>
          <div class="detailListWrap">
            <ul v-if="insuranceRecordData">
              <li v-for="(o,index) in insuranceRecordData"
                  :key=index>
                <ul>
                  <li>{{o.year}}</li>
                  <li :title="o.insurance_agency">{{o.insurance_agency}}</li>
                  <li :title="o.insurance_number">{{o.insurance_number}}</li>
                  <li>{{o.insurance_end_date}}</li>
                  <li>{{o.bxlx.insurance_type}}</li>
                  <li>{{o.insurance_cost}}</li>
                  <li>{{o.qy_qyfb.region_scope_name}}</li>
                </ul>
              </li>
            </ul>
            <loading :data="insuranceRecordData"></loading>
          </div>
        </div>
        <pop-up-widget title="车辆出险记录"
                       :detailsBtnShow='false'
                       class="mainTitleBorder"></pop-up-widget>
        <div class="slecteDateWrap clearfix">
          <div class="title">统计周期</div>
          <div class="date">
            <key-value-select width="100px"
                              :data="years"
                              @up="selectYear_record"></key-value-select>
          </div>
        </div>
        <div class="detailsContent">
          <div class="titleWrap">
            <div class="title">保单编号</div>
            <div class="title">出险时间</div>
            <div class="title">出险金额</div>
            <div class="title">出险类型</div>
            <div class="title">出险原因</div>
            <div class="title">责任人</div>
            <div class="title">责任人联系电话</div>
          </div>
          <div class="detailListWrap">
            <ul v-if="lossAdviseData">
              <li v-for="(o,index) in lossAdviseData"
                  :key=index>
                <ul>
                  <li>{{o.insurance_number}}</li>
                  <li>{{o.insurance_claim_date}}</li>
                  <li>{{o.insurance_claim_cost}}</li>
                  <li>{{o.bxlx.insurance_type}}</li>
                  <li>{{o.insurance_claim_cause}}</li>
                  <li>{{o.responsible_person}}</li>
                  <li>{{parseInt(o.phone_number)}}</li>
                </ul>
              </li>
            </ul>
            <loading :data="lossAdviseData"></loading>
          </div>
        </div>
        <div v-show="false">{{getlossAdviseData}}</div>
        <pop-up-widget title="出险次数统计信息"
                       :detailsBtnShow='false'
                       class="mainTitleBorder"></pop-up-widget>
        <div class="slecteDateWrap clearfix">
          <div class="title">统计周期</div>
          <div class="date">
            <key-value-select width="100px"
                              :data="years"
                              @up="selectYear_count"></key-value-select>
          </div>
        </div>

        <div class="insuranceCountWrap clearfix">
          <div class="insuranceCountItem">
            <div class="item">
              <div class="title">年度出险次数</div>
              <div class="data"
                   v-if="lossAdviseCountData">{{lossAdviseCountData[0].yearly_insurance_claim_times}}</div>
            </div>
            <div class="item clearMarginRight">
              <div class="title">累计出险次数</div>
              <div class="data"
                   v-if="lossAdviseCountData">{{lossAdviseCountData[0].total_insurance_claim_times}}</div>
            </div>
          </div>
          <!-- btn -->
          <div class="prevBtn"></div>
          <div class="nextBtn"></div>
        </div>
      </pop-up-frame>
    </div>
  </car-maintenance-repaire>
</template>
<script>
import _ from 'lodash'
import { mapState, mapActions } from 'vuex'
import CarMaintenanceRepaire from '@/components/car/CarMaintenanceRepaire'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'
import lineDoubleAxis from '@/components/charts/lineDoubleAxis'
import KeyValueSelect from '@/components/KeyValueSelect'
import xxx from '../../../util/dictionary'

export default {
  components: {
    CarMaintenanceRepaire,
    PopUpFrame,
    PopUpWidget,
    xxx,
    lineDoubleAxis,
    KeyValueSelect,
  },
  props: [''],
  data() {
    return {
      move: false,
      years: [...xxx.date.year],
      maintenanceDetailsPopupShow: false,
      repaireDetailsPopupShow: false,
      detectionDetailsPopupShow: false,
      insuranceDetailsPopupShow: false,
      chartShow: true,
      lineDoubleAxisColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      lineDoubleAxisCostData: null,
      lineDoubleCostProperty: null,
      lineDoubleTimeProperty: null,
      lineDoubleAxisTimeData: null,

      lineDoubleAxisRepaireCostData: null,
      lineDoubleRepaireCostProperty: null,
      lineDoubleRepaireTimeProperty: null,
      lineDoubleAxisRepaireTimeData: null,

      // 车辆出险记录
      lossAdviseRecordData: null,
      yearValue: null,
    }
  },
  computed: {
    ...mapState('carMaintenanceRepaireContainer', [
      'clbyxxData',
      'clwxxxData',
      'clbxjcData',
      'ylrqgtjcData',
      'maintainInfomationData',
      'repairRecordData',
      'repairStatisticsData',
      'insuranceRecordData',
      'lossAdviseData',
      'testInformationData',
      'lossAdviseCountData',
    ]),
    ...mapState('carModelsSearchContainer', [
      'cljcxxData',
      'fuelCost',
      'vehicle_id',
    ]),
    // 保险
    getMaintenanceCostData() {
      if (this.maintainInfomationData) {
        this.lineDoubleCostProperty = [
          {
            name: this.maintainInfomationData.cost[0].name,
            type: 'bar',
            axis: 0,
          },
          {
            name: this.maintainInfomationData.cost[1].name,
            type: 'line',
            axis: 1,
          },
        ]
        //  年度保养次数费用统计
        this.lineDoubleAxisCostData = [
          {
            name: this.maintainInfomationData.cost[0].name,
            data: this.maintainInfomationData.cost[0].data,
          },
          {
            name: this.maintainInfomationData.cost[1].name,
            data: this.maintainInfomationData.cost[1].data,
          },
        ]
        // console.log('年度保养次数费用统计', JSON.stringify(this.lineDoubleAxisCostData))
      }
      return null
    },
    getMaintenanceTimeData() {
      if (this.maintainInfomationData) {
        this.lineDoubleTimeProperty = [
          {
            name: this.maintainInfomationData.time[0].name,
            type: 'bar',
            axis: 0,
          },
          {
            name: this.maintainInfomationData.time[1].name,
            type: 'line',
            axis: 1,
          },
        ]
        //  年度保养次数耗时统计
        this.lineDoubleAxisTimeData = [
          {
            name: this.maintainInfomationData.time[0].name,
            data: this.maintainInfomationData.time[0].data,
          },
          {
            name: this.maintainInfomationData.time[1].name,
            data: this.maintainInfomationData.time[1].data,
          },
        ]
        // console.log('年度保养次数耗时统计', JSON.stringify(this.lineDoubleAxisTimeData))
      }
      return null
    },
    // 维修
    getRepaireCostData() {
      if (this.repairStatisticsData) {
        this.lineDoubleRepaireCostProperty = [
          {
            name: this.repairStatisticsData.cost[0].name,
            type: 'bar',
            axis: 0,
          },
          {
            name: this.repairStatisticsData.cost[1].name,
            type: 'line',
            axis: 1,
          },
        ]
        this.lineDoubleAxisRepaireCostData = [
          {
            name: this.repairStatisticsData.cost[0].name,
            data: this.repairStatisticsData.cost[0].data,
          },
          {
            name: this.repairStatisticsData.cost[1].name,
            data: this.repairStatisticsData.cost[1].data,
          },
        ]
        // console.log('年度保养次数费用统计', JSON.stringify(this.lineDoubleAxisRepaireCostData))
      }
      return null
    },
    getRepaireTimeData() {
      if (this.repairStatisticsData) {
        this.lineDoubleRepaireTimeProperty = [
          {
            name: this.repairStatisticsData.time[0].name,
            type: 'bar',
            axis: 0,
          },
          {
            name: this.repairStatisticsData.time[1].name,
            type: 'line',
            axis: 1,
          },
        ]
        this.lineDoubleAxisRepaireTimeData = [
          {
            name: this.repairStatisticsData.time[0].name,
            data: this.repairStatisticsData.time[0].data,
          },
          {
            name: this.repairStatisticsData.time[1].name,
            data: this.repairStatisticsData.time[1].data,
          },
        ]
        // console.log('年度保养次数耗时统计', JSON.stringify(this.lineDoubleAxisRepaireTimeData))
      }
      return null
    },
    getlossAdviseData() {
      if (this.cljcxxData) {
        this.getcarLossAdvise({
          vehicleId: this.cljcxxData.vehicle_id,
          year: this.years[0].value,
        })
      }
      return null
    },
    getTestInformationData() {
      if (this.cljcxxData) {
        this.getcarTestInformation({
          vehicleId: this.cljcxxData.vehicle_id,
          testDate: this.years[0].value,
        })
      }
      return null
    },
    // 最大维修费用Box Red change
    repaireCostChangeColor() {
      if (this.fuelCost && this.vehicle_id) {
        const now_date = String(new Date().getFullYear() - 1)

        const defaultRepair_cost = Number(
          this.fuelCost.filter(
            o => o.vehicle_id === this.vehicle_id && o.year === now_date,
          )[0].repair_cost,
        )

        const now_repaireCost_max = _.max(
          this.fuelCost
            .filter(o => o.year === now_date)
            .map(o => Number(o.repair_cost)),
        )
        const result = !(defaultRepair_cost < now_repaireCost_max)
        return result
      }
      return false
    },
  },
  methods: {
    ...mapActions('carMaintenanceRepaireContainer', ['getcarLossAdvise']),
    ...mapActions('carMaintenanceRepaireContainer', ['getcarTestInformation']),
    openDetailsPopup(item) {
      if (item === 'maintenance') {
        this.repaireDetailsPopupShow = false
        this.detectionDetailsPopupShow = false
        this.insuranceDetailsPopupShow = false
        this.maintenanceDetailsPopupShow = !this.maintenanceDetailsPopupShow
        this.chartShow = true
      } else if (item === 'repaire') {
        this.maintenanceDetailsPopupShow = false
        this.detectionDetailsPopupShow = false
        this.insuranceDetailsPopupShow = false
        this.repaireDetailsPopupShow = !this.repaireDetailsPopupShow
      } else if (item === 'detection') {
        this.maintenanceDetailsPopupShow = false
        this.insuranceDetailsPopupShow = false
        this.repaireDetailsPopupShow = false
        this.detectionDetailsPopupShow = !this.detectionDetailsPopupShow
      } else if (item === 'insurance') {
        this.maintenanceDetailsPopupShow = false
        this.detectionDetailsPopupShow = false
        this.repaireDetailsPopupShow = false
        this.insuranceDetailsPopupShow = !this.insuranceDetailsPopupShow
      }
    },
    closeDetailsPopupShow() {
      this.maintenanceDetailsPopupShow = false
      this.repaireDetailsPopupShow = false
      this.detectionDetailsPopupShow = false
      this.insuranceDetailsPopupShow = false
    },
    getDetails(item) {
      if (item === 1) {
        this.chartShow = false
      } else if (item === 2) {
        this.chartShow = true
      }
    },
    selectYear_record(item) {
      this.yearValue = item
      this.getcarLossAdvise({
        vehicleId: this.cljcxxData.vehicle_id,
        year: this.yearValue,
      })
    },
    selectYear_count() {
      // console.log(item)
    },
    selectYear_detection(item) {
      this.yearValue = item
      this.getcarTestInformation({
        vehicleId: this.cljcxxData.vehicle_id,
        testDate: this.yearValue,
      })
    },
  },
  // mounted() {
  //   console.log('aaaaaaaaaaaaaaaaaaaa', this.lineDoubleCostProperty)
  // },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
.maintenanceDetailsPopupWrap {
  width: 100%;

  .detailsContentWrap {
    width: 100%;
    .btnWrap {
      width: 100%;
      .title {
        width: 200px;
        height: 25px;
        line-height: 25px;
        color: #b5b5b5;
        font-size: 14px;
        text-align: center;
        border: 1px solid rgba(0, 191, 229, 1);
        background: rgba(0, 191, 229, 0.2);
        box-sizing: border-box;
        float: right;
        margin-right: 20px;
        cursor: pointer;
      }
      .box_off {
        color: #b5b5b5;
        background: rgba(0, 191, 229, 0.2);
      }
      .box_on {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      .title:hover {
        color: #fff;
      }
    }
    .costStatisticsWrap {
      height: 200px;
      margin-top: 10px;
    }
    .TimeConsumingStatisticsWrap {
      height: 200px;
      margin-top: 10px;
    }
    .CumulativeMaintenanceInfoWrap {
      width: 100%;
      margin-top: 10px;
      padding-top: 20px;
      .CumulativeMaintenanceInfo {
        width: 100%;
        margin-top: 10px;
        .item {
          width: 230px;
          float: left;
          margin-right: 10px;
          .insuranceTitle {
            line-height: 16px;
            font-size: 16px;
            color: #89dddf;
            text-align: center;
            margin-top: 10px;
            margin-bottom: 10px;
          }
          .insuranceData {
            height: 40px;
            line-height: 40px;
            text-align: center;
            color: #fff;
            background: rgba(3, 139, 252, 0.4);
          }
        }
        .last {
          margin-right: 0px;
        }
      }
    }
  }
}
.repaireDetailsPopupWrap {
  width: 100%;

  .repaireRecordDetailsContentWrap {
    width: 100%;
    margin-bottom: 20px;
    .detailsContent {
      width: 100%;
      height: 265px;
      overflow: hidden;
      border: 1px solid #81d9e5;
      box-sizing: border-box;
      .titleWrap {
        @include size(100%,25px);
        margin-top: 10px;
        margin-bottom: 5px;
        background: rgba(5, 208, 235, 0.2);
        .repaireRecordtitle {
          @include size(100px,25px);
          line-height: 25px;
          text-align: center;
          color: #89dddf;
          font-size: 14px;
          float: left;
        }
      }
      .detailListWrap {
        width: 100%;
        ul {
          width: 703px;
          height: 220px;
          list-style: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          overflow-y: scroll;
          li {
            width: 99.3%;
            height: 20px;
            overflow: hidden;
            list-style: none;
            margin: 0;
            padding: 0;
            margin-bottom: 5px;
            background: rgba(129, 217, 229, 0.1);
            ul {
              width: 100%;
              height: 20px;
              overflow: hidden;
              list-style: none;
              margin: 0;
              padding: 0;
              li {
                width: (100%/7);
                height: 20px;
                line-height: 20px;
                text-align: center;
                color: #b5b5b5;
                font-size: 14px;
                float: left;
                list-style: none;
                margin: 0;
                padding: 0;
              }
            }
            ul:hover {
              background: rgba(129, 217, 229, 0.5);
            }
            ul:hover {
              li {
                color: #fff;
              }
            }
          }
        }
        ul::-webkit-scrollbar {
          @include size(5px,220px);
          background: url(~assets/car/scroll.png) no-repeat center center;
          position: relative;
          right: 10px;
          top: 5px;
          background-size: 5px 220px;
        }
        ul::-webkit-scrollbar-thumb {
          background: rgba(5, 208, 235, 1);
        }
      }
    }
  }

  .detailsStatisticsContentWrap {
    width: 100%;
    .btnWrap {
      width: 100%;
      .title {
        width: 200px;
        height: 25px;
        line-height: 25px;
        color: #b5b5b5;
        font-size: 14px;
        text-align: center;
        border: 1px solid rgba(0, 191, 229, 1);
        background: rgba(0, 191, 229, 0.2);
        box-sizing: border-box;
        float: right;
        margin-right: 20px;
        cursor: pointer;
      }
      .box_off {
        color: #b5b5b5;
        background: rgba(0, 191, 229, 0.2);
      }
      .box_on {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      .title:hover {
        color: #fff;
      }
    }
    .costStatisticsWrap {
      height: 200px;
      margin-top: 10px;
    }
    .TimeConsumingStatisticsWrap {
      height: 200px;
      margin-top: 10px;
    }
    .CumulativeMaintenanceInfoWrap {
      width: 100%;
      margin-top: 10px;
      padding-top: 20px;
      .CumulativeMaintenanceInfo {
        width: 100%;
        margin-top: 10px;
        .item {
          width: 230px;
          float: left;
          margin-right: 10px;
          .rerpaireTitle {
            line-height: 16px;
            font-size: 16px;
            color: #89dddf;
            text-align: center;
            margin-top: 10px;
            margin-bottom: 10px;
          }
          .repaireData {
            height: 40px;
            line-height: 40px;
            text-align: center;
            color: #fff;
            background: rgba(3, 139, 252, 0.4);
          }
        }
        .last {
          margin-right: 0px;
        }
      }
    }
  }
}
.detectionDetailsPopupWrap {
  .slecteDateWrap {
    width: 100%;
    padding-right: 0;
    .title {
      padding-left: 544px;
      line-height: 25px;
      margin-right: 10px;
      color: #b5b5b5;
      font-size: 14px;
      float: left;
      box-sizing: border-box;
    }
    .date {
      width: 100px;
      float: left;
    }
  }
  .detailsContentBorderFrame {
    padding-bottom: 5px;
    border: 1px solid #81d9e5;
    margin-top: 10px;
    .detailsContent {
      width: 100%;
      height: 265px;
      padding-bottom: 5px;
      // border: 1px solid #81d9e5;
      border-bottom: none;
      box-sizing: border-box;
      overflow: hidden;
      overflow-x: scroll;
      .titleWrap {
        width: 800px;
        height: 25px;
        margin-top: 10px;
        margin-bottom: 5px;
        background: rgba(5, 208, 235, 0.2);
        .title {
          @include size(100px,25px);
          line-height: 25px;
          text-align: center;
          color: #89dddf;
          font-size: 14px;
          float: left;
        }
      }
      .detailListWrap {
        width: 810px;
        .totalItemWrap {
          width: 800px;
          height: 220px;
          list-style: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          overflow-y: scroll;
          .rowWrap {
            width: 790px;
            height: 20px;
            list-style: none;
            margin: 0;
            padding: 0;
            margin-bottom: 5px;
            background: rgba(129, 217, 229, 0.1);
            .colWrap {
              width: 790px;
              height: 20px;
              overflow: hidden;
              list-style: none;
              margin: 0;
              padding: 0;
              .itemData {
                width: 98.75px;
                height: 20px;
                line-height: 20px;
                text-align: center;
                color: #b5b5b5;
                font-size: 14px;
                float: left;
                list-style: none;
                margin: 0;
                padding: 0;
              }
              .decType {
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              }
              .decAgency {
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              }
            }
            ul:hover {
              background: rgba(129, 217, 229, 0.5);
            }
            ul:hover {
              li {
                color: #fff;
              }
            }
          }
        }
        ul::-webkit-scrollbar {
          @include size(5px,210px);
          background: url(~assets/car/scroll.png) no-repeat center center;
          position: relative;
          right: 0px;
          top: 5px;
          background-size: 5px 210px;
        }
        ul::-webkit-scrollbar-thumb {
          background: rgba(5, 208, 235, 1);
        }
      }
    }
    .detailsContent::-webkit-scrollbar {
      @include size(790px,5px);
      background: url(~assets/car/h_scroll.png) no-repeat center center;
      background-size: 680px 5px;
    }
    .detailsContent::-webkit-scrollbar-thumb {
      background: rgba(5, 208, 235, 1);
    }
  }
}

.insuranceDetailsPopupWrap {
  .slecteDateWrap {
    width: 100%;
    padding-right: 0;
    margin-bottom: 10px;
    .title {
      padding-left: 544px;
      line-height: 25px;
      margin-right: 10px;
      color: #b5b5b5;
      font-size: 14px;
      float: left;
      box-sizing: border-box;
    }
    .date {
      width: 100px;
      float: left;
    }
  }
  .detailsContent {
    width: 100%;
    height: 265px;
    overflow: hidden;
    border: 1px solid #81d9e5;
    box-sizing: border-box;
    .titleWrap {
      @include size(100%,25px);
      margin-top: 10px;
      margin-bottom: 5px;
      background: rgba(5, 208, 235, 0.2);
      .title {
        @include size(100px,25px);
        line-height: 25px;
        text-align: center;
        color: #89dddf;
        font-size: 14px;
        float: left;
      }
    }
    .detailListWrap {
      width: 100%;
      ul {
        width: 703px;
        height: 220px;
        list-style: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        overflow-y: scroll;
        li {
          width: 99.3%;
          height: 20px;
          overflow: hidden;
          list-style: none;
          margin: 0;
          padding: 0;
          margin-bottom: 5px;
          background: rgba(129, 217, 229, 0.1);
          ul {
            width: 100%;
            height: 20px;
            overflow: hidden;
            list-style: none;
            margin: 0;
            padding: 0;
            li {
              width: (100%/7);
              height: 20px;
              line-height: 20px;
              text-align: center;
              color: #b5b5b5;
              font-size: 14px;
              float: left;
              list-style: none;
              margin: 0;
              padding: 0;
              white-space: nowrap;
              overflow: hidden;
              text-overflow: ellipsis;
            }
          }
          ul:hover {
            background: rgba(129, 217, 229, 0.5);
          }
          ul:hover {
            li {
              color: #fff;
            }
          }
        }
      }
      ul::-webkit-scrollbar {
        @include size(5px,220px);
        background: url(~assets/car/scroll.png) no-repeat center center;
        position: relative;
        right: 10px;
        top: 5px;
        background-size: 5px 220px;
      }
      ul::-webkit-scrollbar-thumb {
        background: rgba(5, 208, 235, 1);
      }
    }
  }
  .mainTitleBorder {
    margin-top: 20px;
  }
  .insuranceCountWrap {
    width: 100%;
    margin-top: 10px;
    position: relative;
    .insuranceCountItem {
      width: 670px;
      margin: 0 auto;
      .item {
        width: 325px;
        float: left;
        margin-right: 10px;
        .title {
          line-height: 16px;
          font-size: 16px;
          color: #89dddf;
          text-align: center;
          margin-top: 10px;
          margin-bottom: 10px;
        }
        .data {
          height: 40px;
          line-height: 40px;
          text-align: center;
          color: #fff;
          background: rgba(3, 139, 252, 0.4);
        }
      }
      .clearMarginRight {
        margin-right: 0;
      }
    }
    .prevBtn {
      width: 15px;
      height: 24px;
      background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
      position: absolute;
      top: 45px;
      left: -5px;
    }
    .nextBtn {
      width: 15px;
      height: 24px;
      background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
      position: absolute;
      top: 45px;
      right: -5px;
      transform: rotate(180deg);
    }
    .prevBtn:hover {
      background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;
    }
    .nextBtn:hover {
      background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;
    }
  }
}
</style>
      