
function somar(num1, num2){
    let totalSoma = num1 + num2
    console.log('A soma total é ' + totalSoma);
}


function subtrair(num1, num2){
    let totalSubtracao = num1 - num2
    console.log('Após a subtração o valor é ' + totalSubtracao);
}


function multiplicar (num1, num2){
    let totalMultiplicacao = num1 * num2
    console.log('Após a multiplicação o valor total é ' + totalMultiplicacao);
}


function dividir(num1, num2){
    let totalDividir = num1 / num2
    console.log('Após a divisão o valor é ' + totalDividir);
}

export {somar, subtrair, multiplicar, dividir};