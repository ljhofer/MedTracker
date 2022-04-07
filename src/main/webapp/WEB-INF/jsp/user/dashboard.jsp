<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<div class="accordion col-4" id="medicationAccordion">
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












<%--    <div class="card col-4" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">${med.medName}</h5>--%>
<%--            <h6 class="card-subtitle mb-2 text-muted">${med.medPurpose}</h6>--%>
<%--            <p class="card-text">${med.frequency}</p>--%>
<%--            <p class="card-text">${med.dosage}</p>--%>
<%--        </div>--%>
<%--    </div>--%>

<jsp:include page="../include/footer.jsp" />