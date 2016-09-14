<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <script src="jquery-3.1.0.min.js" type="text/javascript">
    </script>
</head>
<body>

	<span id="temperature">${temp}</span>
    <script type="text/javascript">
    function get_temperature(){
        setInterval(function()
        {
            $.ajax({
              type:"get",
              url:"/temperature",
              datatype:"application/json",
              success:function(data)
              {
                $("#temperature").text(data);
              }
            });
        }, 5000);
    }
    $(document).ready(function(){
       new get_temperature();
     });

    </script>
</body>
</html>