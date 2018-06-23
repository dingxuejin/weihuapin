import * as CompanyAPI from '@/api/company'

const state = {
  recentlyAccdient: null,
  carBaseInfo: {},
  WaybillProgressList: [],
  WaybillProgressListData: [],
}
const mutations = {
  setData(state, data) {
    state.recentlyAccdient = data
  },
  setCarBaseInfoMap(state, data) {
    state.carBaseInfo = data
  },
  setWaybillProgressList(state, data) {
    state.WaybillProgressList = data.ydzt_filter
    state.WaybillProgressListData = data.qy_dzyd
  },
}
const actions = {
  async getRecentlyAccident({ commit }, param) {
    commit('setData', null)
    const recentlyAccdient = await CompanyAPI.getRecentlyAccident(param)
    commit('setData', recentlyAccdient.data)
  },
  async getCarBaseInfoMap({ commit }, param) {
    const res = await CompanyAPI.getCarBaseInfoMap(param)
    commit('setCarBaseInfoMap', res.data)
  },
  // 获取运单进度列表
  async getWaybillProgressList({ commit }, params) {
    const res = await CompanyAPI.getWaybillProgressList(params)
    commit('setWaybillProgressList', res.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
