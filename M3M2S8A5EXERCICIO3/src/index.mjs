import * as mod from './modules/util.mjs'
import * as mode from './modules/operators.mjs'



mode.somar(1,8)

mode.subtrair(55, 44)

mode.multiplicar(12,12)

mode.dividir (60,5)

console.log(mod.currencyFormat(29998))

console.log(mod.addLeadingZeros(234, 7))

console.log(mod.cpfMask("12345678910"))

console.log(mod.convert_to_cpf("6576546"))

let array = [123,23432,3432,324,34,21]
console.log(mod.sortArray(array));


