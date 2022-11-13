function maisLetras(nomes){
    let maiorNome = '';
    let qtdLetras = 0;
        for( let i = 0; i < nomes.length; i++){            
                if(nomes[i].length >= qtdLetras){
                    qtdLetras = nomes[i].length
                    maiorNome = nomes[i]
                }            
        }
        console.log(maiorNome)
}
maisLetras(['José','Lucas','Nádia','Fernanda','Cairo','Joana'])