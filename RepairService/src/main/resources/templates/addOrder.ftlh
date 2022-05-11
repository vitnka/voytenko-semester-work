<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Order</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<#if errorMessage??>
    <div style="color:red;font-style:italic;">
        ${errorMessage}
    </div>
</#if>

<div>
    <fieldset>
        <legend>Add Order</legend>
        <form name="order" action="" method="POST">

            Category: <@spring.formInput "order.category" "" "text"/>    <br/>
            Reason: <@spring.formInput "order.reason" "" "text"/>    <br/>
            Comment: <@spring.formInput "order.comment" "" "text"/>    <br/>
            <input type="submit" value="Create" />
        </form>
    </fieldset>
</div>


</body>

</html>