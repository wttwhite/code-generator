<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<ul>
    <#list menuItems as item>
        <li>
            <a href="${item.url}">${item.label}</a>
        </li>
    </#list>
</ul>
<#-- 注释部分不会被输出 -->
<footer>
    ${currentYear} All right
</footer>

</body>
</html>