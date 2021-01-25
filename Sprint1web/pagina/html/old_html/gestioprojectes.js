function data_davui() {
  avui = new Date();
  var dd = avui.getDate();
  var mm = avui.getMonth() + 1; //Perque Gener es 0.
  var yyyy = avui.getFullYear();
  //utilitzar operadors          linea 92

  //parse int/string/float       line 30
  //operacio ternaria           line 94
  //random() math               line 30
  //expresión regular            line 15
  return (`Data:${mm}/${dd}/${yyyy}`);
}

function compruebaEmail() {
  var tuEmail = document.getElementById('email').value;
  patro = /^[\w]+@{1}[\w]+\.+[a-z]{2,3}$/
  resposta = patro.test(tuEmail)
  if (resposta) {
    alert("email correcte");
  } else {
    alert("email incorrecte");
  }

}

//  output = `I like the song "${ song }".
// I gave it a score of ${ score/highestScore * 100 }%.`;  linea 26

// Retorna un enter aleatori entre min (incluit) y max (excluit)
function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}

function changeData(id) {
  var arrayData = [
    [
      "projecte colegi",
      "descripcio rara",
      "Alfredo"
    ],
    [
      "projecte insitut",
      "descripcio normal",
      "Roberto"
    ],
    [
      "projecte metge",
      "descripcio bona",
      "Marko"
    ],
    [
      "projecte Educacio",
      "descripcio mala",
      "KIKI"
    ],
    [
      "projecte XDXDX",
      "descripcio mesomenos",
      "Ricki"
    ],
    [
      "projecte prova1",
      "descripcio prova",
      "Provero"
    ],
    [
      "projecte Nosekeponer",
      "descripcio normallele",
      "Tahar"
    ],
    [
      "projecte KUKF",
      "descripcio skrr",
      "SIXNINE"
    ],
    [
      "projecte colegi",
      "descripcio rara",
      "Alfredo"
    ]
  ];

  // alertaGuardarCanvis();
  for (var i = 1; i < 8; i++) {
    switch (id) {
      case ("projecte" + id.substring(8)):
        canviarHtml();
        break;
    }
  }

  function stringData(datastring) {
    var array = datastring.split(".");
    var data = new Date(parseInt(array[2]), parseInt(array[1]), parseInt(array[0]));
    return data;

  }

  function canviarHtml() {
    var hello = () => "hora";
    var data;
    if (hello() === "hora") {
      data = hello();
    } else {
      data = `${hello} incorrecta`
    };

    var status = (hello() === "hora") ? data = hello() : data = `${hello} incorrecta`;
    //Alternativa arrow-functions
    document.getElementById('projectnametitol').innerHTML = arrayData[id.substring(8)][0];
    document.getElementById('projectname').value = arrayData[id.substring(8)][0];
    document.getElementById('description').value = arrayData[id.substring(8)][1];
    document.getElementById('responsable').value = arrayData[id.substring(8)][2];
    document.getElementById(data).innerHTML = data_davui();
    document.getElementById('dataintroduida').value = stringData(document.getElementById('dataintroduida').value);
  }
}