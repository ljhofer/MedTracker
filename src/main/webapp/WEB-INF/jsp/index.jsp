<jsp:include page="include/header.jsp" />

<h1 id="title" style="margin-top: 100px" >MedTracker</h1>
<h2 id="sub-title">Easing the pain of medication management.</h2>
<h3>${user}</h3>

    <div class="container">
        <div class="row" style="margin-top: 30px">
            <div class="col-3 dashboard-div card shadow-2-strong mx-auto text-center index-div" style="padding: 30px">
                <h2>Already a user?</h2>
                <div style="margin: 20px">
                    <a href="/login/login" id="sendToLoginLink" class="btn btn-secondary btn-md indexButton" style="margin-bottom: 15px"> Log In </a>
                </div>
            </div>

            <div class="col-3 dashboard-div card shadow-2-strong mx-auto text-center index-div" style="padding: 30px">
                <h2>Need an account?</h2>
                <div style="margin: 20px">
                    <a href="/user/register" id="sendToRegisterLink" class="btn btn-secondary btn-md indexButton" style="margin-bottom: 15px"> Sign Up </a>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="include/footer.jsp" />