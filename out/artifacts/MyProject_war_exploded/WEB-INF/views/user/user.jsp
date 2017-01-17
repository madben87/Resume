<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="fonts"/>
<spring:url value="resources/css/materialize.css" var="materialize"/>
<spring:url value="resources/css/style.css" var="style"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/i18n/spring_messages.jsp"%>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <title>Parallax Template - Materialize</title>

    <!-- CSS  -->
    <link href="${fonts}" rel="stylesheet">
    <link href="${materialize}" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="${style}" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="#" class="brand-logo">USER</a>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<div id="index-banner" class="parallax-container">
    <div class="parallax"><img src="resources/images/background/background1.jpg"></div>
</div>

<div class="container">
    <div class="section">

        <!--   Icon Section   -->
        <div class="row">
            <div class="col s12 m6">
                <div class="icon-block">
                    <h2 class="center brown-text"><i class="material-icons">flash_on</i></h2>
                    <h5 class="center">${skills}</h5>

                    <p class="light">
                        <div id="r0">
                    <p>${skill_header}</p>
                    <a href="javascript:change_visibility ('r0', 'r1')">
                        ${skill_open}
                    </a>
                </div>
                <div id="r1" style="display:none">
                    <p>${skill_header}</p>
                    <p>

                        <a href="#modal1"><img src="resources/images/skills/Java_avatar.png" width="48" height="48"></a>
                        <a href="#modal2"><img src="resources/images/skills/JDBC.png" width="68" height="68"></a>
                        <a href="#modal3"><img src="resources/images/skills/spring-framework-project-logo.png" width="68" height="68"></a>
                        <a href="#modal4"><img src="resources/images/skills/maven-logo-black-on-white1.png" width="88" height="68"></a>
                        <a href="#modal5"><img src="resources/images/skills/mysql-icon.png" width="68" height="68"></a>
                        <a href="#modal6"><img src="resources/images/skills/Tomcat.svg.png" width="68" height="78"></a>
                        <a href="#modal7"><img src="resources/images/skills/glassfish.png" width="88" height="68"></a>
                        <a href="#modal8"><img src="resources/images/skills/Logo_JPA.png" width="68" height="68"></a>
                        <a href="#modal9"><img src="resources/images/skills/hibernate_logo_whitebkg_stacked_256px.png" width="68" height="68"></a>
                        <a href="#modal10"><img src="resources/images/skills/JSP.png" width="68" height="68"></a>
                        <a href="#modal11"><img src="resources/images/skills/js.png" width="128" height="78"></a>
                        <a href="#modal12"><img src="resources/images/skills/junit5-banner.png" width="185" height="58"></a>

                    </p>
                    <a onClick="change_visibility ('r1', 'r0')">
                        ${skill_close}
                    </a>
                </div></p>
            </div>
        </div>

        <div class="col s12 m6">
            <div class="icon-block">
                <h2 class="center brown-text"><i class="material-icons">settings</i></h2>
                <h5 class="center">${about}</h5>

                <p class="light"><div id="about0">
                <p>${about_me_header}</p>
                <a href="javascript:change_visibility ('about0', 'about1')">
                    ${skill_open}
                </a>
            </div>
            <div id="about1" style="display:none">
                <p>${about_me_header}</p>
                <p>
                    ${about_me}
                </p>
                <a onClick="change_visibility ('about1', 'about0')">
                    ${skill_close}
                </a>
            </div></p>
        </div>
    </div>
</div>
</div>
</div>


<div class="parallax-container valign-wrapper">
    <div class="parallax"><img src="resources/images/background/background2.jpg"></div>
</div>

<div class="container">
    <div class="section">

        <div class="row">
            <div class="col s12 center">
                <h3><i class="mdi-content-send brown-text"></i></h3>
                <h4>Contact Us</h4>
                <p class="left-align light">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam scelerisque id nunc nec volutpat. Etiam pellentesque tristique arcu, non consequat magna fermentum ac. Cras ut ultricies eros. Maecenas eros justo, ullamcorper a sapien id, viverra ultrices eros. Morbi sem neque, posuere et pretium eget, bibendum sollicitudin lacus. Aliquam eleifend sollicitudin diam, eu mattis nisl maximus sed. Nulla imperdiet semper molestie. Morbi massa odio, condimentum sed ipsum ac, gravida ultrices erat. Nullam eget dignissim mauris, non tristique erat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;</p>
            </div>
        </div>

    </div>
</div>

<div class="parallax-container valign-wrapper">
    <div class="parallax"><img src="resources/images/background/background3.jpg"></div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>

<div class="fixed-action-btn horizontal click-to-toggle">
    <a class="btn-floating btn-large lighten-1">
        <i class="material-icons">menu</i>
    </a>
    <ul>
        <li><a class="tooltipped dropdown-button btn-floating lighten-1" href="#localization" data-position="bottom" data-delay="50" data-tooltip="${language}"><i class="large material-icons">language</i></a></li>
        <li><a class="tooltipped btn-floating lighten-1" href="https://github.com/madben87?tab=repositories" data-position="bottom" data-delay="50" data-tooltip="${my_project}"><i class="material-icons">store</i></a></li>
        <li><a class="tooltipped btn-floating lighten-1" href="#user_email_modal" data-position="bottom" data-delay="50" data-tooltip="${write_me}"><i class="material-icons">email</i></a></li>
        <li><a class="tooltipped btn-floating lighten-1" href="admin" data-position="bottom" data-delay="50" data-tooltip="${admin_menu}"><i class="material-icons">verified_user</i></a></li>
    </ul>
</div>

<%@include file="/WEB-INF/views/template/modals.jsp"%>

<!--  Scripts-->
<script src="resources/jQuery/jquery-3.1.1.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/init.js"></script>

<script>
    function change_visibility (block_4_close, block_4_open) {
    $(document).ready(function(){
        $('#'+block_4_close).css('display','none');
        $('#'+block_4_open).css('display','');
        return false;
    });
}</script>
<script>
    $(document).ready(function(){
        $('.modal').modal();
    });
</script>
<script>
    $(document).ready(function(){
        $('.tooltipped').tooltip({delay: 50});
    });
</script>

</body>
</html>
