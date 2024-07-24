import {get} from "../js/requester.js";

let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");
const consumerContainer = document.getElementById('consumer-container')

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};

async function loadConsumerDetails(){
  try{
    const consumer = await get('loans/v1.0.0/get/consumer');

    let consumerHTML = '';

    consumerHTML +=
        `
        <img src="${consumer.imageUrl}" alt="">
        <p> ${consumer.description} </p>
        `
    consumerContainer.innerHTML += consumerHTML;
  }
  catch (e){
    alert(`Error: ${e}`)
  }
}
await loadConsumerDetails()
