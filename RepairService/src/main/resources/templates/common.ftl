<!doctype html>
<#macro navigation pageName>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#import "/spring.ftl" as spring/>
    <title>${pageName}</title>
    <style>
        a {
            text-decoration: none;
            color: black;
        }

        body{
            margin: 0;
            padding: 0;
        }

        header {
            margin: 0 auto;
            padding: 0;
        }

        header .wrapper {
            background-color: #333333;
            padding: 20px 30px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            font-size: 20px;
            color: white;
        }

        header .nav-bar {
            display: flex;
            flex-direction: row;
            align-items: center;
            width: 300px;
            justify-content: space-around;
        }

        header .nav-bar a {
            color: white;
            font-size: 20px;
        }
    </style>
</head>
<body>

    <#nested>

    </body>
    </html>
</#macro>

