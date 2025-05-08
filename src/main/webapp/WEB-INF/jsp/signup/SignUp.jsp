
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Activedo - Sign Up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body { background-color: #f4f6f9; }
        .signup-container { max-width: 500px; margin: 50px auto; }
        .card { padding: 20px; border-radius: 10px; box-shadow: 0 0 20px rgba(0,0,0,0.1); }
        .form-control { margin-bottom: 15px; }
        .error-message { color: red; font-size: 0.875rem; }
    </style>
    <script src="${pageContext.request.contextPath}pub/js/script.JS"></script>
</head>
<body>

<div class="container signup-container">
    <div class="card">
        <div class="card-body">
            <h2 class="text-center mb-4">Sign-Up Now</h2>
            <div id="client-errors"></div>
            <form method="post" action="https://${pageContext.request.serverName}${pageContext.request.contextPath}/submitsignup">

                <div class="mb-3">
                    <label for="Username" class="form-label">Username</label>
                    <input type="text" name="email" id="Username" class="form-control" value="${form.email}" required>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" id="password" class="form-control" value="${form.password}" required>
                </div>

                <div class="mb-3">
                    <label for="FullName" class="form-label">Full Name</label>
                    <input type="text" name="full_name" id="FullName" class="form-control" value="${form.full_name}" required>
                </div>

                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <input type="text" name="gender" id="gender" class="form-control" value="${form.gender}" required>
                </div>

                <div class="mb-3">
                    <label for="age" class="form-label">Age</label>
                    <input type="number" name="age" id="age" class="form-control" value="${form.age}" required>
                </div>

                <button type="submit" class="btn btn-primary w-100">Sign-Up</button>

                <div class="mt-3 text-center">
                    <a href="https://${pageContext.request.serverName}${pageContext.request.contextPath}/login">Already have an account? Login</a>
                </div>

                <div class="mt-2 text-center">
                    <a href="https://${pageContext.request.serverName}${pageContext.request.contextPath}/index">Home Page</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
