const api = 'https://pokeapi.co/api/v2/pokemon/'

let dataSection = document.getElementById("data");
let button = document.getElementById("btn");

button.onclick = getPoke;

async function getPoke(){
  let userInput = document.getElementById("num").value;

  let response = await fetch(api+userInput);

  if(response.status===200){
    let data = await response.json();
    populateData(data);
  }else{
    console.log("It got away!");
  }
}

function populateData(data){

  let nameTag = document.createElement('h3');
  nameTag.innerText = data.name;

  let abilities = document.createElement('ul');
  console.log(data.abilities);
  let abilArray = data.abilities;

  for(let ability of abilArray){
    let li = document.createElement('li');
    li.innerText=ability.ability.name;
    abilities.appendChild(li);
  }

  dataSection.appendChild(nameTag);
  dataSection.appendChild(abilities);

}