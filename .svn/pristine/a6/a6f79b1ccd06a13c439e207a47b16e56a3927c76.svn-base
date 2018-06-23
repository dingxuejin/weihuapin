import * as DriverAPI from '@/api/driver'

const state = {
  pm: null,
}
const mutations = {
  setPm(state, data) {
    state.pm = data
  },
}
const actions = {
  async getPm({ commit }, param) {
    commit('setPm', null)
    const pm = await DriverAPI.getPm(param)
    commit('setPm', pm.data[0])
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
