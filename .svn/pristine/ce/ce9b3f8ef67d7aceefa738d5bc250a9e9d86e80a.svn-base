<template>
  <div>
    <amessage>
      <aheader slot='header'
               name='线路信息'
               show='true'
               @click='up'></aheader>
      <aline slot='content'
             :dataNum='lineMsg'>
        <pieRose chartTheme="dark"
                 :data="lineMsg"
                 :color="pieRoseColor"
                 v-if="lineMsg"></pieRose>
        <loading :data='lineMsg'></loading>
      </aline>
    </amessage>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import amessage from '../../../components/company/amessage'
import aheader from '../../../components/company/aheader'
import aline from '../../../components/company/aline'
import pieRose from '../../../components/charts/lineMsgPieRose'

export default {
  components: {
    amessage,
    aheader,
    aline,
    pieRose,
  },
  computed: {
    ...mapState('lineMsgStore', ['lineMsg']),
  },
  methods: {
    up() {
      // console.log('123')
      this.$emit('upx')
    },
  },
  data() {
    return {
      pieRoseColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
    }
  },
}
</script>
