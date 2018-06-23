<template>
  <!-- 资质证件到期信息汇总 -->
  <popup-out-frame :title="mainTitle">
    <div class="items"
         v-if="clzzzjxxData">
      <div class="itemWrap">
        <div class="subTitle">证件编号</div>
        <div class="content"
             v-if="clzzzjxxData">{{clzzzjxxItem.certificate_number||''}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">颁发机构</div>
        <div class="content"
             v-if="clzzzjxxData">{{clzzzjxxItem.issued_agency}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap">
        <div class="subTitle">有效期始</div>
        <div class="content"
             v-if="clzzzjxxData">{{formatDate(clzzzjxxItem.effective_date||'')}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">有效期止</div>
        <div class="content"
             v-if="clzzzjxxData">{{formatDate(clzzzjxxItem.expire_date||'')}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap">
        <div class="subTitle">有限期限</div>
        <div class="content"
             v-if="clzzzjxxData">{{clzzzjxxItem.valid_period}}年
          <div class="rotateBox"></div>
        </div>
      </div>
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
      clzzzjxxItem: '',
    }
  },
  computed: {
    // 原始数据：车辆基础信息
    ...mapState('carBaseInfoContainer', ['clzzzjxxData']),
    // 轮播选择：获取title
    ...mapState('warningCarouselpopupContainer', ['title']),
    getTerminalInfo() {
      if (this.clzzzjxxData && this.title) {
        this.mainTitle = this.title
        const clzzzjxxItems = this.clzzzjxxData.filter(
          item => item.clzj.vehicle_certificate_type === this.title,
        )[0]

        if (clzzzjxxItems !== undefined) {
          const clzzzjxxItem = {
            certificate_number: clzzzjxxItems.certificate_number || 'null',
            effective_date: clzzzjxxItems.effective_date || 'null',
            expire_date: clzzzjxxItems.expire_date || 'null',
            valid_period: clzzzjxxItems.valid_period || 'null',
            issued_agency: clzzzjxxItems.issued_agency || 'null',
          }
          this.clzzzjxxItem = clzzzjxxItem
        } else {
          this.clzzzjxxItem = {
            certificate_number: '无',
            effective_date: '无',
            expire_date: '无',
            valid_period: '无',
            issued_agency: '无',
          }
        }
        return null
      }
      return null
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
.items {
  width: 100%;
  overflow: hidden;
  .itemWrap {
    @include size(350px,30px);
    line-height: 30px;
    margin-bottom: 10px;
    margin-right: 10px;
    float: left;
    .subTitle {
      @include size(110px,30px);
      line-height: 30px;
      text-align: left;
      color: #89dddf;
      font-size: 14px;
      float: left;
    }
    .content {
      @include size(240px,30px);
      line-height: 30px;
      padding-left: 30px;
      color: #fff;
      font-size: 14px;
      font-weight: bold;
      border: 1px solid #89dddf;
      float: left;
      position: relative;
      box-sizing: border-box;
      .rotateBox {
        @include size(7px,7px);
        position: absolute;
        top: 11px;
        left: 10px;
        transform: rotate(45deg);
        background: #05d0eb;
      }
    }
  }
  .clearMarginRight {
    margin-right: 0;
  }
}
</style>
