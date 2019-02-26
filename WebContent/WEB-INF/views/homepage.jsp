<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="panel panel-default">
    <div class="panel-heading"> Controle de Pedidos do dia [ ${diaatual} ] </div>
    <div class="panel-body">

        <div class="row">
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-teal panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
                        <div class="large">120</div>
                        <div class="text-muted"> <span style="color:#586ea5">Total de Pedidos </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-blue panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
                        <div class="large">52</div>
                        <div class="text-muted"> <span style="color:#59b564">Finalizados </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-orange panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
                        <div class="large">24</div>
                        <div class="text-muted"><span style="color:#a7a04b"> Em Produção </span></div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-orange panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
                        <div><a href="/" class="large"><span class="glyphicon glyphicon-plus"></span></a></div>
                        <div class="text-muted" style="margin-top: 12px"><span style="color:#a1491e"> Adicionar novo Pedido </span></div>
                    </div>
                </div>
            </div>

        </div><!--/.row-->
    </div>

    <div style="min-height: 200px">
        <table class="table table-striped">
            <tr>
                <th> Nome </th>
                <th> Telefone </th>
                <th> Horário </th>
                <th> Endereço </th>
                <th>  </th>
            </tr>

            <%--<tr>--%>
                <%--<td colspan="5" align="center">  <span style="color:#5b5959">Nenhum pedido em produção no momento.</span> </td>--%>
            <%--</tr>--%>

            <tr>
                <td> user teste</td>
                <td> 7327317237 </td>
                <td> 19:30 </td>
                <td> Rua das testeiras, Igara, 50 </td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ações <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#"> Confirmar Pagamento </a></li>
                            <li><a href="#"> Reimprimir</a></li>
                            <li><a href="#"> Editar Pedido</a></li>
                            <li><a href="#"> Relatar Problema </a></li>
                            <li role="separator" class="divider"></li>
                            <li style="background-color: #eb8c8c"><a href="#"> Excluir </a></li>
                        </ul>
                    </div>
                </td>
            </tr>

            <tr>
                <td> user teste</td>
                <td> 7327317237 </td>
                <td> 19:30 </td>
                <td> Rua das testeiras, Igara, 50 </td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ações <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#"> Confirmar Pagamento </a></li>
                            <li><a href="#"> Reimprimir</a></li>
                            <li><a href="#"> Editar Pedido</a></li>
                            <li><a href="#"> Relatar Problema </a></li>
                            <li role="separator" class="divider"></li>
                            <li style="background-color: #eb8c8c"><a href="#"> Excluir </a></li>
                        </ul>
                    </div>
                </td>
            </tr>

            <tr>
                <td> user teste</td>
                <td> 7327317237 </td>
                <td> 19:30 </td>
                <td> Rua das testeiras, Igara, 50 </td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ações <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#"> Confirmar Pagamento </a></li>
                            <li><a href="#"> Reimprimir</a></li>
                            <li><a href="#"> Editar Pedido</a></li>
                            <li><a href="#"> Relatar Problema </a></li>
                            <li role="separator" class="divider"></li>
                            <li style="background-color: #eb8c8c"><a href="#"> Excluir </a></li>
                        </ul>
                    </div>
                </td>
            </tr>

            <tr>
                <td> user teste</td>
                <td> 7327317237 </td>
                <td> 19:30 </td>
                <td> Rua das testeiras, Igara, 50 </td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ações <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#"> Confirmar Pagamento </a></li>
                            <li><a href="#"> Reimprimir</a></li>
                            <li><a href="#"> Editar Pedido</a></li>
                            <li><a href="#"> Relatar Problema </a></li>
                            <li role="separator" class="divider"></li>
                            <li style="background-color: #eb8c8c"><a href="#"> Excluir </a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>