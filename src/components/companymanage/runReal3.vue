<template>
    <div class="runReal3">
        <div class="left">
            <div>{{name}}</div>
            <div>{{num}}</div>
        </div>
        <div class="right">
            <div :class="[bg]"></div>
            <div>变化趋势</div>
        </div>
    </div>
</template>

<script>
export default{
  props: ['name', 'num', 'bg'],
}
</script>

<style lang="scss" scoped>
    .runReal3{
        width:460px;
        height: 90px;
        .left{
            float: left;
            width:220px;
            div:nth-child(1){
                height: 30px;
                line-height:30px;
                text-align:center;
                font-size:14px;
                color:#88dddf;
                margin-bottom:10px;
                background: rgba(3,139,252,.3);
            }
            div:nth-child(2){
                height: 50px;
                box-sizing: border-box;
                font-size: 32px;
                font-weight: bold;
                font-family: 'digi';
                line-height: 50px;
                text-align: center;
                position: relative;
                color:#88dddf;
                border:1px solid #81d9e5;
            }
        }
        .right{
            float: left;
            width:230px;
            margin-left:10px;
            div:nth-child(1){
                width:34px;
                height:42px;
                margin:15px auto;
            }
            div:nth-child(2){
                font-size: 14px;
                color:#88dddf;
                text-align: center;
            }
            .red{
                background: url('../../assets/companymanage/arrow_red.png');
            }
            .green{
                background: url('../../assets/companymanage/arrow_green.png');
            }
        }
    }
</style>