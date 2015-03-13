function addMilk() {
         
    var c = document.getElementById("cowId");
    var mp = document.getElementById("time");
    var t = document.getElementById("amountProduced");
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    row.insertCell(0).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
    row.insertCell(1).innerHTML= c.value;
    row.insertCell(2).innerHTML= t.value;
    row.insertCell(2).innerHTML= mp.value;

}

function addMeal() {

    var c = document.getElementById("cow");
    var f = document.getElementById("feed");
    var a = document.getElementById("amount");
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    row.insertCell(0).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
    row.insertCell(1).innerHTML= c.value;
    row.insertCell(2).innerHTML= a.value;
    row.insertCell(2).innerHTML= f.value;

}

function addBreed() {

    var c = document.getElementById("cow");
    var mp = document.getElementById("time");
    var t = document.getElementById("milkproduced");
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    row.insertCell(0).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
    row.insertCell(1).innerHTML= c.value;
    row.insertCell(2).innerHTML= t.value;
    row.insertCell(2).innerHTML= mp.value;

}

function jsonObject() {
    var object = [];

}

function deleteRow(obj) {
     
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("myTableData");
    table.deleteRow(index);
   
}


function load() {
   
    console.log("Page load finished");

}