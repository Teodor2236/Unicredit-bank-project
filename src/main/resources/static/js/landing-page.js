import {get} from "../js/requester.js";

async function loadClient() {
    try {
        console.log("here")
        const clientNumber = localStorage.getItem('clientNumber');
        console.log(clientNumber);
        const client = await get(`clients/v1.0.0/get/client-number/${clientNumber}`);
        const welcomeMessage = document.getElementById("welcome-message")
        welcomeMessage.innerText = `Добре дошли в нашата система, ${client.names}`;
        console.log(client);
    } catch (error) {
        console.error('Error loading users:', error);
    }
}

async function loadProducts() {
    try {
        const product = await get (`products/v1.0.0/get/${id}`);
        const name = document.getElementByID("card-name");
        name.innerText = ${products.type};
    }
}

await loadClient();
