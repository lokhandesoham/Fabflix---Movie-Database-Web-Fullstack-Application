$(document).ready(function() {
    // Function to fetch cart data from CartServlet and update the cart table in HTML
    function fetchCartData() {
        $.ajax({
            url: 'cart', // URL to CartServlet
            type: 'GET',
            success: function(response) {
                // Parse the JSON response
                console.log("In fetchCartData");
                const cartData = JSON.parse(response);


                const movieCountMap = new Map();
                cartData.previous_movies.forEach(movie => {
                    movieCountMap.set(movie, (movieCountMap.get(movie) || 0) + 1);
                });

                const movieTitles = [];
                const movieCounts = [];
                movieCountMap.forEach((count, title) => {
                    movieTitles.push(title); // Add movie title to the movieTitles array
                    movieCounts.push(count); // Add movie count to the movieCounts array
                });

                // Update the cart table body with retrieved cart items
                const cartBody = $('#cart_body');
                cartBody.empty(); // Clear existing items

                movieCountMap.forEach((count, movie) => {
                    // const row = `<tr>
                    //     <td>${movie}</td>
                    //     <td>${count}</td>
                    //     <td>$10.00</td> <!-- Sample price, you can modify this -->
                    //     <td>$${(count * 10).toFixed(2)}</td> <!-- Sample total, you can modify this -->
                    //     <td><button class="remove_item_button">Remove</button></td>
                    // </tr>`;
                    var row = $('<tr>');
                        row.append($('<td>').text(movie));
                        row.append($('<td>').text(count));
                        row.append($('<td>').text("$10"));
                        row.append($('<td>').text("$"+(count * 10).toFixed(2)));
                        //row.append($('<td>').append($('<button>').addClass('remove_item_button').text('Remove')));

                        const addButton = $('<button>').addClass('quantity_button').data('type', 'plus').text('+');
                        const minusButton = $('<button>').addClass('quantity_button').data('type', 'minus').text('-');

                        row.append($('<td>').append(addButton).append(minusButton));
   
                        row.append($('<td>').append($('<button>').addClass('remove_item_button').text('Remove')));

                    cartBody.append(row);
                });

                // Update total price
                const totalPriceSpan = $('#total_price');
                const totalPrice = calculateTotalPrice(cartData.previous_movies);
                totalPriceSpan.text(`$${totalPrice.toFixed(2)}`); // Format price with 2 decimal places
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    // Function to calculate total price based on cart items
    function calculateTotalPrice(cartItems) {
        let totalPrice = 0;
        // Sample price calculation based on quantity (assuming quantity is always 1 for now)
        cartItems.forEach(item => {
            totalPrice += 10; // Sample price, you can modify this
        });
        return totalPrice;
    }

    // Fetch cart data when the page loads
    fetchCartData();


    $(document).on('click', '.remove_item_button', function () {
        console.log('Removing:', movieTitle);
        // Get the corresponding movie title
        var movieTitle = $(this).closest('tr').find('td:first-child').text();
        console.log('Removing:', movieTitle);
        
        $.ajax({
            url: 'cart', // URL to CartServlet
            type: 'POST',
            data: { title: movieTitle ,
                    remove: "yes"},
            success: function(response) {
                // If successful, fetch updated cart data and refresh cart table
                fetchCartData();
            },
            error: function(xhr, status, error) {
                console.error(xhr.responsecsText);
            }
        });
    });

    $(document).on('click', '.quantity_button', function() {
        console.log('In quantity:');
        const buttonType = $(this).data('type'); // Get the button type (+ or -)
        const row = $(this).closest('tr');
        var movieTitle = $(this).closest('tr').find('td:first-child').text();

        let quantityChange;
        if (buttonType === 'plus') {
            quantityChange = 1; // Increase quantity by 1 for + button
        } else if (buttonType === 'minus') {
            quantityChange = 0; // Decrease quantity by 1 for - button
        }

        // Send AJAX POST request to update quantity in cart
        $.ajax({
            url: 'cart', // URL to CartServlet
            type: 'POST',
            data: { title: movieTitle, quantityChange: quantityChange },
            success: function(response) {
                // If successful, fetch updated cart data and refresh cart table
                fetchCartData();
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    });


   

    // Proceed to Payment button click event
    $('#proceed_to_payment').click(function() {
        const movieCountMap = new Map();
        $('#cart_body tr').each(function() {
            const title = $(this).find('td:first').text();
            const count = parseInt($(this).find('td:nth-child(2)').text());
            movieCountMap.set(title, count);
        });

        const movieTitles = [];
        const movieCounts = [];
        movieCountMap.forEach((count, title) => {
            movieTitles.push(title); // Add movie title to the movieTitles array
            movieCounts.push(count); // Add movie count to the movieCounts array
        });

        console.log("In payament proceed button");
        console.log(movieTitles);
        console.log(movieCounts);


        // Get the total price from the cart page
        const totalPrice = parseFloat($('#total_price').text().replace('$', ''));

        const queryParams = new URLSearchParams();
        queryParams.set('movieTitles', JSON.stringify(movieTitles));
        queryParams.set('movieCounts', JSON.stringify(movieCounts));
        queryParams.set('totalPrice', totalPrice);

        console.log("payment.html?$"+queryParams.toString());
        // Redirect to payment.html with query parameters
        window.location.href = `payment.html?${queryParams.toString()}`;

        console.log("Donne");


        //window.location.href = `payment.html?movieTitles=${encodeURIComponent(JSON.stringify([movieTitles]))}&movieCounts=${encodeURIComponent(JSON.stringify([movieCounts]))}&totalPrice=${totalPrice}`;
    });
  
});
