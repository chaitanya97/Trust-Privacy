<!DOCTYPE html>
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
        <li class="tab active"><a href="#signup">Text DECRYPT</a></li>
        <li class="tab"><a href="#login">File DECRYPT</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Write Text to Decrypt</h1>
          
          <form action="TextD" method="get">
          
          <div class="field-wrap">
            <input type="text" name="text">
          </div>
          
          <button type="submit" class="button button-block"/>DECRYPT</button>
          
          </form>

        </div>
         <div id="login">   
          <h1>File Name To Decrypt</h1>
          
          <form action="FileDecrypt" method="post" enctype="multipart/form-data">
          
            <div class="field-wrap">
                <label>
              File Name<span class="req">*</span>
            </label>
            <input type="text" name="FileName" id="FileName">
          </div>
          <div class="field-wrap">
              <label>
              Key to Decrypt<span class="req">*</span>
            </label>
            <input type="Text" name="Key" id="fileToUpload">
          </div>
          
          
        
          
          <button class="button button-block"/>DECRYPT</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>




</body>

</html>
