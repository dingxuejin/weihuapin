import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverAccidentAreaCount: null,
}
const mutations = {
  setData(state, data) {
    state.driverAccidentAreaCount = data
  },
}
const actions = {
  async getDriverAccidentAreaCount({ commit }, param) {
    commit('setData', null)
    const driverAccidentAreaCount = await CompanySecureAPI.getDriverAccidentAreaCount(
      param,
    )
    commit('setData', driverAccidentAreaCount.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
