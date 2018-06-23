import * as DriverAPI from '@/api/driver'

const state = {
  popUpTrainInfo: null,
  SubjectInfo: null,
  SubjectTimeColor: null,
}
const mutations = {
  setPopUpTrainInfo(state, data) {
    state.popUpTrainInfo = data
  },
  setSubject(state, data) {
    state.SubjectInfo = data
  },
  setSubjectTimeColor(state, data) {
    state.SubjectTimeColor = data
  },
}
const actions = {
  async getPopUpTrainInfo({ commit }, param) {
    commit('setPopUpTrainInfo', null)
    const popUpTrainInfo = await DriverAPI.getPopUpTrainInfo(param)
    commit('setPopUpTrainInfo', popUpTrainInfo.data)
  },
  async getSubject({ commit }, param) {
    commit('setSubject', null)
    const subject = await DriverAPI.getSubject(param)
    commit('setSubject', subject.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
