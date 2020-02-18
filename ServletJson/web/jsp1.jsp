<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Algorithm compare</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="jsonjs.js"></script>

    </head>

    <body onload ="init();">
        <h1>Hello ! jsp 1</h1>  
        <progress id="progressStep" value="1"  max="100" > 0 </progress>
        <p>Step</p>
        <input id="slideStep" type="range" oninput="chooseStep();" max="0" min="0" value="1">
        <div id="txtStepcount" style="float: contour"></div>
        <input type="submit" onclick=" init();" value="Restart" />    
        <input id="PauseOrCon" type="submit" onclick="resume();" value="Pause" />
        <input id="btnPrev" type="submit" onclick="back();" value="<" />
        <input id="btnNext" type="submit" onclick="next();" value=">" />
        <input id="txtElement" onkeydown="isNumberKey(event);" type="text" name="name" value="" />
        <input type="submit" onclick="inputByUser();" value="Nhập data" />
        <input id="btnShuffle" type="submit" onclick="shuffle();" value="Shuffle" />
        <canvas id="canvas" width="700" height="50" style="border:1px solid #000000;"></canvas>
         <canvas id="canvas2" width="35" height="230"  style="border:2px solid #000000;"></canvas>
        <p>Speed</p>
        <input id="rangebar" type="range" oninput="changeSpeed();" max="2000" min="100" value="1000">    
        <script type="text/javascript" src="jsonjs.js"></script>
        
        <%-- <%@include file="./jsp2.jsp"%>--%>

        <%--<jsp:include page="./jsp2.jsp" />--%>

    </body>      

</html>
