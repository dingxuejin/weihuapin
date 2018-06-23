import * as comAPI from '../../../api/company'

const state = {
  data: '',
}
const mutations = {
  setData(state, data) {
    state.data = data
  },
}
const actions = {
  getCompanyMsg({ commit }) {
    comAPI.getCompanyMsg().then((data) => {
      // console.log('store data', data)
      commit('setData', data)
    }).catch((error) => {
      console.log('企业信息数据请求失败', error)
    })
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
