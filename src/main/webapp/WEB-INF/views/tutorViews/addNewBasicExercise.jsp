<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tutor - dodaj nowe zadanie</title>
<!-- Bootstrap core CSS -->
<link href="resources/tutorDashboard/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/tutorDashboard/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resources/tutorDashboard/css/zabuto_calendar.css">

<link rel="stylesheet" type="text/css"
	href="resources/tutorDashboard/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="resources/tutorDashboard/css/style.css" rel="stylesheet">
<link href="resources/tutorDashboard/css/style-responsive.css"
	rel="stylesheet">

<script src="resources/tutorDashboard/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<c:url value="../sys_school/adduser" var="newUser" />
	<c:url value="../sys_school/invitestudent" var="newStudent" />
	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start--> <a href="index.html" class="logo"><b>MYCLASS.PL</b></a>
	<!--logo end-->
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav top-menu">

			<!-- inbox dropdown start-->
			<li id="header_inbox_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
					<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">10</span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">You have 5 new messages</p>
					</li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-zac.jpg"></span>
							<span class="subject"> <span class="from">Zac
									Snider</span> <span class="time">Just now</span>
						</span> <span class="message"> Hi mate, how is everything? </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-divya.jpg"></span>
							<span class="subject"> <span class="from">Divya
									Manian</span> <span class="time">40 mins.</span>
						</span> <span class="message"> Hi, I need your help with this. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-danro.jpg"></span>
							<span class="subject"> <span class="from">Dan
									Rogers</span> <span class="time">2 hrs.</span>
						</span> <span class="message"> Love your new Dashboard. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="resources/tutorDashboard/img/ui-sherman.jpg"></span>
							<span class="subject"> <span class="from">Dj
									Sherman</span> <span class="time">4 hrs.</span>
						</span> <span class="message"> Please, answer asap. </span>
					</a></li>
					<li><a href="index.html#">See all messages</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="login.html">Logout</a></li>
		</ul>
	</div>
	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="profile.html"><img
					src="resources/login/images/hello.png" class="img-circle"
					width="60"></a>
			</p>
			<h5 class="centered">${tutor.login}</h5>

			<li class="mt"><a class="active" href="index.html"> <i
					class="fa fa-dashboard"></i> <span>Panel główny</span>
			</a></li>

			<li class="sub-menu"><a href=""> <i class="fa fa-comments"></i>
					<span>Wiadomości</span>
			</a></li>

			<li class="sub-menu"><a href=""> <i class="fa fa-users"></i>
					<span>Uczniowie</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class="fa fa-tasks"></i>
					<span>Zadania</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class="fa fa-archive"></i>
					<span>Odpowiedzi do zadań</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i
					class="fa fa-bar-chart-o"></i> <span>Raporty</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class=" fa fa-money"></i>
					<span>Finanse</span>
			</a></li>
			<li class="sub-menu"><a href=""> <i class=" fa fa-cog"></i>
					<span>Ustawienia</span>
			</a></li>

		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<!--main content start--> <section id="main-content"> <section
		class="wrapper">
	<div class="row">
		<div class="col-lg-9 main-chart">
			<div class="row mtbox">
				<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
					<a href="${newStudent}"><div class="box1">
							<span class="li_study"></span>
							<h3>Dodaj nowych uczniów</h3>
						</div></a>
					<p>Wyślij zaproszenie do swojej klasy.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<a href="${newExercise}"><div class="box1">
							<span class="li_note"></span>
							<h3>Dodaj nowe zadanie</h3>
						</div></a>
					<p>Dodaj i przydziel nowe zadanie.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<a href="${newExercise}"><div class="box1">
							<span class="li_pen"></span>
							<h3>Sprawdź odpowiedzi</h3>
						</div></a>
					<p>Zweryfikuj postępy swoich uczniów.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<a href="${newExercise}"><div class="box1">
							<span class="li_calendar"></span>
							<h3>Ustal datę nowej lekcji</h3>
						</div></a>
					<p>Wyślij propozycję terminu następnej lekcji.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<a href="${newExercise}"><div class="box1">
							<span class="li_settings"></span>
							<h3>Sprawdź ustawienia</h3>
						</div></a>
					<p>Przejdź do ustawień swojego konta.</p>
				</div>

			</div>
			<!-- /row mt -->


			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
						<form:form class="form-horizontal style-form" method="post"
							modelAttribute="basicExercises">
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Temat
									zadania</label>
								<div class="col-sm-10">
									<form:input path="title" class="form-control" type="text"
										placeholder="Tytuł zadania" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Treść
									zadania</label>
								<div class="col-sm-10">
									<form:input path="description" class="form-control"
										placeholder="Wpisz treść zadania" type="text" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Kto ma
									wykonać?</label>
								<div class="col-sm-10">
									<form:select itemValue="id" path="student.id" itemLabel="login"
										items="${students}" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Do kiedy?</label>
								<div class="col-sm-10" class="form-control">
									<form:input itemValue="deadline" path="deadline" type="date" />
								</div>
							</div> --%>


							<input class="btn btn-primary" type="submit"
								value="Dodaj zadanie">
						</form:form>
					</div>
				</div>
			</div>
			<!-- /row -->


			<div class="row"></div>

			<div class="row mt">
				<!--CUSTOM CHART START -->
				<!--custom chart end-->
			</div>
			<!-- /row -->

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->
		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds">
			<h3>POWIADOMIENIA</h3>

			<!-- First Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>2 Minutes Ago</muted>
						<br /> <a href="#">James Brown</a> subscribed to your newsletter.<br />
					</p>
				</div>
			</div>
			<!-- Second Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>3 Hours Ago</muted>
						<br /> <a href="#">Diana Kennedy</a> purchased a year
						subscription.<br />
					</p>
				</div>
			</div>
			<!-- Third Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>7 Hours Ago</muted>
						<br /> <a href="#">Brandon Page</a> purchased a year
						subscription.<br />
					</p>
				</div>
			</div>
			<!-- Fourth Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>11 Hours Ago</muted>
						<br /> <a href="#">Mark Twain</a> commented your post.<br />
					</p>
				</div>
			</div>
			<!-- Fifth Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>18 Hours Ago</muted>
						<br /> <a href="#">Daniel Pratt</a> purchased a wallet in your
						store.<br />
					</p>
				</div>
			</div>

			<!-- USERS ONLINE SECTION -->
			<h3>UCZNIOWIE</h3>
			<!-- First Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle"
						src="resources/tutorDashboard/img/ui-divya.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DIVYA MANIAN</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Second Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle"
						src="resources/tutorDashboard/img/ui-sherman.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DJ SHERMAN</a><br />
						<muted>I am Busy</muted>
					</p>
				</div>
			</div>
			<!-- Third Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle"
						src="resources/tutorDashboard/img/ui-danro.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DAN ROGERS</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fourth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle"
						src="resources/tutorDashboard/img/ui-zac.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Zac Sniders</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fifth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle"
						src="resources/tutorDashboard/img/ui-sam.jpg" width="35px"
						height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Marcel Newman</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>

			<!-- CALENDAR-->
			<div id="calendar" class="mb">
				<div class="panel green-panel no-margin">
					<div class="panel-body">
						<div id="date-popover" class="popover top"
							style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
							<div class="arrow"></div>
							<h3 class="popover-title" style="disadding: none;"></h3>
							<div id="date-popover-content" class="popover-content"></div>
						</div>
						<div id="my-calendar"></div>
					</div>
				</div>
			</div>
			<!-- / calendar -->

		</div>
		<!-- /col-lg-3 -->
	</div>
	<! --/row --> </section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer">
	<div class="text-center">
		Potrzebujesz pomocy?<a href="index.html#" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/tutorDashboards/js/jquery.js"></script>
	<script src="resources/tutorDashboard/js/jquery-1.8.3.min.js"></script>
	<script src="resources/tutorDashboard/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/tutorDashboard/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/tutorDashboard/js/jquery.scrollTo.min.js"></script>
	<script src="resources/tutorDashboard/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="resources/tutorDashboard/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="resources/tutorDashboard/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="resources/tutorDashboard/js/sparkline-chart.js"></script>
	<script src="resources/tutorDashboard/js/zabuto_calendar.js"></script>



	<script type="application/javascript">
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</script>


</body>