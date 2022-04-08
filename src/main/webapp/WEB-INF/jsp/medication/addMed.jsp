<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<container class="container py-5 col-9 card shadow-2-strong" style="margin-top: 30px">
    <form action="" id="addMedForm">
        <h2 style="color:black; margin-left: 0; margin-top: 0;">Add A Med</h2>
        <div class="input-group mb-3" >
            <label class="input-group-text" for="addMedSelect">New Med</label>
            <select class="form-select" id="addMedSelect">
                <option selected>Choose medication...</option>
                <!-- Add forEach loop here  -->
                <option value="1">Med Choice One</option>
                <option value="2">Med Choice Two</option>
                <option value="3">Med Choice Three</option>
            </select>
        </div>

        <div class="input-group mb-3" >
            <label class="input-group-text" for="frequencySelect">Frequency</label>
            <select class="form-select" id="frequencySelect" name="frequency">
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
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="dosage" value="Enter medication amount for each dose">
        </div>

        <div class="col-md-3 mt-4 pt-2">
            <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
        </div>

    </form>

</container>













<jsp:include page="../include/footer.jsp" />