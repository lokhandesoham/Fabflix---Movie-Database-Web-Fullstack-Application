$(document).ready(function() {

    $('#checkout_button').click(function() {
        window.location.href = 'cart.html';
    });

    
    const queryParams = new URLSearchParams(window.location.search);
    const movieTitlesString = queryParams.get('movieTitles');
    const movieCountsString = queryParams.get('movieCounts');
    const totalPriceString = queryParams.get('totalPrice');

    const movieTitles = JSON.parse(movieTitlesString);
    const movieCounts = JSON.parse(movieCountsString);
    const totalPrice = parseFloat(totalPriceString);
    
    // console.log("In payment page");
    // console.log("Movie Titles:", movieTitles);
    // console.log("Movie Counts:", movieCounts);
    // console.log("Total Price:", totalPrice);



    // Update total price on the page
    $('#total_price').text('$' + totalPrice.toFixed(2));

    // Event listener for Place Order button click
    $('#place_order_button').click(function(event) {
        event.preventDefault(); // Prevent default form submission


        const queryParams = new URLSearchParams(window.location.search);
        const movieTitlesString = queryParams.get('movieTitles');
        const movieCountsString = queryParams.get('movieCounts');
        const totalPriceString = queryParams.get('totalPrice');

        // const movieTitles = JSON.parse(movieTitlesString);
        // const movieCounts = JSON.parse(movieCountsString);
        const totalPrice = parseFloat(totalPriceString);
        
        console.log("In payment page");
        console.log("Movie Titles:", movieTitlesString);
        console.log("Movie Counts:", totalPriceString);
        console.log("Total Price:", totalPrice);

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
            movieTitles: movieTitlesString,
            movieCounts: movieCountsString,
            firstName: firstName,
            lastName: lastName,
            creditCardNumber: creditCardNumber,
            expirationDate: expirationDate,
            total: totalPrice
        };

        function generateConfirmationSection(urlString) {

            console.log("in generate");
            const saleDetails = urlString.split('||');
        
            saleDetails.forEach((saleDetail, index) => {
                console.log(saleDetail);
                const saleInfo = saleDetail.split(',,,');
        
                const saleId = saleInfo[0].split('-')[1];
                console.log("sid -",saleId);
                const movie = saleInfo[1].split('-')[1];
                console.log(movie);
                const quantity = saleInfo[2].split('-')[1];
                console.log(quantity);
                const price = saleInfo[3].split('-')[1];
                console.log(price);
               
        
                const confirmationItem = `
                <div class="confirmation-item">
                    <p style="display: inline;"><strong>Sale ID:</strong> ${saleId} | </p>
                    <p style="display: inline;"><strong>Movie:</strong> ${movie} | </p>
                    <p style="display: inline;"><strong>Quantity:</strong> ${quantity} | </p>
                    <p style="display: inline;"><strong>Price:</strong> $${price}</p>
                </div>
                `;

                
        
                $('#confirmation_section').append(confirmationItem);
            });

            
        }

        // Send POST request using AJAX
        $.ajax({
            url: 'process_order', // URL to handle the order processing
            type: 'POST',
            data: data,
            success: function(response) {
                // Handle successful response, e.g., show confirmation message
                const url = response["param"];
                const total = response["total"];
                console.log("url", url);
                $("#payment_error_message").text(response["message"]);
                console.log('Order processed successfully:', response["message"]);
                if(!response["message"])
                {
                    $("#payment_error_message").text("");
                    generateConfirmationSection(url);
                    $("#total").text("Total: "+ response["total"]);
                }

                  
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