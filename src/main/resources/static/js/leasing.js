import {get} from "../js/requester.js";
import { sendClientRequest } from "../js/client-request.js";

const leasingContainer = document.getElementById('leasing-container')
let confirmationBox = document.getElementById("confirmationBox");
let closeConfirmation = document.getElementById("closeConfirmation");

async function loadLeasingData(){
    try {
            const leasing = await get('leasings/v1.0.0/get-all');
            const productDetails = await get('product-details/v1.0.0/get');

            let leasingHTML = '';

            leasing.forEach(leasing => {
            const matchingProductDetail = productDetails.find(
                            detail => detail.leasingType && detail.leasingType.type === leasing.type
                        );

                        if (!matchingProductDetail) return;
                leasingHTML +=
                    `
                    <section class="accordion" id=${leasing.type}>
                        <h1 class="title"><a href=#${leasing.type}> ${leasing.type}</a></h1>
                        <div class="content">
                            <div class="wrapper">
                                <img class="accordion-image" src=${leasing.imageUrl} alt="" >
                                <ul style="list-style-type: none;">
                                    <li>&#10003; ${leasing.description}</li>    
                                </ul>
                                <div class="d-grid gap-4 col-4 mx-auto">
                                  <button id="request-button" type="button" class="btn btn-success request-button" data-product-details="${matchingProductDetail.id}">Проявявам интерес</button>
                                 </div>
                            </div>
                        </div>
                    </section>
                    `
            })
            leasingContainer.innerHTML += leasingHTML;
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
await loadLeasingData()