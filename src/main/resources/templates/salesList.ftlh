<#import "parts/common.ftlh" as c>

<@c.page>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Главная</a></li>
            <li class="breadcrumb-item"><a href="/cart">Корзина</a></li>
            <li class="breadcrumb-item"><a href="/history">История скидок</a></li>
            <li class="breadcrumb-item"><a href="/statistic">Статистика</a></li>
            <li class="breadcrumb-item active" aria-current="page">Инфо о продажах</li>
        </ol>
    </nav>

    <h3>Продажи</h3>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Наименование продукта</th>
            <th scope="col">Цена/шт</th>
            <th scope="col">Количество</th>
            <th scope="col">Цена со скидкой</th>
            <th scope="col">Сумма чека</th>
        </tr>

        </thead>

        <tbody>

        <#list sales as s>
            <#list s.getSalePositions() as p>
                <tr>
                    <td scope="row">${p.getProduct().getName()}</td>
                    <td scope="row">${p.getProduct().getCost()}</td>
                    <td scope="row">${p.getCount()}</td>
                    <td scope="row">${p.getDiscountCost()}</td>
            </#list>
<#--                <td scope="row">${s.getTotalCostSale()}</td>-->
            </tr>
            <tr>
                <td scope="row"><b>Дата продажи:</b> ${s.getDate()}</td>
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>