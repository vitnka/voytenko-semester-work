<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Заказы">
    <@navigation.loggedUser/>
    <div class="content">
        <div class="left">
            <h1>Отзывы</h1>
            <#list reviews as review>
            <div class="review">
                <p>${review.comment}</p>
                <p>${review.date}</p>
                <p>${review.rating}</p>
                <#if review.user.id == userId >
                    <form action="/reviews/remove/${review.id}" method="post">
                        <p><input type="submit" value="Удалить отзыв"></p>
                    </form>
                </#if>
            </div>
            </#list>

            <form action="/reviews/completed" method="get" >
                <button type="submit" class="btn btn-primary">Показать отзывы на завершенные заказы</button>
            </form>
        </div>

    </div>

    <style>
        body, h1 {
            margin: 0;
            padding: 0;
        }

        .content {
            margin: 30px auto;
            max-width: 1300px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: flex-start;
        }

        .left {
            display: flex;
            flex-direction: column;
            max-width: 700px;
        }

        .left h1 {
            margin-bottom: 20px;
        }

        .left .review {
            margin-bottom: 10px;
            border: 1px solid #333333;
            border-radius: 5px;
            width: 700px;
            padding: 20px;
        }

        .right {
            display: flex;
            flex-direction: column;
        }

        .right h1 {
            margin-bottom: 20px;
        }

        .right form {
            display: flex;
            flex-direction: column;
        }

        .right form input {
            width: 250px;
            height: 30px;
            border-radius: 5px;
            margin-bottom: 10px;
        }
    </style>
</@navigationBar.navigation>