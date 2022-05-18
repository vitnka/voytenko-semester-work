<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Главная страница">
<#if id?has_content>
    <@navigation.loggedUser/>
<#else>
    <@navigation.unloggedUser/>
</#if>
    <div class="first">
        <img src="images/img.png" alt="здесь будет фото">
    </div>

    <div class="repair">
        <h1>Оставьте заявку на ремонт</h1>

        <form name="order" action="/order/add" method="POST">
            <input type="text" name="item" placeholder="Название техники"/>
            <input type="text" name="reason" placeholder="Причина поломки"/>
            <input type="text" name="comment" placeholder="Домолнительный комментарий"/>
            <input type="submit" value="Создать"/>
        </form>
    </div>

    <style>
        .first {
            max-width: 100vw;
            background-color: #FAFAFA;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }

        .first img {
            width: 300px;
            height: 300px;
        }

        .repair {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: flex-start;
            max-width: 1000px;
            margin: 40px auto;
        }

        .repair h1 {
            font-size: 40px;
            margin: 0;
        }

        .repair form {
            display: flex;
            flex-direction: column;
        }

        .repair form input[type=submit],
        .repair form input[type=text] {
            width: 300px;
            height: 30px;
            margin-bottom: 10px;
            padding: 0;
        }
    </style>

</@navigationBar.navigation>

