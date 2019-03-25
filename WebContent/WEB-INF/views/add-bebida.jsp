<%@ include file="templates/header.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicione uma bebida </div>
    <div class="panel-body">

        <div class="col-md-8">
            <div class="form-group">
                <label for="bebida"> Selecione a Bebida </label>
                <select class="form-control" name="bebida" id="bebida">
                    <option value="0"> Selecione </option>
                    <option value="coca"> Coca-Cola 2L </option>
                    <option value="guarana"> Guarana </option>
                </select>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-group">
                <label for="quantidade"> Quantidade </label>
                <input class="form-control" type="number" name="quantidade" id="quantidade" value="1">
            </div>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <a href="/add-edit-pedido" class="btn btn-danger" style="width: 100%"> Cancelar </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button class="btn btn-primary" style="width: 100%"> Adicionar Bebida </button>
        </div>

    </div>
    <div class="panel-footer"> @POC/SPRING - Iago Machado </div>
</div>

<%@ include file="templates/footer.jsp"%>