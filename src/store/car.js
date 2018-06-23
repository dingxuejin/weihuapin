import Vue from 'vue'
import Vuex from 'vuex'

import carListCostsContainer from '@/containers/car/carListCostsContainer/store'

Vue.use(Vuex)
export default new Vuex.Store({
  modules: {
    carListCostsContainer,
  },
})
