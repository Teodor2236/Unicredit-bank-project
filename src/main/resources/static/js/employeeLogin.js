import { post } from "../js/requester.js";

const employeeNumberInput = document.getElementById("employeeNumberInput");
const passwordInput = document.getElementById("passwordInput");
const loginButton = document.getElementById("loginButton");

const LOGIN_URL = "employees/v1.0.0/login";

window.addEventListener('load', function() {
    localStorage.clear();
});

loginButton.addEventListener('click', async function() {
    const employeeNumber = employeeNumberInput.value;
    const password = passwordInput.value;

    const request = {
        "employeeNumber" : employeeNumber,
        "password" : password
    };

    const employee = await post(LOGIN_URL, request);

    localStorage.setItem("employee", JSON.stringify(employee));

    window.location.href = "http://localhost:8080/internal/employeeDash.html";
});
