// funciones de boton agregar

function agregar(string, index) {
    //  console.log(event)
    let nextIndex = index + 1;
    let row = document.getElementById(string + nextIndex);
    if (row != null) {
        row.classList.remove("no-mostrar");
    }
    console.log("holis entre a agregar");
}

function eliminar(string, index) {
    let row = document.getElementById(string + index);
    if (string == "ingrediente") {
        if (index != 0) {
            let nombre = document.getElementById('nombreIngrediente' + index);
            let cantidad = document.getElementById('cantidad' + index);
            nombre.value = null;
            cantidad.value = '';
        }
    }
    if (row != null) {
        row.classList.add("no-mostrar")
    }
    ;
    console.log("holis entre a eliminar");
}

