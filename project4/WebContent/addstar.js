$(document).ready(function() {
    $('#addStarForm').submit(function(event) {
        event.preventDefault();

        var starName = $('#starName').val();
        var birthYear = $('#birthYear').val();

        $.ajax({
            url: 'addstar',
            method: 'POST',
            data: {
                starName: starName,
                birthYear: birthYear
            },
            success: function(response) {
                console.log('Star added successfully!');
                $("#added_message").text("added star with new id -->" + response["newid"]);
            },
            error: function(xhr, status, error) {
                alert('Error adding star: ' + error);
            }
        });
    });
});