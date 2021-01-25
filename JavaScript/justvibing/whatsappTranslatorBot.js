// var rotation = 0;
// while (rotation < 20){
var y = document.getElementsByClassName("_1VzZY selectable-text");
for (var i = 0; i < y.length; i++) {
  var x = y[i].getElementsByTagName("span");
  for (var j = 0; j < x.length; j++) {
    if (x[j].innerHTML.includes("!translate")) {
      console.log(x[j]);
      // var usr = document.getElementsByClassName("Srlyw")[0];
      // console.log(usr);
      // var input = document.getElementsByClassName("_1awRl");
      // for (var i = 0; i < input.length; i++) {
      //   if (input[i].innerHTML.includes("Translation")) {
      //     input[i].innerHTML += " la traduccio funcina";
      //     // console.log("safet");
      //     // document.getElementsByClassName("_2Ujuu")[0].click();
      //
      //   }
      // }
    }
  }
}
// rotation++;
// }