<template>
    <div class="pop">
        <div class="name">{{name}}</div>
        <div class="value">
            <div></div>
            <div>{{value}}</div>
        </div>
    </div>
</template>

<script>
export default{
  props: ['name', 'value'],
}
</script>

<style lang="scss" scoped>
.pop{
    height: 30px;
    .name{
        font-size: 16px;
        color:#89dddf;
        line-height:30px;
        width:110px;
        float: left;
    }
    .value{
        width: 240px;
        height: 30px;
        box-sizing: border-box;
        border:1px solid #81d9e5;
        font-size: 14px;
        color: #ffffff;
        line-height: 28px;
        float: left;
        div:nth-child(1){
            width:10px;
            height: 10px;
            float: left;
            margin:9px 10px 9px 9px;
            background:rgba(5,208,235,1);
            transform:rotate(45deg);
        }
        div:nth-child(2){
            float: left;
        }
    }
}
</style>