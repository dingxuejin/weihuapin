import * as CompanyAPI from '@/api/company'

const state = {
  companyExpireTip: null,
  companyExpireNum: 0,
}

const mutations = {
  setCompanyExpireTip(state, data) {
    /* eslint-disable */
    const car = data.car.filter(o => o.expiry_reminder_days_code == '-1').length
    const company = data.company.filter(o => o.expiry_reminder_days_code == '-1').length
    const driver = data.driver.filter(o => o.expiry_reminder_days_code == '-1').length
    state.companyExpireTip = data
    state.companyExpireNum=car+company+driver
  }
}

const actions = {
  async getCompanyExpireTip({ commit }, params) {
    const res = await CompanyAPI.getCompanyExpireTip(params)
    commit('setCompanyExpireTip', res.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
