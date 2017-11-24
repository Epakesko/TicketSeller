<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Profile</title>
	</head>
	<body>
	<table>
	<tr><th colspan="6" >
	<h3> Your tickets: </h3></th></tr>
        <g:each in="${tickets}" var="ticket" status="i">
            <tr><td class="labeltext">Concert:</td><td>${ticket.concert.performer}</td><td class="labeltext">Category:</td><td>${ticket.ticketType.tType}</td><td class="labeltext">Count:</td><td>${ticket.count}</td></tr>
        </g:each>
    </table>
	</body>
</html>