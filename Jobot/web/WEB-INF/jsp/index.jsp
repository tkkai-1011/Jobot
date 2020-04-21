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
    <!-- Right-sided navbar links -->
<!--    <div class="w3-right w3-hide-small">
      <a href="#search" class="w3-bar-item w3-button"></i>Search</a>
    </div>-->
    <!-- Hide right-floated links on small screens and replace them with a menu icon -->

    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</div>

<!-- Sidebar on small screens when clicking the menu icon -->
<!--<nav class="w3-sidebar w3-bar-block w3-black w3-card w3-animate-left w3-hide-medium w3-hide-large" style="display:none" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a>
  <a href="#search" onclick="w3_close()" class="w3-bar-item w3-button">SEARCH</a>
</nav>-->

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
  <div class="w3-display-left w3-text-white" style="padding:48px">
    <span class="w3-jumbo w3-hide-small">Jobot</span><br>
    <span class="w3-xxlarge w3-hide-large w3-hide-medium"></span><br>
    <span class="w3-large">Your Most Reliable Job Search Robot!</span>
    <p><a href="#search" class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Let's start!</a></p>
  </div> 
</header>



<!-- Contact Section -->
<div class="w3-container w3-light-grey" style="padding:128px 16px" id="search">
  <h3 class="w3-center">User Loggin</h3>
<!--  <p class="w3-center w3-large">User Loggin:</p>-->
  <div style="margin-top:48px">
    <form action="main.htm" method='post'>
      <p><input class="w3-input w3-border" type="text" placeholder="Username" required name="username"></p>
      <p><input class="w3-input w3-border" type="password" placeholder="Password" required name="password"></p>
      <p>
        <button class="w3-button w3-black" type="submit">
          <i class="fa fa-paper-plane"></i> Login
        </button>
      </p>
    </form>
      
      <form action="redirect.htm" method='post'>
        <button class="w3-button w3-black" type="submit">
          <i class="fa fa-paper-plane"></i> Create a new account!
        </button>
      </p>
    </form>
  </div>
</div>

<!-- Footer -->
<footer class="w3-center w3-black w3-padding-64">
  <a href="#home" class="w3-button w3-light-grey"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
</footer>
 
<script>
// Modal Image Gallery

function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}


// Toggle between showing and hiding the sidebar when clicking the menu icon
var mySidebar = document.getElementById("mySidebar");

function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
  } else {
    mySidebar.style.display = 'block';
  }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
}
</script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</body>
</html>
