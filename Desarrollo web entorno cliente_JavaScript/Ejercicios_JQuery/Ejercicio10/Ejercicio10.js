Math.mcd = function mcd(x, y) {
    var resto = 0;
    while (x % y != 0) {
        resto = x % y;
        x = y;
        y = resto;
    }
    return y;
}
Math.mcm = function (a, b) {
    return a * b / Math.mcd(a, b);
};
var a = prompt("Escribe un número");
var b = prompt("Escribe otro número");
document.write("MCD(" + a + ", " + b + ") = " + Math.mcd(a, b));
document.write("<br>MCM(" + a + ", " + b + ") = " + Math.mcm(a, b));
