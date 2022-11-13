let n = 10;
fatorial = []
//let fato;
let nn = 1;
if(n == 0){
    fatorial[0] = 1;
    let fatorial1 = fatorial.join('x') 
    console.log(fatorial1) 
}
for(let i = 0; i < n; i++){   
    fatorial[i] = nn;   
    let inverter = fatorial.slice(0).reverse();
    let fatorial1 = inverter.join('x')    
    console.log(fatorial1)     
    nn++    
}

