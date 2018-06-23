<template>
  <div class="listWrap eleScrollBar">
    <div class="listContent"
         :style="{width: contentWidth+'px'}">

      <div class="titleCon clearfix">
        <div v-for="(t,index) in titlesData"
             :key="index"
             :style="{width:t.width+'px'}">{{t.name}}</div>
      </div>
      <div class="content eleScrollBar">
        <ul class="eleScrollBar">
          <li class="lis clearfix"
              v-for="(item,index) in listData"
              :key="index">
            <div class="fl cell over"
                 v-for="(t,index) in titlesData"
                 :key="index"
                 :style="{width:t.width+'px'}">{{contentCell(item,t.key)}}</div>
          </li>
        </ul>
      </div>
    </div>
  </div>

</template>

<script type="text/javascript">

export default {
  name: 'ListComponent',
  components: {},
  props: ['listData', 'titlesData'],
  data() {
    return {}
  },
  computed: {
    contentWidth() {
      return (
        this.titlesData.reduce((total, curr) => total + curr.width, 0) + 10
      )
    },
    contentCell() {
      return function (item, key) {
        let result = item
        key.split('.').forEach((k) => {
          if (result[k] !== null && result[k] !== undefined) {
            result = result[k]
          } else {
            result = ''
          }
        })
        return result
      }
    },
  },
}
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w,$h) {
  width: $w;
  height: $h;
}

// 自定义滚动条
.eleScrollBar::-webkit-scrollbar {
  @include size(5px,5px);
  background: url("../assets/driver/scroll.png") no-repeat center center;
  // position: relative;
  // right: 10px;
  // top: 5px;
  background-size: 100% 100%;
}
.eleScrollBar::-webkit-scrollbar-thumb {
  background: rgba(5, 208, 235, 1);
}

.listWrap {
  width: 100%;
  height: 98%;
  overflow-x: auto;
  overflow-y: hidden;
}

// 列表数据
.listContent {
  height: 265px;
  // 标题
  .titleCon {
    color: #89dddf;
    background: rgba(5, 208, 235, 0.2);
    div {
      float: left;
      text-align: center;
      line-height: 25px;
      // background: red;
      // margin-left:1px;
    }
  }
  .content {
    width: 100%;
    height: 230px;
    overflow-x: auto;

    ul {
      overflow-y: auto;
      // 列表部分
      .lis {
        @include size(100%,20px);
        color: #b5b5b5;
        text-align: center;
        line-height: 20px;
        background: rgba(129, 217, 229, 0.1);
        margin-top: 5px;

        .cell{
          min-height: 1px;
        }


      }

      .lis:hover {
        color: #fff;
        background: rgba(129, 217, 229, 0.5);
      }
    }
  }
}
</style>