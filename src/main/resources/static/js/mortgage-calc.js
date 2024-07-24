//let menu = document.querySelector("#navbar");
//let nav = document.querySelector(".menu");
//
//menu.onclick = () => {
//  menu.classList.toggle("fa-times");
//  nav.classList.toggle("active");
//};
//
//
//var slider = document.getElementById("myRange");
//var output = document.getElementById("s-sum");
//output.value = slider.value;
//
//slider.oninput = function() {
//  output.value = this.value;
//}
//
//var slider = document.getElementById("myRange2");
//var output2 = document.getElementById("p-period");
//output2.value = slider.value;
//
//slider.oninput = function() {
//  output2.value = this.value;
//}
//
//
//function calc() {
//
//    var suma = document.getElementById("s-sum")
//    var period = document.getElementById("p-period")
//    var mesVnoska = document.getElementById("m-installment")
//
//    var mesLihva = parseFloat(2.69 / 100 / 12);
//
//    mesVnoska.value = ((parseFloat(mesLihva) * parseFloat(suma.value)
//     * Math.pow((1 + mesLihva), parseFloat(period.value)))
//      / Math.pow((1 + mesLihva), parseFloat(period.value)) - 1).toFixed(2);
//
//
//}
//
//
//
//var calculate = document.getElementById("calcing");
//
//calculate.addEventListener('click', function()  {
//        calc();
//
//});

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





