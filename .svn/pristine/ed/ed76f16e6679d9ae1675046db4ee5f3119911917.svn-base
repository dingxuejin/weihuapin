// 划分千分位
export default function qf(tempnum) {
  const figureNum = 3
  const newtempnum = (tempnum || 0).toString()
  let result = ''
  const newnum = newtempnum.split('.')
  let num = newnum[0]
  while (num.length > figureNum) {
    result = `,${num.slice(-figureNum)}${result}`
    num = num.slice(0, num.length - figureNum)
  }
  if (num) {
    result = num + result
  }

  if (newnum.length > 1) {
    result += `.${newnum[1]}`
  }
  return result
}
