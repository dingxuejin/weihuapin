<template>
  <div class="warningCarouselpopupContainer_wrap clearfix"
       v-if="detailsShow" v-drag @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
    <!-- 终端配置信息:弹框信息汇总 -->
    <div class="warningTerminalConfiguration_wrap clearfix"
         v-if="selectedType==='terminal'">
      <warning-terminal-configuration type="terminal">
      </warning-terminal-configuration>
    </div>

    <!-- 警告及防护信息：弹框信息汇总 -->
    <div class="WarningProtectionConfiguratio_wrap clearfix"
         v-if="selectedType==='pwc'">
      <warning-protection-configuratio></warning-protection-configuratio>
    </div>

    <!-- 资质证件信息: 弹框信息汇总 -->
    <div class="qualificationDocumentinfor_wrap clearfix"
         v-if="selectedType==='baseInfo'">
      <qualification-documentinfor></qualification-documentinfor>
    </div>
    <!-- 保养信息：弹框信息 -->
    <div class="nextMaintenanceDate_wrap clearfix"
         v-if="selectedType==='maintenance'">
      <next-maintenance-date></next-maintenance-date>
    </div>
    <!-- 维修信息：弹框信息 -->
    <div class="nextRepaireDate_wrap clearfix"
         v-if="selectedType==='repaire'">
      <next-repaire-date></next-repaire-date>
    </div>
    <!-- 检测信息：弹框信息 -->
    <div class="nextDetectionDate_wrap clearfix"
         v-if="selectedType==='detection'">
      <next-detection-date></next-detection-date>
    </div>
    <!-- 保险信息：弹框信息 -->
    <div class="nextInsuranceDate_wrap clearfix"
         v-if="selectedType==='insurance'">
      <next-insurance-date></next-insurance-date>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import PopupOutFrame from './PopupOutFrame'
import WarningTerminalConfiguration from './WarningTerminalConfiguration'
import WarningProtectionConfiguratio from './WarningProtectionConfiguratio'
import QualificationDocumentinfor from './QualificationDocumentinfor'
import NextMaintenanceDate from './NextMaintenanceDate'
import NextRepaireDate from './NextRepaireDate'
import NextDetectionDate from './NextDetectionDate'
import NextInsuranceDate from './NextInsuranceDate'

export default {
  components: {
    PopupOutFrame,
    WarningTerminalConfiguration,
    WarningProtectionConfiguratio,
    QualificationDocumentinfor,
    NextMaintenanceDate,
    NextRepaireDate,
    NextDetectionDate,
    NextInsuranceDate,
  },
  data() {
    return {
      title: null,
      move: false,
    }
  },
  computed: {
    ...mapState('warningCarouselpopupContainer', [
      'detailsShow',
      'terminal_configration_Details_show',
      'warning_protection_details_show',
      'selectedType',
    ]),
  },
  methods: {
    ...mapMutations('terminalConfigurationContainer', [
      'getTermialSelectedInfo',
    ]),
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
.warningCarouselpopupContainer_wrap {
  width: 100%;
  .warningTerminalConfiguration_wrap {
    width: 750px;
  }
  .WarningProtectionConfiguratio_wrap {
    width: 1190px;
    position: relative;
    left:-100px;
  }
  .qualificationDocumentinfor_wrap {
    width: 750px;
  }
  .nextMaintenanceDate_wrap {
    width: 750px;
  }
  .nextRepaireDate_wrap {
    width: 750px;
  }
  .nextDetectionDate_wrap {
    width: 750px;
  }
  .nextInsuranceDate_wrap {
    width: 750px;
  }
}
</style>
