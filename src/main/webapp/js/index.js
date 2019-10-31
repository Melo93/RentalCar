function login() {

    var username = $("#username").val();
    var password = $("#password").val();

    console.log(username + " " + password);

    $.ajax({
        type: "POST",
        url: "login",
        data: {
            "Username": username,
            "Password": password
        },

        success: function () {
            window.location.href = "index.jsp";

        },

        error: function () {
            $("#login-result").html(
                "<div class=\"alert alert-danger\" role=\"alert\">Password o Username errati.</div>");
        }
    });
}