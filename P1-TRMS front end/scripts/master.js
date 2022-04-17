let loggedInUser;
let logInBtn;
let logInLogout;


async function checkLogin() {
    let userId = sessionStorage.getItem('Auth-Token');
    let httpResp = await fetch('http://localhost:9999/users/' + userId);
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
    }
}


async function logIn() {
    let credentials = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    let credentialJSON = JSON.stringify(credentials);

    let httpResp = await fetch('http://localhost:9999/Users',
        { method: 'POST', body: credentialJSON });
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        sessionStorage.setItem('Auth-Token', loggedInUser.user);
        await checkLogin();
        location.replace('index.html');
        document.getElementById('Loginlogout').innerText = "LogOut";

    }
}
function loggedInNavBar() {

    logInLogout = document.getElementById('Loginlogout');
    logInLogout.addEventListener('click', logOut);
    document.getElementById('Usergreeting').innerText = "Welcome" + loggedInUser.firstName;
    logInLogout.innerText = "LogOut";
}

function loggedOutNavBar() {

    logInBtn = document.getElementById('logInBtn');
    logInBtn.addEventListener('click', logIn);

}


async function logIn() {
    let credentials = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    let credentialJSON = JSON.stringify(credentials);

    let httpResp = await fetch('http://localhost:9999/auth',
        { method: 'POST', body: credentialJSON });
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        sessionStorage.setItem('Auth-Token', loggedInUser.id);
        await checkLogin();
        loggedInNavBar();
    }
}

function logOut() {
    sessionStorage.removeItem('Auth-Token');
    loggedInUser = null;
    loggedOutNavBar();
}


