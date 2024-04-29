$(document).ready(function() {

    $('#checkout_button').click(function() {
        window.location.href = 'cart.html';
    });


    // Function to parse URL parameters
    function getUrlParameter(name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
        const results = regex.exec(location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    }

    // Parse movieCountMap and totalPrice from URL parameters
    const movieCountMapString = getUrlParameter('movieCountMap');
    const totalPrice = parseFloat(getUrlParameter('totalPrice'));

    // Convert movieCountMapString back to a Map object
    const movieCountMap = new Map(JSON.parse(movieCountMapString));

    console.log(movieCountMap)

    // Update total price on the page
    $('#total_price').text(`$${totalPrice.toFixed(2)}`);

    // Event listener for Place Order button click
    $('#place_order_button').click(function(event) {
        event.preventDefault(); // Prevent default form submission

        // Get form data
        const firstName = $('#first_name').val();
        const lastName = $('#last_name').val();
        const creditCardNumber = $('#credit_card_number').val();
        const expirationDate = $('#expiration_date').val();

        // You can perform further actions here such as sending the form data to a server

        // For demonstration purposes, log the form data to the console
        console.log('First Name:', firstName);
        console.log('Last Name:', lastName);
        console.log('Credit Card Number:', creditCardNumber);
        console.log('Expiration Date:', expirationDate);

        const data = {
            movieCountMapString: getUrlParameter('movieCountMap'),
            firstName: firstName,
            lastName: lastName,
            creditCardNumber: creditCardNumber,
            expirationDate: expirationDate,
            total: parseFloat(getUrlParameter('totalPrice'))
        };

        // Send POST request using AJAX
        $.ajax({
            url: 'process_order', // URL to handle the order processing
            type: 'POST',
            data: data,
            success: function(response) {
                // Handle successful response, e.g., show confirmation message
                
                $("#payment_error_message").text(response["message"]);
                console.log('Order processed successfully:', response["message"]);
                  
            },
            error: function(xhr, status, error) {
                console.error('Error processing order:', xhr.responseText);
                // Handle error response, e.g., show error message to the user
            }
        });
    });

        // Optionally, redirect the user to a confirmation page or perform other actions
        // window.location.href = 'confirmation.html';
});

