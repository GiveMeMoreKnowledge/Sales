<#import "parts/common.ftlh" as c>

<@c.page>

    <h3>Статистика</h3>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Количество чеков</th>
            <th scope="col">Сумма всех чеков</th>
            <th scope="col">Средняя стоимость чека</th>
            <th scope="col">Сумма скидок</th>
            <th scope="col">Сумма всех чеков с учетом скидок</th>
            <th scope="col">Средняя стоимость чеков с учетом скидок</th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td scope="row">${count}</td>
            <td scope="row">${sum}</td>
            <td scope="row">${avg}</td>
            <td scope="row">${sumDiscount}</td>
            <td scope="row">${sumAllSalesDiscountCost}</td>
            <td scope="row">${avgAllSalesDiscountCost}</td>
        </tr>

        </tbody>
    </table>

</@c.page>