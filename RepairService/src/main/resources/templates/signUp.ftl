<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "signUpTemplate.ftl" as registration>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Регистрация">
    <@navigation.unloggedUser/>

    <@registration.registrationTemplate/>
</@navigationBar.navigation>

