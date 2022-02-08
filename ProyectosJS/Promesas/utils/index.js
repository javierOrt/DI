// Es una ejecucion larga sobre la cual quiero que cuando termine se ejecuta 
// si lo ha hecho bien una cosa y si lo ha hecho mal otra

/*
setInterval(() => {
    console.log("ejecucion");
}, 500);
*/

// Promise
let promesa = new Promise((res,rej)=>{
    setTimeout(() => {
        
        //Lógica promesa
        //La accion que tarda mucho
        let numero = Math.random()*20;
    
        if (numero > 5) {
            res('bien resuelto');
        } else {
            rej('mal resuelto');
        }

    }, 3000);
});

// cuando ejecuto el then ejecuto la logica
promesa.then(
    // repuesta correcta
    (data) => {console.log(data);},
    // respuesta incorrecta
    (data) => {
        console.log("No se ha podido hacer");
        console.log(data);
    }
);

let url = "https://randomuser.me/api/?results=50";
let listaM = document.querySelector('#lista-m');
let listaF = document.querySelector('#lista-f');

fetch(url).then(
    
    (data) => {
        //console.log(data);
        let json = data.json();
        return json;
    },
    (err) => {}
    
    ).then(
        
    (data) => {
        
        let listaPersonas = data.results;

        listaPersonas.forEach(element => {
            let nodoLI = document.createElement("li");
            nodoLI.classList.add("list-group-item");
            nodoLI.innerText = element.name.first;
            
            if (element.gender == "male") {
                listaM.append(nodoLI);
            } else {
                listaF.append(nodoLI);
            }
        });
    },
    (err) => {}
    )