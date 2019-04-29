<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="panel panel-default">
    <div class="panel-heading"> Relatório de Pedidos </div>
    <div class="panel-body">

        <form:form id="form_filtro" action="/filtro/relatorio" name="form_filtro" method="get" cssClass="form-inline">
            <input type="hidden" name="problema" value="${problema ? problema : false}">
            <div class="form-group">
                <select id="filtro" class="form-control" style="width: 300px">
                    <option value="0"> Filtrar por </option>
                    <option value="day"> Dia </option>
                    <option value="month"> Mês </option>
                </select>
            </div>

            <div class="form-group hide" id="day">
                <input class="form-control" type="date" name="filtro_dia" style="width: 300px">
            </div>

            <div class="form-group hide" id="month">
                <select class="form-control" style="width: 180px" name="filtro_mes">
                    <option value="0" selected="selected"> Selecione o mês </option>
                    <option value="01"> Janeiro </option>
                    <option value="02"> Fevereiro </option>
                    <option value="03"> Março </option>
                    <option value="04"> Abril </option>
                    <option value="05"> Maio </option>
                    <option value="06"> Junho </option>
                    <option value="07"> Julho </option>
                    <option value="08"> Agosto </option>
                    <option value="09"> Setembro </option>
                    <option value="10"> Outubro </option>
                    <option value="11"> Novembro </option>
                    <option value="12"> Dezembro </option>
                </select>
            </div>

            <div class="form-group hide" id="year">
                <select class="form-control" style="width: 100px" name="filtro_ano">
                    <option value="2019" selected="selected"> 2019 </option>
                    <option value="2020"> 2020 </option>
                    <option value="2021"> 2021 </option>
                    <option value="2022"> 2022 </option>
                    <option value="2023"> 2023 </option>
                    <option value="2024"> 2024 </option>
                    <option value="2025"> 2025 </option>
                    <option value="2026"> 2026 </option>
                    <option value="2027"> 2027 </option>
                    <option value="2028"> 2028 </option>
                    <option value="2029"> 2029 </option>
                    <option value="2030"> 2030 </option>
                </select>
            </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group" id="search_button">
                <button type="submit" class="btn btn-button"> Pesquisar </button>
            </div>

        </form:form>
        <table class="table table-striped">
            <tr>
                <th> Código </th>
                <th> Cliente </th>
                <th> Endereço / Tipo </th>
                <th> H Solicitação </th>
                <th> ${not problema ? 'H Confirmação' : 'Registro do Problema'}</th>
                <th> Pedido </th>
                <th> Pagamento </th>
                <th> Valor Total</th>
            </tr>

            <c:forEach var="pedido" items="${pedidos}">

            <tr>
                <td> ${pedido.id} </td>
                <td> ${pedido.nomeCliente} </td>
                <td>
                    <c:if test="${pedido.tipoPedido.equals(tele)}">
                        Rua ${pedido.endereco.rua}, Bairro ${pedido.endereco.bairro}, Nº ${pedido.endereco.numero}
                    </c:if>

                    <c:if test="${not pedido.tipoPedido.equals(tele)}">
                        [ ${pedido.tipoPedido} ]
                    </c:if>
                </td>
                <td> ${pedido.start.format(formatter)} </td>
                <td> ${pedido.end.format(formatter)} </td>
                <td> <button class="btn btn-ifo" data-toggle="modal" data-target="#modal_${pedido.id}"><span class="glyphicon glyphicon-plus"></span> </button> </td>
                <td>
                    <c:if test="${pedido.tipoPagamento.equals(cartao)}">
                        Cartão / ${pedido.bandeira}
                    </c:if>
                    <c:if test="${not pedido.tipoPagamento.equals(cartao)}">
                        Dinheiro / Troco - R$${pedido.troco}
                    </c:if>
                </td>
                <td> R$${pedido.valorTotal}</td>
            </tr>

            </c:forEach>
        </table>


        <div class="col-md-8">
            <table class="table table-striped table-bordered">
                <tr style="background-color:${not problema ? '#c3d6c6' : '#ff2f004f'};">
                    <th style="width:30%"> Período </th>
                    <th style="width:30%"> Quantidade de Pedidos </th>
                    <th> Total Faturado </th>
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


<c:forEach var="pedido" items="${pedidos}">

    <!-- Modal -->
    <div class="modal fade" id="modal_${pedido.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"> Composição do Pedido [${pedido.id}]</h5>
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

                        <c:forEach var="item" items="${pedido.itens}">

                            <tr>
                                <td>${item.id}</td>
                                <td>
                                    <c:if test="${item.ispizza}">
                                        Pizza ${item.pizza.tamanhoPizza}
                                        <c:if test="${item.pizza.comborda}">
                                            c/borda.
                                        </c:if>

                                        <c:forEach var="sabor" items="${item.pizza.sabores}">
                                            <br> - ${sabor.sabor}
                                        </c:forEach>

                                    </c:if>

                                    <c:if test="${not item.ispizza}">
                                        ${item.bebida.bebida}
                                    </c:if>
                                </td>
                                <td> ${item.valor}</td>
                            </tr>

                        </c:forEach>

                        <tr>
                            <td></td>
                            <th style="text-align:right"> Valor Total:  </th>
                            <td> <span style="color: green">R$${pedido.valorTotal} </span> </td>
                        </tr>

                    </table>

                    <c:if test="${problema}">
                        <table class="table table-striped">
                            <tr>
                                <th> Descrição do Problema </th>
                            </tr>
                            <tr>
                                <td> ${pedido.problema.descricao} </td>
                            </tr>
                        </table>
                    </c:if>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"> Fechar Janela</button>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>



    <script>
            $("#filtro").change(function(){
                var value = $(this).children("option:selected").val();
                $("#day").addClass("hide");
                $("#month").addClass("hide");
                $("#year").addClass("hide");

                $("#"+value).removeClass("hide");

                if(value == "month"){
                    $("#year").removeClass("hide");
                }
            });
    </script>

<%@ include file="templates/footer.jsp"%>