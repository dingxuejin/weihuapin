import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverDangerCount: null,
}
const mutations = {
  setData(state, data) {
    state.driverDangerCount = data
  },
}
const actions = {
  async getDriverDangerCount({ commit }, param) {
    commit('setData', null)
    const driverDangerCount = await CompanySecureAPI.getDriverDangerCount(
      param,
    )
    commit('setData', driverDangerCount.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
