<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Блокировка аккаунта">
    <@navigation.admin/>
    <script>
        function getAccounts() {
            let request = new XMLHttpRequest();

            request.open('GET', '/banned', false);

            request.send();

            if (request.status !== 200) {
                alert('Ошибка!');
            } else {
                let html = '';

                let response = JSON.parse(request.response);

                for (let i = 0; i < response.length; i++) {
                    html += '<tr>';
                    html += '<td>' + response[i]['id'] + '</td>';
                    html += '<td>' + response[i]['email'] + '</td>';
                    html += '<td>' + response[i]['state'] + '</td>';
                    html += '<td>'+ '<td> <input type="submit" class="btn btn-secondary" value="забанить" onclick="addBan(' + response[i]['id'] + ')"> </td>';
                    html += '<td>'+ '<td> <input type="submit" class="btn btn-secondary" value="снять бан" onclick="removeBan(' + response[i]['id'] + ')"> </td>';
                    html += '</tr>';
                }

                document.getElementById('account_table').innerHTML = html;
            }
        }

        function addBan(id) {

            let request = new XMLHttpRequest();

            let body = {
                "id": id
            };

            request.open('POST', '/banned', false);

            request.setRequestHeader('Content-Type', 'application/json');

            request.send(JSON.stringify(body));

            getAccounts();

        }

        function removeBan(id) {

            let request = new XMLHttpRequest();

            let body = {
                "id": id
            };

            request.open('POST', '/banned/remove', false);

            request.setRequestHeader('Content-Type', 'application/json');

            request.send(JSON.stringify(body));

            getAccounts();

        }


        window.onload = getAccounts;
    </script>
    <div class="mx-auto" style="width: 90%; margin-top: 20px;">

        <table class="table  table-dark">
            <thead>

            <tr>
                <th scope="col">Айди</th>
                <th scope="col">Почта</th>
                <th scope="col">Статус</th>
            </tr>
            </thead>
            <tbody id="account_table">
            </tbody>
        </table>
    </div>
</@navigationBar.navigation>