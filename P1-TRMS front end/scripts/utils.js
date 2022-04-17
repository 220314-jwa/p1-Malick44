let requestListTable = document.getElementById('requestListTable');
checkLogin();

async function sendRequest() {
    // sending basic GET request to /pets
    let httpResponse = await fetch('http://localhost:9999/ViewRequests');

    if (httpResponse && httpResponse.status === 200) {
        let responseBody = await httpResponse.json();
        showRequests(responseBody);
    }
}

function showRequests(RequestsArr) {
    requestListTable.innerHTML = `<tr>
    <th>requestId</th>
    <th>employeeId</th>
    <th>eventTypeId</th>
    <th>statusId</th>
    <th>cost</th>
    <th>eventDate</th>
    <th>description</th>
    <th>lacation</th>
    <th>submissionTime</th>
    </tr>`;

    // for each Request in the Requests array from the http response
    for (let Request of RequestsArr) {
        // these Requests are coming from Java so the fields are the same
        let row = document.createElement('tr');
        row.innerHTML = `
            <td>${Request.requestId}</td>
            <td>${Request.employeeId}</td>
            <td>${Request.eventTypeId}</td>
            <td>${Request.statusId}</td>
            <td>${Request.cost}</td>
            <td>${Request.eventDate}</td>
            <td>${Request.description}</td>
            <td>${Request.location}</td>
            <td>${Request.submissionTime}</td>

        `;
        // add the row to the table
        requestListTable.appendChild(row);

    }
}