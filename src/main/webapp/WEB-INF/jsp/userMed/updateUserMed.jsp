<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<container class="container py-5 col-6 card shadow-2-strong" style="margin-top: 30px">
    <form action="/userMed/updateUserMedSubmit" id="updateUserMedForm">
        <input type="hidden" name="id"  value="${userMed.id}">
        <input type="hidden" name="medId"  value="${userMed.medication.id}">
        <h2 style="color:black; margin-left: 0; margin-top: 0;">Update A Med</h2>
        <div class="input-group mb-3">
            <span class="input-group-text" id="medToUpdate">Medication Name</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" readonly value="${userMed.medication.name}" readonly>
        </div>

        <div class="input-group mb-3" >
            <label class="input-group-text" for="frequencySelect">Frequency</label>
            <select class="form-select" id="frequencySelect" name="frequency" >
                <option selected>Update frequency...</option>
                <option value="${userMed.frequency}">Currently taking every ${userMed.frequency} hour(s)</option>
                <option value="1">Every 1 hour</option>
                <option value="2">Every 2 hours</option>
                <option value="3">Every 3 hours</option>
                <option value="4">Every 4 hours</option>
                <option value="6">Every 6 hours</option>
                <option value="8">Every 8 hours</option>
                <option value="12">Every 12 hours</option>
                <option value="24">Every 24 hours</option>
            </select>
        </div>
        <c:forEach items="${bindingResult.getFieldErrors('frequency')}" var="error">
            <div style="color: orangered;">
                Frequency is required.
            </div>
        </c:forEach>

        <div class="input-group mb-3">
            <span class="input-group-text" id="dosageInput">Dosage</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="dosage" value="${userMed.dosage}">
        </div>
        <c:forEach items="${bindingResult.getFieldErrors('dosage')}" var="error">
            <div style="color: orangered;">
                Dosage is required.
            </div>
        </c:forEach>

<%--        Button for submitting userMed changes--%>
        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="submit" value="Update Med" />
        </div>

<%--        Button for deleting userMed--%>
        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="" value="Delete Med" />
        </div>

    </form>

</container>


<jsp:include page="../include/footer.jsp" />