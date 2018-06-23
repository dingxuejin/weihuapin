import * as DriverAPI from '@/api/driver'

const state = {
  trainCountInfo: null,
}
const mutations = {
  setTrainCountInfo(state, data) {
    state.trainCountInfo = data
  },
}
const actions = {
  async getTrainCountInfo({ commit }, param) {
    commit('setTrainCountInfo', null)
    const trainCountInfo = await DriverAPI.getTrainCountInfo(param)
    commit('setTrainCountInfo', trainCountInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
