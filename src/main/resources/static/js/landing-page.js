
function loadClient() {
    try {
        const client = JSON.parse(localStorage.getItem('client'));
        const welcomeMessage = document.getElementById("welcome-message")
        welcomeMessage.innerText = `Добре дошли в нашата система, ${client.names}`;
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
                                      <button class="btn card_btn"  id="learn-more-btn"> <a href="${product.htmlFileName}"> Научете повече тук</a></button>
                                  </div>
                              </div>
                          </li>
                      `;
        });

        cardsContainer.innerHTML = cardsHTML;
    } catch (error) {
        console.error('Error:', error);
    }
}

loadClient();
await loadProducts();


