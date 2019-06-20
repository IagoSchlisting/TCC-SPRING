<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Controle de Pedidos do dia [ ${data_hoje} ] </div>
    <div class="panel-body">

        <div class="row">
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-teal panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
                        <div class="large">${total_pedidos}</div>
                        <div class="text-muted"> <span style="color:#586ea5">Total de Pedidos </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-blue panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
                        <div class="large">${total_pedidos_confirmados}</div>
                        <div class="text-muted"> <span style="color:#59b564">Finalizados </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-orange panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
                        <div class="large">${total_pedidos_producao}</div>
                        <div class="text-muted"><span style="color:#a7a04b"> Em Produção </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-orange panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
                        <div><a href="/pedido/add" class="large"><span class="glyphicon glyphicon-plus"></span></a></div>
                        <div class="text-muted" style="margin-top: 12px"><span style="color:#a1491e"> Adicionar novo Pedido </span></div>
                    </div>
                </div>
            </div>

        </div><!--/.row-->
    </div>

    <div style="min-height: 200px">
        <table class="table table-striped">
            <tr>
                <th> Cód. </th>
                <th> Nome </th>
                <th> Telefone </th>
                <th> Horário </th>
                <th> Endereço </th>
                <th> Pagamento </th>
                <th> Total </th>
                <th>  </th>
            </tr>

            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td> ${pedido.id}</td>
                    <td> ${pedido.nomeCliente} </td>
                    <td> ${pedido.telefone} </td>
                    <td> ${pedido.start.format(formatter)} </td>
                    <td>

                        <c:if test="${pedido.tipoPedido.equals(tele)}">
                            Rua ${pedido.endereco.rua}, Bairro ${pedido.endereco.bairro}, Nº ${pedido.endereco.numero}
                        </c:if>

                        <c:if test="${not pedido.tipoPedido.equals(tele)}">
                            [ ${pedido.tipoPedido} ]
                        </c:if>

                    </td>
                    <td>
                        <c:if test="${pedido.tipoPagamento.equals(cartao)}">
                            Cartão / ${pedido.bandeira}
                        </c:if>
                        <c:if test="${not pedido.tipoPagamento.equals(cartao)}">
                            Dinheiro / Troco - R$${pedido.troco}
                        </c:if>
                    </td>
                    <td> R$${pedido.valorTotal} </td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ações <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="/confirma/pedido/${pedido.id}"> Confirmar Pagamento </a></li>
                                <li><a href="/reimprimir/pedido/${pedido.id}"> Reimprimir</a></li>
                                <li><a href="/editar/pedido/${pedido.id}"> Editar Pedido</a></li>
                                <li><a href="" data_pedido="${pedido.id}" data-toggle="modal" data-target="#modalCenter" class="problem_link"> Relatar Problema </a></li>
                                <li role="separator" class="divider"></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <%--<tr>--%>
                <%--<td colspan="5" align="center">  <span style="color:#5b5959">Nenhum pedido em produção no momento.</span> </td>--%>
            <%--</tr>--%>
        </table>
    </div>

        <!-- Modal -->
    <div class="modal fade" id="modalCenter" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modalnot-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle"> Área de registro de problemas.</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: -25px">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                <form:form id="problemacontrol" action="/pedido/add/problema" name="problema" method="post">
                    <input type="hidden" name="pedido_id" id="pedido_id_modal"/>
                    <div class="form-group">
                        <label for="problemadesc"> Relate o problema do pedido <span style="color: red" id="pedido_id_span"> </span> </label>
                        <textarea class="form-control" id="problemadesc" name="problemadesc" rows="3"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form:form>
                </div>
            </div>
        </div>
    </div>

    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>
    <OBJECT id="BemaMP32" height="14" width="14" classid="clsid:310DBDAC-85FF-4008-82A8-E22A09F9460B"  VIEWASTEXT></OBJECT>
    <script>

        <c:if test="${not empty imprimir}">
            BemaMP32.ConfiguraModeloImpressora(7);
            BemaMP32.iniciaPorta("USB");
            <c:forEach var="linha" items="${imprimir}">
                BemaMP32.BematechTX("${linha}");
                BemaMP32.BematechTX("\n");
            </c:forEach>
            BemaMP32.BematechTX("\n");
            BemaMP32.BematechTX("\n");
            BemaMP32.AcionaGuilhotina(0);
            BemaMP32.FechaPorta();
        </c:if>

        $(document)
            .on("click", ".problem_link", function(){
                $("#pedido_id_modal").val($(this).attr("data_pedido"));
                $("#pedido_id_span").html("[" +$(this).attr("data_pedido")+ "]");
            });
    </script>