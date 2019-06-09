<%@ include file="templates/header.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Adicionando uma pizza ao pedido ${pedido_id} </div>
    <div class="panel-body">
        <form:form id="pizzaitem" action="/pizza/add" name="pizza" method="post">
        <input name="pedido_id" type="hidden" id="pedido_id" value="${pedido_id}">
        <div class="col-md-12">
            <div class="col-md-8">
                <div class="form-group">
                    <label for="tamanhopizza"> Tamanho da Pizza </label>
                    <select class="form-control" name="tamanhopizza" id="tamanhopizza">
                        <option value="GIGANTE"> Gigante </option>
                        <option value="GRANDE"> Grande </option>
                        <option value="MEDIA"> Media </option>
                        <option value="BROTO"> Broto </option>
                    </select>
                </div>
            </div>


            <div class="col-md-4">
                <div class="form-check" style="margin: 30px">
                    <input class="form-check-input" type="checkbox" name="borda" value="1" id="borda">
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
            <a href="/pedido/add" class="btn btn-danger" style="width: 100%"> Cancelar </a>
        </div>

        <div class="col-md-6" style="margin-top: 20px;" align="right">
            <button type="submit" class="btn btn-primary" style="width: 100%"> Adicionar Pizza </button>
        </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form:form>

    </div>
    <div class="panel-footer"> @POC/SPRING - Iago Machado </div>
</div>

<%@ include file="templates/footer.jsp"%>

<script>


    $(document)
        .on("change", "#tamanhopizza", function(){
            if(this.value == "GIGANTE"){
                $(".sabor").show();
                $("#borda").prop("disabled", false);
            }

            if(this.value == "GRANDE"){
                $(".sabor").show();
                $("#borda").prop("disabled", false);

            }

            if(this.value == "MEDIA"){
                $(".sabor").show();
                $("#sabor4").hide();
                $("#borda").prop("disabled", true);
            }
            if(this.value == "BROTO"){
                $(".sabor").show();
                $("#sabor3").hide();
                $("#sabor4").hide();
                $("#borda").prop("disabled", true);
            }


        });

    // $(document)
    //     .on("change", "#tamanhopizza", function(){
    //         if(this.value == "GIGANTE"){
    //             $(".sabor").prop("disabled", false);
    //         }
    //
    //         if(this.value == "GRANDE"){
    //             $(".sabor").prop("disabled", false);;
    //
    //         }
    //
    //         if(this.value == "MEDIA"){
    //             $(".sabor").prop("disabled", false);
    //             $("#sabor4").prop("disabled", true);
    //             $("#borda").prop("disabled", true);
    //         }
    //         if(this.value == "BROTO"){
    //             $(".sabor").prop("disabled", false);
    //             $("#sabor3").prop("disabled", true);
    //             $("#sabor4").prop("disabled", true);
    //             $("#borda").prop("disabled", true);
    //         }
    //     });
</script>