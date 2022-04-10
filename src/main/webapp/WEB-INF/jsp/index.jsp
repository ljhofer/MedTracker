<jsp:include page="include/header.jsp" />

<h1 id="title">MedTracker</h1>
<h2 id="sub-title">Easing the pain of medication management.</h2>

<!-- Login form -->
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <!-- <div class="col-12 col-lg-9 col-xl-7"> -->
            <div class="col-6">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <form class="card-body p-2" id="loginForm">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Log In</h3>

                            <!-- Email -->
                            <div class="row">
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="email" id="emailInput" class="form-control form-control-lg" required />
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
                                        <input type="password" id="passwordInput" class="form-control form-control-lg" required />
                                        <label class="form-label" for="passwordInput">Password</label>
                                        <div class="invalid-feedback">
                                            Please enter a password.
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 mb-4">
                                        <h6 class="mb-2 pb-1">User Type: </h6>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                   id="admin" value="option1"
                                            />
                                            <label class="form-check-label" for="admin">Admin</label>
                                        </div>

                                        <div class="form-check form-check-inline">
                                            <input
                                                    class="form-check-input" type="radio" name="inlineRadioOptions"
                                                    id="user" value="option2" checked />
                                            <label class="form-check-label" for="user">User</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                        </div>
                                    </div>

                                    <div class="col-md-3 mt-4 pt-2">
                                        <input class="btn btn-secondary btn-md" type="submit" value="Submit" />
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

<jsp:include page="include/footer.jsp" />