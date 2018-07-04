<template>
    <div class="home">
        <div class="home_header">
            <common-header :headerTitle="headerTitle" :leftHeaderTitle="leftHeaderTitle"></common-header>
        </div>
        <NationalMap></NationalMap>
    </div>
</template>
<script>
/* eslint-disable */
import CommonHeader from '@/components/commonHeader'
import NationalMap from './NationalMap.vue'

export default {
  components: {
      CommonHeader,
    NationalMap,
  },
  data(){
      return {
        headerTitle: '综合运营看板',
        leftHeaderTitle: '危货运输安全管理系统',
      }
  }
}
</script>
<style lang="scss" scoped>
.home{
    width: 100%;
    height: 100%;
    overflow: hidden;
    position: relative;
    &_header{
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
        height: 80px;
        background-color: #000;
        z-index: 11;
    }
}
</style>
