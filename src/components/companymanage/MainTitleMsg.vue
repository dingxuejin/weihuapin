<template>
  <div class="top_name">
    <select>
      <option value="" v-for='(item,index) in data' :key='index'>{{item}}</option>
    </select>
    <div class="title">企业经营管理</div>
    <div class="top_btn"></div>
  </div>
</template>

<script>
  // import {
  //   mapActions,
  //   mapState,
  // } from 'vuex'

  export default {
    data() {
      return {
        data: ['华北配送中心', '华南配送中心', '西北配送中心', '东南配送中心'],
      }
    },
    computed: {
      // ...mapState('headerMsgStore', ['headerdata']),
    },
    methods: {
      // ...mapActions('headerMsgStore', ['getHeader']),
    },
    mounted() {
      // this.getHeader()
    },
  }

</script>

<style lang="scss" scoped>
  .top_name {
    width: 100%;
    height: 100px;
    // margin: 15px 0px 10px;
    background: url('../../assets/companymanage/select_bg.png') no-repeat;
    text-indent: 50px;
    font-size: 24px;
    font-weight: bold;
    color: #89dddf;
    position: relative;
    select {
      width: 370px;
      color: #89dddf;
      background: rgba(0, 0, 0, 0);
      list-style: none;
      border: 0;
      outline: none;
      cursor: pointer;
      font-weight:bold;
      margin-top:24px;
    }
    .title{
        font-size: 16px;
        margin-top:5px;
    }
    .top_btn {
      width: 29px;
      height: 20px;
      position: absolute;
      top: 32px;
      right: 10px;
      background: url('../../assets/companymanage/selecet.png') no-repeat;
      pointer-events:none;
    }
  }

</style>
