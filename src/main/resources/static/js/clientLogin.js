console.log("here")

const landingButton = document.getElementById('landing-page-login-button')
console.log(landingButton)
landingButton.addEventListener('click', function() {
    console.log("inside")
    const clientNumber = document.getElementById('customer-number-input-field').value;
    console.log(clientNumber)
    localStorage.setItem('clientNumber', clientNumber);
});
