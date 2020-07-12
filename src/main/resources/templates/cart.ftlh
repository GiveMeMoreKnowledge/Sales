<#import "parts/common.ftlh" as c>
<#import "cartList.ftlh" as l>

<@c.page>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Главная</a></li>
            <li class="breadcrumb-item"><a href="/sales">Инфо о продажах</a></li>
            <li class="breadcrumb-item"><a href="/history">История скидок</a></li>
            <li class="breadcrumb-item"><a href="/statistic">Статистика</a></li>
            <li class="breadcrumb-item active" aria-current="page">Корзина</li>
        </ol>
    </nav>

    <div class="row">
        <div class="col-sm">
            <h3>Добавление товаров в корзину</h3>
        </div>
    </div>

    <form action="/cart" method="post">

        <div class="form-row">
            <div class="form-group col-md-6">
                <select class="form-control" id="exampleFormControlSelect1" name="product">
                    <#list products as product>
                        <option value=${product.id}>${product.name}</option>
                    </#list>
                </select>
            </div>

            <div class="form-group col-md-6">
                <input type="number" min="1" name="count" placeholder="Количество" class="form-control"
                       aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit" class="btn btn-outline-primary">Добавить товар</button>
            </div>
        </div>

    </form>

    <div class="form-row">
        <div class="form-group col-md-6">
            <form action="/sale" method="post">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit" class="btn btn-outline-success">Добавить продажу</button>
            </form>
        </div>
    </div>

    <@l.cartList />

</@c.page>