import * as DriverAPI from '@/api/driver'

const state = {
  currentData: null,
  lastData: null,
  badDriver: null,
  irregularity: null,
  illegal: null,
  accident: null,
}
const mutations = {
  setYearData(state, data) {
    state.currentData = data.currYear
    state.lastData = data.lastYear
  },
  setMonthData(state, data) {
    state.currentData = data.currMonth
    state.lastData = data.lastMonth
  },
  setBadDriver(state, data) {
    state.badDriver = data
  },
  setIrregularity(state, data) {
    state.irregularity = data
  },
  setIllegal(state, data) {
    state.illegal = data
  },
  setAccident(state, data) {
    state.accident = data
  },
}
const actions = {
  async getMonthKh({ commit }, param) {
    commit('setMonthData', {
      currMonth: null,
      lastMonth: null,
    })
    const monthKh = await DriverAPI.getKhxmydfjpm(param)
    commit('setMonthData', monthKh.data)
  },
  async getYearKh({ commit }, param) {
    commit('setYearData', {
      currYear: null,
      lastYear: null,
    })
    const yearKh = await DriverAPI.getKhxmndfjpm(param)
    commit('setYearData', yearKh.data)
  },
  async getBadDrive({ commit }, param) {
    commit('setBadDriver', null)
    const badDriver = await DriverAPI.getQngrmxsbj(param)
    commit('setBadDriver', badDriver.data)
  },
  async getIrregularity({ commit }, param) {
    commit('setIrregularity', null)
    const irregularity = await DriverAPI.getQngrmxswg(param)
    commit('setIrregularity', irregularity.data)
  },
  async getIllegal({ commit }, param) {
    commit('setIllegal', null)
    const illegal = await DriverAPI.getQngrbglwf(param)
    commit('setIllegal', illegal.data)
  },
  async getAccident({ commit }, param) {
    commit('setAccident', null)
    const accident = await DriverAPI.getQngrwglsg(param)
    commit('setAccident', accident.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
