<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h3>Register</h3>
    <form method="post" action="register.jsp">
        First Name: <input type="text" name="firstName"/><br/><br/>
        Last Name: <input type="text" name="lastName"/><br/><br/>
        Email: <input type="text" name="email"/><br/><br/>
        Password: <input type="password" name="password"/><br/><br/>
        Date of Birth: <input type="date" name="dob"/><br/><br/>
        Role: 
        <select name="role">
            <option value="voter">Voter</option>
            <option value="admin">Admin</option>
        </select><br/><br/>
        <input type="submit" value="Register"/>
    </form>
    <br/>
    <a href="index.jsp">Home</a>
</body>
</html>
