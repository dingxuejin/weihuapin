/* eslint-disable */
import * as CarAPI from "@/api/car";

const state = {
  // 中间：车辆基础信息
  cljcxxData: null,
  cljcxxData_ErroMsg: null,
  fuelCost: null,
  vehicle_id: null
};
const mutations = {
  setMutationData(state, data) {
    if (data !== null && data !== undefined) {
      state.cljcxxData = data;
      state.vehicle_id = data.vehicle_id;
    } else {
      state.cljcxxData_ErroMsg = "无数据";
    }
  },
  setfuel(state, data) {
    state.fuelCost = data;
  }
};
const actions = {
  // 查询车辆车牌
  async getCljcxx({ commit, dispatch }, plate_number) {
    const cljcxx = await CarAPI.getCljcxx(plate_number);
    if (plate_number) {
      CarAPI.getCljcxx(plate_number).then(cljcxx => {
        commit("setMutationData", cljcxx.data[0]);
      });
    }
    if (cljcxx && cljcxx.data) {
      commit("setMutationData", cljcxx.data[0]);
    }

    const vehicleId = state.cljcxxData && state.cljcxxData.vehicle_id;
    console.log("vehicleId***********:", vehicleId);
    if (vehicleId !== null && vehicleId !== undefined) {
      //到期预警提醒
      dispatch("caralertinfo/getAlertInfo", vehicleId, { root: true });

      // 过期提醒
      dispatch(
        "CarOverdueRemindingStore/getCarOverReminding",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧所有信息
      dispatch(
        "mileagemiscinfoWrapContainer/getrightPartData",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧：查询里程等信息
      dispatch("totalMileageContainer/getClxslc", vehicleId, {
        root: true
      });
      // 右侧：查询车辆运量
      dispatch("carWeightContainer/getClyl", vehicleId, {
        root: true
      });
      // 右侧：查询周转量
      dispatch("carPerMileageContainer/getClzzl", vehicleId, {
        root: true
      });
      // 右侧：查询车运单数
      dispatch("carTotalCountContainer/getClydsl", vehicleId, {
        root: true
      });

      // 累计各项费用占比以及年度总费用等
      dispatch("carListCostsContainer/getClfytj", vehicleId, {
        root: true
      });
      // 查询车辆保养信息
      dispatch("carMaintenanceRepaireContainer/getClbyxx", vehicleId, {
        root: true
      });
      // 查询车辆维修信息
      dispatch("carMaintenanceRepaireContainer/getClwxxx", vehicleId, {
        root: true
      });
      // 查询车辆保险信息
      dispatch("carMaintenanceRepaireContainer/getClbxjc", vehicleId, {
        root: true
      });
      // 查询检测信息
      dispatch("carMaintenanceRepaireContainer/getYlrqgtjc", vehicleId, {
        root: true
      });

      // 左侧： 查询终端配置信息
      dispatch("terminalConfigurationContainer/getCzzdxx", vehicleId, {
        root: true
      });

      // 左侧： 查询轮胎配置信息
      dispatch("tyreConfigurationContainer/getLtsyxx", vehicleId, {
        root: true
      });
      // 左侧： 轮胎配置详细信息:轮胎轮换记录
      dispatch("tyreConfigurationContainer/getLtghxx", vehicleId, {
        root: true
      });
      // 左侧：防护及警告装备配置信息
      dispatch("protectionWarningConfigurationContainer/getCzzbxx", vehicleId, {
        root: true
      });
      // 中间：车辆基础信息弹出框
      dispatch("carBaseInfoContainer/getClzzzjxx", vehicleId, {
        root: true
      });
      // 右侧：车辆行驶里程弹出框
      dispatch(
        "totalMileageContainer/getCarMileageStatistics",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧：重车行驶里程占比弹出框
      dispatch(
        "heavyEmptyMileageContainer/getcarMileageStatisticsRatio",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧：车辆运量弹出框
      dispatch(
        "carWeightContainer/getcarMileageVolumeStatistics",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧：车辆周转量弹出框
      dispatch(
        "carPerMileageContainer/getCarPerMileageStatistics",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 右侧：车辆运单数比弹出框
      dispatch(
        "carTotalCountContainer/getcarMileageWaybillStatistics",
        { vehicle_id: vehicleId },
        { root: true }
      );
      // 中间：累计各项费用占比模块弹出信息
      dispatch("costStatisticPopupContainer/getcarCostStatistics", vehicleId, {
        root: true
      });
      // 中间：累计各项费用占比模块弹出信息 -- 二级弹出框
      dispatch("costStatisticPopupContainer/getcarFuelvsMileage", vehicleId, {
        root: true
      });
      // 中下保养及维修等信息弹出框 -- 保养信息
      dispatch(
        "carMaintenanceRepaireContainer/getcarMaintainInfomation",
        vehicleId,
        {
          root: true
        }
      );

      // 中下保养及维修等信息弹出框 -- 维修信息
      dispatch("carMaintenanceRepaireContainer/getcarRepairRecord", vehicleId, {
        root: true
      });
      dispatch(
        "carMaintenanceRepaireContainer/getcarRepairStatistics",
        vehicleId,
        {
          root: true
        }
      );
      // 中下保养及维修等信息弹出框 -- 保险信息
      dispatch(
        "carMaintenanceRepaireContainer/getcarInsuranceRecord",
        vehicleId,
        {
          root: true
        }
      );
      dispatch(
        "carMaintenanceRepaireContainer/getcarLossAdvise",
        { vehicle_id: vehicleId },
        { root: true }
      );
      dispatch(
        "carMaintenanceRepaireContainer/getcarLossAdviseCount",
        vehicleId,
        {
          root: true
        }
      );
      // 中下保养及维修等信息弹出框 -- 检测信息
      dispatch(
        "carMaintenanceRepaireContainer/getcarTestInformation",
        { vehicle_id: vehicleId },
        { root: true }
      );
    }
    // console.log('cljcxxData', state.cljcxxData)
    return true;
  },

  // 获取油耗
  async getfuel({ commit }, search) {
    const fuel = await CarAPI.getfuel(search);
    commit("setfuel", fuel.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
