import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverDangerTrend: null,
}
const mutations = {
  setData(state, data) {
    state.driverDangerTrend = data
  },
}
const actions = {
  async getDriverDangerTrend({ commit }, param) {
    commit('setData', null)
    const driverDangerTrend = await CompanySecureAPI.getDriverDangerTrend(param)
    commit('setData', driverDangerTrend.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
