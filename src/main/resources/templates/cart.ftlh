<#import "parts/common.ftlh" as c>

<@c.page>

    Добавление продуктов в корзину

    <div class="sales_container">

        <form action="/cart" method="post">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Продукты</label>
                <select class="form-control" id="exampleFormControlSelect1" name="product">
                    <#list products as product>
                        <option>${product.id}</option>
                    </#list>
                </select>
            </div>

            <#--            <select name="product">-->
            <#--                <#list products as product>-->
            <#--                    <option>${product.id}</option>-->
            <#--                </#list>-->
            <#--            </select>-->

            <input type="number" min="1" name="count" placeholder="Количество" class="form-control"
                   aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"/>

            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-outline-primary">Добавить товар</button>
        </form>

    </div>

    <form action="/sale" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-outline-success">Добавить продажу</button>
    </form>

</@c.page>