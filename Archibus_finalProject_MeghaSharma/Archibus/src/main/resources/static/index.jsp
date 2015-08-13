<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download Page</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data"
		action="/upload">
		File to upload: <input type="file" name="file"><br /> Name: <input
			type="text" name="name"><br /> <br /> <input type="submit"
			value="Upload"> Press here to upload the file!
	</form>
	<center>
        <h2><a href="/download/testFile1.txt">Click here to download file</a></h2>
    </center>
	<div>
	<%="Helloooo Worlddddd"%>
	</div>
</body>
</html>