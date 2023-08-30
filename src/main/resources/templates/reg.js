
// Handle submission of the registration form
document.getElementById("registration-form").addEventListener("submit", function(e) {
    e.preventDefault();
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    // Handle registration logic here
    console.log("Name: ", name);
    console.log("Email: ", email);
    console.log("Password: ", password);
    // You can send this data to a server-side script for further processing
});