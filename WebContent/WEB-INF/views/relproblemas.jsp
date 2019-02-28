<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="panel panel-default">
    <div class="panel-heading"> Relatório de Problemas </div>
    <div class="panel-body">


        <form class="form-inline">
            <div class="form-group">
                <select id="filtro" class="form-control" style="width: 300px">
                    <option value="0"> Filtrar por </option>
                    <option value="day"> Dia </option>
                    <option value="month"> Mês </option>
                </select>
            </div>

            <div class="form-group hide" id="day">
                <input class="form-control" type="date" style="width: 300px">
            </div>

            <div class="form-group hide" id="month">
                <select class="form-control" style="width: 150px">
                    <option value="1"> Janeiro </option>
                    <option value="2"> Fevereiro </option>
                    <option value="3"> Março </option>
                    <option value="4"> Abril </option>
                    <option value="5"> Maio </option>
                    <option value="6"> Junho </option>
                    <option value="7"> Julho </option>
                    <option value="8"> Agosto </option>
                    <option value="9"> Setembro </option>
                    <option value="10"> Outubro </option>
                    <option value="11"> Novembro </option>
                    <option value="12"> Dezembro </option>
                </select>
            </div>

        </form>
        <table class="table table-striped">
            <tr>
                <th> Código </th>
                <th> Cliente </th>
                <th> Endereço </th>

                <th> H Solicitação </th>
                <th> H Confirmação</th>
                <th> Pedido </th>
                <th> Descrição do Problema</th>
                <th> Valor Total</th>
            </tr>

            <tr>
                <td> 1232 </td>
                <td> user teste </td>
                <td> rua das palmeiras, 50 </td>
                <td> 20:50 18/02/2019 </td>
                <td> 21:50 18/02/2019</td>
                <td> <button class="btn btn-ifo" data-toggle="modal" data-target="#exampleModal"><span class="glyphicon glyphicon-plus"></span> </button> </td>
                <td><input type="text" class="form-control" value="Pizza do Cliente veio gelada"></td>
                <td> R$80,90</td>
            </tr>

            <tr>
                <td> 1232 </td>
                <td> user teste </td>
                <td> rua das palmeiras, 50 </td>
                <td> 20:50 18/02/2019 </td>
                <td> 21:50 18/02/2019</td>
                <td> <button class="btn btn-ifo" data-toggle="modal" data-target="#exampleModal"><span class="glyphicon glyphicon-plus"></span> </button> </td>
                <td><input type="text" class="form-control" value="Pizza do Cliente veiodsadasdsadsadsadas gelada"></td>
                <td> R$80,90</td>
            </tr>

            <tr>
                <td> 1232 </td>
                <td> user teste </td>
                <td> rua das palmeiras, 50 </td>
                <td> 20:50 18/02/2019 </td>
                <td> 21:50 18/02/2019</td>
                <td> <button class="btn btn-ifo" data-toggle="modal" data-target="#exampleModal"><span class="glyphicon glyphicon-plus"></span> </button> </td>
                <td> <input type="text" class="form-control" value="Pizza do Cliente ssasasaveio gelada"> </td>
                <td> R$80,90</td>
            </tr>

        </table>


        <div class="col-md-8">
            <table class="table table-striped table-bordered">
                <tr style="background-color:#ff2f004f;">
                    <th style="width:30%"> Período </th>
                    <th style="width:30%"> Quantidade de Pedidos </th>
                    <th> Total Somado </th>
                </tr>
                <tr>
                    <td> 02/08/2018 </td>
                    <td> 89 </td>
                    <td> R$6800,00 </td>
                </tr>
            </table>
        </div>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"> Composição do Pedido </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>#</th>
                            <th>Descrição do Item</th>
                            <th>Valor total</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td> Pizza gigante - c/borda - marguerita - alho poro - strognoff - camarao </td>
                            <td> R$98,00</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td> Coca Cola 2L</td>
                            <td> R$6,00 </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td> Broto - camarao </td>
                            <td> R$34,90</td>
                        </tr>
                        <tr>
                            <td></td>
                            <th style="text-align:right"> Valor Total:  </th>
                            <td> <span style="color: green">R$138,90 </span> </td>
                        </tr>

                    </table>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>