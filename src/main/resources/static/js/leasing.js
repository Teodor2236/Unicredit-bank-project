import {get} from "../js/requester.js";

const leasingContainer = document.getElementById('leasing-container')

async function loadLeasingData(){
    try {
        {
            const leasing = await get('leasings/v1.0.0/get-all');

            let leasingHTML = '';

            leasing.forEach(leasing => {
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
                            </div>
                        </div>
                    </section>
                    `
            })
            leasingContainer.innerHTML += leasingHTML;
        }

    }
    catch (e){
        alert(`Error: ${e}`)
    }
}
await loadLeasingData()