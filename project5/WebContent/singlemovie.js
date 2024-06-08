function getParameterByName(target) {
        
    let url = window.location.href;        
    target = target.replace(/[\[\]]/g, "\\$&");
    
    let regex = new RegExp("[?&]" + target + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';

    return decodeURIComponent(results[2].replace(/\+/g, " "));
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


function handleMovieResult(resultData) {
    let movieTableBodyElement = document.getElementById("movie_table_body");

    resultData.forEach(movie => {
        let row = movieTableBodyElement.insertRow();

        let titleCell = row.insertCell(0);
        titleCell.textContent = movie.title;

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
        let starsArray = movie.stars.split(", ");
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
}





// Makes the HTTP GET request and registers on success callback function handleResult
function fetchMovieData(id) 
{

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
    const newUrl = `mov?${nonEmptyParams.join('&')}`;

    console.log(newUrl);

    jQuery.ajax({
        dataType: "json",  
        method: "GET",
        url: newUrl,
        success: (resultData) => handleMovieResult(resultData) 
    });
}
// window.onload = () => {
//     let id = getParameterByName('id');
//     console.log(id);

$('#checkout_button').click(function() {
    window.location.href = 'cart.html';
});

fetchMovieData();
