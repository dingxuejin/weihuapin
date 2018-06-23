<template>
  <!-- 警告与防护到期信息弹框汇总 -->
  <popup-out-frame :title="mainTitle">
    <div class="popupDetailsContent clearfix"
         v-if="czzbxxData">
      <ul class="itemWrap">
        <li class="itemTitle">存放位置</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxItem.equipment_position}}
        </li>
      </ul>
      <ul class="itemWrap">
        <li class="itemTitle">装备品牌</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxItem.equipment_brand}}
        </li>
      </ul>
      <ul class="itemWrap">
        <li class="itemTitle">型号</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxItem.equipment_model}}
        </li>
      </ul>
      <ul class="itemWrap MFGDate">
        <li class="itemTitle">生产日期</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{formatDate(czzbxxItem.purchase_date||'')}}
        </li>
      </ul>
      <ul class="itemWrap">
        <li class="itemTitle">有效期</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxItem.valid_period}} 年
        </li>
      </ul>
      <ul class="itemWrap">
        <li class="itemTitle">采购渠道</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxItem.purchase_channel}}
        </li>
      </ul>
      <ul class="itemWrap price"
          style="margin-right:0px">
        <li class="itemTitle">采购价格</li>
        <li class="ItemData"
            v-if="czzbxxData">
          {{czzbxxData.price}} 元
        </li>
      </ul>
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
      czzbxxItem: '',
      move: false,
    }
  },
  computed: {
    // 原始数据：防护及警告装备
    ...mapState('protectionWarningConfigurationContainer', ['czzbxxData']),
    // 轮播选择：获取title
    ...mapState('warningCarouselpopupContainer', ['title']),
    getTerminalInfo() {
      if (this.czzbxxData && this.title) {
        this.mainTitle = this.title
        const czzbxxItems = this.czzbxxData.filter(
          item => item.fhzzlx.protective_equipment_type === this.title,
        )[0]

        if (czzbxxItems !== undefined) {
          const czzbxxItem = {
            equipment_position: czzbxxItems.equipment_position
              ? czzbxxItems.equipment_position
              : '',
            equipment_brand: czzbxxItems.equipment_brand
              ? czzbxxItems.equipment_brand
              : '',
            equipment_model: czzbxxItems.equipment_model
              ? czzbxxItems.equipment_model
              : '',
            purchase_date: czzbxxItems.purchase_date
              ? czzbxxItems.purchase_date
              : '',
            valid_period: czzbxxItems.valid_period
              ? czzbxxItems.valid_period
              : '',
            purchase_channel: czzbxxItems.fhzzcgqd
              .protective_equipment_supply_channel
              ? czzbxxItems.fhzzcgqd.protective_equipment_supply_channel
              : '',
            price: czzbxxItems.price ? czzbxxItems.price : '',
          }
          this.czzbxxItem = czzbxxItem
        } else {
          this.czzbxxItem = {
            equipment_position: '无',
            equipment_brand: '无',
            equipment_model: '无',
            purchase_date: '无',
            valid_period: '无',
            purchase_channel: '无',
            price: '无',
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
.popupDetailsContent {
  width: 100%;
  .itemWrap {
    width: 150px;
    float: left;
    margin: 0;
    padding: 0;
    margin-right: 10px;
    .itemTitle {
      list-style: none;
      margin: 0;
      padding: 0;
      font-size: 16px;
      color: #89dddf;
      text-align: center;
      padding-bottom: 10px;
    }
    .ItemData {
      height: 40px;
      line-height: 40px;
      font-size: 22px;
      color: #fff;
      text-align: center;
      background: rgba(3, 139, 252, 0.4);
    }
  }
  .MFGDate {
    width: 200px;
  }
  .price {
    width: 140px;
  }
}
</style>
