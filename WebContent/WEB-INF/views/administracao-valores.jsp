<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Administração de Valores </div>
    <div class="panel-body">

    <form:form id="valorescontrol" action="/valores/update" name="valoresForm" method="post">
    <div class="div-table-title col-md-4">
            <span class="div-table-title-font">Valores Base dos Tamanhos</span>
        </div>

        <table class="table table-striped">
            <tr>
                <th> Broto </th>
                <th> Média </th>
                <th> Grande </th>
                <th> Gigante </th>
            </tr>
            <tr>
                <td> <input type="text" class="form-control" name="valorBaseBroto" value="${valoresAdicionais.valorBaseBroto}"></td>
                <td> <input type="text" class="form-control" name="valorBaseMedia" value="${valoresAdicionais.valorBaseMedia}"></td>
                <td> <input type="text" class="form-control" name="valorBaseGrande" value="${valoresAdicionais.valorBaseGrande}"></td>
                <td> <input type="text" class="form-control" name="valorBaseGigante" value="${valoresAdicionais.valorBaseGigante}"></td>
            </tr>
        </table>

        <div class="div-table-title col-md-4">
            <span class="div-table-title-font">Valores Adicionais Borda e Tele Entrega</span>
        </div>

        <table class="table table-striped">
            <tr>
                <th> Borda Grande </th>
                <th> Borda Gigante </th>
                <th> Tele Entrega</th>
            </tr>
            <tr>
                <td> <input type="text" class="form-control" name="valorBordaGrande" value="${valoresAdicionais.valorBordaGrande}"></td>
                <td> <input type="text" class="form-control" name="valorBordaGigante" value="${valoresAdicionais.valorBordaGigante}"></td>
                <td> <input type="text" class="form-control" name="valorTeleEntrega" value="${valoresAdicionais.valorTeleEntrega}"></td>
            </tr>
        </table>

        <div class="div-table-title col-md-4">
            <span class="div-table-title-font">Valores Adicionais dos Sabores Especiais</span>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Broto</th>
                <th>Média</th>
                <th>Grande</th>
                <th>Gigante</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td><input type="text" class="form-control" name="valorEspecialBroto1" value="${valoresAdicionais.valorEspecialBroto1}"></td>
                <td><input type="text" class="form-control" name="valorEspecialMedia1" value="${valoresAdicionais.valorEspecialMedia1}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGrande1" value="${valoresAdicionais.valorEspecialGrande1}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGigante1" value="${valoresAdicionais.valorEspecialGigante1}"></td>
            </tr>
            <tr>
                <th scope="row">1/2</th>
                <td><input type="text" class="form-control" name="valorEspecialBroto2" value="${valoresAdicionais.valorEspecialBroto2}"></td>
                <td><input type="text" class="form-control" name="valorEspecialMedia2" value="${valoresAdicionais.valorEspecialMedia2}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGrande2" value="${valoresAdicionais.valorEspecialGrande2}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGigante2" value="${valoresAdicionais.valorEspecialGigante2}"></td>
            </tr>
            <tr>
                <th scope="row">1/3</th>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td><input type="text" class="form-control" name="valorEspecialMedia3" value="${valoresAdicionais.valorEspecialMedia3}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGrande3" value="${valoresAdicionais.valorEspecialGrande3}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGigante3" value="${valoresAdicionais.valorEspecialGigante3}"></td>
            </tr>
            <tr>
                <th scope="row">1/4</th>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td><input type="text" class="form-control" name="valorEspecialGrande4" value="${valoresAdicionais.valorEspecialGrande4}"></td>
                <td><input type="text" class="form-control" name="valorEspecialGigante4" value="${valoresAdicionais.valorEspecialGigante4}"></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div align="center" style="background-color: #f8f8f8; padding: 10px">
            <a href="/" class="btn btn-danger btn-save-values"> Cancelar </a>
            <button class="btn btn-primary btn-save-values"> Salvar Valores </button>
        </div>
    </form:form>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>