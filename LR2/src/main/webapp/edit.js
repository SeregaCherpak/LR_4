let Car = {
    mark: "",
    model: "",
    price: "",
    year: "",
    engine_capacity: 0,
    idInDatabase: 0
}
function sendEditedSeries(){
    let xhrEdit = new XMLHttpRequest();
    Car.title=document.getElementById("mark").value;
    Car.genre=document.getElementById("model").value;
    Car.author=document.getElementById("price").value;
    Car.studio=document.getElementById("year").value;
    Car.amount=document.getElementById("engine_capacity").value;
    Car.idInDatabase=location.search.split("=")[1];
    let carJson = JSON.stringify(Series);
    console.log(Car);
    xhrEdit.open("POST", "sv", true);
    xhrEdit.setRequestHeader('Content-Type', 'application/json');
    xhrEdit.send(carJson);
    location.href="read"
}
