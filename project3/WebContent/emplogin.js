let login_form = $("#login_form");

let recaptchaWidgetId;

function onRecaptchaLoad() {
    recaptchaWidgetId = grecaptcha.render('recaptcha-container', {
        'sitekey' : '6Le3i9UpAAAAACWv0e1HMS5JMLJwtsu31iCUUua8'
    });
}


/**
 * Handle the data returned by LoginServlet
 * @param resultDataString jsonObject
 */
function handleLoginResult(resultDataJson) {
    console.log("handle login response1");
    
    
    console.log("handle login response2");
    console.log(resultDataJson);
    console.log(resultDataJson["status"]);

    // If login succeeds, it will redirect the user to main.html
    if (resultDataJson["status"] === "success") {
        console.log("innnn");
        window.location.replace("dashboard.html");
    } else {
        // If login fails, the web page will display 
        // error messages on <div> with id "login_error_message"
        console.log("show error message");
        console.log(resultDataJson["message"]);
        $("#login_error_message").text(resultDataJson["message"]);
        grecaptcha.reset(recaptchaWidgetId);
        
    }
}

/**
 * Submit the form content with POST method
 * @param formSubmitEvent
 */
function submitLoginForm(formSubmitEvent) {
    console.log("submit login form");
    /**
     * When users click the submit button, the browser will not direct
     * users to the url defined in HTML form. Instead, it will call this
     * event handler when the event is triggered.
     */
    formSubmitEvent.preventDefault();

    $.ajax(
        "emplogin", {
            method: "POST",
            // Serialize the login form to the data sent by POST request
            data: login_form.serialize(),
            success: handleLoginResult
        }
    );
}

// Bind the submit action of the form to a handler function
login_form.submit(submitLoginForm);

