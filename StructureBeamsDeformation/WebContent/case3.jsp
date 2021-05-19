<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beam deformation calculator</title>
<style>
a:link {
	text-decoration: none;
	color: #606060;
}

a:visited {
	text-decoration: none;
	color: #606060;
}

a:active {
	text-decoration: none;
	color: #606060;
}

a:hover {
	text-decoration: none;
}

.nav {
	display: table; /* Allow the centering to work */
	margin: 0 auto;
}

.nav-main li {
	position: relative;
	display: inline-block;
	list-style-type: none;
	padding: 0px;
	padding-left: 0px;
	padding-right: 0px;
	border: 1px solid #b3bfd1;
	margin-top: -1px;
	background-color: #fff;
}

.nav-main li:hover {
	background-color: #dde3ee;
}

/*links inside dropdown*/
.sub-menu li {
	background: #b3bfd1;
	color: #606060;
	font-weight: 700
}

.sub-menu li:hover {
	background: #dde3ee;
}

/*dropdown content*/
.sub-menu {
	display: none;
	position: absolute;
	width: 100%;
	z-index: 1;
	padding: 10px 0px;
	left: 0;
}

.nav-main>li:hover .sub-menu {
	display: table-row;
}

.profiles {
	margin: auto;
	width: 10%;
	padding-bottom: 15px;
}

