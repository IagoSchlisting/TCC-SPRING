<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Controle de Usuários </div>
    <div class="panel-body">

        <table class="table table-striped">
            <tr>
                <th> id </th>
                <th> Username </th>
                <th> Nível de acesso </th>
                <th> Remover </th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td> ${user.id} </td>
                    <td> ${user.username} </td>
                    <td>
                        <c:forEach var="role" items="${user.roles}">
                            ${role.role}
                        </c:forEach>
                    </td>
                    <td> <a href="/user/remove/${user.id}" class="btn btn-danger"> Remover </a> </td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <div class="panel-heading"> Administração de Usuários </div>
    <div class="panel-body">
        <form:form id="usercontrol" action="/user/add" name="user" method="post">
        <form>
            <div class="form-group">
                <label for="username"> Username </label>
                <input type="text" class="form-control" name="username" id="username" placeholder="exemplo: joao.marcos">
            </div>
            <div class="form-group">
                <label for="accessLevel"> Nível de acesso </label>
                <select class="form-control" name="accessLevel" id="accessLevel">
                    <option value="0"> Normal </option>
                    <option value="1"> Administrador </option>
                </select>
            </div>
            <div class="form-group">
                <span style="font-size: small; color: grey"> Obs: Lembre o usuário que sua senha inicial será <strong>12345</strong> e que ele deverá alterá-la no primeiro acesso por questões de segurança.</span>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary"> Adicionar Usuário </button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        </form:form>

    </div>

    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>