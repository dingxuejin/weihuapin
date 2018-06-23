<template>
  <div class="carMaintenanceRepaire"
       @mouseover="stopCrousel()"
       @mouseleave="startCrousel()">
    <!-- 保养信息+维修信息 -->
    <!-- <loading :data="clwxxxData&&clbyxxData&&ylrqgtjcData&&clbxjcData"> -->
      <div class="wrapBox"
           v-if="maintenceRepaireDetailsShow">
        <!-- 保养信息 -->
        <div class="itemBox"
             v-if="clbyxxData">
          <div class="title"
               @click="openDetails('maintenance')">保养信息
            <div class="btnDetails"></div>
          </div>
          <div class="nextDate" :class="getMaintenceDueDayChangeColor">下次保养&nbsp;
            <span v-if="clbyxxData.next_maintain_date">{{clbyxxData.next_maintain_date }}</span>
            <div class="rotateBox"></div>
          </div>
          <div class="details">
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_1===1">
                <div class="detailsItem firstBox">
                  <div class="subTitle">本次保养里程</div>
                  <div class="content"
                       v-if="clbyxxData">{{qf(clbyxxData.current_maintain_km)}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">下次计划保养里程</div>
                  <div class="content"
                       v-if="clbyxxData">{{qf(clbyxxData.next_maintain_km)}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">累计保养次数</div>
                  <div class="content"
                       v-if="clbyxxData">{{qf(clbyxxData.total_maintain_times)}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">保养日期</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.maintain_date}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_1===2">
                <div class="detailsItem firstBox">
                  <div class="subTitle">保养类型</div>
                  <!-- tooltip TBD -->
                  <div class="content"
                       :title='clbyxxData.bylx.maintenance_type'
                       v-if="clbyxxData">{{clbyxxData.bylx.maintenance_type}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">保养机构</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.qy_hzsxx.name}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">保养费用</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.maintain_cost}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">送报人/办理人</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.maintain_director}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_1===3">
                <div class="detailsItem firstBox">
                  <div class="subTitle">电话</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.phone_number}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">保养结果/状态</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.byzt.maintenance_status}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">保养耗时</div>
                  <div class="content"
                       v-if="clbyxxData">{{clbyxxData.maintain_time_consumed}}</div>
                </div>
              </div>
            </transition>
            <div class="prevBtn"
                 @click="scrollContent_h_1(-1)"></div>
            <div class="nextBtn"
                 @click="scrollContent_h_1(1)"></div>
          </div>
        </div>
        <!-- 维修信息 -->
        <div class="itemBox"
             v-if="clwxxxData">
          <div class="title"
               @click="openDetails('repaire')">维修信息
            <div class="btnDetails"></div>
          </div>
          <div class="nextDate" :class="getRepaireDueDayChangeColor">下次维修&nbsp;
            <span>{{clwxxxData.next_maintain_date}}</span>
            <div class="rotateBox"></div>
          </div>
          <div class="details">
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_2===1">
                <div class="detailsItem firstBox">
                  <div class="subTitle">维修时间</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.repair_date}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">维修类型</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.wxlx.repaire_type}}</div>
                  <!-- <div class="content"
                     v-if="clwxxxData">{{'大修'}}</div> -->
                </div>
                <div class="detailsItem">
                  <div class="subTitle">维修费用</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.repair_cost}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">维修厂商</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.partner_id}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_2===2">
                <div class="detailsItem firstBox">
                  <div class="subTitle">送修人</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.repair_director}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">送修人电话</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.phone_number}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">里程</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.current_km}}</div>
                </div>
                <div class="detailsItem">
                  <div class="subTitle">维修耗时(H)</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.repair_time_consumed}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_2===3">
                <div class="detailsItem firstBox">
                  <div class="subTitle">下次计划性维修时间</div>
                  <div class="content"
                       v-if="clwxxxData">{{clwxxxData.next_maintain_date}}</div>
                </div>
              </div>
            </transition>
            <div class="prevBtn"
                 @click="scrollContent_h_2(-1)"></div>
            <div class="nextBtn"
                 @click="scrollContent_h_2(1)"></div>
          </div>
        </div>
      </div>

      <!-- 保险信息+检测信息 -->
      <div class="wrapBox"
           v-if="!maintenceRepaireDetailsShow">
        <!-- 保险信息 -->
        <div class="itemBox"
             v-if="clbxjcData">
          <div class="title"
               @click="openDetails('insurance')">保险信息
            <div class="btnDetails"></div>
          </div>
          <div class="nextDate" :class="getInsuranceDueDayChangeColor">
            保单到期&nbsp;<span>{{clbxjcData.insurance_end_date||''}}</span>
            <div class="rotateBox"></div>
          </div>
          <div class="details">
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_3===1">
                <div class="detailsItem firstBox insuredOrg">
                  <div class="subTitle">投保机构</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.insurance_agency}}</div>
                </div>
                <div class="detailsItem policyNo">
                  <div class="subTitle">保单编号</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.insurance_number}}</div>
                </div>
                <div class="detailsItem endDate">
                  <div class="subTitle">保单到期日期</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.insurance_end_date}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_3===2">
                <div class="detailsItem firstBox insuredOrg">
                  <div class="subTitle">保险类型</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.bxlx.insurance_type}}</div>
                </div>
                <div class="detailsItem policyNo">
                  <div class="subTitle">保险金额</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.insurance_cost}}</div>
                </div>
                <div class="detailsItem endDate">
                  <div class="subTitle">投保区域</div>
                  <div class="content"
                       v-if="clbxjcData">{{clbxjcData.qy_qyfb.region_scope_name}}</div>
                </div>
              </div>
            </transition>
            <div class="prevBtn"
                 @click="scrollContent_h_3(-1)"></div>
            <div class="nextBtn"
                 @click="scrollContent_h_3(1)"></div>
          </div>
        </div>
        <!-- 检测信息 -->
        <div class="itemBox"
             v-if="ylrqgtjcData">
          <div class="title"
               @click="openDetails('detection')">检测信息
            <div class="btnDetails"></div>
          </div>
          <div class="nextDate" :class="getDetectionDueDayChangeColor">下次检测&nbsp;
            <span>{{ylrqgtjcData.next_test_date}}</span>
            <div class="rotateBox"></div>
          </div>
          <div class="details">
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_4===1">
                <div class="detailsItem firstBox insuredOrg">
                  <div class="subTitle">检测时间</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.test_date}}</div>
                </div>
                <div class="detailsItem policyNo">
                  <div class="subTitle">检测类别</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.cljclx.detection_type}}</div>
                </div>
                <div class="detailsItem endDate">
                  <div class="subTitle">检测机构</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.qy_hzsxx.name}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_4===2">
                <div class="detailsItem firstBox insuredOrg">
                  <div class="subTitle">送检人</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.test_director}}</div>
                </div>
                <div class="detailsItem policyNo">
                  <div class="subTitle">送检人联系电话</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.phone_number}}</div>
                </div>
                <div class="detailsItem endDate">
                  <div class="subTitle">检测费用</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.test_cost}}</div>
                </div>
              </div>
            </transition>
            <transition name="fade">
              <div class="wrapDetailsBox"
                   v-if="detailesBoxShow_h_4===3">
                <div class="detailsItem firstBox insuredOrg">
                  <div class="subTitle">检测结果</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.gtjcjg.inspect_result}}</div>
                </div>
                <div class="detailsItem policyNo">
                  <div class="subTitle">下次检测时间</div>
                  <div class="content"
                       v-if="ylrqgtjcData">{{ylrqgtjcData.next_test_date}}</div>
                </div>
              </div>
            </transition>
            <div class="prevBtn"
                 @click="scrollContent_h_4(-1)"></div>
            <div class="nextBtn"
                 @click="scrollContent_h_4(1)"></div>
          </div>
        </div>
      </div>
      <div class="upBtn"
           @click="scrollContent(-1)"></div>
      <div class="downBtn"
           @click="scrollContent(1)"></div>
    <!-- </loading> -->

    <!-- 详细弹出框 -->
    <!-- 保险信息 -->
    <div class="maintenanceRepairedetailsWrap">
      <slot name="detailsWrap"></slot>
    </div>
    <!-- 保养信息 -->
    <div class="maintenancedetailsWrap">
      <slot name="maintenancedetail"></slot>
    </div>
    <!-- 检测信息 -->
    <div class="detectiondetailsWrap">
      <slot name="detectiondetails"></slot>
    </div>
    <!-- 维修信息 -->
    <div class="repairedetailsWrap">
      <slot name="repairedetails"></slot>
    </div>
    <!-- 定时器 -->
    <div v-show="false">{{v_carousel}}</div>
  </div>
