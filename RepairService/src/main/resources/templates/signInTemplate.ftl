<#macro loginTemplate servletName>
<div class="form-style-2" xmlns="http://www.w3.org/1999/html">
    <div class="form-style-2-heading">
        Вход
    </div>

    <form action="/signIn" method="post">
        <div class="input-field">
            <input type="email" name="email" placeholder="Почта">
        </div>

        <div class="input-field">
            <input type="password" name="password" placeholder="Пароль">
        </div>

        <div class="signup_link">Запомнить меня?
            <input type="checkbox" name="rememberMe">
        </div>

        <input type="submit" value="Войти"/>
    </form>
</div>
    <style>
        body {
            margin: 0 auto;
        }

        .form-style-2 {
            max-width: 500px;
            padding: 20px 12px 10px 20px;
            font: 13px Arial, Helvetica, sans-serif;
        }

        .form-style-2-heading {
            font-weight: bold;
            font-style: italic;
            border-bottom: 2px solid #ddd;
            margin-bottom: 20px;
            font-size: 15px;
            padding-bottom: 3px;
        }

        .form-style-2 span.required {
            color: red;
        }

        .form-style-2 .input-field input {
            width: 48%;
        }

        .form-style-2 .input-field input {
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            border: 1px solid #C2C2C2;
            box-shadow: 1px 1px 4px #EBEBEB;
            -moz-box-shadow: 1px 1px 4px #EBEBEB;
            -webkit-box-shadow: 1px 1px 4px #EBEBEB;
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            padding: 7px;
            outline: none;
        }

        .form-style-2 input[type=submit] {
            border: none;
            padding: 8px 15px 8px 15px;
            background: #333333;
            color: #fff;
            box-shadow: 1px 1px 4px #DADADA;
            -moz-box-shadow: 1px 1px 4px #DADADA;
            -webkit-box-shadow: 1px 1px 4px #DADADA;
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
        }

        .form-style-2 input[type=submit]:hover {
            margin-top: 10px;
            background: #EA7B00;
            color: #fff;
        }

    </style>

</#macro>