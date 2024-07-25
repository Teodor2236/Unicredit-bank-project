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
                <td>${valueIdentifier(request.client.names)}</td>
                <td>${valueIdentifier(request.client.clientNumber)}</td>
                <td>${valueIdentifier(request.loanAmount)}</td>
                <td>${valueIdentifier(request.loanTermInMonths)}</td>
                <td>${valueIdentifier(request.loanTerm)}</td>
                <td>${valueIdentifier(request.investmentAmount)}</td>
                <td>${valueIdentifier(request.investmentTermInMonths)}</td>
                <td>${valueIdentifier(request.currency)}</td>
                <td>${valueIdentifier(request.actionType)}</td>
            </tr>
        `

        request.client === "undefined";

        customerTable.innerHTML = customerRows;
    })
});

function valueIdentifier(value) {
    if (value === undefined) {
        return "-";
    } else if (value === 0) {
        return "-";
    } else {
        return value;
    }
}


