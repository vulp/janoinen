<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fi">
<head>
    <c:set var="url">${pageContext.request.contextPath}</c:set>
    <meta http-equiv="Content-Type" content="text/html; UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Helsingin hanat</title>
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${url}/css/style.css" rel="stylesheet" media="screen">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${url}/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function() {
            $.get('${url}/lintu/', function(data) {
                $('#lintu').append(data);
            });
            $.get('${url}/kaisla/', function(data) {
                $('#kaisla').append(data);
            });
            $.get('${url}/urho/', function(data) {
                $('#urho').append(data);
            });
            $.get('${url}/onepint/', function(data) {
                $('#onepint').append(data);
            });
            $.get('${url}/stones/', function(data) {
                $('#stones').append(data);
            });
            $.get('${url}/penni/', function(data) {
                $('#penni').append(data);
            });
            $.get('${url}/bruuveri/', function(data) {
                $('#bruuveri').append(data);
            });
            $.get('${url}/teerenpeli/', function(data) {
                $('#teerenpeli').append(data);
            });
            $.get('${url}/blackdoor/', function(data) {
                $('#blackdoor').append(data);
            });
            $.get('${url}/vltava/', function(data) {
                $('#vltava').append(data);
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
<div class="row-fluid">
<div class="span2">
    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            <li class="nav-header">Pikalinkit</li>
            <li><a href="#lintu-link">Pikkulintu</a></li>
            <li><a href="#kaisla-link">Kaisla</a></li>
            <li><a href="#urho-link">St. Urho´s</a></li>
            <li><a href="#onepint-link">One Pint Pub</a></li>
            <li><a href="#stones-link">Stone's</a></li>
            <li><a href="#penni-link">Viisi penniä</a></li>
            <li><a href="#bruuveri-link">Bruuveri</a></li>
            <li><a href="#teerenpeli-link">Teerenpeli</a></li>
            <li><a href="#blackdoor-link">Black Door</a></li>
            <li><a href="#vltava-link">Vltava</a></li>
        </ul>
    </div>
    <!--/.well -->
</div>
<!--/span-->
<div class="span10">
<div class="page-header">
    <h1>Helsingin hanat</h1>
    <blockquote>

    </blockquote>
</div>

<div class="row-fluid">
    <div class="span5">
        <a id="lintu-link"></a>

        <h2><a href="http://pikkulintu.fi">Pikkulintu</a></h2>

        <p>
            Klaavuntie 11, Helsinki<br/>
            Su - To 15 - 24<br/>
            Pe - La 15 - 02<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=klaavuntie+11,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="lintu">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
    <div class="span5">
        <a id="kaisla-link"></a>

        <h2><a href="http://www.oluthuone.fi/kaisla.html">Kaisla</a></h2>

        <p>
            Vilhonkatu 4, Helsinki<br/>
            Su - To 13 - 02<br/>
            Pe - La 13 - 03<br/>
            Ikäraja 18 vuotta<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=vilhonkatu+4,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="kaisla">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
</div>
<!--/row-->

<div class="row-fluid">
    <div class="span5">
        <a id="urho-link"></a>

        <h2><a href="http://www.botta.fi/fi/st+urhos+pub/etusivu/">St. Urho´s</a></h2>

        <p>
            Museokatu 10, Helsinki<br/>
            Su - Ti 15 - 01<br/>
            Ke - La 15 - 03<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=museokatu+10,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="urho">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
    <div class="span5">
        <a id="onepint-link"></a>

        <h2><a href="http://www.onepintpub.com">One Pint Pub</a></h2>

        <p>
            Santakatu 2, Helsinki<br/>
            Su - To 13 - 01<br/>
            Pe - La 13 - 02<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=santakatu+2,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="onepint">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
</div>
<!--/row-->

<div class="row-fluid">
    <div class="span5">
        <a id="stones-link"></a>

        <h2><a href="http://www.stonespub.fi">Stone's</a></h2>

        <p>
            Keskuskatu 4 , Helsinki<br/>
            Ti - To 13-02<br/>
            Pe - La 13-03<br/>
            Su - Ma 13-24<br/>
            Ikäraja 20v<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=keskuskatu+4,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="stones">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
    <div class="span5">
        <a id="penni-link"></a>

        <h2><a href="http://oluttupa.viisipennia.fi/">Viisi penniä</a></h2>

        <p>
            Mannerheimintie 55, Helsinki<br/>
            Ma - Pe 14-02<br/>
            La 12-02<br/>
            Su 12-24<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=mannerheimintie+55,helsinki"
              target="_blank">Reittiopas &raquo;</a></p>
        </p>
        <table class="table" id="penni">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
</div>
<!--/row-->

<div class="row-fluid">
    <div class="span5">
        <a id="bruuveri-link"></a>

        <h2><a href="http://bruuveri.fi/">Bruuveri</a></h2>

        <p>
            Fredrikinkatu 63, Helsinki<br/>
            Ma - Ti 10.30 - 24.00<br/>
            Ke - To 10.30 - 01.00<br/>
            Pe 10.30 - 02.00<br/>
            La 11.00 - 02.00<br/>
            Su 16.00 - 23.00<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=Fredrikinkatu+63,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="bruuveri">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
    <div class="span5">
        <a id="teerenpeli-link"></a>

        <h2><a href="http://www.teerenpeli.com/">Teerenpeli</a></h2>

        <p>
            Olavinkatu 2, Helsinki<br/>
            Ma - To 12 - 02<br/>
            Pe - La 12 - 03<br/>
            Su 15 - 24<br/>
            Ikäraja 22v.<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=Olavinkatu+2,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="teerenpeli">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
</div>
<!--/row-->

<div class="row-fluid">
    <div class="span5">
        <a id="blackdoor-link"></a>

        <h2><a href="http://www.delifox.fi/blackdoor/">Black Door</a></h2>

        <p>
            Iso Roobertinkatu 1, Helsinki<br/>
            Su - To 11 - 02<br/>
            Pe - La 11 - 03<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=Iso%20Roobertinakatu+1,helsinki"
              target="_blank">Reittiopas &raquo;</a></p>
        </p>
        <table class="table" id="blackdoor">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
    <div class="span5">
        <a id="vltava-link"></a>

        <h2><a href="http://www.vltava.fi/etusivu.html">Vltava</a></h2>

        <p>
            Elielinaukio 2, Helsinki<br/>
            Su - Ma 11 - 24<br/>
            Ti - To 11 - 03<br/>
            Pe - La 10 - 04<br/>

        <p><a class="btn" href="http://www.reittiopas.fi/fi/?to=Elielinaukio+2,helsinki"
              target="_blank">Reittiopas &raquo;</a>
        </p>
        </p>
        <table class="table" id="vltava">
            <tr>
                <th>Nimi</th>
                <th>&#37;</th>
                <th>&euro;</th>
                <th>Tietoa</th>
                <th>Arvostelu</th>
            </tr>
        </table>
    </div>
    <!--/span-->
</div>
<!--/row-->


</div>
<!--/span-->
</div>
<!--/row-->
</div>
<!--/.fluid-container-->
</body>
</html>
