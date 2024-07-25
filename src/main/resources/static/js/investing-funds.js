import {get} from "../js/requester.js";
import { sendClientRequest } from "../js/client-request.js";

const investmentFundsContainer = document.getElementById("accordion-container")
let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");
let confirmationBox = document.getElementById("confirmationBox");
let closeConfirmation = document.getElementById("closeConfirmation");

menu.onclick = () => {
    menu.classList.toggle("fa-times");
    nav.classList.toggle("active");
};

async function loadInvestmentFunds() {
    try {
      const investments = await get('investments/v1.0.0/get-all');
       const productDetails = await get('product-details/v1.0.0/get');

      let investmentsHTML = '';

      investments.forEach(investment => {
      const matchingProductDetail = productDetails.find(
                      detail => detail.investmentType && detail.investmentType.type === investment.type
                  );

                  if (!matchingProductDetail) return;

        investmentsHTML +=
            `
            <section class="accordion" id=${investment.type}>
                <h1 class="title"><a href=#${investment.type}> ${investment.type}</a></h1>
                <div class="content">
                    <div class="wrapper">
                            <img class="accordion-image" src=${investment.imageUrl} alt="" >
                            <ul style="list-style-type: none;">
                                <li>&#10003; ${investment.description}</li>    
                            </ul>
                            <div class="d-grid gap-4 col-4 mx-auto">
                                 <button id="request-button" type="button" class="btn btn-success request-button" data-product-details="${matchingProductDetail.id}">Проявявам интерес</button>
                            </div>
                    </div>
                </div>
             </section>
            `
      })

      investmentFundsContainer.innerHTML += investmentsHTML;
      setupButtons();

    }
    catch (e){
      alert(`Error: ${e}`)
    }

}

function setupButtons() {
    const buttons = document.querySelectorAll('.request-button');
    buttons.forEach(button => {
        button.addEventListener('click', async () => {
            const productDetailsId = button.getAttribute('data-product-details');
            const productDetails = await get(`product-details/v1.0.0/get/${productDetailsId}`) ;
            await sendClientRequest(productDetails, 'REQUEST');
            confirmationBox.style.display = 'block';
        });
    });
}

closeConfirmation.onclick = () => {
    confirmationBox.style.display = 'none';
};

window.onclick = (event) => {
    if (event.target === confirmationBox) {
        confirmationBox.style.display = 'none';
    }
};
await loadInvestmentFunds()