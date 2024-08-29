<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>An Error Occurred</h1>
<p>We're sorry, but something went wrong.</p>
<p>Status Code: ${status}</p>
<p>Message: ${message}</p>
<p>Exception: ${exception}</p>
<p>Request URI: ${path}</p>
<p><a href="/">Go to Home</a></p>
</body>
</html>