.image {
	padding: 0px 50px;
}
</style>
</head>
<body bgcolor="white">

	<!-- ------CHOOSE SECTION FORM------ -->
	<form method="post" action="case3.jsp">
		<header>
			<h2>
				<a href="index.jsp">&#x2190; Cases</a>
			</h2>
			<h2 align="center">Case 3</h2>
			<div class="nav">
				<ul class="nav-main">
					<li><button type="submit" name="buttonCHS" id="button"
							class="button">
							<img src="profile-icons/icon-profile-chs.png" alt="img not found">
						</button></li>
					<li><button type="submit" name="buttonSHS" id="button"
							class="button">
							<img src="profile-icons/icon-profile-shs.png" alt="img not found">
						</button></li>
					<li><button type="submit" name="buttonRHS" id="button"
							class="button">
							<img src="profile-icons/icon-profile-rhs.png" alt="img not found">
						</button></li>
					<li><button type="submit" name="buttonLE" id="button"
							class="button">
							<img src="profile-icons/icon-profile-le.png" alt="img not found">
						</button></li>
					<li><button type="submit" name="buttonLU" id="button"
							class="button">
							<img src="profile-icons/icon-profile-lu.png" alt="img not found">
						</button></li>
					<!-- <li><img src="profile-icons/icon-profile-u.png" alt="img not found">
						<ul class="sub-menu" style="width: 75px !important;">
							<li><button type="submit">UPN</button></li>
							<li><a href="case1ue.html">UE</a></li>
							<li><a href="case1upe.html">UPE</a></li>
							<li><a href="case1uap.html">UAP</a></li>
						</ul>
					</li>
					<li><img src="profile-icons/icon-profile-h.png" alt="img not found">
						<ul class="sub-menu">
							<li><a href="underconstruction.html">HE</a></li>
							<li><a href="underconstruction.html">HEA</a></li>
							<li><a href="underconstruction.html">HEAA</a></li>
							<li><a href="underconstruction.html">HEB</a></li>
							<li><a href="underconstruction.html">HEM</a></li>
							<li><a href="underconstruction.html">HD</a></li>
							<li><a href="underconstruction.html">HL</a></li>
						</ul>
					</li>
					<li><img src="profile-icons/icon-profile-i.png" alt="img not found">
						<ul class="sub-menu">
							<li><a href="underconstruction.html">IPN</a></li>
							<li><a href="underconstruction.html">IPE</a></li>
							<li><a href="underconstruction.html">IPEA</a></li>
							<li><a href="underconstruction.html">IPEAA</a></li>
							<li><a href="underconstruction.html">IPEO</a></li>
						</ul>
					</li> -->
				</ul>
			</div>
		</header>
	</form>
	<!-- ------END OF CHOOSE SECTION FORM------ -->

	<form method="post" action="casesServlet">
		<%
		if (request.getParameter("buttonCHS") != null) {
		%>
		<div class="profiles">
			<table>
				<tbody>
					<tr>
						<td><label>Section:</label></td>
						<td><select name="profile" class="profile" id="profile">
								<option disabled selected>Select section</option>
								<option value="CHS+21.3x2.3">CHS 21.3x2.3</option>
								<option value="CHS+21.3x2.6">CHS 21.3x2.6</option>
								<option value="CHS+21.3x3.2">CHS 21.3x3.2</option>
								<option value="CHS+26.9x2.3">CHS 26.9x2.3</option>
								<option value="CHS+26.9x2.6">CHS 26.9x2.6</option>
								<option value="CHS+26.9x3.2">CHS 26.9x3.2</option>
								<option value="CHS+33.7x2.6">CHS 33.7x2.6</option>
								<option value="CHS+33.7x3.2">CHS 33.7x3.2</option>
								<option value="CHS+33.7x4">CHS 33.7x4</option>
								<option value="CHS+42.4x2.6">CHS 42.4x2.6</option>
								<option value="CHS+42.4x3.2">CHS 42.4x3.2</option>
								<option value="CHS+42.4x4">CHS 42.4x4</option>
								<option value="CHS+48.3x2.6">CHS 48.3x2.6</option>
								<option value="CHS+48.3x3.2">CHS 48.3x3.2</option>
								<option value="CHS+48.3x4">CHS 48.3x4</option>
								<option value="CHS+48.3x5">CHS 48.3x5</option>
								<option value="CHS+60.3x2.6">CHS 60.3x2.6</option>
								<option value="CHS+60.3x3.2">CHS 60.3x3.2</option>
								<option value="CHS+60.3x4">CHS 60.3x4</option>
								<option value="CHS+60.3x5">CHS 60.3x5</option>
								<option value="CHS+76.1x2.6">CHS 76.1x2.6</option>
								<option value="CHS+76.1x3.2">CHS 76.1x3.2</option>
								<option value="CHS+76.1x4">CHS 76.1x4</option>
								<option value="CHS+76.1x5">CHS 76.1x5</option>
								<option value="CHS+88.9x3.2">CHS 88.9x3.2</option>
								<option value="CHS+88.9x4">CHS 88.9x4</option>
								<option value="CHS+88.9x5">CHS 88.9x5</option>
								<option value="CHS+88.9x6.3">CHS 88.9x6.3</option>
								<option value="CHS+101.6x3.2">CHS 101.6x3.2</option>
								<option value="CHS+101.6x4">CHS 101.6x4</option>
								<option value="CHS+101.6x5">CHS 101.6x5</option>
								<option value="CHS+101.6x6.3">CHS 101.6x6.3</option>
								<option value="CHS+101.6x8">CHS 101.6x8</option>
								<option value="CHS+101.6x10">CHS 101.6x10</option>
								<option value="CHS+114.3x3.2">CHS 114.3x3.2</option>
								<option value="CHS+114.3x4">CHS 114.3x4</option>
								<option value="CHS+114.3x5">CHS 114.3x5</option>
								<option value="CHS+114.3x6.3">CHS 114.3x6.3</option>
								<option value="CHS+114.3x8">CHS 114.3x8</option>
								<option value="CHS+114.3x10">CHS 114.3x10</option>
								<option value="CHS+139.7x4">CHS 139.7x4</option>
								<option value="CHS+139.7x5">CHS 139.7x5</option>
								<option value="CHS+139.7x6.3">CHS 139.7x6.3</option>
								<option value="CHS+139.7x8">CHS 139.7x8</option>
								<option value="CHS+139.7x10">CHS 139.7x10</option>
								<option value="CHS+139.7x12.5">CHS 139.7x12.5</option>
								<option value="CHS+168.3x4">CHS 168.3x4</option>
								<option value="CHS+168.3x5">CHS 168.3x5</option>
								<option value="CHS+168.3x6.3">CHS 168.3x6.3</option>
								<option value="CHS+168.3x8">CHS 168.3x8</option>
								<option value="CHS+168.3x10">CHS 168.3x10</option>
								<option value="CHS+168.3x12.5">CHS 168.3x12.5</option>
								<option value="CHS+177.8x5">CHS 177.8x5</option>
								<option value="CHS+177.8x6.3">CHS 177.8x6.3</option>
								<option value="CHS+177.8x8">CHS 177.8x8</option>
								<option value="CHS+177.8x10">CHS 177.8x10</option>
								<option value="CHS+177.8x12.5">CHS 177.8x12.5</option>
								<option value="CHS+193.7x5">CHS 193.7x5</option>
								<option value="CHS+193.7x6.3">CHS 193.7x6.3</option>
								<option value="CHS+193.7x8">CHS 193.7x8</option>
								<option value="CHS+193.7x10">CHS 193.7x10</option>
								<option value="CHS+193.7x12.5">CHS 193.7x12.5</option>
								<option value="CHS+193.7x14.2">CHS 193.7x14.2</option>
								<option value="CHS+193.7x16">CHS 193.7x16</option>
								<option value="CHS+219.1x5">CHS 219.1x5</option>
								<option value="CHS+219.1x6.3">CHS 219.1x6.3</option>
								<option value="CHS+219.1x8">CHS 219.1x8</option>
								<option value="CHS+219.1x10">CHS 219.1x10</option>
								<option value="CHS+219.1x12.5">CHS 219.1x12.5</option>
								<option value="CHS+219.1x14.2">CHS 219.1x14.2</option>
								<option value="CHS+219.1x16">CHS 219.1x16</option>
								<option value="CHS+219.1x20">CHS 219.1x20</option>
								<option value="CHS+244.5x5">CHS 244.5x5</option>
								<option value="CHS+244.5x6.3">CHS 244.5x6.3</option>
								<option value="CHS+244.5x8">CHS 244.5x8</option>
								<option value="CHS+244.5x10">CHS 244.5x10</option>
								<option value="CHS+244.5x12.5">CHS 244.5x12.5</option>
								<option value="CHS+244.5x14.2">CHS 244.5x14.2</option>
								<option value="CHS+244.5x16">CHS 244.5x16</option>
								<option value="CHS+244.5x20">CHS 244.5x20</option>
								<option value="CHS+244.5x25">CHS 244.5x25</option>
								<option value="CHS+273x5">CHS 273x5</option>
								<option value="CHS+273x6.3">CHS 273x6.3</option>
								<option value="CHS+273x8">CHS 273x8</option>
								<option value="CHS+273x10">CHS 273x10</option>
								<option value="CHS+273x12.5">CHS 273x12.5</option>
								<option value="CHS+273x14.2">CHS 273x14.2</option>
								<option value="CHS+273x16">CHS 273x16</option>
								<option value="CHS+273x20">CHS 273x20</option>
								<option value="CHS+273x25">CHS 273x25</option>
								<option value="CHS+323.9x5">CHS 323.9x5</option>
								<option value="CHS+323.9x6.3">CHS 323.9x6.3</option>
								<option value="CHS+323.9x8">CHS 323.9x8</option>
								<option value="CHS+323.9x10">CHS 323.9x10</option>
								<option value="CHS+323.9x12.5">CHS 323.9x12.5</option>
								<option value="CHS+323.9x14.2">CHS 323.9x14.2</option>
								<option value="CHS+323.9x16">CHS 323.9x16</option>
								<option value="CHS+323.9x20">CHS 323.9x20</option>
								<option value="CHS+323.9x25">CHS 323.9x25</option>
								<option value="CHS+355.6x6.3">CHS 355.6x6.3</option>
								<option value="CHS+355.6x8">CHS 355.6x8</option>
								<option value="CHS+355.6x10">CHS 355.6x10</option>
								<option value="CHS+355.6x12.5">CHS 355.6x12.5</option>
								<option value="CHS+355.6x14.2">CHS 355.6x14.2</option>
								<option value="CHS+355.6x16">CHS 355.6x16</option>
								<option value="CHS+355.6x20">CHS 355.6x20</option>
								<option value="CHS+355.6x25">CHS 355.6x25</option>
								<option value="CHS+406.4x6.3">CHS 406.4x6.3</option>
								<option value="CHS+406.4x8">CHS 406.4x8</option>
								<option value="CHS+406.4x10">CHS 406.4x10</option>
								<option value="CHS+406.4x12.5">CHS 406.4x12.5</option>
								<option value="CHS+406.4x14.2">CHS 406.4x14.2</option>
								<option value="CHS+406.4x16">CHS 406.4x16</option>
								<option value="CHS+406.4x20">CHS 406.4x20</option>
								<option value="CHS+406.4x25">CHS 406.4x25</option>
								<option value="CHS+406.4x30">CHS 406.4x30</option>
								<option value="CHS+406.4x40">CHS 406.4x40</option>
								<option value="CHS+457x6.3">CHS 457x6.3</option>
								<option value="CHS+457x8">CHS 457x8</option>
								<option value="CHS+457x10">CHS 457x10</option>
								<option value="CHS+457x12.5">CHS 457x12.5</option>
								<option value="CHS+457x14.2">CHS 457x14.2</option>
								<option value="CHS+457x16">CHS 457x16</option>
								<option value="CHS+457x20">CHS 457x20</option>
								<option value="CHS+457x25">CHS 457x25</option>
								<option value="CHS+457x30">CHS 457x30</option>
								<option value="CHS+457x40">CHS 457x40</option>
								<option value="CHS+508x6.3">CHS 508x6.3</option>
								<option value="CHS+508x8">CHS 508x8</option>
								<option value="CHS+508x10">CHS 508x10</option>
								<option value="CHS+508x12.5">CHS 508x12.5</option>
								<option value="CHS+508x14.2">CHS 508x14.2</option>
								<option value="CHS+508x16">CHS 508x16</option>
								<option value="CHS+508x20">CHS 508x20</option>
								<option value="CHS+508x25">CHS 508x25</option>
								<option value="CHS+508x30">CHS 508x30</option>
								<option value="CHS+508x40">CHS 508x40</option>
								<option value="CHS+508x50">CHS 508x50</option>
								<option value="CHS+610x6.3">CHS 610x6.3</option>
								<option value="CHS+610x8">CHS 610x8</option>
								<option value="CHS+610x10">CHS 610x10</option>
								<option value="CHS+610x12.5">CHS 610x12.5</option>
								<option value="CHS+610x14.2">CHS 610x14.2</option>
								<option value="CHS+610x16">CHS 610x16</option>
								<option value="CHS+610x20">CHS 610x20</option>
								<option value="CHS+610x25">CHS 610x25</option>
								<option value="CHS+610x30">CHS 610x30</option>
								<option value="CHS+610x40">CHS 610x40</option>
								<option value="CHS+610x50">CHS 610x50</option>
								<option value="CHS+711x6.3">CHS 711x6.3</option>
								<option value="CHS+711x8">CHS 711x8</option>
								<option value="CHS+711x10">CHS 711x10</option>
								<option value="CHS+711x12.5">CHS 711x12.5</option>
								<option value="CHS+711x14.2">CHS 711x14.2</option>
								<option value="CHS+711x16">CHS 711x16</option>
								<option value="CHS+711x20">CHS 711x20</option>
								<option value="CHS+711x25">CHS 711x25</option>
								<option value="CHS+711x30">CHS 711x30</option>
								<option value="CHS+711x40">CHS 711x40</option>
								<option value="CHS+711x50">CHS 711x50</option>
								<option value="CHS+711x60">CHS 711x60</option>
								<option value="CHS+762x6">CHS 762x6</option>
								<option value="CHS+762x6.3">CHS 762x6.3</option>
								<option value="CHS+762x8">CHS 762x8</option>
								<option value="CHS+762x10">CHS 762x10</option>
								<option value="CHS+762x12.5">CHS 762x12.5</option>
								<option value="CHS+762x14.2">CHS 762x14.2</option>
								<option value="CHS+762x16">CHS 762x16</option>
								<option value="CHS+762x20">CHS 762x20</option>
								<option value="CHS+762x25">CHS 762x25</option>
								<option value="CHS+762x30">CHS 762x30</option>
								<option value="CHS+762x40">CHS 762x40</option>
								<option value="CHS+762x50">CHS 762x50</option>
								<option value="CHS+813x8">CHS 813x8</option>
								<option value="CHS+813x10">CHS 813x10</option>
								<option value="CHS+813x12.5">CHS 813x12.5</option>
								<option value="CHS+813x14.2">CHS 813x14.2</option>
								<option value="CHS+813x16">CHS 813x16</option>
								<option value="CHS+813x20">CHS 813x20</option>
								<option value="CHS+813x25">CHS 813x25</option>
								<option value="CHS+813x30">CHS 813x30</option>
								<option value="CHS+914x8">CHS 914x8</option>
								<option value="CHS+914x10">CHS 914x10</option>
								<option value="CHS+914x12.5">CHS 914x12.5</option>
								<option value="CHS+914x14.2">CHS 914x14.2</option>
								<option value="CHS+914x16">CHS 914x16</option>
								<option value="CHS+914x20">CHS 914x20</option>
								<option value="CHS+914x25">CHS 914x25</option>
								<option value="CHS+914x30">CHS 914x30</option>
								<option value="CHS+1016x8">CHS 1016x8</option>
								<option value="CHS+1016x10">CHS 1016x10</option>
								<option value="CHS+1016x12.5">CHS 1016x12.5</option>
								<option value="CHS+1016x14.2">CHS 1016x14.2</option>
								<option value="CHS+1016x16">CHS 1016x16</option>
								<option value="CHS+1016x20">CHS 1016x20</option>
								<option value="CHS+1016x25">CHS 1016x25</option>
								<option value="CHS+1016x30">CHS 1016x30</option>
								<option value="CHS+1067x10">CHS 1067x10</option>
								<option value="CHS+1067x12.5">CHS 1067x12.5</option>
								<option value="CHS+1067x14.2">CHS 1067x14.2</option>
								<option value="CHS+1067x16">CHS 1067x16</option>
								<option value="CHS+1067x20">CHS 1067x20</option>
								<option value="CHS+1067x25">CHS 1067x25</option>
								<option value="CHS+1067x30">CHS 1067x30</option>
								<option value="CHS+1168x10">CHS 1168x10</option>
								<option value="CHS+1168x12.5">CHS 1168x12.5</option>
								<option value="CHS+1168x14.2">CHS 1168x14.2</option>
								<option value="CHS+1168x16">CHS 1168x16</option>
								<option value="CHS+1168x20">CHS 1168x20</option>
								<option value="CHS+1168x25">CHS 1168x25</option>
								<option value="CHS+1219x10">CHS 1219x10</option>
								<option value="CHS+1219x12.5">CHS 1219x12.5</option>
								<option value="CHS+1219x16">CHS 1219x16</option>
								<option value="CHS+1219x14.2">CHS 1219x14.2</option>
								<option value="CHS+1219x20">CHS 1219x20</option>
								<option value="CHS+1219x25">CHS 1219x25</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>

		<%
		}
		%>

		<%
		if (request.getParameter("buttonRHS") != null) {
		%>
		<div class="profiles">
			<table>
				<tbody>
					<tr>
						<td><label>Section:</label></td>
						<td><select name="profile" class="profile" id="profile">
								<option disabled selected>Select section</option>
								<option value="RHS+50x30x2.6">RHS 50x30x2.6</option>
								<option value="RHS+50x30x3.2">RHS 50x30x3.2</option>
								<option value="RHS+50x30x4">RHS 50x30x4</option>
								<option value="RHS+50x30x5">RHS 50x30x5</option>
								<option value="RHS+60x40x2.6">RHS 60x40x2.6</option>
								<option value="RHS+60x40x3.2">RHS 60x40x3.2</option>
								<option value="RHS+60x40x4">RHS 60x40x4</option>
								<option value="RHS+60x40x5">RHS 60x40x5</option>
								<option value="RHS+60x40x6.3">RHS 60x40x6.3</option>
								<option value="RHS+80x40x3.2">RHS 80x40x3.2</option>
								<option value="RHS+80x40x4">RHS 80x40x4</option>
								<option value="RHS+80x40x5">RHS 80x40x5</option>
								<option value="RHS+80x40x6.3">RHS 80x40x6.3</option>
								<option value="RHS+80x40x8">RHS 80x40x8</option>
								<option value="RHS+90x50x3.2">RHS 90x50x3.2</option>
								<option value="RHS+90x50x4">RHS 90x50x4</option>
								<option value="RHS+90x50x5">RHS 90x50x5</option>
								<option value="RHS+90x50x6.3">RHS 90x50x6.3</option>
								<option value="RHS+90x50x8">RHS 90x50x8</option>
								<option value="RHS+100x50x3.2">RHS 100x50x3.2</option>
								<option value="RHS+100x50x4">RHS 100x50x4</option>
								<option value="RHS+100x50x5">RHS 100x50x5</option>
								<option value="RHS+100x50x6.3">RHS 100x50x6.3</option>
								<option value="RHS+100x50x8">RHS 100x50x8</option>
								<option value="RHS+100x60x3.2">RHS 100x60x3.2</option>
								<option value="RHS+100x60x4">RHS 100x60x4</option>
								<option value="RHS+100x60x5">RHS 100x60x5</option>
								<option value="RHS+100x60x6.3">RHS 100x60x6.3</option>
								<option value="RHS+100x60x8">RHS 100x60x8</option>
								<option value="RHS+120x60x4">RHS 120x60x4</option>
								<option value="RHS+120x60x5">RHS 120x60x5</option>
								<option value="RHS+120x60x6.3">RHS 120x60x6.3</option>
								<option value="RHS+120x60x8">RHS 120x60x8</option>
								<option value="RHS+120x60x10">RHS 120x60x10</option>
								<option value="RHS+120x80x4">RHS 120x80x4</option>
								<option value="RHS+120x80x5">RHS 120x80x5</option>
								<option value="RHS+120x80x6.3">RHS 120x80x6.3</option>
								<option value="RHS+120x80x8">RHS 120x80x8</option>
								<option value="RHS+120x80x10">RHS 120x80x10</option>
								<option value="RHS+140x80x4">RHS 140x80x4</option>
								<option value="RHS+140x80x5">RHS 140x80x5</option>
								<option value="RHS+140x80x6.3">RHS 140x80x6.3</option>
								<option value="RHS+140x80x8">RHS 140x80x8</option>
								<option value="RHS+140x80x10">RHS 140x80x10</option>
								<option value="RHS+150x100x4">RHS 150x100x4</option>
								<option value="RHS+150x100x5">RHS 150x100x5</option>
								<option value="RHS+150x100x6.3">RHS 150x100x6.3</option>
								<option value="RHS+150x100x8">RHS 150x100x8</option>
								<option value="RHS+150x100x10">RHS 150x100x10</option>
								<option value="RHS+150x100x12.5">RHS 150x100x12.5</option>
								<option value="RHS+160x80x4">RHS 160x80x4</option>
								<option value="RHS+160x80x5">RHS 160x80x5</option>
								<option value="RHS+160x80x6.3">RHS 160x80x6.3</option>
								<option value="RHS+160x80x8">RHS 160x80x8</option>
								<option value="RHS+160x80x10">RHS 160x80x10</option>
								<option value="RHS+160x80x12.5">RHS 160x80x12.5</option>
								<option value="RHS+180x100x4">RHS 180x100x4</option>
								<option value="RHS+180x100x5">RHS 180x100x5</option>
								<option value="RHS+180x100x6.3">RHS 180x100x6.3</option>
								<option value="RHS+180x100x8">RHS 180x100x8</option>
								<option value="RHS+180x100x10">RHS 180x100x10</option>
								<option value="RHS+180x100x12.5">RHS 180x100x12.5</option>
								<option value="RHS+200x100x4">RHS 200x100x4</option>
								<option value="RHS+200x100x5">RHS 200x100x5</option>
								<option value="RHS+200x100x6.3">RHS 200x100x6.3</option>
								<option value="RHS+200x100x8">RHS 200x100x8</option>
								<option value="RHS+200x100x10">RHS 200x100x10</option>
								<option value="RHS+200x100x12.5">RHS 200x100x12.5</option>
								<option value="RHS+200x100x16">RHS 200x100x16</option>
								<option value="RHS+200x120x6.3">RHS 200x120x6.3</option>
								<option value="RHS+200x120x8">RHS 200x120x8</option>
								<option value="RHS+200x120x10">RHS 200x120x10</option>
								<option value="RHS+200x120x12.5">RHS 200x120x12.5</option>
								<option value="RHS+250x150x6.3">RHS 250x150x6.3</option>
								<option value="RHS+250x150x8">RHS 250x150x8</option>
								<option value="RHS+250x150x10">RHS 250x150x10</option>
								<option value="RHS+250x150x12.5">RHS 250x150x12.5</option>
								<option value="RHS+250x150x14.2">RHS 250x150x14.2</option>
								<option value="RHS+250x150x16">RHS 250x150x16</option>
								<option value="RHS+260x180x6.3">RHS 260x180x6.3</option>
								<option value="RHS+260x180x8">RHS 260x180x8</option>
								<option value="RHS+260x180x10">RHS 260x180x10</option>
								<option value="RHS+260x180x12.5">RHS 260x180x12.5</option>
								<option value="RHS+260x180x14.2">RHS 260x180x14.2</option>
								<option value="RHS+260x180x16">RHS 260x180x16</option>
								<option value="RHS+300x200x6.3">RHS 300x200x6.3</option>
								<option value="RHS+300x200x8">RHS 300x200x8</option>
								<option value="RHS+300x200x10">RHS 300x200x10</option>
								<option value="RHS+300x200x12.5">RHS 300x200x12.5</option>
								<option value="RHS+300x200x14.2">RHS 300x200x14.2</option>
								<option value="RHS+300x200x16">RHS 300x200x16</option>
								<option value="RHS+350x250x6.3">RHS 350x250x6.3</option>
								<option value="RHS+350x250x8">RHS 350x250x8</option>
								<option value="RHS+350x250x10">RHS 350x250x10</option>
								<option value="RHS+350x250x12.5">RHS 350x250x12.5</option>
								<option value="RHS+350x250x14.2">RHS 350x250x14.2</option>
								<option value="RHS+350x250x16">RHS 350x250x16</option>
								<option value="RHS+400x200x8">RHS 400x200x8</option>
								<option value="RHS+400x200x10">RHS 400x200x10</option>
								<option value="RHS+400x200x12.5">RHS 400x200x12.5</option>
								<option value="RHS+400x200x14.2">RHS 400x200x14.2</option>
								<option value="RHS+400x200x16">RHS 400x200x16</option>
								<option value="RHS+450x250x8">RHS 450x250x8</option>
								<option value="RHS+450x250x10">RHS 450x250x10</option>
								<option value="RHS+450x250x12.5">RHS 450x250x12.5</option>
								<option value="RHS+450x250x14.2">RHS 450x250x14.2</option>
								<option value="RHS+450x250x16">RHS 450x250x16</option>
								<option value="RHS+500x300x10">RHS 500x300x10</option>
								<option value="RHS+500x300x12.5">RHS 500x300x12.5</option>
								<option value="RHS+500x300x14.2">RHS 500x300x14.2</option>
								<option value="RHS+500x300x16">RHS 500x300x16</option>
								<option value="RHS+500x300x20">RHS 500x300x20</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%
		}
		%>

		<%
		if (request.getParameter("buttonSHS") != null) {
		%>
		<div class="profiles">
			<table>
				<tbody>
					<tr>
						<td><label>Section:</label></td>
						<td><select name="profile" class="profile" id="profile">
								<option disabled selected>Select section</option>
								<option value="SHS+40x2.6">SHS 40x2.6</option>
								<option value="SHS+40x3.2">SHS 40x3.2</option>
								<option value="SHS+40x4">SHS 40x4</option>
								<option value="SHS+40x5">SHS 40x5</option>
								<option value="SHS+50x2.6">SHS 50x2.6</option>
								<option value="SHS+50x3.2">SHS 50x3.2</option>
								<option value="SHS+50x4">SHS 50x4</option>
								<option value="SHS+50x5">SHS 50x5</option>
								<option value="SHS+50x6.3">SHS 50x6.3</option>
								<option value="SHS+60x2.6">SHS 60x2.6</option>
								<option value="SHS+60x3.2">SHS 60x3.2</option>
								<option value="SHS+60x4">SHS 60x4</option>
								<option value="SHS+60x5">SHS 60x5</option>
								<option value="SHS+60x6.3">SHS 60x6.3</option>
								<option value="SHS+60x8">SHS 60x8</option>
								<option value="SHS+70x3.2">SHS 70x3.2</option>
								<option value="SHS+70x4">SHS 70x4</option>
								<option value="SHS+70x5">SHS 70x5</option>
								<option value="SHS+70x6.3">SHS 70x6.3</option>
								<option value="SHS+70x8">SHS 70x8</option>
								<option value="SHS+80x3.2">SHS 80x3.2</option>
								<option value="SHS+80x4">SHS 80x4</option>
								<option value="SHS+80x5">SHS 80x5</option>
								<option value="SHS+80x6.3">SHS 80x6.3</option>
								<option value="SHS+80x8">SHS 80x8</option>
								<option value="SHS+90x4">SHS 90x4</option>
								<option value="SHS+90x5">SHS 90x5</option>
								<option value="SHS+90x6.3">SHS 90x6.3</option>
								<option value="SHS+90x8">SHS 90x8</option>
								<option value="SHS+100x4">SHS 100x4</option>
								<option value="SHS+100x5">SHS 100x5</option>
								<option value="SHS+100x6.3">SHS 100x6.3</option>
								<option value="SHS+100x8">SHS 100x8</option>
								<option value="SHS+100x10">SHS 100x10</option>
								<option value="SHS+120x5">SHS 120x5</option>
								<option value="SHS+120x6.3">SHS 120x6.3</option>
								<option value="SHS+120x8">SHS 120x8</option>
								<option value="SHS+120x10">SHS 120x10</option>
								<option value="SHS+120x12.5">SHS 120x12.5</option>
								<option value="SHS+140x5">SHS 140x5</option>
								<option value="SHS+140x6.3">SHS 140x6.3</option>
								<option value="SHS+140x8">SHS 140x8</option>
								<option value="SHS+140x10">SHS 140x10</option>
								<option value="SHS+140x12.5">SHS 140x12.5</option>
								<option value="SHS+150x5">SHS 150x5</option>
								<option value="SHS+150x6.3">SHS 150x6.3</option>
								<option value="SHS+150x8">SHS 150x8</option>
								<option value="SHS+150x10">SHS 150x10</option>
								<option value="SHS+150x12.5">SHS 150x12.5</option>
								<option value="SHS+150x14.2">SHS 150x14.2</option>
								<option value="SHS+150x16">SHS 150x16</option>
								<option value="SHS+160x5">SHS 160x5</option>
								<option value="SHS+160x6.3">SHS 160x6.3</option>
								<option value="SHS+160x8">SHS 160x8</option>
								<option value="SHS+160x10">SHS 160x10</option>
								<option value="SHS+160x12.5">SHS 160x12.5</option>
								<option value="SHS+160x16">SHS 160x16</option>
								<option value="SHS+180x5">SHS 180x5</option>
								<option value="SHS+180x6.3">SHS 180x6.3</option>
								<option value="SHS+180x8">SHS 180x8</option>
								<option value="SHS+180x10">SHS 180x10</option>
								<option value="SHS+180x12.5">SHS 180x12.5</option>
								<option value="SHS+180x14.2">SHS 180x14.2</option>
								<option value="SHS+180x16">SHS 180x16</option>
								<option value="SHS+200x5">SHS 200x5</option>
								<option value="SHS+200x6.3">SHS 200x6.3</option>
								<option value="SHS+200x8">SHS 200x8</option>
								<option value="SHS+200x10">SHS 200x10</option>
								<option value="SHS+200x12.5">SHS 200x12.5</option>
								<option value="SHS+200x14.2">SHS 200x14.2</option>
								<option value="SHS+200x16">SHS 200x16</option>
								<option value="SHS+220x6.3">SHS 220x6.3</option>
								<option value="SHS+220x8">SHS 220x8</option>
								<option value="SHS+220x10">SHS 220x10</option>
								<option value="SHS+220x12.5">SHS 220x12.5</option>
								<option value="SHS+220x14.2">SHS 220x14.2</option>
								<option value="SHS+220x16">SHS 220x16</option>
								<option value="SHS+250x6.3">SHS 250x6.3</option>
								<option value="SHS+250x8">SHS 250x8</option>
								<option value="SHS+250x10">SHS 250x10</option>
								<option value="SHS+250x12.5">SHS 250x12.5</option>
								<option value="SHS+250x14.2">SHS 250x14.2</option>
								<option value="SHS+250x16">SHS 250x16</option>
								<option value="SHS+260x6.3">SHS 260x6.3</option>
								<option value="SHS+260x8">SHS 260x8</option>
								<option value="SHS+260x10">SHS 260x10</option>
								<option value="SHS+260x12.5">SHS 260x12.5</option>
								<option value="SHS+260x14.2">SHS 260x14.2</option>
								<option value="SHS+260x16">SHS 260x16</option>
								<option value="SHS+300x6.3">SHS 300x6.3</option>
								<option value="SHS+300x8">SHS 300x8</option>
								<option value="SHS+300x10">SHS 300x10</option>
								<option value="SHS+300x12.5">SHS 300x12.5</option>
								<option value="SHS+300x14.2">SHS 300x14.2</option>
								<option value="SHS+300x16">SHS 300x16</option>
								<option value="SHS+350x8">SHS 350x8</option>
								<option value="SHS+350x10">SHS 350x10</option>
								<option value="SHS+350x12.5">SHS 350x12.5</option>
								<option value="SHS+350x14.2">SHS 350x14.2</option>
								<option value="SHS+350x16">SHS 350x16</option>
								<option value="SHS+400x10">SHS 400x10</option>
								<option value="SHS+400x12.5">SHS 400x12.5</option>
								<option value="SHS+400x14.2">SHS 400x14.2</option>
								<option value="SHS+400x16">SHS 400x16</option>
								<option value="SHS+400x20">SHS 400x20</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%
		}
		%>

		<%
		if (request.getParameter("buttonLE") != null) {
		%>
		<div class="profiles">
			<table>
				<tbody>
					<tr>
						<td><label>Section:</label></td>
						<td><select name="profile" class="profile" id="profile">
								<option disabled selected>Select section</option>
								<option value="Le+20x20x3">L 20x20x3</option>
								<option value="Le+22x22x3">L 22x22x3</option>
								<option value="Le+25x25x3">L 25x25x3</option>
								<option value="Le+25x25x4">L 25x25x4</option>
								<option value="Le+28x28x3">L 28x28x3</option>
								<option value="Le+30x30x3">L 30x30x3</option>
								<option value="Le+30x30x4">L 30x30x4</option>
								<option value="Le+32x32x3">L 32x32x3</option>
								<option value="Le+32x32x4">L 32x32x4</option>
								<option value="Le+35x35x3">L 35x35x3</option>
								<option value="Le+35x35x4">L 35x35x4</option>
								<option value="Le+36x36x3">L 36x36x3</option>
								<option value="Le+36x36x4">L 36x36x4</option>
								<option value="Le+40x40x3">L 40x40x3</option>
								<option value="Le+40x40x4">L 40x40x4</option>
								<option value="Le+40x40x5">L 40x40x5</option>
								<option value="Le+45x45x3">L 45x45x3</option>
								<option value="Le+45x45x4">L 45x45x4</option>
								<option value="Le+45x45x4.5">L 45x45x4.5</option>
								<option value="Le+45x45x5">L 45x45x5</option>
								<option value="Le+50x50x4">L 50x50x4</option>
								<option value="Le+50x50x5">L 50x50x5</option>
								<option value="Le+50x50x6">L 50x50x6</option>
								<option value="Le+50x50x7">L 50x50x7</option>
								<option value="Le+55x55x5">L 55x55x5</option>
								<option value="Le+55x55x6">L 55x55x6</option>
								<option value="Le+56x56x4">L 56x56x4</option>
								<option value="Le+56x56x5">L 56x56x5</option>
								<option value="Le+56x56x6">L 56x56x6</option>
								<option value="Le+60x60x4">L 60x60x4</option>
								<option value="Le+60x60x5">L 60x60x5</option>
								<option value="Le+60x60x6">L 60x60x6</option>
								<option value="Le+60x60x8">L 60x60x8</option>
								<option value="Le+63x63x4">L 63x63x4</option>
								<option value="Le+63x63x5">L 63x63x5</option>
								<option value="Le+63x63x6">L 63x63x6</option>
								<option value="Le+65x65x6">L 65x65x6</option>
								<option value="Le+65x65x7">L 65x65x7</option>
								<option value="Le+65x65x8">L 65x65x8</option>
								<option value="Le+70x70x5">L 70x70x5</option>
								<option value="Le+70x70x6">L 70x70x6</option>
								<option value="Le+70x70x7">L 70x70x7</option>
								<option value="Le+70x70x8">L 70x70x8</option>
								<option value="Le+70x70x9">L 70x70x9</option>
								<option value="Le+75x75x4">L 75x75x4</option>
								<option value="Le+75x75x5">L 75x75x5</option>
								<option value="Le+75x75x6">L 75x75x6</option>
								<option value="Le+75x75x7">L 75x75x7</option>
								<option value="Le+75x75x8">L 75x75x8</option>
								<option value="Le+75x75x10">L 75x75x10</option>
								<option value="Le+80x80x5">L 80x80x5</option>
								<option value="Le+80x80x6">L 80x80x6</option>
								<option value="Le+80x80x7">L 80x80x7</option>
								<option value="Le+80x80x8">L 80x80x8</option>
								<option value="Le+80x80x10">L 80x80x10</option>
								<option value="Le+90x90x6">L 90x90x6</option>
								<option value="Le+90x90x7">L 90x90x7</option>
								<option value="Le+90x90x8">L 90x90x8</option>
								<option value="Le+90x90x9">L 90x90x9</option>
								<option value="Le+90x90x10">L 90x90x10</option>
								<option value="Le+90x90x11">L 90x90x11</option>
								<option value="Le+100x100x6">L 100x100x6</option>
								<option value="Le+100x100x7">L 100x100x7</option>
								<option value="Le+100x100x8">L 100x100x8</option>
								<option value="Le+100x100x10">L 100x100x10</option>
								<option value="Le+100x100x12">L 100x100x12</option>
								<option value="Le+110x110x8">L 110x110x8</option>
								<option value="Le+110x110x10">L 110x110x10</option>
								<option value="Le+110x110x12">L 110x110x12</option>
								<option value="Le+120x120x8">L 120x120x8</option>
								<option value="Le+120x120x10">L 120x120x10</option>
								<option value="Le+120x120x11">L 120x120x11</option>
								<option value="Le+120x120x12">L 120x120x12</option>
								<option value="Le+120x120x13">L 120x120x13</option>
								<option value="Le+120x120x15">L 120x120x15</option>
								<option value="Le+120x120x16">L 120x120x16</option>
								<option value="Le+125x125x8">L 125x125x8</option>
								<option value="Le+125x125x10">L 125x125x10</option>
								<option value="Le+125x125x12">L 125x125x12</option>
								<option value="Le+125x125x14">L 125x125x14</option>
								<option value="Le+130x130x10">L 130x130x10</option>
								<option value="Le+130x130x12">L 130x130x12</option>
								<option value="Le+130x130x13">L 130x130x13</option>
								<option value="Le+130x130x14">L 130x130x14</option>
								<option value="Le+130x130x16">L 130x130x16</option>
								<option value="Le+140x140x10">L 140x140x10</option>
								<option value="Le+140x140x12">L 140x140x12</option>
								<option value="Le+140x140x14">L 140x140x14</option>
								<option value="Le+150x150x10">L 150x150x10</option>
								<option value="Le+150x150x12">L 150x150x12</option>
								<option value="Le+150x150x13">L 150x150x13</option>
								<option value="Le+150x150x14">L 150x150x14</option>
								<option value="Le+150x150x15">L 150x150x15</option>
								<option value="Le+150x150x16">L 150x150x16</option>
								<option value="Le+150x150x18">L 150x150x18</option>
								<option value="Le+150x150x20">L 150x150x20</option>
								<option value="Le+160x160x10">L 160x160x10</option>
								<option value="Le+160x160x12">L 160x160x12</option>
								<option value="Le+160x160x14">L 160x160x14</option>
								<option value="Le+160x160x15">L 160x160x15</option>
								<option value="Le+160x160x16">L 160x160x16</option>
								<option value="Le+160x160x17">L 160x160x17</option>
								<option value="Le+180x180x12">L 180x180x12</option>
								<option value="Le+180x180x13">L 180x180x13</option>
								<option value="Le+180x180x14">L 180x180x14</option>
								<option value="Le+180x180x15">L 180x180x15</option>
								<option value="Le+180x180x16">L 180x180x16</option>
								<option value="Le+180x180x17">L 180x180x17</option>
								<option value="Le+180x180x18">L 180x180x18</option>
								<option value="Le+180x180x19">L 180x180x19</option>
								<option value="Le+180x180x20">L 180x180x20</option>
								<option value="Le+200x200x14">L 200x200x14</option>
								<option value="Le+200x200x15">L 200x200x15</option>
								<option value="Le+200x200x16">L 200x200x16</option>
								<option value="Le+200x200x17">L 200x200x17</option>
								<option value="Le+200x200x18">L 200x200x18</option>
								<option value="Le+200x200x19">L 200x200x19</option>
								<option value="Le+200x200x20">L 200x200x20</option>
								<option value="Le+200x200x21">L 200x200x21</option>
								<option value="Le+200x200x22">L 200x200x22</option>
								<option value="Le+200x200x23">L 200x200x23</option>
								<option value="Le+200x200x24">L 200x200x24</option>
								<option value="Le+200x200x25">L 200x200x25</option>
								<option value="Le+200x200x26">L 200x200x26</option>
								<option value="Le+250x250x20">L 250x250x20</option>
								<option value="Le+250x250x21">L 250x250x21</option>
								<option value="Le+250x250x22">L 250x250x22</option>
								<option value="Le+250x250x23">L 250x250x23</option>
								<option value="Le+250x250x24">L 250x250x24</option>
								<option value="Le+250x250x25">L 250x250x25</option>
								<option value="Le+250x250x26">L 250x250x26</option>
								<option value="Le+250x250x27">L 250x250x27</option>
								<option value="Le+250x250x28">L 250x250x28</option>
								<option value="Le+250x250x35">L 250x250x35</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%
		}
		%>

		<%
		if (request.getParameter("buttonLU") != null) {
		%>
		<div class="profiles">
			<table>
				<tbody>
					<tr>
						<td><label>Section:</label></td>
						<td><select name="profile" class="profile" id="profile">
								<option disabled selected>Select section</option>
								<option value="Lu+25x16x3">L 25x16x3</option>
								<option value="Lu+30x20x3">L 30x20x3</option>
								<option value="Lu+30x20x4">L 30x20x4</option>
								<option value="Lu+32x20x3">L 32x20x3</option>
								<option value="Lu+40x25x3">L 40x25x3</option>
								<option value="Lu+40x25x4">L 40x25x4</option>
								<option value="Lu+40x25x5">L 40x25x5</option>
								<option value="Lu+45x28x4">L 45x28x4</option>
								<option value="Lu+45x30x4">L 45x30x4</option>
								<option value="Lu+45x30x5">L 45x30x5</option>
								<option value="Lu+50x30x4">L 50x30x4</option>
								<option value="Lu+50x30x5">L 50x30x5</option>
								<option value="Lu+50x32x3">L 50x32x3</option>
								<option value="Lu+50x32x4">L 50x32x4</option>
								<option value="Lu+56x36x4">L 56x36x4</option>
								<option value="Lu+56x36x5">L 56x36x5</option>
								<option value="Lu+60x40x5">L 60x40x5</option>
								<option value="Lu+60x40x6">L 60x40x6</option>
								<option value="Lu+60x40x7">L 60x40x7</option>
								<option value="Lu+63x40x4">L 63x40x4</option>
								<option value="Lu+63x40x5">L 63x40x5</option>
								<option value="Lu+63x40x6">L 63x40x6</option>
								<option value="Lu+65x50x5">L 65x50x5</option>
								<option value="Lu+65x50x6">L 65x50x6</option>
								<option value="Lu+65x50x7">L 65x50x7</option>
								<option value="Lu+65x50x8">L 65x50x8</option>
								<option value="Lu+70x45x5">L 70x45x5</option>
								<option value="Lu+70x45x6">L 70x45x6</option>
								<option value="Lu+75x50x5">L 75x50x5</option>
								<option value="Lu+75x50x6">L 75x50x6</option>
								<option value="Lu+75x50x7">L 75x50x7</option>
								<option value="Lu+75x50x8">L 75x50x8</option>
								<option value="Lu+80x50x5">L 80x50x5</option>
								<option value="Lu+80x50x6">L 80x50x6</option>
								<option value="Lu+80x50x8">L 80x50x8</option>
								<option value="Lu+80x60x6">L 80x60x6</option>
								<option value="Lu+80x60x7">L 80x60x7</option>
								<option value="Lu+80x60x8">L 80x60x8</option>
								<option value="Lu+90x56x6">L 90x56x6</option>
								<option value="Lu+90x56x8">L 90x56x8</option>
								<option value="Lu+90x60x6">L 90x60x6</option>
								<option value="Lu+90x60x8">L 90x60x8</option>
								<option value="Lu+100x63x8">L 100x63x8</option>
								<option value="Lu+100x63x10">L 100x63x10</option>
								<option value="Lu+100x65x7">L 100x65x7</option>
								<option value="Lu+100x65x8">L 100x65x8</option>
								<option value="Lu+100x65x9">L 100x65x9</option>
								<option value="Lu+100x65x10">L 100x65x10</option>
								<option value="Lu+100x65x12">L 100x65x12</option>
								<option value="Lu+110x70x8">L 110x70x8</option>
								<option value="Lu+110x70x10">L 110x70x10</option>
								<option value="Lu+110x70x12">L 110x70x12</option>
								<option value="Lu+120x80x8">L 120x80x8</option>
								<option value="Lu+120x80x10">L 120x80x10</option>
								<option value="Lu+120x80x12">L 120x80x12</option>
								<option value="Lu+125x75x8">L 125x75x8</option>
								<option value="Lu+125x75x9">L 125x75x9</option>
								<option value="Lu+125x75x10">L 125x75x10</option>
								<option value="Lu+125x75x12">L 125x75x12</option>
								<option value="Lu+125x80x8">L 125x80x8</option>
								<option value="Lu+125x80x10">L 125x80x10</option>
								<option value="Lu+125x80x12">L 125x80x12</option>
								<option value="Lu+130x90x10">L 130x90x10</option>
								<option value="Lu+130x90x12">L 130x90x12</option>
								<option value="Lu+130x90x14">L 130x90x14</option>
								<option value="Lu+140x90x8">L 140x90x8</option>
								<option value="Lu+140x90x10">L 140x90x10</option>
								<option value="Lu+140x90x12">L 140x90x12</option>
								<option value="Lu+140x90x14">L 140x90x14</option>
								<option value="Lu+150x75x9">L 150x75x9</option>
								<option value="Lu+150x75x10">L 150x75x10</option>
								<option value="Lu+150x75x11">L 150x75x11</option>
								<option value="Lu+150x75x12">L 150x75x12</option>
								<option value="Lu+150x90x10">L 150x90x10</option>
								<option value="Lu+150x90x11">L 150x90x11</option>
								<option value="Lu+150x90x12">L 150x90x12</option>
								<option value="Lu+150x90x15">L 150x90x15</option>
								<option value="Lu+150x100x10">L 150x100x10</option>
								<option value="Lu+150x100x12">L 150x100x12</option>
								<option value="Lu+150x100x14">L 150x100x14</option>
								<option value="Lu+160x100x10">L 160x100x10</option>
								<option value="Lu+160x100x12">L 160x100x12</option>
								<option value="Lu+160x100x14">L 160x100x14</option>
								<option value="Lu+160x100x16">L 160x100x16</option>
								<option value="Lu+200x100x10">L 200x100x10</option>
								<option value="Lu+200x100x12">L 200x100x12</option>
								<option value="Lu+200x100x14">L 200x100x14</option>
								<option value="Lu+200x100x15">L 200x100x15</option>
						</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%
		}
		%>

		<div class="nav">
			<table border="1">
				<tbody>
					<tr>
						<td><label for="fillParameters">Fill parameters:</label></td>
					</tr>
					<tr>
						<td>
							<table border="1">
								<tbody>
									<tr>
										<td><label for="reaction">Reaction force [A]:</label></td>
										<td><input type="text" name="reaction"
											disabled="disabled" value="A=PL/2"> N</td>
									</tr>
									<tr>
										<td><label for="elastic">Elastic modulus [E]:</label></td>
										<td><input type="text" name="elastic" disabled="disabled">N/m&#xB2;;</td>
									</tr>
									<tr>
										<td><label for="inertia">Moment of inertia [J]:</label></td>
										<td><input type="text" name="elastic" disabled="disabled">m&#8308;</td>
									</tr>
								</tbody>
							</table>
						</td>
						<td>
							<table border="1">
								<tbody>
									<tr>
										<td><label for="force">Applied force [P]:</label></td>
										<td><input type="text" name="reaction" disabled
											class="selector"></td>
									</tr>
									<tr>
										<td><label for="lenght">Total lenght [L]:</label></td>
										<td><input type="text" name="lenght" disabled
											class="selector"> m</td>
									</tr>

									<tr>
										<td><label for="lenghtx">Lenght [x]:</label></td>
										<td><input type="text" name="lenghtx" disabled
											class="selector"> m</td>
									</tr>
								</tbody>
							</table>
						</td>
						<td><img src="cases-images/case3.png" alt="image not found">
						</td>

						<%
						if (request.getParameter("buttonCHS") != null) {
						%>
						<td><img src="profile-images/profile-chs.png"
							alt="image not found" width="135" class="image"></td>
						<%
						}
						%>

						<%
						if (request.getParameter("buttonSHS") != null) {
						%>
						<td><img src="profile-images/profile-shs.png"
							alt="image not found" width="150" class="image"></td>
						<%
						}
						%>

						<%
						if (request.getParameter("buttonRHS") != null) {
						%>
						<td><img src="profile-images/profile-rhs.png"
							alt="image not found" width="135" class="image"></td>
						<%
						}
						%>

						<%
						if (request.getParameter("buttonLE") != null) {
						%>
						<td><img src="profile-images/profile-le.png"
							alt="image not found" width="150" class="image"></td>
						<%
						}
						%>

						<%
						if (request.getParameter("buttonLU") != null) {
						%>
						<td><img src="profile-images/profile-lu.png"
							alt="image not found" width="150" class="image"></td>
						<%
						}
						%>
					</tr>
					<tr>
						<td colspan="4" align="center"><h3>RESULT</h3> <input
							type="submit" value="Calculate" id="calculateButton"
							name="calculateButton" hidden="true"></td>

					</tr>
					<tr>
						<td colspan="4" align="center">
							<table border="1">
								<tbody>
									<tr>
										<td><label for="deformationP">Deformation at P:</label></td>
										<td><input type="text" name="deformamtionP"
											name="deformationP" disabled>
									</tr>
									<tr>
										<td><label for="deformationX">Deformation at X:</label></td>
										<td><input type="text" name="deformamtionX"
											name="deformationX" disabled>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="code.js"></script>

</html>