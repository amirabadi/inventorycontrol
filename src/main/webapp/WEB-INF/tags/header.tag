<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <sec:csrfMetaTags />
    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <!-- Bootstrap Core CSS -->
    <link href='/inventorycontrol/themesite/rtl/bootstrap.min.css' rel="stylesheet" type="text/css">
    <link href="/inventorycontrol/themesite/rtl/bootstrap.min.css" rel="stylesheet">

    <!-- not use this in ltr -->
    <link href="/inventorycontrol/themesite/rtl/bootstrap.rtl.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/inventorycontrol/themesite/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="/inventorycontrol/themesite/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/inventorycontrol/themesite/rtl/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/inventorycontrol/themesite/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/inventorycontrol/themesite/font-awesome/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/inventorycontrol/themesite/public.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery Version 1.11.0 -->
    <script src="/inventorycontrol/themesite/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/inventorycontrol/themesite/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/inventorycontrol/themesite/js/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/inventorycontrol/themesite/js/raphael/raphael.min.js"></script>
    <script src="/inventorycontrol/themesite/js/morris/morris.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/inventorycontrol/themesite/js/sb-admin-2.js"></script>
    <link href="/inventorycontrol/resources/styles/kendo.common.min.css" rel="stylesheet"
          type="text/css" />
    <link href="/inventorycontrol/resources/styles/kendo.blueopal.min.css" rel="stylesheet"
          type="text/css" />
    <link href="/inventorycontrol/resources/styles/kendo.rtl.min.css" rel="stylesheet"
          type="text/css" />
    <script src="/inventorycontrol/resources/js/kendo.all.min.js"></script>
    <script type="application/javascript">
        $(function () {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $(document).ajaxSend(function(e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
        });
    </script>
</head>
<body>