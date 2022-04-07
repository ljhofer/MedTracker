<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<div class="container py-5 col-9 card shadow-2-strong" style="margin-top:30px">
    <h2 style="color:black; margin-left: 0; margin-top: 0;">Log Your Meds</h2>
    <div class="input-group mb-3" >
        <label class="input-group-text" for="inputGroupSelect01">My Medications</label>
        <select class="form-select" id="inputGroupSelect01">
            <option selected>Choose medication...</option>
            <option value="1">Med Choice One</option>
            <option value="2">Med Choice Two</option>
            <option value="3">Med Choice Three</option>
        </select>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="dosageInput">Dosage</span>
        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="specialInstructionsInput">Special Instructions</span>
        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="" value="">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="sideEffectInput">Side effects</span>
        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name=""  value="">
    </div>

    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="takenCheckBox" name="takenCheckBox">
        <label class="form-check-label" for="takenCheckBox">
            Med taken
        </label>
    </div>

    <div class="col-md-3 mt-4 pt-2">
        <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
    </div>

</div>

















<jsp:include page="../include/footer.jsp" />