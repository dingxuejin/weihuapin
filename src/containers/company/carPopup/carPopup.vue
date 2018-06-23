<template>
  <div class="pop" v-drag  @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
    <PopUpFrame @close='up'>
      <PopUpWidget title='车载终端安装比例'>
        <div class="echart">
          <ring-single chartTheme='dark'
                       :data='vehicleTermailRatio'
                       :color="ringSingleColor"
                       :showLabel=true
                       v-if="vehicleTermailRatio"
                       :borderColor="ringSingleBorderColor"
                       fontSize="16"></ring-single>
          <loading :data='vehicleTermailRatio'></loading>
        </div>
      </PopUpWidget>
    </PopUpFrame>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'
import ringSingle from '../../../components/charts/ringSingle'

export default {
  components: {
    PopUpFrame,
    PopUpWidget,
    ringSingle,
  },
  computed: {
    ...mapState('carPopup', ['vehicleTermailRatio']),
  },
  methods: {
    up() {
      this.$emit('upx')
    },
  },
  data: () => ({
    ringSingleColor: [
      '#05d0eb',
      '#81d9e5',
      '#f6ffcb',
      '#e75029',
      '#038bfc',
      '#006a55',
    ],
    ringSingleBorderColor: [
      '#05d0eb',
      '#81d9e5',
      '#f6ffcb',
      '#e75029',
      '#038bfc',
      '#006a55',
    ],
    move: false,
  }),
  mounted() {
    // console.log('vehicleTermailRatio', this.vehicleTermailRatio)
  },
}
</script>

<style lang="scss" scoped>
.pop {
  width: 750px;
}
.echart {
  height: 200px;
  //   background: lightblue;
}
</style>