function handleStarResult(resultData) {
    console.log("handleStarResult: populating movie table from resultData");

    let movieTableBodyElement = jQuery("#movie_table_body");

    resultData.forEach(movie => {
        let rowHTML = "<tr>";
        rowHTML +=
            "<td>" + movie["title"] + "</td>" +
            "<td>" + movie["year"] + "</td>" +
            "<td>" + movie["director"] + "</td>" +
            "<td>" + movie["genres"] + "</td>" +
            "<td>" + movie["stars"] + "</td>" +
            "<td>" + movie["rating"] + "</td>";
        rowHTML += "</tr>";

        movieTableBodyElement.append(rowHTML);
        console.log(resultData)
    });
}

jQuery.ajax({
    dataType: "json",
    method: "GET",
    url: "movies",
    success: (resultData) => handleStarResult(resultData),
    error: (xhr, status, error) => {
        console.error("AJAX Error:", status, error);
        alert("Failed to fetch movie data. Please try again later.");
    }
});

