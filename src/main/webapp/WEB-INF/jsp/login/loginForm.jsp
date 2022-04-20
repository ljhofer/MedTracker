<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 id="title" >MedTracker</h1>
<h2 id="sub-title">Easing the pain of medication management.</h2>

<!-- Login form -->
<section>
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-5">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4">
                        <form class="card-body p-3" action="/login/loginSubmit" method="POST" id="loginForm">
                            <h2 class="pb-3">Log In</h2>

                            <!-- Email -->
                            <div class="row">
                                <div class="">
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
                                <div class="">
                                    <div class="form-outline">
                                        <input type="password" id="passwordInput" class="form-control form-control-lg" name="password" required />
                                        <label class="form-label" for="passwordInput">Password</label>
                                        <div class="invalid-feedback">
                                            Please enter a password.
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-4 mt-2 pt-2">
                                        <input class="btn btn-dark btn-md" type="submit" value="Log In" />
                                    </div>
                                    <div >
                                        <a href="/user/register" id="sendToRegisterButton" class="redirectLink" style="margin-bottom: 15px"> <strong>New here?</strong> Register instead  </a>
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

<%--extra comment--%>