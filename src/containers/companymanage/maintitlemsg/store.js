import * as CompanyAPI from '@/api/company'
import Dictionary from '@/util/dictionary'


const state = {
  entities: null,
  selectedEntity: '1310000010000000',
}
const mutations = {
  setEntity(state, data) {
    state.entities = data
  },
  setSelectedEntity(state, data) {
    state.selectedEntity = data.entity_id
  },
}
const actions = {
  async getEntity({
    commit,
    dispatch,
  }) {
    const entity = await CompanyAPI.getHeaderMsg()
    commit('setEntity', entity.data)
    dispatch('selectEntity', {
      entity_id: state.entities[0].entity_id,
    })
  },

  async selectEntity({
    commit,
    dispatch,
  }, {
    entity_id,
  }) {
    commit(
      'setSelectedEntity',
      state.entities.filter(e => e.entity_id === entity_id)[0],
    )
    dispatch('fetchOtherBlock', {
      entity_id,
    })
  },

  async fetchOtherBlock({

    dispatch,
    state,
  }) {
    // 获得货物类型列表
    dispatch(
      'companyManage/getCargoId_name', null, { root: true },
    )
    // 成本比例变化趋势
    dispatch(
      'manageCostRatio/getCostRatio', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )

    // 变动成本
    dispatch(
      'manageCostChange/getVariableCost', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )

    // 固定成本
    dispatch(
      'manageCostConstant/getFixedCost', {
        entity_id: state.selectedEntity,
        situation: 'maintain',
        type: 'maintain_cost',
      }, {
        root: true,
      },
    )

    // 运输时段
    dispatch(
      'manageRunTime/getVehicleQuantity', {
        entity_id: state.selectedEntity,
        month: 11,
        year: 2017,
      }, {
        root: true,
      },
    )

    // 线路排名
    dispatch(
      'manageLineRanking/getRouteOrder', {
        entity_id: state.selectedEntity,
        month: Dictionary.nowMonth,
        year: Dictionary.nowYear,
        period: 'year',
      }, {
        root: true,
      },
    )

    // 货物流量流向统计
    dispatch(
      'manageGoodsTj/getCargoFlow', {
        entity_id: state.selectedEntity,
        year: Dictionary.nowYear,
        // month: null,
        cargo_id: '93',
      }, {
        root: true,
      },
    )

    // 货物流量流向变化趋势

    // 货物流量流向统计
    dispatch(
      'manageGoodsFx/getCargoFlowArea', {
        entity_id: state.selectedEntity,
        year: 2018,
        cargo_id: '93',
      }, {
        root: true,
      },
    )

    // 里程分布
    // dispatch(
    //   'manageMileageDistribution/getMileageStatistics', {
    //     entity_id: 1310000010000000,
    //     month: 11,
    //     year: 2017,
    //   }, {
    //     root: true,
    //   },
    // )
    // dispatch(
    //   'manageMileageDistribution/getMileageTrend', {
    //     entity_id: 1310000010000000,
    //     month: 11,
    //     year: 2017,
    //   }, {
    //     root: true,
    //   },
    // )
    dispatch(
      'manageMileageDistribution/getMileageStatistics', {
        entity_id: state.selectedEntity,
        month: 11,
        year: 2017,
      }, {
        root: true,
      },
    )
    dispatch(
      'manageMileageDistribution/getMileageTrend', {
        entity_id: state.selectedEntity,
        month: 11,
        year: 2017,
      }, {
        root: true,
      },
    )
    dispatch(
      'manageMileageDistribution/getMileageRatio', {
        entity_id: state.selectedEntity,
        month: Dictionary.nowMonth,
        year: Dictionary.nowYear,
      }, {
        root: true,
      },
    )
    dispatch(
      'manageMileageDistribution/getHighestVehicleMileage', {
        entity_id: state.selectedEntity,
        month: Dictionary.nowMonth,
        year: Dictionary.nowYear,
      }, {
        root: true,
      },
    )
    // 获取实时运行情况
    dispatch(
      'manageRunReal/getCost', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )
    //  经营总收入-年排名及趋势
    dispatch(
      'manageRunReal/requireRanking', {
        entity_id: state.selectedEntity,
        year: Dictionary.nowYear,
        // year: 2017,
        active: 0,
      }, {
        root: true,
      },
    )
    //  经营单车收入-年排名及趋势
    // dispatch(
    //   'manageRunReal/requireDcYearRanking', {
    //     entity_id: state.selectedEntity,
    //     // year: Dictionary.nowYear,
    //     year: 2017,
    //   }, {
    //     root: true,
    //   },
    // )

    // 详情弹出框
    dispatch(
      'yearCostTrend/getYearCostTrendFixed', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )
    dispatch(
      'yearCostTrend/getYearCostTrendTurnover', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )
    dispatch(
      'yearCostTrend/getYearCostTrendFloat', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )

    // 暂注释, 解Bug
    // dispatch(
    //   'popupContainer/getCompany_manage_waybill_yearonyear_this_month',
    //   {
    //     entity_id: 1310000010000000,
    //     year: new Date().getFullYear(),
    //     month: new Date().getMonth() + 1,
    //   },
    //   { root: true },
    // )

    // 不同类型货物货运量统计
    // dispatch(
    //   'cargoVolume/getVolumeByCargoType',
    //   { entity_id: 1310000010000000, year: 2017, cargo_type_code: '03121' },
    //   { root: true },
    // )
    // month: 11,

    // // 运单总数
    // dispatch(
    //   'waybillStatistics/getWaybillStatistics', {
    //     entity_id: 1310000010000000,
    //     year: 2017,
    //   }, {
    //     root: true,
    //   },
    // )
    dispatch(
      'waybillTrendRecently/getWaybillTrendRecently', {
        entity_id: state.selectedEntity,
        month: Dictionary.nowMonth,
        year: Dictionary.nowYear,
      }, {
        root: true,
      },
    )
    dispatch(
      'waybillYearOnYearThisMonth/getWaybillYearOnYearThisMonth', {
        entity_id: state.selectedEntity,
        month: Dictionary.nowMonth,
        year: Dictionary.nowYear,
      }, {
        root: true,
      },
    )
    // dispatch(
    //   'cargoTurnover/getTurnoverByCargoType', {
    //     entity_id: state.selectedEntity,
    //   }, {
    //     root: true,
    //   },
    // )
    dispatch(
      'routeInfo/getRouteInfo', {
        entity_id: state.selectedEntity,
      }, {
        root: true,
      },
    )
    dispatch(
      'volumeStatisticsDayNight/getVolumeStatisticDayNight', {
        entity_id: state.selectedEntity,
        cargo_id: 1,
      }, {
        root: true,
      },
    )

    // dispatch(
    //   'volumeStatisticsEntity/getVolumeStatisticsEntity', {
    //     year: 2017,
    //     region_scope_code: 440000,
    //     cargo_type_code: '03121',
    //   }, {
    //     root: true,
    //   },
    // )
    dispatch(
      'volumeInterstateEntity/getVolumeInterstateEntity', {
        entity_id: state.selectedEntity,
        cargo_id: '93',
      }, {
        root: true,
      },
    )

    //  货物流量流向变化趋势
    dispatch('managegoodsbh/getManageGoodsBh', {
      entity_id: state.selectedEntity,
      year: 2018,
      cargo_id: '93',
      route: '揭阳渔湖站-潮州英利宝站',
    }, {
      root: true,
    })
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
