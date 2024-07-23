const loginBtn = document.getElementById('landing-page-login-button');
const popup = document.getElementById('popup');
const submitBtn = document.getElementById('submitBtn');
const cancelBtn = document.getElementById('cancelBtn');
loginBtn.addEventListener('click', () => {

    const criteriaMet = (document.getElementById('customer-number-input-field').value=="123");
    // Change 123 to request to Back-end get(cust with this EGN/Client Num)

    if (!criteriaMet) {
        popup.style.display = 'block';
    }
    else {
     window.location.href="./ext/landing-page.html";
    }
});

submitBtn.addEventListener('click', () => {
    const inputEGNValue = document.getElementById('EGN').value;
    const inputNameValue = document.getElementById('Name').value;
    const inputEmailValue = document.getElementById('email').value;

    // Perform validation or further actions here
    // Validate the input first, redirect to landing page once all clear
    window.location.href="./ext/landing-page.html";
});

