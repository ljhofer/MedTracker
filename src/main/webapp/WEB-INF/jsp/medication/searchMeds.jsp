<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<container class="container py-5 col-9 card shadow-2-strong mx-auto" style="margin-top: 30px">
    <form action="/medication/searchMeds" id="searchMedForm">
        <h2 style="color:black; margin-left: 0; margin-top: 0; margin-right: 20px; margin-bottom: 20px; display: inline">Search Medications</h2>
        <a href="/medication/addMed" id="adminAddMedButton" class="btn btn-dark adminAddMedButton" style="margin-bottom: 15px"> + Add New Med</a>
        <br>
        <div class="input-group mb-3" style="margin-top: 20px">
            <span class="input-group-text" id="nameInput">Search Medications</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="searchMed" placeholder="Enter medication name" value="${searchMed}">
        </div>

        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-dark btn-md" type="submit" value="Search" />
        </div>
        <br>


    </form>

<%--    <div class="row ">--%>
        <c:if test="${not empty searchMed}">
            <h5 style="margin-left: 5px">Search found ${meds.size()} result(s) </h5>
        </c:if>
        <table class="table table-secondary table-striped" id="table-div">
            <tr class="table">
                <th scope="col" class="table-secondary">Name</th>
                <th scope="col" class="table-secondary">Purpose</th>
                <th scope="col" class="table-secondary">Special Instructions</th>
            </tr>

            <c:forEach items="${meds}" var="med">
                <tr class="table">
                    <td class=""><strong>${med.name}</strong></td>
                    <td class="">${med.medPurpose}</td>
                    <td class="">${med.specialInstructions}</td>
                </tr>
            </c:forEach>
        </table>
<%--    </div>--%>




</container>

























<jsp:include page="../include/footer.jsp" />