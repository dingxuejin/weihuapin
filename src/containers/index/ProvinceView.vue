<template>
    <div class="provinceBox">
        <div class="province fl" v-for="(item,index) in provincesNum" :key="index" @click="clickItem(item)">
            {{item.name}}
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      // 省份
      provincesNum: [
        {
          name: '北京',
        },
        {
          name: '江苏',
        },
        {
          name: '山东',
        },
        {
          name: '浙江',
        },
        {
          name: '河南',
        },
        {
          name: '四川',
        },
        {
          name: '湖北',
        },
        {
          name: '上海',
        },
        {
          name: '湖南',
        },
        {
          name: '河北',
        },
        {
          name: '福建',
        },
        {
          name: '广东',
        },
        {
          name: '安徽',
        },
        {
          name: '辽宁',
        },
        {
          name: '江西',
        },
        {
          name: '陕西',
        },
        {
          name: '天津',
        },
        {
          name: '重庆',
        },
        {
          name: '广西',
        },
        {
          name: '云南',
        },
        {
          name: '内蒙古',
        },
        {
          name: '山西',
        },
        {
          name: '黑龙江',
        },
        {
          name: '贵州',
        },
        {
          name: '吉林',
        },
        {
          name: '新疆',
        },
        {
          name: '甘肃',
        },
        {
          name: '海南',
        },
        {
          name: '宁夏',
        },
        {
          name: '青海',
        },
        {
          name: '西藏',
        },
        {
          name: '香港',
        },
        {
          name: '澳门',
        },
        {
          name: '台湾',
        },
      ],
    }
  },
  methods: {
    clickItem(info) {
      this.$emit('selectProvince', info)
    },
  },
}
</script>
<style lang="scss" scoped>
.provinceBox{
    width: 100%;
    height: 100%;
    padding: 10px 0;
    background-color:#031528;
    overflow: auto;
    .province{ 
        width: 105px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        cursor: pointer;
        margin-bottom: 10px;
        box-sizing: border-box;
        margin-left: 15px;
        div {
            margin: 0;
            padding: 0;
            display: inline-block;
            width: 30px;
            line-height: 30px;
        }
    }
    .province:hover{
        color: #fff;
    }
}
.provinceBox::-webkit-scrollbar {
    width: 5px;
    background: #69a3b1;
}
.provinceBox::-webkit-scrollbar-thumb {
    width: 5px;
    background: #05d0eb;
}
</style>
