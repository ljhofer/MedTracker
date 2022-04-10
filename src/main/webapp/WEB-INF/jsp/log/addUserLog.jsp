<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<div class="container py-5 col-9 card shadow-2-strong" style="margin-top:30px">
    <h2 style="color:black; margin-left: 0; margin-top: 0;">Log Your Meds</h2>
        <form action="/log/addUserLogSubmit" id="addLogForm">
            <div class="input-group mb-3" >
                <label class="input-group-text" for="inputGroupSelect01">My Medications</label>
                <select class="form-select" name="medId" id="inputGroupSelect01">
                    <option selected>Choose medication...</option>
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}" name="medId">${med.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="dosageInput">Dosage</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" readonly name="" value="${med.dosage}" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="specialInstructionsInput">Special Instructions</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="${med.special_instructions}" readonly>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="sideEffectInput">Side effects</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="sideEffects"  value="Enter any side effects you have noticed since your last dose">
            </div>

            <div class="col-md-3 mt-4 pt-2">
                <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
            </div>
        </form>
</div>

















<jsp:include page="../include/footer.jsp" />