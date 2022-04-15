<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- Login form -->
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <!-- <div class="col-12 col-lg-9 col-xl-7"> -->
            <div class="col-6">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <form class="card-body p-2" action="/login/loginSubmit" method="POST" id="loginForm">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Log In</h3>

                            <!-- Email -->
                            <div class="row">
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="email" id="emailInput" class="form-control form-control-lg" name="username" required />
                                        <label class="email" for="emailInput">Email</label>
                                        <div class="invalid-feedback">
                                            Please enter an email.
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Password -->
                            <div class="row">
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="passwordInput" class="form-control form-control-lg" name="password" required />
                                        <label class="form-label" for="passwordInput">Password</label>
                                        <div class="invalid-feedback">
                                            Please enter a password.
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-3 mt-4 pt-2">
                                        <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
                                    </div>
                                    <div >
                                        <a href="/user/register" id="sendToRegisterButton" class="btn btn-secondary btn-md userDashboardButton" style="margin-bottom: 15px"> Register Instead </a>
                                    </div>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />