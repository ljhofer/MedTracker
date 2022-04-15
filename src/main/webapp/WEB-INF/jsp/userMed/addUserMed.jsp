<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<container class="container py-5 col-6 card shadow-2-strong" style="margin-top: 30px">
    <form action="/userMed/addUserMedSubmit" id="addMedForm">
<%--        TODO: Make this userMed id probably--%>
        <input type="hidden" name="id"  value="${form.id}">
        <h2 style="color:black; margin-left: 0; margin-top: 0;">Add A Med</h2>
        <div class="input-group mb-3" >
            <label class="input-group-text" for="addMedSelect">Med Name</label>
            <select class="form-select" id="addMedSelect" name="medId">
                <option selected>Choose medication...</option>
                <!-- Iterates over each med to populate the dropdown  -->
                <c:forEach items="${meds}" var="med">
                <option value="${med.id}" name="medId">${med.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="input-group mb-3" >
            <label class="input-group-text" for="frequencySelect">Frequency</label>
            <select class="form-select" id="frequencySelect" name="frequency" >
                <option selected>Choose dose frequency...</option>
                <option value="1">Every hour</option>
                <option value="2">Every 2 hours</option>
                <option value="3">Every 3 hours</option>
                <option value="4">Every 4 hours</option>
                <option value="6">Every 6 hours</option>
                <option value="8">Every 8 hours</option>
                <option value="12">Every 12 hours</option>
                <option value="24">Every 24 hours</option>
            </select>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text" id="dosageInput">Dosage</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="dosage" placeholder="Enter medication amount for each dose">
        </div>

        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
        </div>

    </form>

</container>


<jsp:include page="../include/footer.jsp" />