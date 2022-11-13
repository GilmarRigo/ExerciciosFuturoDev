function menorValor(valores){
    let menorNum = 0
    let PosNum = 0

        for(let i = 0; i < valores.length; i++){
            if(valores[i] < menorNum){
                menorNum = valores[i]
                PosNum = i   
            }
        }
        console.log('O maior número é ' + menorNum + ' e está na posição ' + PosNum + '.')
}



menorValor([2,4,6,7,10,0,-3])
    

