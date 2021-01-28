// document.getElementById("exemple").innerHTML = "NOUVEAU TEXTE";
var element_exemple = document.getElementById("score");
var element_clic = document.getElementById("click");
var click=1
var f1 = function(){
    element_clic.innerHTML = click++;
}
element_exemple.addEventListener('click',f1);