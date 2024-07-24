import {get} from "../js/requester.js";

let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");
const mortgageContainer = document.getElementById('mortgage-container')

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};

async function loadMortgageDetails(){
  try{
    const mortgage = await get('loans/v1.0.0/get/mortgage');

    let mortgageHTML = '';

    mortgageHTML +=
        `
        <img src="${mortgage.imageUrl}" alt="">
        <p> ${mortgage.description} </p>
        `
    mortgageContainer.innerHTML += mortgageHTML;
  }
  catch (e){
    alert(`Error: ${e}`)
  }
}
await loadMortgageDetails()