let loggedInUser;
let nav = document.getElementsByTagName('nav')
let logInBtn;
let page = index.innerHTML;
// call checklogin on the other JS files so that we can make sure other things happen first

async function starting() {
    loggedOutNavBar();
    let httpResp = await fetch('http://localhost:9999/Index.html/');
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        loggedInNavBar();
    } else {
        loggedOutNavBar();
    }
}

function loggedInNavBar() {
    
    
    
    logInBtn = document.getElementById('logInBtn');
    logInBtn.addEventListener('click', logOut);
    document.getElementById('nameDisplay').innerText = loggedInUser.firstName;
}

function loggedOutNavBar() {
    body.innerHTML = `<ul id="navList">
        <li><a href="index.html">PetApp</a></li>
        <li>&#128062;</li>
        <li><a href="all-pets.html">Available Pets</a></li>
        <li><a href="my-pets.html">My Pets</a></li>
    </ul>
    <form id="loginWindow">
        <label for="usernameLogin">Username: </label><input type="text" id="usernameLogin">&nbsp;
        <label for="passwordLogin">Password: </label><input type="password" id="passwordLogin">
        <button type="button" id="logInBtn">Log In</button>
    </form>`;
    logInBtn = document.getElementById('logInBtn');
    logInBtn.addEventListener('click', logIn);
}

async function starting() {
    let credentials = {
        username:document.getElementById('usernameLogin').value,
        password:document.getElementById('passwordLogin').value
    };
    let credentialJSON = JSON.stringify(credentials);

    let httpResp = await fetch('http://localhost:9999/Index.html',
        {method:'POST', body:credentialJSON});
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        sessionStorage.setItem('Auth-Token', loggedInUser.id);
        await starting();
        loggedInNavBar();
    }
}

function logOut() {
    sessionStorage.removeItem('Auth-Token');
    loggedInUser=null;
    loggedOutNavBar();
}

let styleSelector = document.getElementById('styleSelector');
changeStyle();
// when the style selector element has a selection, call the changeStyle function
styleSelector.addEventListener('change',changeStyle);

function changeStyle() {
    document.getElementsByTagName('link')[0].href='styles/'+styleSelector.value;
}
