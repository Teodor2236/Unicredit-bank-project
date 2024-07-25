import { get } from "../js/requester.js";

const actionSelect = document.getElementById("actionTypeSelect");
const searchButton = document.getElementById("searchByCustomerNumber");
const customerNumberInput = document.getElementById("customerNumberInput");
const customerTable = document.getElementById("customerTable");
const welcomeMessage = document.getElementById("welcomeMessage");

const FIND_CUSTOMER_REQUESTS = "client-requests/v1.0.0/get";

window.addEventListener('load', function() {
    const employee = JSON.parse(localStorage.getItem("employee"));

    welcomeMessage.innerHTML = employee.names;
});

searchButton.addEventListener('click', async function() {
    let selectedValue = actionSelect.value;
    const inputValue = customerNumberInput.value;
    console.log("selected value: " + selectedValue);
    console.log("input value: " + inputValue);

    if (selectedValue === "") {
        selectedValue = "ALL";
    }

    const customerRequests = await get(FIND_CUSTOMER_REQUESTS + "?customerNumber=" + inputValue + "&actionType=" + selectedValue);

    console.log(customerRequests);

    let customerRows = "";

    customerRequests.forEach(request => {
        customerRows += `
            <tr>
                <th scope="row">${request.productDetails.product.type}</th>
                <td>${request.client.names}</td>
                <td>${request.client.clientNumber}</td>
                <td>${request.loanAmount}</td>
                <td>${request.loanTermInMonths}</td>
                <td>${request.loanTerm}</td>
                <td>${request.investmentAmount}</td>
                <td>${request.investmentTermInMonths}</td>
                <td>${request.currency}</td>
                <td>${request.actionType}</td>
            </tr>
        `

        customerTable.innerHTML = customerRows;
    })
});


