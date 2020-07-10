<#import "parts/common.ftlh" as c>

<@c.page>

    Список позиций

    <div class="product_container">

        <form action="/product" method="post">

            <input type="text" name="name" placeholder="Название товара">
            <input type="number" name="cost" placeholder="Стоимость товара">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit">Добавить товар</button>

        </form>

    </div>

    <div class="info">


        <table>
            <thead>
            <tr>
                <th>Наименование</th>
                <th>Стоимость</th>
            </tr>
            </thead>

            <tbody>
            <#list products as product>
                <tr>
                    <td>${product.name}</td>
                    <td>${product.cost}</td>
                    <td>
                        <a href="product/product/${product.id}">Редактировать</a>
                    </td>
                    <td>
                        <a href="product/product/delete/${product.id}">Удалить</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>

</@c.page>