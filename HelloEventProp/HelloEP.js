const bubbling = false;
const capturing = true;


let inner = document.getElementById("inner");
let middle = document.getElementById("middle");
let outer = document.getElementById("outer");
let otherMiddle = document.getElementById("othermiddle");

inner.addEventListener("click", (event)=>{ console.log("INNER - capturing") }, capturing);
//middle.addEventListener("click", (event)=>{ event.stopPropagation()}, capturing);
middle.addEventListener("click", (event)=>{ console.log("MIDDLE - capturing") }, capturing);
outer.addEventListener("click", (event)=>{ console.log("OUTER - capturing") }, capturing);
otherMiddle.addEventListener("click", (event)=>{ console.log("OTHER MIDDLE - capturing") }, capturing);
inner.addEventListener("click", (event)=>{ console.log("INNER - bubbling") }, bubbling);
middle.addEventListener("click", (event)=>{ event.stopImmediatePropagation()}, bubbling);
middle.addEventListener("click", (event)=>{ console.log("MIDDLE - bubbling") }, bubbling);
outer.addEventListener("click", (event)=>{ console.log("OUTER - bubbling") }, bubbling);
otherMiddle.addEventListener("click", (event)=>{ console.log("OTHER MIDDLE - bubbling") }, bubbling);