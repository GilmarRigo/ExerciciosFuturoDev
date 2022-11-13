function comparaNome(nome1, nome2){
    let totalNome = []
    let finalNome = []
    let reposta
    let cont = 0
    for(let i = (nome1.length - 1); i > 0; i--){
        totalNome[cont] = nome1[i]   
        cont++
    }
    cont = 0
    for(let i = (nome2.length -1); i >= 0; i--){             
        finalNome[cont] = nome2[i]
        cont++
    }   
    for(let ii = 0; ii < finalNome.length; ii++){
       if(totalNome[ii] == finalNome[ii]){       
        resposta = 'true'       
       } else {
        resposta = 'false'               
       }       
    }
    //console.log(finalNome)
    //console.log(totalNome)
    console.log(nome1 + ' ' +  nome2)
    console.log(resposta)
}

comparaNome('Roberto', 'rto')