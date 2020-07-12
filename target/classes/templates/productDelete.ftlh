<#import "parts/common.ftlh" as c>

<@c.page>

    Удаление позиции

    <form action="/prodDelete" method="post">

        <input type="text" name="name" value="${product.name}" readonly>
        <input type="number" name="cost" value="${product.cost}" readonly>
        <input type="text" value="${product.id}" name="productId" readonly>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Удалить</button>

    </form>

</@c.page>