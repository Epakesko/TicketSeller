<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Creating a new concert</title>
		
		<style>
		td{
			vertical-align:middle;
		}
		
		</style>
	</head>
	<body>
		<form action="<g:createLink controller="concert" action="save"/>" method="post">
			<table style="width:50%;">
			<tr><td>Performer:</td><td><g:textField name="performer"/></td></tr>
			<tr><td>Location:</td><td><g:textField name="location"/></td></tr>
			<tr><td>Starttime</td><td><g:field type="datetime-local" name="startTime"/></td></tr>
			<tr><td>Endtime:</td><td><g:field type="datetime-local" name="endTime"/></td></tr>
			<tr><td>Tickets:</td></tr>
	        <g:each in="${ticketTypes}" var="ticketType" status="i">
	            <tr><td style="text-align:right;">${ticketType.tType} (${ticketType.price} money/ticket):</td><td><g:field class="numberField" type="number" name="${ticketType.tType}" value="0"/></td></tr>
	        </g:each>
	        </table>
	        <table style="width:50%;"><tr><td>
			<tr><td><input type="submit" value="ADD EVENT" /></td></td>
			<td>
			<g:if test='${flash.message}'>
				<div class="registration_message" >${flash.message}</div>
			</g:if>
			</td>
			</tr>
			</table>
		</form>  
	</body>
</html>