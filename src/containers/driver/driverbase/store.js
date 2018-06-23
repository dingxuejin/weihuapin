import * as DriverAPI from '@/api/driver'

const state = {
  ryjb: null,
}

const mutations = {
  setRyjb(state, data) {
    state.ryjb = data
  },
}
/* eslint-disable */ 
const actions = {
  async getRyjb({ commit, dispatch }, search) {
    const ryjb = await DriverAPI.getRyjb(search)
    commit('setRyjb', ryjb.data[0])

    const driverId = ryjb.data[0].driver_id
    const CurrYear = `${new Date().getFullYear()}`
    const CurrMonth = `${new Date().getMonth() + 1}` < 10 ? `${`0${new Date().getMonth()}${1}`}` : `${new Date().getMonth() + 1}`
    //  驾驶员自身标签
    dispatch(
      'PopUpDriverTag/getDriverMyselfTag', driverId,
      { root: true },
    )
    //  驾驶员同事印象
    dispatch(
      'PopUpDriverTag/getDriverTheirTag', driverId,
      { root: true },
    )
    // 获取健康信息
    dispatch(
      'popupdriverhealthy/getDriverHealthy', driverId,
      { root: true },
    )
    dispatch(
      'popuptraininfo/getSubject', driverId,
      { root: true },
    )
    // 获取奖惩资料
    dispatch(
      'driverreward/getJc',
      { year: 2017, driver_id: driverId },
      { root: true },
    )
    // 获取安全积分
    dispatch(
      'driverreward/getSafetyIntegral', driverId,
      { root: true },
    )
    // 获取当年累计工作量统计资料
    dispatch(
      'accumulatedWorkloadStatistics/getPm',
      { year: 2017, driver_id: driverId },
      { root: true },
    )

    // 获取考核项目月得分及排名
    dispatch('scoreAndRankingOfSafetyEvaluation/getMonthKh', {
      year: 2017, month: 11, driver_id: driverId,
    }, { root: true })

    // 获取考核项目年得分及排名
    dispatch(
      'scoreAndRankingOfSafetyEvaluation/getYearKh',
      { year: 2017, driver_id: driverId },
      { root: true },
    )

    // 安全评价总得分及排名(高频不良驾驶行为)
    dispatch(
      'scoreAndRankingOfSafetyEvaluation/getBadDrive',
      { month: 11, year: 2017, driver_id: driverId },
      { root: true },
    )

    // 安全评价总得分及排名(高频违规行为)
    dispatch(
      'scoreAndRankingOfSafetyEvaluation/getIrregularity',
      { month: 11, year: 2017, driver_id: driverId },
      { root: true },
    )

    // 安全评价总得分及排名(高频违法行为)
    dispatch(
      'scoreAndRankingOfSafetyEvaluation/getIllegal',
      { month: 11, driver_id: driverId },
      { root: true },
    )

    // 安全评价总得分及排名(累计事故次数)
    dispatch(
      'scoreAndRankingOfSafetyEvaluation/getAccident',
      { month: 11, driver_id: driverId },
      { root: true },
    )

    // 驾驶员承运线路(jy)
    dispatch(
      'driverLine/getDriverJy',
      { driver_id: driverId },
      { root: true },
    )

    // 驾驶员承运线路(驾驶行为)
    dispatch(
      'driverLine/getTodayDriver',
      {
        driver_id: driverId,
        year: 2017,
        month: 11,
        day: 18,
      },
      { root: true },
    )
    dispatch(
      'driverLine/getToadyIrregularity',
      { driver_id: driverId, year: 2017, month: 11, day: 18 },
      { root: true },
    )
    dispatch(
      'driverLine/getTodayIllegal',
      { driver_id: driverId, year: 2017, month: 11, day: 18 },
      { root: true },
    )
    dispatch(
      'driverLine/getTodayAccident',
      { driver_id: driverId, year: 2017, month: 11, day: 18 },
      { root: true },
    )

    dispatch(
      'popupdriverlicense/getPopUpDriverLicense',
      { driver_id: driverId },
      { root: true },
    )

    dispatch(
      'popupworkqualification/getPopUpWorkQualification',
      { driver_id: driverId },
      { root: true },
    )

    dispatch(
      'popuptraininfo/getPopUpTrainInfo',
      { driver_id: driverId, training_theme_code: 10 },
      { root: true },
    )

    dispatch(
      'traincountinfo/getTrainCountInfo',
      {
        driver_id: driverId,
        training_type_code: 12,
        training_theme_code: 10,
        year: 2015,
        month: 10,
        type: '培训时长',
      },
      { root: true },
    )

    dispatch(
      'traindetailsinfo/getTrainDetailsInfo',
      {
        driver_id: driverId,
        training_type_code: 12,
        training_theme_code: 10,
        year: 2015,
        month: 10,
      },
      { root: true },
    )

    dispatch(
      'rewardinfo/getRewardInfo',
      { driver_id: driverId },
      { root: true },
    )
    // 奖励统计信息
    dispatch(
      'rewardcountinfo/getRewardCountInfo',
      {
        driver_id: driverId,
        reward_type_code: 3,
        year: CurrYear,
        month: null,
        type: '奖励次数',
      },
      { root: true },
    )
    // 奖励详细信息
    dispatch(
      'rewarddetailsinfo/getRewardDetailsInfo',
      { driver_id: driverId, year: CurrYear, month: null, day: null },
      { root: true },
    )

    dispatch(
      'punishinfo/getPunishInfo',
      { driver_id: driverId },
      { root: true },
    )
    // 惩罚统计信息
    dispatch(
      'punishcountinfo/getPunishCountInfo',
      {
        // driver_id: 201408000003,
        driver_id: driverId,
        punishment_type_code: 20,
        year: CurrYear,
        month: null,
        type: '惩罚次数',
      },
      { root: true },
    )
    // 惩罚详细信息
    dispatch(
      'punishdetailsinfo/getPunishDetailsInfo',
      {
        // driver_id: 201408000003,
        driver_id: driverId,
        year: CurrYear,
        month: null,
        day: null,
      },
      { root: true },
    )

    dispatch(
      'workmileagecountinfo/getWorkMileageCountInfo',
      {
        driver_id: driverId,
        // year: 2017,
        // month: '03',
        type: '环比',
      },
      { root: true },
    )

    dispatch(
      'workstrengthcountinfo/getWorkStrengthCountInfo',
      {
        driver_id: driverId,
        // year: 2017,
        // month: '03',
        type: '环比',
      },
      { root: true },
    )

    dispatch(
      'workordercountinfo/getWorkOrderCountInfo',
      {
        driver_id: driverId,
        year: 2017,
        // month: 03,
        type: '同比',
        capacity_unit_code: 2,
      },
      { root: true },
    )
    // 驾驶区间信息
    dispatch(
      'workmileagedetailsinfo/getWorkMileageDetailsInfo',
      { driver_id: driverId, year: CurrYear, month: null, day: null },
      { root: true },
    )
    // 驾驶时段信息
    dispatch(
      'workstrengthdetailsinfo/getWorkStrengthDetailsInfo',
      {
        driver_id: driverId,
        year: CurrYear,
        month: null,
        day: null,
      },
      { root: true },
    )
    // 运单详细信息
    dispatch(
      'workorderdetailsinfo/getWorkOrderDetailsInfo',
      { driver_id: driverId, year: CurrYear, month: null, day: null },
      { root: true },
    )
    dispatch(
      'driverbehavioralarmcountinfo/getDriverBehaviorAlarmCountInfo',
      {
        driver_id: driverId,
        drive_event_type_code: 10311,
        year: 2017,
        month: 11,
      },
      { root: true },
    )
    // 速度标准差变化趋势
    dispatch(
      'driverbehaviorspeedcountinfo/getDriverBehaviorSpeedCountInfo',
      {
        driver_id: driverId,
        year: CurrYear, month: CurrMonth, day: null
      },
      { root: true },
    )
    dispatch(
      'driverbehaviorspeedcountinfo/getDriverBehaviorSpeedStatistics',
      {
        driver_id: driverId,
      },
      { root: true },
    )
    dispatch(
      'driverbehavioralarmdetailsinfo/getDriverBehaviorAlarmDetailsInfo',
      { driver_id: driverId },
      { root: true },
    )

    dispatch(
      'irregalaritybehaviorcountinfo/getIrregalarityBehaviorCountInfo',
      {
        driver_id: driverId,
        drive_event_type_code: 20900,
        year: 2017,
        month: 11,
      },
      { root: true },
    )

    dispatch(
      'irregalaritybehaviordetailsinfo/getIrregalarityBehaviorDetailsInfo',
      { driver_id: driverId },
      { root: true },
    )

    dispatch(
      'illegalbehavioralarmcount/getIllegalBehaviorAlarmCount',
      {
        driver_id: driverId,
        drive_event_type_code: 30500,
        year: 2017,
        month: 11,
      },
      { root: true },
    )

    dispatch(
      'illegalbehaviorproportioncount/getIllegalBehaviorProportionCount',
      {
        driver_id: driverId,
        // year: 2017,
        // month: '03',
        // day: '01',
      },
      { root: true },
    )

    dispatch(
      'illegalbehaviordetailsinfo/getIllegalBehaviorDetailsInfo',
      { driver_id: driverId },
      { root: true },
    )

    // 有责事故次数统计
    dispatch(
      'blameaccidentnumcountinfo/getBlameAccidentNumCountInfo',
      {
        driver_id: driverId,
        accident_level_code: 4,
        year: 2017,
        month: 11,
      },
      { root: true },
    )

    dispatch(
      'blameaccidentproportioninfo/getBlameAccidentProportionInfo',
      {
        driver_id: driverId,
        //  year: 2015,
        //  month: 03,
        //  day: 01
        type: '有责事故类型占比',
      },
      { root: true },
    )

    dispatch(
      'blameaccidentdetailsinfo/getBlameAccidentDetailsInfo',
      { driver_id: driverId },
      { root: true },
    )
    dispatch(
      'driverLine/getDriver_runtime_route_info',
      { driver_id: driverId },
      { root: true },
    )
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
