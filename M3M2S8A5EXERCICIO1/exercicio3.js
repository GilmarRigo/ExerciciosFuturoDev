doisObjetos('estamos aqui', 'estamos ali')

function doisObjetos(objeto1, objeto2){
let A = {
  frase1: objeto1,
};
  
let B = {
  frase2: objeto2,
};
  
let Sites = Object.assign(A, B);
  
console.log(Sites);
}
