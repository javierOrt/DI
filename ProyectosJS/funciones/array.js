let numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let mixto = ["hola",2,false,"adios"];
let alumnos = ["javi","perro","jeje"];

alumnos.forEach((element , index, array) => {
    console.log(element);
});

//Crear funcion que introduciendo un nombre lo busque en un array y una vez ejecutada salga
//Un mensaje en caso negativo o positivo

let existe = false;

function comprobarNombre(nombre){
    alumnos.forEach(element => {
        if (element == nombre) {
            existe = true;
        }
    });

    if(existe) {
        alert("alumno encontrado");
    } else {
        alert("alumno no existe");
    }
}

comprobarNombre("perro");