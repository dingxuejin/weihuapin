import * as DriverAPI from '@/api/driver'

const state = {
  workOrderDetailsInfo: null,
}
const mutations = {
  setWorkOrderDetailsInfo(state, data) {
    state.workOrderDetailsInfo = data
  },
}
const actions = {
  async getWorkOrderDetailsInfo({ commit }, param) {
    commit('setWorkOrderDetailsInfo', null)
    const workOrderDetailsInfo = await DriverAPI.getWorkOrderDetailsInfo(param)
    // console.log('订单详细信息', workOrderDetailsInfo.data)
    commit('setWorkOrderDetailsInfo', workOrderDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
