import { sendClientRequest } from "../js/client-request.js";

async function loadClient() {
    try {
        const client = JSON.parse(localStorage.getItem('client'));
        const welcomeMessage = document.getElementById("welcome-message")
        welcomeMessage.innerHTML = `Добре дошли,<br><b>${client.names}</b>!`;
    } catch (error) {
        console.error('Error getting client from localStorage: ', error);
    }
}

async function loadProducts() {
    try {
        const response = await fetch('http://localhost:8080/products/v1.0.0/get');
        const products = await response.json();
        console.log(products);

        const cardsContainer = document.getElementById('cards-container')

        let cardsHTML = '';
        products.forEach(product => {
            cardsHTML += `
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image">
                            <img src="${product.imageUrl}" alt="${product.imageUrl}">
                        </div>
                        <div class="card_content">
                            <h2 class="card_title">${product.type}</h2>
                            <p class="card_text">${product.description}</p>
                            <button class="btn card_btn learn-more-btn" data-product-type="${product.type}">Научете повече</button>
                        </div>
                    </div>
                </li>
            `;
        });

        cardsContainer.innerHTML = cardsHTML;

        document.querySelectorAll('.learn-more-btn').forEach(button => {
            button.addEventListener('click', async (event) => {
                const productType = event.target.getAttribute('data-product-type');
                await handleLearnMoreClick(productType, products);
            });
        });

    } catch (error) {
        console.error('Error:', error);
    }
}

async function handleLearnMoreClick(productType, products) {
    try {
        const productDetailsResponse = await fetch('http://localhost:8080/product-details/v1.0.0/get');
        const productDetails = await productDetailsResponse.json();
        console.log("product type"+ productType);

        console.log("product details:");
        console.log(productDetails);
        const matchedProductDetail = productDetails.find(detail => detail.product.type === productType);
        const product = products.find(p => p.type === productType);
        console.log("matched product detail id: "+matchedProductDetail.id);
        if (matchedProductDetail) {
            await sendClientRequest(matchedProductDetail, 'VIEW');
            window.location.href = product.htmlFileName;
        } else {
            console.error(`No product details found for product type: ${productType}`);
        }
    } catch (error) {
        console.error('Error handling learn more click:', error);
    }
}

loadClient();
loadProducts();
