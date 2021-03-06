import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  // behaviorScore: null,
  tb_subject_qy_qyaqfz: null,
}
const mutations = {
  // setData(state, data) {
  //   state.behaviorScore = data
  // },
  settb_subject_qy_qyaqfz(state, data) {
    state.tb_subject_qy_qyaqfz = data
  },
}
const actions = {
  // async getBehaviorScore({ commit }, param) {
  //   commit('setData', null)
  //   const behaviorScore = await CompanySecureAPI.getBehaviorScore(param)
  //   commit('setData', behaviorScore.data)
  // },
  async gettb_subject_qy_qyaqfz({
    commit,
  }, param) {
    // commit('setData', null)
    const tb_subject_qy_qyaqfz = await CompanySecureAPI.gettb_subject_qy_qyaqfz(param)
    commit('settb_subject_qy_qyaqfz', tb_subject_qy_qyaqfz.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
