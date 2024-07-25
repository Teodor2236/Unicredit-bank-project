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
        const response = await post('client-requests/v1.0.0/create', postData);
    } catch (error) {
        console.error(error);
    }
}
