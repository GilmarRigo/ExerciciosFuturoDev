/* let botao = document.getElementById('id-form')
botao.addEventListener("submit", (teste) => {
    let mostra = teste
    console.log(mostra)
}) */

async function pegaPoke(poke) {
    console.log(poke)
    const pokemon = await (await fetch (`https://pokeapi.co/api/v2/pokemon/${poke}`)).json()
    console.log(pokemon)
    for(const key in pokemon.stats){
        console.log(pokemon.stats[key].stat.name)
        const status = pokemon.stats[key].stat.name
        const baseState = pokemon.stats[key].base_stat        
        const paragrafo = document.createElement('p')
        paragrafo.innerHTML = `${status}:${baseState}`
        document.getElementById('id-lista-informacao').appendChild(paragrafo)
    }
}

let radio =  document.getElementById('btn');
radio.addEventListener("click", () => {
    let pokemonEscolhido = document.querySelector('input[name="pokemon"]:checked').value;
    console.log(pokemonEscolhido);

pegaPoke(pokemonEscolhido)
})

