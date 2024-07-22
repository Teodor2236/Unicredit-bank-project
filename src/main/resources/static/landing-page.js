loadClient();

-
async function loadClient() {
    try {
        const clientNumber = localStorage.getItem('clientNumber');
        console.log(clientNumber);
        const client = await get(`clients/v1.0.0/get/client-number/${clientNumber}`);
        console.log(client)
    } catch (error) {
        console.error('Error loading users:', error);
    }
}