<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading">  ${type} pedido número ${pedido.id} </div>
    <div class="panel-body">
            <table class="table table-striped">
                <tr>
                    <th> Cód. </th>
                    <th> Descrição </th>
                    <th> Valor Item </th>
                    <th>  </th>
                </tr>

                <c:forEach var="item" items="${pedido.itens}">
                    <tr>
                        <td> ${item.id} </td>
                        <td>
                            <c:if test="${item.ispizza}">
                                Pizza ${item.pizza.tamanhoPizza}

                                <c:if test="${item.pizza.comborda}">
                                    c/borda.
                                </c:if>
                            </c:if>

                            <c:if test="${not item.ispizza}">
                                ${item.bebida.bebida}
                            </c:if>
                        </td>
                        <td> ${item.valor} </td>
                        <td>
                            <a href="/remove/item/${item.id}" class="btn btn-danger"> Excluir </a>

                            <c:if test="${item.ispizza}">
                                <button class="btn btn-default" data-toggle="modal" data-target="#modal_${item.id}"> Ver Detalhes </button>


                                <!-- Modal -->
                                <div class="modal fade" id="modal_${item.id}" tabindex="-1" role="dialog" aria-labelledby="modal_${item.id}lLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title" id="exampleModalLabel" style="color:dimgrey"> PIZZA ${item.pizza.tamanhoPizza} ${item.pizza.comborda ? "C/BORDA" : ""} </h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">

                                                <table class="table table-striped">
                                                    <tr>
                                                        <th>Sabor</th>
                                                        <th>Tipo</th>
                                                    </tr>

                                                <c:forEach var="sabor" items="${item.pizza.sabores}">
                                                    <tr>
                                                        <td>${sabor.sabor}</td>
                                                        <td style="color: ${sabor.especial ? "green" : ""}"> ${sabor.especial ? "Especial" : "Normal"} </td>
                                                    </tr>
                                                </c:forEach>

                                                </table>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Save changes</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                        </td>

                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="4" align="center">
                        <a href="/pizza/add/${pedido.id}" class="btn btn-default" style="width: 400px"> Adicionar Pizza </a>
                        <a href="/bebida/add/${pedido.id}" class="btn btn-default" style="width: 400px"> Adicionar Bebida </a>
                    </td>
                </tr>

            </table>

        <form:form id="finalizapedido" action="/finaliza/pedido" name="finalizapedido" method="post">

            <input type="hidden" name="pedido_id" id="pedido_id" value="${pedido.id}">
        <div class="col-md-4">
            <div class="form-group">
                <label for="nome"> Nome do Cliente </label>
                <input type="text" class="form-control" name="nome" id="nome" value="${type.equals('Editando') ? pedido.nomeCliente : ''}">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="telefone"> Telefone </label>
                <input type="number" class="form-control" name="telefone" id="telefone" value="${type.equals('Editando') ? pedido.telefone : ''}">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="tipoPedido"> Tipo de Pedido </label>
                <select class="form-control" name="tipoPedido" id="tipoPedido">
                    <option value="TELE" ${pedido.tipoPedido.toString().equals('TELE') ? 'selected' : ''}>Tele-Entrega</option>
                    <option value="BALCAO" ${pedido.tipoPedido.toString().equals('BALCAO') ? 'selected' : ''}>Balcão</option>
                    <option value="SALAO" ${pedido.tipoPedido.toString().equals('SALAO') ? 'selected' : ''}>Salão</option>
                </select>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="bairro"> Bairro </label>
                <input type="text" class="form-control endereco" name="bairro" id="bairro" value="${pedido.tipoPedido.toString().equals('TELE') ? pedido.endereco.bairro: ''}">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="rua"> Rua </label>
                <input type="text" class="form-control endereco" name="rua" id="rua" value="${pedido.tipoPedido.toString().equals('TELE') ? pedido.endereco.rua: ''}">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="numero"> Nº </label>
                <input type="number" class="form-control endereco" name="numero" id="numero" value="${pedido.tipoPedido.toString().equals('TELE') ? pedido.endereco.numero: ''}">
            </div>
        </div>


        <div class="col-md-12" style="margin-bottom: 20px">
            <div class="form-row">
                <label for="totalvalue">Valor Total</label>
                <div class="input-group">
                    <span class="input-group-addon">R$</span>
                    <input type="number" value="${pedido.valorTotal}" min="0.00" step="0.01" max="10000.00" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="totalvalue" disabled="disabled"/>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group">
                <label for="tipoPagamento"> Forma de Pagamento </label>
                <select class="form-control" name="tipoPagamento" id="tipoPagamento">
                    <option value="CARTAO" ${pedido.tipoPagamento.toString().equals("CARTAO") ? 'selected' : ''}> Cartão </option>
                    <option value="DINHEIRO" ${pedido.tipoPagamento.toString().equals("DINHEIRO") ? 'selected' : ''}> Dinheiro </option>
                </select>
            </div>
        </div>

        <div class="col-md-6" id="bandeira-div" style="display: ${pedido.tipoPagamento.toString().equals("DINHEIRO") ? 'none' : 'block'}">
            <div class="form-group">
                <label for="bandeira"> Bandeira </label>
                <select class="form-control" name="bandeira" id="bandeira">
                    <option value="NONE"> Selecione a Bandeira</option>
                    <option value="VISA" ${pedido.bandeira.toString().equals("VISA") ? 'selected' : ''}>  VISA </option>
                    <option value="MASTER" ${pedido.bandeira.toString().equals("MASTER") ? 'selected' : ''}> MASTER </option>
                    <option value="ALELO" ${pedido.bandeira.toString().equals("ALELO") ? 'selected' : ''}>  ALELO </option>
                    <option value="SODEXO" ${pedido.bandeira.toString().equals("SODEXO") ? 'selected' : ''}>  SODEXO </option>
                    <option value="HIPERCARD" ${pedido.bandeira.toString().equals("HIPERCARD") ? 'selected' : ''}>  HIPERCARD </option>
                    <option value="ELO" ${pedido.bandeira.toString().equals("ELO") ? 'selected' : ''}>  ELO </option>
                    <option value="CIELO" ${pedido.bandeira.toString().equals("CIELO") ? 'selected' : ''}>  CIELO </option>
                    <option value="BANRI_VR" ${pedido.bandeira.toString().equals("BANRI_VR") ? 'selected' : ''}>  BANRI_VR </option>
                    <option value="BANRI_VA" ${pedido.bandeira.toString().equals("BANRI_VA") ? 'selected' : ''}>  BANRI_VA </option>
                    <option value="GREEN_VR" ${pedido.bandeira.toString().equals("GREEN_VR") ? 'selected' : ''}>  GREEN_VR </option>
                    <option value="GREEN_VA" ${pedido.bandeira.toString().equals("GREEN_VA") ? 'selected' : ''}>  GREEN_VA </option>
                    <option value="VR" ${pedido.bandeira.toString().equals("VR") ? 'selected' : ''}>  VR </option>
                </select>
            </div>
        </div>

        <div class="col-md-6" id="troco-div" style="display: ${pedido.tipoPagamento.toString().equals("DINHEIRO") ? 'block' : 'none'}">
            <div class="form-group">
                <label for="troco">Troco necessário</label>
                <div class="input-group">
                    <span class="input-group-addon">R$</span>
                    <input type="number" value="${pedido.troco}" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="troco" name="troco"/>
                </div>
            </div>
        </div>


        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <a href="/" class="btn btn-danger" style="width: 100%"> Voltar  </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button type="submit" class="btn btn-success" style="width: 100%"> Finalizar Pedido </button>
        </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form:form>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="js/pcsFormatNumber.jquery.js"></script>

    <script>

        $(document)
            .on("change", "#tipoPagamento", function(){
                if(this.value == "CARTAO"){
                    $("#bandeira-div").css("display", "block");
                    $("#troco-div").css("display", "none");
                }
                if(this.value == "DINHEIRO"){
                    $("#bandeira-div").css("display", "none");
                    $("#troco-div").css("display", "block");
                }
            })
            .on("change", "#tipoPedido",function(){
                if(this.value == "TELE"){
                    $(".endereco").prop("disabled", false);
                }else{
                    $(".endereco").prop("disabled", true);
                }
            });

            if(${not empty pedido.tipoPedido and pedido.tipoPedido.toString().equals('TELE')}){
                $(".endereco").prop("disabled", false);
            }else{
                if(${empty pedido.tipoPedido}){
                    $(".endereco").prop("disabled", false);
                }else{
                    $(".endereco").prop("disabled", true);
                }
            }
    </script>