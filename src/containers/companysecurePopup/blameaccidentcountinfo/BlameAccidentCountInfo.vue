<template>
  <div class="blameAccidentCountInfoCon">
    <!-- 有责事故次数统计 -->
    <div>
        <blame-accident-num-count-info></blame-accident-num-count-info>
    </div>

    <!-- 有责事故占比统计 -->
    <div>
        <blame-accident-proport-ioninfo></blame-accident-proport-ioninfo>
    </div>
  </div>
</template>

<script type="text/javascript">
import BlameAccidentNumCountInfo from '../blameaccidentnumcountinfo/BlameAccidentNumCountInfo'
import BlameAccidentProportIoninfo from '../blameaccidentproportioninfo/BlameAccidentProportIoninfo'

export default {
  name: 'workCountInfo',
  components: {
    BlameAccidentNumCountInfo,
    BlameAccidentProportIoninfo,
  },
  data() {
    return {}
  },
}
</script>

<style lang="scss" scoped>
@mixin size($w,$h){
  width:$w;
  height:$h;
}
.blameAccidentCountInfoCon{
  // 行驶里程统计
  >div{
    width:100%;
    min-height:10px;
    // background: green;
  }

  >div:nth-child(n+2){
    margin-top:20px;
  }
}

</style>