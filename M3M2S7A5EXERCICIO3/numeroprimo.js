let numero = 100;
let ii = 1;
let qtd = 0; 
let maior = 0;

for(let i = 1; i < numero; i++){
   qtd = 0;   
    for(let ii = 1; ii < numero; ii++){
        if(i % ii == 0){
            qtd++
        }        
    }
    if(qtd == 2){
        maior = i;
    }
}
console.log('O maior número primo entre 0 ' + ' e ' + numero + ' é ' + maior + '.')
