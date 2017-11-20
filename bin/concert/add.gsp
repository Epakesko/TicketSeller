<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Ticket types</title>
	</head>
	<body>
		<form action="<g:createLink controller="concert" action="save"/>" method="post">
			<h3>Performer: <g:textField name="performer"/></h3>
			<h3>Location: <g:textField name="location"/></h3>
			<h3>Starttime (yyyy-MM-dd HH:mm): <g:textField name="startTime"/></h3>
			<h3>Endtime: (yyyy-MM-dd HH:mm): <g:textField name="endTime"/></h3>
			<h3>Tickets:</h3>
	        <g:each in="${ticketTypes}" var="ticketType" status="i">
	            <p>&emsp;Category: ${ticketType.tType} (${ticketType.price} money/ticket): <g:field class="numberField" type="number" name="${ticketType.tType}" value="0"/></p>
	        </g:each>
			</br>
			<input type="submit" value="ADD EVENT" />
		</form>  
	</body>
</html>