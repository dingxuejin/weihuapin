import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  volumeInterstateEntity: null,
}
const mutations = {
  setData(state, data) {
    state.volumeInterstateEntity = data
  },
}
const actions = {
  async getVolumeInterstateEntity({ commit }, param) {
    commit('setData', null)
    const volumeInterstateEntity = await CompanyManageAPI.getVolumeInterstateEntity(
      param,
    )
    commit('setData', volumeInterstateEntity.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
