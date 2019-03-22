<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="panel panel-default">
    <div class="panel-heading">  Adicionar / Editar Pedido </div>
    <div class="panel-body">
            <table class="table table-striped">
                <tr>
                    <th> Cód. </th>
                    <th> Descrição </th>
                    <th> Valor Item </th>
                    <th>  </th>
                </tr>

                <tr>
                    <td> 1234552 </td>
                    <td> Pizza Gigante </td>
                    <td> R$80,00 </td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ações <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#"> Ver Detalhes </a></li>
                                <li><a href="#"> Editar </a></li>
                                <li><a href="#"> Excluir </a></li>
                            </ul>
                        </div>
                    </td>

                </tr>

                <tr>
                    <td> 1234552 </td>
                    <td> Pizza Gigante </td>
                    <td> R$80,00 </td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ações <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#"> Ver Detalhes </a></li>
                                <li><a href="#"> Editar </a></li>
                                <li><a href="#"> Excluir </a></li>
                            </ul>
                        </div>
                    </td>

                </tr>

                <tr>
                    <td> 1234552 </td>
                    <td> Pizza Gigante </td>
                    <td> R$80,00 </td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ações <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#"> Ver Detalhes </a></li>
                                <li><a href="#"> Editar </a></li>
                                <li><a href="#"> Excluir </a></li>
                            </ul>
                        </div>
                    </td>

                </tr>
                <tr>
                    <td colspan="4" align="center">
                        <a href="add-pizza" class="btn btn-default" style="width: 400px"> Adicionar Pizza </a>
                        <a href="add-bebida" class="btn btn-default" style="width: 400px"> Adicionar Bebida </a>
                    </td>
                </tr>

            </table>

        <div class="col-md-6">
            <div class="form-group">
                <label for="nomecli"> Nome do Cliente </label>
                <input type="text" class="form-control" name="nomecli" id="nomecli">
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group">
                <label for="telcli"> Telefone </label>
                <input type="number" class="form-control" name="telcli" id="telcli">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="bairrocli"> Bairro </label>
                <input type="text" class="form-control" name="bairrocli" id="bairrocli">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="ruacli"> Rua </label>
                <input type="text" class="form-control" name="ruacli" id="ruacli">
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="numerocli"> Nº </label>
                <input type="number" class="form-control" name="numerocli" id="numerocli">
            </div>
        </div>


        <div class="col-md-12" style="margin-bottom: 20px">
            <div class="form-row">
                <label for="totalvalue">Valor Total</label>
                <div class="input-group">
                    <span class="input-group-addon">R$</span>
                    <input type="number" value="1000" min="1" step="any" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="totalvalue" disabled="disabled"/>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group">
                <label for="formaDepagamento"> Forma de Pagamento </label>
                <select class="form-control" name="formaDepagamento" id="formaDepagamento">
                    <option value="0"> Cartão </option>
                    <option value="1"> Dinheiro </option>
                </select>
            </div>
        </div>

        <%--<div class="col-md-6">--%>
            <%--<div id="bandeira-div">--%>
                <%--<div class="form-group">--%>
                    <%--<label for="bandeira"> Bandeira </label>--%>
                    <%--<select class="form-control" name="bandeira" id="bandeira">--%>
                        <%--<option value="0"> Mastercard </option>--%>
                        <%--<option value="1">  Visa </option>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div id="troco-div" style="display: none">--%>
                <%--<label for="troco">Troco necessário</label>--%>
                <%--<div class="input-group">--%>
                    <%--<span class="input-group-addon">R$</span>--%>
                    <%--<input type="number" value="0" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="troco" />--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>


        <div class="col-md-6" id="bandeira-div">
            <div class="form-group">
                <label for="bandeira"> Bandeira </label>
                <select class="form-control" name="bandeira" id="bandeira">
                    <option value="0"> Mastercard </option>
                    <option value="1">  Visa </option>
                </select>
            </div>
        </div>

        <div class="col-md-6" id="troco-div" style="display: none">
            <div class="form-group">
                <label for="troco">Troco necessário</label>
                <div class="input-group">
                    <span class="input-group-addon">R$</span>
                    <input type="number" value="0" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="troco" />
                </div>
            </div>
        </div>


        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <a href="/" class="btn btn-danger" style="width: 100%"> Cancelar Pedido </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button class="btn btn-primary" style="width: 100%"> Finalizar Pedido </button>
        </div>

    </div>
    <div class="panel-footer"> @TCC/SPRING - Iago Machado </div>


<%@ include file="templates/footer.jsp"%>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="js/pcsFormatNumber.jquery.js"></script>

    <script>

        $(document).on("change", "#formaDepagamento", function(){
            if(this.value == "0"){
                $("#bandeira-div").css("display", "block");
                $("#troco-div").css("display", "none");
            }
            if(this.value == "1"){
                $("#bandeira-div").css("display", "none");
                $("#troco-div").css("display", "block");
            }
        });

    </script>