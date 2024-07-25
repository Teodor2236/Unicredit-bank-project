import { post } from "../js/requester.js";

export async function sendClientRequest(productDetails, actionType) {
    const client = JSON.parse(localStorage.getItem('client'));
    if (!client || !client.id) {
        return;
    }

    const postData = {
        client,
        actionType,
        productDetails
    };

    try {
        console.log(postData);
        const response = await post('client-requests/v1.0.0/create', postData);
        console.log(response);
    } catch (error) {
        alert(`Error: ${error}`);
        console.log(error);
    }
}
