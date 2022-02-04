let usuarios = [
    {
        nombre: "Javi", 
        genero: "M", 
        apellido: "Ortiz", 
        edad: 23,
        conocimientos: [
            {area: "Informatica", tema:"Programacion"},
            {area: "Informatica", tema: "sistemas"}
        ]
    },
    {
        nombre: "Jota", 
        genero: "M", 
        apellido: "Perro", 
        edad: 22,
        conocimientos: [
            {area: "Informatica", tema:"nominas"},
            {area: "Informatica", tema: "sistemas"}
        ]
    },
    {
        nombre: "David", 
        genero: "M", 
        apellido: "Puta", 
        edad: 21,
        conocimientos: [
            {area: "profesion", tema:"Perrear"},
            {area: "Gamer", tema: "Genshin"}
        ]
    },
    {
        nombre: "Alba", 
        genero: "F", 
        apellido: "Moreno", 
        edad: 22,
        conocimientos: [
            {area: "HOT", tema:"Girl"},
            {area: "Queen", tema: "Galapagar"}
        ]
    }
];

usuarios.forEach(element => {
   console.log(element.nombre); 
});

usuarios.forEach(element => {
    element.conocimientos.forEach((data) => {
        let contador=0;
        if (data.area.toLowerCase()=="informatica") {
            contador++;
        }
        if (contador>0) {
            console.log(element.nombre);
        }
    });
});

//Genera un array solo con los usuarios de genero masculino

let masculinos = [];
/*
usuarios.forEach(element => {
    if (element.genero.toLowerCase()=="m") {
        masculinos.push(element);
    }
});
*/
masculinos = usuarios.filter(element=>element.genero.toLowerCase()=="m");
console.log(masculinos);

let persona = new persona("Javi","Ortiz",20,[]);

persona.mostrarDatos();