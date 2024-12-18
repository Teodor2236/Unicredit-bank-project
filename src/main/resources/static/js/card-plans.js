import { get } from "../js/requester.js";
import { sendClientRequest } from "../js/client-request.js";

const plansContainer = document.getElementById("accordion-container");
console.log("here", plansContainer);

async function loadPlans() {
    try {
        const plans = await get('plans/v1.0.0/get-all');
        const productDetails = await get('product-details/v1.0.0/get');
        console.log(plans);
        console.log(productDetails);

        let plansHTML = '';

        plans.forEach(plan => {
            const matchingProductDetail = productDetails.find(
                detail => detail.planType && detail.planType.type === plan.type
            );

            if (!matchingProductDetail) return;

            plansHTML +=
                `
            <section class="accordion" id=${plan.type}>
                <h1 class="title"><a href=#${plan.type}> ${plan.type}</a></h1>
                <div class="content">
                    <div class="wrapper">
                        <img class="accordion-image" src=${plan.imageUrl} alt="" >
                        <ul style="list-style-type: none;">
                            <li>&#10003; ${plan.description}</li>    
                        </ul>
                        <div class="d-grid gap-4 col-4 mx-auto">
                            <button type="button" id="request-button" class="btn btn-success request-button" data-product-details="${matchingProductDetail.id}">Проявявам интерес</button>
                        </div>
                    </div>
                </div>
             </section>
            `;

        });

        plansContainer.innerHTML += plansHTML;
        await setupButtons();
    } catch (e) {
        alert(`Error: ${e}`);
        console.log(e);
    }
}

async function setupButtons() {
    const buttons = document.querySelectorAll('.request-button');
    buttons.forEach(button => {
        button.addEventListener('click', async () => {
            const productDetailsId = button.getAttribute('data-product-details');
            const productDetails = await get(`product-details/v1.0.0/get/${productDetailsId}`) ;
            console.log(button.getAttribute('data-product-details'));
            sendClientRequest(productDetails, 'REQUEST');
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

await loadPlans();
