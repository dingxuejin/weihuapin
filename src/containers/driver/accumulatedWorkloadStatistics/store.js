import * as DriverAPI from '@/api/driver'

const state = {
  pm: null,
  showYoM: 'y',
  leftPMData: null,
}
const mutations = {
  setPm(state, data) {
    state.pm = data
  },
  setshowYoM(state, data) {
    state.showYoM = data
  },
  setleftPMData(state, data) {
    state.leftPMData = data
  },
}
const actions = {
  async getPm({
    commit,
  }, param) {
    const pm = await DriverAPI.getPm(param)
    commit('setPm', pm.data[0])
  },
  async getleftPMData({
    commit,
  }, param) {
    const leftPMDataWrap = await DriverAPI.getleftPMData(param)
    commit('setleftPMData', leftPMDataWrap.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
