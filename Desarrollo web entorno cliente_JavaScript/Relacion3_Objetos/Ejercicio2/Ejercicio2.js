class Empresa {
    constructor(nif, nombre, direccion, telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
class Cliente {
    constructor(dni, numero, nombre, domicilio, cp, ciudad, provincia) {
        this.dni = dni;
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cp = cp;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
}
class Producto {
    constructor(descripcion, precio, cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    precioFinal() {
        return this.precio * this.cantidad;
    }
}
class Factura {
    constructor(Empresa, Cliente, importe, formaPago) {
        this.Empresa = empresa;
        this.Cliente = cliente;
        this.importe = importe;
        this.formaPago = formaPago;
    }
}

function imprimir() {
    document.write("<h2>Empresa</h2>Nombre de la empresa: "
    + empresa.nombre + "<br>Nif de la empresa: " + empresa.nif +
    "<br>Dirección: " + empresa.direccion + "<br>Telefono de la empresa: "
    + empresa.telefono);
    document.write("<h2>Cliente</h2>DNI: " + cliente.dni + "<br>Nombre: " + cliente.nombre + 
    "<br>Numero: " + cliente.numero + "<br>Domicilio: " + cliente.domicilio + 
    "<br>Codigo Postal: " + cliente.cp + "<br>Ciudad: " + cliente.ciudad + 
    "<br>Provincia: " + cliente.provincia);
}
function totalFactura(arrayProductos) {
    var aux = 0;
        for (i = 0; i < arrayProductos.length; i++) {
            aux += arrayProductos[i].precioFinal();
        }
        document.write(aux);
}