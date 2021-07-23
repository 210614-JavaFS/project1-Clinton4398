//Get HTML Elements
let pokepic = document.getElementById("pokepic");
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");

let button = document.getElementById("btn");
button.addEventListener("click", ajaxFunc);

function ajaxFunc(){
  let num = document.getElementById("field").value;

  let xhr = new XMLHttpRequest();

  //Determine first how to handle the response before sending the request. 

  xhr.onreadystatechange = function () {
    //wait till we have the response and it is a successful response
    if(this.readyState===4 && this.status===200){
      
      //data is JS object created from the JSON the API sent back in the response. 
      let data = JSON.parse(xhr.responseText);

      renderData(data);
    }
  }

  xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+num, true);
  xhr.send();
}

//What will I do with the data from the response.
function renderData(data){
  pokename.innerText = data.name;
  pokenum.innerText = data.id;
  poketype.innerText = data.types[0].type.name;
  if(data.types[1]){
    poketype.append(", "+data.types[1].type.name);
  }
  pokepic.setAttribute('src', data.sprites.front_default);
}