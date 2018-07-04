import * as CompanyManageAPI from '@/api/companymanage'

const waybillAndTurnoverStatistics = {
  namespaced: true,
  state: {
    waybill: null,
    turnover: null,
  },
  mutations: {
    setTbSubjectQyMYRydAndHwzzl(state, data) {
      console.log(data)
      state.waybill = data[0]
      state.turnover = data[1]
    },
  },
  actions: {
    async requireTbSubjectQyMYRydAndHwzzl({ commit }, param) {
      const requireTbSubjectQyMYRydAndHwzzl =
       await CompanyManageAPI.requireTbSubjectQyMYRydAndHwzzl(param)
      if (requireTbSubjectQyMYRydAndHwzzl.status === 200) {
        commit('setTbSubjectQyMYRydAndHwzzl', requireTbSubjectQyMYRydAndHwzzl.data)
      }
    },
  },
}
export default waybillAndTurnoverStatistics
