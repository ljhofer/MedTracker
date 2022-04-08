<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--    My meds accordion--%>
   <div class="container">
        <div class="row">
            <div class="col-6">
                <div class="accordion" id="medicationAccordion">
                    <h1 class="userDashboardHeader">My Medications</h1>
                    <a href="contact_us.html" class="btn btn-secondary"> + Add a new med</a>
                    <c:forEach items="${meds}" var="med">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="${med.id}">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${med.id}" aria-expanded="true" aria-controls="collapse${med.id}">
                                    ${med.name}
                                </button>
                            </h2>
                            <div id="collapse${med.id}" class="accordion-collapse collapse show" aria-labelledby="heading${med.id}" data-bs-parent="#amedicationAccordion">
                                <div class="accordion-body">
                                    <strong>${med.medPurpose}</strong>
                                    <br>
                                    ${med.specialInstructions}
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
                    <a href="" class="btn btn-secondary"> + Add a new log</a>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="1">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse1" aria-expanded="true" aria-controls="collapse${log.id}">
                                    Date
                            </button>
                        </h2>
                        <div id="collapse1" class="accordion-collapse collapse show" aria-labelledby="heading${log.id}" data-bs-parent="#logAccordion">
                            <div class="accordion-body">
                                <strong>Medication Name</strong>
                                <br>
                                    This is a side effect
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



<%--// Log accordions with JSTL--%>

<%--    <div class="accordion col-4" id="logAccordion">--%>
<%--        <h1 class="userDashboardHeader">My Logs</h1>--%>
<%--        <c:forEach items="${logs}" var="log">--%>
<%--            <div class="accordion-item">--%>
<%--                <h2 class="accordion-header" id="${log.id}">--%>
<%--                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${log.id}" aria-expanded="true" aria-controls="collapse${log.id}">--%>
<%--                            ${log.timestamp}--%>
<%--                    </button>--%>
<%--                </h2>--%>
<%--                <div id="collapse${log.id}" class="accordion-collapse collapse show" aria-labelledby="heading${log.id}" data-bs-parent="#logAccordion">--%>
<%--                    <div class="accordion-body">--%>
<%--                        <strong>${log.medId.name}</strong>--%>
<%--                        <br>--%>
<%--                            ${log.side_effects}--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>











<%--    <div class="card col-4" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">${med.medName}</h5>--%>
<%--            <h6 class="card-subtitle mb-2 text-muted">${med.medPurpose}</h6>--%>
<%--            <p class="card-text">${med.frequency}</p>--%>
<%--            <p class="card-text">${med.dosage}</p>--%>
<%--        </div>--%>
<%--    </div>--%>

<jsp:include page="../include/footer.jsp" />