let xhr = new XMLHttpRequest();
let jsonStr;
let jsonObj;
xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
        jsonStr = xhr.responseText;
        jsonObj = JSON.parse(jsonStr);
        let table_body = document.getElementById("table_body")
        for (let element of jsonObj) {
            let str = "";
            table_body.innerHTML += "<tr>";
            for (value of Object.values(element)) {
                str += "<td>" + value + "</td>";
            }
            str+="<td><button type='button' id='delBtn" + n + "' name='delBtn' class='delBtn btn btn-danger rounded'>Удалить</button></td>";
                str+="<td><button type='button' id='editBtn" + n + "' name='editBtn' class='editBtn btn btn-primary rounded'>Редактировать</button></td>";
                table_body.innerHTML += str;
                table_body.innerHTML += "</tr>";
                n++;
            }
            let delButtons = document.getElementsByName("delBtn");
            for (let button of delButtons) {
                let id = button.parentElement.previousSibling.innerText;
                button.onclick = function() {
                    let xhr1 = new XMLHttpRequest();
                    xhr1.open("POST", "delete", true);
                    xhr1.send(id);
                    setTimeout(location.reload(), 1000);
                }
                let editButtons = document.getElementsByName("editBtn");
                for (let button of editButtons) {
                    button.onclick = function() {
                        let id = button.parentElement.previousSibling.previousSibling.innerText;
                        setTimeout(location.href = "edit?id=" + id, 1000);
                    }
                }
            }
        }
    }
}
xhr.open("POST", "list", true);
xhr.getResponseHeader("Content-type", "application/json");
xhr.send("1");
