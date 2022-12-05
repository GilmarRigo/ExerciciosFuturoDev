let numeros = [25, 64, 4, 9, 81, 36, 49, 1, 100, 121, 16 ];

numeros.sort((a,b) => {
    if(a > b) return  1;
    if(a < b) return -1;
    return 0; 
});

let numeros2 = numeros;

console.log('Array com números em ordem = ' + numeros2.join(", "));
console.log('Array com dobro do valor de cada número = ' + numeros2.map(numero => numero * numero).join(", "));
console.log('Array com metade do valor de cada número = ' + numeros2.map(numero => numero / 2).join(", "));
console.log('Array com raíz quadrada de cada número = ' + numeros2.map(numero => Math.sqrt(numero)).join(" ,"));
