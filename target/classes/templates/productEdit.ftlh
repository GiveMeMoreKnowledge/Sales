<#import "parts/common.ftlh" as c>

<@c.page>

    Редактирование

    <form action="/prodEdit" method="post">

        <input type="text" name="name" value="${product.name}">
        <input type="number" name="cost" value="${product.cost}">
        <input type="text" value="${product.id}" name="productId" readonly>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>

    </form>

</@c.page>