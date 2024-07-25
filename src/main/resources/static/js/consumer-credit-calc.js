import {sendClientRequest} from "../js/client-request.js";
import {get} from "./requester.js";

let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");
let interestedButton = document.getElementById("calcing");
let confirmationBox = document.getElementById("confirmationBox");
let closeConfirmation = document.getElementById("closeConfirmation");

menu.onclick = () => {
    menu.classList.toggle("fa-times");
    nav.classList.toggle("active");
};

var sumSlider = document.getElementById("myRange");
var sumInput = document.getElementById("s-sum");
sumInput.value = sumSlider.value;

sumSlider.oninput = function () {
    sumInput.value = this.value;
    calc();
};

sumInput.oninput = function () {
    sumSlider.value = this.value;
    calc();
};

var periodSlider = document.getElementById("myRange2");
var periodInput = document.getElementById("p-period");
periodInput.value = periodSlider.value;

periodSlider.oninput = function () {
    periodInput.value = this.value;
    calc();
};

periodInput.oninput = function () {
    periodSlider.value = this.value;
    calc();
};

function calc() {
    var suma = parseFloat(sumInput.value);
    var period = parseFloat(periodInput.value);
    var mesVnoska = document.getElementById("m-installment");

    var mesLihva = parseFloat(2.69 / 100 / 12);

    mesVnoska.value = ((mesLihva * suma * Math.pow((1 + mesLihva), period))
        / (Math.pow((1 + mesLihva), period) - 1)).toFixed(2);
}

calc();

interestedButton.addEventListener('click', async () => {
    const productDetail = await get("product-details/v1.0.0/get/4");
    await sendClientRequest(productDetail, 'REQUEST');
    confirmationBox.style.display = 'block';
});

closeConfirmation.onclick = () => {
    confirmationBox.style.display = 'none';
};

window.onclick = (event) => {
    if (event.target === confirmationBox) {
        confirmationBox.style.display = 'none';
    }
};
