var canvas = document.getElementById("gameCanvas");
var ctx = canvas.getContext("2d");
var timeatstart = new Date();

var background = new Image();
background.src = "https://www.maketecheasier.com/assets/uploads/2018/08/set-bing-daily-wallpaper-as-background-windows-10-header.jpg";

// Make sure the image is loaded first otherwise nothing will draw.
var xfolder = 0;
var yfolder = 0;

var workfolder = new Image();
workfolder.src = "https://whateverbrightthings.com/wp-content/uploads/2017/10/Work-Folder.png";
var actualvalue = 1;
workfolder.onload = function() {

  updateImages();
}

function updateImages() {
  if (xfolder > canvas.width) {
    var timeatend = new Date();
    var diff = timeatend - timeatstart;
    console.log(diff / (1000));
    window.stop();

  }
  ctx.drawImage(background, 0, 0);
  ctx.drawImage(workfolder, xfolder, yfolder, 50, 50);
}

function getMousePos(canvas, evt, actualvalue) {
  xfolder += actualvalue;
  updateImages();
  console.log("xfolder = ", xfolder);
  var rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  };
}
var canvas = document.getElementById('gameCanvas');

canvas.addEventListener('mousemove', function(evt) {
  var mousePos = getMousePos(canvas, evt, actualvalue);
  var message = 'Mouse position: ' + mousePos.x + ',' + mousePos.y;

}, false);