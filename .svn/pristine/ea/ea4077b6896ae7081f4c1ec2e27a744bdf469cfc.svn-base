import * as DriverAPI from '@/api/driver'

const state = {
  workOrderCountInfo: null,
}
const mutations = {
  setWorkOrderCountInfo(state, data) {
    state.workOrderCountInfo = data
  },
}
const actions = {
  async getWorkOrderCountInfo({ commit }, param) {
    commit('setWorkOrderCountInfo', null)
    const workOrderCountInfo = await DriverAPI.getWorkOrderCountInfo(param)
    commit('setWorkOrderCountInfo', workOrderCountInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
