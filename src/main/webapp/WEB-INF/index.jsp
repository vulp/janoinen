<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fi">
<head>
    <c:set var="url">${pageContext.request.contextPath}</c:set>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Helsingin hanat</title>
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${url}/css/style.css" rel="stylesheet" media="screen">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="${url}/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $.get('${url}/lintu', function(data){
              $('#lintu').html(data);
            });
        });
    </script>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Project name</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link">Username</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Pikalinkit</li>
              <li class="active"><a href="#">Pikkulintu</a></li>
              <li><a href="#">Kaisla</a></li>
              <li><a href="#">5 penniä</a></li>
              <li><a href="#">Joku</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10">
          <div class="hero-unit">
            <h1>Helsingin hanat</h1>
            <p>Tähän tulee valitutpalat taulukko!</p>
          </div>
          <div class="row-fluid">
            <div class="span5">
              <h2>Pikkulintu</h2>
              <p>
              Klaavutie 2, Helsinki<br />
              Ma-pe 15-02<br />
              la 1-1<br />
              su 1-1<br />
              </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
              <div id="lintu"></div>
            </div><!--/span-->
            <div class="span5">
              <h2>Kaisla</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
          
          <div class="row-fluid">
            <div class="span5">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span5">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
          
        </div><!--/span-->
      </div><!--/row-->
    </div><!--/.fluid-container-->
</body>
</html>
