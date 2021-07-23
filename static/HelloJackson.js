const URL = 'http://localhost:8080/HelloJackson/';

let avengerButton = document.getElementById("avengerButton");
let homeButton = document.getElementById("homeButton");
let getHomeButton = document.getElementById("getOneHome");
let addHomeButton = document.getElementById("addHomeButton");

homeButton.onclick = getHomes;
avengerButton.onclick = avengersAssemble;
getHomeButton.onclick = getOneHome;
addHomeButton.onclick = addHome;

async function avengersAssemble(){
  let response = await fetch(URL+'avenger');

  if(response.status===200){
    let data = await response.json();
    populateAvengerTable(data);
  }else{
    console.log('The Avengers are busy saving the planet, come back later.')
  }
}

function populateAvengerTable(data){
  let tbody = document.getElementById("tableBody");

  tbody.innerHTML = ""

  for(let avenger of data){
    let row = document.createElement("tr");

    for(let cell in avenger){
      let td = document.createElement("td");
      if(cell=='home'&&avenger[cell]){
        td.innerText= avenger[cell].homeName + ": "+avenger[cell].streetAddress+", "+avenger[cell].city+
          ", "+avenger[cell].region+" "+avenger[cell].zip;
      }else{
        td.innerText=avenger[cell];
      }
      row.appendChild(td);
    }

    tbody.appendChild(row);
  }
}

async function getHomes(){
  let response = await fetch(URL+'home');

  if(response.status==200){
    let homeData = await response.json();
    populateHomeTable(homeData);
  }else{
    console.log("There was a problem accessing the homes.")
  }
}

function populateHomeTable(data){
  let homeBody = document.getElementById("homeBody");

  homeBody.innerHTML="";

  for(let home of data){
    let row = document.createElement("tr");

    for(let cell in home){
      let td = document.createElement("td");
      td.innerText=home[cell];
      row.appendChild(td);
    }
    homeBody.appendChild(row);
  }
}

async function getOneHome(){
  let input = document.getElementById("homeRequest").value;

  let response = await fetch(URL+"home/"+input);

  if(response.status===200){
    let data = await response.json();
    let paragraph = document.getElementById("homeInfo");
    paragraph.innerText = data.homeName+": "+data.streetAddress+", "+data.city+
    ", "+data.region+" "+data.zip;
  }else{
    console.log("Could not retrieve home.");
  }
}

function getUserHome(){
  let newHomeName = document.getElementById("homeName").value;
  let homeStreet = document.getElementById("homeStreet").value;
  let homeCity = document.getElementById("homeCity").value;
  let homeRegion = document.getElementById("homeRegion").value;
  let homeZip = document.getElementById("homeZip").value;

  let home = {
    homeName:newHomeName,
    streetAddress:homeStreet,
    city:homeCity,
    region:homeRegion,
    zip:homeZip
  }

  return home;
}

async function addHome(){
  let home = getUserHome();

  let response = await fetch(URL+'home', {
    method:'POST',
    body:JSON.stringify(home),
    //credentials: 'include' //This will include cookies in the request if they are present. It will
    //also ensure new cookies are accepted. 
  });

  if(response.status===201){
    console.log("Home successfully created");
  }else {
    console.log("Something went wrong trying to add new home.")
  }
}