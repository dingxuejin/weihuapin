import * as DriverAPI from '@/api/driver'

const state = {
  punishInfo: null,
}
const mutations = {
  setPunishInfo(state, data) {
    state.punishInfo = data
  },
}
const actions = {
  async getPunishInfo({ commit }, param) {
    commit('setPunishInfo', null)
    const punishInfo = await DriverAPI.getPunishInfo(param)
    // console.log('惩罚信息一级弹窗', punishInfo.data)
    commit('setPunishInfo', punishInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
