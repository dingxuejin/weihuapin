<template>
  <div class='widget'>
      <div class='widget_title'>
          I am frame Title from carDetails home
      </div>
  </div>
</template>
<script>
export default {
  name: 'car-details-info',
}
</script>
<style lang="scss" scoped>
    .widget{
        border: 1px solid red;
        height: 300px;
        width: 400px;
        margin:0 auto;
        background:pink;
        &_title{
            border-bottom: 1px solid red;
            width: 100%;
            height: 50px
        }
    }
</style>
