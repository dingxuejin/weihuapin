import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverIllegalCount: null,
}
const mutations = {
  setData(state, data) {
    state.driverIllegalCount = data
  },
}
const actions = {
  async getDriverIllegalCount({ commit }, param) {
    commit('setData', null)
    const driverIllegalCount = await CompanySecureAPI.getDriverIllegalCount(
      param,
    )
    commit('setData', driverIllegalCount.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
