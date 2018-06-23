<template>
  <div class='widget'>
      <div class='widget_title'>
          I am frame Title
      </div>
      <div class='widget_content'>
          I am frame container
          <slot></slot>
      </div>
  </div>
</template>
<script>
export default {
  name: 'big-frame',
}
</script>
<style lang="scss" scoped>
    .widget{
        border: 1px solid red;
        height: 300px;
        width: 400px;
        &_title{
            border-bottom: 1px solid red;
            width: 100%;
            height: 50px
        }
        &_content{
            width: 100%;
            height: 250px
        }
    }
</style>
