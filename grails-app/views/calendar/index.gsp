<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    
    <title>
        TicketSeller
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>



    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
	<asset:stylesheet href="fullcalendar.css" />
	<asset:javascript src='jquery.min.js'/>
	<asset:javascript src='moment.min.js'/>

	<script>
	<%@page expressionCodec="none" %>
	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			customButtons: {
		        eventAdder: {
		            text: 'Add event',
		            click: function() {
		                window.location = "<g:createLink controller="concert" action="add"/>";    
		            }
		        }
    		},
			header: {
				left: 'prev,next today <sec:ifAllGranted roles='ROLE_ADMIN'>eventAdder</sec:ifAllGranted>',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listWeek'
			},
			navLinks: true, // can click day/week names to navigate views
			eventLimit: true, // allow "more" link when too many events
			events:[
				<g:each in="${events}" var="event" status="i">
	            	{title:'${event.title}', start: '${event.start}', end: '${event.end}', url: '<g:createLink controller="concert" action="show" id="${event.id}" />'},
	        	</g:each>
        	],
			timeFormat: 'H:mm'
			
		});
		
	});


	</script>
	<style>
	
	
		#calendar {
			max-width: 900px;
			margin: 0 auto;
		}
	
	</style>



</head>
<body>

    <div id="content" role="main">
        <section class="row colset-2-its">
            </br>
			<div id='calendar'></div>
        </section>
    </div>

	
	<asset:javascript src='fullcalendar.js'/>
	

</body>
</html>
