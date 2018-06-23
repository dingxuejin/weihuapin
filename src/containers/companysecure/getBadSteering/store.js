import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  BadSteering: null,
}
const mutations = {
  setBadSteering(state, data) {
    state.badDriver = data
  },
}
const actions = {
  async alarmEventRankBadSteering({ commit }, param) {
    commit('setBadSteering', null)
    const badSteering = await CompanySecureAPI.alarmEventRankBadSteering(param)
    commit('setBadSteering', badSteering.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
