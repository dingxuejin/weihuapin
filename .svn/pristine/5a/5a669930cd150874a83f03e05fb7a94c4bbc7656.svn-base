import * as DriverAPI from '@/api/driver'

const state = {
  workStrengthDetailsInfo: null,
}
const mutations = {
  setWorkStrengthDetailsInfo(state, data) {
    state.workStrengthDetailsInfo = data
  },
}
const actions = {
  async getWorkStrengthDetailsInfo({ commit }, param) {
    commit('setWorkStrengthDetailsInfo', null)
    const workStrengthDetailsInfo = await DriverAPI.getWorkStrengthDetailsInfo(
      param,
    )
    commit('setWorkStrengthDetailsInfo', workStrengthDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
