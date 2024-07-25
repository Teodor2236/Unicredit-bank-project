import {get} from "../js/requester.js";

let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");
const imageContainer = document.getElementById('consumer-credit-image');
const consumerContainer = document.getElementById('consumer-container')

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};

async function loadConsumerCreditDetails(){
  try{
    const consumer = await get('loans/v1.0.0/get/consumer');

    let consumerHTML = '';
    let titleImageHTML = '';
    consumerHTML +=
        `
        <p> ${consumer.description} </p>
        `
    titleImageHTML +=
        `
        <img src="${consumer.imageUrl}" alt="" width="100%" height="300px">
        `
    consumerContainer.innerHTML += consumerHTML;
    imageContainer.innerHTML += titleImageHTML;
  }
  catch (e){
    alert(`Error: ${e}`)
  }
}
await loadConsumerCreditDetails()
