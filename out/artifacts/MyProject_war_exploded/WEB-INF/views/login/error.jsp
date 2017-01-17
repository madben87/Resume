<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="login_error" code="login_error"/>
<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="fonts"/>
<spring:url value="resources/css/materialize.css" var="materialize"/>
<spring:url value="resources/css/style.css" var="style"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<div id="index-banner" class="parallax-container">
    <div class="parallax"><img src="resources/images/background/background1.jpg"></div>
</div>

<div class="container">
    <div class="section">
        <div class="row">
            <p class="col s12 center">
            <h3><i class="mdi-content-send brown-text"></i></h3>
            <h5 style="color: red;">${login_error}</h5>

            <form name="frm" action="<c:url value='login'/>" method="post">
                <table>
                    <tr> <td>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="login" type="text" name="username">
                                <label for="login">Login</label>
                            </div>
                        </div>
                    </td></tr>
                    <tr> <td>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" name="password">
                                <label for="password">Password</label>
                            </div>
                        </div>
                    </td></tr>
                    <tr> <td>
                        <button class="btn waves-effect waves-light" type="submit" name="submit">Submit
                            <i class="material-icons right">send</i>
                        </button>
                    </td></tr>
                    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
                           value="<c:out value="${_csrf.token}"/>"/>
                </table>
            </form>
        </div>
    </div>
</div>

<div class="parallax-container valign-wrapper">
    <div class="parallax"><img src="resources/images/background/background2.jpg"></div>
</div>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/init.js"></script>

</body>
</html>