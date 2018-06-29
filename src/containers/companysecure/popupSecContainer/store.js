/*eslint-disable */
import * as CompanySecureAPI from "@/api/companysecure";

const state = {
  // data：数据部分
  // 所有驾驶行为
  tb_subject_qy_gwqy: null,
  // 1.高危驾驶行为区域分布
  driver_danger_distribute_trend_area: null,
  // 2.高危驾驶行为时段分布变化趋势
  driver_danger_distribute_trend_interval: null,
  // 3.违规行为区域分布变化趋势
  driver_irregularity_distribute_trend_area: null,
  // 4.违规行为时段分布变化趋势
  driver_irregularity_distribute_trend_interval: null,
  // 5.违法行为区域分布变化趋势
  driver_illegal_distribute_trend_area: null,
  // 6.违法行为时段分布变化趋势
  driver_illegal_distribute_trend_interval: null,
  // 7.事故详情
  tb_business_yzsg: null,
  // 9.不同类型事故区域分布
  AccidentDistributeTrendArea: null,
  // 8.不同周期高危驾驶行为数量（高危驾驶行为数量变化趋势弹框）
  driverDangerCount: null,
  // 不同周期违规行为数量（违规行为行为数量变化趋势弹框）
  driverIrregularityCount: null,
  // 不同周期违法行为数量（违法行为行为数量变化趋势弹框）
  driverIllegalCount: null,


  // 显示/隐藏状态（弹框部分）
  detailsShow: false,
  /*高危驾驶行为区域分布 */
  distributeTrendArea_show: false,
  /* 高危驾驶行为时段分布 */
  distributeTrendTime_show: false,
  /**违规行为区域分布 */
  irregularityDistributeTrendArea_Show: false,
  /**违规行为时段分布 */
  irregularityDistributeTrendInterval_show: false,
  /*0621-1违法行为区域分布变化趋势 弹出框显示隐藏*/
  illegalDistributeTrendArea_show: false,
  /*0621-2 违法行为时段分布变化趋势弹出框显示隐藏 */
  illegalDistributeTrendInterval_show: false,
  /*0621-3不同类型事故时间分布弹出框显示隐藏 */
  accidentDistributeTrendInterval_show: false,
  /*0621-4不同类型事故区域分布弹窗显示隐藏 */
  accidentDistributeTrendArea_show: false,
  /*0621-5事故详情 */
  accidentDetails_show: false,
  /*0621-6 不同周期高危驾驶行为数量*/
  differentDateTrend_show: false,
  /*不同周期违规行为数量 */
  quantityIrregularity_show: false,
  /*不同周期违法行为数量 */
  quantityIllegal_show: false,
  // popup state
  accidentDistributeTrendInterval: null
};
const mutations = {
  // setData(state, { name, data }) {
  //   state[name] = data
  // },
  // 触发弹框显示及隐藏
  getComDetails(state, o) {
    // 高驾行为区域分布
    // if (o === "areaDistri") {
    //   state.detailsShow = true;
    //   state.distributeTrendArea_show = true;
    // }
    // 高驾行为时段分布
    // if (o === "timeDistri") {
    //   state.detailsShow = true;
    //   state.distributeTrendTime_show = true;
    // }
    // 违规行为区域分布
    // if (o === "irregularityArea") {
    //   state.detailsShow = true;
    //   state.irregularityDistributeTrendArea_Show = true;
    // }
    // 违规行为时段分布
    // if (o === "irregularityInterval") {
    //   state.detailsShow = true;
    //   state.irregularityDistributeTrendInterval_show = true;
    // }
    // // 违法行为区域分布
    // if (o === "illegalArea") {
    //   state.detailsShow = true;
    //   state.illegalDistributeTrendArea_show = true;
    // }
    // 违法行为时段分布
    // if (o === "illegalInterval") {
    //   state.detailsShow = true;
    //   state.illegalDistributeTrendInterval_show = true;
    // }
    // 事故时段分布
    // if (o === "accidentInterval") {
    //   state.detailsShow = true;
    //   state.accidentDistributeTrendInterval_show = true;
    // }
    // 事故区域分布
    // if (o === "accidentArea") {
    //   state.detailsShow = true;
    //   state.accidentDistributeTrendArea_show = true;
    // }
    // 事故浏览
    // if (o === "accidentDetails") {
    //   state.detailsShow = true;
    //   state.accidentDetails_show = true;
    // }
    // // 不同周期高危驾驶行为数量
    // if (o === "quantityDriver") {
    //   state.detailsShow = true;
    //   state.differentDateTrend_show = true;
    // }
    // 不同周期违规行为数量
    // if (o === "quantityIrregularity") {
    //   state.detailsShow = true;
    //   state.quantityIrregularity_show = true;
    // }
    // 不同周期违法行为数量
    // if (o === "quantityIllegal") {
    //   state.detailsShow = true;
    //   state.quantityIllegal_show = true;
    // }
    return true;
  },
  closeComDetails(state, o) {
    // 不同周期高危驾驶行为数量（高危驾驶行为数量变化趋势弹框）
    // if (o === "不同周期高危驾驶行为数量") {
    //   state.detailsShow = false;
    //   state.differentDateTrend_show = false;
    // }
    // 不同周期违规行为数量（违规行为行为数量变化趋势弹框）
    // if (o === "不同周期违规行为数量") {
    //   state.detailsShow = false;
    //   state.quantityIrregularity_show = false;
    // }
    // 不同周期违法行为数量（违法行为行为数量变化趋势弹框）
    // if (o === "不同周期违法行为数量") {
    //   state.detailsShow = false;
    //   state.quantityIllegal_show = true;
    // }
    // 高危驾驶行为区域分布变化趋势（高驾行为区域分布弹框）
    // if (o === "高危驾驶行为区域分布变化趋势") {
    //   state.detailsShow = false;
    //   state.distributeTrendArea_show = false;
    // }
    // 高危驾驶行为时段分布变化趋势（高驾行为时段分布弹框）
    // if (o === "高危驾驶行为时段分布变化趋势") {
    //   state.detailsShow = false;
    //   state.distributeTrendTime_show = false;
    // }
    // 违规行为区域分布变化趋势（违规行为区域分布弹框）
    // if (o === "违规行为区域分布变化趋势") {
    //   state.detailsShow = false;
    //   state.irregularityDistributeTrendArea_Show = false;
    // }
    // 违规行为时段分布变化趋势（违规行为时段分布弹框）
    // if (o === "违规行为时段分布变化趋势") {
    //   state.detailsShow = false;
    //   state.irregularityDistributeTrendInterval_show = false;
    // }
    // 违法行为区域分布变化趋势（违法行为区域分布弹框）
    // if (o === "违法行为区域分布变化趋势") {
    //   state.detailsShow = false;
    //   state.illegalDistributeTrendArea_show = false;
    // }
    // 违法行为时段分布变化趋势（违法行为时段分布弹框）
    // if (o === "违法行为时段分布变化趋势") {
    //   state.detailsShow = false;
    //   state.illegalDistributeTrendInterval_show = false;
    // }
    // 不同类型事故时间分布（事故时段分布弹框）
    // if (o === "不同类型事故时间分布") {
    //   state.detailsShow = false;
    //   state.accidentDistributeTrendInterval_show = true;
    // }
    // 不同类型事故区域分布（事故区域分布弹框）
    // if (o === "不同类型事故区域分布") {
    //   state.detailsShow = false;
    //   state.accidentDistributeTrendArea_show = true;
    // }
    // 事故详情（事故浏览弹框）
    // if (o === "事故详情") {
    //   state.detailsShow = false;
    //   state.accidentDetails_show = true;
    // }
    // console.log(state)
    // state.detailsShow = false
    // state.distributeTrendArea_show = false
    // state.distributeTrendTime_show = false
    // state.irregularityDistributeTrendArea_Show = false
    // state.irregularityDistributeTrendInterval_show = false
    // state.illegalDistributeTrendArea_show = false
    // state.illegalDistributeTrendInterval_show = false
    // state.accidentDistributeTrendInterval_show = false
    // state.accidentDistributeTrendArea_show = false
    // state.accidentDetails_show = false
    // state.differentDateTrend_show = false
    // state.quantityIrregularity_show = false
    // state.quantityIllegal_show = false
    // if (state === 'quantityDriver') {
    //   state.detailsShow = false
    //   state.quantityIllegal_show = false
    // }
  },
  // 数据
  setAccidentDistributeTrendInterval(state, data) {
    state.accidentDistributeTrendInterval = data;
  },
  settb_subject_qy_gwqy(state, data) {
    state.tb_subject_qy_gwqy = data;
  },
  setdriver_danger_distribute_trend_area(state, data) {
    state.driver_danger_distribute_trend_area = data;
  },
  setdriver_danger_distribute_trend_interval(state, data) {
    state.driver_danger_distribute_trend_interval = data;
  },
  setdriver_irregularity_distribute_trend_area(state, data) {
    state.driver_irregularity_distribute_trend_area = data;
  },
  setdriver_irregularity_distribute_trend_interval(state, data) {
    state.driver_irregularity_distribute_trend_interval = data;
  },
  setdriver_illegal_distribute_trend_area(state, data) {
    state.driver_illegal_distribute_trend_area = data;
  },
  setdriver_illegal_distribute_trend_interval(state, data) {
    state.driver_illegal_distribute_trend_interval = data;
  },
  settb_business_yzsg(state, data) {
    state.tb_business_yzsg = data;
  },
  // 不同周期高危驾驶行为数量（高危驾驶行为数量变化趋势弹框）
  setDriverDangerCount(state, data) {
    state.driverDangerCount = data
  },
  // 不同周期违规行为数量（违规行为行为数量变化趋势弹框）
  setDriverIrregularityCount(state, data) {
    state.driverIrregularityCount = data
  },
  // 不同周期违法行为数量（违法行为行为数量变化趋势弹框）
  setDriverIllegalCount(state, data) {
    state.driverIllegalCount = data
  },
  // 不同类型事故区域分布
  setAccidentDistributeTrendArea(state, data) {
    state.AccidentDistributeTrendArea = data;
  },
  /*20180621修改显示隐藏 */
  /*0621-1违法行为区域分布变化趋势 弹出框显示隐藏*/
  setillegalDistributeTrendArea_show(state, data) {
    state.illegalDistributeTrendArea_show = data;
  },
  /*0621-2 违法行为时段分布变化趋势弹出框显示隐藏 */
  setillegalDistributeTrendInterval_show(state, data) {
    state.illegalDistributeTrendInterval_show = data;
  },
  /*0621-3不同类型事故时间分布弹出框显示隐藏 */
  setaccidentDistributeTrendInterval_show(state, data) {
    state.accidentDistributeTrendInterval_show = data;
  },
  /*0621-4不同类型事故区域分布弹窗显示隐藏 */
  setaccidentDistributeTrendArea_show(state, data) {
    state.accidentDistributeTrendArea_show = data;
  },
  /*0621-5事故详情 */
  setaccidentDetails_show(state, data) {
    state.accidentDetails_show = data;
  },
  /*0621-6不同周期违法行为数量 */
  setquantityIllegal_show(state, data) {
    state.quantityIllegal_show = data;
  },
  /*不同周期高危驾驶行为数量 */
  setdifferentDateTrend_show(state, data) {
    state.differentDateTrend_show = data;
  },
  //  不同周期违规行为数量
  setquantityIrregularity_show(state, data) {
    state.quantityIrregularity_show = data;
  },
  /*高危驾驶行为区域分布 */
  setdistributeTrendArea_show(state, data) {
    state.distributeTrendArea_show = data;
  },
  /* 高危驾驶行为时段分布*/
  setdistributeTrendTime_show(state, data) {
    state.distributeTrendTime_show = data;
  },
  /*违规行为区域分布 */
  setirregularityDistributeTrendArea_Show(state, data) {
    state.irregularityDistributeTrendArea_Show = data;
  },
  /*违规行为时段分布 */
  setirregularityDistributeTrendInterval_show(state, data) {
    state.irregularityDistributeTrendInterval_show = data;
  }
};
const actions = {
  async getAccidentDistributeTrendInterval({ commit }, param) {
    commit("setAccidentDistributeTrendInterval", null);
    const accidentDistributeTrendInterval = await CompanySecureAPI.getAccidentDistributeTrendInterval(
      param
    );
    commit(
      "setAccidentDistributeTrendInterval",
      accidentDistributeTrendInterval.data
    );
  },

  // 获取所有驾驶行为
  async gettb_subject_qy_gwqy({ commit }, param) {
    const tb_subject_qy_gwqy = await CompanySecureAPI.gettb_subject_qy_gwqy(
      param
    );
    commit("settb_subject_qy_gwqy", tb_subject_qy_gwqy.data);
  },
  // 1.高危驾驶行为区域分布
  async getdriver_danger_distribute_trend_area({ commit }, param) {
    const driver_danger_distribute_trend_area = await CompanySecureAPI.getdriver_danger_distribute_trend_area(
      param
    );
    commit(
      "setdriver_danger_distribute_trend_area",
      driver_danger_distribute_trend_area.data
    );
  },
  // 2.高危驾驶行为时段分布变化趋势
  async getdriver_danger_distribute_trend_interval({ commit }, param) {
    const driver_danger_distribute_trend_interval = await CompanySecureAPI.getdriver_danger_distribute_trend_interval(
      param
    );
    commit(
      "setdriver_danger_distribute_trend_interval",
      driver_danger_distribute_trend_interval.data
    );
  },
  //  3.违规行为区域分布变化趋势
  async getdriver_irregularity_distribute_trend_area({ commit }, param) {
    const driver_irregularity_distribute_trend_area = await CompanySecureAPI.getdriver_irregularity_distribute_trend_area(
      param
    );
    commit(
      "setdriver_irregularity_distribute_trend_area",
      driver_irregularity_distribute_trend_area.data
    );
  },
  // 4.违规行为时段分布变化趋势
  async getdriver_irregularity_distribute_trend_interval({ commit }, param) {
    const driver_irregularity_distribute_trend_interval = await CompanySecureAPI.getdriver_irregularity_distribute_trend_interval(
      param
    );
    commit(
      "setdriver_irregularity_distribute_trend_interval",
      driver_irregularity_distribute_trend_interval.data
    );
  },
  // 5.违法行为区域分布变化趋势
  async getdriver_illegal_distribute_trend_area({ commit }, param) {
    const driver_illegal_distribute_trend_area = await CompanySecureAPI.getdriver_illegal_distribute_trend_area(
      param
    );
    commit(
      "setdriver_illegal_distribute_trend_area",
      driver_illegal_distribute_trend_area.data
    );
  },
  // 6.违法行为时段分布变化趋势
  async getdriver_illegal_distribute_trend_interval({ commit }, param) {
    const driver_illegal_distribute_trend_interval = await CompanySecureAPI.getdriver_illegal_distribute_trend_interval(
      param
    );
    commit(
      "setdriver_illegal_distribute_trend_interval",
      driver_illegal_distribute_trend_interval.data
    );
  },
  // 7. 事故详情
  async gettb_business_yzsg({ commit }, param) {
    const tb_business_yzsg = await CompanySecureAPI.gettb_business_yzsg(param);
    commit("settb_business_yzsg", tb_business_yzsg.data);
  },
  // 8.不同周期高危驾驶行为数量（高危驾驶行为数量变化趋势弹框）
  async getDriverDangerCount({ commit }, param) {
    commit("setDriverDangerCount", null);
    const driverDangerCount = await CompanySecureAPI.getDriverDangerCount(
      param
    );
    commit("setDriverDangerCount", driverDangerCount.data);
  },
  // 不同周期违规行为数量（违规行为行为数量变化趋势弹框）
  async getDriverIrregualarityCount({ commit }, param) {
    commit('setDriverIrregularityCount', null)
    const driverIrregularityCount = await CompanySecureAPI.getDriverIrregualarityCount(
      param,
    )
    commit('setDriverIrregularityCount', driverIrregularityCount.data)
  },
  // 不同周期违法行为数量（违法行为行为数量变化趋势弹框）
  async getDriverIllegalCount({ commit }, param) {
    commit('setDriverIllegalCount', null)
    const driverIllegalCount = await CompanySecureAPI.getDriverIllegalCount(
      param,
    )
    commit('setDriverIllegalCount', driverIllegalCount.data)
  },
  // 9.不同类型事故区域分布
  async getAccidentDistributeTrendArea({ commit }, param) {
    const AccidentDistributeTrendArea = await CompanySecureAPI.getAccidentDistributeTrendArea(
      param
    );
    commit("setAccidentDistributeTrendArea", AccidentDistributeTrendArea.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
