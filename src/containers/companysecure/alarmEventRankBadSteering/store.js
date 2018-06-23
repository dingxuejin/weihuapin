import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  BadSteering: null,
}
const mutations = {
  setBadSteering(state, data) {
    state.BadSteering = data
  },
}
const actions = {
  async getBadSteering({ commit }, param) {
    commit('setBadSteering', null)
    const badSteering = await CompanySecureAPI.getBadSteering(param)
    commit('setBadSteering', badSteering.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
