// CarRealtimeMap
import * as CarAPI from '@/api/car'

const state = {
  showRealtimeMap: false,
  CarLocationInfo: {},
}
const mutations = {
  setShowRealtimeMap(state, data) {
    state.showRealtimeMap = data
  },
  setCarLocationInfo(state, data) {
    state.showRealtimeMap = true
    state.CarLocationInfo = data
  },
}
const actions = {
  async getCarLocationInfo({ commit }, params) {
    const res = await CarAPI.getCarLocationInfo(params)
    if (res.status === 200) {
      commit('setCarLocationInfo', res.data)
    }
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
