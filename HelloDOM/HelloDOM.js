let p1 = document.getElementById("p1");

p1.textContent = "Wow look at my new content.";

let divs = document.getElementsByClassName("myClass");

divs[0].setAttribute("style", "border:10px dashed aqua");


divs[1].addEventListener("mouseover", () => {
  let kid = document.createElement("p")
  kid.textContent = "I'm a new paragraph";
  divs[1].appendChild(kid);
})

let btn = document.getElementById('myButton');

let pText = false;

btn.onclick = () => {
  if(pText){
    document.getElementById("p3").innerText = "I'm a happy paragraph!";
    pText = false;
  }else {
    document.getElementById("p3").innerText = "I'm a sad paragraph!";
    pText = true;
  }
}