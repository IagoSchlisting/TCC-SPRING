<%@ include file="templates/header.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicione uma pizza </div>
    <div class="panel-body">

        <div class="col-md-12">
            <div class="col-md-8">
                <div class="form-group">
                    <label for="tamanhopizza"> Tamanho da Pizza </label>
                    <select class="form-control" name="tamanhopizza" id="tamanhopizza">
                        <option value="gigante"> Gigante </option>
                        <option value="grande"> Grande </option>
                        <option value="media"> Média </option>
                        <option value="broto"> Broto </option>
                    </select>
                </div>
            </div>


            <div class="col-md-4">
                <div class="form-check" style="margin: 30px">
                    <input class="form-check-input" type="checkbox" value="1" id="borda">
                    <label class="form-check-label" for="borda">
                        Com borda
                    </label>
                </div>
            </div>
        </div>

        <div class="col-md-12">

            <div class="col-md-6">
                <div class="form-check">
                    <label for="sabor1"> Sabor 1 </label>
                    <select class="form-control sabor" name="sabor1" id="sabor1">
                        <option value="0" selected="selected"> Selecione um Sabor </option>
                        <c:forEach var="sabor" items="${sabores}">
                            <option value="${sabor.id}"> ${sabor.sabor} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-check">
                    <label for="sabor2"> Sabor 2 </label>
                    <select class="form-control sabor" name="sabor2" id="sabor2">
                        <option value="0" selected="selected"> Selecione um Sabor </option>
                        <c:forEach var="sabor" items="${sabores}">
                            <option value="${sabor.id}"> ${sabor.sabor} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="col-md-12" style="margin-top: 20px">

            <div class="col-md-6">
                <div class="form-check">
                    <label for="sabor3"> Sabor 3 </label>
                    <select class="form-control sabor" name="sabor3" id="sabor3">
                        <option value="0" selected="selected"> Selecione um Sabor </option>
                        <c:forEach var="sabor" items="${sabores}">
                            <option value="${sabor.id}"> ${sabor.sabor} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-check">
                    <label for="sabor4"> Sabor 4 </label>
                    <select class="form-control sabor" name="sabor4" id="sabor4">
                        <option value="0" selected="selected"> Selecione um Sabor </option>
                        <c:forEach var="sabor" items="${sabores}">
                            <option value="${sabor.id}"> ${sabor.sabor} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <a href="/add-edit-pedido" class="btn btn-danger" style="width: 100%"> Cancelar </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button class="btn btn-primary" style="width: 100%"> Adicionar Pizza </button>
        </div>


    </div>
    <div class="panel-footer"> @POC/SPRING - Iago Machado </div>
</div>

<%@ include file="templates/footer.jsp"%>

<script>

    $(document)
        .on("change", "#tamanhopizza", function(){
            if(this.value == "gigante"){
                $(".sabor").prop("disabled", false);
            }

            if(this.value == "grande"){
                $(".sabor").prop("disabled", false);
                $("#sabor4").prop("disabled", true);

            }

            if(this.value == "media"){
                $(".sabor").prop("disabled", false);
                $("#sabor3").prop("disabled", true);
                $("#sabor4").prop("disabled", true);
            }
            if(this.value == "broto"){
                $(".sabor").prop("disabled", true);
                $("#sabor1").prop("disabled", false);
            }


        });
</script>