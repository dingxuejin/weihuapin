import * as DriverAPI from '@/api/driver'

const state = {
  popUpTrainInfo: null,
}
const mutations = {
  setPopUpTrainInfo(state, data) {
    state.popUpTrainInfo = data
  },
}
const actions = {
  async getPopUpTrainInfo({ commit }, param) {
    // commit('setPopUpTrainInfo', null)
    const popUpTrainInfo = await DriverAPI.getPopUpTrainInfo(param)
    commit('setPopUpTrainInfo', popUpTrainInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
