let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};


var slider = document.getElementById("myRange");
var output = document.getElementById("s-sum");
output.value = slider.value;

slider.oninput = function() {
  output.value = this.value;
}

var slider = document.getElementById("myRange2");
var output2 = document.getElementById("p-period");
output2.value = slider.value;

slider.oninput = function() {
  output2.value = this.value;
}

var slider = document.getElementById("myRange3");
var output3 = document.getElementById("m-installment");
output3 = (output.value / output2.value);
output3.value = slider.value;

slider.oninput = function() {
  output3.value = this.value;
}


