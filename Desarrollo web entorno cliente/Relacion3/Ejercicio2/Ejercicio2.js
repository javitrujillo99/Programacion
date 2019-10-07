var factura = {
    nombreEmpresa: 'Empresa',
    direccion: 'Calle Lima 8',
    telefono: 33344455,
    nif: '509428374R',
    formaPago: 'PayPal',
    importeTotalFactura: function() {
        return producto.cantidad * producto.precio;
    },
    mostrarFactura: function() {
        return alert("La cantidad a pagar es " + factura.importeTotalFactura());
    }
    
};

var cliente = {
    numero: 555666333,
    dni: '55566677E',
    nombre: 'Ruben',
    domicilio: 'Calle Mostoles 5',
    cp: 15900,
    ciudad: 'Mostoles',
    provincia: 'Madrid'
};

var producto = {
    descripcion: 'Muy chachi',
    precio: 5,
    cantidad: 3
};
factura.mostrarFactura();