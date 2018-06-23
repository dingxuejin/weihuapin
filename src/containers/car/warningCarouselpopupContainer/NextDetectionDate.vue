<template>
  <!-- 资质证件到期信息汇总 -->
  <popup-out-frame :title="mainTitle">
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
                 v-if="ylrqgtjcData">{{ylrqgtjcData.test_agency}}</div>
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
    <div v-show="false">{{getTerminalInfo}}</div>
  </popup-out-frame>

</template>

<script>
import { mapState } from '../../../../node_modules/_vuex@3.0.1@vuex'
import PopupOutFrame from './PopupOutFrame'

export default {
  props: [''],
  components: {
    PopupOutFrame,
  },

  data() {
    return {
      mainTitle: '',
      detailesBoxShow_h_4: 1,
    }
  },
  computed: {
    //   保养维修等数据
    ...mapState('carMaintenanceRepaireContainer', [
      'clbyxxData',
      'clwxxxData',
      'clbxjcData',
      'ylrqgtjcData',
    ]),
    // 轮播选择：获取title
    ...mapState('warningCarouselpopupContainer', ['title']),
    getTerminalInfo() {
      if (this.clbyxxData && this.title) {
        this.mainTitle = this.title
        return null
      }
      return null
    },
  },
  methods: {
    scrollContent_h_4(i) {
      this.detailesBoxShow_h_4 += 1 * i
      if (this.detailesBoxShow_h_4 < 1 || this.detailesBoxShow_h_4 > 3) {
        this.detailesBoxShow_h_4 = 1
      }
    },
  },
}
</script>
<style lang="scss" scope>
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
.details {
  @include size(100%, 55px);
  margin-top: 10px;
  float: left;
  position: relative;
  overflow: hidden;
  .wrapDetailsBox {
    .detailsItem {
      width: 152px;
      float: left;
      margin-right: 20px;
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
      width: 188px !important;
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
    background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -280px -38px;
  }
  .prevBtn:hover {
    background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -340px -38px;
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
    background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -280px -37px;
    transform: rotate(180deg);
  }
  .nextBtn:hover {
    background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -340px -37px;
  }
  .firstBox {
    margin-left: 22px;
  }
}
</style>
