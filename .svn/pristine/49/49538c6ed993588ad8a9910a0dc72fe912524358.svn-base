import * as CarAPI from '@/api/car'

const state = {
  czzbxxData: null,
}
const mutations = {
  setCzbxx(state, data) {
    state.czzbxxData = data
  },
}
const actions = {
  async getCzzbxx({ commit }, vehicleId) {
    const czzbxx = await CarAPI.getCzzbxx(vehicleId)
    commit('setCzbxx', czzbxx.data)
  },

}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
