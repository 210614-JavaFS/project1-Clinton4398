//object without a class
let obj = {
  name:"tim",
  age: 19,
  favoriteAnimal: "unicorn",
  speak: () => {
    console.log(obj.name+" says hi.");
  }
}

console.log(obj);

console.log(obj.name);

obj.speak();

//Class declarations

class Person {
  constructor(name, age){
    this.name = name;
    this.age = age;
  }
}


let Tim = new Person("Tim", 19);

console.log(Tim);

let Pet = class {
  constructor(name, type){
    this.name = name;
    this.type = type;
  }
}

let myCat = new Pet("Artemis", "Cat");

console.log(myCat);

//Prototypical Inheritance

let animal = {
  eats:true,
  walk() {
    alert("I can walk");
  }
}

let rabbit = {
  jumps:true,
  __proto__:animal
}

rabbit.walk();

console.log(rabbit);

rabbit.color= "white";

console.log(rabbit.color);

console.log(rabbit);

let x = 3;
let y = 7;
result = `The product of ${x} and ${y} is ${x*y}`
console.log(result);
