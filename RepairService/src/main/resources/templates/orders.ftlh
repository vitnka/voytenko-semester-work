<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Order List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<h3>Order List</h3>
<a href="addOrder">Add Order</a>
<br><br>
<div>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Category</th>
            <th>Reason</th>
            <th>Comment</th>
        </tr>
        <#list orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.category}</td>
                <td>${order.reason}</td>
                <td>${order.comment}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>