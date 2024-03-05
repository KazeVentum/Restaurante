

document.addEventListener("DOMContentLoaded", async ()=>{
    let res = await((await fetch("http://localhost:8080/api/plato")).json());
    let contenedorPaises = document.querySelector("#countries-response");    
    const searchInput = document.getElementById('search-input');

    function renderCountries(countries) {
        contenedorPaises.innerHTML = '';
        countries.forEach(e => {
            contenedorPaises.insertAdjacentHTML("beforeend", /*html*/ `
                <div class="paises-nombre">
                    <blockquote>
                        <div class="tarjeta">
                            <div class="titulo"><h3>${e.nombrePlato}</h3></div>
                            <div class="pie">
                                <p><strong>Id:</strong> ${e.id}</p>
                                <p><strong>Descripcion:</strong> ${e.descripcionPlato}</p>
                                <p><strong>Menu:</strong> ${e.menuPlato}</p>
                                <strong><p>precio: ${e.precioPlato}</p></strong>
                            </div>
                        </div>
                    </blockquote>
                </div>
            `);
        });
    }


    function filterCountries(searchTerm) {
        
        return res.filter(plato =>
            plato.id == searchTerm ||   
            plato.nombrePlato.toLowerCase().includes(searchTerm.toLowerCase()) ||
            plato.descripcionPlato.toLowerCase().includes(searchTerm.toLowerCase()) ||
            plato.menuPlato.toLowerCase().includes(searchTerm.toLowerCase())
            
        );
    }

    searchInput.addEventListener('input', () => {
        const searchTerm = searchInput.value.trim();
        const filteredCountries = filterCountries(searchTerm);
        renderCountries(filteredCountries);
    });

    // Render all countries initially
    renderCountries(res);
});


var formularioEnviar = document.getElementById("ingresarPlatoForm");

formularioEnviar.addEventListener('submit', function(e){
    e.preventDefault();
    console.log("Diste click");

    var datos = new FormData(formularioEnviar);
    console.log(datos);

    // Crear el objeto JSON con los datos del formulario
    var objetoJSON = {
        nombrePlato: datos.get('namePlato'),
        descripcionPlato: datos.get('descripPlato'),
        menuPlato: datos.get('menuPlato'),
        precioPlato: parseInt(datos.get('precioPlato')) // Convertir a entero
    };

    console.log(objetoJSON);

    // Enviar los datos al servidor usando Fetch
    fetch('http://localhost:8080/api/plato', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(objetoJSON)
    })
    .then(response => {
        if (response.ok) {
            console.log('Datos enviados correctamente');
            window.location.reload();
        } else {
            console.error('Error al enviar los datos');
        }
    })
    .catch(error => {
        console.error('Error en la solicitud:', error);
    });
});


var formularioEliminar = document.getElementById("Eliminar-plato"); 

formularioEliminar.addEventListener('submit', function(e){
    e.preventDefault();
    console.log("Diste click");

    var idPlato = document.getElementById("idEliminarPlato").value; // Obtener el valor del campo directamente

    // Enviar la solicitud DELETE al servidor
    fetch('http://localhost:8080/api/plato/' + idPlato, { 
        method: 'DELETE' 
    })
    .then(response => {
        if (response.ok) {
            console.log('Plato eliminado correctamente');
            window.location.reload();
        } else {
            console.error('Error al eliminar el plato');
        }
    })
    .catch(error => {
        console.error('Error en la solicitud:', error);
    });
});

var formularioEditar = document.getElementById("editarForm");

formularioEditar.addEventListener('submit', function(e){
    e.preventDefault();
    console.log("Diste click");

    var idPlato = document.getElementById("idEditarPlato").value;

    var datos = new FormData(formularioEditar);
    console.log(datos);

    var objetoJSON = {
        nombrePlato: datos.get('nameEditarPlato'),
        descripcionPlato: datos.get('descripcionPlato'),
        menuPlato: datos.get('menuPlato'),
        precioPlato: parseInt(datos.get('precioPlato')) 
    };

    console.log(objetoJSON);

    // Enviar la solicitud PUT al servidor
    fetch('http://localhost:8080/api/plato/' + idPlato, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(objetoJSON)
        })
        .then(response => {
            if (response.ok) {
                console.log('Plato actualizado correctamente');
                window.location.reload(); // limpiar formulario
            } else {
                console.error('Error al actualizar el plato');
            }
        })
        .catch(error => {
                    console.error('Error en la solicitud:', error);
                });
});

