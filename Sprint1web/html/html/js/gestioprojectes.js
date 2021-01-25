

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

  alertaGuardarCanvis();
  for (var i = 1; i < 8; i++) {
    switch (id) {
      case ("projecte" + id.substring(8)):
        canviarHtml();
        break;
    }
  }

  function canviarHtml() {
    document.getElementById('projectnametitol').innerHTML = arrayData[id.substring(8)][0];
    document.getElementById('projectname').value = arrayData[id.substring(8)][0];
    document.getElementById('description').value = arrayData[id.substring(8)][1];
    document.getElementById('responsable').value = arrayData[id.substring(8)][2];
  }
}