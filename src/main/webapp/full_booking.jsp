<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/basic_styles.css">
    <link rel="shortcut icon" type="image/png" href="images/logo_symbol.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,600;0,800;1,100;1,200&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
    <link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@300;400;700&display=swap" rel="stylesheet">
    <title>
        Destinare : Car Rentals
    </title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="images/Logo_icon.ico">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    <link href="./styles/navbar-top-fixed.css" rel="stylesheet">
    <link href="./styles/sticky-footer.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<!--Header-->
    <nav class="navbar navbar-expand-md navbar-light fixed-top" style="background-color: white;">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp"><img class="d-inline-block" src="images/Logo_1.png" width="120px" height=auto style="padding-left: 15px"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-md-center" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Vehicle Fleet</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Services</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Rates</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
              </li>
              <!--
              <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
              </li>
              -->
            </ul>
            <span class="new-123">
                	<div style="display: flex; flex: wrap;">
            			<form action="vreview" method="post">
                    		<button class="basic-btn-2" type="submit">Reviews</button>
            			</form>
           				<form class="d-flex" action ="ManageSessionServlet" method="POST">
                    		<button class="basic-btn" type="submit" onclick="bookPopup()">Book a vehicle</button>
                    		<button class="basic-btn" type="submit"><%if (session.getAttribute("Name") != null) { out.println(session.getAttribute("Name").toString()); } else { out.println("Login | Register"); } %></button>
            			</form>
            		</div>
            </span>
          </div>
        </div>
    </nav>
	<br>
	<div class="text-center">
        <label style="margin-bottom: -200px;" class="title-1">Full Booking</label><br>
        <label class="title-2">Free cancellations on most bookings   |   60,000+ locations   |   Customer support 24/7</label>
    </div>

<form action = "insert" method = "post" >
		<center>
			<br>
			<div class="form-container">

				<c:forEach var="vehicle" items="${vDetails}">
					<input id="chk" type="text" name="vehicleID" value="${vehicle.vid}" hidden>
				</c:forEach>

				<input type="hidden" name="userID"
					value=<%if (session.getAttribute("Name") != null) { out.println(session.getAttribute("UID").toString()); } else { out.println("Login | Register"); }%>>
				<br>
				Select a trip type:
				<select class="form-dropdown" name="tripType" style="margin: 15px">
					<option value="Self Drive">Self Drive</option>
					<option value="Pickup">Pickup</option>
<!-- 					<option value="wedding and VIP">wedding and VIP</option> -->
					<option value="Airport Pickup">Airport Pickup</option>
<!-- 					<option value="Truck">Truck</option> -->
				</select><br>
				Pickup Date: <input class="form-dropdown" type="date" name="pickupDate" style="margin: 15px" required> <br>
				Return Date: <input class="form-dropdown" type="date" name="returnDate" style="margin: 15px" required> <br>
				Pickup Point: <input class="form-dropdown" type="text" name="pickupPoint" style="margin: 15px" required> <br>
				Return Point: <input class="form-dropdown" type="text" name="returnPoint" style="margin: 15px" required>
				<br>
				<input class="basic-btn" type="submit" name="submit" value="Reserve your vehicle">
			</div>
			<br>
			<br>
			<br>
		</center>
	</form>

<!--Footer-->
    <div class="footer-clean">
      <footer>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4 col-md-3 item">
                    <h3>Services</h3>
                    <ul>
                        <li><a href="#">Weddings & VIP Hires</a></li>
                        <li><a href="#">Airport Pickups</a></li>
                        <li><a href="#">Corporate Rental</a></li>
                        <li><a href="#">Self Drive Rental</a></li>
                        <li><a href="#">Moving Truck and Lorry Services</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>Business Center</h3>
                    <ul>
                        <li><a href="#">Corporate Account</a></li>
                        <li><a href="#">Business Solutions</a></li>
                        <li><a href="#">Tour Operators</a></li>
                        <li><a href="#">Travel Agents</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>Legal Information</h3>
                    <ul>
                        <li><a href="#">Damage Management Policy</a></li>
                        <li><a href="#">Deposit Policy</a></li>
                        <li><a href="#">Security and Privacy Policy</a></li>
                        <li><a href="#">Terms and Conditions</a></li>
                        <li><a href="#">Important Information</a></li>
                    </ul>
                </div>
                <!--
                <div class="col-lg-3 item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a>
                    <p class="copyright">Company Name � 2018</p>
                </div>
                -->
                <center><p class="message">OOP Group Project by Group_151 � 2022</p></center>
            </div>
            
        </div>
        
      </footer>
    </div>
      
    <script src="js/basic_script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script>
		var new123 = document.getElementById("chk").value;
		console.log("jddfsjfjs");
	</script>
</body>
</html>