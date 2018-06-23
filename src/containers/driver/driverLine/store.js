import * as DriverAPI from '@/api/driver'

const state = {
  jy: null,
  todayDriver: null,
  todayIllegal: null,
  todayAccident: null,
  toadyIrregularity: null,
  todayAlarm: null,
  runtime_route_info: null,
}
const mutations = {
  setJy(state, data) {
    state.jy = data
  },
  setTodayDriver(state, data) {
    state.todayDriver = data
  },
  setTodayIrregularity(state, data) {
    state.todayIrregularity = data
  },
  setTodayIllegal(state, data) {
    state.todayIllegal = data
  },
  setTodayAccident(state, data) {
    state.todayAccident = data
  },
  setTodayAlarm(state, data) {
    state.todayAlarm = data
  },
  setRuntime_route_info(state, data) {
    state.runtime_route_info = data
  },
}

const actions = {
  async getDriverJy({ commit }, param) {
    commit('setJy', null)
    const jy = await DriverAPI.getJy(param)
    commit('setJy', jy.data)
  },

  async getTodayDriver({ commit }, param) {
    commit('setTodayAlarm', null)
    const todayDriver = await DriverAPI.getTodayDriver(param)
    commit('setTodayAlarm', todayDriver.data)
  },

  async getToadyIrregularity({ commit }, param) {
    commit('setTodayAlarm', null)
    const toadyIrregularity = await DriverAPI.getTodayIrregularity(param)
    commit('setTodayAlarm', toadyIrregularity.data)
  },

  async getTodayIllegal({ commit }, param) {
    commit('setTodayAlarm', null)
    const todayIllegal = await DriverAPI.getTodayIllegal(param)
    commit('setTodayAlarm', todayIllegal.data)
  },

  async getTodayAccident({ commit }, param) {
    commit('setTodayAlarm', null)
    const todayAccident = await DriverAPI.getTodayAccident(param)
    commit('setTodayAlarm', todayAccident.data)
  },

  async getDriver_runtime_route_info({ commit }, param) {
    commit('setRuntime_route_info', null)
    const runtime_route_info = await DriverAPI.getDriver_runtime_route_info(param)
    commit('setRuntime_route_info', runtime_route_info.data)
  },

}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
