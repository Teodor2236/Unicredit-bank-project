let menu = document.querySelector("#navbar");
let nav = document.querySelector(".menu");

menu.onclick = () => {
  menu.classList.toggle("fa-times");
  nav.classList.toggle("active");
};