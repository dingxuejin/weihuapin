import * as DriverAPI from '@/api/driver'

const state = {
  punishDetailsInfo: null,
}
const mutations = {
  setPunishDetailsInfo(state, data) {
    state.punishDetailsInfo = data
  },
}
const actions = {
  async getPunishDetailsInfo({ commit }, param) {
    commit('setPunishDetailsInfo', null)
    const punishDetailsInfo = await DriverAPI.getPunishDetailsInfo(param)
    // console.log('惩罚详细信息', punishDetailsInfo.data)
    commit('setPunishDetailsInfo', punishDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