</template>


<script>
// import Tock from 'tocktimer'
export default {
  name: 'car-maintenance-repaire',
  props: ['clbyxxData', 'clwxxxData', 'clbxjcData', 'ylrqgtjcData'],
  data() {
    return {
      maintenceRepaireDetailsShow: true,
      detailesBoxShow_h_1: 1,
      detailesBoxShow_h_2: 1,
      detailesBoxShow_h_3: 1,
      detailesBoxShow_h_4: 1,
    }
  },
  computed: {
    repaire_type() {
      return this.clwxxxData.wxlx.repaire_type
    },
    // 定时器
    v_carousel() {
      this.timer = setInterval(() => {
        if (this.maintenceRepaireDetailsShow) {
          this.maintenceRepaireDetailsShow = false
        } else {
          this.maintenceRepaireDetailsShow = true
        }
      }, 2000)
      return null
    },
    // 获取保养到期信息-- 暂无数据
    getMaintenceDueDayChangeColor() {
      return 'green'
    },
    // 获取维修到期信息
    getRepaireDueDayChangeColor() {
      if (this.clwxxxData) {
        if (this.clwxxxData.next_maintain_date) {
          const dueDate_before = this.clwxxxData.next_maintain_date
          const dueDate = new Date(dueDate_before)
          const one_month = 31 * 24 * 60 * 60 * 1000
          const three_month = 31 * 24 * 60 * 60 * 1000 * 3
          const nowDate = new Date()
          const difDate = dueDate - nowDate
          if (difDate >= 0) {
            if (difDate < one_month) {
              return 'box_red'
            } else if (difDate < three_month) {
              return 'box_yellow'
            }
            return 'box_green'
          }
          return 'box_green'
        }
        return 'box_green'
      }
      return 'box_green'
    },
    // 获取保险到期信息
    getInsuranceDueDayChangeColor() {
      if (this.clbxjcData) {
        if (this.clbxjcData.insurance_end_date) {
          const dueDate_before = this.formatDate(this.clbxjcData.insurance_end_date)
          const dueDate = new Date(dueDate_before)
          const one_month = 31 * 24 * 60 * 60 * 1000
          const three_month = 31 * 24 * 60 * 60 * 1000 * 3
          const nowDate = new Date()
          const difDate = dueDate - nowDate
          if (difDate >= 0) {
            if (difDate < one_month) {
              return 'box_red'
            } else if (difDate < three_month) {
              return 'box_yellow'
            }
            return 'box_green'
          }
          return 'box_green'
        }
        return 'box_green'
      }
      return 'box_green'
    },
    // 获取检测到期信息
    getDetectionDueDayChangeColor() {
      if (this.ylrqgtjcData) {
        if (this.ylrqgtjcData.next_test_date) {
          const dueDate_before = this.ylrqgtjcData.next_test_date
          const dueDate = new Date(dueDate_before)
          const one_month = 31 * 24 * 60 * 60 * 1000
          const three_month = 31 * 24 * 60 * 60 * 1000 * 3
          const nowDate = new Date()
          const difDate = dueDate - nowDate
          if (difDate >= 0) {
            if (difDate < one_month) {
              return 'box_red'
            } else if (difDate < three_month) {
              return 'box_yellow'
            }
            return 'box_green'
          }
          return 'box_green'
        }
        return 'box_green'
      }
      return 'box_green'
    },
  },
  methods: {
    scrollContent() {
      if (this.maintenceRepaireDetailsShow) {
        this.maintenceRepaireDetailsShow = false
      } else {
        this.maintenceRepaireDetailsShow = true
      }
    },
    scrollContent_h_1(i) {
      this.detailesBoxShow_h_1 += 1 * i
      if (this.detailesBoxShow_h_1 > 3) {
        this.detailesBoxShow_h_1 = 3
      }
      if (this.detailesBoxShow_h_1 < 1) {
        this.detailesBoxShow_h_1 = 1
      }
    },
    scrollContent_h_2(i) {
      this.detailesBoxShow_h_2 += 1 * i
      if (this.detailesBoxShow_h_2 > 3) {
        this.detailesBoxShow_h_2 = 3
      }
      if (this.detailesBoxShow_h_2 < 1) {
        this.detailesBoxShow_h_2 = 1
      }
    },
    scrollContent_h_3(i) {
      this.detailesBoxShow_h_3 += 1 * i
      if (this.detailesBoxShow_h_3 > 2) {
        this.detailesBoxShow_h_3 = 2
      }
      if (this.detailesBoxShow_h_3 < 1) {
        this.detailesBoxShow_h_3 = 1
      }
    },
    scrollContent_h_4(i) {
      this.detailesBoxShow_h_4 += 1 * i
      if (this.detailesBoxShow_h_4 > 3) {
        this.detailesBoxShow_h_4 = 3
      }
      if (this.detailesBoxShow_h_4 < 1) {
        this.detailesBoxShow_h_4 = 1
      }
    },
    openDetails(items) {
      this.$emit('openDetails', items)
    },
    stopCrousel() {
      clearInterval(this.timer)
    },
    startCrousel() {
      this.timer = setInterval(() => {
        if (this.maintenceRepaireDetailsShow) {
          this.maintenceRepaireDetailsShow = false
        } else {
          this.maintenceRepaireDetailsShow = true
        }
      }, 2000)
    },
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carMaintenanceRepaire {
  @include size(530px, 210px);
  margin-top: 10px;
  margin-left: 10px;
  position: relative;
  z-index: 9;
  .wrapBox {
    width:505px;
    height: 230px;
    .itemBox {
      height: 95px;
      margin-bottom: 20px;
      .title {
        @include size(200px, 30px);
        line-height: 30px;
        color: #89dddf;
        font-size: 18px;
        font-weight: bold;
        padding-left: 20px;
        background: #005b7f;
        position: relative;
        float: left;
        box-sizing: border-box;
        .btnDetails {
          @include size(20px, 20px);
          position: absolute;
          top: 12px;
          right: 10px;
          cursor: pointer;
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
        }
        .btnDetails:hover {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
        }
      }
      .nextDate {
        @include size(200px, 30px);
        position: relative;
        float: right;
        line-height: 30px;
        color: #fff;
        font-size: 14px;
        font-weight: bold;
        padding-left: 20px;
        background: rgba(5, 208, 235, 0.4);
        border: 1px solid rgba(5, 208, 235, 1);
        box-sizing: border-box;
        span {
          font-weight: bold;
          position: absolute;
          top: 0;
          right: 24px;
          text-align: center;
        }
        .rotateBox {
          @include size(7px,7px);
          position: absolute;
          top: 11px;
          left: 5px;
          transform: rotate(45deg);
          background: #05d0eb;
        }
      }
      .details {
        @include size(100%, 55px);
        margin-top: 10px;
        float: left;
        position: relative;
        overflow: hidden;
        .wrapDetailsBox {
          .detailsItem {
            width: 140px;
            float: left;
            margin-right: 5px;
            .subTitle {
              line-height: 14px;
              font-size: 14px;
              color: #89dddf;
              text-align: center;
            }
            .content {
              height: 30px;
              line-height: 30px;
              font-size: 14px;
              color: #fff;
              text-align: center;
              background: rgba(3, 139, 252, 0.4);
              margin-top: 10px;
              overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
            }
            .content::-webkit-scrollbar {
              display: none;
            }
          }
          .insuredOrg {
            width:140px !important;
          }
          .policyNo {
            @extend .insuredOrg;
          }
          .endDate {
            @extend .insuredOrg;
          }
        }
        .prevBtn {
          @include size(15px, 30px);
          line-height: 30px;
          position: absolute;
          bottom: 0px;
          left: 0px;
          color: #fff;
          cursor: pointer;
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -38px;
        }
        .prevBtn:hover {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -38px;
        }
        .nextBtn {
          @include size(15px, 30px);
          line-height: 30px;
          position: absolute;
          bottom: 0;
          right: 0px;
          color: #fff;
          cursor: pointer;
          text-align: right;
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -37px;
          transform: rotate(180deg);
        }
        .nextBtn:hover {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -37px;
        }
        .firstBox {
          margin-left: 22px;
        }
      }
    }
  }
  .upBtn {
    @include size(20px, 20px);
    position: absolute;
    top: 0;
    left: 48.25%;
    background: url(../../assets/car/css_sprite_car-01.png) no-repeat -400px -40px;
    cursor: pointer;
  }
  .upBtn:hover {
    background: url(../../assets/car/css_sprite_car-01.png) no-repeat -460px -40px;
  }
  .downBtn {
    @include size(20px, 20px);
    position: absolute;
    bottom: -28px;
    left: 48.25%;
    background: url(../../assets/car/css_sprite_car-01.png) no-repeat -400px -40px;
    cursor: pointer;
    transform: rotate(180deg);
  }
  .downBtn:hover {
    background: url(../../assets/car/css_sprite_car-01.png) no-repeat -460px -40px;
  }
  .fade-enter-active,
  .fade-leave-active {
    transition: opacity 0.2s;
  }
  .fade-enter,
  .fade-leave-to {
    opacity: 0;
  }

  // 详细弹出框
  .maintenanceRepairedetailsWrap {
    width: 750px;
    position: absolute;
    top: -638px;
    left: 550px;
    z-index: 33;
  }
  .maintenancedetailsWrap {
    width: 750px;
    position: absolute;
    top: -485px;
    left: 422px;
    z-index: 33;
  }
  .detectiondetailsWrap {
    width: 750px;
    position: absolute;
    top: -385px;
    left: 422px;
    z-index: 33;
  }
  .repairedetailsWrap {
    width: 750px;
    position: absolute;
    top: -638px;
    left: 550px;
    z-index: 33;
  }
}
</style>
