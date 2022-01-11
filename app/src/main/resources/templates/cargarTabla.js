var tabla = [
    { nombre: "Juan" },
    { nombre: "Pedro" },
    { nombre: "Raul" },
    { nombre: "Simon" },
    { nombre: "Franco" },
    { nombre: "German" },
    { nombre: "Lautaro" },
    { nombre: "Emi" },
    { nombre: "Maxi" },
    { nombre: "Lucas" }
];
var j, x, i;
var pval;
window.onload = cargarEventos;
function cargarEventos() {
    document.getElementById("mostrar-tabla").addEventListener("click", mostrarTabla, false);
    document.getElementById("cambio-nombres").addEventListener("click", cambiarNombres, false);
}
function mostrarTabla() {
    var cuerpoTabla = document.getElementById("equipos-tabla");
    var tablaLlena = "";
    for (var i = 0; i < tabla.length; i++) {
        tablaLlena += "<tr><td>" + tabla[i].nombre;
    }
    cuerpoTabla.innerHTML = tablaLlena;
}

function cambiarNombres(tablaLlena) {
    for (i = tabla.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        x = tabla[i].nombre;
        tabla[i].nombre = tabla[j].nombre;
        tabla[j].nombre = x;

    }
    pval = "";
    for (i = 0, j = tabla.length - 1; i < tabla.length / 2; i++, j--) {
        pval += "<tr>";
        pval += "<td>" + tabla[i].nombre + "</td>"
        pval += "<td>" + tabla[j].nombre + "</td>"
        pval += "</tr>"
    }
    document.getElementById('pText').innerHTML = pval;

}