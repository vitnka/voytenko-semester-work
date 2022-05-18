<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Заказы">
    <@navigation.loggedUser/>
    <div class="content">


        <script>
            function search_by_itemName(itemName) {

                let request = new XMLHttpRequest();

                request.open('GET', 'order/search/' + itemName, false);
                request.send();
                console.log(request.responseText);

                    let html = '<tr>' +
                        '<th>orderStatus</th>' +
                        '<th>itemName</th>' +
                        '<th>reason</th>' +
                        '<th>comment</th>' +
                        '</tr>';

                    let response = JSON.parse(request.response);


                    for (let i = 0; i < response.length; i++) {
                        html += '<tr>' +
                            '<th>' + response[i]['orderStatus'] + '</th>' +
                            '<th>' + response[i]['itemName'] + '</th>' +
                            '<th>' + response[i]['reason'] + '</th>' +
                            '<th>' + response[i]['comment'] + '</th>' +
                            '</tr>';
                    }

                    document.getElementById('search_by_item_name_table').innerHTML = html;
            }
        </script>

        <div class="top">
            <h1>Мои заказы</h1>

            <label for="itemName">
                <input type="search" id="itemName" name="itemName" placeholder="Найти"
                       onkeyup="search_by_itemName(this.value)">
                <input type="submit" class="searchButton" value="Найти">
            </label>

        </div>

        <table id="search_by_item_name_table">
            <div class="orders">
                <#list orders as order>
                    <div class="order">

                        <p>${order.orderStatus}</p>
                        <p><a href="order/${order.id}">${order.itemName}</p>

                        <form action="/order/cancel/${order.id}" method="post">
                            <p><input type="submit" value="Отменить"></p>
                        </form>
                    </div>
                </#list>
        </table>
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
    </style>
</@navigationBar.navigation>