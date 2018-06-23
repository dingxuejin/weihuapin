<template>
  <car-models-search @receiverParams="getParams" :cljcxxData_ErroMsg='cljcxxData_ErroMsg'></car-models-search>
</template>
<script>
import CarModelsSearch from '@/components/car/CarModelsSearch'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    CarModelsSearch,
  },
  data() {
    return {
      // plate_number: 'R85927',
      plate_number: '京AAF905',
    }
  },
  computed: {
    ...mapState('carModelsSearchContainer', ['cljcxxData', 'cljcxxData_ErroMsg']),
  },
  methods: {
    ...mapActions('carModelsSearchContainer', ['getCljcxx']),

    getParams(data) {
      this.plate_number = data
      this.getCljcxx(this.plate_number)
    },
  },
  mounted() {
    this.getCljcxx(this.plate_number)
  },
}
</script>
<style lang="scss" scoped>

</style>
