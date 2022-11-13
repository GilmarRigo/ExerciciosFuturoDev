let palavra = 'socorram me subi no onibus em marrocos'
let invertida = []
let impressao;

//console.log(palavra.length)

for(let i = (palavra.length)-1; i >= 0; i--){    
    invertida[palavra.length - i] = palavra[i]
}
impressao = invertida.join('');
console.log(impressao);