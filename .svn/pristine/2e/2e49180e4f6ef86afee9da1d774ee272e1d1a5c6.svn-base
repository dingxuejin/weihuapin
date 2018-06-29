import * as CompanyManageAPI from '@/api/companymanage'

const popUpFrameRank = {
  namespaced: true,
  state: {
    routeOrder: [
      { paiming: 1, shijian: '2018年', zongshouru: 5000, qushi: '1' },
      { paiming: 2, shijian: '2017年', zongshouru: 2000, qushi: '1' },
    ],
  },
  mutations: {
    setFrameYearRanking(state, data) {
      if (data && data.length > 0) {
        const newRouteORder = data.map((val) => {
          let zongshouru = 0
          if (val.year_income) {
            zongshouru = val.year_income
          } else if (val.year_average_income) {
            zongshouru = val.year_average_income
          }
          return {
            paiming: val.year_ranking,
            shijian: `${val.year}年`,
            zongshouru,
            qushi: val.year_ranking_change_code,
          }
        })


        state.routeOrder = newRouteORder
      } else {
        state.routeOrder = [{ paiming: '无数据', shijian: '无数据', zongshouru: 0, qushi: null }]
      }
    },
    setFrameMonthRanking(state, data) {
      if (data && data.length > 0) {
        const newRouteORder = data.map((val) => {
          let zongshouru = 0
          if (val.year_income) {
            zongshouru = val.income
          } else if (val.average_income) {
            zongshouru = val.average_income
          }
          return {
            paiming: val.ranking,
            shijian: `${val.month}月`,
            zongshouru,
            qushi: val.ranking_change_code,
          }
        })


        state.routeOrder = newRouteORder
      } else {
        state.routeOrder = [{ paiming: '无数据', shijian: '无数据', zongshouru: 0, qushi: null }]
      }
    },
  },
  actions: {
    async requireRouteOrder({
      commit,
    }, param) {
      if (param.active === 0) {
        if (param.year) {
          // 经营总收入-月排名及趋势
          const requireFrameMonthRanking = await CompanyManageAPI.requireFrameMonthRanking(param)
          if (requireFrameMonthRanking.status === 200) {
            commit('setFrameMonthRanking', requireFrameMonthRanking.data)
          }
        } else {
          // 经营总收入-年排名及趋势
          const requireFrameYearRanking = await CompanyManageAPI.requireFrameYearRanking(param)
          if (requireFrameYearRanking.status === 200) {
            commit('setFrameYearRanking', requireFrameYearRanking.data)
          }
        }
      } else if (param.active === 1) {
        if (param.year) {
          // 经营单车收入-月排名及趋势
          const DcFrameMonthRanking = await CompanyManageAPI.requireDcFrameMonthRanking(param)
          if (DcFrameMonthRanking.status === 200) {
            commit('setFrameMonthRanking', DcFrameMonthRanking.data)
          }
        } else {
          // 经营单车收入-年排名及趋势
          const requireDcFrameYearRanking = await CompanyManageAPI.requireDcFrameYearRanking(param)
          if (requireDcFrameYearRanking.status === 200) {
            commit('setFrameYearRanking', requireDcFrameYearRanking.data)
          }
        }
      }
    },
  },


}
export default popUpFrameRank
