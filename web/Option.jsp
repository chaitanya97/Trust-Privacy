<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Text ENCRYPT</a></li>
        <li class="tab"><a href="#login">File ENCRYPT</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Write Text</h1>
          
          <form action="TextAES" method="get">
          
          <div class="field-wrap">
            <input type="text" name="text">
          </div>
          
          <button type="submit" class="button button-block"/>ENCRYPT</button>
          
          </form>

        </div>
         <div id="login">   
          <h1>Upload a File</h1>
          
          <form action="#" method="post">
          
            <div class="field-wrap">
            <input type="file" name="fileToUpload" id="fileToUpload">
          </div>
          
          
          
        
          
          <button class="button button-block"/>ENCRYPT</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>




</body>

</html>
