<template>
  <!-- 终端配置到期信息弹框汇总 -->
  <popup-out-frame :title="mainTitle">
    <div class="warningTerminalConfiguration"
         v-if="getTerminalInfo">
      <div class="popUpBoxContent">
        <div class="itemWrap">
          <div class="subTitle">终端类型</div>
          <div class="content">{{getTerminalInfo.zdlx.terminal_type}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap clearMarginRight">
          <div class="subTitle">终端厂家</div>
          <div class="content">{{getTerminalInfo.manufacturer}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap">
          <div class="subTitle">终端品牌</div>
          <div class="content">{{getTerminalInfo.terminal_brand}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap clearMarginRight">
          <div class="subTitle">终端型号</div>
          <div class="content">{{getTerminalInfo.terminal_model}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap">
          <div class="subTitle">设备数量</div>
          <div class="content">{{getTerminalInfo.terminal_quantity}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap clearMarginRight">
          <div class="subTitle">终端安装日期</div>
          <div class="content">{{formatDate(getTerminalInfo.install_date||'')}}
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap">
          <div class="subTitle">终端质保期</div>
          <div class="content">{{getTerminalInfo.warranty_period}} 年
            <div class="rotateBox"></div>
          </div>
        </div>
      </div>
    </div>
    <div v-show="false">{{getTerminalInfo}}</div>
  </popup-out-frame>

</template>

<script>
import PopupOutFrame from './PopupOutFrame'
import { mapState } from '../../../../node_modules/_vuex@3.0.1@vuex'

export default {
  props: ['type'],
  components: {
    PopupOutFrame,
  },

  data() {
    return {
      mainTitle: '',
    }
  },
  computed: {
    // 原始数据：终端信息
    ...mapState('terminalConfigurationContainer', ['czzdxxData']),
    // 轮播选择：获取title
    ...mapState('warningCarouselpopupContainer', ['title']),
    getTerminalInfo() {
      if (this.czzdxxData && this.title) {
        this.mainTitle = this.title
        const terminalInfo = this.czzdxxData.filter(
          item => item.zdlx.terminal_type === this.title,
        )[0]
        return terminalInfo
      }
      return null
    },
  },
  methods: {
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

.warningTerminalConfiguration {
  width: 100%;
  .popUpBoxContent {
    @include size(100%,100%);
    // margin: 16px;
    position: relative;
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
        height: 30px;
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
    .remindRed {
      .content {
        background: rgba(231, 80, 41, 0.4);
        border: 1px solid rgba(231, 80, 41, 1);
        .rotateBox {
          background: rgba(231, 80, 41, 1);
        }
      }
    }
    .remindYellow {
      .content {
        background: rgba(255, 185, 46, 0.4);
        border: 1px solid rgba(255, 185, 46, 1);
        .rotateBox {
          background: rgba(255, 185, 46, 1);
        }
      }
    }
    .remindGreen {
      .content {
        background: rgba(5, 208, 235, 0.4);
        border: 1px solid rgba(5, 208, 235, 1);
        .rotateBox {
          background: rgba(5, 208, 235, 1);
        }
      }
    }

    .clearMarginRight {
      margin-right: 0;
    }
  }
}
</style>
