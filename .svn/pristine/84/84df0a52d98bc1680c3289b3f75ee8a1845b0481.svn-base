import * as DriverAPI from '@/api/driver'

const state = {
  punishCountInfo: null,
}
const mutations = {
  setPunishCountInfo(state, data) {
    state.punishCountInfo = data
  },
}
const actions = {
  async getPunishCountInfo({ commit }, param) {
    commit('setPunishCountInfo', null)
    const punishCountInfo = await DriverAPI.getPunishCountInfo(param)
    // console.log('惩罚统计信息', punishCountInfo.data)
    commit('setPunishCountInfo', punishCountInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
