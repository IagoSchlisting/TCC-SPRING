<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicionar Bebida </div>
    <div class="panel-body">


        <form:form id="bebidacontrol" action="/bebida/add" name="bebida" method="post">
        <form>
            <div class="form-group">
                <label for="bebida"> Bebida </label>
                <input type="text" class="form-control" name="bebida" id="bebida" placeholder="exemplo: Coca-Cola 2L">
            </div>
            <div class="form-group">
                <label for="valor"> Valor </label>
                <input type="number" class="form-control" name="valor" id="valor" placeholder="exemplo: R$6,00">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary"> Adicionar Bebida </button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            </form:form>

    </div>

    <div class="panel-heading"> Banco de Bebidas </div>
    <div class="panel-body">

        <table class="table table-striped">
            <tr>
                <th> id </th>
                <th> Bebida </th>
                <th> Valor </th>
                <th> Remover </th>
            </tr>
            <c:forEach var="bebida" items="${bebidas}">
                <tr>
                    <td> ${bebida.id} </td>
                    <td> ${bebida.bebida} </td>
                    <td> ${bebida.valor} </td>
                    <td> <a href="/bebida/remove/${bebida.id}" class="btn btn-danger"> Remover </a> </td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>