function metodoPArametros(param1,param2,param2){
    console.log(param1);
    console.log(param2);
    console.log(param3);
    console.log(arguments);
}

let variableMetodo = function (param1, param2){
    console.log(param1);
    console.log(param2);
};

function metodoPorDefecto(param1, param2){
    param2 = param2 || "por defecto";
    console.log(param1);
    console.log(param2);
}

function metodoSuma(param1, param2){
    let suma = param1 + param2;
    return suma;
}

let funcionDeFlecha = (param1) => {
    console.log(param1);
};

function funcionCallBack(p1, p2, p3){
    p3(p1,p2);
}

funcionCallBack(5,9,(p1,p2)=>{
    console.log(p1+p2)
});

metodoPArametros("javi",3,false,7);
variableMetodo(1,"hola");
metodoPorDefecto("javi");
console.log(metodoSuma(5,5))