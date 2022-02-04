// modificciones y accesos a nodos por parte de codigo

//Encuentra un html element (antigo)
let boton = document.getElementById('boton-agregar');

// sihay varios sale un html collection (antigo)
let botones = document.getElementsByClassName('btn');
let inputs = document.getElementsByTagName('input');

// query -> actual: (#)esNombreID (.)Laclase (nada es)tag
// el primer elemento que tiene la clase btn
/*
let botonQuery = document.querySelectorAll('.btn');
botonQuery.forEach((element, index) => {
    element.innerHTML = `Pulsado ${index+1}`
});
*/
let botonesQuery = document.querySelector('.btn');
let lista = document.querySelector('#lista-contenido');

//lista.innerHTML += "<li>Elemento nuevo</li>";

let botonAgregar = document.querySelector("#boton-agregar");
let inputAgregar = document.querySelector("input");
let botonBorrar = document.querySelector("#boton-borrar");
let spanKeys = document.querySelector("span");
let checkActivar = document.querySelector("#checkActivar");

inputAgregar.addEventListener("keyup", ()=>{
    spanKeys.innerHTML = inputAgregar.value.length
});

botonAgregar.addEventListener("click", ()=>{

    if (checkActivar.checked && inputAgregar.value!="") {
        
        let nodoLI = document.createElement("li");
        nodoLI.classList.add("list-group-item");
        nodoLI.innerText = inputAgregar.value;
        lista.append(nodoLI);
    } else {
        
        alert("No esta activado");
    }
});

checkActivar.addEventListener("click", (element)=>{
    
});

botonBorrar.addEventListener("click", ()=>{
    
});