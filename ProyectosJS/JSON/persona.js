class persona{
    
    nombre;
    apellido;
    edad:
    conocimientos;

    constructor(nombre, apellido, edad, conocimientos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.conocimientos = conocimientos;
    }

    mostrarDatos(){
        console.log(`Nombre: ${nombre}\nApellido: ${apellido}\nEdad: ${edad}`);
    }

    get getEdad(){
        return this.edad;
    }

    set setEdad(edad){
        this.edad = edad;
    }
}