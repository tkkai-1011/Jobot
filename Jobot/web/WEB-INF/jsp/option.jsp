<!DOCTYPE html>
<html>
<title>Jobot</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}

body, html {
  height: 100%;
  line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("https://www.glassdoor.com/blog/app/uploads/sites/2/iStock-504243026-e1514926306494-1024x450.jpg");
  min-height: 100%;
}

.w3-bar .w3-button {
  padding: 16px;
}
</style>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">
    <a href="#home" class="fas fa-robot" style='font-size:48px;'>Jobot</a>

    <!-- Hide right-floated links on small screens and replace them with a menu icon -->

    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</div>
<!-- Contact Section -->
<div class="w3-container w3-light-grey" style="padding:128px 16px" id="search">
    <br><br><br><br><br>
    <br><br><br><br><br>
    
  <form action="file.htm" method='post'>
      <h3 class="w3-center">Upload your resume to let me know you better</h3>
        <p><input class="w3-input w3-border" id='in' type="text" placeholder="Paste your resume here" required name="resume"></p>
      <button class="w3-button w3-black" type="submit">
          
          <i class="fa fa-paper-plane"></i> Let's see what we have!
        
      </button>
      </p>
    </form>
  <h3 class="w3-center">Start your Search !</h3>
  
  <div style="margin-top:48px">
    <form action="search.htm" method='post'>
      <p><input class="w3-input w3-border" type="text" placeholder="language: java, python, C++" required name="jobSpecification"></p>
        <button class="w3-button w3-black" type="submit">
          <i class="fa fa-paper-plane"></i> Let's see what we have!
        </button>
      </p>
    </form>
  </div>
  
</div>

<!-- Footer -->
<footer class="w3-center w3-black w3-padding-64">
</footer>
 

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</body>
</html>
