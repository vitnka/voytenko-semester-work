<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Заказ">
    <@navigation.loggedUser/>

    <div class="content">
        <div class="top">
            <h1>Заказ</h1>
        </div>

        <table id="search_by_item_name_table">
            <div class="orders">
                    <div class="order">

                        <p>${order.orderStatus}</p>
                        <p>${order.itemName}</p>
                        <p>${order.reason}</p>
                        <p>${order.comment}</p>

                    </div>
            </div>
        </table>

        <div class="right">
            <h1>Добавить отзыв</h1>
            <form action="/reviews/add/${order.id}" method="post">
                <input type="text" name="comment" placeholder="Комментарий"/>
                <input type="text" name="rating" placeholder="Оцените от 1 до 10"/>
                <button type="submit">Добавить</button>
            </form>
        </div>

    </div>


    <style>body, h1 {
            margin: 0;
            padding: 0;
        }

        .content {
            margin: 30px auto;
            max-width: 1300px;
        }

        .top {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }

        .top h1 {
            font-size: 40px;
        }

        .top input {
            width: 250px;
            border: 1px solid #333333;
            border-radius: 5px;
            height: 30px;
        }

        .orders {
            max-width: 700px;
            display: flex;
            flex-direction: column;
            margin-top: 20px;
        }

        .orders .order {
            border: 1px solid #333333;
            border-radius: 5px;
            margin-bottom: 10px;
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