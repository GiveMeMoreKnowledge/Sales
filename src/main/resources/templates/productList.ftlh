<#import "parts/common.ftlh" as c>

<@c.page>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Главная</a></li>
            <li class="breadcrumb-item active" aria-current="page">Добавление товара</li>
        </ol>
    </nav>

    <h3>Добавление товара</h3>

    <div class="product_container">

        <form action="/product" method="post">

            <div class="row">
                <div class="col">
                    <input type="text" class="form-control" name="name" placeholder="Название товара">
                </div>

                <div class="col">
                    <input type="number" class="form-control" min="1" name="cost" placeholder="Стоимость товара">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" class="btn btn-outline-success">Добавить товар</button>

                </div>
            </div>

        </form>

    </div>

    <div class="info">


        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Наименование</th>
                <th scope="col">Стоимость</th>
            </tr>
            </thead>

            <tbody>
            <#list products as product>
                <tr>
                    <td scope="row">${product.name}</td>
                    <td scope="row">${product.cost}</td>
                    <td scope="row">
                        <a href="product/${product.id}">Редактировать</a>
                    </td>
                    <td scope="row">
                        <a href="/delete/${product.id}">Удалить</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>

</@c.page>