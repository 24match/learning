<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
        "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>
    <!-- 指定由spring负责action对象的创建 -->
    <constant name="struts.objectFactory" value="spring"/>
    <!-- 所有匹配*.action的请求都由struts2处理 -->
    <constant name="struts.action.extension" value="action"/>
    <!-- 是否启用开发模式(开发时设置为true,发布到生产环境后设置为false) -->
    <constant name="struts.devMode" value="true"/>
    <!-- struts配置文件改动后，是否重新加载(开发时设置为true,发布到生产环境后设置为false) -->
    <constant name="struts.configuration.xml.reload" value="true"/>
    <!-- 设置浏览器是否缓存静态内容(开发时设置为false,发布到生产环境后设置为true) -->
    <constant name="struts.serve.static.browserCache" value="false"/>
    <!-- 请求参数的编码方式 -->
    <constant name="struts.i18n.encoding" value="UTF-8"/>
    <!-- 每次HTTP请求系统都重新加载资源文件，有助于开发(开发时设置为true,发布到生产环境后设置为false) -->
    <constant name="struts.i18n.reload" value="true"/>
    <!-- 文件上传最大值 -->
    <constant name="struts.multipart.maxSize" value="104857600"/>
    <!-- 让struts2支持动态方法调用,使用叹号访问方法 -->
    <constant name="struts.enable.DynamicMethodInvocation" value="true"/>
    <!-- Action名称中是否还是用斜线 -->
    <constant name="struts.enable.SlashesInActionNames" value="false"/>
    <!-- 允许标签中使用表达式语法 -->
    <constant name="struts.tag.altSyntax" value="true"/>
    <!-- 对于WebLogic,Orion,OC4J此属性应该设置成true -->
    <constant name="struts.dispatcher.parametersWorkaround" value="false"/>
    
    <!--???还没看懂-->
    <package name="basePackage" extends="struts-default"></package>
    
</struts>