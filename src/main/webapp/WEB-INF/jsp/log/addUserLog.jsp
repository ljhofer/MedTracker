<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<script>
    $( document ).ready(function() {
        $( "#medicationSelect" ).on( "change", function() {
            let chosenMedId = $( "#medicationSelect" ).val();
            $.ajax({
                url : '/ajaxRequest',
                type : 'GET',
                data : {
                    'chosenMedId' : chosenMedId
                },
                success : function(data) {
                    $( "#dosageOutput" ).val(data[0]);
                    $( "#specialInstructionsOutput" ).val(data[1]);
                },
                error : function(request,error)
                {
                    console.log("error = " + error + "  " + request)
                }
            });
        });
    });
</script>


<div class="container py-5 col-9 card shadow-2-strong" style="margin-top:30px">
    <h2 style="color:black; margin-left: 27px; margin-top: 0; margin-bottom: 25px;">Log Your Meds</h2>
        <form action="/log/addUserLogSubmit" id="addLogForm">
            <div class="input-group mb-3" >
                <label class="input-group-text" for="medicationSelect">My Medications</label>
                <select class="form-select" name="medId" id="medicationSelect">
                    <option selected>Choose medication...</option>
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.medication.id}" name="medId">${med.medication.name}</option>
                    </c:forEach>
                </select>

            </div>
            <c:forEach items="${bindingResult.getFieldErrors('medId')}" var="error">
                <div style="color: orangered;">
                    Please select a medication
                </div>
                <br>
            </c:forEach>
            <div class="input-group mb-3">
                <span class="input-group-text" id="dosageInput">Dosage</span>
                <input type="text" id="dosageOutput" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="${med.dosage}" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="specialInstructionsInput">Special Instructions</span>
                <input type="text"  id="specialInstructionsOutput" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="${med.medication.special_instructions}" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="sideEffectInput">Side effects</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="sideEffects"  placeholder="Enter any side effects you have noticed since your last dose">
            </div>

            <div class="col-md-3 mt-4 pt-2">
                <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
            </div>
        </form>
        <h2 ></h2>
</div>






<jsp:include page="../include/footer.jsp" />