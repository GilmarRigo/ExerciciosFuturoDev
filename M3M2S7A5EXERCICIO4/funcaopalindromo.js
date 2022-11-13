
function palindromo(palavra1){   
let palavra = palavra1;
let invertida = []
let impressao

//console.log(palavra.length)

for(let i = (palavra.length)-1; i >= 0; i--){    
    invertida[palavra.length - i] = palavra[i]
}
impressao = invertida.join('');
//console.log(impressao);

    if(palavra === impressao){
        console.log('Verdadeiro é um Palíndromo!')
    } else {
        console.log('Falso nãp é um Palíndromo!')
    }
}

palindromo('arara')