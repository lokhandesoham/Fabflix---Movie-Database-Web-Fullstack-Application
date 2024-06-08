$(document).ready(function() {
    $('#addMovieForm').submit(function(event) {
        event.preventDefault();

        var movieTitle = $('#movieTitle').val();
        var movieYear = $('#movieYear').val();
        var movieDirector = $('#movieDirector').val();
        var starName = $('#starName').val();
        var birthYear = $('#birthYear').val();
        var genreName = $('#genreName').val();

        console.log("Makig addmovie request");

        $.ajax({
            url: 'addmovie',
            method: 'POST',
            data: {
                movieTitle: movieTitle,
                movieYear: movieYear,
                movieDirector: movieDirector,
                starName: starName,
                birthYear: birthYear,
                genreName: genreName
            },
            success: function(response) {
                console.log('Movie added done!');
                $("#added_message").text(response["message"]);
            },
            error: function(xhr, status, error) {
                alert('Error adding movie: ' + error);
            }
        });
    });
});
