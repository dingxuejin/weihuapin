import * as DriverAPI from '@/api/driver'

const state = {
  driverBehaviorSpeedCountInfo: null,
  driverBehaviorSpeedStatistics: null,
  // getDriverBehaviorSpeedStatistics
}
const mutations = {
  setDriverBehaviorSpeedCountInfo(state, data) {
    state.driverBehaviorSpeedCountInfo = data
  },
  setDriverBehaviorSpeedStatistics(state, data) {
    state.driverBehaviorSpeedStatistics = data
  },
}
const actions = {
  async getDriverBehaviorSpeedCountInfo({ commit }, param) {
    commit('setDriverBehaviorSpeedCountInfo', null)
    const driverBehaviorSpeedCountInfo = await DriverAPI.getDriverBehaviorSpeedCountInfo(
      param,
    )
    // console.log('速度标准差变化趋势', driverBehaviorSpeedCountInfo.data)
    commit(
      'setDriverBehaviorSpeedCountInfo',
      driverBehaviorSpeedCountInfo.data,
    )
  },
  async getDriverBehaviorSpeedStatistics({ commit }, param) {
    commit('setDriverBehaviorSpeedStatistics', null)
    const driverBehaviorSpeedStatistics = await DriverAPI.getDriverBehaviorSpeedStatistics(
      param,
    )
    // console.log('速度标准差变化趋势', driverBehaviorSpeedCountInfo.data)
    commit(
      'setDriverBehaviorSpeedStatistics',
      driverBehaviorSpeedStatistics.data,
    )
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
