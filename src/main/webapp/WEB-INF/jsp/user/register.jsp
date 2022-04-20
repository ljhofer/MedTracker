<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 id="title"  >MedTracker</h1>
<h2 id="sub-title">Easing the pain of medication management.</h2>

<section>
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-6">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4">
                        <form id="registerForm" class="needs-validation" action="/user/registerSubmit" novalidate>
                            <input type="hidden" name="id"  value="${form.id}">
                            <h3 class="pb-3" style="padding-top: 10px">Register New User</h3>
                            <div class="row">
                                <!-- Name -->
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="userNameInput" class="form-control form-control-lg" name="name" value="${form.name}" required/>
                                        <label class="form-label" for="userNameInput">User Name</label>
                                        <div class="invalid-feedback">
                                            Please enter your name.
                                        </div>
                                        <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
                                            <div style="color: orangered;">
                                                    Username is required.
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <!-- Email -->
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="email" id="emailInput" class="form-control form-control-lg" name="email" value="${form.email}" required />
                                        <label class="email" for="emailInput">Email</label>
                                        <div class="invalid-feedback">
                                            Please enter your email.
                                        </div>
                                        <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                            <div style="color: orangered;">
                                                    Email is required.
                                            </div>
                                        </c:forEach>
                                    </div>

                                </div>
                            </div>


                            <div class="row">
                                <!-- Password -->
                                <div class="col-md-6 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="passwordInput" class="form-control form-control-lg" name="password" value="${form.password}" required />
                                        <label class="form-label" for="passwordInput">Password</label>
                                        <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                            <div style="color: orangered;">
                                                ${error.getDefaultMessage()}
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <!-- Confirm Password -->
                                <div class="col-md-6 pb-2">
                                    <div class="form-outline">
                                        <input type="password" onkeyup="check();" id="confirmPasswordInput" class="form-control form-control-lg" name="confirmPassword" value="${form.confirmPassword}" required/>
                                        <label class="form-label" for="confirmPasswordInput">Confirm Password</label>
                                        <div class="invalid-feedback">
                                            Please confirm your password.
                                        </div>
                                        <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                                            <div style="color: orangered;">
                                                    Password confirm is required.
                                            </div>
                                        </c:forEach>
                                        <div class="col-12 pt-2" id="message"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4 mt-2 pt-2">
                                <input class="btn btn-dark btn-md" type="submit" value="Sign Up" />
                            </div>
                            <a href="/login/login" id="sendToRegisterButton" class="redirectLink" style="margin-bottom: 15px"> <strong>Already have an account?</strong> Log in instead </a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>






<jsp:include page="../include/footer.jsp" />