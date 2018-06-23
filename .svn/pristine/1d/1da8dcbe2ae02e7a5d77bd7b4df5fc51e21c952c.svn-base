import * as DriverAPI from '@/api/driver'

const state = {
  workStrengthCountInfo: null,
}
const mutations = {
  setWorkStrengthCountInfo(state, data) {
    state.workStrengthCountInfo = data
  },
}
const actions = {
  async getWorkStrengthCountInfo({ commit }, param) {
    commit('setWorkStrengthCountInfo', null)
    const workStrengthCountInfo = await DriverAPI.getWorkStrengthCountInfo(
      param,
    )
    commit('setWorkStrengthCountInfo', workStrengthCountInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
