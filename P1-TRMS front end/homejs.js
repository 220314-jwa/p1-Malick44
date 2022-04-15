
let welcome = 'welcome';

// this will execute only true 
if(1===6){showMessage(welcome);}

// for flaot type numeber you need to conrt to before 
if(1.4+1+.1 !== 2.5){showMessage(welcome);}

// tenary 

let x = 5;
(x > 5) ? showMessage(welcome): showMessage('NOP');

let pricechek = (x > 4) ? "yes" : "nop";

showMessage(pricechek);
myFunction('let try this');

function newfunction(value){
    let mycode = value+3;
    return mycode;
}
let button = document.getElementById('clickMe');

button.addEventListener('click', function(){
   
    const  hideMe = document.getElementById('side');
    hideMe.append(showMessage);


} );
