
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat WebSocket</title>
</head>
<body>
    <form>
        <input id="message" type="text">
        <input onclick="wsSendMessage();" value="Echo" type="button">
        <input onclick="wsCloseConnection();" value="Disconnect" type="button">
    </form>
    <br>
    <textarea id="echoText" rows="10" cols="80"></textarea>
    <script type="text/javascript">
        var webSocket = new WebSocket("ws://localhost:8080/test/websocketendpoint");
        var echoText = document.getElementById("echoText");
        echoText.value = "";
        var message = document.getElementById("message");
        webSocket.onopen = function(message){ wsOpen(message);};
        webSocket.onmessage = function(message){ wsGetMessage(message);};
        webSocket.onclose = function(message){ wsClose(message);};
        webSocket.onerror = function(message){ wsError(message);};
        function wsOpen(message){
            echoText.value += "Connected ... \n";
        }
        function wsSendMessage(){
            webSocket.send(message.value);
            echoText.value += "Message sent to the server : " + message.value + "\n";
            message.value = "";
        }
        function wsCloseConnection(){
            webSocket.close();
        }
        function wsGetMessage(message){
            if(message.data == "JSON syntax exception occurred."){
                echoText.value += "Server responded: " + message.data + "\n";
            }else{
                var object = JSON.parse(message.data);
                echoText.value += "Server responded: \n"
                    + "\tname:       " + object.name + "\n"
                    + "\toccupation: " + object.occupation + "\n"
                    + "\tresponse:   " + object.response + "\n";
            }
        }
        function wsClose(message){
            echoText.value += "Disconnect ... \n";
        }

        function wsError(message){
            echoText.value += "Error ... \n";
        }
    </script>
</body>
</html>