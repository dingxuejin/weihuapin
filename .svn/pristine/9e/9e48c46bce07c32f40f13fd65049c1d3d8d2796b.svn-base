// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/* eslint-disable */
import Vue from "vue";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import Echarts from "vue-echarts";
import BaiduMap from "vue-baidu-map";
import echarts from "echarts";
// 弹框拖动
import vueDrag from "vue-dragging";
import App from "./App";
import router from "./router";
import store from "./store/";
import qf from "./util/qf";
import formatDate from "./util/formatDate";
import Loading from "./components/loading";
// 图表主题
import dark from "./assets/chartsTheme/dark-gps.json";
import "./util/index.css";
import Mv from "./util/common";
import "./util/GeoUtils";

Vue.use(ElementUI);

// 划分千分位
Vue.prototype.qf = qf;
// 日期格式化(如将"20190309"格式化为"2019-03-09")
Vue.prototype.formatDate = formatDate;
// 源生 Echarts
Vue.prototype.$echarts = echarts;
Vue.prototype.Mv = Mv;

// 注册图表主题
Echarts.registerTheme("dark", dark);
Vue.config.productionTip = false;
// // ----------bmap-------------------------
Vue.use(BaiduMap, {
  ak: "W2fd4lgScqD7Wgywl8na9ivlFfcPaGzt"
});

// 弹框拖动
Vue.use(vueDrag);

// 注册loading 组件
Vue.use(Loading);
/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  template: "<App/>",
  components: { App }
});
