<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="panel panel-default">
    <div class="panel-heading"> Administração de Valores </div>
    <div class="panel-body">

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
                <td> <input type="text" class="form-control" name="broto-val" value="0"></td>
                <td> <input type="text" class="form-control" name="media-val" value="0"></td>
                <td> <input type="text" class="form-control" name="grande-val" value="0"></td>
                <td> <input type="text" class="form-control" name="gigante-val" value="0"></td>
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
                <td> <input type="text" class="form-control" name="grande-borda" value="0"></td>
                <td> <input type="text" class="form-control" name="gigante-borda" value="0"></td>
                <td> <input type="text" class="form-control" name="tele-entrega" value="0"></td>
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
                <td><input type="text" class="form-control" name="broto-1-val" value="0"></td>
                <td><input type="text" class="form-control" name="media-1-val" value="0"></td>
                <td><input type="text" class="form-control" name="grande-1-val" value="0"></td>
                <td><input type="text" class="form-control" name="gigante-1-val" value="0"></td>
            </tr>
            <tr>
                <th scope="row">1/2</th>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td><input type="text" class="form-control" name="media-2-val" value="0"></td>
                <td><input type="text" class="form-control" name="grande-2-val" value="0"></td>
                <td><input type="text" class="form-control" name="gigante-2-val" value="0"></td>
            </tr>
            <tr>
                <th scope="row">1/3</th>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td><input type="text" class="form-control" name="grande-3-val" value="0"></td>
                <td><input type="text" class="form-control" name="gigante-3-val" value="0"></td>
            </tr>
            <tr>
                <th scope="row">1/4</th>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td> <input type="text" class="form-control" value="###" disabled="disabled"> </td>
                <td><input type="text" class="form-control" name="gigante-4-val" value="0"></td>
            </tr>
            </tbody>
        </table>

        <div align="center" style="background-color: #f8f8f8; padding: 10px">
            <a href="/" class="btn btn-danger btn-save-values"> Cancelar </a>
            <button class="btn btn-primary btn-save-values"> Salvar Valores </button>
        </div>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>