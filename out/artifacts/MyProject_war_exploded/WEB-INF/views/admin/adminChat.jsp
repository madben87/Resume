<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="resources/css/my_test.css" var="my_test"/>
<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="fonts"/>
<spring:url value="resources/css/materialize.css" var="materialize"/>
<spring:url value="resources/css/style.css" var="style"/>

<html>
<head>
    <title>Title</title>
    <link href="${my_test}" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="${fonts}" rel="stylesheet">
    <link href="${materialize}" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="${style}" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>

<nav class="nav_panel">
    <div class="nav-wrapper container">
        <a id="logo-container" href="admin" class="brand-logo">ADMIN</a>

        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<div class="admin_chat white">
    <div class="nav_side grey lighten-3">
        <div id="col" class="collection" style="margin: 0">
            <nav>
                <div class="nav-wrapper teal lighten-1">
                    <form>
                        <div class="input-field">
                            <input id="search" type="search" required>
                            <label for="search"><i class="material-icons">search</i></label>
                            <i class="material-icons">close</i>
                        </div>
                    </form>
                </div>
            </nav>

            <c:if test="${not empty users}">
                <c:forEach items="${users}" var="userMessages">

                    <a id="${userMessages.id}" class="collection-item">${userMessages.name}<br/>${userMessages.email}</a>

                </c:forEach>
            </c:if>

        </div>
    </div>
    <div id="messageArea" class="chat_side">

    </div>
</div>

<c:url value="/adminEmail/answer" var="answerSend"/>

<div class="admin_chat_footer">
    <div id="chatForm" class="reply_block">
        <form name="sentMessage" id="replyForm" action="${answerSend}" method="post" modelAttribute="emailModel">

            <a id="formSubmit" class="tooltipped btn-floating lighten-1 margin_top float_right margin_right"><i class="material-icons medium center ">send</i></a>
            <textarea autofocus id="reply" class="reply_textArea margin_top float_right" name="message"></textarea>
                <%--hidden--%>
            <input type="hidden" id="name" class="validate" name="name">
            <input type="hidden" id="user_id" name="id">
            <input type="hidden" id="message_id" name="message_id">
            <input type="hidden" id="telephone" class="validate" name="phone">
            <input type="hidden" id="email_ans" class="validate" name="email">
                <%--hidden--%>
        </form>
    </div>
    <div class="admin_chat_footer_copyright teal lighten-1">
        <div class="text_copyright">
            Made by <a class="brown-text text-lighten-3" href="http://materializecss.com">Materialize</a>
        </div>
    </div>
</div>



</body>
</html>

<script src="resources/jQuery/jquery-3.1.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> <%--submit form--%>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/init.js"></script>

<script>
    $(".button-collapse").sideNav();
</script>

<script>
    $("#navTest").css("background-color", "white");
</script>

<c:forEach items="${users}" var="user">

    <script>
        $(document).ready(function() {
            $("#${user.id}").click(function () {
                $.post('ajaxTest', {criteria : ${user.id}}, function(data) {
                    $('#messageArea').html(data);
                    $('#chatForm').css('display', 'inline-block');
                    $('#user_id').val('${user.id}');
                    $('#name').val("Ben");
                    $('#telephone').val("+3806754***02");
                    $('#email_ans').val('${user.email}');
                });
            });
        });
    </script>

</c:forEach>

<script>
    $("#formSubmit").click(function () {
        $("#replyForm").submit();
        $('#reply').val('');
    });
</script>
