<#import "parts/common.ftlh" as c>
<#macro cartList>

<@c.page>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Наименование</th>
            <th scope="col">Стоимость</th>
            <th scope="col">Количество</th>
        </tr>
        </thead>

        <tbody>
        <#list salePosition as s>
            <tr>
                <td scope="row">${s.getProduct().getName()}</td>
                <td scope="row">${s.getProduct().getCost()}</td>
                <td scope="row">${s.getCount()}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>

</#macro>