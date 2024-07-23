import {get} from "./requester";

const submitBtn = document.getElementById('submitBtn');
const landingButton = document.getElementById('landing-page-login-button')

landingButton.addEventListener('click', async function () {

    await fetchAndSaveClient()
});

let client;
async function fetchAndSaveClient() {
    try {
        const inputNumber = document.getElementById('customer-number-input-field').value;

        if(inputNumber.length() < 9 && inputNumber.length() >10) {
            alert("Invalid length. Enter a valid EGN or Client number.")
        }
        if(inputNumber.length() === 9){
            client = await get(`clients/v1.0.0/get/client-number/${inputNumber}`);
        }
        if(inputNumber.length() === 10){
            client = await get(`clients/v1.0.0/get/EGN/${inputNumber}`);
        }


        if(!client){
            popup.style.display = 'block';
            return;
        }
        window.location.href="./ext/landing-page.html";

        localStorage.setItem('client', client)
    } catch (error) {
        console.error('Error loading users:', error);
    }
}


submitBtn.addEventListener('click', () => {
    const inputEGNValue = document.getElementById('EGN').value;
    const inputNameValue = document.getElementById('Name').value;
    const inputEmailValue = document.getElementById('email').value;

    client.EGN = inputEGNValue;
    client.names = inputNameValue;
    client.email = inputEmailValue;


    window.location.href="./ext/landing-page.html";
});

