<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Профиль">
    <@navigation.loggedUser/>
        <div class="content">
            <div class="info">
                <p>${user.email}</p>
                <p>${user.firstName}</p>
                <p>${user.lastName}</p>
            </div>

             <#if user.profileImg?has_content>
                                <img src="${user.profileImg}" alt="Avatar" style="width:200px">
                            <#else>
                                <img src="https://okeygeek.ru/wp-content/uploads/2020/03/no_avatar.png" style="width:200px"
                                     alt="avatar">
             </#if>
            <div class="d-flex text">
                <div class="upload">
                    <form action="/upload" method="post" enctype="multipart/form-data">
                        <input type="file" name="file">
                        <button type="submit" class="btn btn-primary">Сменить фото</button>
                    </form>
                </div>
            </div>
        </div>
    <style>

        body, h1{
            margin: 0;
            padding: 0;
        }

        .content{
            margin: 30px auto;
            max-width: 1300px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: flex-start;
        }

        .info{
            border: 1px solid #333333;
            border-radius: 5px;
            display: flex;
            flex-direction: column;
            width: 500px;
            padding: 20px;
        }

        .info p{
            margin-bottom: 5px;
        }

        img {
            border-radius: 50%;
        }


    </style>
</@navigationBar.navigation>