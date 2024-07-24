import {get} from "../js/requester.js";

const plansContainer = document.getElementById("accordion-container");
console.log("here", plansContainer)

async function loadPlans() {
    try {
        const plans = await get('plans/v1.0.0/get-all');
        console.log(plans);

        let plansHTML = '';

        plans.forEach(plan => {
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
                    </div>
                </div>
             </section>
            `
        })
        const buttonHTML =
            `
            <div class="d-grid gap-4 col-4 mx-auto">
                <button type="button" class="btn btn-success" id="request_button"><a href="../index.html" style="font-size: 15pt;">Заяви</a></button>
            </div>
            `
        plansContainer.innerHTML += plansHTML;
        plansContainer.innerHTML += buttonHTML;
    }
    catch (e){
        alert(`Error: ${e}`)
    }
}

await loadPlans()