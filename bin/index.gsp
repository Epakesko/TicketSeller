<!doctype html>
<html>
<head>
    <title>Welcome to Grails</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        Welcome to Grails
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

	<link rel="stylesheet" href="/assets/grails.css?compile=false" />


    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
	<asset:stylesheet href="fullcalendar.css" />
	<asset:javascript src='jquery.min.js'/>
	<asset:javascript src='moment.min.js'/>

	<script>

	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listWeek'
			},
			navLinks: true, // can click day/week names to navigate views
			eventLimit: true, // allow "more" link when too many events
			events: [
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2017-11-12 14:30:00'
				}
			]
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
            <h1>Welcome to Grails</h1>
			<div id='calendar'></div>
            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>

	
	<asset:javascript src='fullcalendar.js'/>
	
	


</body>
</html>
