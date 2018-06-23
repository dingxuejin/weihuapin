<template>
    <div id="container">
        <div class="flex-between">
            <div class="title flex-center">
                <span>具体收入排名</span>
            </div>
            <div class="flex-between ">
                <div class="label">统计周期</div>
                <div>
                    <key-value-select :data='options' @select='select' width='110px'>
                    </key-value-select>
                </div>

            </div>
        </div>
        <div class="content-container">
            <div class="listTitle flex-between">
                <div v-for='(item,index) in listTitle' :key='index' @click="onClickTitle(item)">{{item}}</div>
            </div>
            <ul>
                <li v-for='(item,index) in routeOrder' :key='index' class="listContent flex-between">
                    <div :title="item&&item.paiming">{{index+1}}</div>
                    <div :title="item&&item.shijian">{{item.shijian}}</div>
                    <div :title="item&&item.zongshouru">{{item.zongshouru}}</div>
                    <div :title="item&&item.qushi">
                        <div class="nav"></div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>
<script>
import KeyValueSelect from '../../../components/KeyValueSelect'

export default {
  data() {
    return {
      options: [
        {
          label: '全部',
          value: 'all',
        },
        {
          label: '2018年',
          value: '2018',
        },
        {
          label: '2017年',
          value: '2017',
        },
        {
          label: '2016年',
          value: '2016',
        },
      ],
      listTitle: ['排名', '时间', '总收入', '上升或下降'],
      routeOrder: [
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
        { paiming: 1, shijian: '2018年', zongshouru: 2000, qushi: 'aaa' },
      ],
    }
  },
  components: { KeyValueSelect },
}
</script>
<style scoped>
#container {
  border: 2px solid #81d9e5;
  padding: 13px;
  color: #fff;
}
.content-container {
  max-height: 200px;
  overflow-y: scroll;
  overflow-x: hidden;
  margin: 10px 0 0;
  padding-right: 10px;
}
.content-container::-webkit-scrollbar {
  width: 6px;
}
.content-container::-webkit-scrollbar-thumb {
  border-radius: 5px;
  -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #05d0eb;
}
.content-container::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 2px;
  background: linear-gradient(
    to right,
    transparent 20%,
    #68a0ae 50%,
    transparent 80%
  );
  background: -o-linear-gradient(
    to right,
    transparent 20%,
    #68a0ae 50%,
    transparent 80%
  );
  background: -webkit-linear-gradient(
    to right,
    transparent 20%,
    #68a0ae 50%,
    transparent 80%
  );
  background: -moz-linear-gradient(
    to right,
    transparent 20%,
    #68a0ae 50%,
    transparent 80%
  );
}
.title {
  width: 40%;
  height: 25px;
  background: rgba(129, 217, 229, 0.3);
  font-size: 16px;
  color: #89dddf;
}
.label {
  font-size: 16px;
  color: #b5b5b5;
  margin: 0 10px;
}
.listTitle {
  height: 30px;
  margin-bottom: 5px;
  margin-top: 10px;
}
.listContent {
  height: 30px;
  margin: 5px 0;
}
.listTitle > div {
  height: 30px;
  box-sizing: border-box;
  text-align: center;
  line-height: 28px;
  border: 1px solid #81d9e5;
  color: #b5b5b5;
  font-size: 16px;
  cursor: pointer;
}
.listContent > div {
  height: 30px;
  box-sizing: border-box;
  text-align: center;
  line-height: 28px;
  border: 1px solid #068191;
  background: rgba(7, 49, 55, 0.7);
  color: #b5b5b5;
  font-size: 12px;
  cursor: pointer;
}
.listContent:hover > div {
  background: rgba(6, 108, 122, 0.7);
  color: #ffe9eb;
}
.listTitle > div:nth-child(1),
.listContent > div:nth-child(1) {
  width: 65px;
}
.listTitle > div:nth-child(2),
.listContent > div:nth-child(2) {
  width: 75px;
}
.listTitle > div:nth-child(3),
.listTitle > div:nth-child(4),
.listContent > div:nth-child(3),
.listContent > div:nth-child(4) {
  width: 100px;
}
.nav {
  width: 20px;
  height: 3px;
  margin: 10px auto;
  background: url("../../../assets/companymanage/same_blue.png") no-repeat;
}
.down {
  width: 6px;
  height: 20px;
  margin: 1px auto;
  background: url("../../../assets/companymanage/down_icon.png") no-repeat;
}
.up {
  width: 6px;
  height: 20px;
  margin: 1px auto;
  background: url("../../../assets/companymanage/up_icon.png") no-repeat;
}
</style>


