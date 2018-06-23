<template>
    <div class='car-item'>
      <div>MyFirstContainer</div>
      <div>{{count}}</div>  
    </div>
</template>
<script>
import { mapState } from 'vuex'

export default {
  name: 'my-second-container',
  components: {
  },
  computed: {
    ...mapState('mysecondcontainer', ['count']),
  },
}
</script>
<style lang="scss" scoped>
  .car-item{
    border: 1px solid red
  }
</style>
