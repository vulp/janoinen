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

</head>
<body>
<div class="container-fluid">
<div class="row-fluid">

<!--/span-->
<div class="span10">
<div class="page-header">
    <h1>Helsingin hanat / testit</h1>
    <blockquote>

    </blockquote>
</div>

<div class="row-fluid">
    <div class="span5">
        <h2><a href="https://www.google.com/maps?saddr=Klaavuntie+11,+Helsinki&daddr=Mannerheimintie+55,+Helsinki+to:Museokatu+10,+Helsinki+to:Santakatu+2,+Helsinki+to:Keskuskatu+4+,+Helsinki+to:Vilhonkatu+4,+Helsinki+to:Fredrikinkatu+63,+Helsinki+to:Olavinkatu+2,+Helsinki+to:Iso+Roobertinkatu+1,+Helsinki+to:Elielinaukio+2,+Helsinki&hl=en&sll=60.180453,24.967976&sspn=0.073241,0.169945&geocode=FWfFlgMduO5-ASm1KQ0VLw-SRjEk2omycmpR3w%3BFahtlgMdNTB8ASlz--mLIAqSRjFGbW71WZEQTQ%3BFdAulgMdpG18ASm_7RpDMgqSRjFcPNrFIgkurQ%3BFRkDlgMd_Dx8ASlxIq1MSgqSRjEtUSQsVlMdXg%3BFX0blgMdcJh8ASm7yRVAzAuSRjHNRtdJhtL-fA%3BFQYnlgMdE6l8ASnhc-jxzQuSRjHYDyldTQI5Pg%3BFY4XlgMdY258ASmpji-2NAqSRjHzyL3wa25jDA%3BFcoflgMd9nR8ASn3spZqMwqSRjG2IyHCv2NXDA%3BFasIlgMdspx8ASlJY-YKyQuSRjHA_BrHwRZ_kg%3BFV0klgMdoY18ASkfrv8izQuSRjFh6Gn76Fzfng&mra=ls&t=m&z=12">Beer map</a></h2>

        <p></p>
        <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps?f=d&amp;source=s_d&amp;saddr=Klaavuntie+11,+Helsinki&amp;daddr=Mannerheimintie+55,+Helsinki+to:Museokatu+10,+Helsinki+to:Santakatu+2,+Helsinki+to:Keskuskatu+4+,+Helsinki+to:Vilhonkatu+4,+Helsinki+to:Fredrikinkatu+63,+Helsinki+to:Olavinkatu+2,+Helsinki+to:Iso+Roobertinkatu+1,+Helsinki+to:Elielinaukio+2,+Helsinki&amp;hl=en&amp;geocode=FWfFlgMduO5-ASm1KQ0VLw-SRjEk2omycmpR3w%3BFahtlgMdNTB8ASlz--mLIAqSRjFGbW71WZEQTQ%3BFdAulgMdpG18ASm_7RpDMgqSRjFcPNrFIgkurQ%3BFRkDlgMd_Dx8ASlxIq1MSgqSRjEtUSQsVlMdXg%3BFX0blgMdcJh8ASm7yRVAzAuSRjHNRtdJhtL-fA%3BFQYnlgMdE6l8ASnhc-jxzQuSRjHYDyldTQI5Pg%3BFY4XlgMdY258ASmpji-2NAqSRjHzyL3wa25jDA%3BFcoflgMd9nR8ASn3spZqMwqSRjG2IyHCv2NXDA%3BFasIlgMdspx8ASlJY-YKyQuSRjHA_BrHwRZ_kg%3BFV0klgMdoY18ASkfrv8izQuSRjFh6Gn76Fzfng&amp;aq=&amp;sll=60.180453,24.967976&amp;sspn=0.073241,0.169945&amp;mra=ls&amp;ie=UTF8&amp;t=m&amp;ll=60.187575,25.003065&amp;spn=0.04991,0.18611&amp;output=embed"></iframe><br /><small><a href="https://www.google.com/maps?f=d&amp;source=embed&amp;saddr=Klaavuntie+11,+Helsinki&amp;daddr=Mannerheimintie+55,+Helsinki+to:Museokatu+10,+Helsinki+to:Santakatu+2,+Helsinki+to:Keskuskatu+4+,+Helsinki+to:Vilhonkatu+4,+Helsinki+to:Fredrikinkatu+63,+Helsinki+to:Olavinkatu+2,+Helsinki+to:Iso+Roobertinkatu+1,+Helsinki+to:Elielinaukio+2,+Helsinki&amp;hl=en&amp;geocode=FWfFlgMduO5-ASm1KQ0VLw-SRjEk2omycmpR3w%3BFahtlgMdNTB8ASlz--mLIAqSRjFGbW71WZEQTQ%3BFdAulgMdpG18ASm_7RpDMgqSRjFcPNrFIgkurQ%3BFRkDlgMd_Dx8ASlxIq1MSgqSRjEtUSQsVlMdXg%3BFX0blgMdcJh8ASm7yRVAzAuSRjHNRtdJhtL-fA%3BFQYnlgMdE6l8ASnhc-jxzQuSRjHYDyldTQI5Pg%3BFY4XlgMdY258ASmpji-2NAqSRjHzyL3wa25jDA%3BFcoflgMd9nR8ASn3spZqMwqSRjG2IyHCv2NXDA%3BFasIlgMdspx8ASlJY-YKyQuSRjHA_BrHwRZ_kg%3BFV0klgMdoY18ASkfrv8izQuSRjFh6Gn76Fzfng&amp;aq=&amp;sll=60.180453,24.967976&amp;sspn=0.073241,0.169945&amp;mra=ls&amp;ie=UTF8&amp;t=m&amp;ll=60.187575,25.003065&amp;spn=0.04991,0.18611" style="color:#0000FF;text-align:left">View Larger Map</a></small>
    </div>
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
