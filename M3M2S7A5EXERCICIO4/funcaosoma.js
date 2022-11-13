function somarValores(N){
    let soma = []
    let totalSoma = 0
    if(N >= 0){    

        for(let i = 1; i <= N; i++){
            soma[i] = i        
            totalSoma = totalSoma + soma[i]        
        }
        console.log( 'A soma dos números ' + soma.join('+') + ' = ' + totalSoma)        
    } else {        
        console.log('Número não pode ser negativo!')
    }
}


somarValores(5)