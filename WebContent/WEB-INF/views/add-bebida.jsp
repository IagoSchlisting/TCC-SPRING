<%@ include file="templates/header.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicionando uma bebida ao pedido ${id} </div>
    <div class="panel-body">
    <form:form id="bebidaitem" action="/pedido/bebida/add" name="bebida" method="post">
        <input name="pedido_id" type="hidden" id="pedido_id" value="${pedido_id}">
        <div class="col-md-8">
            <div class="form-group">
                <label for="bebida"> Selecione a Bebida </label>
                <select class="form-control" name="bebida" id="bebida">
                    <option value="0"> Selecione </option>
                    <c:forEach var="bebida" items="${bebidas}">
                            <option value="${bebida.id}"> ${bebida.bebida} - R$${bebida.valor} / cada. </option>
                    </c:forEach>

                </select>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="quantidade"> Quantidade </label>
                <input class="form-control" type="number" max="10" name="quantidade" id="quantidade" value="1">
            </div>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <a href="/pedido/add/${pedido_id}" class="btn btn-danger" style="width: 100%"> Cancelar </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button type="submit" class="btn btn-primary" style="width: 100%"> Adicionar Bebida </button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form:form>

    </div>
    <div class="panel-footer"> @POC/SPRING - Iago Machado </div>
</div>

<%@ include file="templates/footer.jsp"%>