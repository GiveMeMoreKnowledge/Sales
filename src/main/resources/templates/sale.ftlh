<#import "parts/common.ftlh" as c>

<@c.page>

    <h3>Добавление продажи</h3>

    <form action="/sale" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Добавить продажу</button>
    </form>

    Корзина

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Наименование</th>
            <th scope="col">Стоимость</th>
            <th scope="col">Количество</th>
        </tr>
        </thead>

        <tbody>
        <#list salesPosition as s>
            <tr>
                <td scope="row">${s.getProduct().getName()}</td>
                <td scope="row">${s.getProduct().getCost()}</td>
                <td scope="row">${s.getCount()}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>