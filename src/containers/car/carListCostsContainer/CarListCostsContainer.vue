<template>
  <car-list-costs :clfytjData='clfytjData'>
  </car-list-costs>
</template>
<script>
import { mapState } from 'vuex'
import CarListCosts from '@/components/car/CarListCosts'

export default {
  components: {
    CarListCosts,
  },
  data() {
    return {
    }
  },
  computed: {
    ...mapState('carListCostsContainer', ['clfytjData']),
  },
  methods: {},
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
</style>
