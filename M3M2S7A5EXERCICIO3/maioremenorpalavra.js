let array = ['java', 'javascript', 'python', 'html', 'css'];
let maior = 0;
let menor = 100000;
let maiorPalavra;
let menorPalavra;

for(let i = 0; i < array.length; i++){    
    if(array[i].length > maior){
        maior = array[i].length 
        maiorPalavra = array[i]   
    } else if (array[i].length < menor){
        menor = array[i].length
        menorPalavra = array[i]
    }     
}
    console.log('A maior palavra contém ' + maior + ' letras e é ' + maiorPalavra + '.')
    console.log('A menor palavra contém ' + menor + ' letras e é ' + menorPalavra + '.')