var array = [6, "pepe", 2, "juan"];
if (array[1] > array[3]) {
    document.write("La palabra " + array[1] + " es mayor");
}
else if(array[3] > array[1]) {
    document.write("La palabra " + array[3] + " es mayor");
}
document.write("<br>" + array[0] + " + " + array[2] + " = " + (array[0] + array[2]));
document.write("<br>" + array[0] + " - " + array[2] + " = " + (array[0] - array[2]));
document.write("<br>" + array[0] + " · " + array[2] + " = " + (array[0] * array[2]));
document.write("<br>" + array[0] + " : " + array[2] + " = " + (array[0] / array[2]));

