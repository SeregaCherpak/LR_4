let Car = {
    mark: "",
    model: "",
    price: "",
    year: "",
    engine_capacity: ""
}
function getData(){
    Car.mark = document.getElementById("mark").value;
    Car.model = document.getElementById("model").value;
    Car.price = document.getElementById("price").value;
    Car.year = document.getElementById("year").value;
    Car.engine_capacity = document.getElementById("engine_capacity").value;
    let carJson = JSON.stringify(Car);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "main",true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(carJson);
}