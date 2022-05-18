<#ftl encoding='UTF-8'>

<#import "common.ftl" as navigationBar>
<#import "signInTemplate.ftl" as login>
<#import "navigation.ftl" as navigation>

<@navigationBar.navigation pageName="Вход">
    <@navigation.unloggedUser/>
    <#if confirmResult?has_content>
        <#if confirmResult = true>
            <div style="text-align: center; color: black; padding-top: 20px">Аккаунт успешно активирован.</div>
        <#else>
            <div style="text-align: center; color: black; padding-top: 20px">Аккаунт не существует или уже
                активирован.
            </div>
        </#if>
    </#if>
    <#if error??>
        <div style="text-align: center; color: black; padding-top: 20px">
            Проблемы с аутентификацией.
        </div>
    </#if>
    <#if logout??>
        <div style="text-align: center; color: black; padding-top: 20px">
            Вы вышли из аккаунта.
        </div>
    </#if>
    <#if registered??>
        <div style="text-align: center; color: black; padding-top: 20px">
            Аккаунт успешно зарегистрирован. На почту отправлено письмо с подтверждением.
        </div>
    </#if>
    <#if exists??>
        <div style="text-align: center; color: black; padding-top: 20px">
            Аккаунт с такой почтой уже существует.
        </div>
    </#if>
    <@login.loginTemplate servletName="signIn"/>
</@navigationBar.navigation>
