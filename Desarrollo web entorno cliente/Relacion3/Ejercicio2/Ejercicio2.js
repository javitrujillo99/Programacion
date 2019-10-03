var factura = {
    nombreEmpresa = '',
    direccion = '',
    telefono = '',
    nif = '',
    importeFactura = '',
    formaPago = '',
    importeTotalFactura = function() {
        return producto.cantidad * producto.precio;
    },
    importeFactura = importeTotalFactura(),
    mostrarFactura = function() {
        return alert(importeTotalFactura);
    }
    
};

var cliente = {
    numero = '',
    dni = '',
    nombre = '',
    domicilio = '',
    cp = '',
    ciudad = '',
    provincia = ''
};

var producto = {
    descripcion = '',
    precio = '',
    cantidad = ''
};