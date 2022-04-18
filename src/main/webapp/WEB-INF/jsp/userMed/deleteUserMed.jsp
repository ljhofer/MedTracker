<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<container class="container py-5 col-6 card shadow-2-strong" style="margin-top: 30px">
    <form action="/userMed/updateUserMedSubmit" id="updateUserMedForm">
        <input type="hidden" name="id"  value="${userMed.id}">
        <input type="hidden" name="medId"  value="${userMed.medication.id}">
        <h2 style="color:black; margin-left: 0; margin-top: 0;">Delete A Med</h2>
        <div class="input-group mb-3">
            <span class="input-group-text" id="medToDelete">Medication Name</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" readonly value="${userMed.medication.name}" readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text" id="dosageInput">Dosage</span>
            <input type="text" id="dosageOutput" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="${med.dosage}" readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text" id="specialInstructionsInput">Special Instructions</span>
            <input type="text"  id="specialInstructionsOutput" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="${med.medication.special_instructions}" readonly>
        </div>

        <%--        Button for submitting userMed changes--%>
        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="submit" value="Delete Med" />
        </div>



    </form>

</container>




















<jsp:include page="../include/footer.jsp" />