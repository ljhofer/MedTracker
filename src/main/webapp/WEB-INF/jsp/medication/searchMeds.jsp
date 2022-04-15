<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<container class="container py-5 col-9 card shadow-2-strong" style="margin-top: 30px">
    <form action="/medication/searchMeds" id="searchMedForm">
        <h2 style="color:black; margin-left: 0; margin-top: 0; margin-right: 20px; margin-bottom: 20px; display: inline">Search Medications</h2>
        <a href="/medication/addMed" id="adminAddMedButton" class="btn btn-secondary adminAddMedButton" style="margin-bottom: 15px"> + Add New Med</a>
        <br>
        <div class="input-group mb-3">
            <span class="input-group-text" id="nameInput">Search Medications</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="searchMed" placeholder="Enter medication name" value="${searchMed}">
        </div>

        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
        </div>


    </form>

<%--    <div class="row ">--%>
        <table class="table table-secondary" id="table-div">
            <tr class="table">
                <th scope="col" class="table-secondary">Name</th>
                <th scope="col" class="table-secondary">Purpose</th>
                <th scope="col" class="table-secondary">Special Instructions</th>
            </tr>

            <c:forEach items="${meds}" var="med">
                <tr class="table">
                    <td class="">${med.name}</td>
                    <td class="">${med.medPurpose}</td>
                    <td class="">${med.specialInstructions}</td>
                </tr>
            </c:forEach>
        </table>
<%--    </div>--%>




</container>

























<jsp:include page="../include/footer.jsp" />