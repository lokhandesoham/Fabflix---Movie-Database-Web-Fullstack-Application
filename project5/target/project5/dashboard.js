$(document).ready(function() {
    $.ajax({
        url: 'metadata',
        method: 'GET',
        success: function(data) {
            // Parse JSON data
            console.log(data);
            //var metadata = JSON.parse(data);
            
            var groupedTables = {};
            data.forEach(function(tableData) {
                var tableName = tableData.table;
                if (!groupedTables[tableName]) {
                    groupedTables[tableName] = [];
                }
                groupedTables[tableName].push(tableData);
            });

            // Iterate over each grouped table
            for (var tableName in groupedTables) {
                if (groupedTables.hasOwnProperty(tableName)) {
                    var columns = groupedTables[tableName];

                    // Create a new table element for each table
                    var table = $('<table></table>').appendTo('body');
                    var caption = $('<caption></caption>').text(tableName + ' Table');
                    table.append(caption);

                    // Create table headers
                    var thead = $('<thead></thead>').appendTo(table);
                    var headerRow = $('<tr></tr>').appendTo(thead);
                    $('<th></th>').text('Attribute').appendTo(headerRow);
                    $('<th></th>').text('Type').appendTo(headerRow);
                    $('<th></th>').text('Length').appendTo(headerRow);
                    $('<th></th>').text('Nullable').appendTo(headerRow);

                    // Create table body
                    var tbody = $('<tbody></tbody>').appendTo(table);

                    // Iterate over columns in the table and add rows to the table
                    columns.forEach(function(column) {
                        var row = $('<tr></tr>').appendTo(tbody);
                        $('<td></td>').text(column.column).appendTo(row);
                        $('<td></td>').text(column.type).appendTo(row);
                        $('<td></td>').text(column.len).appendTo(row);
                        $('<td></td>').text(column.null).appendTo(row);
                    });
                }
            }

            console.log("Metadata displayed successfully");
        },
        error: function(xhr, status, error) {
            console.error('Error fetching metadata:', error);
        }
    });
});
