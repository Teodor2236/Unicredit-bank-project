import {get, post} from "../js/requester.js";

const submitBtn = document.getElementById('submitBtn');
const landingButton = document.getElementById('landing-page-login-button')
const warningContainer= document.getElementById('main-part')
let elementExists=false;
localStorage.clear();
function removeElement(id='bad-input') {
    var elem = document.getElementById(id);
    return elem.parentNode.removeChild(elem);
}
landingButton.addEventListener('click', async function () {
    if(elementExists){
        removeElement('bad-input')
        elementExists=false;}
    await fetchAndSaveClient()
});

let client;

async function fetchAndSaveClient() {
    try {
        const inputNumber = document.getElementById('customer-number-input-field').value;

        if (inputNumber.length < 9 || inputNumber.length > 10) {

        const warningBadInput = document.createElement('div');
        warningBadInput.id="bad-input";
        warningBadInput.textContent = 'Wrong format. Enter a valid EGN (10 symbols) or Client number (9 symbols).';
        warningContainer.appendChild(warningBadInput);
        elementExists=true;
            return
        }
        if (inputNumber.length === 9) {
            client = await get(`clients/v1.0.0/get/client-number/${inputNumber}`);
        }
        if (inputNumber.length === 10) {
            client = await get(`clients/v1.0.0/get/EGN/${inputNumber}`);
        }

        if (!client) {
            popup.style.display = 'block';
            return;
        }
        window.location.href = "./ext/landing-page.html";

        localStorage.setItem('client', JSON.stringify(client))
    } catch (error) {
        console.error('Error loading users:', error);
    }
}

submitBtn.addEventListener('click', async () => {
    const inputEGNValue = document.getElementById('EGN').value;
    const inputNameValue = document.getElementById('Name').value;
    const inputEmailValue = document.getElementById('email').value;

    const namesArray = inputNameValue.trim().split(' ');
    const firstInitial = namesArray[0][0].toUpperCase();
    const lastInitial = namesArray[namesArray.length - 1][0].toUpperCase();
    const randomNumbers = Math.floor(1000000 + Math.random() * 9000000).toString();

    let clientData = {
        names: inputNameValue,
        email: inputEmailValue,
        egn: inputEGNValue,
        clientNumber: `${firstInitial}${lastInitial}${randomNumbers}`
    }
    const persistedClient = await post(`clients/v1.0.0/create`, clientData);

    localStorage.setItem('client', JSON.stringify(persistedClient))

    window.location.href = "./ext/landing-page.html";
});

