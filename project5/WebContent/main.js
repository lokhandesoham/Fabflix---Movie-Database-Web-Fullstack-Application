// Function to handle search form submission
function submitSearchForm(event) {
    event.preventDefault(); // Prevent default form submission
    console.log("in submitSearchForm")
    // Get the form data
    const formData = {
        title: $('#title').val(),
        year: $('#year').val(),
        director: $('#director').val(),
        star: $('#star').val()
    };

    // Construct query string from form data
    const queryString = $.param(formData);

    console.log('submitSearchForm')
    console.log(queryString)

    // Redirect to movies.html with query string
    window.location.href = `movies.html?${queryString}`;
}

// Function to handle browse link clicks
// function handleBrowseClick(event) {
//     event.preventDefault(); // Prevent default link behavior

//     const browseURL = $(this).attr('href');

//     // Redirect to movies.html with browse URL
//     window.location.href = `movies.html?${browseURL}`;
// }


$.ajax({
    url: 'genres',
    method: 'GET',
    success: function(data) {
        // Update UI with fetched genres
        console.log(data)
        
        const genresHTML = data.map(genreObj => `<li><a href="movies.html?genre=${genreObj.genres}">${genreObj.genres}</a></li>`).join('');
        $('#genres_list').html(genresHTML);
    },
    error: function(xhr, status, error) {
        console.error('Error fetching genres:', error);
    }
});




// Bind event handlers
$(document).ready(function() {
    $('#checkout_button').click(function() {
        window.location.href = 'cart.html';
    });

    $('#search_form').submit(submitSearchForm);
   // $('ul').on('click', 'a', handleBrowseClick); // Delegate click events for dynamic content
});
