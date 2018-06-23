<template>
    <div class="layertitle">
        <div :class="[icon]"></div>
        <div>{{name}}</div>
        <div class="delete" @click='change'></div>
    </div>
</template>

<script>
export default{
  props: ['icon', 'name'],
  methods: {
    change() {
      this.$emit('up', 'false')
    },
  },
  data() {
    return {
      show: true,
    }
  },
}
</script>

<style lang="scss" scoped>
    .layertitle{
        width: 350px;
        height: 50px;
        box-sizing: border-box;
        border:2px solid #05d0eb;
        background: rgba(9,10,11,.9);
        font-size: 18px;
        font-weight: bold;
        color:#ffffff;
        div:nth-child(1){
            width:32px;
            height: 32px;
            margin-top:7px;
            margin-left:38px;
            margin-right:40px;
            float: left;
        }
        .gs{
            background:url('../../assets/company/company_register.png') no-repeat;
        }
        .jy{
            background:url('../../assets/company/company_manager.png') no-repeat;
        }
        .bx{
            background:url('../../assets/company/company_insurance.png') no-repeat;
        }
        .zj{
            background:url('../../assets/company/company_document.png') no-repeat;
        }
        .fgs{
            background:url('../../assets/company/company_fengongsi.png') no-repeat;
        }
        div:nth-child(2){
            line-height: 46px;
            float: left;
        }
        div:nth-child(3){
            width: 18px;
            height: 18px;
            float: right;
            margin-right: 10px;
            margin-top:14px;
            background: url('../../assets/company/exit_icon_off.png') no-repeat;
            cursor: pointer;
        }
        .delete:hover{
            background:url('../../assets/company/exit_icon_on.png') no-repeat;
        }
    }
</style>