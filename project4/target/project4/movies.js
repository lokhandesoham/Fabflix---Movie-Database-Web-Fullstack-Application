let currentPage = 1;

function updateCurrentPageDisplay() {
    $('#current_page_display').text(`Page ${currentPage}`);
}


function addToSession(movie) {
    // Make a POST request to add movie to session
    $.ajax({
        url: 'cart', // Adjust URL based on your servlet mapping
        type: 'POST',
        data: {
            title: movie.title,
            year: movie.year,
            director: movie.director,
            genres: movie.genres,
            stars: movie.stars,
            rating: movie.rating
        },
        success: function(response) {
            console.log(response);
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}


function handleStarResult(resultData) {
    let movieTableBodyElement = document.getElementById("movie_table_body");

    if (resultData.length === 0) {
        // Handle empty array case, e.g., show a message or perform other actions
        console.log("resultData array is empty.");
        return;
    }

    movieTableBodyElement.innerHTML = "";
    console.log(resultData);

    resultData.forEach(movie => {
        let row = movieTableBodyElement.insertRow();

        let titleCell = row.insertCell(0);
        let titleLink = document.createElement("a");
        titleLink.href = "singlemovie.html?id=" + encodeURIComponent(movie.title); // Adjust URL as needed
        titleLink.textContent = movie.title;
        titleCell.appendChild(titleLink);

        let yearCell = row.insertCell(1);
        yearCell.textContent = movie.year;

        let directorCell = row.insertCell(2);
        directorCell.textContent = movie.director;

        let genresCell = row.insertCell(3);
        let genresArray = movie.genres.split(",");
        genresArray.forEach(genre => {
            let genreLink = document.createElement("a");
            genreLink.href = "movies.html?genre=" + encodeURIComponent(genre);
            genreLink.textContent = genre;
            genreLink.style.display = "block"; 
            genresCell.appendChild(genreLink);
        });


        let starsCell = row.insertCell(4);
        let starsArray = movie.stars.split(",");
        starsArray.forEach(star => {
            let starLink = document.createElement("a");
            starLink.href = "singlestar.html?id=" + encodeURIComponent(star);
            starLink.textContent = star;
            starLink.style.display = "block"; 
            starsCell.appendChild(starLink);
        });

        let ratingCell = row.insertCell(5);
        ratingCell.textContent = movie.rating;

        let actionCell = row.insertCell(6);
        let addButton = document.createElement("button");
        addButton.textContent = "Add to Cart button";
        addButton.addEventListener("click", function() {
            addToSession(movie);
            addButton.textContent = "Added";
            addButton.style.backgroundColor = "green";
            addButton.disabled = true;
        });
        actionCell.appendChild(addButton);

    });


    updateCurrentPageDisplay();
}







$(document).ready(function() {

    $('#checkout_button').click(function() {
        window.location.href = 'cart.html';
    });


    function handleUpdateButtonClick() 
    {
        const sortBy = $('#sort_by').val();
        const moviesPerPage = $('#movies_per_page').val();
    
        // Get the current URL
        const currentUrl = window.location.href;
        console.log(currentUrl);

        const urlParts = currentUrl.split('?');

        // Check if there is more than one part after splitting
        console.log("---------");
        const queryString = urlParts[1];
        console.log(queryString);
    
        const params = new URLSearchParams(queryString);

        // Filter out empty parameters
        const nonEmptyParams = Array.from(params.keys()).reduce((acc, key) => {
            const value = params.get(key);
            if (value && value.trim() !== '') {
                acc.push(`${key}=${encodeURIComponent(value)}`);
            }
            return acc;
        }, []);
    
        // Construct the new URL with updated parameters
        //const newUrl = `movies?${queryString}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}`;
        const newUrl = `movies?${nonEmptyParams.join('&')}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}`;

        console.log(newUrl);
        // Redirect to the new URL
        $.ajax({
            url: newUrl,
            type: 'GET',
            success: handleStarResult ,
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    // Bind event handlers
    $('#update_button').click(handleUpdateButtonClick);


    $('#prev_button').click(function() {
        if (currentPage > 1) 
        {
            --currentPage; // Decrease current page number
            const sortBy = $('#sort_by').val();
            const moviesPerPage = $('#movies_per_page').val();
        
            // Get the current URL
            const currentUrl = window.location.href;

            const urlParts = currentUrl.split('?');

            // Check if there is more than one part after splitting
            console.log("---------");
            const queryString = urlParts[1];
            console.log(queryString);
        
            const params = new URLSearchParams(queryString);

            // Filter out empty parameters
            const nonEmptyParams = Array.from(params.keys()).reduce((acc, key) => {
                const value = params.get(key);
                if (value && value.trim() !== '') {
                    acc.push(`${key}=${encodeURIComponent(value)}`);
                }
                return acc;
            }, []);
        
            // Construct the new URL with updated parameters
            //const newUrl = `movies?${queryString}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}`;
            const newUrl = `movies?${nonEmptyParams.join('&')}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}&page=${currentPage}`;

            console.log(newUrl); 

            $.ajax({
                url: newUrl,
                type: 'GET',
                success: handleStarResult ,
                error: function(xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
    });

    // Function to handle Next button click
    $('#next_button').click(function() {
        ++currentPage; // Increase current page number
        const sortBy = $('#sort_by').val();
        const moviesPerPage = $('#movies_per_page').val();
    
        // Get the current URL
        const currentUrl = window.location.href;

        const urlParts = currentUrl.split('?');

        // Check if there is more than one part after splitting
        console.log("---------");
        const queryString = urlParts[1];
        console.log(queryString);
    
        const params = new URLSearchParams(queryString);

        // Filter out empty parameters
        const nonEmptyParams = Array.from(params.keys()).reduce((acc, key) => {
            const value = params.get(key);
            if (value && value.trim() !== '') {
                acc.push(`${key}=${encodeURIComponent(value)}`);
            }
            return acc;
        }, []);
    
        // Construct the new URL with updated parameters
        //const newUrl = `movies?${queryString}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}`;
        const newUrl = `movies?${nonEmptyParams.join('&')}&sort_by=${sortBy}&movies_per_page=${moviesPerPage}&page=${currentPage}`;

        console.log(newUrl); 

        $.ajax({
            url: newUrl,
            type: 'GET',
            success: handleStarResult ,
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    });


    console.log("in 1 func movie.js");
    const urlParams = new URLSearchParams(window.location.search);
    console.log("urlparams: "+ urlParams);
    const title = urlParams.get('title');
    const year = urlParams.get('year');
    const director = urlParams.get('director');
    const star = urlParams.get('star');
    const genre = urlParams.get('genre');
    const fulltitle = urlParams.get('fulltitle');
    console.log("fulltitle: "+ fulltitle);

    // Construct URL for Ajax request
    let url = 'movies'; // Your servlet URL
    if (title || year || director || star || genre || fulltitle) {
        url += '?';
        if (title) url += `title=${encodeURIComponent(title)}&`;
        if (year) url += `year=${encodeURIComponent(year)}&`;
        if (director) url += `director=${encodeURIComponent(director)}&`;
        if (star) url += `star=${encodeURIComponent(star)}&`;
        if (genre) url += `genre=${encodeURIComponent(genre)}&`;
        if (fulltitle) url += `fulltitle=${encodeURIComponent(fulltitle)}&`;
        url = url.slice(0, -1); // Remove trailing '&'
    }
    console.log("in docu.ready");
    console.log("ajax url - "+ url);

    // Ajax request to fetch movies data
    $.ajax({
        url: url,
        type: 'GET',
        success: handleStarResult ,
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });

    updateCurrentPageDisplay();

});