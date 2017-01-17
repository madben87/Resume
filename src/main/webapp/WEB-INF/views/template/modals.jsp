<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Modals begin--%>

<div id="modal1" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/Java_avatar.png" width="300" height="300"></h4>
        <p>${modal_java}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal2" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/JDBC.png" width="300" height="300"></h4>
        <p>${modal_jdbc}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal3" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/Spring_framework.png" width="600" height="200"></h4>
        <p>${modal_spring}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal4" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/maven-logo-black-on-white1.png" width="400" height="300"></h4>
        <p>${modal_maven}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal5" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/mysql-icon.png" width="300" height="300"></h4>
        <p>${modal_mysql}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal6" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/Tomcat.svg.png" width="300" height="400"></h4>
        <p>${modal_tomcat}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal7" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/glassfish.png" width="400" height="300"></h4>
        <p>${modal_glassfish}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal8" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/Logo_JPA.png" width="300" height="300"></h4>
        <p>${modal_jpa}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal9" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/hibernate_logo_whitebkg_stacked_256px.png" width="300" height="300"></h4>
        <p>${modal_hibernate}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal10" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/JSP.png" width="300" height="300"></h4>
        <p>${modal_jsp}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal11" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/js.png" width="600" height="300"></h4>
        <p>${modal_js}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>
<div id="modal12" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4><img src="resources/images/skills/junit5-banner.png" width="600" height="200"></h4>
        <p>${modal_junit}</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat ">Close</a>
    </div>
</div>

<c:url value="/userEmail/send" var="userSend"/>

<form class="col s6" name="sentMessage" id="contactForm" action="${userSend}"
      method="post" modelAttribute="emailModel">
    <div id="user_email_modal" class="modal modal-fixed-footer">
        <div class="modal-content">
            <h4>${email_header}</h4>
            <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input id="icon_prefix" type="text" class="validate" name="name" required>
                <label for="icon_prefix">${email_name}</label>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">phone</i>
                <input id="icon_telephone" type="tel" class="validate" name="phone">
                <label for="icon_telephone">${email_phone}</label>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix"><img src="resources/images/icons/@_symbol.svg.png" width="25" height="25"></i>
                <input id="email" type="email" class="validate" name="email" required>
                <label for="email" data-error="wrong" data-success="right">${email_email}</label>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <textarea id="icon_prefix2" class="materialize-textarea" name="message"></textarea>
                <label for="icon_prefix2">${email_text}</label>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn waves-effect waves-light" type="submit">${email_send}
                <i class="material-icons right">send</i>
            </button>
        </div>
    </div>
</form>

<div id="localization" class="modal collection" style="width: 10%">
    <%--<div class="modal-content">--%>
        <a class="collection-item" href="?lang=en">En<span  class="secondary-content"><img src="resources/images/localization/En_flag.png" width="25" height="25"></span></a>
        <a class="collection-item" href="?lang=ru">Ру<span  class="secondary-content"><img src="resources/images/localization/Ru_flag.png" width="25" height="25"></span></a>
    <%--</div>--%>
</div>

