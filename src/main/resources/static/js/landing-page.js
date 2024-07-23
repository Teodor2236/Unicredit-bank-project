
function loadClient() {
    try {
        const client = JSON.parse(localStorage.getItem('client'));
        const welcomeMessage = document.getElementById("welcome-message")
        welcomeMessage.innerText = `Добре дошли в нашата система, ${client.names}`;
    } catch (error) {
        console.error('Error getting client from localStorage: ', error);
    }
}

loadClient();

