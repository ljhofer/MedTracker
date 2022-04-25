<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

    <h1 style="margin: 25px; font-size: 65px" class="d-flex justify-content-center">Welcome, ${user.name}!</h1>

   <div class="container">
        <div class="row">
           <div class="col-6">
               <%--    My meds accordion--%>
                <div class="dashboard-div card p-3 ">
                    <div style="display:flex; justify-content: space-evenly">
                        <h1 class="userDashboardHeader" style="color:black">My Meds</h1>
                        <a href="/userMed/addUserMed" id="addUserMedButton" class="btn btn-dark userDashboardButton" style="margin: 10px"> + Add New Med</a>
                    </div>
                    <div class="accordion" id="medicationAccordion" style="margin-top: 20px; ">
                        <c:forEach items="${meds}" var="med">
                            <div class="accordion-item" >
                                <h2 class="accordion-header" id="${med.id}">
                                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${med.id}" aria-expanded="true" aria-controls="collapse${med.id}">
                                        <strong>${med.medication.name}</strong>
                                    </button>
                                </h2>
                                <div id="collapse${med.id}" class="accordion-collapse collapse" aria-labelledby="heading${med.id}" data-bs-parent="#amedicationAccordion">
                                    <div class="accordion-body">
                                        <strong>Purpose: </strong> ${med.medication.medPurpose}
                                        <br>
                                        <strong>Dosage:</strong> ${med.dosage}
                                        <br>
                                        <strong>Frequency:</strong> Every ${med.frequency} hour(s)
                                        <br>
                                        <strong>Special Instructions:</strong> ${med.medication.specialInstructions}
                                        <br>
                                        <br>
                                        <a href="/userMed/updateUserMed/${med.id}" class="updateMedLink">Update Med</a> &nbsp | &nbsp
                                        <a href="/userMed/removeUserMed/${med.id}" class="updateMedLink">Remove Med</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
              <%--    My previous meds accordion--%>
               <div class="dashboard-div card shadow-2-strong p-3">
                   <h1 class="userDashboardHeader" style="color:black">My Previous Meds</h1>
                   <div class="accordion" id="previousMedicationAccordion" style="margin-top: 20px; ">
                       <c:forEach items="${previousMeds}" var="previousMed">
                           <div class="accordion-item" >
                               <h2 class="accordion-header" id="${previousMed.id}">
                                   <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${previousMed.id}" aria-expanded="true" aria-controls="collapse${previousMed.id}">
                                       <strong>${previousMed.medication.name}</strong>
                                   </button>
                               </h2>
                               <div id="collapse${previousMed.id}" class="accordion-collapse collapse" aria-labelledby="heading${previousMed.id}" data-bs-parent="#amedicationAccordion">
                                   <div class="accordion-body">
                                       <strong>Dosage:</strong> ${previousMed.dosage}
                                   </div>
                               </div>
                           </div>
                       </c:forEach>
                   </div>
               </div>
        </div>

<%--    My logs accordion--%>
        <div class="col-6">
            <div class="card shadow-2-strong p-3">
                <div style="display:flex; justify-content: space-evenly">
                    <h1 class="userDashboardHeader" style="color:black; display: inline">My Logs</h1>
                    <a href="/log/addUserLog" id="addUserLogButton" class="btn btn-dark userDashboardButton" style="margin: 10px"> + Add New Log</a>
                </div>
                <div class="accordion" id="logAccordion" style="margin-top: 20px">
                    <c:forEach items="${logs}" var="log">
                    <div class="accordion-item" >
                        <h2 class="accordion-header" id="${log.id}">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseid${log.id}" aria-expanded="true" aria-controls="collapse${log.id}">
                                <strong>${log.medication.name}</strong>
                            </button>
                        </h2>
                        <div id="collapseid${log.id}" class="accordion-collapse collapse" aria-labelledby="heading${log.id}" data-bs-parent="#logAccordion">
                            <div class="accordion-body">
                                <strong><fmt:formatDate value="${log.createdOn}" pattern="MM/dd/yy hh:mm aa" /></strong>
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
    </div>



<jsp:include page="../include/footer.jsp" />