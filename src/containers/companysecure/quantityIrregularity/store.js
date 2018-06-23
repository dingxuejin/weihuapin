import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverIrregularityCount: null,
}
const mutations = {
  setData(state, data) {
    state.driverIrregularityCount = data
  },
}
const actions = {
  async getDriverIrregualarityCount({ commit }, param) {
    commit('setData', null)
    const driverIrregularityCount = await CompanySecureAPI.getDriverIrregualarityCount(
      param,
    )
    commit('setData', driverIrregularityCount.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
