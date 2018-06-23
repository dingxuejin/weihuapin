//  const array = [
//    {
//      value: '03110',
//      label: '爆炸品',
//    },
//    {
//      value: '03111',
//      label: '有整体爆炸危险的物质和物品',
//    },
//    {
//      value: '03112',
//      label: '有迸射危险，但无整体爆炸危险的物质和物品',
//    },
//  ]
// 在一个对象数组里根据一个键的值得到另一个键的值
// 如根据03112得到'有迸射危险，但无整体爆炸危险的物质和物品'


// 参数详解：key1：已知键名
//         value1:已知key1的值
//         key2:想得的值的键名
//         arr:对象数组
// 返回值：key2 的值 返回类型数组类型
const keyGetValue = function (key1, value1, key2, arr) {
  if (arr && arr.length > 0) {
    const newArr1 = arr.map((val) => {
      if (val[key1] === value1) {
        return val[key2]
      }
      return null
    })
    const newArr2 = newArr1.filter(val => val !== null)
    return newArr2
  }
  return []
}
export default keyGetValue
