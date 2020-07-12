<#import "parts/common.ftlh" as c>

<@c.page>

    <h3>Почасовая история</h3>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Дата скидки</th>
            <th scope="col">Наименование продукта</th>
            <th scope="col">Скидка</th>
        </tr>
        </thead>

        <tbody>

        <#list history as h>
            <tr>
                <td scope="row">${h.getDate()}</td>
                <td scope="row">${h.getName()}</td>
                <td scope="row">${h.getDiscount()}</td>
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>