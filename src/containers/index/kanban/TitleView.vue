<template>
    <div class="title">
        {{title}}
    </div>
</template>
<script>
export default {
  props: {
    title: {
      type: String,
      default: '企业数量统计',
    },
  },
}
</script>
<style lang="scss" scoped>
.title{
    height: 30px;
    line-height: 30px;
    background-color:rgba(3,139,252,0.4);
}
</style>
