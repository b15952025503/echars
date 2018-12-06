<!DOCTYPE html>
<html>
<head lang="en">
    <title>Demo Page PDF</title>
</head>
<body>
<h2>Demo Page ${title}</h2>
<div><a href="/pdf/preview" target="_blank"> 强大的预览 </a></div>
<div><a href="/pdf/download"> 强大的下载 </a></div>
<#if map?exists>
    <#list map as m>
        <div>${m.age}</div>
    </#list>
</#if>



</body>
</html>
