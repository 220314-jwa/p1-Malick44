let requestListTable = document.getElementById('requestListTable');

async function sendRequest() {
    // sending basic GET request to /pets
    let httpResponse = await fetch('http://localhost:9999/ViewRequests');

    if (httpResponse && httpResponse.status===200) {
        let responseBody = await httpResponse.json();
        showRequests(responseBody);
    }
}

function showRequests(RequestsArr) {
    requestListTable.innerHTML = `<tr>
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
    for (let Request of requestList) {
        // these pets are coming from Java so the fields are the same
        let row = document.createElement('tr');
        row.innerHTML = `
            <td>${Request.employeeId}</td>
            <td>${Request.eventTypeId}</td>
            <td>${Request.statusId}</td>
            <td>${Request.cost}</td>
            <td>${Request.eventDate}</td>
            <td>${Request.description}</td>
            <td>${Request.acation}</td>
            <td>${Request.submissionTime}</td>
        

            <!-- the ID of the adopt button will be "adopt" plus the pet's ID so that
            we can get the ID later and know which pet the user is trying to adopt -->
            <td><button type="button" id="adopt${pet.id}">Adopt</submit></td>
        `;
        // add the row to the table
        requestListTable.appendChild(row);
    
    }}