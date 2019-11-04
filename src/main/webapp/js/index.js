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

function logout() {
    $.post("logout");
    window.location.replace("index.jsp");
}

function save() {
    var inPageValue = Array.prototype.slice.call(document.getElementsByName("editable"));


    var jsonInfo = {
        nome: inPageValue[0].value,
        cognome: inPageValue[1].value,
        codiceFiscale: inPageValue[2].value,
        dataDiNascita: inPageValue[3].value
    }
    console.log(JSON.stringify(jsonInfo));

    $.post({
        url: "editProfile",
        datatype: "json",
        data: {
            jsonUserInfo: JSON
                .stringify(jsonInfo)
        }
    });

}
