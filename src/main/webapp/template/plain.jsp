<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1"/>
		<title><decorator:title /></title>	
		
		<meta name="description" content="MakersWeb Description"/>
        <meta name="robots" content="index, follow"/>
        
        <link rel="shortcut icon" href="../_cdn/_img/favicon.png"/>
        <link href='https://fonts.googleapis.com/css?family=Open Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
        <style>*, *:after, *:before{font-family: 'Open Sans', sans-serif;}</style>
        
        <link rel="stylesheet" href="../_cdn/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../_cdn/css/makersweb.css"/>	
	</head>
	<body>
	
		<decorator:body />
	
	</body>
</html>