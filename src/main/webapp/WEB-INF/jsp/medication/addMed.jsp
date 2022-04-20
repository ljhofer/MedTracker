<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<container class="container py-5 col-9 card shadow-2-strong mx-auto" style="margin-top: 30px">
    <form action="/medication/addMedSubmit" id="addMedForm">
        <h2 style="color:black; margin-left: 0; margin-bottom: 20px;">Add a Medication to the Database</h2>


        <div class="input-group mb-3">
            <span class="input-group-text" id="nameInput">Medication Name</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="name" placeholder="Enter medication name">
        </div>
        <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
            <div style="color: orangered;">
                Please enter a medication name.
            </div>
            <br>
        </c:forEach>

        <div class="input-group mb-3">
            <span class="input-group-text" id="purposeInput">Purpose</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="medPurpose" placeholder="Enter medication purpose">
        </div>
        <c:forEach items="${bindingResult.getFieldErrors('medPurpose')}" var="error">
            <div style="color: orangered;">
                Please enter a medication purpose.
            </div>
            <br>
        </c:forEach>

        <div class="input-group mb-3">
            <span class="input-group-text" id="specialInstructionsInput">Special Instructions</span>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="specialInstructions" placeholder="Enter special instructions for medication ">
        </div>
        <c:forEach items="${bindingResult.getFieldErrors('specialInstructions')}" var="error">
            <div style="color: orangered;">
                Please enter any special instructions for the medication.
            </div>
            <br>
        </c:forEach>

        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-dark btn-md" type="submit" value="Submit" />
        </div>

    </form>

</container>


<jsp:include page="../include/footer.jsp" />