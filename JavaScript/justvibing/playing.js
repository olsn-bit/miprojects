hello = document.getElementById("content");
var i = 0;
while (i != 100) {
  setTimeout(function() {
    hello.innerHTML = i;
    i++;
  }, 2000);
  // hello.innerHTML = i;
}
// x.innerHTML = "DFD";