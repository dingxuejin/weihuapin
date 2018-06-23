import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  cargoId_name: { value: 93, lbael: '全部' },
}
const mutations = {
  setData(state, data) {
    if (data && data.length > 0) {
      const newData = data.map((val) => {
        const newOpo = {}
        newOpo.value = val.cargo_id
        newOpo.label = val.cargo_name
        return newOpo
      })
      state.cargoId_name = newData
    } else {
      state.cargoId_name = null
    }
  },
}
const actions = {
  async getCargoId_name({ commit }) {
    const cargoId_name = await CompanyManageAPI.getCargoId_name()
    commit('setData', cargoId_name.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
