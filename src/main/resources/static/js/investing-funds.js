import {get} from "../js/requester.js";

const investmentFundsContainer = document.getElementById("accordion-container")
let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");

menu.onclick = () => {
    menu.classList.toggle("fa-times");
    nav.classList.toggle("active");
};

async function loadInvestmentFunds() {
    try {
      const investments = await get('investments/v1.0.0/get-all')

      let investmentsHTML = '';

      investments.forEach(investment => {
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
                    </div>
                </div>
             </section>
            `
      })
      const buttonHTML = '';
//          `
//          <div class="butoniii">
////            <button class="vhod"><a href="../internal/employeeLogin.html">Заяви</a></button>
//          </div>
//          `
      investmentFundsContainer.innerHTML += investmentsHTML;
      investmentFundsContainer.innerHTML += buttonHTML;
    }
    catch (e){
      alert(`Error: ${e}`)
    }

}

await loadInvestmentFunds()