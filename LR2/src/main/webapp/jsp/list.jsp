<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>list</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
          crossorigin="anonymous">
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
          crossorigin="anonymous"></script>
  <script src="listJS.js"></script>
</head>
<style>
  body {
    background-color: LightYellow
  }
</style>
<body>
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button"
              data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
              aria-controls="navbarCollapse" aria-expanded="false"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item p-2">
            <form class="form-inline" aria-current="page" action="main">
              <button class="btn btn-outline-light my-2 my-sm-0" style='color:YellowGreen;' type="submit">Добавление записи</button>
            </form>
          </li>
          <li class="nav-item p-2">
            <form class="form-inline" aria-current="page" action="list">
              <button class="btn btn-outline-light my-2 my-sm-0" style='color:YellowGreen;' type="submit">Просмотр списка</button>
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<table class="table w-50 shadow rounded text-center position-absolute top-50 start-50 translate-middle">
  <thead class="bg-success">
  <tr style='background-color:YellowGreen;'>
    <th scope="col">Марка</th>
    <th scope="col">Модель</th>
    <th scope="col">Цена</th>
    <th scope="col">Год</th>
    <th scope="col">Объем двигателя</th>
  </tr>
  </thead>
  <tbody id="table_body"></tbody>
</table>
</body>
</html>