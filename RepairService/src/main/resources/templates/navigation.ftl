<#macro loggedUser>
    <header class="header">
        <div class="wrapper">
            <a href="/home"><h1>FixService24</h1></a>
            <div class="nav-bar">
                <a class="nav-link" href="/home">Оставить заявку</a>
                <a class="nav-link" href="/order">Мои заказы</a>
                <a class="nav-link" href="/reviews">Отзывы</a>
                <a class="nav-link" href="/profile">Профиль</a>
                <a class="nav-link" href="/logout">Выйти</a>
            </div>
        </div>
    </header>
</#macro>
<#macro unloggedUser>
    <header class="header">
        <div class="wrapper">
            <a href="/home"><h1>FixService24</h1></a>
            <div class="nav-bar">
                <a class="nav-link" href="/signIn">Войти</a>
                <a class="nav-link" href="/signUp">Регистрация</a>
            </div>
        </div>
    </header>
</#macro>

<#macro admin>
    <header class="header">
        <div class="wrapper">
            <div class="nav-bar">
                <a href="/admin">Управление ролью</a>
                <a href="/logout">Выйти</a>
            </div>
        </div>
    </header>
</#macro>

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

