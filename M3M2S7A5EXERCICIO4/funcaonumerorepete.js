function numeroRepete(numeros){
    let numRepete
    let qtdRepete
    let maisRepete
    let maisRepeteFinal = 0
    let qtdRepeteFinal = 0
    

        for(let i = 0; i < numeros.length; i++){
            numRepete = numeros[i];
            qtdRepete = 0;
                for(let ii = 0; ii < numeros.length; ii++){
                    if(numRepete == numeros[ii]){
                        qtdRepete = qtdRepete + 1
                        maisRepete = numeros[ii]                     
                    }                    
                }
                if(qtdRepete >= qtdRepeteFinal){
                    qtdRepeteFinal = qtdRepete
                    maisRepeteFinal = maisRepete
                }               
        }
        console.log('O número que mais aparece é o número ' + maisRepeteFinal + ' ele aparece ' + qtdRepeteFinal + '.')
}


numeroRepete([2,3,2,5,8,2,3])