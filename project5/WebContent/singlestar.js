function getParameterByName(target) {
        
    let url = window.location.href;
    target = target.replace(/[\[\]]/g, "\\$&");
    
    let regex = new RegExp("[?&]" + target + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';

    return decodeURIComponent(results[2].replace(/\+/g, " "));
}


function handleStarResult(resultData) {
    let starTableBodyElement = document.getElementById("star_table_body");

    resultData.forEach(star => {
        let row = starTableBodyElement.insertRow();

        let starCell = row.insertCell(0);
        starCell.textContent = star.star_name;

        let yearCell = row.insertCell(1);
        yearCell.textContent = star.birth_year;

        let moviesCell = row.insertCell(2);
        let moviesArray = star.movies_acting.split(", ");
        moviesArray.forEach(movie => {
            let movieLink = document.createElement("a");
            movieLink.href = "singlemovie.html?id=" + encodeURIComponent(movie);
            movieLink.textContent = movie;
            movieLink.style.display = "block"; 
            moviesCell.appendChild(movieLink);
        });


    });
}





// Makes the HTTP GET request and registers on success callback function handleResult
function fetchMovieData() 
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
    const newUrl = `star?${nonEmptyParams.join('&')}`;

    console.log(newUrl);

    jQuery.ajax({
        dataType: "json",  
        method: "GET",
        url: newUrl, 
        success: (resultData) => handleStarResult(resultData) 
});
}



$('#checkout_button').click(function() {
    window.location.href = 'cart.html';
});

fetchMovieData();
