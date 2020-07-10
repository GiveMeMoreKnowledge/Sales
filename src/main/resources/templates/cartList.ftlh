<#import "parts/common.ftlh" as c>

<@c.page>

    Корзина

    <table>
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Стоимость</th>
            <th>Количество</th>
        </tr>
        </thead>

        <tbody>
        <#list salePosition as s>
            <tr>
                <td>${s.getProduct().getName()}</td>
                <td>${s.getProduct().getCost()}</td>
                <td>${s.getCount()}</td>
            </tr>
        </#list>
        </tbody>
    </table>


</@c.page>