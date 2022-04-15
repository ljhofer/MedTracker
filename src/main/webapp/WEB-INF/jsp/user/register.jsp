<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h1 class="mb-4 pb-2 pb-md-0 mb-md-5">Register New User</h1>

                        <form id="registerForm" class="needs-validation" action="/user/registerSubmit" novalidate>
                            <input type="hidden" name="id"  value="${form.id}">
                            <div class="row">
                                <!-- Name -->
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="userNameInput" class="form-control form-control-lg" name="name" value="${form.name}" required/>
                                        <label class="form-label" for="userNameInput">User Name</label>
                                        <div class="invalid-feedback">
                                            Please enter your name.
                                        </div>
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
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <!-- Password -->
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="passwordInput" class="form-control form-control-lg" name="password" value="${form.password}" required />
                                        <label class="form-label" for="passwordInput">Password</label>
                                        <div class="invalid-feedback">
                                            Please enter a password.
                                        </div>
                                    </div>
                                </div>

                                <!-- Confirm Password -->
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="confirmPasswordInput" class="form-control form-control-lg" name="confirmPassword" value="${form.confirmPassword}" required/>
                                        <label class="form-label" for="confirmPasswordInput">Confirm Password</label>
                                        <div class="invalid-feedback">
                                            Please confirm your password.
                                        </div>
                                    </div>
                                </div>
                            </div>

<%--                            TODO: Add in dropbox or radio buttons later--%>
<%--                            <h2>I am a:</h2>--%>
<%--                            <select class="select form-control-md" id="dropdown">--%>
<%--                                <option value="1" disabled>Choose one</option>--%>
<%--                                <option value="2">User</option>--%>
<%--                                <option value="3">Admin</option>--%>
<%--                            </select>--%>

                            <div class="col-md-3 mt-4 pt-2">
                                <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
                            </div>
                            <a href="/login/login" id="sendToRegisterButton" class="btn btn-secondary btn-md userDashboardButton" style="margin-bottom: 15px"> Log In Instead </a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>






<jsp:include page="../include/footer.jsp" />