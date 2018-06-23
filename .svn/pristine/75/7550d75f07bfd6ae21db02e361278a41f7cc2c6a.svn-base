// import * as ComSAPI from '@/api/companysecure'

const state = {
  title: null,
  selectedType: '',

  // 显示/隐藏状态
  detailsShow: false,
  // 到期信息显示或者隐藏
  terminal_configration_Details_show: false,
  warning_protection_details_show: false,
}
const mutations = {
  // // 触发弹框显示及隐藏
  // getComDetails(state) {
  //   state.detailsShow = true
  // },
  closeComDetails(state) {
    state.detailsShow = false
  },

  warningDetails(state, params) {
    state.detailsShow = true
    state.title = params.title
    state.selectedType = params.type
  },
}
const actions = {}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
