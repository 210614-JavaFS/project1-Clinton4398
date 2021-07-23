//This will print to the console
console.log("Hello JavaScript, it's nice to meet you!");

var a = 100;
console.log('Var a is of type: '+typeof a);
a = true;
console.log('Var a is of type: '+typeof a);
a = null;
console.log('Var a is of type: '+typeof a);
a = "I'm a string";
console.log('Var a is of type: '+typeof a);

var b;
console.log('Var b is of type: '+typeof b); //undefined. 

c = "I am undeclared" //JS added the var and ; for me. 
console.log(c);

console.log("=============COERCION====================")

function CoercionTest(inp1, inp2){ //This is a named function.
  console.log("=================================")
  console.log("First input is "+inp1+" which is of the type: "+typeof inp1);
  console.log("Second input is "+inp2+" which is of the type: "+typeof inp2);
  console.log("Coercions shows them as "+((inp1==inp2)?"the same":"different"));
}

CoercionTest('3', 3);

CoercionTest(false, "false");

CoercionTest(0, false);

CoercionTest(1, true);

CoercionTest(2, true);

CoercionTest("true", true);

CoercionTest("1", true);

CoercionTest(false, '');

CoercionTest("null", null);

CoercionTest(null, undefined);

CoercionTest({}, {});

CoercionTest([], []);

CoercionTest([], {});

CoercionTest(NaN, NaN);

console.log("================TRUTHY/FALSY=================")

var truthyTest = function(inp1) {
  console.log("=================================")
  if(inp1){
    console.log(inp1 + " of type "+typeof inp1+" is truthy.");
  }else{
    console.log(inp1 + " of type "+typeof inp1+" is falsy.");
 }
}

truthyTest(true);

truthyTest(false);

truthyTest(0);

truthyTest(1); //t

truthyTest(-1); //t

truthyTest("0"); //t

truthyTest(null); //f

truthyTest(undefined);  //f

truthyTest(''); //f

truthyTest(NaN); //f

truthyTest(' '); //t

truthyTest({}); //t

truthyTest([]); //t

truthyTest([]+[]); //f

console.log([]+[] + " is of type "+typeof([]+[])); // produces '' which is falsy.

var arrowFunc = () => {console.log("I'm an arrow function.")}

arrowFunc();

console.log("============SCOPES=====================")
console.log("=================================")

console.log(d)

var d = "I'm var d"; // the declaration var d is being hoisted to the top of the script. All vars declarations are
// moved by JS to the top of the script and thus all global vars always exists in the script. Assignment still takes 
//place in the location where it is placed in the script. 

console.log(d) //d is global scope

function hoistFunc() {
  console.log(e);
  var e = "I'm var e"; //e is function scope
  console.log(e);
}

hoistFunc();

//console.log(e); func scoped.

console.log("=================================")
console.log(f);
if(true){
  var f = "I'm var f"; //hoisted to the top so is globally scoped. Can't be block scoped. 
  console.log(f);
}
console.log(f);

console.log("=================================")

//console.log(g); g is not hoisted so I can't reference it before it is declared. 
let g = "I'm let g";
console.log(g);

if(true){
  let h = "I'm let h";
  console.log(h);
}
//console.log(h); h is block scoped so throws a reference error. 

console.log("================Callbacks=================")

function myCallback(inp1, inp2){
  inp2(inp1);
}

myCallback("I'm input 1", (inp)=>{console.log("You gave me "+inp)});

myCallback("I'm input 1", (inp)=>{console.log("Now you give me "+inp+"? How rude!")});

console.log("================Closures=================")

function adder(x){
  return function (y){
    return x+y;
  }
}

let add5 = adder(5);

let result = add5(7);
console.log(result); //12

result = add5(9);
console.log(result); //14

console.log("=================================")

let greeting = (name)=>{
  return () => {
    console.log("Hello "+name);
  }
}

greeting = greeting("Tim"); //greeting = () => {console.log("Hello "+"Tim");}

greeting(); //Tim 

greeting("John"); //Tim