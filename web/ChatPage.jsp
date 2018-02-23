<%-- 
    Document   : ChatPage
    Created on : Feb 23, 2018, 3:39:25 PM
    Author     : M.Gebaly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="messageHndling.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body onload="myFunction()">
        <div class="container">
            <div class="row">
                <div class="col-xl-">
                    <div class="alert alert-primary" role="alert">
                        WELCOME
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-8">
                    <div class="row">
                        <div class="col-8">
                            <input type="text" class="form-control" id="msg_txt" placeholder="Enter Your Message" name="msg_txt"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-8">
                            <div id="messages"></div>
                            
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div id="users"></div>
                </div>
            </div>
        </div>
        
    </body>
</html>
