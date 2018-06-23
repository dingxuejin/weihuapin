import * as DriverAPI from '@/api/driver'

const state = {
  trainDetailsInfo: null,
}
const mutations = {
  setTrainDetailsInfo(state, data) {
    state.trainDetailsInfo = data
  },
}
const actions = {
  async getTrainDetailsInfo({ commit }, param) {
    commit('setTrainDetailsInfo', null)
    const trainDetailsInfo = await DriverAPI.getTrainDetailsInfo(param)
    commit('setTrainDetailsInfo', trainDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
