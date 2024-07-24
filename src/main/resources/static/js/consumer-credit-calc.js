let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};


var sumSlider = document.getElementById("myRange");
var sumInput = document.getElementById("s-sum");
sumInput.value = sumSlider.value;

sumSlider.oninput = function() {
  sumInput.value = this.value;
  calc();
}

sumInput.oninput = function() {
  sumSlider.value = this.value;
  calc();
}

var periodSlider = document.getElementById("myRange2");
var periodInput = document.getElementById("p-period");
periodInput.value = periodSlider.value;

periodSlider.oninput = function() {
  periodInput.value = this.value;
  calc();
}

periodInput.oninput = function() {
  periodSlider.value = this.value;
  calc();
}


function calc() {
    var suma = parseFloat(sumInput.value);
    var period = parseFloat(periodInput.value);
    var mesVnoska = document.getElementById("m-installment");

    var mesLihva = parseFloat(2.69 / 100 / 12);

    mesVnoska.value = ((mesLihva * suma * Math.pow((1 + mesLihva), period))
    / (Math.pow((1 + mesLihva), period) - 1)).toFixed(2);
}


calc();


