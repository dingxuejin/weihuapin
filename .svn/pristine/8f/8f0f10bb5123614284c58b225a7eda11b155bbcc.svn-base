import * as DriverAPI from '@/api/driver'

const state = {
  DriverMyselfTag: null,
  DriverTheirTag: null,
}
const mutations = {
  setDriverMyselfTag(state, data) {
    state.DriverMyselfTag = data
  },
  setDriverTheirTag(state, data) {
    state.DriverTheirTag = data
  },
}

const actions = {
  async getDriverMyselfTag({ commit }, param) {
    commit('setDriverMyselfTag', { DriverMyselfTag: null })

    const MyselfTag = await DriverAPI.getDriverMyselfTag(param)
    commit('setDriverMyselfTag', MyselfTag.data)
  },
  async getDriverTheirTag({ commit }, param) {
    commit('setDriverTheirTag', { DriverTheirTag: null })

    const TheirTag = await DriverAPI.getDriverTheirTag(param)
    commit('setDriverTheirTag', TheirTag.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
