<template>
    <div class="carsMsg-content">
        <div class="companyCar-indexCon-title">
            {{data.name}}
        </div>
        <div class="companyCar-index">
            {{qf(data.value)}}
        </div>
        <div class="companyCar-unit">
            {{data.unit}}      
        </div>
    </div>
</template>

<script type="text/javascript">
export default {
  name: 'carsMsg',
  components: {},
  props: ['data'],
  data() {
    return {
    }
  },
}

</script>

<style lang="scss" scoped>
    .carsMsg-content{
        width:100%;
        height: 100%;
        overflow: hidden;
        margin-right:10px;
        position: relative;

        /* background: pink; */
    }
    .companyCar-indexCon-title{
        width:100%;
        height: 40px;
        overflow: hidden;        
        border-bottom:2px solid #81d9e5;
        color:#fff;
        font-size: 18px;
        line-height: 38px;
    }
    .companyCar-index{
        width:100%;
        height: 60px;
        overflow:hidden;
        margin-top:10px;
        background: url('../../assets/company/right_bg1.png');
        color:#05d0eb;
        font-size: 60px;
        font-weight: bold;
        text-indent: 10px;
        line-height: 60px;
        font-family: 'digi';
    }
    .companyCar-unit{
        position: absolute;
        right: 10px;
        bottom: 12px;
        color:#fff;
        font-size: 18px;
    }

</style>