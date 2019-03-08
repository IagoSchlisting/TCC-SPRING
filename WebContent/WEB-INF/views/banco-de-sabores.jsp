<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicionar Sabor </div>
    <div class="panel-body">


        <form:form id="saborcontrol" action="/sabor/add" name="sabor" method="post">
        <form>
            <div class="form-group">
                <label for="sabor"> Sabor </label>
                <input type="text" class="form-control" name="sabor" id="sabor" placeholder="exemplo: Marguerita">
            </div>
            <div class="form-group">
                <label for="especial"> Tipo </label>
                <select class="form-control" name="especial" id="especial">
                    <option value="0"> Normal </option>
                    <option value="1"> Especial </option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary"> Adicionar Sabor </button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            </form:form>

    </div>

    <div class="panel-heading"> Banco de Sabores </div>
    <div class="panel-body">

        <table class="table table-striped">
            <tr>
                <th> id </th>
                <th> Sabor </th>
                <th> Tipo </th>
                <th> Remover </th>
            </tr>
            <c:forEach var="sabor" items="${sabores}">
                <tr>
                    <td> ${sabor.id} </td>
                    <td> ${sabor.sabor} </td>
                    <td style="color: ${sabor.especial ? "green" : ""}"> ${sabor.especial ? "Especial" : "Normal"} </td>
                    <td> <a href="/sabor/remove/${sabor.id}" class="btn btn-danger"> Remover </a> </td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>