import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverAccidentTrend: null,
}
const mutations = {
  setData(state, data) {
    state.driverAccidentTrend = data
  },
}
const actions = {
  async getDriverAccidentTrend({ commit }, param) {
    commit('setData', null)
    const driverAccidentTrend = await CompanySecureAPI.getDriverAccidentTrend(
      param,
    )
    commit('setData', driverAccidentTrend.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
