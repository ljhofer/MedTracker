<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--    My meds accordion--%>
   <div class="container">
        <div class="row">
            <div class="col-6">
                <div class="accordion" id="medicationAccordion">
                    <h1 class="userDashboardHeader">My Medications</h1>
                    <%--                    TODO: Add in href here--%>
                    <a href="/userMed/addUserMed" class="btn btn-secondary userDashboardButton"> + Add New Med</a>
                    <c:forEach items="${meds}" var="med">
                        <div class="accordion-item">
<%--                            TODO: Make this userMed id probably--%>
                            <h2 class="accordion-header" id="${med.id}">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${med.id}" aria-expanded="true" aria-controls="collapse${med.id}">
                                    <strong>${med.medication.name}</strong>
                                </button>
                            </h2>
                            <div id="collapse${med.id}" class="accordion-collapse collapse show" aria-labelledby="heading${med.id}" data-bs-parent="#amedicationAccordion">
                                <div class="accordion-body">
                                    <strong>Purpose: </strong> ${med.medication.medPurpose}
                                    <br>
                                    <strong>Dosage:</strong> ${med.dosage}
                                    <br>
                                    <strong>Special Instructions:</strong> ${med.medication.specialInstructions}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

<%--    My logs accordion--%>
            <div class="col-6">
                <div class="accordion" id="logAccordion">
                    <h1 class="userDashboardHeader">My Logs</h1>
                    <a href="/log/addUserLog" class="btn btn-secondary userDashboardButton"> + Add New Log</a>
                    <c:forEach items="${logs}" var="log">
                    <div class="accordion-item" >
                        <h2 class="accordion-header" id="${log.id}">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseid${log.id}" aria-expanded="true" aria-controls="collapse${log.id}">
                                ${log.createdOn}
                            </button>
                        </h2>
                        <div id="collapseid${log.id}" class="accordion-collapse collapse show" aria-labelledby="heading${log.id}" data-bs-parent="#logAccordion">
                            <div class="accordion-body">
                                <strong>${log.medication.name}</strong>
                                <br>
                                <strong>Side effects:</strong> ${log.sideEffects}
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>



<jsp:include page="../include/footer.jsp" />