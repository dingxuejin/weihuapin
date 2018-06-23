import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  secureDriverOrder: null,
}
const mutations = {
  setData(state, data) {
    state.secureDriverOrder = data
  },
}
const actions = {
  async getSecureDriverOrder({ commit }, param) {
    commit('setData', null)
    const secureDriverOrder = await CompanySecureAPI.getSecureDriverOrder(param)
    commit('setData', secureDriverOrder.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
