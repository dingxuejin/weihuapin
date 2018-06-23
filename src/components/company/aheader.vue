<template>
  <div class="header">
    <span>{{name}}</span>
    <div class="btn" :class="{omit:show}" @click='up'></div>
  </div>
</template>

<script>
  export default {
    props: ['name', 'show'],
    methods: {
      up() {
        this.$emit('click')
      },
    },
  }

</script>

<style lang="scss" scoped>
    .header{
        height: 30px;
        background: url('../../assets/company/left_header_strip.png');
        font-size: 18px;
        font-weight: bold;
        line-height: 30px;
        text-indent: 50px;
        position: relative;
        color:#89dddf;
        .btn{
            width: 28px;
            height:24px;
            background:url('../../assets/company/home.png') no-repeat;
            position:absolute;
            top:1px;
            right:10px;
            cursor: pointer;
        }
        .omit{
           width: 20px;
           height: 5px;
           background:url('../../assets/car/circleButton.png') no-repeat; 
           top:12px;
        }
    }
</style>
