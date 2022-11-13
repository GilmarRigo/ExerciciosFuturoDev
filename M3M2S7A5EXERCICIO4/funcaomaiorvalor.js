function maiorValor(valores){
    let maiorNum = 0
    let PosNum = 0

        for(let i = 0; i < valores.length; i++){
            if(valores[i] >= maiorNum){
                maiorNum = valores[i]
                PosNum = i   
            }
        }
        console.log('O maior número é ' + maiorNum + ' e está na posição ' + PosNum + '.')
}



maiorValor([2,3,6,7,10,1])
    

